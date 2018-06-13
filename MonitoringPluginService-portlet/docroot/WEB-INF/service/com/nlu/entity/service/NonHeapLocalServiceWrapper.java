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
 * Provides a wrapper for {@link NonHeapLocalService}.
 *
 * @author NgocBao
 * @see NonHeapLocalService
 * @generated
 */
public class NonHeapLocalServiceWrapper implements NonHeapLocalService,
	ServiceWrapper<NonHeapLocalService> {
	public NonHeapLocalServiceWrapper(NonHeapLocalService nonHeapLocalService) {
		_nonHeapLocalService = nonHeapLocalService;
	}

	/**
	* Adds the non heap to the database. Also notifies the appropriate model listeners.
	*
	* @param nonHeap the non heap
	* @return the non heap that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.NonHeap addNonHeap(
		com.nlu.entity.model.NonHeap nonHeap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.addNonHeap(nonHeap);
	}

	/**
	* Creates a new non heap with the primary key. Does not add the non heap to the database.
	*
	* @param nonHeapId the primary key for the new non heap
	* @return the new non heap
	*/
	@Override
	public com.nlu.entity.model.NonHeap createNonHeap(long nonHeapId) {
		return _nonHeapLocalService.createNonHeap(nonHeapId);
	}

	/**
	* Deletes the non heap with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap that was removed
	* @throws PortalException if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.NonHeap deleteNonHeap(long nonHeapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.deleteNonHeap(nonHeapId);
	}

	/**
	* Deletes the non heap from the database. Also notifies the appropriate model listeners.
	*
	* @param nonHeap the non heap
	* @return the non heap that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.NonHeap deleteNonHeap(
		com.nlu.entity.model.NonHeap nonHeap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.deleteNonHeap(nonHeap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nonHeapLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nlu.entity.model.NonHeap fetchNonHeap(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.fetchNonHeap(nonHeapId);
	}

	/**
	* Returns the non heap with the primary key.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap
	* @throws PortalException if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.NonHeap getNonHeap(long nonHeapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.getNonHeap(nonHeapId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the non heaps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of non heaps
	* @param end the upper bound of the range of non heaps (not inclusive)
	* @return the range of non heaps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.nlu.entity.model.NonHeap> getNonHeaps(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.getNonHeaps(start, end);
	}

	/**
	* Returns the number of non heaps.
	*
	* @return the number of non heaps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNonHeapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.getNonHeapsCount();
	}

	/**
	* Updates the non heap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nonHeap the non heap
	* @return the non heap that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.NonHeap updateNonHeap(
		com.nlu.entity.model.NonHeap nonHeap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.updateNonHeap(nonHeap);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _nonHeapLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nonHeapLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _nonHeapLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.NonHeap addNonHeap(java.util.Date time,
		double value, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.addNonHeap(time, value, serviceContext);
	}

	@Override
	public com.nlu.entity.model.NonHeap updateNonHeap(long nonHeapId,
		java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.updateNonHeap(nonHeapId, time, value,
			serviceContext);
	}

	@Override
	public java.util.List<com.nlu.entity.model.NonHeap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapLocalService.findAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NonHeapLocalService getWrappedNonHeapLocalService() {
		return _nonHeapLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNonHeapLocalService(
		NonHeapLocalService nonHeapLocalService) {
		_nonHeapLocalService = nonHeapLocalService;
	}

	@Override
	public NonHeapLocalService getWrappedService() {
		return _nonHeapLocalService;
	}

	@Override
	public void setWrappedService(NonHeapLocalService nonHeapLocalService) {
		_nonHeapLocalService = nonHeapLocalService;
	}

	private NonHeapLocalService _nonHeapLocalService;
}