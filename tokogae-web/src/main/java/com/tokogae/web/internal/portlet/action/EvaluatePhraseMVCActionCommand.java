/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import com.tokogae.account.exception.NoSuchSubjectException;
import com.tokogae.data.event.model.Exercise;
import com.tokogae.data.event.model.FoodItem;
import com.tokogae.data.event.model.Sleep;
import com.tokogae.data.event.model.Symptom;
import com.tokogae.data.event.service.ExerciseLocalService;
import com.tokogae.data.event.service.ExerciseService;
import com.tokogae.data.event.service.FoodItemLocalService;
import com.tokogae.data.event.service.FoodItemService;
import com.tokogae.data.event.service.SleepLocalService;
import com.tokogae.data.event.service.SleepService;
import com.tokogae.data.event.service.SymptomLocalService;
import com.tokogae.data.event.service.SymptomService;
import com.tokogae.data.model.Phrase;
import com.tokogae.data.model.PhraseUsage;
import com.tokogae.data.service.PhraseLocalService;
import com.tokogae.data.service.PhraseUsageLocalService;
import com.tokogae.web.internal.constants.TokogaePortletKeys;

import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;
import jakarta.portlet.PortletURL;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"jakarta.portlet.name=" + TokogaePortletKeys.TOKOGAE,
		"mvc.command.name=/tokogae/evaluate_phrase"
	},
	service = MVCActionCommand.class
)
public class EvaluatePhraseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String phraseText = ParamUtil.getString(actionRequest, "phraseText");

		try {
			Phrase phrase = _phraseLocalService.fetchPhraseByText(phraseText);

			if (phrase != null) {
				List<PhraseUsage> phraseUsages =
					_phraseUsageLocalService.getPhraseUsages(
						phrase.getPhraseId(), 0, 1);

				if (phraseUsages.size() == 1) {
					PhraseUsage phraseUsage = phraseUsages.get(0);

					String className = phraseUsage.getClassName();

					if (className.equals(Exercise.class.getName())) {
						_addExercise(
							actionRequest, phraseUsage.getClassPK(),
							phrase.getPhraseId());
					}
					else if (className.equals(FoodItem.class.getName())) {
						_addFoodItem(
							actionRequest, phraseUsage.getClassPK(),
							phrase.getPhraseId());
					}
					else if (className.equals(Sleep.class.getName())) {
						_addSleep(
							actionRequest, phraseUsage.getClassPK(),
							phrase.getPhraseId());
					}
					else if (className.equals(Symptom.class.getName())) {
						_addSymptom(
							actionRequest, phraseUsage.getClassPK(),
							phrase.getPhraseId());
					}

					sendRedirect(actionRequest, actionResponse);

					return;
				}
			}
			else {
				phrase = _phraseLocalService.addPhrase(phraseText);
			}

			_sendRedirect(actionRequest, actionResponse, phrase);
		}
		catch (NoSuchSubjectException noSuchSubjectException) {
			SessionErrors.add(actionRequest, noSuchSubjectException.getClass());
		}
	}

	private void _addExercise(
			ActionRequest actionRequest, long exerciseId, long phraseId)
		throws Exception {

		Exercise exercise = _exerciseLocalService.getExercise(exerciseId);

		Date now = new Date();

		_exerciseService.addExercise(
			getSubjectId(actionRequest), phraseId,
			getBaseTime(actionRequest, now), getNativeTime(actionRequest, now),
			exercise.getName(), exercise.getDuration(), exercise.getQuantity(),
			exercise.getQuantityUnit());
	}

	private void _addFoodItem(
			ActionRequest actionRequest, long foodItemId, long phraseId)
		throws Exception {

		FoodItem foodItem = _foodItemLocalService.getFoodItem(foodItemId);

		Date now = new Date();

		_foodItemService.addFoodItem(
			getSubjectId(actionRequest), phraseId,
			getBaseTime(actionRequest, now), getNativeTime(actionRequest, now),
			foodItem.getName(), foodItem.getLocationOfOrigin(),
			foodItem.getBrand(), foodItem.getQuantity(),
			foodItem.getQuantityUnit());
	}

	private void _addSleep(
			ActionRequest actionRequest, long sleepId, long phraseId)
		throws Exception {

		Sleep sleep = _sleepLocalService.getSleep(sleepId);

		Date now = new Date();

		_sleepService.addSleep(
			getSubjectId(actionRequest), phraseId,
			getBaseTime(actionRequest, now), getNativeTime(actionRequest, now),
			sleep.getDuration());
	}

	private void _addSymptom(
			ActionRequest actionRequest, long symptomId, long phraseId)
		throws Exception {

		Symptom symptom = _symptomLocalService.getSymptom(symptomId);

		Date now = new Date();

		_symptomService.addSymptom(
			getSubjectId(actionRequest), phraseId,
			getBaseTime(actionRequest, now), getNativeTime(actionRequest, now),
			symptom.getDuration(), symptom.getName(), symptom.getAffectedArea(),
			symptom.getIntensityLevel());
	}

	private void _sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse,
			Phrase phrase)
		throws Exception {

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		PortletURL portletURL = PortletURLBuilder.createRenderURL(
			_portal.getLiferayPortletResponse(actionResponse)
		).setMVCRenderCommandName(
			"/tokogae/edit_data_event"
		).setRedirect(
			redirect
		).setParameter(
			"phraseId", phrase.getPhraseId()
		).buildPortletURL();

		sendRedirect(actionRequest, actionResponse, portletURL.toString());
	}

	@Reference
	private ExerciseLocalService _exerciseLocalService;

	@Reference
	private ExerciseService _exerciseService;

	@Reference
	private FoodItemLocalService _foodItemLocalService;

	@Reference
	private FoodItemService _foodItemService;

	@Reference
	private PhraseLocalService _phraseLocalService;

	@Reference
	private PhraseUsageLocalService _phraseUsageLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private SleepLocalService _sleepLocalService;

	@Reference
	private SleepService _sleepService;

	@Reference
	private SymptomLocalService _symptomLocalService;

	@Reference
	private SymptomService _symptomService;

}