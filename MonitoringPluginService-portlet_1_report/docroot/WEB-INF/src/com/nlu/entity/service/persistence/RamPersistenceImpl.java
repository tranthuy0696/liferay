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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nlu.entity.NoSuchRamException;
import com.nlu.entity.model.Ram;
import com.nlu.entity.model.impl.RamImpl;
import com.nlu.entity.model.impl.RamModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the ram service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see RamPersistence
 * @see RamUtil
 * @generated
 */
public class RamPersistenceImpl extends BasePersistenceImpl<Ram>
	implements RamPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RamUtil} to access the ram persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RamImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamModelImpl.FINDER_CACHE_ENABLED, RamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamModelImpl.FINDER_CACHE_ENABLED, RamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamModelImpl.FINDER_CACHE_ENABLED, RamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATE = new FinderPath(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the rams where time LIKE &#63;.
	 *
	 * @param time the time
	 * @return the matching rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ram> findByDate(Date time) throws SystemException {
		return findByDate(time, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rams where time LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param time the time
	 * @param start the lower bound of the range of rams
	 * @param end the upper bound of the range of rams (not inclusive)
	 * @return the range of matching rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ram> findByDate(Date time, int start, int end)
		throws SystemException {
		return findByDate(time, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rams where time LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param time the time
	 * @param start the lower bound of the range of rams
	 * @param end the upper bound of the range of rams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ram> findByDate(Date time, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
		finderArgs = new Object[] { time, start, end, orderByComparator };

		List<Ram> list = (List<Ram>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ram ram : list) {
				if (!StringUtil.wildcardMatches(ram.getTime(), time,
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

			query.append(_SQL_SELECT_RAM_WHERE);

			boolean bindTime = false;

			if (time == null) {
				query.append(_FINDER_COLUMN_DATE_TIME_1);
			}
			else {
				bindTime = true;

				query.append(_FINDER_COLUMN_DATE_TIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RamModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTime) {
					qPos.add(CalendarUtil.getTimestamp(time));
				}

				if (!pagination) {
					list = (List<Ram>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ram>(list);
				}
				else {
					list = (List<Ram>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first ram in the ordered set where time LIKE &#63;.
	 *
	 * @param time the time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ram
	 * @throws com.nlu.entity.NoSuchRamException if a matching ram could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram findByDate_First(Date time, OrderByComparator orderByComparator)
		throws NoSuchRamException, SystemException {
		Ram ram = fetchByDate_First(time, orderByComparator);

		if (ram != null) {
			return ram;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("time=");
		msg.append(time);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRamException(msg.toString());
	}

	/**
	 * Returns the first ram in the ordered set where time LIKE &#63;.
	 *
	 * @param time the time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ram, or <code>null</code> if a matching ram could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram fetchByDate_First(Date time, OrderByComparator orderByComparator)
		throws SystemException {
		List<Ram> list = findByDate(time, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ram in the ordered set where time LIKE &#63;.
	 *
	 * @param time the time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ram
	 * @throws com.nlu.entity.NoSuchRamException if a matching ram could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram findByDate_Last(Date time, OrderByComparator orderByComparator)
		throws NoSuchRamException, SystemException {
		Ram ram = fetchByDate_Last(time, orderByComparator);

		if (ram != null) {
			return ram;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("time=");
		msg.append(time);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRamException(msg.toString());
	}

	/**
	 * Returns the last ram in the ordered set where time LIKE &#63;.
	 *
	 * @param time the time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ram, or <code>null</code> if a matching ram could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram fetchByDate_Last(Date time, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDate(time);

		if (count == 0) {
			return null;
		}

		List<Ram> list = findByDate(time, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rams before and after the current ram in the ordered set where time LIKE &#63;.
	 *
	 * @param ramId the primary key of the current ram
	 * @param time the time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ram
	 * @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram[] findByDate_PrevAndNext(long ramId, Date time,
		OrderByComparator orderByComparator)
		throws NoSuchRamException, SystemException {
		Ram ram = findByPrimaryKey(ramId);

		Session session = null;

		try {
			session = openSession();

			Ram[] array = new RamImpl[3];

			array[0] = getByDate_PrevAndNext(session, ram, time,
					orderByComparator, true);

			array[1] = ram;

			array[2] = getByDate_PrevAndNext(session, ram, time,
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

	protected Ram getByDate_PrevAndNext(Session session, Ram ram, Date time,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RAM_WHERE);

		boolean bindTime = false;

		if (time == null) {
			query.append(_FINDER_COLUMN_DATE_TIME_1);
		}
		else {
			bindTime = true;

			query.append(_FINDER_COLUMN_DATE_TIME_2);
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
			query.append(RamModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTime) {
			qPos.add(CalendarUtil.getTimestamp(time));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ram);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ram> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rams where time LIKE &#63; from the database.
	 *
	 * @param time the time
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDate(Date time) throws SystemException {
		for (Ram ram : findByDate(time, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(ram);
		}
	}

	/**
	 * Returns the number of rams where time LIKE &#63;.
	 *
	 * @param time the time
	 * @return the number of matching rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDate(Date time) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATE;

		Object[] finderArgs = new Object[] { time };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RAM_WHERE);

			boolean bindTime = false;

			if (time == null) {
				query.append(_FINDER_COLUMN_DATE_TIME_1);
			}
			else {
				bindTime = true;

				query.append(_FINDER_COLUMN_DATE_TIME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTime) {
					qPos.add(CalendarUtil.getTimestamp(time));
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

	private static final String _FINDER_COLUMN_DATE_TIME_1 = "ram.time LIKE NULL";
	private static final String _FINDER_COLUMN_DATE_TIME_2 = "ram.time LIKE ?";

	public RamPersistenceImpl() {
		setModelClass(Ram.class);
	}

	/**
	 * Caches the ram in the entity cache if it is enabled.
	 *
	 * @param ram the ram
	 */
	@Override
	public void cacheResult(Ram ram) {
		EntityCacheUtil.putResult(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamImpl.class, ram.getPrimaryKey(), ram);

		ram.resetOriginalValues();
	}

	/**
	 * Caches the rams in the entity cache if it is enabled.
	 *
	 * @param rams the rams
	 */
	@Override
	public void cacheResult(List<Ram> rams) {
		for (Ram ram : rams) {
			if (EntityCacheUtil.getResult(RamModelImpl.ENTITY_CACHE_ENABLED,
						RamImpl.class, ram.getPrimaryKey()) == null) {
				cacheResult(ram);
			}
			else {
				ram.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rams.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RamImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RamImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ram.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ram ram) {
		EntityCacheUtil.removeResult(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamImpl.class, ram.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Ram> rams) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ram ram : rams) {
			EntityCacheUtil.removeResult(RamModelImpl.ENTITY_CACHE_ENABLED,
				RamImpl.class, ram.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ram with the primary key. Does not add the ram to the database.
	 *
	 * @param ramId the primary key for the new ram
	 * @return the new ram
	 */
	@Override
	public Ram create(long ramId) {
		Ram ram = new RamImpl();

		ram.setNew(true);
		ram.setPrimaryKey(ramId);

		return ram;
	}

	/**
	 * Removes the ram with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ramId the primary key of the ram
	 * @return the ram that was removed
	 * @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram remove(long ramId) throws NoSuchRamException, SystemException {
		return remove((Serializable)ramId);
	}

	/**
	 * Removes the ram with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ram
	 * @return the ram that was removed
	 * @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram remove(Serializable primaryKey)
		throws NoSuchRamException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Ram ram = (Ram)session.get(RamImpl.class, primaryKey);

			if (ram == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ram);
		}
		catch (NoSuchRamException nsee) {
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
	protected Ram removeImpl(Ram ram) throws SystemException {
		ram = toUnwrappedModel(ram);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ram)) {
				ram = (Ram)session.get(RamImpl.class, ram.getPrimaryKeyObj());
			}

			if (ram != null) {
				session.delete(ram);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ram != null) {
			clearCache(ram);
		}

		return ram;
	}

	@Override
	public Ram updateImpl(com.nlu.entity.model.Ram ram)
		throws SystemException {
		ram = toUnwrappedModel(ram);

		boolean isNew = ram.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ram.isNew()) {
				session.save(ram);

				ram.setNew(false);
			}
			else {
				session.merge(ram);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RamModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(RamModelImpl.ENTITY_CACHE_ENABLED,
			RamImpl.class, ram.getPrimaryKey(), ram);

		return ram;
	}

	protected Ram toUnwrappedModel(Ram ram) {
		if (ram instanceof RamImpl) {
			return ram;
		}

		RamImpl ramImpl = new RamImpl();

		ramImpl.setNew(ram.isNew());
		ramImpl.setPrimaryKey(ram.getPrimaryKey());

		ramImpl.setRamId(ram.getRamId());
		ramImpl.setTime(ram.getTime());
		ramImpl.setValue(ram.getValue());

		return ramImpl;
	}

	/**
	 * Returns the ram with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ram
	 * @return the ram
	 * @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRamException, SystemException {
		Ram ram = fetchByPrimaryKey(primaryKey);

		if (ram == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ram;
	}

	/**
	 * Returns the ram with the primary key or throws a {@link com.nlu.entity.NoSuchRamException} if it could not be found.
	 *
	 * @param ramId the primary key of the ram
	 * @return the ram
	 * @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram findByPrimaryKey(long ramId)
		throws NoSuchRamException, SystemException {
		return findByPrimaryKey((Serializable)ramId);
	}

	/**
	 * Returns the ram with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ram
	 * @return the ram, or <code>null</code> if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Ram ram = (Ram)EntityCacheUtil.getResult(RamModelImpl.ENTITY_CACHE_ENABLED,
				RamImpl.class, primaryKey);

		if (ram == _nullRam) {
			return null;
		}

		if (ram == null) {
			Session session = null;

			try {
				session = openSession();

				ram = (Ram)session.get(RamImpl.class, primaryKey);

				if (ram != null) {
					cacheResult(ram);
				}
				else {
					EntityCacheUtil.putResult(RamModelImpl.ENTITY_CACHE_ENABLED,
						RamImpl.class, primaryKey, _nullRam);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RamModelImpl.ENTITY_CACHE_ENABLED,
					RamImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ram;
	}

	/**
	 * Returns the ram with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ramId the primary key of the ram
	 * @return the ram, or <code>null</code> if a ram with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ram fetchByPrimaryKey(long ramId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ramId);
	}

	/**
	 * Returns all the rams.
	 *
	 * @return the rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ram> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rams
	 * @param end the upper bound of the range of rams (not inclusive)
	 * @return the range of rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ram> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rams
	 * @param end the upper bound of the range of rams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rams
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ram> findAll(int start, int end,
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

		List<Ram> list = (List<Ram>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RAM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RAM;

				if (pagination) {
					sql = sql.concat(RamModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Ram>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ram>(list);
				}
				else {
					list = (List<Ram>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the rams from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Ram ram : findAll()) {
			remove(ram);
		}
	}

	/**
	 * Returns the number of rams.
	 *
	 * @return the number of rams
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

				Query q = session.createQuery(_SQL_COUNT_RAM);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the ram persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.Ram")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Ram>> listenersList = new ArrayList<ModelListener<Ram>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Ram>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RamImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RAM = "SELECT ram FROM Ram ram";
	private static final String _SQL_SELECT_RAM_WHERE = "SELECT ram FROM Ram ram WHERE ";
	private static final String _SQL_COUNT_RAM = "SELECT COUNT(ram) FROM Ram ram";
	private static final String _SQL_COUNT_RAM_WHERE = "SELECT COUNT(ram) FROM Ram ram WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ram.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Ram exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Ram exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RamPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"time"
			});
	private static Ram _nullRam = new RamImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Ram> toCacheModel() {
				return _nullRamCacheModel;
			}
		};

	private static CacheModel<Ram> _nullRamCacheModel = new CacheModel<Ram>() {
			@Override
			public Ram toEntityModel() {
				return _nullRam;
			}
		};
}