package com.nlu.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nlu.model.JvmOption;
import com.nlu.util.FileUtil;
import com.nlu.util.OsUtils;

public class JvmService {
	private static final Pattern patternXmx = Pattern.compile("(-Xmx)(\\d+)(m)");
	private static final Pattern patternXms = Pattern.compile("(-Xms)(\\d+)(m)");
	private static final Pattern patternMaxPermSize = Pattern.compile("(-XX:MaxPermSize\\s*=\\s*)(\\d+)(m)");
	private static final Pattern patternNewSize = Pattern.compile("(-XX:NewSize\\s*=\\s*)(\\d+)(m)");
	private static final Pattern patternMaxNewSize = Pattern.compile("(-XX:MaxNewSize\\s*=\\s*)(\\d+)(m)");

	public JvmOption getJvmSuggest() {
		return new JvmOption(2048, 2048, 700, 700, 512);
	}
	public static void restartTomcat() throws IOException{
		String pathStop = System.getProperty("catalina.base") + "/bin/restart.bat";
		Runtime.
		   getRuntime().
		   exec(String.format("cmd /c start %s",pathStop));
		
		
	}

	public JvmOption getInfo() {
		String path = "";
		if (OsUtils.isWindows()) {
			path = System.getProperty("catalina.base") + "/bin/setenv.bat";

		} else {
			path = System.getProperty("catalina.base") + "/bin/setenv.sh";
		}
		return getJvmOption(path);
	}

	public void setInfo(JvmOption jvm) throws IOException {
		String path = "";
		if (OsUtils.isWindows()) {
			path = System.getProperty("catalina.base") + "/bin/setenv.bat";

		} else {
			path = System.getProperty("catalina.base") + "/bin/setenv.sh";
		}
		System.out.println(jvm.getNewSize());
		setJvmOption(jvm, path);
	}

	public JvmOption getJvmOption(String path) {
		JvmOption result = new JvmOption();
		FileUtil fileUtil = new FileUtil();
		String contentFile = "";
		try {
			contentFile = fileUtil.loadFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Matcher matcherXmx = patternXmx.matcher(contentFile);
		while (matcherXmx.find()) {
			result.setXmx(Integer.parseInt(matcherXmx.group(2)));
		}
		Matcher matcherMaxPermSize = patternMaxPermSize.matcher(contentFile);
		while (matcherMaxPermSize.find()) {
			result.setMaxPermSize(Integer.parseInt(matcherMaxPermSize.group(2)));
		}
		Matcher matcherMaxNewSize = patternMaxNewSize.matcher(contentFile);
		while (matcherMaxNewSize.find()) {
			result.setMaxNewSize(Integer.parseInt(matcherMaxNewSize.group(2)));
		}
		Matcher matcherNewSize = patternNewSize.matcher(contentFile);
		while (matcherNewSize.find()) {
			result.setNewSize(Integer.parseInt(matcherNewSize.group(2)));
		}
		Matcher matcherXms = patternXms.matcher(contentFile);
		while (matcherXms.find()) {
			result.setXms(Integer.parseInt(matcherXms.group(2)));
		}
		return result;

	}

	public void setJvmOption(JvmOption jvm, String path) throws IOException {
		FileUtil fileUtil = new FileUtil();
		String contentFile = fileUtil.loadFile(path);
		Matcher matcherXmx = patternXmx.matcher(contentFile);
		while (matcherXmx.find()) {
			String matcherNew = matcherXmx.group(1) + jvm.getXmx() + matcherXmx.group(3);
			contentFile = matcherXmx.replaceAll(matcherNew);
		}
		Matcher matcherMaxPermSize = patternMaxPermSize.matcher(contentFile);
		while (matcherMaxPermSize.find()) {
			String matcherNew = matcherMaxPermSize.group(1) + jvm.getMaxPermSize() + matcherMaxPermSize.group(3);
			contentFile = matcherMaxPermSize.replaceAll(matcherNew);
		}
		Matcher matcherMaxNewSize = patternMaxNewSize.matcher(contentFile);
		while (matcherMaxNewSize.find()) {
			String matcherNew = matcherMaxNewSize.group(1) + jvm.getMaxNewSize() + matcherMaxNewSize.group(3);
			contentFile = matcherMaxNewSize.replaceAll(matcherNew);
		}
		Matcher matcherNewSize = patternNewSize.matcher(contentFile);
		while (matcherNewSize.find()) {
			String matcherNew = matcherNewSize.group(1) + jvm.getNewSize() + matcherNewSize.group(3);
			contentFile = matcherNewSize.replaceAll(matcherNew);
		}
		Matcher matcherXms = patternXms.matcher(contentFile);
		while (matcherXms.find()) {
			String matcherNew = matcherXms.group(1) + jvm.getXms() + matcherXms.group(3);
			contentFile = matcherXms.replaceAll(matcherNew);
		}
		fileUtil.writeFile(contentFile, path);

	}

}
