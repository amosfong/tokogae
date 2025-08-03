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
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.service.base.FoodItemLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.event.model.FoodItem",
	service = AopService.class
)
public class FoodItemLocalServiceImpl extends FoodItemLocalServiceBaseImpl {

	public FoodItem addFoodItem(
			long userId, long subjectId, long occurDay, int occurDaySegment,
			long occurTime, String name, String locationOfOrigin, String brand,
			int quantity, String quantityUnit)
		throws PortalException {

		_subjectLocalService.getSubject(subjectId);

		long foodItemId = counterLocalService.increment();

		FoodItem foodItem = foodItemPersistence.create(foodItemId);

		foodItem.setUserId(userId);
		foodItem.setSubjectId(subjectId);
		foodItem.setOccurDay(occurDay);
		foodItem.setOccurDaySegment(occurDaySegment);
		foodItem.setOccurTime(occurTime);
		foodItem.setName(name);
		foodItem.setLocationOfOrigin(locationOfOrigin);
		foodItem.setBrand(brand);
		foodItem.setQuantity(quantity);
		foodItem.setQuantityUnit(quantityUnit);

		foodItem = foodItemPersistence.update(foodItem);

		DataEvent dataEvent = _dataEventFactory.create(foodItem);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.reindex(dataEvent);

				return null;
			});

		return foodItem;
	}

	@Override
	public FoodItem deleteFoodItem(long foodItemId) throws PortalException {
		FoodItem foodItem = foodItemPersistence.remove(foodItemId);

		DataEvent dataEvent = _dataEventFactory.create(foodItem);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.delete(dataEvent);

				return null;
			});

		return foodItem;
	}

	public FoodItem updateFoodItem(
			long foodItemId, long occurDay, int occurDaySegment, long occurTime,
			String name, String locationOfOrigin, String brand, int quantity,
			String quantityUnit)
		throws PortalException {

		FoodItem foodItem = foodItemPersistence.findByPrimaryKey(foodItemId);

		foodItem.setOccurDay(occurDay);
		foodItem.setOccurDaySegment(occurDaySegment);
		foodItem.setOccurTime(occurTime);
		foodItem.setName(name);
		foodItem.setLocationOfOrigin(locationOfOrigin);
		foodItem.setBrand(brand);
		foodItem.setQuantity(quantity);
		foodItem.setQuantityUnit(quantityUnit);

		foodItem = foodItemPersistence.update(foodItem);

		DataEvent dataEvent = _dataEventFactory.create(foodItem);

		TransactionCommitCallbackUtil.registerCallback(
			() -> {
				Indexer<DataEvent> indexer = _indexerRegistry.getIndexer(
					DataEvent.class);

				indexer.reindex(dataEvent);

				return null;
			});

		return foodItem;
	}

	@Reference
	private DataEventFactory _dataEventFactory;

	@Reference
	private IndexerRegistry _indexerRegistry;

	@Reference
	private SubjectLocalService _subjectLocalService;

}