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

package com.service.serviceBuilder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.service.serviceBuilder.model.Cpu;

import java.util.List;

/**
 * The persistence utility for the cpu service. This utility wraps {@link CpuPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see CpuPersistence
 * @see CpuPersistenceImpl
 * @generated
 */
public class CpuUtil {
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
	public static void clearCache(Cpu cpu) {
		getPersistence().clearCache(cpu);
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
	public static List<Cpu> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cpu> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cpu> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Cpu update(Cpu cpu) throws SystemException {
		return getPersistence().update(cpu);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Cpu update(Cpu cpu, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cpu, serviceContext);
	}

	/**
	* Caches the cpu in the entity cache if it is enabled.
	*
	* @param cpu the cpu
	*/
	public static void cacheResult(com.service.serviceBuilder.model.Cpu cpu) {
		getPersistence().cacheResult(cpu);
	}

	/**
	* Caches the cpus in the entity cache if it is enabled.
	*
	* @param cpus the cpus
	*/
	public static void cacheResult(
		java.util.List<com.service.serviceBuilder.model.Cpu> cpus) {
		getPersistence().cacheResult(cpus);
	}

	/**
	* Creates a new cpu with the primary key. Does not add the cpu to the database.
	*
	* @param cpuId the primary key for the new cpu
	* @return the new cpu
	*/
	public static com.service.serviceBuilder.model.Cpu create(long cpuId) {
		return getPersistence().create(cpuId);
	}

	/**
	* Removes the cpu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cpuId the primary key of the cpu
	* @return the cpu that was removed
	* @throws com.service.serviceBuilder.NoSuchCpuException if a cpu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.serviceBuilder.model.Cpu remove(long cpuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.serviceBuilder.NoSuchCpuException {
		return getPersistence().remove(cpuId);
	}

	public static com.service.serviceBuilder.model.Cpu updateImpl(
		com.service.serviceBuilder.model.Cpu cpu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cpu);
	}

	/**
	* Returns the cpu with the primary key or throws a {@link com.service.serviceBuilder.NoSuchCpuException} if it could not be found.
	*
	* @param cpuId the primary key of the cpu
	* @return the cpu
	* @throws com.service.serviceBuilder.NoSuchCpuException if a cpu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.serviceBuilder.model.Cpu findByPrimaryKey(
		long cpuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.serviceBuilder.NoSuchCpuException {
		return getPersistence().findByPrimaryKey(cpuId);
	}

	/**
	* Returns the cpu with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cpuId the primary key of the cpu
	* @return the cpu, or <code>null</code> if a cpu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.service.serviceBuilder.model.Cpu fetchByPrimaryKey(
		long cpuId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cpuId);
	}

	/**
	* Returns all the cpus.
	*
	* @return the cpus
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.serviceBuilder.model.Cpu> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cpus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.serviceBuilder.model.impl.CpuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cpus
	* @param end the upper bound of the range of cpus (not inclusive)
	* @return the range of cpus
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.serviceBuilder.model.Cpu> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cpus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.service.serviceBuilder.model.impl.CpuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cpus
	* @param end the upper bound of the range of cpus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cpus
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.service.serviceBuilder.model.Cpu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cpus from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cpus.
	*
	* @return the number of cpus
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CpuPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CpuPersistence)PortletBeanLocatorUtil.locate(com.service.serviceBuilder.service.ClpSerializer.getServletContextName(),
					CpuPersistence.class.getName());

			ReferenceRegistry.registerReference(CpuUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CpuPersistence persistence) {
	}

	private static CpuPersistence _persistence;
}