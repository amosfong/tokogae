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
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.service.base.ExerciseLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.event.model.Exercise",
	service = AopService.class
)
public class ExerciseLocalServiceImpl extends ExerciseLocalServiceBaseImpl {

	public Exercise addExercise(
			long userId, long subjectId, long occurDay, int occurDaySegment,
			long occurTime, String name, long duration, double quantity,
			String quantityUnit)
		throws PortalException {

		_subjectLocalService.getSubject(subjectId);

		long exerciseId = counterLocalService.increment();

		Exercise exercise = exercisePersistence.create(exerciseId);

		exercise.setUserId(userId);
		exercise.setSubjectId(subjectId);
		exercise.setOccurDay(occurDay);
		exercise.setOccurDaySegment(occurDaySegment);
		exercise.setOccurTime(occurTime);
		exercise.setName(name);
		exercise.setDuration(duration);
		exercise.setQuantity(quantity);
		exercise.setQuantityUnit(quantityUnit);

		exercise = exercisePersistence.update(exercise);

		DataEvent dataEvent = _dataEventFactory.create(exercise);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.reindex(dataEvent);

				return null;
			});

		return exercise;
	}

	@Override
	public Exercise deleteExercise(long exerciseId) throws PortalException {
		Exercise exercise = exercisePersistence.remove(exerciseId);

		DataEvent dataEvent = _dataEventFactory.create(exercise);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.delete(dataEvent);

				return null;
			});

		return exercise;
	}

	public Exercise updateExercise(
			long exerciseId, long occurDay, int occurDaySegment, long occurTime,
			String name, long duration, double quantity, String quantityUnit)
		throws PortalException {

		Exercise exercise = exercisePersistence.findByPrimaryKey(exerciseId);

		exercise.setOccurDay(occurDay);
		exercise.setOccurDaySegment(occurDaySegment);
		exercise.setOccurTime(occurTime);
		exercise.setName(name);
		exercise.setDuration(duration);
		exercise.setQuantity(quantity);
		exercise.setQuantityUnit(quantityUnit);

		exercise = exercisePersistence.update(exercise);

		DataEvent dataEvent = _dataEventFactory.create(exercise);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.reindex(dataEvent);

				return null;
			});

		return exercise;
	}

	@Reference
	private DataEventFactory _dataEventFactory;

	@Reference
	private IndexerRegistry _indexerRegistry;

	@Reference
	private SubjectLocalService _subjectLocalService;

}