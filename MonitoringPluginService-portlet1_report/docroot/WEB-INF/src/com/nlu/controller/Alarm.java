package com.nlu.controller;

import javax.mail.internet.AddressException;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.mail.SendMailUtil;

/**
 * Portlet implementation class Alarm
 */
public class Alarm extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(Alarm.class.getName());
	@Override
	public void init() throws PortletException {
		try {
			_log.info("send mail");
			SendMailUtil.sendMail("14130155@st.hcmuaf.edu.vn", "test", "test");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.init();
	}
}
