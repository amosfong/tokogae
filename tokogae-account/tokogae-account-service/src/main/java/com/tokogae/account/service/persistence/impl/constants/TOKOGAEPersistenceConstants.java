/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.persistence.impl.constants;

/**
 * @author Amos Fong
 * @generated
 */
public class TOKOGAEPersistenceConstants {

	public static final String BUNDLE_SYMBOLIC_NAME =
		"com.tokogae.account.service";

	public static final String ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER =
		"(origin.bundle.symbolic.name=" + BUNDLE_SYMBOLIC_NAME + ")";

	public static final String SERVICE_CONFIGURATION_FILTER =
		"(&" + ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER + "(name=service))";

}