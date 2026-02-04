/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.persistence.impl;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import com.tokogae.data.model.PhraseUsage;
import com.tokogae.data.service.persistence.PhraseUsagePersistence;
import com.tokogae.data.service.persistence.impl.constants.TOKOGAEDataPersistenceConstants;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 * @generated
 */
public abstract class PhraseUsageFinderBaseImpl
	extends BasePersistenceImpl<PhraseUsage> {

	public PhraseUsageFinderBaseImpl() {
		setModelClass(PhraseUsage.class);
	}

	@Override
	@Reference(
		target = TOKOGAEDataPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = TOKOGAEDataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TOKOGAEDataPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected PhraseUsagePersistence phraseUsagePersistence;

}