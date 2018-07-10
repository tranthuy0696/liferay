package com.nlu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;
import org.hyperic.sigar.SigarException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.Heap;
import com.nlu.entity.model.NonHeap;
import com.nlu.entity.model.Ram;
import com.nlu.entity.model.SessionRequest;
import com.nlu.entity.service.CpuLocalServiceUtil;
import com.nlu.entity.service.HeapLocalServiceUtil;
import com.nlu.entity.service.NonHeapLocalServiceUtil;
import com.nlu.entity.service.RamLocalServiceUtil;
import com.nlu.entity.service.SessionRequestLocalServiceUtil;
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
import com.nlu.service.MonitorDirectory;
import com.nlu.service.RealtimeService;
import com.nlu.service.ReportService;
import com.nlu.util.SystemUtil;

/**
 * Portlet implementation class SystemResource
 */
public class SystemResource extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class
			.getName());
	ScheduleCreate schedule = new ScheduleCreate();
	ScheduleSessionInit ses = new ScheduleSessionInit();

	@Override
	public void init() throws PortletException {
		_log.info(" This is init method without parameter");
		schedule.init();
		ses.init();
		super.init();
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter p = response.getWriter();
		String id = request.getResourceID();
		PortletSession session = request.getPortletSession();
		RealtimeService realtimeService = new RealtimeService();
		ReportService reportService = new ReportService();
		DirectoryService directoryService = new DirectoryService();
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
			_log.info("HEAP");
			_log.info(SystemUtil.getMaxHeapMemory());
			DataResponse heap = realtimeService.getHeapRealtime();
			p.write(om.writeValueAsString(heap));
			p.close();
			break;
		case "nonheap":
			_log.info("Non HEAP");
			_log.info(SystemUtil.getNonHeapMemoryUsed());
			DataResponse nonHeapDataResponse = realtimeService
					.getNonHeapRealtime();
			p.write(om.writeValueAsString(nonHeapDataResponse));
			p.close();
			break;
		case "sessionrequest":
			try {
				SessionResponse sessionResponse = realtimeService
						.getSessionUserRealtime();
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
			try {
				String dateType = request.getParameter("dateType");
				Report memoryReport = reportService.getRamReportInfo(dateType);
				p.write(om.writeValueAsString(memoryReport));
			} catch (ParseException e) {
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "re":
			try {
				List<DataReport> rs = reportService.getInfoRamToReport();
				p.write(om.writeValueAsString(rs));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "reportCPU":
			try {
				List<DataReport> rs = reportService.getInfoCpuToReport();
				p.write(om.writeValueAsString(rs));
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;

		case "heapReport":
			try {
				List<DataReport> rs = reportService.getInfoHeapToReport();
				p.write(om.writeValueAsString(rs));
			} catch (SystemException e) {
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "nonheapReport":
			try {
				List<DataReport> rs = reportService.getInfoNonHeapToReport();
				p.write(om.writeValueAsString(rs));
			} catch (SystemException e) {
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "networkReport":
			try {
				List<NetworkReport> rs = reportService.getInfoNetworkToReport();
				p.write(om.writeValueAsString(rs));
			} catch (SystemException e) {
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		case "sessionRequestReport":
			String dateType = request.getParameter("dateType");
			System.out.println(dateType);
			try {
				SessionReport rs = reportService
						.getInfoSessionReportByDate(dateType);
				System.out.println("size" + rs.getListBrowser().size());
				p.write(om.writeValueAsString(rs));
			} catch (JSONException e) {
				e.printStackTrace();
			} finally {
				p.close();
			}
			break;
		default:
			break;
		}

	}

	public void getAllRam(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException,
			SystemException {
		RamLocalServiceUtil.findAll();
		for (Ram string : RamLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getAllCpu(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException,
			SystemException {
		CpuLocalServiceUtil.findAll();
		for (Cpu string : CpuLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getAllHeap(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException,
			SystemException {

		for (Heap string : HeapLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getAllNonHeap(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException,
			SystemException {

		for (NonHeap string : NonHeapLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getApi(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException,
			SystemException {
		for (SessionRequest string : SessionRequestLocalServiceUtil.findAll()) {
			_log.info(string);
		}
	}

	public void destroy() {
		schedule.deptroy();
		ses.deptroy();
		_log.info("deptroy");
	}

}
