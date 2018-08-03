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

package com.nlu.entity.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.nlu.entity.model.AlarmInfo;
import com.nlu.entity.service.AlarmInfoLocalServiceUtil;

/**
 * The extended model base implementation for the AlarmInfo service. Represents a row in the &quot;AlarmInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AlarmInfoImpl}.
 * </p>
 *
 * @author NgocBao
 * @see AlarmInfoImpl
 * @see com.nlu.entity.model.AlarmInfo
 * @generated
 */
public abstract class AlarmInfoBaseImpl extends AlarmInfoModelImpl
	implements AlarmInfo {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a alarm info model instance should use the {@link AlarmInfo} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AlarmInfoLocalServiceUtil.addAlarmInfo(this);
		}
		else {
			AlarmInfoLocalServiceUtil.updateAlarmInfo(this);
		}
	}
}