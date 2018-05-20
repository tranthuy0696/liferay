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

package com.monitor.portlet.entity.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.monitor.portlet.entity.model.Foo;
import com.monitor.portlet.entity.service.base.FooLocalServiceBaseImpl;

/**
 * The implementation of the foo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.monitor.portlet.entity.service.FooLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author thuthuy
 * @see com.monitor.portlet.entity.service.base.FooLocalServiceBaseImpl
 * @see com.monitor.portlet.entity.service.FooLocalServiceUtil
 */
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {
	public List<Foo> findAll() throws SystemException{
		return fooPersistence.findAll();
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.monitor.portlet.entity.service.FooLocalServiceUtil} to access the foo local service.
	 */
}