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

import com.liferay.portal.service.persistence.BasePersistence;

import com.nlu.entity.model.SessionRequest;

/**
 * The persistence interface for the session request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see SessionRequestPersistenceImpl
 * @see SessionRequestUtil
 * @generated
 */
public interface SessionRequestPersistence extends BasePersistence<SessionRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SessionRequestUtil} to access the session request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the session request in the entity cache if it is enabled.
	*
	* @param sessionRequest the session request
	*/
	public void cacheResult(com.nlu.entity.model.SessionRequest sessionRequest);

	/**
	* Caches the session requests in the entity cache if it is enabled.
	*
	* @param sessionRequests the session requests
	*/
	public void cacheResult(
		java.util.List<com.nlu.entity.model.SessionRequest> sessionRequests);

	/**
	* Creates a new session request with the primary key. Does not add the session request to the database.
	*
	* @param sessionRequestId the primary key for the new session request
	* @return the new session request
	*/
	public com.nlu.entity.model.SessionRequest create(long sessionRequestId);

	/**
	* Removes the session request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request that was removed
	* @throws com.nlu.entity.NoSuchSessionRequestException if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.SessionRequest remove(long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchSessionRequestException;

	public com.nlu.entity.model.SessionRequest updateImpl(
		com.nlu.entity.model.SessionRequest sessionRequest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the session request with the primary key or throws a {@link com.nlu.entity.NoSuchSessionRequestException} if it could not be found.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request
	* @throws com.nlu.entity.NoSuchSessionRequestException if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.SessionRequest findByPrimaryKey(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchSessionRequestException;

	/**
	* Returns the session request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sessionRequestId the primary key of the session request
	* @return the session request, or <code>null</code> if a session request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.SessionRequest fetchByPrimaryKey(
		long sessionRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the session requests.
	*
	* @return the session requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.SessionRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.nlu.entity.model.SessionRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.nlu.entity.model.SessionRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the session requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of session requests.
	*
	* @return the number of session requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}