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

import com.nlu.entity.model.Network;

/**
 * The persistence interface for the network service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see NetworkPersistenceImpl
 * @see NetworkUtil
 * @generated
 */
public interface NetworkPersistence extends BasePersistence<Network> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NetworkUtil} to access the network persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the network in the entity cache if it is enabled.
	*
	* @param network the network
	*/
	public void cacheResult(com.nlu.entity.model.Network network);

	/**
	* Caches the networks in the entity cache if it is enabled.
	*
	* @param networks the networks
	*/
	public void cacheResult(
		java.util.List<com.nlu.entity.model.Network> networks);

	/**
	* Creates a new network with the primary key. Does not add the network to the database.
	*
	* @param networkId the primary key for the new network
	* @return the new network
	*/
	public com.nlu.entity.model.Network create(long networkId);

	/**
	* Removes the network with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param networkId the primary key of the network
	* @return the network that was removed
	* @throws com.nlu.entity.NoSuchNetworkException if a network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Network remove(long networkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchNetworkException;

	public com.nlu.entity.model.Network updateImpl(
		com.nlu.entity.model.Network network)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the network with the primary key or throws a {@link com.nlu.entity.NoSuchNetworkException} if it could not be found.
	*
	* @param networkId the primary key of the network
	* @return the network
	* @throws com.nlu.entity.NoSuchNetworkException if a network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Network findByPrimaryKey(long networkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchNetworkException;

	/**
	* Returns the network with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param networkId the primary key of the network
	* @return the network, or <code>null</code> if a network with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Network fetchByPrimaryKey(long networkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the networks.
	*
	* @return the networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Network> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the networks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of networks
	* @param end the upper bound of the range of networks (not inclusive)
	* @return the range of networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Network> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the networks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of networks
	* @param end the upper bound of the range of networks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of networks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Network> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the networks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of networks.
	*
	* @return the number of networks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}