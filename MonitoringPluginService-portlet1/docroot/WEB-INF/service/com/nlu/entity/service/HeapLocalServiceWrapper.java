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
 * Provides a wrapper for {@link HeapLocalService}.
 *
 * @author NgocBao
 * @see HeapLocalService
 * @generated
 */
public class HeapLocalServiceWrapper implements HeapLocalService,
	ServiceWrapper<HeapLocalService> {
	public HeapLocalServiceWrapper(HeapLocalService heapLocalService) {
		_heapLocalService = heapLocalService;
	}

	/**
	* Adds the heap to the database. Also notifies the appropriate model listeners.
	*
	* @param heap the heap
	* @return the heap that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Heap addHeap(com.nlu.entity.model.Heap heap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.addHeap(heap);
	}

	/**
	* Creates a new heap with the primary key. Does not add the heap to the database.
	*
	* @param heapId the primary key for the new heap
	* @return the new heap
	*/
	@Override
	public com.nlu.entity.model.Heap createHeap(long heapId) {
		return _heapLocalService.createHeap(heapId);
	}

	/**
	* Deletes the heap with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param heapId the primary key of the heap
	* @return the heap that was removed
	* @throws PortalException if a heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Heap deleteHeap(long heapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.deleteHeap(heapId);
	}

	/**
	* Deletes the heap from the database. Also notifies the appropriate model listeners.
	*
	* @param heap the heap
	* @return the heap that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Heap deleteHeap(com.nlu.entity.model.Heap heap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.deleteHeap(heap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _heapLocalService.dynamicQuery();
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
		return _heapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _heapLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _heapLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _heapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _heapLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nlu.entity.model.Heap fetchHeap(long heapId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.fetchHeap(heapId);
	}

	/**
	* Returns the heap with the primary key.
	*
	* @param heapId the primary key of the heap
	* @return the heap
	* @throws PortalException if a heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Heap getHeap(long heapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.getHeap(heapId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the heaps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heaps
	* @param end the upper bound of the range of heaps (not inclusive)
	* @return the range of heaps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.nlu.entity.model.Heap> getHeaps(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.getHeaps(start, end);
	}

	/**
	* Returns the number of heaps.
	*
	* @return the number of heaps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHeapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.getHeapsCount();
	}

	/**
	* Updates the heap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param heap the heap
	* @return the heap that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Heap updateHeap(com.nlu.entity.model.Heap heap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.updateHeap(heap);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _heapLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_heapLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _heapLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.Heap addHeap(java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.addHeap(time, value, serviceContext);
	}

	@Override
	public com.nlu.entity.model.Heap updateHeap(long heapId,
		java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.updateHeap(heapId, time, value, serviceContext);
	}

	@Override
	public java.util.List<com.nlu.entity.model.Heap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _heapLocalService.findAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HeapLocalService getWrappedHeapLocalService() {
		return _heapLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHeapLocalService(HeapLocalService heapLocalService) {
		_heapLocalService = heapLocalService;
	}

	@Override
	public HeapLocalService getWrappedService() {
		return _heapLocalService;
	}

	@Override
	public void setWrappedService(HeapLocalService heapLocalService) {
		_heapLocalService = heapLocalService;
	}

	private HeapLocalService _heapLocalService;
}