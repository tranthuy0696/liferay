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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SessionRequest. This utility wraps
 * {@link com.nlu.entity.service.impl.SessionRequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author NgocBao
 * @see SessionRequestLocalService
 * @see com.nlu.entity.service.base.SessionRequestLocalServiceBaseImpl
 * @see com.nlu.entity.service.impl.SessionRequestLocalServiceImpl
 * @generated
 */
public class SessionRequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.nlu.entity.service.impl.SessionRequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the session request to the database. Also notifies the appropriate model listeners.
	*
	* @param sessionRequest the session request
	* @return the session request that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest addSessionRequest(
		com.nlu.entity.model.SessionRequest sessionRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSessionRequest(sessionRequest);
	}

	/**
	* Creates a new session request with the primary key. Does not add the session request to the database.
	*
	* @param sessionRequestId the primary key for the new session request
	* @return the new session request
	*/
	public static com.nlu.entity.model.SessionRequest createSessionRequest(
		long sessionRequestId) {
		return getService().createSessionRequest(sessionRequestId);
	}

	/**
	* Deletes the session request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request that was removed
	* @throws PortalException if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest deleteSessionRequest(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSessionRequest(sessionRequestId);
	}

	/**
	* Deletes the session request from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionRequest the session request
	* @return the session request that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest deleteSessionRequest(
		com.nlu.entity.model.SessionRequest sessionRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSessionRequest(sessionRequest);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.SessionRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.SessionRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.nlu.entity.model.SessionRequest fetchSessionRequest(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSessionRequest(sessionRequestId);
	}

	/**
	* Returns the session request with the primary key.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request
	* @throws PortalException if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest getSessionRequest(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSessionRequest(sessionRequestId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the session requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.SessionRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of session requests
	* @param end the upper bound of the range of session requests (not inclusive)
	* @return the range of session requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.SessionRequest> getSessionRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSessionRequests(start, end);
	}

	/**
	* Returns the number of session requests.
	*
	* @return the number of session requests
	* @throws SystemException if a system exception occurred
	*/
	public static int getSessionRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSessionRequestsCount();
	}

	/**
	* Updates the session request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sessionRequest the session request
	* @return the session request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest updateSessionRequest(
		com.nlu.entity.model.SessionRequest sessionRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSessionRequest(sessionRequest);
	}

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

	public static java.util.List<com.nlu.entity.model.SessionRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static void deleteSessionRequestByDate(int numberDate) {
		getService().deleteSessionRequestByDate(numberDate);
	}

	public static java.util.List<com.nlu.entity.model.SessionRequest> searchSessionRequestByDate(
		java.lang.String date) {
		return getService().searchSessionRequestByDate(date);
	}

	public static java.util.List getSessionReportByDate(java.lang.String name,
		java.lang.String date) {
		return getService().getSessionReportByDate(name, date);
	}

	public static void clearService() {
		_service = null;
	}

	public static SessionRequestLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SessionRequestLocalService.class.getName());

			if (invokableLocalService instanceof SessionRequestLocalService) {
				_service = (SessionRequestLocalService)invokableLocalService;
			}
			else {
				_service = new SessionRequestLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SessionRequestLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SessionRequestLocalService service) {
	}

	private static SessionRequestLocalService _service;
}