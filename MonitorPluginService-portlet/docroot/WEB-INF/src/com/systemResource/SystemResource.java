package com.systemResource;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.service.serviceBuilder.model.Cpu;
import com.service.serviceBuilder.model.impl.CpuImpl;
import com.service.serviceBuilder.service.RamServiceUtil;

/**
 * Portlet implementation class SystemResource
 */
public class SystemResource extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SystemResource.class.getName());

	@Override
	public void init() throws PortletException {
		_log.info(" This is init method without parameter");

		super.init();
	}

	public void method1(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		ServiceContext serviceContext = new ServiceContext();
		Cpu aa = new CpuImpl();
		a.setMin(1.2);
		a.setMax(1.2);
		a.setAver(5.6);
		_log.info(RamServiceUtil.addRam(aa));
		
		
		
	}
	

}
