package com.nlu.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
	public static String PATH_RAM="ram";
	public static String PATH_CPU="cpu";
	public static String PATH_HEAP="heap";
	public static String PATH_NONHEAP="nonHeap";
	public static String PATH_SESSIONREQUEST="sessionRequest";
	public static String PATH_NETWORK="network";
	public static String PATH_ALARM="alarm";
	public static String LINE="\n";
	public static String WHITE_SPACE=" ";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public void writeFile(String pData, String pFileName) throws IOException {
		Files.write(Paths.get(pFileName), pData.getBytes());
	}

	public String loadFile(String pFileName) throws IOException {
		return new String(Files.readAllBytes(Paths.get(pFileName)));
	}

	public boolean isFileExists(String pFilePath) {
		return Files.exists(Paths.get(pFilePath));
	}

	public String pathDirectory() {
		return System.getProperty("liferay.home") + File.separator + "monitor";
	}
//monitor//ram//ram.date.txt;
	public String getPathSaveDataMonitor(String fileName) throws IOException {
		String path=String.format("%s%s%s%s%s.%s.txt", pathDirectory(),File.separator,fileName,File.separator,fileName,sdf.format(new Date()));
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		return path;
	}
//	public String getPathSaveDataAlarm(String fileName) throws IOException {
//		String path=String.format("%s%s%s%s%s.txt", pathDirectory(),File.separator,fileName,File.separator,fileName);
//		File file = new File(path);
//		if (!file.exists()) {
//			file.createNewFile();
//		}
//		return path;
//	}
	public void createPath(){
		new File(pathDirectory()).mkdir();
		String pathRoot=pathDirectory()+File.separator;
		new File(pathRoot+PATH_RAM).mkdir();
		new File(pathRoot+PATH_CPU).mkdir();
		new File(pathRoot+PATH_HEAP).mkdir();
		new File(pathRoot+PATH_NONHEAP).mkdir();
		new File(pathRoot+PATH_NETWORK).mkdir();
		new File(pathRoot+PATH_SESSIONREQUEST).mkdir();
		new File(pathRoot+PATH_ALARM).mkdir();
	}
	public String pathFileData(String folderName){
		return pathDirectory()+File.separator+folderName;
	}
	
}