/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

/**
 * @author Amos Fong
 */
public interface DataEventFactory {

	public DataEvent create(FoodItem foodItem);

	public DataEvent create(Symptom symptom);

}