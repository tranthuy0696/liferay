package com.nlu.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.model.JvmOption;
import com.nlu.service.JvmService;

/**
 * Portlet implementation class Optimize
 */
public class Optimize extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class.getName());

	public void setJvm(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		Integer xmx = ParamUtil.getInteger(request, "xmx");
		Integer xms = ParamUtil.getInteger(request, "xms");
		Integer newSize = ParamUtil.getInteger(request, "newSize");
		Integer maxNewSize = ParamUtil.getInteger(request, "maxNewSize");
		Integer maxPermSize = ParamUtil.getInteger(request, "maxPermSize");
		JvmOption jvmOp = new JvmOption(xmx, xms, newSize, maxNewSize, maxPermSize);
		JvmService service = new JvmService();
		_log.info("aaaa" + xmx);
		service.setInfo(jvmOp);

	}

	public void setJvm1(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {

		_log.info("aaaa");

	}

}
