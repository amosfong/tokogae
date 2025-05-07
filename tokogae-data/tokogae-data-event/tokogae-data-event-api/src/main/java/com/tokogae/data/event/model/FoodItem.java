/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the FoodItem service. Represents a row in the &quot;FoodItem&quot; database table, with each column mapped to a property of this class.
 *
 * @author Amos Fong
 * @see FoodItemModel
 * @generated
 */
@ImplementationClassName("com.tokogae.data.event.model.impl.FoodItemImpl")
@ProviderType
public interface FoodItem extends FoodItemModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.tokogae.data.event.model.impl.FoodItemImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FoodItem, Long> FOOD_ITEM_ID_ACCESSOR =
		new Accessor<FoodItem, Long>() {

			@Override
			public Long get(FoodItem foodItem) {
				return foodItem.getFoodItemId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FoodItem> getTypeClass() {
				return FoodItem.class;
			}

		};

}