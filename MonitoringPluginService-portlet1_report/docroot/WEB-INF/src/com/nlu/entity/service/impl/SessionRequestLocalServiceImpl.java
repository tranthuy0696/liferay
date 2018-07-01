/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nlu.entity.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import com.nlu.entity.model.SessionRequest;
import com.nlu.entity.service.base.SessionRequestLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the session request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.SessionRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.SessionRequestLocalServiceBaseImpl
 * @see com.nlu.entity.service.SessionRequestLocalServiceUtil
 */
public class SessionRequestLocalServiceImpl
	extends SessionRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.SessionRequestLocalServiceUtil} to access the session request local service.
	 */
	public SessionRequest addSessionRequest( String sessionId,
		Date time, String ip, String browser, String os, boolean login,
		ServiceContext serviceContext) throws SystemException, PortalException {
		

		long sessionRequestId = counterLocalService.increment(SessionRequest.class.getName());
		SessionRequest sessionRequest = sessionRequestPersistence.create(sessionRequestId);

		sessionRequest.setSessionId(sessionId);
		sessionRequest.setTime(time);
		sessionRequest.setIp(ip);
		sessionRequest.setBrowser(browser);
		sessionRequest.setOs(os);
		sessionRequest.setLogin(login);
		sessionRequest.setExpandoBridgeAttributes(serviceContext);

		addSessionRequest(sessionRequest);

		return sessionRequest;
	}

	public SessionRequest updateSessionRequest(long sessionRequestId,
		String sessionId, Date time, String ip, String browser, String os,
		boolean login, ServiceContext serviceContext)
		throws SystemException, PortalException {
		SessionRequest sessionRequest = sessionRequestPersistence.fetchByPrimaryKey(sessionRequestId);

		sessionRequest.setSessionId(sessionId);
		sessionRequest.setTime(time);
		sessionRequest.setIp(ip);
		sessionRequest.setBrowser(browser);
		sessionRequest.setOs(os);
		sessionRequest.setLogin(login);
		sessionRequest.setExpandoBridgeAttributes(serviceContext);

		updateSessionRequest(sessionRequest);

		return sessionRequest;
	}
	public List<SessionRequest> findAll() throws SystemException{
		return sessionRequestPersistence.findAll();
	}
	public void deleteSessionRequestByDate(int numberDate){
		sessionRequestFinder.deleteSessionRequestByDate(numberDate);
	}
}