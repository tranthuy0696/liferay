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

import com.nlu.entity.model.SessionRequest;
import com.nlu.entity.service.SessionRequestService;
import com.nlu.entity.service.persistence.CpuPersistence;
import com.nlu.entity.service.persistence.HeapPersistence;
import com.nlu.entity.service.persistence.NonHeapPersistence;
import com.nlu.entity.service.persistence.RamPersistence;
import com.nlu.entity.service.persistence.SessionRequestPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the session request remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.nlu.entity.service.impl.SessionRequestServiceImpl}.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.impl.SessionRequestServiceImpl
 * @see com.nlu.entity.service.SessionRequestServiceUtil
 * @generated
 */
public abstract class SessionRequestServiceBaseImpl extends BaseServiceImpl
	implements SessionRequestService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.nlu.entity.service.SessionRequestServiceUtil} to access the session request remote service.
	 */

	/**
	 * Returns the cpu local service.
	 *
	 * @return the cpu local service
	 */
	public com.nlu.entity.service.CpuLocalService getCpuLocalService() {
		return cpuLocalService;
	}

	/**
	 * Sets the cpu local service.
	 *
	 * @param cpuLocalService the cpu local service
	 */
	public void setCpuLocalService(
		com.nlu.entity.service.CpuLocalService cpuLocalService) {
		this.cpuLocalService = cpuLocalService;
	}

	/**
	 * Returns the cpu remote service.
	 *
	 * @return the cpu remote service
	 */
	public com.nlu.entity.service.CpuService getCpuService() {
		return cpuService;
	}

	/**
	 * Sets the cpu remote service.
	 *
	 * @param cpuService the cpu remote service
	 */
	public void setCpuService(com.nlu.entity.service.CpuService cpuService) {
		this.cpuService = cpuService;
	}

	/**
	 * Returns the cpu persistence.
	 *
	 * @return the cpu persistence
	 */
	public CpuPersistence getCpuPersistence() {
		return cpuPersistence;
	}

	/**
	 * Sets the cpu persistence.
	 *
	 * @param cpuPersistence the cpu persistence
	 */
	public void setCpuPersistence(CpuPersistence cpuPersistence) {
		this.cpuPersistence = cpuPersistence;
	}

	/**
	 * Returns the heap local service.
	 *
	 * @return the heap local service
	 */
	public com.nlu.entity.service.HeapLocalService getHeapLocalService() {
		return heapLocalService;
	}

	/**
	 * Sets the heap local service.
	 *
	 * @param heapLocalService the heap local service
	 */
	public void setHeapLocalService(
		com.nlu.entity.service.HeapLocalService heapLocalService) {
		this.heapLocalService = heapLocalService;
	}

	/**
	 * Returns the heap remote service.
	 *
	 * @return the heap remote service
	 */
	public com.nlu.entity.service.HeapService getHeapService() {
		return heapService;
	}

	/**
	 * Sets the heap remote service.
	 *
	 * @param heapService the heap remote service
	 */
	public void setHeapService(com.nlu.entity.service.HeapService heapService) {
		this.heapService = heapService;
	}

	/**
	 * Returns the heap persistence.
	 *
	 * @return the heap persistence
	 */
	public HeapPersistence getHeapPersistence() {
		return heapPersistence;
	}

	/**
	 * Sets the heap persistence.
	 *
	 * @param heapPersistence the heap persistence
	 */
	public void setHeapPersistence(HeapPersistence heapPersistence) {
		this.heapPersistence = heapPersistence;
	}

	/**
	 * Returns the non heap local service.
	 *
	 * @return the non heap local service
	 */
	public com.nlu.entity.service.NonHeapLocalService getNonHeapLocalService() {
		return nonHeapLocalService;
	}

	/**
	 * Sets the non heap local service.
	 *
	 * @param nonHeapLocalService the non heap local service
	 */
	public void setNonHeapLocalService(
		com.nlu.entity.service.NonHeapLocalService nonHeapLocalService) {
		this.nonHeapLocalService = nonHeapLocalService;
	}

	/**
	 * Returns the non heap remote service.
	 *
	 * @return the non heap remote service
	 */
	public com.nlu.entity.service.NonHeapService getNonHeapService() {
		return nonHeapService;
	}

	/**
	 * Sets the non heap remote service.
	 *
	 * @param nonHeapService the non heap remote service
	 */
	public void setNonHeapService(
		com.nlu.entity.service.NonHeapService nonHeapService) {
		this.nonHeapService = nonHeapService;
	}

	/**
	 * Returns the non heap persistence.
	 *
	 * @return the non heap persistence
	 */
	public NonHeapPersistence getNonHeapPersistence() {
		return nonHeapPersistence;
	}

	/**
	 * Sets the non heap persistence.
	 *
	 * @param nonHeapPersistence the non heap persistence
	 */
	public void setNonHeapPersistence(NonHeapPersistence nonHeapPersistence) {
		this.nonHeapPersistence = nonHeapPersistence;
	}

	/**
	 * Returns the ram local service.
	 *
	 * @return the ram local service
	 */
	public com.nlu.entity.service.RamLocalService getRamLocalService() {
		return ramLocalService;
	}

	/**
	 * Sets the ram local service.
	 *
	 * @param ramLocalService the ram local service
	 */
	public void setRamLocalService(
		com.nlu.entity.service.RamLocalService ramLocalService) {
		this.ramLocalService = ramLocalService;
	}

	/**
	 * Returns the ram remote service.
	 *
	 * @return the ram remote service
	 */
	public com.nlu.entity.service.RamService getRamService() {
		return ramService;
	}

	/**
	 * Sets the ram remote service.
	 *
	 * @param ramService the ram remote service
	 */
	public void setRamService(com.nlu.entity.service.RamService ramService) {
		this.ramService = ramService;
	}

	/**
	 * Returns the ram persistence.
	 *
	 * @return the ram persistence
	 */
	public RamPersistence getRamPersistence() {
		return ramPersistence;
	}

	/**
	 * Sets the ram persistence.
	 *
	 * @param ramPersistence the ram persistence
	 */
	public void setRamPersistence(RamPersistence ramPersistence) {
		this.ramPersistence = ramPersistence;
	}

	/**
	 * Returns the session request local service.
	 *
	 * @return the session request local service
	 */
	public com.nlu.entity.service.SessionRequestLocalService getSessionRequestLocalService() {
		return sessionRequestLocalService;
	}

	/**
	 * Sets the session request local service.
	 *
	 * @param sessionRequestLocalService the session request local service
	 */
	public void setSessionRequestLocalService(
		com.nlu.entity.service.SessionRequestLocalService sessionRequestLocalService) {
		this.sessionRequestLocalService = sessionRequestLocalService;
	}

	/**
	 * Returns the session request remote service.
	 *
	 * @return the session request remote service
	 */
	public com.nlu.entity.service.SessionRequestService getSessionRequestService() {
		return sessionRequestService;
	}

	/**
	 * Sets the session request remote service.
	 *
	 * @param sessionRequestService the session request remote service
	 */
	public void setSessionRequestService(
		com.nlu.entity.service.SessionRequestService sessionRequestService) {
		this.sessionRequestService = sessionRequestService;
	}

	/**
	 * Returns the session request persistence.
	 *
	 * @return the session request persistence
	 */
	public SessionRequestPersistence getSessionRequestPersistence() {
		return sessionRequestPersistence;
	}

	/**
	 * Sets the session request persistence.
	 *
	 * @param sessionRequestPersistence the session request persistence
	 */
	public void setSessionRequestPersistence(
		SessionRequestPersistence sessionRequestPersistence) {
		this.sessionRequestPersistence = sessionRequestPersistence;
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

		com.nlu.entity.service.SessionRequestServiceUtil.clearService();
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
		return SessionRequest.class;
	}

	protected String getModelClassName() {
		return SessionRequest.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = sessionRequestPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.nlu.entity.service.CpuLocalService.class)
	protected com.nlu.entity.service.CpuLocalService cpuLocalService;
	@BeanReference(type = com.nlu.entity.service.CpuService.class)
	protected com.nlu.entity.service.CpuService cpuService;
	@BeanReference(type = CpuPersistence.class)
	protected CpuPersistence cpuPersistence;
	@BeanReference(type = com.nlu.entity.service.HeapLocalService.class)
	protected com.nlu.entity.service.HeapLocalService heapLocalService;
	@BeanReference(type = com.nlu.entity.service.HeapService.class)
	protected com.nlu.entity.service.HeapService heapService;
	@BeanReference(type = HeapPersistence.class)
	protected HeapPersistence heapPersistence;
	@BeanReference(type = com.nlu.entity.service.NonHeapLocalService.class)
	protected com.nlu.entity.service.NonHeapLocalService nonHeapLocalService;
	@BeanReference(type = com.nlu.entity.service.NonHeapService.class)
	protected com.nlu.entity.service.NonHeapService nonHeapService;
	@BeanReference(type = NonHeapPersistence.class)
	protected NonHeapPersistence nonHeapPersistence;
	@BeanReference(type = com.nlu.entity.service.RamLocalService.class)
	protected com.nlu.entity.service.RamLocalService ramLocalService;
	@BeanReference(type = com.nlu.entity.service.RamService.class)
	protected com.nlu.entity.service.RamService ramService;
	@BeanReference(type = RamPersistence.class)
	protected RamPersistence ramPersistence;
	@BeanReference(type = com.nlu.entity.service.SessionRequestLocalService.class)
	protected com.nlu.entity.service.SessionRequestLocalService sessionRequestLocalService;
	@BeanReference(type = com.nlu.entity.service.SessionRequestService.class)
	protected com.nlu.entity.service.SessionRequestService sessionRequestService;
	@BeanReference(type = SessionRequestPersistence.class)
	protected SessionRequestPersistence sessionRequestPersistence;
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
	private SessionRequestServiceClpInvoker _clpInvoker = new SessionRequestServiceClpInvoker();
}