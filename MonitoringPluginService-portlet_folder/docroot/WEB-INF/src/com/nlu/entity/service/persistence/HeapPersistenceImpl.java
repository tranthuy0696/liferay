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

import com.nlu.entity.NoSuchHeapException;
import com.nlu.entity.model.Heap;
import com.nlu.entity.model.impl.HeapImpl;
import com.nlu.entity.model.impl.HeapModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the heap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see HeapPersistence
 * @see HeapUtil
 * @generated
 */
public class HeapPersistenceImpl extends BasePersistenceImpl<Heap>
	implements HeapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HeapUtil} to access the heap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HeapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HeapModelImpl.ENTITY_CACHE_ENABLED,
			HeapModelImpl.FINDER_CACHE_ENABLED, HeapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HeapModelImpl.ENTITY_CACHE_ENABLED,
			HeapModelImpl.FINDER_CACHE_ENABLED, HeapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HeapModelImpl.ENTITY_CACHE_ENABLED,
			HeapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HeapPersistenceImpl() {
		setModelClass(Heap.class);
	}

	/**
	 * Caches the heap in the entity cache if it is enabled.
	 *
	 * @param heap the heap
	 */
	@Override
	public void cacheResult(Heap heap) {
		EntityCacheUtil.putResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
			HeapImpl.class, heap.getPrimaryKey(), heap);

		heap.resetOriginalValues();
	}

	/**
	 * Caches the heaps in the entity cache if it is enabled.
	 *
	 * @param heaps the heaps
	 */
	@Override
	public void cacheResult(List<Heap> heaps) {
		for (Heap heap : heaps) {
			if (EntityCacheUtil.getResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
						HeapImpl.class, heap.getPrimaryKey()) == null) {
				cacheResult(heap);
			}
			else {
				heap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all heaps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HeapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HeapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the heap.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Heap heap) {
		EntityCacheUtil.removeResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
			HeapImpl.class, heap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Heap> heaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Heap heap : heaps) {
			EntityCacheUtil.removeResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
				HeapImpl.class, heap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new heap with the primary key. Does not add the heap to the database.
	 *
	 * @param heapId the primary key for the new heap
	 * @return the new heap
	 */
	@Override
	public Heap create(long heapId) {
		Heap heap = new HeapImpl();

		heap.setNew(true);
		heap.setPrimaryKey(heapId);

		return heap;
	}

	/**
	 * Removes the heap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param heapId the primary key of the heap
	 * @return the heap that was removed
	 * @throws com.nlu.entity.NoSuchHeapException if a heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Heap remove(long heapId) throws NoSuchHeapException, SystemException {
		return remove((Serializable)heapId);
	}

	/**
	 * Removes the heap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the heap
	 * @return the heap that was removed
	 * @throws com.nlu.entity.NoSuchHeapException if a heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Heap remove(Serializable primaryKey)
		throws NoSuchHeapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Heap heap = (Heap)session.get(HeapImpl.class, primaryKey);

			if (heap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHeapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(heap);
		}
		catch (NoSuchHeapException nsee) {
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
	protected Heap removeImpl(Heap heap) throws SystemException {
		heap = toUnwrappedModel(heap);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(heap)) {
				heap = (Heap)session.get(HeapImpl.class, heap.getPrimaryKeyObj());
			}

			if (heap != null) {
				session.delete(heap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (heap != null) {
			clearCache(heap);
		}

		return heap;
	}

	@Override
	public Heap updateImpl(com.nlu.entity.model.Heap heap)
		throws SystemException {
		heap = toUnwrappedModel(heap);

		boolean isNew = heap.isNew();

		Session session = null;

		try {
			session = openSession();

			if (heap.isNew()) {
				session.save(heap);

				heap.setNew(false);
			}
			else {
				session.merge(heap);
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

		EntityCacheUtil.putResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
			HeapImpl.class, heap.getPrimaryKey(), heap);

		return heap;
	}

	protected Heap toUnwrappedModel(Heap heap) {
		if (heap instanceof HeapImpl) {
			return heap;
		}

		HeapImpl heapImpl = new HeapImpl();

		heapImpl.setNew(heap.isNew());
		heapImpl.setPrimaryKey(heap.getPrimaryKey());

		heapImpl.setHeapId(heap.getHeapId());
		heapImpl.setTime(heap.getTime());
		heapImpl.setValue(heap.getValue());

		return heapImpl;
	}

	/**
	 * Returns the heap with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the heap
	 * @return the heap
	 * @throws com.nlu.entity.NoSuchHeapException if a heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Heap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHeapException, SystemException {
		Heap heap = fetchByPrimaryKey(primaryKey);

		if (heap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHeapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return heap;
	}

	/**
	 * Returns the heap with the primary key or throws a {@link com.nlu.entity.NoSuchHeapException} if it could not be found.
	 *
	 * @param heapId the primary key of the heap
	 * @return the heap
	 * @throws com.nlu.entity.NoSuchHeapException if a heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Heap findByPrimaryKey(long heapId)
		throws NoSuchHeapException, SystemException {
		return findByPrimaryKey((Serializable)heapId);
	}

	/**
	 * Returns the heap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the heap
	 * @return the heap, or <code>null</code> if a heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Heap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Heap heap = (Heap)EntityCacheUtil.getResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
				HeapImpl.class, primaryKey);

		if (heap == _nullHeap) {
			return null;
		}

		if (heap == null) {
			Session session = null;

			try {
				session = openSession();

				heap = (Heap)session.get(HeapImpl.class, primaryKey);

				if (heap != null) {
					cacheResult(heap);
				}
				else {
					EntityCacheUtil.putResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
						HeapImpl.class, primaryKey, _nullHeap);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HeapModelImpl.ENTITY_CACHE_ENABLED,
					HeapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return heap;
	}

	/**
	 * Returns the heap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param heapId the primary key of the heap
	 * @return the heap, or <code>null</code> if a heap with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Heap fetchByPrimaryKey(long heapId) throws SystemException {
		return fetchByPrimaryKey((Serializable)heapId);
	}

	/**
	 * Returns all the heaps.
	 *
	 * @return the heaps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Heap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the heaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of heaps
	 * @param end the upper bound of the range of heaps (not inclusive)
	 * @return the range of heaps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Heap> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the heaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of heaps
	 * @param end the upper bound of the range of heaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of heaps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Heap> findAll(int start, int end,
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

		List<Heap> list = (List<Heap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HEAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HEAP;

				if (pagination) {
					sql = sql.concat(HeapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Heap>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Heap>(list);
				}
				else {
					list = (List<Heap>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the heaps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Heap heap : findAll()) {
			remove(heap);
		}
	}

	/**
	 * Returns the number of heaps.
	 *
	 * @return the number of heaps
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

				Query q = session.createQuery(_SQL_COUNT_HEAP);

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
	 * Initializes the heap persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.Heap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Heap>> listenersList = new ArrayList<ModelListener<Heap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Heap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HeapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HEAP = "SELECT heap FROM Heap heap";
	private static final String _SQL_COUNT_HEAP = "SELECT COUNT(heap) FROM Heap heap";
	private static final String _ORDER_BY_ENTITY_ALIAS = "heap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Heap exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HeapPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"time"
			});
	private static Heap _nullHeap = new HeapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Heap> toCacheModel() {
				return _nullHeapCacheModel;
			}
		};

	private static CacheModel<Heap> _nullHeapCacheModel = new CacheModel<Heap>() {
			@Override
			public Heap toEntityModel() {
				return _nullHeap;
			}
		};
}