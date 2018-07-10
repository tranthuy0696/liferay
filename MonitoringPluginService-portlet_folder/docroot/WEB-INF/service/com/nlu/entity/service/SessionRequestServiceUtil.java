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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SessionRequest. This utility wraps
 * {@link com.nlu.entity.service.impl.SessionRequestServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author NgocBao
 * @see SessionRequestService
 * @see com.nlu.entity.service.base.SessionRequestServiceBaseImpl
 * @see com.nlu.entity.service.impl.SessionRequestServiceImpl
 * @generated
 */
public class SessionRequestServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.nlu.entity.service.impl.SessionRequestServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.nlu.entity.model.SessionRequest addSessionRequest(
		java.lang.String sessionId, java.util.Date time, java.lang.String ip,
		java.lang.String browser, java.lang.String os, boolean login,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSessionRequest(sessionId, time, ip, browser, os, login,
			serviceContext);
	}

	public static void deleteSessionRequest(long sessionRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSessionRequest(sessionRequestId);
	}

	public static com.nlu.entity.model.SessionRequest getSessionRequest(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSessionRequest(sessionRequestId);
	}

	public static com.nlu.entity.model.SessionRequest updateSessionRequest(
		long sessionRequestId, java.lang.String sessionId, java.util.Date time,
		java.lang.String ip, java.lang.String browser, java.lang.String os,
		boolean login, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSessionRequest(sessionRequestId, sessionId, time, ip,
			browser, os, login, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SessionRequestService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SessionRequestService.class.getName());

			if (invokableService instanceof SessionRequestService) {
				_service = (SessionRequestService)invokableService;
			}
			else {
				_service = new SessionRequestServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SessionRequestServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SessionRequestService service) {
	}

	private static SessionRequestService _service;
}