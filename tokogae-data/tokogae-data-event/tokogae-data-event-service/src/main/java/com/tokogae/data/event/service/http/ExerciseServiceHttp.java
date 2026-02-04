/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.tokogae.data.event.service.ExerciseServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ExerciseServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Amos Fong
 * @generated
 */
public class ExerciseServiceHttp {

	public static com.tokogae.data.event.model.Exercise addExercise(
			HttpPrincipal httpPrincipal, long subjectId, long phraseId,
			long occurDayBaseTime, long occurDayNativeTime, String name,
			long duration, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExerciseServiceUtil.class, "addExercise",
				_addExerciseParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subjectId, phraseId, occurDayBaseTime,
				occurDayNativeTime, name, duration, quantity, quantityUnit);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.tokogae.data.event.model.Exercise)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.data.event.model.Exercise deleteExercise(
			HttpPrincipal httpPrincipal, long exerciseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExerciseServiceUtil.class, "deleteExercise",
				_deleteExerciseParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, exerciseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.tokogae.data.event.model.Exercise)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.data.event.model.Exercise updateExercise(
			HttpPrincipal httpPrincipal, long exerciseId, long occurDayBaseTime,
			long occurDayNativeTime, String name, long duration,
			double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExerciseServiceUtil.class, "updateExercise",
				_updateExerciseParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, exerciseId, occurDayBaseTime, occurDayNativeTime,
				name, duration, quantity, quantityUnit);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.tokogae.data.event.model.Exercise)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExerciseServiceHttp.class);

	private static final Class<?>[] _addExerciseParameterTypes0 = new Class[] {
		long.class, long.class, long.class, long.class, String.class,
		long.class, double.class, String.class
	};
	private static final Class<?>[] _deleteExerciseParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _updateExerciseParameterTypes2 =
		new Class[] {
			long.class, long.class, long.class, String.class, long.class,
			double.class, String.class
		};

}