create table TOKOGAEData_Phrase (
	mvccVersion LONG default 0 not null,
	phraseId LONG not null primary key,
	companyId LONG,
	text_ VARCHAR(250) null
);

create table TOKOGAEData_PhraseUsage (
	mvccVersion LONG default 0 not null,
	phraseUsageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	phraseId LONG,
	classNameId LONG,
	classPK LONG
);