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
 * Provides a wrapper for {@link AlarmInfoLocalService}.
 *
 * @author NgocBao
 * @see AlarmInfoLocalService
 * @generated
 */
public class AlarmInfoLocalServiceWrapper implements AlarmInfoLocalService,
	ServiceWrapper<AlarmInfoLocalService> {
	public AlarmInfoLocalServiceWrapper(
		AlarmInfoLocalService alarmInfoLocalService) {
		_alarmInfoLocalService = alarmInfoLocalService;
	}

	/**
	* Adds the alarm info to the database. Also notifies the appropriate model listeners.
	*
	* @param alarmInfo the alarm info
	* @return the alarm info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.AlarmInfo addAlarmInfo(
		com.nlu.entity.model.AlarmInfo alarmInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.addAlarmInfo(alarmInfo);
	}

	/**
	* Creates a new alarm info with the primary key. Does not add the alarm info to the database.
	*
	* @param alarmInfoId the primary key for the new alarm info
	* @return the new alarm info
	*/
	@Override
	public com.nlu.entity.model.AlarmInfo createAlarmInfo(long alarmInfoId) {
		return _alarmInfoLocalService.createAlarmInfo(alarmInfoId);
	}

	/**
	* Deletes the alarm info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param alarmInfoId the primary key of the alarm info
	* @return the alarm info that was removed
	* @throws PortalException if a alarm info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.AlarmInfo deleteAlarmInfo(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.deleteAlarmInfo(alarmInfoId);
	}

	/**
	* Deletes the alarm info from the database. Also notifies the appropriate model listeners.
	*
	* @param alarmInfo the alarm info
	* @return the alarm info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.AlarmInfo deleteAlarmInfo(
		com.nlu.entity.model.AlarmInfo alarmInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.deleteAlarmInfo(alarmInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _alarmInfoLocalService.dynamicQuery();
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
		return _alarmInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _alarmInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _alarmInfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _alarmInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _alarmInfoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nlu.entity.model.AlarmInfo fetchAlarmInfo(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.fetchAlarmInfo(alarmInfoId);
	}

	/**
	* Returns the alarm info with the primary key.
	*
	* @param alarmInfoId the primary key of the alarm info
	* @return the alarm info
	* @throws PortalException if a alarm info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.AlarmInfo getAlarmInfo(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.getAlarmInfo(alarmInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the alarm infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alarm infos
	* @param end the upper bound of the range of alarm infos (not inclusive)
	* @return the range of alarm infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.nlu.entity.model.AlarmInfo> getAlarmInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.getAlarmInfos(start, end);
	}

	/**
	* Returns the number of alarm infos.
	*
	* @return the number of alarm infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAlarmInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.getAlarmInfosCount();
	}

	/**
	* Updates the alarm info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param alarmInfo the alarm info
	* @return the alarm info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.AlarmInfo updateAlarmInfo(
		com.nlu.entity.model.AlarmInfo alarmInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.updateAlarmInfo(alarmInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _alarmInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_alarmInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _alarmInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.nlu.entity.model.AlarmInfo addAlarmInfo(java.lang.String name,
		java.lang.String mail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.addAlarmInfo(name, mail, serviceContext);
	}

	@Override
	public com.nlu.entity.model.AlarmInfo updateAlarmInfo(long alarmInfoId,
		java.lang.String name, java.lang.String mail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoLocalService.updateAlarmInfo(alarmInfoId, name, mail,
			serviceContext);
	}

	@Override
	public java.util.List<com.nlu.entity.model.AlarmInfo> findName(
		java.lang.String name) {
		return _alarmInfoLocalService.findName(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AlarmInfoLocalService getWrappedAlarmInfoLocalService() {
		return _alarmInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAlarmInfoLocalService(
		AlarmInfoLocalService alarmInfoLocalService) {
		_alarmInfoLocalService = alarmInfoLocalService;
	}

	@Override
	public AlarmInfoLocalService getWrappedService() {
		return _alarmInfoLocalService;
	}

	@Override
	public void setWrappedService(AlarmInfoLocalService alarmInfoLocalService) {
		_alarmInfoLocalService = alarmInfoLocalService;
	}

	private AlarmInfoLocalService _alarmInfoLocalService;
}