create table TOKOGAE_Subject (
	mvccVersion LONG default 0 not null,
	subjectId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	displayName VARCHAR(75) null,
	gender INTEGER,
	birthday DATE null
);