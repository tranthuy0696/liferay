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
 * Provides a wrapper for {@link diachiLocalService}.
 *
 * @author NgocBao
 * @see diachiLocalService
 * @generated
 */
public class diachiLocalServiceWrapper implements diachiLocalService,
	ServiceWrapper<diachiLocalService> {
	public diachiLocalServiceWrapper(diachiLocalService diachiLocalService) {
		_diachiLocalService = diachiLocalService;
	}

	/**
	* Adds the diachi to the database. Also notifies the appropriate model listeners.
	*
	* @param diachi the diachi
	* @return the diachi that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.diachi adddiachi(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.adddiachi(diachi);
	}

	/**
	* Creates a new diachi with the primary key. Does not add the diachi to the database.
	*
	* @param id the primary key for the new diachi
	* @return the new diachi
	*/
	@Override
	public com.nlu.entity.model.diachi creatediachi(long id) {
		return _diachiLocalService.creatediachi(id);
	}

	/**
	* Deletes the diachi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the diachi
	* @return the diachi that was removed
	* @throws PortalException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.diachi deletediachi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.deletediachi(id);
	}

	/**
	* Deletes the diachi from the database. Also notifies the appropriate model listeners.
	*
	* @param diachi the diachi
	* @return the diachi that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.diachi deletediachi(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.deletediachi(diachi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _diachiLocalService.dynamicQuery();
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
		return _diachiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _diachiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _diachiLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _diachiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _diachiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nlu.entity.model.diachi fetchdiachi(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.fetchdiachi(id);
	}

	/**
	* Returns the diachi with the primary key.
	*
	* @param id the primary key of the diachi
	* @return the diachi
	* @throws PortalException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.diachi getdiachi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.getdiachi(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the diachis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of diachis
	* @param end the upper bound of the range of diachis (not inclusive)
	* @return the range of diachis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.nlu.entity.model.diachi> getdiachis(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.getdiachis(start, end);
	}

	/**
	* Returns the number of diachis.
	*
	* @return the number of diachis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getdiachisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.getdiachisCount();
	}

	/**
	* Updates the diachi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param diachi the diachi
	* @return the diachi that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.diachi updatediachi(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.updatediachi(diachi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _diachiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_diachiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _diachiLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.diachi adddiachi(long userId, long id,
		java.lang.String tinh, java.lang.String huyen, java.lang.String xa,
		java.lang.String duong, java.lang.String duongKhac,
		java.lang.String khuPho, java.lang.String soNha,
		java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.adddiachi(userId, id, tinh, huyen, xa,
			duong, duongKhac, khuPho, soNha, quocGia, serviceContext);
	}

	@Override
	public com.nlu.entity.model.diachi updatediachi(long diachiId, long id,
		java.lang.String tinh, java.lang.String huyen, java.lang.String xa,
		java.lang.String duong, java.lang.String duongKhac,
		java.lang.String khuPho, java.lang.String soNha,
		java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.updatediachi(diachiId, id, tinh, huyen, xa,
			duong, duongKhac, khuPho, soNha, quocGia, serviceContext);
	}

	@Override
	public com.nlu.entity.model.diachi fetchByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.fetchByID(id);
	}

	@Override
	public com.nlu.entity.model.diachi findByID(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiLocalService.findByID(id);
	}

	@Override
	public void removeByID(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_diachiLocalService.removeByID(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public diachiLocalService getWrappeddiachiLocalService() {
		return _diachiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappeddiachiLocalService(
		diachiLocalService diachiLocalService) {
		_diachiLocalService = diachiLocalService;
	}

	@Override
	public diachiLocalService getWrappedService() {
		return _diachiLocalService;
	}

	@Override
	public void setWrappedService(diachiLocalService diachiLocalService) {
		_diachiLocalService = diachiLocalService;
	}

	private diachiLocalService _diachiLocalService;
}