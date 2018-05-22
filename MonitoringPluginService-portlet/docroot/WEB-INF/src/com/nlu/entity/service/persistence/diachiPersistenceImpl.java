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

import com.nlu.entity.NoSuchdiachiException;
import com.nlu.entity.model.diachi;
import com.nlu.entity.model.impl.diachiImpl;
import com.nlu.entity.model.impl.diachiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the diachi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see diachiPersistence
 * @see diachiUtil
 * @generated
 */
public class diachiPersistenceImpl extends BasePersistenceImpl<diachi>
	implements diachiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link diachiUtil} to access the diachi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = diachiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiModelImpl.FINDER_CACHE_ENABLED, diachiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiModelImpl.FINDER_CACHE_ENABLED, diachiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiModelImpl.FINDER_CACHE_ENABLED, diachiImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByID",
			new String[] { Long.class.getName() },
			diachiModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the diachi where id = &#63; or throws a {@link com.nlu.entity.NoSuchdiachiException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching diachi
	 * @throws com.nlu.entity.NoSuchdiachiException if a matching diachi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi findByID(long id)
		throws NoSuchdiachiException, SystemException {
		diachi diachi = fetchByID(id);

		if (diachi == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchdiachiException(msg.toString());
		}

		return diachi;
	}

	/**
	 * Returns the diachi where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching diachi, or <code>null</code> if a matching diachi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi fetchByID(long id) throws SystemException {
		return fetchByID(id, true);
	}

	/**
	 * Returns the diachi where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching diachi, or <code>null</code> if a matching diachi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi fetchByID(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result instanceof diachi) {
			diachi diachi = (diachi)result;

			if ((id != diachi.getId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DIACHI_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<diachi> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"diachiPersistenceImpl.fetchByID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					diachi diachi = list.get(0);

					result = diachi;

					cacheResult(diachi);

					if ((diachi.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, diachi);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (diachi)result;
		}
	}

	/**
	 * Removes the diachi where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the diachi that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi removeByID(long id)
		throws NoSuchdiachiException, SystemException {
		diachi diachi = findByID(id);

		return remove(diachi);
	}

	/**
	 * Returns the number of diachis where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching diachis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByID(long id) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID;

		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DIACHI_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "diachi.id = ?";

	public diachiPersistenceImpl() {
		setModelClass(diachi.class);
	}

	/**
	 * Caches the diachi in the entity cache if it is enabled.
	 *
	 * @param diachi the diachi
	 */
	@Override
	public void cacheResult(diachi diachi) {
		EntityCacheUtil.putResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiImpl.class, diachi.getPrimaryKey(), diachi);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { diachi.getId() }, diachi);

		diachi.resetOriginalValues();
	}

	/**
	 * Caches the diachis in the entity cache if it is enabled.
	 *
	 * @param diachis the diachis
	 */
	@Override
	public void cacheResult(List<diachi> diachis) {
		for (diachi diachi : diachis) {
			if (EntityCacheUtil.getResult(
						diachiModelImpl.ENTITY_CACHE_ENABLED, diachiImpl.class,
						diachi.getPrimaryKey()) == null) {
				cacheResult(diachi);
			}
			else {
				diachi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all diachis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(diachiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(diachiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the diachi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(diachi diachi) {
		EntityCacheUtil.removeResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiImpl.class, diachi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(diachi);
	}

	@Override
	public void clearCache(List<diachi> diachis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (diachi diachi : diachis) {
			EntityCacheUtil.removeResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
				diachiImpl.class, diachi.getPrimaryKey());

			clearUniqueFindersCache(diachi);
		}
	}

	protected void cacheUniqueFindersCache(diachi diachi) {
		if (diachi.isNew()) {
			Object[] args = new Object[] { diachi.getId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID, args, diachi);
		}
		else {
			diachiModelImpl diachiModelImpl = (diachiModelImpl)diachi;

			if ((diachiModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { diachi.getId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID, args, diachi);
			}
		}
	}

	protected void clearUniqueFindersCache(diachi diachi) {
		diachiModelImpl diachiModelImpl = (diachiModelImpl)diachi;

		Object[] args = new Object[] { diachi.getId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

		if ((diachiModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
			args = new Object[] { diachiModelImpl.getOriginalId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);
		}
	}

	/**
	 * Creates a new diachi with the primary key. Does not add the diachi to the database.
	 *
	 * @param id the primary key for the new diachi
	 * @return the new diachi
	 */
	@Override
	public diachi create(long id) {
		diachi diachi = new diachiImpl();

		diachi.setNew(true);
		diachi.setPrimaryKey(id);

		return diachi;
	}

	/**
	 * Removes the diachi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the diachi
	 * @return the diachi that was removed
	 * @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi remove(long id) throws NoSuchdiachiException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the diachi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the diachi
	 * @return the diachi that was removed
	 * @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi remove(Serializable primaryKey)
		throws NoSuchdiachiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			diachi diachi = (diachi)session.get(diachiImpl.class, primaryKey);

			if (diachi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdiachiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(diachi);
		}
		catch (NoSuchdiachiException nsee) {
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
	protected diachi removeImpl(diachi diachi) throws SystemException {
		diachi = toUnwrappedModel(diachi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(diachi)) {
				diachi = (diachi)session.get(diachiImpl.class,
						diachi.getPrimaryKeyObj());
			}

			if (diachi != null) {
				session.delete(diachi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (diachi != null) {
			clearCache(diachi);
		}

		return diachi;
	}

	@Override
	public diachi updateImpl(com.nlu.entity.model.diachi diachi)
		throws SystemException {
		diachi = toUnwrappedModel(diachi);

		boolean isNew = diachi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (diachi.isNew()) {
				session.save(diachi);

				diachi.setNew(false);
			}
			else {
				session.merge(diachi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !diachiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
			diachiImpl.class, diachi.getPrimaryKey(), diachi);

		clearUniqueFindersCache(diachi);
		cacheUniqueFindersCache(diachi);

		return diachi;
	}

	protected diachi toUnwrappedModel(diachi diachi) {
		if (diachi instanceof diachiImpl) {
			return diachi;
		}

		diachiImpl diachiImpl = new diachiImpl();

		diachiImpl.setNew(diachi.isNew());
		diachiImpl.setPrimaryKey(diachi.getPrimaryKey());

		diachiImpl.setId(diachi.getId());
		diachiImpl.setTinh(diachi.getTinh());
		diachiImpl.setHuyen(diachi.getHuyen());
		diachiImpl.setXa(diachi.getXa());
		diachiImpl.setDuong(diachi.getDuong());
		diachiImpl.setDuongKhac(diachi.getDuongKhac());
		diachiImpl.setKhuPho(diachi.getKhuPho());
		diachiImpl.setSoNha(diachi.getSoNha());
		diachiImpl.setQuocGia(diachi.getQuocGia());

		return diachiImpl;
	}

	/**
	 * Returns the diachi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the diachi
	 * @return the diachi
	 * @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdiachiException, SystemException {
		diachi diachi = fetchByPrimaryKey(primaryKey);

		if (diachi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdiachiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return diachi;
	}

	/**
	 * Returns the diachi with the primary key or throws a {@link com.nlu.entity.NoSuchdiachiException} if it could not be found.
	 *
	 * @param id the primary key of the diachi
	 * @return the diachi
	 * @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi findByPrimaryKey(long id)
		throws NoSuchdiachiException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the diachi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the diachi
	 * @return the diachi, or <code>null</code> if a diachi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		diachi diachi = (diachi)EntityCacheUtil.getResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
				diachiImpl.class, primaryKey);

		if (diachi == _nulldiachi) {
			return null;
		}

		if (diachi == null) {
			Session session = null;

			try {
				session = openSession();

				diachi = (diachi)session.get(diachiImpl.class, primaryKey);

				if (diachi != null) {
					cacheResult(diachi);
				}
				else {
					EntityCacheUtil.putResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
						diachiImpl.class, primaryKey, _nulldiachi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(diachiModelImpl.ENTITY_CACHE_ENABLED,
					diachiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return diachi;
	}

	/**
	 * Returns the diachi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the diachi
	 * @return the diachi, or <code>null</code> if a diachi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public diachi fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the diachis.
	 *
	 * @return the diachis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<diachi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<diachi> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the diachis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of diachis
	 * @param end the upper bound of the range of diachis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of diachis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<diachi> findAll(int start, int end,
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

		List<diachi> list = (List<diachi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DIACHI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIACHI;

				if (pagination) {
					sql = sql.concat(diachiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<diachi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<diachi>(list);
				}
				else {
					list = (List<diachi>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the diachis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (diachi diachi : findAll()) {
			remove(diachi);
		}
	}

	/**
	 * Returns the number of diachis.
	 *
	 * @return the number of diachis
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

				Query q = session.createQuery(_SQL_COUNT_DIACHI);

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
	 * Initializes the diachi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.diachi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<diachi>> listenersList = new ArrayList<ModelListener<diachi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<diachi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(diachiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DIACHI = "SELECT diachi FROM diachi diachi";
	private static final String _SQL_SELECT_DIACHI_WHERE = "SELECT diachi FROM diachi diachi WHERE ";
	private static final String _SQL_COUNT_DIACHI = "SELECT COUNT(diachi) FROM diachi diachi";
	private static final String _SQL_COUNT_DIACHI_WHERE = "SELECT COUNT(diachi) FROM diachi diachi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "diachi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No diachi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No diachi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(diachiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static diachi _nulldiachi = new diachiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<diachi> toCacheModel() {
				return _nulldiachiCacheModel;
			}
		};

	private static CacheModel<diachi> _nulldiachiCacheModel = new CacheModel<diachi>() {
			@Override
			public diachi toEntityModel() {
				return _nulldiachi;
			}
		};
}