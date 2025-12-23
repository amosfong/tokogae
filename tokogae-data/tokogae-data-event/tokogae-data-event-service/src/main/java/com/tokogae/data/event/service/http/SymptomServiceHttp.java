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

import com.tokogae.data.event.service.SymptomServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SymptomServiceUtil</code> service
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
public class SymptomServiceHttp {

	public static com.tokogae.data.event.model.Symptom addSymptom(
			HttpPrincipal httpPrincipal, long subjectId, long occurDay,
			int occurDaySegment, long occurTime, String name,
			String affectedArea, boolean extended, java.util.Date startDate,
			java.util.Date endDate, int intensityLevel)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SymptomServiceUtil.class, "addSymptom",
				_addSymptomParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subjectId, occurDay, occurDaySegment, occurTime,
				name, affectedArea, extended, startDate, endDate,
				intensityLevel);

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

			return (com.tokogae.data.event.model.Symptom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.data.event.model.Symptom deleteSymptom(
			HttpPrincipal httpPrincipal, long symptomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SymptomServiceUtil.class, "deleteSymptom",
				_deleteSymptomParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, symptomId);

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

			return (com.tokogae.data.event.model.Symptom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.data.event.model.Symptom updateSymptom(
			HttpPrincipal httpPrincipal, long symptomId, long occurDay,
			int occurDaySegment, long occurTime, String name,
			String affectedArea, boolean extended, java.util.Date startDate,
			java.util.Date endDate, int intensityLevel)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SymptomServiceUtil.class, "updateSymptom",
				_updateSymptomParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, symptomId, occurDay, occurDaySegment, occurTime,
				name, affectedArea, extended, startDate, endDate,
				intensityLevel);

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

			return (com.tokogae.data.event.model.Symptom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SymptomServiceHttp.class);

	private static final Class<?>[] _addSymptomParameterTypes0 = new Class[] {
		long.class, long.class, int.class, long.class, String.class,
		String.class, boolean.class, java.util.Date.class, java.util.Date.class,
		int.class
	};
	private static final Class<?>[] _deleteSymptomParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _updateSymptomParameterTypes2 =
		new Class[] {
			long.class, long.class, int.class, long.class, String.class,
			String.class, boolean.class, java.util.Date.class,
			java.util.Date.class, int.class
		};

}