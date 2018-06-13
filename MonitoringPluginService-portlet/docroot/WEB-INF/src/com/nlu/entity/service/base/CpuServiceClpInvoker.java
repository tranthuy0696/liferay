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

package com.nlu.entity.service.base;

import com.nlu.entity.service.CpuServiceUtil;

import java.util.Arrays;

/**
 * @author NgocBao
 * @generated
 */
public class CpuServiceClpInvoker {
	public CpuServiceClpInvoker() {
		_methodName42 = "getBeanIdentifier";

		_methodParameterTypes42 = new String[] {  };

		_methodName43 = "setBeanIdentifier";

		_methodParameterTypes43 = new String[] { "java.lang.String" };

		_methodName48 = "addCpu";

		_methodParameterTypes48 = new String[] {
				"java.util.Date", "double",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName49 = "deleteCpu";

		_methodParameterTypes49 = new String[] { "long" };

		_methodName50 = "getCpu";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "updateCpu";

		_methodParameterTypes51 = new String[] {
				"long", "java.util.Date", "double",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return CpuServiceUtil.getBeanIdentifier();
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			CpuServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return CpuServiceUtil.addCpu((java.util.Date)arguments[0],
				((Double)arguments[1]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			CpuServiceUtil.deleteCpu(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return CpuServiceUtil.getCpu(((Long)arguments[0]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return CpuServiceUtil.updateCpu(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1],
				((Double)arguments[2]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
}