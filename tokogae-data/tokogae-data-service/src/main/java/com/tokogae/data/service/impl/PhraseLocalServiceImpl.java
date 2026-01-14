/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.data.model.Phrase;
import com.tokogae.data.service.base.PhraseLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.model.Phrase",
	service = AopService.class
)
public class PhraseLocalServiceImpl extends PhraseLocalServiceBaseImpl {

	public Phrase addPhrase(String text) {
		long phraseId = counterLocalService.increment();

		Phrase phrase = phrasePersistence.create(phraseId);

		phrase.setText(text);

		return phrasePersistence.update(phrase);
	}

	public Phrase fetchPhraseByText(String text) {
		return phrasePersistence.fetchByText(text);
	}

}