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

import com.nlu.entity.service.SessionRequestServiceUtil;

import java.util.Arrays;

/**
 * @author NgocBao
 * @generated
 */
public class SessionRequestServiceClpInvoker {
	public SessionRequestServiceClpInvoker() {
		_methodName42 = "getBeanIdentifier";

		_methodParameterTypes42 = new String[] {  };

		_methodName43 = "setBeanIdentifier";

		_methodParameterTypes43 = new String[] { "java.lang.String" };

		_methodName48 = "addSessionRequest";

		_methodParameterTypes48 = new String[] {
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName49 = "deleteSessionRequest";

		_methodParameterTypes49 = new String[] { "long" };

		_methodName50 = "getSessionRequest";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "updateSessionRequest";

		_methodParameterTypes51 = new String[] {
				"long", "java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SessionRequestServiceUtil.getBeanIdentifier();
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			SessionRequestServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return SessionRequestServiceUtil.addSessionRequest((java.lang.String)arguments[0],
				(java.util.Date)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			SessionRequestServiceUtil.deleteSessionRequest(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return SessionRequestServiceUtil.getSessionRequest(((Long)arguments[0]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return SessionRequestServiceUtil.updateSessionRequest(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
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