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

package com.nlu.entity.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.nlu.entity.model.AlarmInfo;
import com.nlu.entity.service.AlarmInfoService;
import com.nlu.entity.service.persistence.AlarmFinder;
import com.nlu.entity.service.persistence.AlarmInfoPersistence;
import com.nlu.entity.service.persistence.AlarmPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the alarm info remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nlu.entity.service.impl.AlarmInfoServiceImpl}.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.impl.AlarmInfoServiceImpl
 * @see com.nlu.entity.service.AlarmInfoServiceUtil
 * @generated
 */
public abstract class AlarmInfoServiceBaseImpl extends BaseServiceImpl
	implements AlarmInfoService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.nlu.entity.service.AlarmInfoServiceUtil} to access the alarm info remote service.
	 */

	/**
	 * Returns the alarm local service.
	 *
	 * @return the alarm local service
	 */
	public com.nlu.entity.service.AlarmLocalService getAlarmLocalService() {
		return alarmLocalService;
	}

	/**
	 * Sets the alarm local service.
	 *
	 * @param alarmLocalService the alarm local service
	 */
	public void setAlarmLocalService(
		com.nlu.entity.service.AlarmLocalService alarmLocalService) {
		this.alarmLocalService = alarmLocalService;
	}

	/**
	 * Returns the alarm remote service.
	 *
	 * @return the alarm remote service
	 */
	public com.nlu.entity.service.AlarmService getAlarmService() {
		return alarmService;
	}

	/**
	 * Sets the alarm remote service.
	 *
	 * @param alarmService the alarm remote service
	 */
	public void setAlarmService(
		com.nlu.entity.service.AlarmService alarmService) {
		this.alarmService = alarmService;
	}

	/**
	 * Returns the alarm persistence.
	 *
	 * @return the alarm persistence
	 */
	public AlarmPersistence getAlarmPersistence() {
		return alarmPersistence;
	}

	/**
	 * Sets the alarm persistence.
	 *
	 * @param alarmPersistence the alarm persistence
	 */
	public void setAlarmPersistence(AlarmPersistence alarmPersistence) {
		this.alarmPersistence = alarmPersistence;
	}

	/**
	 * Returns the alarm finder.
	 *
	 * @return the alarm finder
	 */
	public AlarmFinder getAlarmFinder() {
		return alarmFinder;
	}

	/**
	 * Sets the alarm finder.
	 *
	 * @param alarmFinder the alarm finder
	 */
	public void setAlarmFinder(AlarmFinder alarmFinder) {
		this.alarmFinder = alarmFinder;
	}

	/**
	 * Returns the alarm info local service.
	 *
	 * @return the alarm info local service
	 */
	public com.nlu.entity.service.AlarmInfoLocalService getAlarmInfoLocalService() {
		return alarmInfoLocalService;
	}

	/**
	 * Sets the alarm info local service.
	 *
	 * @param alarmInfoLocalService the alarm info local service
	 */
	public void setAlarmInfoLocalService(
		com.nlu.entity.service.AlarmInfoLocalService alarmInfoLocalService) {
		this.alarmInfoLocalService = alarmInfoLocalService;
	}

	/**
	 * Returns the alarm info remote service.
	 *
	 * @return the alarm info remote service
	 */
	public com.nlu.entity.service.AlarmInfoService getAlarmInfoService() {
		return alarmInfoService;
	}

	/**
	 * Sets the alarm info remote service.
	 *
	 * @param alarmInfoService the alarm info remote service
	 */
	public void setAlarmInfoService(
		com.nlu.entity.service.AlarmInfoService alarmInfoService) {
		this.alarmInfoService = alarmInfoService;
	}

	/**
	 * Returns the alarm info persistence.
	 *
	 * @return the alarm info persistence
	 */
	public AlarmInfoPersistence getAlarmInfoPersistence() {
		return alarmInfoPersistence;
	}

	/**
	 * Sets the alarm info persistence.
	 *
	 * @param alarmInfoPersistence the alarm info persistence
	 */
	public void setAlarmInfoPersistence(
		AlarmInfoPersistence alarmInfoPersistence) {
		this.alarmInfoPersistence = alarmInfoPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return AlarmInfo.class;
	}

	protected String getModelClassName() {
		return AlarmInfo.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = alarmInfoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.nlu.entity.service.AlarmLocalService.class)
	protected com.nlu.entity.service.AlarmLocalService alarmLocalService;
	@BeanReference(type = com.nlu.entity.service.AlarmService.class)
	protected com.nlu.entity.service.AlarmService alarmService;
	@BeanReference(type = AlarmPersistence.class)
	protected AlarmPersistence alarmPersistence;
	@BeanReference(type = AlarmFinder.class)
	protected AlarmFinder alarmFinder;
	@BeanReference(type = com.nlu.entity.service.AlarmInfoLocalService.class)
	protected com.nlu.entity.service.AlarmInfoLocalService alarmInfoLocalService;
	@BeanReference(type = com.nlu.entity.service.AlarmInfoService.class)
	protected com.nlu.entity.service.AlarmInfoService alarmInfoService;
	@BeanReference(type = AlarmInfoPersistence.class)
	protected AlarmInfoPersistence alarmInfoPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private AlarmInfoServiceClpInvoker _clpInvoker = new AlarmInfoServiceClpInvoker();
}