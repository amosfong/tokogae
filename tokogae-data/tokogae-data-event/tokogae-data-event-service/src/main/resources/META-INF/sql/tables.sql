create table TOKOGAEData_Exercise (
	mvccVersion LONG default 0 not null,
	exerciseId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	subjectId LONG,
	occurDayBaseTime LONG,
	occurDayNativeTime LONG,
	name VARCHAR(75) null,
	duration LONG,
	quantity DOUBLE,
	quantityUnit VARCHAR(75) null
);

create table TOKOGAEData_FoodItem (
	mvccVersion LONG default 0 not null,
	foodItemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	subjectId LONG,
	occurDayBaseTime LONG,
	occurDayNativeTime LONG,
	name VARCHAR(75) null,
	locationOfOrigin VARCHAR(75) null,
	brand VARCHAR(75) null,
	quantity DOUBLE,
	quantityUnit VARCHAR(75) null
);

create table TOKOGAEData_Sleep (
	mvccVersion LONG default 0 not null,
	sleepId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	subjectId LONG,
	occurDayBaseTime LONG,
	occurDayNativeTime LONG,
	duration LONG
);

create table TOKOGAEData_Symptom (
	mvccVersion LONG default 0 not null,
	symptomId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	subjectId LONG,
	occurDayBaseTime LONG,
	occurDayNativeTime LONG,
	duration LONG,
	name VARCHAR(75) null,
	affectedArea VARCHAR(75) null,
	intensityLevel INTEGER
);

create table TOKOGAEData_SymptomPeriod (
	mvccVersion LONG default 0 not null,
	symptomId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	subjectId LONG,
	name VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
);