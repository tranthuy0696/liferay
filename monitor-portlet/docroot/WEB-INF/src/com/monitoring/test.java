package com.monitoring;

import java.io.File;
import java.lang.management.ManagementFactory;

public class test {

	public static void main(String[] args) {
		/* Total number of processors or cores available to the JVM */
		System.out.println("Available processors (cores): "
				+ Runtime.getRuntime().availableProcessors());

		/* Total amount of free memory available to the JVM */
		System.out.println("Free memory (bytes): "
				+ Runtime.getRuntime().freeMemory());

		/* This will return Long.MAX_VALUE if there is no preset limit */
		long maxMemory = Runtime.getRuntime().maxMemory();
		/* Maximum amount of memory the JVM will attempt to use */
		System.out.println("Maximum memory (bytes): "
				+ (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

		/* Total memory currently available to the JVM */
		System.out.println("Total memory available to JVM (bytes): "
				+ Runtime.getRuntime().totalMemory());

		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();

		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.out.println("File system root: " + root.getAbsolutePath());
			System.out.println("Total space (bytes): " + root.getTotalSpace());
			System.out.println("Free space (bytes): " + root.getFreeSpace());
			System.out
					.println("Usable space (bytes): " + root.getUsableSpace());

		}
		  com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

		    long physicalMemorySize = os.getTotalPhysicalMemorySize();
		    long freePhysicalMemory = os.getFreePhysicalMemorySize();
		    System.out.println(physicalMemorySize);
		    System.out.println(freePhysicalMemory);
		    double free=(double)freePhysicalMemory/physicalMemorySize;
		    free=free*100;
		    free=Math.round(free);
		    free=free/100;
		    System.out.println(free);
	}
}
