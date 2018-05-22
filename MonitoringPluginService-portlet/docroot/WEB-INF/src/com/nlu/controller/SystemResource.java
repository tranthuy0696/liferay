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
import com.nlu.entity.model.Ram;
import com.nlu.entity.service.CpuLocalServiceUtil;
import com.nlu.entity.service.RamLocalServiceUtil;
import com.nlu.util.GetApi;
import com.nlu.util.ScheduleSystemResource;
import com.nlu.util.SystemUtil;

/**
 * Portlet implementation class SystemResource
 */
public class SystemResource extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class.getName());

	@Override
	public void init() throws PortletException {
		_log.info(" This is init method without parameter");
		ScheduleSystemResource.start();
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
			try {
				_log.info(SystemUtil.getCpuUsed(session));
				p.write((int) SystemUtil.getCpuUsed(session) + "");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		PortletSession session = request.getPortletSession();
		_log.info(GetApi.getApi(session, ""));
		CpuLocalServiceUtil.findAll();
		for (Cpu string : CpuLocalServiceUtil.findAll()) {
			_log.info(string);
		}

	}

	public void getApi(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		PortletSession session = request.getPortletSession();
		_log.info(SystemUtil.getCpuUsed(session));
		SystemUtil.getInfoSession(session);
	}

	public void destroy() {
		ScheduleSystemResource.deptroy();
		_log.info("deptroy");
	}

}
