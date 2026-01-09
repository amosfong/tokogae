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

import com.tokogae.data.event.service.FoodItemServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>FoodItemServiceUtil</code> service
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
public class FoodItemServiceHttp {

	public static com.tokogae.data.event.model.FoodItem addFoodItem(
			HttpPrincipal httpPrincipal, long subjectId, long occurDayBaseTime,
			long occurDayNativeTime, String name, String locationOfOrigin,
			String brand, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FoodItemServiceUtil.class, "addFoodItem",
				_addFoodItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subjectId, occurDayBaseTime, occurDayNativeTime,
				name, locationOfOrigin, brand, quantity, quantityUnit);

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

			return (com.tokogae.data.event.model.FoodItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.data.event.model.FoodItem deleteFoodItem(
			HttpPrincipal httpPrincipal, long foodItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FoodItemServiceUtil.class, "deleteFoodItem",
				_deleteFoodItemParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, foodItemId);

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

			return (com.tokogae.data.event.model.FoodItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.data.event.model.FoodItem updateFoodItem(
			HttpPrincipal httpPrincipal, long foodItemId, long occurDayBaseTime,
			long occurDayNativeTime, String name, String locationOfOrigin,
			String brand, double quantity, String quantityUnit)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FoodItemServiceUtil.class, "updateFoodItem",
				_updateFoodItemParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, foodItemId, occurDayBaseTime, occurDayNativeTime,
				name, locationOfOrigin, brand, quantity, quantityUnit);

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

			return (com.tokogae.data.event.model.FoodItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FoodItemServiceHttp.class);

	private static final Class<?>[] _addFoodItemParameterTypes0 = new Class[] {
		long.class, long.class, long.class, String.class, String.class,
		String.class, double.class, String.class
	};
	private static final Class<?>[] _deleteFoodItemParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _updateFoodItemParameterTypes2 =
		new Class[] {
			long.class, long.class, long.class, String.class, String.class,
			String.class, double.class, String.class
		};

}