package com.monitor.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.monitor.portlet.entity.service.FooLocalServiceUtil;
import com.monitoring.Monitoring;

/**
 * Portlet implementation class monitorAction
 */
public class monitorAction extends MVCPortlet {
	com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) ManagementFactory
			.getOperatingSystemMXBean();

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException {
		PrintWriter p = response.getWriter();
		String id = request.getResourceID();
		if (id.equals("memory")) {
			p.write((100 - (int) getMemoryFree()) + "");
			p.close();
		}
	}

	public double getMemoryFree() {
		long physicalMemorySize = os.getTotalPhysicalMemorySize();
		long freePhysicalMemory = os.getFreePhysicalMemorySize();
		double free = (double) freePhysicalMemory / physicalMemorySize;
		free = free * 100;
		free = Math.round(free);
		free = free / 100;
		return free * 100;
	}
	public double getCpuFree(){
		double cpu = os.getSystemCpuLoad();
		return cpu;
	}
	public static void main(String[] args) {
		monitorAction m=new monitorAction();
		System.out.println(m.getCpuFree());
	}

}
