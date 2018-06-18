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

import com.nlu.entity.NoSuchCpuException;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.impl.CpuImpl;
import com.nlu.entity.model.impl.CpuModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cpu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see CpuPersistence
 * @see CpuUtil
 * @generated
 */
public class CpuPersistenceImpl extends BasePersistenceImpl<Cpu>
	implements CpuPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CpuUtil} to access the cpu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CpuImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CpuModelImpl.ENTITY_CACHE_ENABLED,
			CpuModelImpl.FINDER_CACHE_ENABLED, CpuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CpuModelImpl.ENTITY_CACHE_ENABLED,
			CpuModelImpl.FINDER_CACHE_ENABLED, CpuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CpuModelImpl.ENTITY_CACHE_ENABLED,
			CpuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CpuPersistenceImpl() {
		setModelClass(Cpu.class);
	}

	/**
	 * Caches the cpu in the entity cache if it is enabled.
	 *
	 * @param cpu the cpu
	 */
	@Override
	public void cacheResult(Cpu cpu) {
		EntityCacheUtil.putResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
			CpuImpl.class, cpu.getPrimaryKey(), cpu);

		cpu.resetOriginalValues();
	}

	/**
	 * Caches the cpus in the entity cache if it is enabled.
	 *
	 * @param cpus the cpus
	 */
	@Override
	public void cacheResult(List<Cpu> cpus) {
		for (Cpu cpu : cpus) {
			if (EntityCacheUtil.getResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
						CpuImpl.class, cpu.getPrimaryKey()) == null) {
				cacheResult(cpu);
			}
			else {
				cpu.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cpus.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CpuImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CpuImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cpu.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cpu cpu) {
		EntityCacheUtil.removeResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
			CpuImpl.class, cpu.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Cpu> cpus) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cpu cpu : cpus) {
			EntityCacheUtil.removeResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
				CpuImpl.class, cpu.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cpu with the primary key. Does not add the cpu to the database.
	 *
	 * @param cpuId the primary key for the new cpu
	 * @return the new cpu
	 */
	@Override
	public Cpu create(long cpuId) {
		Cpu cpu = new CpuImpl();

		cpu.setNew(true);
		cpu.setPrimaryKey(cpuId);

		return cpu;
	}

	/**
	 * Removes the cpu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cpuId the primary key of the cpu
	 * @return the cpu that was removed
	 * @throws com.nlu.entity.NoSuchCpuException if a cpu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cpu remove(long cpuId) throws NoSuchCpuException, SystemException {
		return remove((Serializable)cpuId);
	}

	/**
	 * Removes the cpu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cpu
	 * @return the cpu that was removed
	 * @throws com.nlu.entity.NoSuchCpuException if a cpu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cpu remove(Serializable primaryKey)
		throws NoSuchCpuException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cpu cpu = (Cpu)session.get(CpuImpl.class, primaryKey);

			if (cpu == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCpuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cpu);
		}
		catch (NoSuchCpuException nsee) {
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
	protected Cpu removeImpl(Cpu cpu) throws SystemException {
		cpu = toUnwrappedModel(cpu);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cpu)) {
				cpu = (Cpu)session.get(CpuImpl.class, cpu.getPrimaryKeyObj());
			}

			if (cpu != null) {
				session.delete(cpu);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cpu != null) {
			clearCache(cpu);
		}

		return cpu;
	}

	@Override
	public Cpu updateImpl(com.nlu.entity.model.Cpu cpu)
		throws SystemException {
		cpu = toUnwrappedModel(cpu);

		boolean isNew = cpu.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cpu.isNew()) {
				session.save(cpu);

				cpu.setNew(false);
			}
			else {
				session.merge(cpu);
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

		EntityCacheUtil.putResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
			CpuImpl.class, cpu.getPrimaryKey(), cpu);

		return cpu;
	}

	protected Cpu toUnwrappedModel(Cpu cpu) {
		if (cpu instanceof CpuImpl) {
			return cpu;
		}

		CpuImpl cpuImpl = new CpuImpl();

		cpuImpl.setNew(cpu.isNew());
		cpuImpl.setPrimaryKey(cpu.getPrimaryKey());

		cpuImpl.setCpuId(cpu.getCpuId());
		cpuImpl.setTime(cpu.getTime());
		cpuImpl.setValue(cpu.getValue());

		return cpuImpl;
	}

	/**
	 * Returns the cpu with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cpu
	 * @return the cpu
	 * @throws com.nlu.entity.NoSuchCpuException if a cpu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cpu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCpuException, SystemException {
		Cpu cpu = fetchByPrimaryKey(primaryKey);

		if (cpu == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCpuException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cpu;
	}

	/**
	 * Returns the cpu with the primary key or throws a {@link com.nlu.entity.NoSuchCpuException} if it could not be found.
	 *
	 * @param cpuId the primary key of the cpu
	 * @return the cpu
	 * @throws com.nlu.entity.NoSuchCpuException if a cpu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cpu findByPrimaryKey(long cpuId)
		throws NoSuchCpuException, SystemException {
		return findByPrimaryKey((Serializable)cpuId);
	}

	/**
	 * Returns the cpu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cpu
	 * @return the cpu, or <code>null</code> if a cpu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cpu fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cpu cpu = (Cpu)EntityCacheUtil.getResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
				CpuImpl.class, primaryKey);

		if (cpu == _nullCpu) {
			return null;
		}

		if (cpu == null) {
			Session session = null;

			try {
				session = openSession();

				cpu = (Cpu)session.get(CpuImpl.class, primaryKey);

				if (cpu != null) {
					cacheResult(cpu);
				}
				else {
					EntityCacheUtil.putResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
						CpuImpl.class, primaryKey, _nullCpu);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CpuModelImpl.ENTITY_CACHE_ENABLED,
					CpuImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cpu;
	}

	/**
	 * Returns the cpu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cpuId the primary key of the cpu
	 * @return the cpu, or <code>null</code> if a cpu with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cpu fetchByPrimaryKey(long cpuId) throws SystemException {
		return fetchByPrimaryKey((Serializable)cpuId);
	}

	/**
	 * Returns all the cpus.
	 *
	 * @return the cpus
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cpu> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cpus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.CpuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpus
	 * @param end the upper bound of the range of cpus (not inclusive)
	 * @return the range of cpus
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cpu> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cpus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.CpuModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cpus
	 * @param end the upper bound of the range of cpus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cpus
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cpu> findAll(int start, int end,
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

		List<Cpu> list = (List<Cpu>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CPU);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CPU;

				if (pagination) {
					sql = sql.concat(CpuModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cpu>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cpu>(list);
				}
				else {
					list = (List<Cpu>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the cpus from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cpu cpu : findAll()) {
			remove(cpu);
		}
	}

	/**
	 * Returns the number of cpus.
	 *
	 * @return the number of cpus
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

				Query q = session.createQuery(_SQL_COUNT_CPU);

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
	 * Initializes the cpu persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.Cpu")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cpu>> listenersList = new ArrayList<ModelListener<Cpu>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cpu>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CpuImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CPU = "SELECT cpu FROM Cpu cpu";
	private static final String _SQL_COUNT_CPU = "SELECT COUNT(cpu) FROM Cpu cpu";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cpu.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cpu exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CpuPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"time"
			});
	private static Cpu _nullCpu = new CpuImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cpu> toCacheModel() {
				return _nullCpuCacheModel;
			}
		};

	private static CacheModel<Cpu> _nullCpuCacheModel = new CacheModel<Cpu>() {
			@Override
			public Cpu toEntityModel() {
				return _nullCpu;
			}
		};
}