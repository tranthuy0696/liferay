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
public class HeapFinderUtil {
	public static void deleteHeapByDate(int numberDate) {
		getFinder().deleteHeapByDate(numberDate);
	}

	public static HeapFinder getFinder() {
		if (_finder == null) {
			_finder = (HeapFinder)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					HeapFinder.class.getName());

			ReferenceRegistry.registerReference(HeapFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(HeapFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HeapFinderUtil.class, "_finder");
	}

	private static HeapFinder _finder;
}