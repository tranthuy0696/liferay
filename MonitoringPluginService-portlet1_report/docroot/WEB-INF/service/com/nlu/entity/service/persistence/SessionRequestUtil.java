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

package com.nlu.entity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.nlu.entity.model.SessionRequest;

import java.util.List;

/**
 * The persistence utility for the session request service. This utility wraps {@link SessionRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see SessionRequestPersistence
 * @see SessionRequestPersistenceImpl
 * @generated
 */
public class SessionRequestUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SessionRequest sessionRequest) {
		getPersistence().clearCache(sessionRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SessionRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SessionRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SessionRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SessionRequest update(SessionRequest sessionRequest)
		throws SystemException {
		return getPersistence().update(sessionRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SessionRequest update(SessionRequest sessionRequest,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sessionRequest, serviceContext);
	}

	/**
	* Caches the session request in the entity cache if it is enabled.
	*
	* @param sessionRequest the session request
	*/
	public static void cacheResult(
		com.nlu.entity.model.SessionRequest sessionRequest) {
		getPersistence().cacheResult(sessionRequest);
	}

	/**
	* Caches the session requests in the entity cache if it is enabled.
	*
	* @param sessionRequests the session requests
	*/
	public static void cacheResult(
		java.util.List<com.nlu.entity.model.SessionRequest> sessionRequests) {
		getPersistence().cacheResult(sessionRequests);
	}

	/**
	* Creates a new session request with the primary key. Does not add the session request to the database.
	*
	* @param sessionRequestId the primary key for the new session request
	* @return the new session request
	*/
	public static com.nlu.entity.model.SessionRequest create(
		long sessionRequestId) {
		return getPersistence().create(sessionRequestId);
	}

	/**
	* Removes the session request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request that was removed
	* @throws com.nlu.entity.NoSuchSessionRequestException if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest remove(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchSessionRequestException {
		return getPersistence().remove(sessionRequestId);
	}

	public static com.nlu.entity.model.SessionRequest updateImpl(
		com.nlu.entity.model.SessionRequest sessionRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sessionRequest);
	}

	/**
	* Returns the session request with the primary key or throws a {@link com.nlu.entity.NoSuchSessionRequestException} if it could not be found.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request
	* @throws com.nlu.entity.NoSuchSessionRequestException if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest findByPrimaryKey(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchSessionRequestException {
		return getPersistence().findByPrimaryKey(sessionRequestId);
	}

	/**
	* Returns the session request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request, or <code>null</code> if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.SessionRequest fetchByPrimaryKey(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sessionRequestId);
	}

	/**
	* Returns all the session requests.
	*
	* @return the session requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.SessionRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.nlu.entity.model.SessionRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the session requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.SessionRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of session requests
	* @param end the upper bound of the range of session requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of session requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.SessionRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the session requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of session requests.
	*
	* @return the number of session requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SessionRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SessionRequestPersistence)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					SessionRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(SessionRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SessionRequestPersistence persistence) {
	}

	private static SessionRequestPersistence _persistence;
}