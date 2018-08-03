package com.nlu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.nlu.mail.SendMailUtil;
import com.nlu.model.AlarmInfo;

/**
 * Portlet implementation class Alarm
 */
public class Alarm extends MVCPortlet {
	private static final String RAM = "/ram";
	private static final String CPU = "/cpu";
	private static final String HEAP = "/heap";
	private static final String NON_HEAP = "/nonheap";
	private static final String SESSION = "/session";
	private static final String START = "/start";
	private static final String END = "/end";
	private static final String VALUE = "/value";
	private static final Log _log = LogFactoryUtil
			.getLog(Alarm.class.getName());

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

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException {
		PortletSession portletSession = request.getPortletSession();
		ObjectMapper objMapper = new ObjectMapper();
		PrintWriter p = response.getWriter();
		String id = request.getResourceID();
		switch (id) {
		case "setupAlarm":
			List<AlarmInfo> listAlarmInfos = new ArrayList<AlarmInfo>();
			String data = ParamUtil.getString(request, "dataSend");
			JsonNode root = objMapper.readTree(data);
			JsonNode ramNode = root.at(RAM);
			JsonNode cpuNode = root.at(CPU);
			JsonNode heapNode = root.at(HEAP);
			JsonNode nonheapNode = root.at(NON_HEAP);
			JsonNode sessionNode = root.at(SESSION);
			if (ramNode.isArray()) {
				for (JsonNode objNode : ramNode) {
					AlarmInfo ai = new AlarmInfo();
					ai.setName("Memory");
					ai.setStart(objNode.at(START).asInt());
					ai.setEnd(objNode.at(END).asInt());
					ai.setValue(objNode.at(VALUE).asDouble());
					listAlarmInfos.add(ai);
				}

			}
			if (cpuNode.isArray()) {
				for (JsonNode objNode : cpuNode) {
					AlarmInfo ai = new AlarmInfo();
					ai.setName("Cpu");
					ai.setStart(objNode.at(START).asInt());
					ai.setEnd(objNode.at(END).asInt());
					ai.setValue(objNode.at(VALUE).asDouble());
					listAlarmInfos.add(ai);
				}

			}
			if (heapNode.isArray()) {
				for (JsonNode objNode : heapNode) {
					AlarmInfo ai = new AlarmInfo();
					ai.setName("Heap");
					ai.setStart(objNode.at(START).asInt());
					ai.setEnd(objNode.at(END).asInt());
					ai.setValue(objNode.at(VALUE).asDouble());
					listAlarmInfos.add(ai);
				}

			}
			if (nonheapNode.isArray()) {
				for (JsonNode objNode : nonheapNode) {
					AlarmInfo ai = new AlarmInfo();
					ai.setName("NonHeap");
					ai.setStart(objNode.at(START).asInt());
					ai.setEnd(objNode.at(END).asInt());
					ai.setValue(objNode.at(VALUE).asDouble());
					listAlarmInfos.add(ai);
				}

			}
			if (sessionNode.isArray()) {
				for (JsonNode objNode : sessionNode) {
					AlarmInfo ai = new AlarmInfo();
					ai.setName("SessionRequest");
					ai.setStart(objNode.at(START).asInt());
					ai.setEnd(objNode.at(END).asInt());
					ai.setValue(objNode.at(VALUE).asDouble());
					listAlarmInfos.add(ai);
				}

			}
			for(AlarmInfo ai: listAlarmInfos){
				System.out.println(ai);
			}
			break;
		}
	}
}
