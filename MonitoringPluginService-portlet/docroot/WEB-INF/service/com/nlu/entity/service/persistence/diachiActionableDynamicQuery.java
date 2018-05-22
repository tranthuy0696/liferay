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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.nlu.entity.model.diachi;
import com.nlu.entity.service.diachiLocalServiceUtil;

/**
 * @author NgocBao
 * @generated
 */
public abstract class diachiActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public diachiActionableDynamicQuery() throws SystemException {
		setBaseLocalService(diachiLocalServiceUtil.getService());
		setClass(diachi.class);

		setClassLoader(com.nlu.entity.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}