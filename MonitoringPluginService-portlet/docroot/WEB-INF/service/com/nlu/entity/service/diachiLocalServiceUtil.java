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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for diachi. This utility wraps
 * {@link com.nlu.entity.service.impl.diachiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author NgocBao
 * @see diachiLocalService
 * @see com.nlu.entity.service.base.diachiLocalServiceBaseImpl
 * @see com.nlu.entity.service.impl.diachiLocalServiceImpl
 * @generated
 */
public class diachiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.nlu.entity.service.impl.diachiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the diachi to the database. Also notifies the appropriate model listeners.
	*
	* @param diachi the diachi
	* @return the diachi that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi adddiachi(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().adddiachi(diachi);
	}

	/**
	* Creates a new diachi with the primary key. Does not add the diachi to the database.
	*
	* @param id the primary key for the new diachi
	* @return the new diachi
	*/
	public static com.nlu.entity.model.diachi creatediachi(long id) {
		return getService().creatediachi(id);
	}

	/**
	* Deletes the diachi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the diachi
	* @return the diachi that was removed
	* @throws PortalException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi deletediachi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletediachi(id);
	}

	/**
	* Deletes the diachi from the database. Also notifies the appropriate model listeners.
	*
	* @param diachi the diachi
	* @return the diachi that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi deletediachi(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletediachi(diachi);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.nlu.entity.model.diachi fetchdiachi(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchdiachi(id);
	}

	/**
	* Returns the diachi with the primary key.
	*
	* @param id the primary key of the diachi
	* @return the diachi
	* @throws PortalException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi getdiachi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getdiachi(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the diachis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of diachis
	* @param end the upper bound of the range of diachis (not inclusive)
	* @return the range of diachis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.diachi> getdiachis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getdiachis(start, end);
	}

	/**
	* Returns the number of diachis.
	*
	* @return the number of diachis
	* @throws SystemException if a system exception occurred
	*/
	public static int getdiachisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getdiachisCount();
	}

	/**
	* Updates the diachi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param diachi the diachi
	* @return the diachi that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi updatediachi(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatediachi(diachi);
	}

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

	public static com.nlu.entity.model.diachi adddiachi(long userId, long id,
		java.lang.String tinh, java.lang.String huyen, java.lang.String xa,
		java.lang.String duong, java.lang.String duongKhac,
		java.lang.String khuPho, java.lang.String soNha,
		java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .adddiachi(userId, id, tinh, huyen, xa, duong, duongKhac,
			khuPho, soNha, quocGia, serviceContext);
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

	public static com.nlu.entity.model.diachi fetchByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByID(id);
	}

	public static com.nlu.entity.model.diachi findByID(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByID(id);
	}

	public static void removeByID(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeByID(id);
	}

	public static void clearService() {
		_service = null;
	}

	public static diachiLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					diachiLocalService.class.getName());

			if (invokableLocalService instanceof diachiLocalService) {
				_service = (diachiLocalService)invokableLocalService;
			}
			else {
				_service = new diachiLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(diachiLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(diachiLocalService service) {
	}

	private static diachiLocalService _service;
}