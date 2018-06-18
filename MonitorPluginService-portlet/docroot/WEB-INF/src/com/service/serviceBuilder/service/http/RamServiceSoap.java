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

package com.service.serviceBuilder.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.service.serviceBuilder.service.RamServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.service.serviceBuilder.service.RamServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.service.serviceBuilder.model.RamSoap}.
 * If the method in the service utility returns a
 * {@link com.service.serviceBuilder.model.Ram}, that is translated to a
 * {@link com.service.serviceBuilder.model.RamSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author NgocBao
 * @see RamServiceHttp
 * @see com.service.serviceBuilder.model.RamSoap
 * @see com.service.serviceBuilder.service.RamServiceUtil
 * @generated
 */
public class RamServiceSoap {
	public static com.service.serviceBuilder.model.RamSoap addRam(
		java.util.Date time, double min, double max, double aver,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.service.serviceBuilder.model.Ram returnValue = RamServiceUtil.addRam(time,
					min, max, aver, serviceContext);

			return com.service.serviceBuilder.model.RamSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRam(long ramId) throws RemoteException {
		try {
			RamServiceUtil.deleteRam(ramId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.service.serviceBuilder.model.RamSoap getRam(long ramId)
		throws RemoteException {
		try {
			com.service.serviceBuilder.model.Ram returnValue = RamServiceUtil.getRam(ramId);

			return com.service.serviceBuilder.model.RamSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.service.serviceBuilder.model.RamSoap updateRam(
		long ramId, java.util.Date time, double min, double max, double aver,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.service.serviceBuilder.model.Ram returnValue = RamServiceUtil.updateRam(ramId,
					time, min, max, aver, serviceContext);

			return com.service.serviceBuilder.model.RamSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RamServiceSoap.class);
}