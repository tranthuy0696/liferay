package com.nlu.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public List<DataPoints> getDataSessionRequest(String folder) throws IOException {
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
						SystemUtil.convertByteToKB(Double.parseDouble(listSubContent[1])), SystemUtil.convertByteToKB(Double
								.parseDouble(listSubContent[2]))));

			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
	FileUtil fu=new FileUtil();
	String content=fu.loadFile("C:\\Users\\thuthuy\\Desktop\\software_liferay\\sdk_server\\server\\monitor\\ram\\ram.2018-07-14.txt");
	 Pattern patternMaxValue=Pattern.compile("(.*\\s+)(\\S+)\\s+max", Pattern.MULTILINE);
	 Matcher m=patternMaxValue.matcher(content);
	 while(m.find()){
		 System.out.println(m.group(1)+" "+m.group(2));
	 }
	}

}
