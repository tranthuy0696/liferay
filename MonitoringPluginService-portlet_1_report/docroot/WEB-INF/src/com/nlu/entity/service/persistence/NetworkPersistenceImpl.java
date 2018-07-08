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

import com.nlu.entity.NoSuchNetworkException;
import com.nlu.entity.model.Network;
import com.nlu.entity.model.impl.NetworkImpl;
import com.nlu.entity.model.impl.NetworkModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the network service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see NetworkPersistence
 * @see NetworkUtil
 * @generated
 */
public class NetworkPersistenceImpl extends BasePersistenceImpl<Network>
	implements NetworkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NetworkUtil} to access the network persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NetworkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NetworkModelImpl.ENTITY_CACHE_ENABLED,
			NetworkModelImpl.FINDER_CACHE_ENABLED, NetworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NetworkModelImpl.ENTITY_CACHE_ENABLED,
			NetworkModelImpl.FINDER_CACHE_ENABLED, NetworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NetworkModelImpl.ENTITY_CACHE_ENABLED,
			NetworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NetworkPersistenceImpl() {
		setModelClass(Network.class);
	}

	/**
	 * Caches the network in the entity cache if it is enabled.
	 *
	 * @param network the network
	 */
	@Override
	public void cacheResult(Network network) {
		EntityCacheUtil.putResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
			NetworkImpl.class, network.getPrimaryKey(), network);

		network.resetOriginalValues();
	}

	/**
	 * Caches the networks in the entity cache if it is enabled.
	 *
	 * @param networks the networks
	 */
	@Override
	public void cacheResult(List<Network> networks) {
		for (Network network : networks) {
			if (EntityCacheUtil.getResult(
						NetworkModelImpl.ENTITY_CACHE_ENABLED,
						NetworkImpl.class, network.getPrimaryKey()) == null) {
				cacheResult(network);
			}
			else {
				network.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all networks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NetworkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NetworkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the network.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Network network) {
		EntityCacheUtil.removeResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
			NetworkImpl.class, network.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Network> networks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Network network : networks) {
			EntityCacheUtil.removeResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
				NetworkImpl.class, network.getPrimaryKey());
		}
	}

	/**
	 * Creates a new network with the primary key. Does not add the network to the database.
	 *
	 * @param networkId the primary key for the new network
	 * @return the new network
	 */
	@Override
	public Network create(long networkId) {
		Network network = new NetworkImpl();

		network.setNew(true);
		network.setPrimaryKey(networkId);

		return network;
	}

	/**
	 * Removes the network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param networkId the primary key of the network
	 * @return the network that was removed
	 * @throws com.nlu.entity.NoSuchNetworkException if a network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Network remove(long networkId)
		throws NoSuchNetworkException, SystemException {
		return remove((Serializable)networkId);
	}

	/**
	 * Removes the network with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the network
	 * @return the network that was removed
	 * @throws com.nlu.entity.NoSuchNetworkException if a network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Network remove(Serializable primaryKey)
		throws NoSuchNetworkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Network network = (Network)session.get(NetworkImpl.class, primaryKey);

			if (network == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNetworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(network);
		}
		catch (NoSuchNetworkException nsee) {
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
	protected Network removeImpl(Network network) throws SystemException {
		network = toUnwrappedModel(network);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(network)) {
				network = (Network)session.get(NetworkImpl.class,
						network.getPrimaryKeyObj());
			}

			if (network != null) {
				session.delete(network);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (network != null) {
			clearCache(network);
		}

		return network;
	}

	@Override
	public Network updateImpl(com.nlu.entity.model.Network network)
		throws SystemException {
		network = toUnwrappedModel(network);

		boolean isNew = network.isNew();

		Session session = null;

		try {
			session = openSession();

			if (network.isNew()) {
				session.save(network);

				network.setNew(false);
			}
			else {
				session.merge(network);
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

		EntityCacheUtil.putResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
			NetworkImpl.class, network.getPrimaryKey(), network);

		return network;
	}

	protected Network toUnwrappedModel(Network network) {
		if (network instanceof NetworkImpl) {
			return network;
		}

		NetworkImpl networkImpl = new NetworkImpl();

		networkImpl.setNew(network.isNew());
		networkImpl.setPrimaryKey(network.getPrimaryKey());

		networkImpl.setNetworkId(network.getNetworkId());
		networkImpl.setTime(network.getTime());
		networkImpl.setDown(network.getDown());
		networkImpl.setUp(network.getUp());

		return networkImpl;
	}

	/**
	 * Returns the network with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the network
	 * @return the network
	 * @throws com.nlu.entity.NoSuchNetworkException if a network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Network findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNetworkException, SystemException {
		Network network = fetchByPrimaryKey(primaryKey);

		if (network == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNetworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return network;
	}

	/**
	 * Returns the network with the primary key or throws a {@link com.nlu.entity.NoSuchNetworkException} if it could not be found.
	 *
	 * @param networkId the primary key of the network
	 * @return the network
	 * @throws com.nlu.entity.NoSuchNetworkException if a network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Network findByPrimaryKey(long networkId)
		throws NoSuchNetworkException, SystemException {
		return findByPrimaryKey((Serializable)networkId);
	}

	/**
	 * Returns the network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the network
	 * @return the network, or <code>null</code> if a network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Network fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Network network = (Network)EntityCacheUtil.getResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
				NetworkImpl.class, primaryKey);

		if (network == _nullNetwork) {
			return null;
		}

		if (network == null) {
			Session session = null;

			try {
				session = openSession();

				network = (Network)session.get(NetworkImpl.class, primaryKey);

				if (network != null) {
					cacheResult(network);
				}
				else {
					EntityCacheUtil.putResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
						NetworkImpl.class, primaryKey, _nullNetwork);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NetworkModelImpl.ENTITY_CACHE_ENABLED,
					NetworkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return network;
	}

	/**
	 * Returns the network with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param networkId the primary key of the network
	 * @return the network, or <code>null</code> if a network with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Network fetchByPrimaryKey(long networkId) throws SystemException {
		return fetchByPrimaryKey((Serializable)networkId);
	}

	/**
	 * Returns all the networks.
	 *
	 * @return the networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Network> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of networks
	 * @param end the upper bound of the range of networks (not inclusive)
	 * @return the range of networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Network> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the networks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NetworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of networks
	 * @param end the upper bound of the range of networks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of networks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Network> findAll(int start, int end,
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

		List<Network> list = (List<Network>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NETWORK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NETWORK;

				if (pagination) {
					sql = sql.concat(NetworkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Network>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Network>(list);
				}
				else {
					list = (List<Network>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the networks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Network network : findAll()) {
			remove(network);
		}
	}

	/**
	 * Returns the number of networks.
	 *
	 * @return the number of networks
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

				Query q = session.createQuery(_SQL_COUNT_NETWORK);

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
	 * Initializes the network persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nlu.entity.model.Network")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Network>> listenersList = new ArrayList<ModelListener<Network>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Network>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NetworkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NETWORK = "SELECT network FROM Network network";
	private static final String _SQL_COUNT_NETWORK = "SELECT COUNT(network) FROM Network network";
	private static final String _ORDER_BY_ENTITY_ALIAS = "network.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Network exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NetworkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"time"
			});
	private static Network _nullNetwork = new NetworkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Network> toCacheModel() {
				return _nullNetworkCacheModel;
			}
		};

	private static CacheModel<Network> _nullNetworkCacheModel = new CacheModel<Network>() {
			@Override
			public Network toEntityModel() {
				return _nullNetwork;
			}
		};
}