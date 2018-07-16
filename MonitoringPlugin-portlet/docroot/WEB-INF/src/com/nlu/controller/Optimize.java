package com.nlu.controller;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.util.FileUtil;
import com.nlu.util.OsUtils;

/**
 * Portlet implementation class Optimize
 */
public class Optimize extends MVCPortlet {
	private static final Pattern patternXmx =Pattern.compile("(-Xmx)(\\d+)(m)");
	private static final Pattern patternXX=Pattern.compile("(-XX:MaxPermSize\\s*=\\s*)(\\d+)(m)");
	public void getApi(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		try {
			System.out.println(System.getProperty("catalina.base"));
			
			optimize(1000, 1000);
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
	}
	public void getUrl(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		
	}
	public void optimize(int xmx, int xx) throws IOException{
		FileUtil fileUtil = new FileUtil();
		String path="";
		if (OsUtils.isWindows()) {
			 path = System.getProperty("catalina.base")+ "/bin/setenv.bat";
			
		}
		else{
			path= System.getProperty("catalina.base")+ "/bin/setenv.sh";
		}
		String contentFile = fileUtil.loadFile(path);
		Matcher matcherXmx=patternXmx.matcher(contentFile);
		while(matcherXmx.find()){
			String matcherNew=matcherXmx.group(1)+xmx+matcherXmx.group(3);
			contentFile=matcherXmx.replaceAll(matcherNew);
		}
		Matcher matcherXX=patternXX.matcher(contentFile);
		while(matcherXX.find()){
			String matcherNew=matcherXX.group(1)+xx+matcherXX.group(3);
			contentFile=matcherXX.replaceAll(matcherNew);
		}
		System.out.println(contentFile);
		fileUtil.writeFile(contentFile, path);
		
	}
//	public static void main(String[] args) {
//		String text="if exist \"%CATALINA_HOME%/jre1.6.0_20/win\" (\r\nif not \"%JAVA_HOME%\" == \"\" (\r\nset JAVA_HOME=\r\n)\r\nset \"JRE_HOME=%CATALINA_HOME%/jre1.6.0_20/win\"\r\n(\r\nset \"CATALINA_OPTS=%CATALINA_OPTS% -Dfile.encoding=UTF8 -Djava.net.preferIPv4Stack=true  -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false -Duser.timezone=GMT+7 -Xmx2048m\r\n -XX:MaxPermSize=512m\"";
////	System.out.println(text);
//		
//		String sh="CATALINA_OPTS=\"$CATALINA_OPTS -Dfile.encoding=UTF8 -Djava.net.preferIPv4Stack=true  -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false\r\n -Duser.timezone=GMT+7 -XX:MaxPermSize =512m -Xmx2048m\"";
//	Pattern pattern =Pattern.compile("(.*)(-Xmx(\\d+)m.*-XX:MaxPermSize=(\\d+)m)(.*)", Pattern.DOTALL);
//	Pattern pattern1 =Pattern.compile("(-Xmx)(\\d+)(m)");
//	Pattern pattern2=Pattern.compile("(-XX:MaxPermSize\\s*=\\s*)(\\d+)(m)");
//	Matcher matcher=pattern1.matcher(sh);
////	System.out.println(matcher.find());
////	String t="";
//	while(matcher.find()){
////		System.out.println(matcher.group(0));`
//		System.out.println("1. "+matcher.group(2));
////		System.out.println("2. "+matcher.group(2));
////		System.out.println("3. "+matcher.group(3));
////		System.out.println("4. "+matcher.group(4));
////		System.out.println("5. "+matcher.group(5));
//		String t=matcher.group(1)+1000+matcher.group(3);
//		System.out.println(t);
//		
//		sh=matcher.replaceAll(t);
//	}
//	Matcher m2=pattern2.matcher(sh);
//	while(m2.find()){
//		System.out.println("1. "+m2.group(2));
////		System.out.println("2. "+matcher.group(2));
////		System.out.println("3. "+matcher.group(3));
////		System.out.println("4. "+matcher.group(4));
////		System.out.println("5. "+matcher.group(5));
//		String t=m2.group(1)+1000+m2.group(3);
//		System.out.println(t);
//		sh=m2.replaceAll(t);
//	}
////	matcher.replaceAll()
//	System.out.println(sh);
//	}
 

}
