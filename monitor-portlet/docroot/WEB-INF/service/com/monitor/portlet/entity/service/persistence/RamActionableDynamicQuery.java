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

package com.monitor.portlet.entity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.monitor.portlet.entity.model.Ram;
import com.monitor.portlet.entity.service.RamLocalServiceUtil;

/**
 * @author thuthuy
 * @generated
 */
public abstract class RamActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public RamActionableDynamicQuery() throws SystemException {
		setBaseLocalService(RamLocalServiceUtil.getService());
		setClass(Ram.class);

		setClassLoader(com.monitor.portlet.entity.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("ramId");
	}
}