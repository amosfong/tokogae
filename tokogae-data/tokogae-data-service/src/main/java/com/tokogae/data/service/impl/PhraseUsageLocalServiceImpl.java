/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ClassNameLocalService;

import com.tokogae.data.model.PhraseUsage;
import com.tokogae.data.service.base.PhraseUsageLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
		long userId, long phraseId, String className, long classPK,
		int attributesHashCode) {

		long phraseUsageId = counterLocalService.increment();

		PhraseUsage phraseUsage = phraseUsagePersistence.create(phraseUsageId);

		phraseUsage.setUserId(userId);
		phraseUsage.setPhraseId(phraseId);
		phraseUsage.setClassName(className);
		phraseUsage.setClassPK(classPK);
		phraseUsage.setAttributesHashCode(attributesHashCode);

		return phraseUsagePersistence.update(phraseUsage);
	}

	public PhraseUsage deletePhraseUsage(long classNameId, long classPK)
		throws PortalException {

		return phraseUsagePersistence.removeByC_C(classNameId, classPK);
	}

	public PhraseUsage fetchPhraseUsage(String className, long classPK) {
		long classNameId = _classNameLocalService.getClassNameId(className);

		return phraseUsagePersistence.fetchByC_C(classNameId, classPK);
	}

	public List<PhraseUsage> getPhraseUsages(long phraseId, int start, int end)
		throws PortalException {

		List<PhraseUsage> phraseUsages = new ArrayList<>();

		List<Long> phraseUsageIds = phraseUsageFinder.findByTopUsage(
			phraseId, start, end);

		for (Long phraseUsageId : phraseUsageIds) {
			phraseUsages.add(
				phraseUsagePersistence.findByPrimaryKey(phraseUsageId));
		}

		return phraseUsages;
	}

	public PhraseUsage updatePhraseUsage(
			long phraseUsageId, int attributesHashCode)
		throws PortalException {

		PhraseUsage phraseUsage = phraseUsagePersistence.findByPrimaryKey(
			phraseUsageId);

		phraseUsage.setAttributesHashCode(attributesHashCode);

		return phraseUsagePersistence.update(phraseUsage);
	}

	@Reference
	private ClassNameLocalService _classNameLocalService;

}