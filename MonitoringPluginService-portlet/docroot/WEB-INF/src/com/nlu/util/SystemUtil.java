package com.nlu.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
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
		return cputimer.getCombined() * 100;

	}

	public static double getNumberCurrentSession() throws IOException, JSONException {
		String value = GetApi.getApi("&part=lastValue&graph=httpSessions");
		System.out.println(value);
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);
		return myObject.getDouble("double");

	}

	public static List<SessionUser> getInfoSession() throws IOException, JSONException {
		String value = GetApi.getApi("&part=sessions");
		List<SessionUser> result = new ArrayList<>();
		JSONObject myObject = JSONFactoryUtil.createJSONObject(value);

		JSONArray list = myObject.getJSONArray("list");
		for (int i = 0; i < list.length(); i++) {
			JSONObject element = list.getJSONObject(i);
			SessionUser user = new SessionUser(element.getString("id"), element.getString("remoteAddr"));
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
//		System.out.println("-----Disk Info-----");
//		FileSystem fileSystemList[] = sigar.getFileSystemList();
//		for (int f = 0; f < fileSystemList.length; f++) {
//			String devName = fileSystemList[f].getDevName();
//			int devType = fileSystemList[f].getType();
//			// Only get the physical disk
//			if (devType == FileSystem.TYPE_LOCAL_DISK) {
//				System.out.println("Disk " + devName);
//				System.out.println(sigar.getDirUsage(devName));
//				System.out.println(sigar.getDiskUsage(devName));
//				System.out.println(sigar.getFileSystemUsage(devName));
//			}
//		}

		// For CPU
		System.out.println("-----CPU Info-----");
		System.out.println(sigar.getCpuPerc());
		System.out.println(sigar.getCpu());
		CpuInfo cpuInfoList[] = sigar.getCpuInfoList();
		Cpu cpuList[] = sigar.getCpuList();
		for (int c = 0; c < cpuInfoList.length; c++) {
			System.out.println("CPU " + c);
			System.out.println(cpuInfoList[c].toString());
			System.out.println(cpuList[c].toString());
		}

		// For Memory
		System.out.println("-----Memory Info-----");
		System.out.println(sigar.getMem());

		// For Network
		System.out.println("-----Network Info-----");
		System.out.println(sigar.getNetInfo());
		NetStat thisNetState = sigar.getNetStat();
		System.out.println(
				"in-bound " + thisNetState.getAllInboundTotal() + " out-bound " + thisNetState.getAllOutboundTotal());
		String[] li = sigar.getNetInterfaceList();
		for(String a :  li){
			NetInterfaceStat netSt = sigar.getNetInterfaceStat(a);
			NetInterfaceConfig c = sigar.getNetInterfaceConfig(a);
			System.err.println(a);
			System.out.println(netSt);
			System.out.println(c);
		}
		
	}

}
