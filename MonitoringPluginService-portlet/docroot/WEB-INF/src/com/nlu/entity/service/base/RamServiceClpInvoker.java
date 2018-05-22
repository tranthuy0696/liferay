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

import com.nlu.entity.service.RamServiceUtil;

import java.util.Arrays;

/**
 * @author NgocBao
 * @generated
 */
public class RamServiceClpInvoker {
	public RamServiceClpInvoker() {
		_methodName24 = "getBeanIdentifier";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "setBeanIdentifier";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName30 = "addRam";

		_methodParameterTypes30 = new String[] {
				"java.util.Date", "double", "double", "double",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName31 = "deleteRam";

		_methodParameterTypes31 = new String[] { "long" };

		_methodName32 = "getRam";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "updateRam";

		_methodParameterTypes33 = new String[] {
				"long", "java.util.Date", "double", "double", "double",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return RamServiceUtil.getBeanIdentifier();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			RamServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return RamServiceUtil.addRam((java.util.Date)arguments[0],
				((Double)arguments[1]).doubleValue(),
				((Double)arguments[2]).doubleValue(),
				((Double)arguments[3]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			RamServiceUtil.deleteRam(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return RamServiceUtil.getRam(((Long)arguments[0]).longValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return RamServiceUtil.updateRam(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1],
				((Double)arguments[2]).doubleValue(),
				((Double)arguments[3]).doubleValue(),
				((Double)arguments[4]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
}