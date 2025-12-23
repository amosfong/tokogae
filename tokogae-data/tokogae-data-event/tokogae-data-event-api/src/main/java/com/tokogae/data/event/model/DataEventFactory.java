/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.model;

import com.liferay.portal.kernel.search.Document;

/**
 * @author Amos Fong
 */
public interface DataEventFactory {

	public DataEvent create(Document document) throws Exception;

	public DataEvent create(Exercise exercise);

	public DataEvent create(FoodItem foodItem);

	public DataEvent create(Sleep sleep);

	public DataEvent create(Symptom symptom);

}