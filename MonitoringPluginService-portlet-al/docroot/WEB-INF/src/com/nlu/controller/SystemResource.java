package com.nlu.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.SigarException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.alarm.GetInfoAlarm;
import com.nlu.alarm.SaveAlarm;
import com.nlu.model.AllReport;
import com.nlu.model.DataAlarm;
import com.nlu.model.DataPoint;
import com.nlu.model.DataPoints;
import com.nlu.model.DataReport;
import com.nlu.model.DataResponse;
import com.nlu.model.DirectoryData;
import com.nlu.model.NetworkReport;
import com.nlu.model.Report;
import com.nlu.model.SessionReport;
import com.nlu.model.SessionResponse;
import com.nlu.schedule.ScheduleCreate;
import com.nlu.schedule.session.ScheduleSessionInit;
import com.nlu.service.DirectoryService;
import com.nlu.service.GetDataService;
import com.nlu.service.MonitorDirectory;
import com.nlu.service.RealtimeService;
import com.nlu.service.ReportService;
import com.nlu.service.SaveDataService;
import com.nlu.util.FileUtil;
import com.nlu.util.SystemUtil;

/**
 * Portlet implementation class SystemResource
 */
public class SystemResource extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class
			.getName());
	ScheduleCreate schedule = new ScheduleCreate();
	ScheduleSessionInit ses = new ScheduleSessionInit();
	GetDataService getDataService=new GetDataService();
	FileUtil fileUtil=new FileUtil();

	RealtimeService realtimeService = new RealtimeService();
	DirectoryService directoryService = new DirectoryService();
	GetInfoAlarm getInfoAlarm=new GetInfoAlarm();
	SaveAlarm saveAlarm=new SaveAlarm();
	ObjectMapper om = new ObjectMapper();
	@Override
	public void init() throws PortletException {
		_log.info(" This is init method without parameter");
		schedule.init();
		ses.init();
		super.init();
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		PortletSession session = request.getPortletSession();
		PrintWriter p = response.getWriter();
		String id = request.getResourceID();
		
		switch (id) {
		case "memory":
			DataResponse memory = realtimeService.getMemoryRealtime();
			p.write(om.writeValueAsString(memory));
			p.close();
			break;
		case "cpu":

			p.write(SystemUtil.getCpuUsed() + "");

			p.close();
			break;
		case "heap":
			DataResponse heap = realtimeService.getHeapRealtime();
			p.write(om.writeValueAsString(heap));
			p.close();
			break;
		case "nonheap":
			DataResponse nonHeapDataResponse = realtimeService
					.getNonHeapRealtime();
			p.write(om.writeValueAsString(nonHeapDataResponse));
			p.close();
			break;
		case "sessionrequest":
			try {
				SessionResponse sessionResponse = realtimeService.getSessionUserRealtime();
				p.write(om.writeValueAsString(sessionResponse));
			} catch (JSONException e) {

				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "network":
			try {
				p.write(om.writeValueAsString(realtimeService
						.getNetworkRealtime()));
			} catch (SigarException e1) {
				e1.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "directory":
			DirectoryData directoryData = new DirectoryData();
			Path dir = Paths
					.get(directoryService.getPathFile());
			directoryData.setSize(Math
					.ceil((double)directoryService.getFolderSize(dir.toFile()) / 1024));
			List<String> listEvent = new ArrayList<String>();
			while (!MonitorDirectory.listEvent.isEmpty()) {
				listEvent.add(MonitorDirectory.listEvent.poll());
			}
			directoryData.setStatus(MonitorDirectory.status);
			directoryData.setEventList(listEvent);
			directoryData.setContentGUI(directoryService
					.getStructureDirectory(dir));
			p.write(om.writeValueAsString(directoryData));
			p.close();
			MonitorDirectory.status=false;
			break;
		case "memoryReport":
//			try {
//				String dateType = request.getParameter("dateType");
//				Report memoryReport = reportService.getRamReportInfo(dateType);
//				p.write(om.writeValueAsString(memoryReport));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			} finally {
//				p.close();
//			}
			break;
		case "re":
				List<DataPoint> rs = getDataService.getDataRam(fileUtil.pathFileData(FileUtil.PATH_RAM));
				p.write(om.writeValueAsString(rs));
				p.close();
			break;
		case "reportCPU":
				List<DataPoint> reCpu = getDataService.getDataCpu(fileUtil.pathFileData(FileUtil.PATH_CPU));
				p.write(om.writeValueAsString(reCpu));
				p.close();
			break;

		case "heapReport":
				List<DataPoint> reHeap = getDataService.getDataHeapAndNonHeap(fileUtil.pathFileData(FileUtil.PATH_HEAP));
				p.write(om.writeValueAsString(reHeap));
				p.close();
			break;
		case "nonheapReport":
				List<DataPoint> reNonHeap = getDataService.getDataHeapAndNonHeap(fileUtil.pathFileData(FileUtil.PATH_NONHEAP));
				p.write(om.writeValueAsString(reNonHeap));
				p.close();
			break;
		case "networkReport":
				List<DataPoints> reNetwork = getDataService.getDataNetwork(fileUtil.pathFileData(FileUtil.PATH_NETWORK));
				p.write(om.writeValueAsString(reNetwork));
				p.close();
			break;
		case "sessionRequestReport":
		    List<DataPoints> reSesionRequest = getDataService.getDataSessionRequest(fileUtil.pathFileData(FileUtil.PATH_SESSIONREQUEST));
		    p.write(om.writeValueAsString(reSesionRequest));
			p.close();
			break;
		case "allreport":
			String date = request.getParameter("date");
			AllReport allReport=getDataService.getInfoAllReport(date);
			p.write(om.writeValueAsString(allReport));
			p.close();
			break;
		case "receiveAlarm":
			List<DataAlarm> dataAlarm=getInfoAlarm.getListInfoAlarm();
			p.write(om.writeValueAsString(dataAlarm));
			p.close();
			break;
		case "resetAlarm":
			String time=request.getParameter("time");
			String name=request.getParameter("name");
			saveAlarm.resetStatusAlarm(time, name);
			break;
		default:
			break;
		}

	}

//	public void getAllRam(ActionRequest request, ActionResponse response)
//			throws IOException, PortletException, PortalException,
//			SystemException {
//		RamLocalServiceUtil.findAll();
//		for (Ram string : RamLocalServiceUtil.findAll()) {
//			_log.info(string);
//		}
//
//	}
//
//	public void getAllCpu(ActionRequest request, ActionResponse response)
//			throws IOException, PortletException, PortalException,
//			SystemException {
//		CpuLocalServiceUtil.findAll();
//		for (Cpu string : CpuLocalServiceUtil.findAll()) {
//			_log.info(string);
//		}
//
//	}
//
//	public void getAllHeap(ActionRequest request, ActionResponse response)
//			throws IOException, PortletException, PortalException,
//			SystemException {
//
//		for (Heap string : HeapLocalServiceUtil.findAll()) {
//			_log.info(string);
//		}
//
//	}
//
//	public void getAllNonHeap(ActionRequest request, ActionResponse response)
//			throws IOException, PortletException, PortalException,
//			SystemException {
//
//		for (NonHeap string : NonHeapLocalServiceUtil.findAll()) {
//			_log.info(string);
//		}
//
//	}
//
//	public void getApi(ActionRequest request, ActionResponse response)
//			throws IOException, PortletException, PortalException,
//			SystemException {
//		for (SessionRequest string : SessionRequestLocalServiceUtil.findAll()) {
//			_log.info(string);
//		}
//	}

	public void destroy() {
		schedule.deptroy();
		ses.deptroy();
		_log.info("deptroy");
	}
public static void main(String[] args) throws JsonProcessingException {
	ObjectMapper om = new ObjectMapper();
	int[][] m={{1,0},{2,4}};
	System.out.println(om.writeValueAsString(m));
	int[] dt=m[0];
	System.out.println(om.writeValueAsString(dt));
	File file=new File("C:\\Users\\thuthuy\\Desktop\\software_liferay\\sdk_server\\server\\monitor");
}
}
