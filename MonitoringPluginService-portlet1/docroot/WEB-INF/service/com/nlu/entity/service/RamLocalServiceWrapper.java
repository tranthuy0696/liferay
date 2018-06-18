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
 * Provides a wrapper for {@link RamLocalService}.
 *
 * @author NgocBao
 * @see RamLocalService
 * @generated
 */
public class RamLocalServiceWrapper implements RamLocalService,
	ServiceWrapper<RamLocalService> {
	public RamLocalServiceWrapper(RamLocalService ramLocalService) {
		_ramLocalService = ramLocalService;
	}

	/**
	* Adds the ram to the database. Also notifies the appropriate model listeners.
	*
	* @param ram the ram
	* @return the ram that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Ram addRam(com.nlu.entity.model.Ram ram)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.addRam(ram);
	}

	/**
	* Creates a new ram with the primary key. Does not add the ram to the database.
	*
	* @param ramId the primary key for the new ram
	* @return the new ram
	*/
	@Override
	public com.nlu.entity.model.Ram createRam(long ramId) {
		return _ramLocalService.createRam(ramId);
	}

	/**
	* Deletes the ram with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ramId the primary key of the ram
	* @return the ram that was removed
	* @throws PortalException if a ram with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Ram deleteRam(long ramId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.deleteRam(ramId);
	}

	/**
	* Deletes the ram from the database. Also notifies the appropriate model listeners.
	*
	* @param ram the ram
	* @return the ram that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Ram deleteRam(com.nlu.entity.model.Ram ram)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.deleteRam(ram);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ramLocalService.dynamicQuery();
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
		return _ramLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ramLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ramLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ramLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ramLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nlu.entity.model.Ram fetchRam(long ramId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.fetchRam(ramId);
	}

	/**
	* Returns the ram with the primary key.
	*
	* @param ramId the primary key of the ram
	* @return the ram
	* @throws PortalException if a ram with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Ram getRam(long ramId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.getRam(ramId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the rams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rams
	* @param end the upper bound of the range of rams (not inclusive)
	* @return the range of rams
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.nlu.entity.model.Ram> getRams(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.getRams(start, end);
	}

	/**
	* Returns the number of rams.
	*
	* @return the number of rams
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRamsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.getRamsCount();
	}

	/**
	* Updates the ram in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ram the ram
	* @return the ram that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Ram updateRam(com.nlu.entity.model.Ram ram)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.updateRam(ram);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ramLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ramLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ramLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.Ram addRam(java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.addRam(time, value, serviceContext);
	}

	@Override
	public com.nlu.entity.model.Ram updateRam(long ramId, java.util.Date time,
		double value, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.updateRam(ramId, time, value, serviceContext);
	}

	@Override
	public java.util.List<com.nlu.entity.model.Ram> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.findAll();
	}

	@Override
	public int countByDate(java.util.Date time)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.countByDate(time);
	}

	@Override
	public java.util.List<com.nlu.entity.model.Ram> findByDate(
		java.util.Date time)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.findByDate(time);
	}

	@Override
	public java.util.List<com.nlu.entity.model.Ram> findByDate(
		java.util.Date time, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.findByDate(time, start, end);
	}

	@Override
	public java.util.List<com.nlu.entity.model.Ram> findByDate(
		java.util.Date time, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ramLocalService.findByDate(time, start, end, obc);
	}

	@Override
	public void removeByDate(java.util.Date time)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ramLocalService.removeByDate(time);
	}

	@Override
	public java.util.List<com.nlu.entity.model.Ram> getRamByDate(
		java.util.Date date) {
		return _ramLocalService.getRamByDate(date);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RamLocalService getWrappedRamLocalService() {
		return _ramLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRamLocalService(RamLocalService ramLocalService) {
		_ramLocalService = ramLocalService;
	}

	@Override
	public RamLocalService getWrappedService() {
		return _ramLocalService;
	}

	@Override
	public void setWrappedService(RamLocalService ramLocalService) {
		_ramLocalService = ramLocalService;
	}

	private RamLocalService _ramLocalService;
}