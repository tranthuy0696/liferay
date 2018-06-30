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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nlu.entity.NoSuchNonHeapException;
import com.nlu.entity.model.NonHeap;
import com.nlu.entity.model.impl.NonHeapImpl;
import com.nlu.entity.model.impl.NonHeapModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the non heap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see NonHeapPersistence
 * @see NonHeapUtil
 * @generated
 */
public class NonHeapPersistenceImpl extends BasePersistenceImpl<NonHeap>
	implements NonHeapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NonHeapUtil} to access the non heap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NonHeapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
			NonHeapModelImpl.FINDER_CACHE_ENABLED, NonHeapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
			NonHeapModelImpl.FINDER_CACHE_ENABLED, NonHeapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
			NonHeapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NonHeapPersistenceImpl() {
		setModelClass(NonHeap.class);
	}

	/**
	 * Caches the non heap in the entity cache if it is enabled.
	 *
	 * @param nonHeap the non heap
	 */
	@Override
	public void cacheResult(NonHeap nonHeap) {
		EntityCacheUtil.putResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
			NonHeapImpl.class, nonHeap.getPrimaryKey(), nonHeap);

		nonHeap.resetOriginalValues();
	}

	/**
	 * Caches the non heaps in the entity cache if it is enabled.
	 *
	 * @param nonHeaps the non heaps
	 */
	@Override
	public void cacheResult(List<NonHeap> nonHeaps) {
		for (NonHeap nonHeap : nonHeaps) {
			if (EntityCacheUtil.getResult(
						NonHeapModelImpl.ENTITY_CACHE_ENABLED,
						NonHeapImpl.class, nonHeap.getPrimaryKey()) == null) {
				cacheResult(nonHeap);
			}
			else {
				nonHeap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all non heaps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NonHeapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NonHeapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the non heap.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NonHeap nonHeap) {
		EntityCacheUtil.removeResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
			NonHeapImpl.class, nonHeap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NonHeap> nonHeaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NonHeap nonHeap : nonHeaps) {
			EntityCacheUtil.removeResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
				NonHeapImpl.class, nonHeap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new non heap with the primary key. Does not add the non heap to the database.
	 *
	 * @param nonHeapId the primary key for the new non heap
	 * @return the new non heap
	 */
	@Override
	public NonHeap create(long nonHeapId) {
		NonHeap nonHeap = new NonHeapImpl();

		nonHeap.setNew(true);
		nonHeap.setPrimaryKey(nonHeapId);

		return nonHeap;
	}

	/**
	 * Removes the non heap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nonHeapId the primary key of the non heap
	 * @return the non heap that was removed
	 * @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonHeap remove(long nonHeapId)
		throws NoSuchNonHeapException, SystemException {
		return remove((Serializable)nonHeapId);
	}

	/**
	 * Removes the non heap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the non heap
	 * @return the non heap that was removed
	 * @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonHeap remove(Serializable primaryKey)
		throws NoSuchNonHeapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NonHeap nonHeap = (NonHeap)session.get(NonHeapImpl.class, primaryKey);

			if (nonHeap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNonHeapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nonHeap);
		}
		catch (NoSuchNonHeapException nsee) {
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
	protected NonHeap removeImpl(NonHeap nonHeap) throws SystemException {
		nonHeap = toUnwrappedModel(nonHeap);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nonHeap)) {
				nonHeap = (NonHeap)session.get(NonHeapImpl.class,
						nonHeap.getPrimaryKeyObj());
			}

			if (nonHeap != null) {
				session.delete(nonHeap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nonHeap != null) {
			clearCache(nonHeap);
		}

		return nonHeap;
	}

	@Override
	public NonHeap updateImpl(com.nlu.entity.model.NonHeap nonHeap)
		throws SystemException {
		nonHeap = toUnwrappedModel(nonHeap);

		boolean isNew = nonHeap.isNew();

		Session session = null;

		try {
			session = openSession();

			if (nonHeap.isNew()) {
				session.save(nonHeap);

				nonHeap.setNew(false);
			}
			else {
				session.merge(nonHeap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
			NonHeapImpl.class, nonHeap.getPrimaryKey(), nonHeap);

		return nonHeap;
	}

	protected NonHeap toUnwrappedModel(NonHeap nonHeap) {
		if (nonHeap instanceof NonHeapImpl) {
			return nonHeap;
		}

		NonHeapImpl nonHeapImpl = new NonHeapImpl();

		nonHeapImpl.setNew(nonHeap.isNew());
		nonHeapImpl.setPrimaryKey(nonHeap.getPrimaryKey());

		nonHeapImpl.setNonHeapId(nonHeap.getNonHeapId());
		nonHeapImpl.setTime(nonHeap.getTime());
		nonHeapImpl.setValue(nonHeap.getValue());

		return nonHeapImpl;
	}

	/**
	 * Returns the non heap with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the non heap
	 * @return the non heap
	 * @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonHeap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNonHeapException, SystemException {
		NonHeap nonHeap = fetchByPrimaryKey(primaryKey);

		if (nonHeap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNonHeapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return nonHeap;
	}

	/**
	 * Returns the non heap with the primary key or throws a {@link com.nlu.entity.NoSuchNonHeapException} if it could not be found.
	 *
	 * @param nonHeapId the primary key of the non heap
	 * @return the non heap
	 * @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonHeap findByPrimaryKey(long nonHeapId)
		throws NoSuchNonHeapException, SystemException {
		return findByPrimaryKey((Serializable)nonHeapId);
	}

	/**
	 * Returns the non heap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the non heap
	 * @return the non heap, or <code>null</code> if a non heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonHeap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NonHeap nonHeap = (NonHeap)EntityCacheUtil.getResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
				NonHeapImpl.class, primaryKey);

		if (nonHeap == _nullNonHeap) {
			return null;
		}

		if (nonHeap == null) {
			Session session = null;

			try {
				session = openSession();

				nonHeap = (NonHeap)session.get(NonHeapImpl.class, primaryKey);

				if (nonHeap != null) {
					cacheResult(nonHeap);
				}
				else {
					EntityCacheUtil.putResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
						NonHeapImpl.class, primaryKey, _nullNonHeap);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NonHeapModelImpl.ENTITY_CACHE_ENABLED,
					NonHeapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nonHeap;
	}

	/**
	 * Returns the non heap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nonHeapId the primary key of the non heap
	 * @return the non heap, or <code>null</code> if a non heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonHeap fetchByPrimaryKey(long nonHeapId) throws SystemException {
		return fetchByPrimaryKey((Serializable)nonHeapId);
	}

	/**
	 * Returns all the non heaps.
	 *
	 * @return the non heaps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NonHeap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the non heaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of non heaps
	 * @param end the upper bound of the range of non heaps (not inclusive)
	 * @return the range of non heaps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NonHeap> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the non heaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of non heaps
	 * @param end the upper bound of the range of non heaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of non heaps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NonHeap> findAll(int start, int end,
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

		List<NonHeap> list = (List<NonHeap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NONHEAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NONHEAP;

				if (pagination) {
					sql = sql.concat(NonHeapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NonHeap>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NonHeap>(list);
				}
				else {
					list = (List<NonHeap>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the non heaps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NonHeap nonHeap : findAll()) {
			remove(nonHeap);
		}
	}

	/**
	 * Returns the number of non heaps.
	 *
	 * @return the number of non heaps
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

				Query q = session.createQuery(_SQL_COUNT_NONHEAP);

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
	 * Initializes the non heap persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.NonHeap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NonHeap>> listenersList = new ArrayList<ModelListener<NonHeap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NonHeap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NonHeapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NONHEAP = "SELECT nonHeap FROM NonHeap nonHeap";
	private static final String _SQL_COUNT_NONHEAP = "SELECT COUNT(nonHeap) FROM NonHeap nonHeap";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nonHeap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NonHeap exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NonHeapPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"time"
			});
	private static NonHeap _nullNonHeap = new NonHeapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NonHeap> toCacheModel() {
				return _nullNonHeapCacheModel;
			}
		};

	private static CacheModel<NonHeap> _nullNonHeapCacheModel = new CacheModel<NonHeap>() {
			@Override
			public NonHeap toEntityModel() {
				return _nullNonHeap;
			}
		};
}