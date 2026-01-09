/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;

import com.tokogae.account.service.SubjectLocalService;
import com.tokogae.data.event.model.DataEvent;
import com.tokogae.data.event.model.DataEventFactory;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.service.base.SleepLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.event.model.Sleep",
	service = AopService.class
)
public class SleepLocalServiceImpl extends SleepLocalServiceBaseImpl {

	public Sleep addSleep(
			long userId, long subjectId, long occurDayBaseTime,
			long occurDayNativeTime, long duration)
		throws PortalException {

		_subjectLocalService.getSubject(subjectId);

		long sleepId = counterLocalService.increment();

		Sleep sleep = sleepPersistence.create(sleepId);

		sleep.setUserId(userId);
		sleep.setSubjectId(subjectId);
		sleep.setOccurDayBaseTime(occurDayBaseTime);
		sleep.setOccurDayNativeTime(occurDayNativeTime);
		sleep.setDuration(duration);

		sleep = sleepPersistence.update(sleep);

		DataEvent dataEvent = _dataEventFactory.create(sleep);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.reindex(dataEvent);

				return null;
			});

		return sleep;
	}

	@Override
	public Sleep deleteSleep(long sleepId) throws PortalException {
		Sleep sleep = sleepPersistence.remove(sleepId);

		DataEvent dataEvent = _dataEventFactory.create(sleep);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.delete(dataEvent);

				return null;
			});

		return sleep;
	}

	public Sleep updateSleep(
			long sleepId, long occurDayBaseTime, long occurDayNativeTime,
			long duration)
		throws PortalException {

		Sleep sleep = sleepPersistence.findByPrimaryKey(sleepId);

		sleep.setOccurDayBaseTime(occurDayBaseTime);
		sleep.setOccurDayNativeTime(occurDayNativeTime);
		sleep.setDuration(duration);

		sleep = sleepPersistence.update(sleep);

		DataEvent dataEvent = _dataEventFactory.create(sleep);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.reindex(dataEvent);

				return null;
			});

		return sleep;
	}

	@Reference
	private DataEventFactory _dataEventFactory;

	@Reference
	private IndexerRegistry _indexerRegistry;

	@Reference
	private SubjectLocalService _subjectLocalService;

}