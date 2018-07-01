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

package com.nlu.entity.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Network}.
 * </p>
 *
 * @author NgocBao
 * @see Network
 * @generated
 */
public class NetworkWrapper implements Network, ModelWrapper<Network> {
	public NetworkWrapper(Network network) {
		_network = network;
	}

	@Override
	public Class<?> getModelClass() {
		return Network.class;
	}

	@Override
	public String getModelClassName() {
		return Network.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("networkId", getNetworkId());
		attributes.put("time", getTime());
		attributes.put("down", getDown());
		attributes.put("up", getUp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long networkId = (Long)attributes.get("networkId");

		if (networkId != null) {
			setNetworkId(networkId);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		Double down = (Double)attributes.get("down");

		if (down != null) {
			setDown(down);
		}

		Double up = (Double)attributes.get("up");

		if (up != null) {
			setUp(up);
		}
	}

	/**
	* Returns the primary key of this network.
	*
	* @return the primary key of this network
	*/
	@Override
	public long getPrimaryKey() {
		return _network.getPrimaryKey();
	}

	/**
	* Sets the primary key of this network.
	*
	* @param primaryKey the primary key of this network
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_network.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the network ID of this network.
	*
	* @return the network ID of this network
	*/
	@Override
	public long getNetworkId() {
		return _network.getNetworkId();
	}

	/**
	* Sets the network ID of this network.
	*
	* @param networkId the network ID of this network
	*/
	@Override
	public void setNetworkId(long networkId) {
		_network.setNetworkId(networkId);
	}

	/**
	* Returns the time of this network.
	*
	* @return the time of this network
	*/
	@Override
	public java.util.Date getTime() {
		return _network.getTime();
	}

	/**
	* Sets the time of this network.
	*
	* @param time the time of this network
	*/
	@Override
	public void setTime(java.util.Date time) {
		_network.setTime(time);
	}

	/**
	* Returns the down of this network.
	*
	* @return the down of this network
	*/
	@Override
	public double getDown() {
		return _network.getDown();
	}

	/**
	* Sets the down of this network.
	*
	* @param down the down of this network
	*/
	@Override
	public void setDown(double down) {
		_network.setDown(down);
	}

	/**
	* Returns the up of this network.
	*
	* @return the up of this network
	*/
	@Override
	public double getUp() {
		return _network.getUp();
	}

	/**
	* Sets the up of this network.
	*
	* @param up the up of this network
	*/
	@Override
	public void setUp(double up) {
		_network.setUp(up);
	}

	@Override
	public boolean isNew() {
		return _network.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_network.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _network.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_network.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _network.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _network.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_network.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _network.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_network.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_network.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_network.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NetworkWrapper((Network)_network.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.Network network) {
		return _network.compareTo(network);
	}

	@Override
	public int hashCode() {
		return _network.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.Network> toCacheModel() {
		return _network.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.Network toEscapedModel() {
		return new NetworkWrapper(_network.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.Network toUnescapedModel() {
		return new NetworkWrapper(_network.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _network.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _network.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_network.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NetworkWrapper)) {
			return false;
		}

		NetworkWrapper networkWrapper = (NetworkWrapper)obj;

		if (Validator.equals(_network, networkWrapper._network)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Network getWrappedNetwork() {
		return _network;
	}

	@Override
	public Network getWrappedModel() {
		return _network;
	}

	@Override
	public void resetOriginalValues() {
		_network.resetOriginalValues();
	}

	private Network _network;
}