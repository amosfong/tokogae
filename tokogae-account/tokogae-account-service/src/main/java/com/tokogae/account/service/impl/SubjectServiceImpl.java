/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.account.service.base.SubjectServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogae",
		"json.web.service.context.path=Subject"
	},
	service = AopService.class
)
public class SubjectServiceImpl extends SubjectServiceBaseImpl {
}