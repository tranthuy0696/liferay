package com.nlu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.entity.model.Alarm;
import com.nlu.entity.service.AlarmInfoLocalServiceUtil;
import com.nlu.entity.service.AlarmLocalServiceUtil;
import com.nlu.model.AlarmName;
import com.nlu.service.JvmService;

/**
 * Portlet implementation class Alarm
 */
public class AlarmController extends MVCPortlet { 
	private static final Log _log = LogFactoryUtil.getLog(AlarmController.class.getName());

	@Override
	public void init() throws PortletException {

		super.init();
	}

	public void saveAlarm(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		JvmService.restartTomcat();
		
//		 AlarmLocalServiceUtil.deleteAll();
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Ram.name(), 1, 10, 7, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Ram.name(), 10, 19, 7, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Ram.name(), 19, 24, 7, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Cpu.name(), 1, 10, 90, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Cpu.name(), 10, 19, 90, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Cpu.name(), 19, 24, 90, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Heap.name(), 1, 10, 1500, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Heap.name(), 10, 19, 1500, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.Heap.name(), 19, 24, 1500, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.NonHeap.name(), 1, 10, 520, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.NonHeap.name(), 10, 19, 520, new
//		 ServiceContext());
//		 AlarmLocalServiceUtil.addAlarm(AlarmName.NonHeap.name(), 19, 24, 520, new
//		 ServiceContext());//
		 //System.out.println(AlarmLocalServiceUtil.getAlarmByTime(12, AlarmName.Ram.name()).getValue());
		 
		

	}

	public void saveInfo(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		Long ram = ParamUtil.getLong(request, "ram");
		String mailRam = ParamUtil.getString(request, "mailRam");
		Long cpu = ParamUtil.getLong(request, "cpu");
		String mailCpu = ParamUtil.getString(request, "mailCpu");
		Long nonHeap = ParamUtil.getLong(request, "nonHeap");
		String mailNonHeap = ParamUtil.getString(request, "mailNonHeap");
		Long heap = ParamUtil.getLong(request, "heap");
		String mailHeap = ParamUtil.getString(request, "mailHeap");
		if (ram != 0) {
			AlarmInfoLocalServiceUtil.updateAlarmInfo(ram, "ram", mailRam, new ServiceContext());
		} else {
			AlarmInfoLocalServiceUtil.addAlarmInfo("ram", mailRam, new ServiceContext());
		}

		if (cpu != 0) {
			AlarmInfoLocalServiceUtil.updateAlarmInfo(cpu, "cpu", mailCpu, new ServiceContext());
		} else {
			AlarmInfoLocalServiceUtil.addAlarmInfo("cpu", mailCpu, new ServiceContext());
		}

		if (heap != 0) {
			AlarmInfoLocalServiceUtil.updateAlarmInfo(heap, "heap", mailHeap, new ServiceContext());
		} else {
			AlarmInfoLocalServiceUtil.addAlarmInfo("heap", mailHeap, new ServiceContext());
		}

		if (nonHeap != 0) {
			AlarmInfoLocalServiceUtil.updateAlarmInfo(nonHeap, "nonHeap", mailNonHeap, new ServiceContext());
		} else {
			AlarmInfoLocalServiceUtil.addAlarmInfo("nonHeap", mailNonHeap, new ServiceContext());
		}

	}
}
