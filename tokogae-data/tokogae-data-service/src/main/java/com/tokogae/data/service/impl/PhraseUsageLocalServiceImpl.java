/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.data.model.PhraseUsage;
import com.tokogae.data.service.base.PhraseUsageLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.model.PhraseUsage",
	service = AopService.class
)
public class PhraseUsageLocalServiceImpl
	extends PhraseUsageLocalServiceBaseImpl {

	public PhraseUsage addPhraseUsage(
		long userId, long phraseId, long classNameId, long classPK) {

		long phraseUsageId = counterLocalService.increment();

		PhraseUsage phraseUsage = phraseUsagePersistence.create(phraseUsageId);

		phraseUsage.setUserId(userId);
		phraseUsage.setPhraseId(phraseId);
		phraseUsage.setClassNameId(classNameId);
		phraseUsage.setClassPK(classPK);

		return phraseUsagePersistence.update(phraseUsage);
	}

	public void deletePhraseUsages(long classNameId, long classPK) {
		List<PhraseUsage> phraseUsages = phraseUsagePersistence.findByC_C(
			classNameId, classPK);

		for (PhraseUsage phraseUsage : phraseUsages) {
			phraseUsagePersistence.remove(phraseUsage);
		}
	}

	public List<PhraseUsage> getPhraseUsages(long phraseId) {
		return phraseUsagePersistence.findByPhraseId(phraseId);
	}

}