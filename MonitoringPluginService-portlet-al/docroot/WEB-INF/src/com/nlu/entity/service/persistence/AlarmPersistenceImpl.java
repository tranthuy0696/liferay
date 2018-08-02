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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nlu.entity.NoSuchAlarmException;
import com.nlu.entity.model.Alarm;
import com.nlu.entity.model.impl.AlarmImpl;
import com.nlu.entity.model.impl.AlarmModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the alarm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see AlarmPersistence
 * @see AlarmUtil
 * @generated
 */
public class AlarmPersistenceImpl extends BasePersistenceImpl<Alarm>
	implements AlarmPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AlarmUtil} to access the alarm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AlarmImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AlarmModelImpl.ENTITY_CACHE_ENABLED,
			AlarmModelImpl.FINDER_CACHE_ENABLED, AlarmImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AlarmModelImpl.ENTITY_CACHE_ENABLED,
			AlarmModelImpl.FINDER_CACHE_ENABLED, AlarmImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AlarmModelImpl.ENTITY_CACHE_ENABLED,
			AlarmModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AlarmPersistenceImpl() {
		setModelClass(Alarm.class);
	}

	/**
	 * Caches the alarm in the entity cache if it is enabled.
	 *
	 * @param alarm the alarm
	 */
	@Override
	public void cacheResult(Alarm alarm) {
		EntityCacheUtil.putResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
			AlarmImpl.class, alarm.getPrimaryKey(), alarm);

		alarm.resetOriginalValues();
	}

	/**
	 * Caches the alarms in the entity cache if it is enabled.
	 *
	 * @param alarms the alarms
	 */
	@Override
	public void cacheResult(List<Alarm> alarms) {
		for (Alarm alarm : alarms) {
			if (EntityCacheUtil.getResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
						AlarmImpl.class, alarm.getPrimaryKey()) == null) {
				cacheResult(alarm);
			}
			else {
				alarm.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all alarms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AlarmImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AlarmImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the alarm.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Alarm alarm) {
		EntityCacheUtil.removeResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
			AlarmImpl.class, alarm.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Alarm> alarms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Alarm alarm : alarms) {
			EntityCacheUtil.removeResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
				AlarmImpl.class, alarm.getPrimaryKey());
		}
	}

	/**
	 * Creates a new alarm with the primary key. Does not add the alarm to the database.
	 *
	 * @param alarmId the primary key for the new alarm
	 * @return the new alarm
	 */
	@Override
	public Alarm create(long alarmId) {
		Alarm alarm = new AlarmImpl();

		alarm.setNew(true);
		alarm.setPrimaryKey(alarmId);

		return alarm;
	}

	/**
	 * Removes the alarm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alarmId the primary key of the alarm
	 * @return the alarm that was removed
	 * @throws com.nlu.entity.NoSuchAlarmException if a alarm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Alarm remove(long alarmId)
		throws NoSuchAlarmException, SystemException {
		return remove((Serializable)alarmId);
	}

	/**
	 * Removes the alarm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the alarm
	 * @return the alarm that was removed
	 * @throws com.nlu.entity.NoSuchAlarmException if a alarm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Alarm remove(Serializable primaryKey)
		throws NoSuchAlarmException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Alarm alarm = (Alarm)session.get(AlarmImpl.class, primaryKey);

			if (alarm == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlarmException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(alarm);
		}
		catch (NoSuchAlarmException nsee) {
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
	protected Alarm removeImpl(Alarm alarm) throws SystemException {
		alarm = toUnwrappedModel(alarm);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(alarm)) {
				alarm = (Alarm)session.get(AlarmImpl.class,
						alarm.getPrimaryKeyObj());
			}

			if (alarm != null) {
				session.delete(alarm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (alarm != null) {
			clearCache(alarm);
		}

		return alarm;
	}

	@Override
	public Alarm updateImpl(com.nlu.entity.model.Alarm alarm)
		throws SystemException {
		alarm = toUnwrappedModel(alarm);

		boolean isNew = alarm.isNew();

		Session session = null;

		try {
			session = openSession();

			if (alarm.isNew()) {
				session.save(alarm);

				alarm.setNew(false);
			}
			else {
				session.merge(alarm);
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

		EntityCacheUtil.putResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
			AlarmImpl.class, alarm.getPrimaryKey(), alarm);

		return alarm;
	}

	protected Alarm toUnwrappedModel(Alarm alarm) {
		if (alarm instanceof AlarmImpl) {
			return alarm;
		}

		AlarmImpl alarmImpl = new AlarmImpl();

		alarmImpl.setNew(alarm.isNew());
		alarmImpl.setPrimaryKey(alarm.getPrimaryKey());

		alarmImpl.setAlarmId(alarm.getAlarmId());
		alarmImpl.setName(alarm.getName());
		alarmImpl.setStartTime(alarm.getStartTime());
		alarmImpl.setEndTime(alarm.getEndTime());
		alarmImpl.setValue(alarm.getValue());

		return alarmImpl;
	}

	/**
	 * Returns the alarm with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the alarm
	 * @return the alarm
	 * @throws com.nlu.entity.NoSuchAlarmException if a alarm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Alarm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAlarmException, SystemException {
		Alarm alarm = fetchByPrimaryKey(primaryKey);

		if (alarm == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAlarmException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return alarm;
	}

	/**
	 * Returns the alarm with the primary key or throws a {@link com.nlu.entity.NoSuchAlarmException} if it could not be found.
	 *
	 * @param alarmId the primary key of the alarm
	 * @return the alarm
	 * @throws com.nlu.entity.NoSuchAlarmException if a alarm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Alarm findByPrimaryKey(long alarmId)
		throws NoSuchAlarmException, SystemException {
		return findByPrimaryKey((Serializable)alarmId);
	}

	/**
	 * Returns the alarm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the alarm
	 * @return the alarm, or <code>null</code> if a alarm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Alarm fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Alarm alarm = (Alarm)EntityCacheUtil.getResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
				AlarmImpl.class, primaryKey);

		if (alarm == _nullAlarm) {
			return null;
		}

		if (alarm == null) {
			Session session = null;

			try {
				session = openSession();

				alarm = (Alarm)session.get(AlarmImpl.class, primaryKey);

				if (alarm != null) {
					cacheResult(alarm);
				}
				else {
					EntityCacheUtil.putResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
						AlarmImpl.class, primaryKey, _nullAlarm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AlarmModelImpl.ENTITY_CACHE_ENABLED,
					AlarmImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return alarm;
	}

	/**
	 * Returns the alarm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param alarmId the primary key of the alarm
	 * @return the alarm, or <code>null</code> if a alarm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Alarm fetchByPrimaryKey(long alarmId) throws SystemException {
		return fetchByPrimaryKey((Serializable)alarmId);
	}

	/**
	 * Returns all the alarms.
	 *
	 * @return the alarms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Alarm> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alarms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alarms
	 * @param end the upper bound of the range of alarms (not inclusive)
	 * @return the range of alarms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Alarm> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the alarms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alarms
	 * @param end the upper bound of the range of alarms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alarms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Alarm> findAll(int start, int end,
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

		List<Alarm> list = (List<Alarm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ALARM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALARM;

				if (pagination) {
					sql = sql.concat(AlarmModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Alarm>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Alarm>(list);
				}
				else {
					list = (List<Alarm>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the alarms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Alarm alarm : findAll()) {
			remove(alarm);
		}
	}

	/**
	 * Returns the number of alarms.
	 *
	 * @return the number of alarms
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

				Query q = session.createQuery(_SQL_COUNT_ALARM);

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
	 * Initializes the alarm persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.Alarm")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Alarm>> listenersList = new ArrayList<ModelListener<Alarm>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Alarm>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AlarmImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ALARM = "SELECT alarm FROM Alarm alarm";
	private static final String _SQL_COUNT_ALARM = "SELECT COUNT(alarm) FROM Alarm alarm";
	private static final String _ORDER_BY_ENTITY_ALIAS = "alarm.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Alarm exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AlarmPersistenceImpl.class);
	private static Alarm _nullAlarm = new AlarmImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Alarm> toCacheModel() {
				return _nullAlarmCacheModel;
			}
		};

	private static CacheModel<Alarm> _nullAlarmCacheModel = new CacheModel<Alarm>() {
			@Override
			public Alarm toEntityModel() {
				return _nullAlarm;
			}
		};
}