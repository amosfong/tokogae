/**
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */

package com.tokogae.data.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SymptomLocalService}.
 *
 * @author Amos Fong
 * @see SymptomLocalService
 * @generated
 */
public class SymptomLocalServiceWrapper
	implements ServiceWrapper<SymptomLocalService>, SymptomLocalService {

	public SymptomLocalServiceWrapper() {
		this(null);
	}

	public SymptomLocalServiceWrapper(SymptomLocalService symptomLocalService) {
		_symptomLocalService = symptomLocalService;
	}

	@Override
	public com.tokogae.data.event.model.Symptom addSymptom(
			long userId, long subjectId, long occurDayBaseTime,
			long occurDayNativeTime, long duration, String name,
			String affectedArea, int intensityLevel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.addSymptom(
			userId, subjectId, occurDayBaseTime, occurDayNativeTime, duration,
			name, affectedArea, intensityLevel);
	}

	/**
	 * Adds the symptom to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptom the symptom
	 * @return the symptom that was added
	 */
	@Override
	public com.tokogae.data.event.model.Symptom addSymptom(
		com.tokogae.data.event.model.Symptom symptom) {

		return _symptomLocalService.addSymptom(symptom);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new symptom with the primary key. Does not add the symptom to the database.
	 *
	 * @param symptomId the primary key for the new symptom
	 * @return the new symptom
	 */
	@Override
	public com.tokogae.data.event.model.Symptom createSymptom(long symptomId) {
		return _symptomLocalService.createSymptom(symptomId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the symptom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom that was removed
	 * @throws PortalException if a symptom with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.Symptom deleteSymptom(long symptomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.deleteSymptom(symptomId);
	}

	/**
	 * Deletes the symptom from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptom the symptom
	 * @return the symptom that was removed
	 */
	@Override
	public com.tokogae.data.event.model.Symptom deleteSymptom(
		com.tokogae.data.event.model.Symptom symptom) {

		return _symptomLocalService.deleteSymptom(symptom);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _symptomLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _symptomLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _symptomLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _symptomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _symptomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _symptomLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _symptomLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _symptomLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.tokogae.data.event.model.Symptom fetchSymptom(long symptomId) {
		return _symptomLocalService.fetchSymptom(symptomId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _symptomLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _symptomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _symptomLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the symptom with the primary key.
	 *
	 * @param symptomId the primary key of the symptom
	 * @return the symptom
	 * @throws PortalException if a symptom with the primary key could not be found
	 */
	@Override
	public com.tokogae.data.event.model.Symptom getSymptom(long symptomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.getSymptom(symptomId);
	}

	/**
	 * Returns a range of all the symptoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokogae.data.event.model.impl.SymptomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of symptoms
	 * @param end the upper bound of the range of symptoms (not inclusive)
	 * @return the range of symptoms
	 */
	@Override
	public java.util.List<com.tokogae.data.event.model.Symptom> getSymptoms(
		int start, int end) {

		return _symptomLocalService.getSymptoms(start, end);
	}

	/**
	 * Returns the number of symptoms.
	 *
	 * @return the number of symptoms
	 */
	@Override
	public int getSymptomsCount() {
		return _symptomLocalService.getSymptomsCount();
	}

	@Override
	public com.tokogae.data.event.model.Symptom updateSymptom(
			long symptomId, long occurDayBaseTime, long occurDayNativeTime,
			long duration, String name, String affectedArea, int intensityLevel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _symptomLocalService.updateSymptom(
			symptomId, occurDayBaseTime, occurDayNativeTime, duration, name,
			affectedArea, intensityLevel);
	}

	/**
	 * Updates the symptom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SymptomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param symptom the symptom
	 * @return the symptom that was updated
	 */
	@Override
	public com.tokogae.data.event.model.Symptom updateSymptom(
		com.tokogae.data.event.model.Symptom symptom) {

		return _symptomLocalService.updateSymptom(symptom);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _symptomLocalService.getBasePersistence();
	}

	@Override
	public SymptomLocalService getWrappedService() {
		return _symptomLocalService;
	}

	@Override
	public void setWrappedService(SymptomLocalService symptomLocalService) {
		_symptomLocalService = symptomLocalService;
	}

	private SymptomLocalService _symptomLocalService;

}