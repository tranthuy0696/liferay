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

import com.nlu.entity.service.SessionRequestLocalServiceUtil;

import java.util.Arrays;

/**
 * @author NgocBao
 * @generated
 */
public class SessionRequestLocalServiceClpInvoker {
	public SessionRequestLocalServiceClpInvoker() {
		_methodName0 = "addSessionRequest";

		_methodParameterTypes0 = new String[] {
				"com.nlu.entity.model.SessionRequest"
			};

		_methodName1 = "createSessionRequest";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSessionRequest";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSessionRequest";

		_methodParameterTypes3 = new String[] {
				"com.nlu.entity.model.SessionRequest"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSessionRequest";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSessionRequest";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSessionRequests";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSessionRequestsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSessionRequest";

		_methodParameterTypes15 = new String[] {
				"com.nlu.entity.model.SessionRequest"
			};

		_methodName76 = "getBeanIdentifier";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "setBeanIdentifier";

		_methodParameterTypes77 = new String[] { "java.lang.String" };

		_methodName82 = "addSessionRequest";

		_methodParameterTypes82 = new String[] {
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName83 = "updateSessionRequest";

		_methodParameterTypes83 = new String[] {
				"long", "java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName84 = "findAll";

		_methodParameterTypes84 = new String[] {  };

		_methodName85 = "deleteSessionRequestByDate";

		_methodParameterTypes85 = new String[] { "int" };

		_methodName86 = "searchSessionRequestByDate";

		_methodParameterTypes86 = new String[] { "java.lang.String" };

		_methodName87 = "getSessionReportByDate";

		_methodParameterTypes87 = new String[] {
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SessionRequestLocalServiceUtil.addSessionRequest((com.nlu.entity.model.SessionRequest)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SessionRequestLocalServiceUtil.createSessionRequest(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SessionRequestLocalServiceUtil.deleteSessionRequest(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SessionRequestLocalServiceUtil.deleteSessionRequest((com.nlu.entity.model.SessionRequest)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SessionRequestLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SessionRequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SessionRequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SessionRequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SessionRequestLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SessionRequestLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SessionRequestLocalServiceUtil.fetchSessionRequest(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SessionRequestLocalServiceUtil.getSessionRequest(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SessionRequestLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SessionRequestLocalServiceUtil.getSessionRequests(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SessionRequestLocalServiceUtil.getSessionRequestsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SessionRequestLocalServiceUtil.updateSessionRequest((com.nlu.entity.model.SessionRequest)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SessionRequestLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			SessionRequestLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SessionRequestLocalServiceUtil.addSessionRequest((java.lang.String)arguments[0],
				(java.util.Date)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SessionRequestLocalServiceUtil.updateSessionRequest(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SessionRequestLocalServiceUtil.findAll();
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			SessionRequestLocalServiceUtil.deleteSessionRequestByDate(((Integer)arguments[0]).intValue());

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SessionRequestLocalServiceUtil.searchSessionRequestByDate((java.lang.String)arguments[0]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SessionRequestLocalServiceUtil.getSessionReportByDate((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
}