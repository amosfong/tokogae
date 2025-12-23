/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.data.event.service.base.SymptomPeriodServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogaedata",
		"json.web.service.context.path=SymptomPeriod"
	},
	service = AopService.class
)
public class SymptomPeriodServiceImpl extends SymptomPeriodServiceBaseImpl {
}