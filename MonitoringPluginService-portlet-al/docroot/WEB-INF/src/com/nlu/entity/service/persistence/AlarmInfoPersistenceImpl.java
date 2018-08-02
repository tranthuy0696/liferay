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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nlu.entity.NoSuchAlarmInfoException;
import com.nlu.entity.model.AlarmInfo;
import com.nlu.entity.model.impl.AlarmInfoImpl;
import com.nlu.entity.model.impl.AlarmInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the alarm info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see AlarmInfoPersistence
 * @see AlarmInfoUtil
 * @generated
 */
public class AlarmInfoPersistenceImpl extends BasePersistenceImpl<AlarmInfo>
	implements AlarmInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AlarmInfoUtil} to access the alarm info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AlarmInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoModelImpl.FINDER_CACHE_ENABLED, AlarmInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoModelImpl.FINDER_CACHE_ENABLED, AlarmInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoModelImpl.FINDER_CACHE_ENABLED, AlarmInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME = new FinderPath(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the alarm infos where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AlarmInfo> findByname(String name) throws SystemException {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alarm infos where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of alarm infos
	 * @param end the upper bound of the range of alarm infos (not inclusive)
	 * @return the range of matching alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AlarmInfo> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the alarm infos where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of alarm infos
	 * @param end the upper bound of the range of alarm infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AlarmInfo> findByname(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
		finderArgs = new Object[] { name, start, end, orderByComparator };

		List<AlarmInfo> list = (List<AlarmInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AlarmInfo alarmInfo : list) {
				if (!StringUtil.wildcardMatches(alarmInfo.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ALARMINFO_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AlarmInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<AlarmInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AlarmInfo>(list);
				}
				else {
					list = (List<AlarmInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first alarm info in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alarm info
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a matching alarm info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo findByname_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchAlarmInfoException, SystemException {
		AlarmInfo alarmInfo = fetchByname_First(name, orderByComparator);

		if (alarmInfo != null) {
			return alarmInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlarmInfoException(msg.toString());
	}

	/**
	 * Returns the first alarm info in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alarm info, or <code>null</code> if a matching alarm info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo fetchByname_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<AlarmInfo> list = findByname(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last alarm info in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alarm info
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a matching alarm info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo findByname_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchAlarmInfoException, SystemException {
		AlarmInfo alarmInfo = fetchByname_Last(name, orderByComparator);

		if (alarmInfo != null) {
			return alarmInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAlarmInfoException(msg.toString());
	}

	/**
	 * Returns the last alarm info in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alarm info, or <code>null</code> if a matching alarm info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo fetchByname_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByname(name);

		if (count == 0) {
			return null;
		}

		List<AlarmInfo> list = findByname(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the alarm infos before and after the current alarm info in the ordered set where name LIKE &#63;.
	 *
	 * @param alarmInfoId the primary key of the current alarm info
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alarm info
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo[] findByname_PrevAndNext(long alarmInfoId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchAlarmInfoException, SystemException {
		AlarmInfo alarmInfo = findByPrimaryKey(alarmInfoId);

		Session session = null;

		try {
			session = openSession();

			AlarmInfo[] array = new AlarmInfoImpl[3];

			array[0] = getByname_PrevAndNext(session, alarmInfo, name,
					orderByComparator, true);

			array[1] = alarmInfo;

			array[2] = getByname_PrevAndNext(session, alarmInfo, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AlarmInfo getByname_PrevAndNext(Session session,
		AlarmInfo alarmInfo, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ALARMINFO_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AlarmInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(alarmInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AlarmInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the alarm infos where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByname(String name) throws SystemException {
		for (AlarmInfo alarmInfo : findByname(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(alarmInfo);
		}
	}

	/**
	 * Returns the number of alarm infos where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByname(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ALARMINFO_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "alarmInfo.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "alarmInfo.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(alarmInfo.name IS NULL OR alarmInfo.name LIKE '')";

	public AlarmInfoPersistenceImpl() {
		setModelClass(AlarmInfo.class);
	}

	/**
	 * Caches the alarm info in the entity cache if it is enabled.
	 *
	 * @param alarmInfo the alarm info
	 */
	@Override
	public void cacheResult(AlarmInfo alarmInfo) {
		EntityCacheUtil.putResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoImpl.class, alarmInfo.getPrimaryKey(), alarmInfo);

		alarmInfo.resetOriginalValues();
	}

	/**
	 * Caches the alarm infos in the entity cache if it is enabled.
	 *
	 * @param alarmInfos the alarm infos
	 */
	@Override
	public void cacheResult(List<AlarmInfo> alarmInfos) {
		for (AlarmInfo alarmInfo : alarmInfos) {
			if (EntityCacheUtil.getResult(
						AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
						AlarmInfoImpl.class, alarmInfo.getPrimaryKey()) == null) {
				cacheResult(alarmInfo);
			}
			else {
				alarmInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all alarm infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AlarmInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AlarmInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the alarm info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AlarmInfo alarmInfo) {
		EntityCacheUtil.removeResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoImpl.class, alarmInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AlarmInfo> alarmInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AlarmInfo alarmInfo : alarmInfos) {
			EntityCacheUtil.removeResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
				AlarmInfoImpl.class, alarmInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new alarm info with the primary key. Does not add the alarm info to the database.
	 *
	 * @param alarmInfoId the primary key for the new alarm info
	 * @return the new alarm info
	 */
	@Override
	public AlarmInfo create(long alarmInfoId) {
		AlarmInfo alarmInfo = new AlarmInfoImpl();

		alarmInfo.setNew(true);
		alarmInfo.setPrimaryKey(alarmInfoId);

		return alarmInfo;
	}

	/**
	 * Removes the alarm info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alarmInfoId the primary key of the alarm info
	 * @return the alarm info that was removed
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo remove(long alarmInfoId)
		throws NoSuchAlarmInfoException, SystemException {
		return remove((Serializable)alarmInfoId);
	}

	/**
	 * Removes the alarm info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the alarm info
	 * @return the alarm info that was removed
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo remove(Serializable primaryKey)
		throws NoSuchAlarmInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AlarmInfo alarmInfo = (AlarmInfo)session.get(AlarmInfoImpl.class,
					primaryKey);

			if (alarmInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlarmInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(alarmInfo);
		}
		catch (NoSuchAlarmInfoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AlarmInfo removeImpl(AlarmInfo alarmInfo)
		throws SystemException {
		alarmInfo = toUnwrappedModel(alarmInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(alarmInfo)) {
				alarmInfo = (AlarmInfo)session.get(AlarmInfoImpl.class,
						alarmInfo.getPrimaryKeyObj());
			}

			if (alarmInfo != null) {
				session.delete(alarmInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (alarmInfo != null) {
			clearCache(alarmInfo);
		}

		return alarmInfo;
	}

	@Override
	public AlarmInfo updateImpl(com.nlu.entity.model.AlarmInfo alarmInfo)
		throws SystemException {
		alarmInfo = toUnwrappedModel(alarmInfo);

		boolean isNew = alarmInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (alarmInfo.isNew()) {
				session.save(alarmInfo);

				alarmInfo.setNew(false);
			}
			else {
				session.merge(alarmInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AlarmInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
			AlarmInfoImpl.class, alarmInfo.getPrimaryKey(), alarmInfo);

		return alarmInfo;
	}

	protected AlarmInfo toUnwrappedModel(AlarmInfo alarmInfo) {
		if (alarmInfo instanceof AlarmInfoImpl) {
			return alarmInfo;
		}

		AlarmInfoImpl alarmInfoImpl = new AlarmInfoImpl();

		alarmInfoImpl.setNew(alarmInfo.isNew());
		alarmInfoImpl.setPrimaryKey(alarmInfo.getPrimaryKey());

		alarmInfoImpl.setAlarmInfoId(alarmInfo.getAlarmInfoId());
		alarmInfoImpl.setName(alarmInfo.getName());
		alarmInfoImpl.setMail(alarmInfo.getMail());

		return alarmInfoImpl;
	}

	/**
	 * Returns the alarm info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the alarm info
	 * @return the alarm info
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAlarmInfoException, SystemException {
		AlarmInfo alarmInfo = fetchByPrimaryKey(primaryKey);

		if (alarmInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAlarmInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return alarmInfo;
	}

	/**
	 * Returns the alarm info with the primary key or throws a {@link com.nlu.entity.NoSuchAlarmInfoException} if it could not be found.
	 *
	 * @param alarmInfoId the primary key of the alarm info
	 * @return the alarm info
	 * @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo findByPrimaryKey(long alarmInfoId)
		throws NoSuchAlarmInfoException, SystemException {
		return findByPrimaryKey((Serializable)alarmInfoId);
	}

	/**
	 * Returns the alarm info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the alarm info
	 * @return the alarm info, or <code>null</code> if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AlarmInfo alarmInfo = (AlarmInfo)EntityCacheUtil.getResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
				AlarmInfoImpl.class, primaryKey);

		if (alarmInfo == _nullAlarmInfo) {
			return null;
		}

		if (alarmInfo == null) {
			Session session = null;

			try {
				session = openSession();

				alarmInfo = (AlarmInfo)session.get(AlarmInfoImpl.class,
						primaryKey);

				if (alarmInfo != null) {
					cacheResult(alarmInfo);
				}
				else {
					EntityCacheUtil.putResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
						AlarmInfoImpl.class, primaryKey, _nullAlarmInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AlarmInfoModelImpl.ENTITY_CACHE_ENABLED,
					AlarmInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return alarmInfo;
	}

	/**
	 * Returns the alarm info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param alarmInfoId the primary key of the alarm info
	 * @return the alarm info, or <code>null</code> if a alarm info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AlarmInfo fetchByPrimaryKey(long alarmInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)alarmInfoId);
	}

	/**
	 * Returns all the alarm infos.
	 *
	 * @return the alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AlarmInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alarm infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alarm infos
	 * @param end the upper bound of the range of alarm infos (not inclusive)
	 * @return the range of alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AlarmInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the alarm infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alarm infos
	 * @param end the upper bound of the range of alarm infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AlarmInfo> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AlarmInfo> list = (List<AlarmInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ALARMINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALARMINFO;

				if (pagination) {
					sql = sql.concat(AlarmInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AlarmInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AlarmInfo>(list);
				}
				else {
					list = (List<AlarmInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the alarm infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AlarmInfo alarmInfo : findAll()) {
			remove(alarmInfo);
		}
	}

	/**
	 * Returns the number of alarm infos.
	 *
	 * @return the number of alarm infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALARMINFO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the alarm info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.AlarmInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AlarmInfo>> listenersList = new ArrayList<ModelListener<AlarmInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AlarmInfo>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AlarmInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ALARMINFO = "SELECT alarmInfo FROM AlarmInfo alarmInfo";
	private static final String _SQL_SELECT_ALARMINFO_WHERE = "SELECT alarmInfo FROM AlarmInfo alarmInfo WHERE ";
	private static final String _SQL_COUNT_ALARMINFO = "SELECT COUNT(alarmInfo) FROM AlarmInfo alarmInfo";
	private static final String _SQL_COUNT_ALARMINFO_WHERE = "SELECT COUNT(alarmInfo) FROM AlarmInfo alarmInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "alarmInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AlarmInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AlarmInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AlarmInfoPersistenceImpl.class);
	private static AlarmInfo _nullAlarmInfo = new AlarmInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AlarmInfo> toCacheModel() {
				return _nullAlarmInfoCacheModel;
			}
		};

	private static CacheModel<AlarmInfo> _nullAlarmInfoCacheModel = new CacheModel<AlarmInfo>() {
			@Override
			public AlarmInfo toEntityModel() {
				return _nullAlarmInfo;
			}
		};
}