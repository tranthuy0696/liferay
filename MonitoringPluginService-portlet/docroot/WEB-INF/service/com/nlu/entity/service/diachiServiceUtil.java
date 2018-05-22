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

package com.nlu.entity.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for diachi. This utility wraps
 * {@link com.nlu.entity.service.impl.diachiServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author NgocBao
 * @see diachiService
 * @see com.nlu.entity.service.base.diachiServiceBaseImpl
 * @see com.nlu.entity.service.impl.diachiServiceImpl
 * @generated
 */
public class diachiServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.nlu.entity.service.impl.diachiServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.nlu.entity.model.diachi adddiachi(long id,
		java.lang.String tinh, java.lang.String huyen, java.lang.String xa,
		java.lang.String duong, java.lang.String duongKhac,
		java.lang.String khuPho, java.lang.String soNha,
		java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .adddiachi(id, tinh, huyen, xa, duong, duongKhac, khuPho,
			soNha, quocGia, serviceContext);
	}

	public static void deletediachi(long diachiId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletediachi(diachiId);
	}

	public static com.nlu.entity.model.diachi getdiachi(long diachiId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getdiachi(diachiId);
	}

	public static com.nlu.entity.model.diachi updatediachi(long diachiId,
		long id, java.lang.String tinh, java.lang.String huyen,
		java.lang.String xa, java.lang.String duong,
		java.lang.String duongKhac, java.lang.String khuPho,
		java.lang.String soNha, java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatediachi(diachiId, id, tinh, huyen, xa, duong,
			duongKhac, khuPho, soNha, quocGia, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static diachiService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					diachiService.class.getName());

			if (invokableService instanceof diachiService) {
				_service = (diachiService)invokableService;
			}
			else {
				_service = new diachiServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(diachiServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(diachiService service) {
	}

	private static diachiService _service;
}