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

package com.nlu.entity.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import com.nlu.entity.model.Network;
import com.nlu.entity.service.base.NetworkLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the network local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.NetworkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.NetworkLocalServiceBaseImpl
 * @see com.nlu.entity.service.NetworkLocalServiceUtil
 */
public class NetworkLocalServiceImpl extends NetworkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.NetworkLocalServiceUtil} to access the network local service.
	 */
	public Network addNetwork( Date time, double down, double up,
		ServiceContext serviceContext) throws SystemException, PortalException {

		long networkId = counterLocalService.increment(Network.class.getName());
		Network network = networkPersistence.create(networkId);

		network.setTime(time);
		network.setDown(down);
		network.setUp(up);
		network.setExpandoBridgeAttributes(serviceContext);

		addNetwork(network);

		return network;
	}

	public Network updateNetwork(long networkId, Date time, double down,
		double up, ServiceContext serviceContext)
		throws SystemException, PortalException {
		Network network = networkPersistence.fetchByPrimaryKey(networkId);

		network.setTime(time);
		network.setDown(down);
		network.setUp(up);
		network.setExpandoBridgeAttributes(serviceContext);

		updateNetwork(network);

		return network;
	}
}