/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.data.event.service.base.FoodItemServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=tokogae_data",
		"json.web.service.context.path=FoodItem"
	},
	service = AopService.class
)
public class FoodItemServiceImpl extends FoodItemServiceBaseImpl {
}