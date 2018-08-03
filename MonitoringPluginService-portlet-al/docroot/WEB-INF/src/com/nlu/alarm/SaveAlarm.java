package com.nlu.alarm;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nlu.model.DataAlarm;
import com.nlu.util.FileUtil;

public class SaveAlarm {
	FileUtil fileUtil = new FileUtil();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * reset status alarm
	 * 
	 * @param time
	 * @param name
	 * @throws IOException
	 */
	public void resetStatusAlarm(String time, String name) throws IOException {
		long timestamp = Long.parseLong(time);
		String date = df.format(new Date(timestamp));
		String result="";
		File[] listFile = getListFile(
				new File(fileUtil.pathFileData(FileUtil.PATH_ALARM)), date);
		for (File file : listFile) {
			String contentFile = fileUtil.loadFile(file.getAbsolutePath());
			Pattern pattern = Pattern
					.compile(String
							.format("%s\\s+%s\\s+(\\S+)\\s+(\\S+)\\s+(false)",
									time, name));
			Matcher matcher = pattern.matcher(contentFile);
			while (matcher.find()) {
				result=matcher.group(1);
				String contentUpdate = String.format("%s %s %s %s %s", time,
						name, result, matcher.group(2), "true");
				contentFile = matcher.replaceAll(contentUpdate);
				
			}
			fileUtil.writeFile(contentFile, file.getAbsolutePath());
			
		}

	}

	/**
	 * save alarm
	 * 
	 * @param listDataAlarm
	 * @throws IOException
	 */
	public void saveAlarm(List<DataAlarm> listDataAlarm) throws IOException {
		String pathFile = fileUtil.getPathSaveDataMonitor(FileUtil.PATH_ALARM);
		String content = fileUtil.loadFile(pathFile);
		StringBuilder sb = new StringBuilder();
		sb.append(content);
		for (DataAlarm data : listDataAlarm) {
			sb.append(data.getTime() + FileUtil.WHITE_SPACE + data.getName()
					+ FileUtil.WHITE_SPACE + data.getValue()
					+ FileUtil.WHITE_SPACE + data.getValueAlarm()
					+ FileUtil.WHITE_SPACE + "false");
			sb.append(FileUtil.LINE);
		}
		fileUtil.writeFile(sb.toString(), pathFile);
	}
	public void saveAlarm(DataAlarm data) throws IOException {
		String pathFile = fileUtil.getPathSaveDataMonitor(FileUtil.PATH_ALARM);
		String content = fileUtil.loadFile(pathFile);
		StringBuilder sb = new StringBuilder();
		sb.append(content);
		
			sb.append(data.getTime() + FileUtil.WHITE_SPACE + data.getName()
					+ FileUtil.WHITE_SPACE + data.getValue()
					+ FileUtil.WHITE_SPACE + data.getValueAlarm()
					+ FileUtil.WHITE_SPACE + "false");
			sb.append(FileUtil.LINE);
		
		fileUtil.writeFile(sb.toString(), pathFile);
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

	public static void main(String[] args) throws IOException {
		FileUtil fu = new FileUtil();
		String path = "C:\\Users\\thuthuy\\Desktop\\software_liferay\\Server\\monitor\\cpu\\cpu.2018-07-23.txt";
		StringBuilder sb = new StringBuilder();
		sb.append("1532325223706 cpu 3.5 3 true");
		sb.append("\r\n");
		sb.append("1532325923706 cpu 3.7 3 false");
		sb.append("\r\n");
		sb.append("1532425223706 cpu 3.6 3 false");
		sb.append("\r\n");
		sb.append("1533325223706 cpu 3.9 3 false");
		sb.append("\r\n");
		Pattern pattern = Pattern
				.compile(String
						.format("%s\\s+%s\\s+(\\S+)\\s+(\\S+)\\s+(false)",
								"1532425223706", "cpu"));
		Matcher matcher = pattern.matcher(sb.toString());
		System.out.println(sb.toString());
		while (matcher.find()) {
			System.out.println("matcher");
			String contentUpdate = String.format("%s %s %s %s %s", "1532425223706",
					"cpu", matcher.group(1), matcher.group(2), "true");
			String b = matcher.replaceAll(contentUpdate);
			System.out.println("==========================");
			System.out.println(b);
		}
//		System.out.println(fu.loadFile(path));
//		fu.writeFile(path, sb.toString());
	}

}
