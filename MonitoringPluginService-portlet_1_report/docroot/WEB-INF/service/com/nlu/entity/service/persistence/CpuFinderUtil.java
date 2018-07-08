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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author NgocBao
 */
public class CpuFinderUtil {
	public static void deleteCpuByDate(int numberDate) {
		getFinder().deleteCpuByDate(numberDate);
	}

	public static CpuFinder getFinder() {
		if (_finder == null) {
			_finder = (CpuFinder)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					CpuFinder.class.getName());

			ReferenceRegistry.registerReference(CpuFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(CpuFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CpuFinderUtil.class, "_finder");
	}

	private static CpuFinder _finder;
}