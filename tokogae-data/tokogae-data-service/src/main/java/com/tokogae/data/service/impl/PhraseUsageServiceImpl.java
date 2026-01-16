/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.data.service.base.PhraseUsageServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogaedata",
		"json.web.service.context.path=PhraseUsage"
	},
	service = AopService.class
)
public class PhraseUsageServiceImpl extends PhraseUsageServiceBaseImpl {
}