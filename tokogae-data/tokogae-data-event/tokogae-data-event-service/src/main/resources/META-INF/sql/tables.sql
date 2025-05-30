create table Exercise (
	mvccVersion LONG default 0 not null,
	exerciseId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	occurDay LONG,
	occurDaySegment INTEGER,
	occurTime LONG,
	name VARCHAR(75) null,
	type_ INTEGER,
	duration INTEGER,
	intensityLevel INTEGER,
	quantity INTEGER
);

create table FoodItem (
	mvccVersion LONG default 0 not null,
	foodItemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	subjectId LONG,
	occurDay LONG,
	occurDaySegment INTEGER,
	occurTime LONG,
	name VARCHAR(75) null,
	locationOfOrigin VARCHAR(75) null,
	brand VARCHAR(75) null,
	quantity LONG,
	quantityUnit VARCHAR(75) null
);

create table Symptom (
	mvccVersion LONG default 0 not null,
	symptomId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	occurDay LONG,
	occurDaySegment INTEGER,
	occurTime LONG,
	name VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	intensityLevel INTEGER
);