/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.impl;

import com.liferay.portal.aop.AopService;

import com.tokogae.data.event.service.base.SymptomLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.tokogae.data.event.model.Symptom",
	service = AopService.class
)
public class SymptomLocalServiceImpl extends SymptomLocalServiceBaseImpl {
}