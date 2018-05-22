package com.nlu.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletSession;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nlu.SessionUser;
import com.nlu.controller.SystemResource;
import com.sun.management.OperatingSystemMXBean;

public class SystemUtil {
	static OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	static MemoryMXBean jvm = ManagementFactory.getMemoryMXBean();
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class.getName());
	public static double getMemoryFree() {
		long physicalMemorySize = os.getTotalPhysicalMemorySize();
		long freePhysicalMemory = os.getFreePhysicalMemorySize();
		double free = (double) freePhysicalMemory / physicalMemorySize;
		free = free * 100;
		free = Math.round(free);
		free = free / 100;
		return free * 100;
	}

	public static double getCpuFree() {
		double cpu = os.getSystemCpuLoad();
		return cpu;
	}

	public static double getCpuUsed(PortletSession session) throws IOException, JSONException {

		String value = GetApi.getApi(session, "&part=lastValue&graph=systemCpuLoad");
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);
		return myObject.getDouble("double");

	}
	public static double getNumberCurrentSession(PortletSession session) throws IOException, JSONException {
		String value = GetApi.getApi(session, "&part=lastValue&graph=httpSessions");
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);
		return myObject.getDouble("double");

	}
	public static List<SessionUser> getInfoSession(PortletSession session) throws IOException, JSONException {
		String value = GetApi.getApi(session, "&part=sessions");
		List<SessionUser> result = new ArrayList<>();
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);
		
		JSONArray list =  myObject.getJSONArray("list");
		for (int i = 0; i < list.length(); i++) {
			JSONObject element = list.getJSONObject(i);
			SessionUser user = new SessionUser(element.getString("id"),element.getString("remoteAddr"));
			user.parseSessionAgent(element.getString("userAgent"));
			result.add(user);
		}
		return result;
		
		

	}
	public static long getHeapMemoryUsed() {
		MemoryUsage heap = jvm.getHeapMemoryUsage();
		return heap.getUsed();
	}
	public static long getMaxHeapMemory() {
		MemoryUsage heap = jvm.getHeapMemoryUsage();
		return heap.getMax();
	}
	public static long getNonHeapMemoryUsed() {
		MemoryUsage nonHeap = jvm.getNonHeapMemoryUsage();
		return nonHeap.getUsed();
	}
	public static long getNonMaxHeapMemory() {
		MemoryUsage nonHeap = jvm.getNonHeapMemoryUsage();;
		return nonHeap.getMax();
	}
	
	
	
}
