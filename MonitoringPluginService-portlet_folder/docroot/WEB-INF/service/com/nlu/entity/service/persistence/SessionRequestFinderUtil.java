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
public class SessionRequestFinderUtil {
	public static void deleteSessionRequestByDate(int numberDate) {
		getFinder().deleteSessionRequestByDate(numberDate);
	}

	public static java.util.List<com.nlu.entity.model.SessionRequest> searchSessionRequestByDate(
		java.lang.String date) {
		return getFinder().searchSessionRequestByDate(date);
	}

	public static java.util.List getListSessionRequestReportByDate(
		java.lang.String columnName, java.lang.String date) {
		return getFinder().getListSessionRequestReportByDate(columnName, date);
	}

	public static SessionRequestFinder getFinder() {
		if (_finder == null) {
			_finder = (SessionRequestFinder)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					SessionRequestFinder.class.getName());

			ReferenceRegistry.registerReference(SessionRequestFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SessionRequestFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SessionRequestFinderUtil.class,
			"_finder");
	}

	private static SessionRequestFinder _finder;
}