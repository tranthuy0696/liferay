package com.nlu.controller;

import java.io.File;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.util.FileUtil;
import com.nlu.util.OsUtils;

/**
 * Portlet implementation class Optimize
 */
public class Optimize extends MVCPortlet {
	public void getApi(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		try {
			System.out.println(System.getProperty("catalina.base"));
			
			optimize();
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
	}
	public void getUrl(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		
	}
	public void optimize() throws IOException{
		FileUtil fileUtil = new FileUtil();
		if (OsUtils.isWindows()) {
			
		}
		String path = System.getProperty("catalina.base")+ "/bin/setenv.bat";
		String contentFile = fileUtil.loadFile(path);
		System.out.println(contentFile);
		System.out.println(System.getProperty("os.name"));
		
	}
	
 

}
