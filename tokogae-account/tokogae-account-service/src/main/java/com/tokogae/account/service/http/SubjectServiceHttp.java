/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.account.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.tokogae.account.service.SubjectServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>SubjectServiceUtil</code> service
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
public class SubjectServiceHttp {

	public static com.tokogae.account.model.Subject addSubject(
			HttpPrincipal httpPrincipal, String firstName, String lastName,
			String displayName, int gender, java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubjectServiceUtil.class, "addSubject",
				_addSubjectParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, firstName, lastName, displayName, gender, birthday);

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

			return (com.tokogae.account.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.account.model.Subject deleteSubject(
			HttpPrincipal httpPrincipal, long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubjectServiceUtil.class, "deleteSubject",
				_deleteSubjectParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subjectId);

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

			return (com.tokogae.account.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.account.model.Subject getSubject(
			HttpPrincipal httpPrincipal, long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubjectServiceUtil.class, "getSubject",
				_getSubjectParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subjectId);

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

			return (com.tokogae.account.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.tokogae.account.model.Subject> getSubjects(
		HttpPrincipal httpPrincipal, long userId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				SubjectServiceUtil.class, "getSubjects",
				_getSubjectsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.tokogae.account.model.Subject>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getSubjectsCount(
		HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				SubjectServiceUtil.class, "getSubjectsCount",
				_getSubjectsCountParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.tokogae.account.model.Subject updateSubject(
			HttpPrincipal httpPrincipal, long subjectId, String firstName,
			String lastName, String displayName, int gender,
			java.util.Date birthday)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				SubjectServiceUtil.class, "updateSubject",
				_updateSubjectParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subjectId, firstName, lastName, displayName, gender,
				birthday);

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

			return (com.tokogae.account.model.Subject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubjectServiceHttp.class);

	private static final Class<?>[] _addSubjectParameterTypes0 = new Class[] {
		String.class, String.class, String.class, int.class,
		java.util.Date.class
	};
	private static final Class<?>[] _deleteSubjectParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getSubjectParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getSubjectsParameterTypes3 = new Class[] {
		long.class, int.class, int.class
	};
	private static final Class<?>[] _getSubjectsCountParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _updateSubjectParameterTypes5 =
		new Class[] {
			long.class, String.class, String.class, String.class, int.class,
			java.util.Date.class
		};

}