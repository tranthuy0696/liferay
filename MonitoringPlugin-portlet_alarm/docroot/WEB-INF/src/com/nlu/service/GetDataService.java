package com.nlu.service;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nlu.model.AllReport;
import com.nlu.model.DataAlarm;
import com.nlu.model.DataPoint;
import com.nlu.model.DataPoints;
import com.nlu.util.FileUtil;
import com.nlu.util.SystemUtil;

public class GetDataService {
	FileUtil fileUtil = new FileUtil();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public List<DataPoint> getDataRam(String folder) throws IOException {
		List<DataPoint> result = new ArrayList<DataPoint>();
		File file = new File(folder);
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				result.add(new DataPoint(Long.parseLong(listSubContent[0]),
						SystemUtil.convertByteToGB(Double
								.parseDouble(listSubContent[1]))));

			}
		}
		return result;
	}

	public List<DataPoint> getDataCpu(String folder) throws IOException {
		List<DataPoint> result = new ArrayList<DataPoint>();
		File file = new File(folder);
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				result.add(new DataPoint(Long.parseLong(listSubContent[0]),
						Double.parseDouble(listSubContent[1])));

			}
		}
		return result;
	}

	public List<DataPoint> getDataHeapAndNonHeap(String folder)
			throws IOException {
		List<DataPoint> result = new ArrayList<DataPoint>();
		File file = new File(folder);
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				result.add(new DataPoint(Long.parseLong(listSubContent[0]),
						SystemUtil.convertByteToMB(Double
								.parseDouble(listSubContent[1]))));

			}
		}
		return result;
	}

	public List<DataPoints> getDataSessionRequest(String folder)
			throws IOException {
		List<DataPoints> result = new ArrayList<DataPoints>();
		File file = new File(folder);
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				result.add(new DataPoints(Long.parseLong(listSubContent[0]),
						Double.parseDouble(listSubContent[1]), Double
								.parseDouble(listSubContent[2])));

			}
		}
		return result;
	}

	public List<DataPoints> getDataNetwork(String folder) throws IOException {
		List<DataPoints> result = new ArrayList<DataPoints>();
		File file = new File(folder);
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				result.add(new DataPoints(Long.parseLong(listSubContent[0]),
						SystemUtil.convertByteToKB(Double
								.parseDouble(listSubContent[1])), SystemUtil
								.convertByteToKB(Double
										.parseDouble(listSubContent[2]))));

			}
		}
		return result;
	}
/**
 * select in report by date
 * @return
 */
	public List<String> getListDate() {
		File file = new File(fileUtil.pathFileData(FileUtil.PATH_RAM));
		List<String> result = new ArrayList<String>();
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			String name = f.getName();
			name = name.replace(String.format("%s.", FileUtil.PATH_RAM), "");
			name = name.replace(".txt", "");
			result.add(name);
		}
		return result;
	}

	public AllReport getInfoAllReport(String date) throws IOException {
		AllReport allReport = new AllReport();
		File fileRam = new File(fileUtil.pathFileData(FileUtil.PATH_RAM));
		final String dt = date;
		File[] fRam = getListFile(fileRam, dt);
		System.out.println(fRam.length);
		List<DataPoint> ramData = new ArrayList<DataPoint>();
		for (File f : fRam) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				ramData.add(new DataPoint(Long.parseLong(listSubContent[0]),
						SystemUtil.convertByteToGB(Double
								.parseDouble(listSubContent[1]))));

			}
		}
		allReport.setRamReport(ramData);

		File[] fCpu = getListFile(
				new File(fileUtil.pathFileData(FileUtil.PATH_CPU)), dt);
		List<DataPoint> cpuData = new ArrayList<DataPoint>();
		for (File f : fCpu) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				cpuData.add(new DataPoint(Long.parseLong(listSubContent[0]),
						Double.parseDouble(listSubContent[1])));

			}
		}
		allReport.setCpuReport(cpuData);

		File[] fHeap = getListFile(
				new File(fileUtil.pathFileData(FileUtil.PATH_HEAP)), dt);
		List<DataPoint> heapData = new ArrayList<DataPoint>();
		for (File f : fHeap) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				heapData.add(new DataPoint(Long.parseLong(listSubContent[0]),
						SystemUtil.convertByteToMB(Double
								.parseDouble(listSubContent[1]))));

			}
		}
		allReport.setHeapReport(heapData);

		File[] fNonHeap = getListFile(
				new File(fileUtil.pathFileData(FileUtil.PATH_NONHEAP)), dt);
		List<DataPoint> nonHeapData = new ArrayList<DataPoint>();
		for (File f : fNonHeap) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				nonHeapData.add(new DataPoint(
						Long.parseLong(listSubContent[0]), SystemUtil
								.convertByteToMB(Double
										.parseDouble(listSubContent[1]))));

			}
		}
		allReport.setNonheapReport(nonHeapData);

		File[] fNetwork = getListFile(
				new File(fileUtil.pathFileData(FileUtil.PATH_NETWORK)), dt);
		List<DataPoints> networkData = new ArrayList<DataPoints>();
		for (File f : fNetwork) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				networkData.add(new DataPoints(Long
						.parseLong(listSubContent[0]),
						SystemUtil.convertByteToKB(Double
								.parseDouble(listSubContent[1])), SystemUtil
								.convertByteToKB(Double
										.parseDouble(listSubContent[2]))));

			}
		}
		allReport.setNetworkReport(networkData);

		File[] fSessionRequest = getListFile(
				new File(fileUtil.pathFileData(FileUtil.PATH_SESSIONREQUEST)),
				dt);

		List<DataPoints> sessionData = new ArrayList<DataPoints>();
		for (File f : fSessionRequest) {
			String content = fileUtil.loadFile(f.getAbsolutePath());
			String[] listContent = content.split(FileUtil.LINE);
			for (String ct : listContent) {
				String[] listSubContent = ct.split(FileUtil.WHITE_SPACE);
				sessionData.add(new DataPoints(Long
						.parseLong(listSubContent[0]), Double
						.parseDouble(listSubContent[1]), Double
						.parseDouble(listSubContent[2])));

			}
		}
		allReport.setSessionReport(sessionData);

		return allReport;
	}

	private File[] getListFile(File root, final String date) {
		File[] listFile = root.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(String.format("%s.txt", date));
			}

		});
		return listFile;
	}

	

}
