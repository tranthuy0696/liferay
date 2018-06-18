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

import com.liferay.portal.service.persistence.BasePersistence;

import com.service.serviceBuilder.model.Cpu;

/**
 * The persistence interface for the cpu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see CpuPersistenceImpl
 * @see CpuUtil
 * @generated
 */
public interface CpuPersistence extends BasePersistence<Cpu> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CpuUtil} to access the cpu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cpu in the entity cache if it is enabled.
	*
	* @param cpu the cpu
	*/
	public void cacheResult(com.service.serviceBuilder.model.Cpu cpu);

	/**
	* Caches the cpus in the entity cache if it is enabled.
	*
	* @param cpus the cpus
	*/
	public void cacheResult(
		java.util.List<com.service.serviceBuilder.model.Cpu> cpus);

	/**
	* Creates a new cpu with the primary key. Does not add the cpu to the database.
	*
	* @param cpuId the primary key for the new cpu
	* @return the new cpu
	*/
	public com.service.serviceBuilder.model.Cpu create(long cpuId);

	/**
	* Removes the cpu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cpuId the primary key of the cpu
	* @return the cpu that was removed
	* @throws com.service.serviceBuilder.NoSuchCpuException if a cpu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.serviceBuilder.model.Cpu remove(long cpuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.serviceBuilder.NoSuchCpuException;

	public com.service.serviceBuilder.model.Cpu updateImpl(
		com.service.serviceBuilder.model.Cpu cpu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cpu with the primary key or throws a {@link com.service.serviceBuilder.NoSuchCpuException} if it could not be found.
	*
	* @param cpuId the primary key of the cpu
	* @return the cpu
	* @throws com.service.serviceBuilder.NoSuchCpuException if a cpu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.serviceBuilder.model.Cpu findByPrimaryKey(long cpuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.service.serviceBuilder.NoSuchCpuException;

	/**
	* Returns the cpu with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cpuId the primary key of the cpu
	* @return the cpu, or <code>null</code> if a cpu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.service.serviceBuilder.model.Cpu fetchByPrimaryKey(long cpuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cpus.
	*
	* @return the cpus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.service.serviceBuilder.model.Cpu> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.service.serviceBuilder.model.Cpu> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.service.serviceBuilder.model.Cpu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cpus from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cpus.
	*
	* @return the number of cpus
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}