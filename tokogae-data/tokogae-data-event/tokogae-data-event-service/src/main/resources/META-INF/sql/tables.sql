create table FoodItem (
	mvccVersion LONG default 0 not null,
	foodItemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	name VARCHAR(75) null,
	locationOfOrigin VARCHAR(75) null,
	brand VARCHAR(75) null,
	quantity LONG,
	quantityUnit VARCHAR(75) null
);