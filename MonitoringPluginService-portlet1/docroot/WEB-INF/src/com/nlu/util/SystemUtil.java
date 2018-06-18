package com.nlu.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.NetStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nlu.controller.SystemResource;
import com.nlu.model.SessionUser;
import com.sun.management.OperatingSystemMXBean;

public class SystemUtil {
	static OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory
			.getOperatingSystemMXBean();
	static MemoryMXBean jvm = ManagementFactory.getMemoryMXBean();
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class
			.getName());

	public static double getMemoryFree() {
		return os.getFreePhysicalMemorySize();
	}

	public static double getMaxMemory() {
		return os.getTotalPhysicalMemorySize();
	}

	public static double convertByteToGB(double bytes) {
		double gb = (double) bytes / (1024 * 1024 * 1024) * 100;
		gb = Math.round(gb);
		return gb / 100;
	}
	public static double convertByteToMB(double bytes) {
		double mb = (double) bytes / (1024 * 1024);
		mb = Math.round(mb);
		return mb;
	}

	public static double usage(double free, double total) {
		return total - free;
	}

	public static double getCpuFree() {
		double cpu = os.getSystemCpuLoad();
		return cpu;
	}

	public static double getCpuUsed() {

		// String value = GetApi.getApi("&part=lastValue&graph=systemCpuLoad");
		// JSONObject myObject = JSONFactoryUtil.createJSONObject(value);
		// return myObject.getDouble("double");
		Sigar sigar = new Sigar();
		CpuPerc cputimer = null;
		try {
			cputimer = sigar.getCpuPerc();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double result = cputimer.getCombined() * 10000;
		result = Math.round(result);
		return result / 100;

	}

	public static double getNumberCurrentSession() throws IOException,
			JSONException {
		String value = GetApi.getApi("&part=lastValue&graph=httpSessions");
		System.out.println(value);
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);
		return myObject.getDouble("double");

	}

	public static List<SessionUser> getInfoSession() throws IOException,
			JSONException {
		String value = GetApi.getApi("&part=sessions");
		List<SessionUser> result = new ArrayList<>();
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);

		JSONArray list = myObject.getJSONArray("list");
		for (int i = 0; i < list.length(); i++) {
			JSONObject element = list.getJSONObject(i);
			SessionUser user = new SessionUser(element.getString("id"),
					element.getString("remoteAddr"));
			user.parseSessionAgent(element.getString("userAgent"));
			user.setLogin(element.getString("remoteUser").equals("20200"));
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
		MemoryUsage nonHeap = jvm.getNonHeapMemoryUsage();

		return nonHeap.getMax();
	}

	private static Sigar sigar = new Sigar();

	public static void main(String[] args) throws Exception {

		// For Disk
		// System.out.println("-----Disk Info-----");
		// FileSystem fileSystemList[] = sigar.getFileSystemList();
		// for (int f = 0; f < fileSystemList.length; f++) {
		// String devName = fileSystemList[f].getDevName();
		// int devType = fileSystemList[f].getType();
		// // Only get the physical disk
		// if (devType == FileSystem.TYPE_LOCAL_DISK) {
		// System.out.println("Disk " + devName);
		// System.out.println(sigar.getDirUsage(devName));
		// System.out.println(sigar.getDiskUsage(devName));
		// System.out.println(sigar.getFileSystemUsage(devName));
		// }
		// }
		//
		// // For CPU
		// System.out.println("-----CPU Info-----");
		// System.out.println(sigar.getCpuPerc());
		// System.out.println(sigar.getCpu());
		// CpuInfo cpuInfoList[] = sigar.getCpuInfoList();
		// Cpu cpuList[] = sigar.getCpuList();
		// for (int c = 0; c < cpuInfoList.length; c++) {
		// System.out.println("CPU " + c);
		// System.out.println(cpuInfoList[c].toString());
		// System.out.println(cpuList[c].toString());
		// }
		//
		// // For Memory
		// System.out.println("-----Memory Info-----");
		// System.out.println(sigar.getMem());
		//
		// // For Network
		// System.out.println("-----Network Info-----");
		// System.out.println(sigar.getNetInfo());
		// NetStat thisNetState = sigar.getNetStat();
		// System.out.println(
		// "in-bound " + thisNetState.getAllInboundTotal() + " out-bound " +
		// thisNetState.getAllOutboundTotal());
		OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory
				.getOperatingSystemMXBean();
		long physicalMemorySize = os.getTotalPhysicalMemorySize();
		long freePhysicalMemory = os.getFreePhysicalMemorySize();
		double maxMemory = (double) physicalMemorySize / (1024 * 1024 * 1000)
				* 100;
		maxMemory = Math.round(maxMemory);
		maxMemory = maxMemory / 100;
	}

}
