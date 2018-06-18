package com.nlu.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONException;
import com.nlu.model.DataResponse;
import com.nlu.model.SessionResponse;
import com.nlu.model.SessionUser;
import com.nlu.util.SystemUtil;

public class RealtimeService {
	/**
	 * memory realtime
	 * 
	 * @return
	 */
	public DataResponse getMemoryRealtime() {
		double memoryFree = SystemUtil.getMemoryFree();
		double memoryTotal = SystemUtil.getMaxMemory();
		double memoryUsage = SystemUtil.usage(memoryFree, memoryTotal);

		DataResponse memoryResponse = new DataResponse(
				SystemUtil.convertByteToGB(memoryUsage),
				Math.round((double) memoryUsage / memoryTotal * 100));
		return memoryResponse;
	}

	public DataResponse getHeapRealtime() {
		long maxHeap = SystemUtil.getMaxHeapMemory();
		long heapUsed = SystemUtil.getHeapMemoryUsed();
		DataResponse heapResponse = new DataResponse(
				SystemUtil.convertByteToMB(heapUsed),
				Math.round((double) heapUsed / maxHeap * 100));
		return heapResponse;
	}

	public DataResponse getNonHeapRealtime() {
		long maxNonHeap = SystemUtil.getNonMaxHeapMemory();
		long nonHeapUsed = SystemUtil.getNonHeapMemoryUsed();
		DataResponse nonHeapResponse = new DataResponse(
				SystemUtil.convertByteToMB(nonHeapUsed),
				Math.round((double) nonHeapUsed / maxNonHeap * 100));
		return nonHeapResponse;
	}

	public SessionResponse getSessionUserRealtime() throws JSONException,
			IOException {
		List<SessionUser> getInfoSession = SystemUtil.getInfoSession();
		SessionResponse result = new SessionResponse();
		for (SessionUser sessionUser : getInfoSession) {
			if (sessionUser.isLogin()) {
				result.setNumberLogin(result.getNumberLogin() + 1);
			} else {
				result.setNumberLogout(result.getNumberLogout() + 1);
			}
		}
		return result;
	}
}
