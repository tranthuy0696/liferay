package com.nlu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
import com.nlu.schedule.ScheduleCreate;
import com.nlu.schedule.ScheduleExecute;
import com.nlu.schedule.session.ScheduleSessionInit;
import com.nlu.util.GetApi;
import com.nlu.util.SystemUtil;

/**
 * Portlet implementation class SystemResource
 */
public class SystemResource extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class.getName());
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
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		PrintWriter p = response.getWriter();
		String id = request.getResourceID();
		PortletSession session = request.getPortletSession();
		switch (id) {
		case "memory":
			p.write((100 - (int) SystemUtil.getMemoryFree()) + "");
			p.close();
			break;
		case "cpu":
			
			
				System.out.println(SystemUtil.getCpuUsed());
				p.write(SystemUtil.getCpuUsed() +"");
			
			
			p.close();
			break;
		case "heap":
			_log.info(SystemUtil.getHeapMemoryUsed());
			p.write(SystemUtil.getHeapMemoryUsed() + "");
			p.close();
			break;
		case "nonheap":
			_log.info("Non HEAP");
			_log.info(SystemUtil.getNonHeapMemoryUsed());
			p.write(SystemUtil.getNonHeapMemoryUsed() + "");
			p.close();
			break;

		default:
			break;
		}

	}

	public void getAllRam(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {

		RamLocalServiceUtil.findAll();
		for (Ram string : RamLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getAllCpu(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		CpuLocalServiceUtil.findAll();
		for (Cpu string : CpuLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}
	public void getAllHeap(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		
		for (Heap string : HeapLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}
	public void getAllNonHeap(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		
		for (NonHeap string : NonHeapLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getApi(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
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
