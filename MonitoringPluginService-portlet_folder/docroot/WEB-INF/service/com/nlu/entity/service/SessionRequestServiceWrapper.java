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

package com.nlu.entity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SessionRequestService}.
 *
 * @author NgocBao
 * @see SessionRequestService
 * @generated
 */
public class SessionRequestServiceWrapper implements SessionRequestService,
	ServiceWrapper<SessionRequestService> {
	public SessionRequestServiceWrapper(
		SessionRequestService sessionRequestService) {
		_sessionRequestService = sessionRequestService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sessionRequestService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sessionRequestService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sessionRequestService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.nlu.entity.model.SessionRequest addSessionRequest(
		java.lang.String sessionId, java.util.Date time, java.lang.String ip,
		java.lang.String browser, java.lang.String os, boolean login,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sessionRequestService.addSessionRequest(sessionId, time, ip,
			browser, os, login, serviceContext);
	}

	@Override
	public void deleteSessionRequest(long sessionRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_sessionRequestService.deleteSessionRequest(sessionRequestId);
	}

	@Override
	public com.nlu.entity.model.SessionRequest getSessionRequest(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sessionRequestService.getSessionRequest(sessionRequestId);
	}

	@Override
	public com.nlu.entity.model.SessionRequest updateSessionRequest(
		long sessionRequestId, java.lang.String sessionId, java.util.Date time,
		java.lang.String ip, java.lang.String browser, java.lang.String os,
		boolean login, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sessionRequestService.updateSessionRequest(sessionRequestId,
			sessionId, time, ip, browser, os, login, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SessionRequestService getWrappedSessionRequestService() {
		return _sessionRequestService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSessionRequestService(
		SessionRequestService sessionRequestService) {
		_sessionRequestService = sessionRequestService;
	}

	@Override
	public SessionRequestService getWrappedService() {
		return _sessionRequestService;
	}

	@Override
	public void setWrappedService(SessionRequestService sessionRequestService) {
		_sessionRequestService = sessionRequestService;
	}

	private SessionRequestService _sessionRequestService;
}