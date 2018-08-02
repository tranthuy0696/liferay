create table Alarm (
	alarmId LONG not null primary key,
	name VARCHAR(75) null,
	startTime INTEGER,
	endTime INTEGER,
	value DOUBLE
);

create table AlarmInfo (
	alarmInfoId LONG not null primary key,
	name VARCHAR(75) null,
	mail VARCHAR(75) null
);