/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Amos Fong
 * @generated
 */
@ProviderType
public interface PhraseUsageFinder {

	public java.util.List<Long> findByTopUsage(
		long phraseId, int start, int end);

}