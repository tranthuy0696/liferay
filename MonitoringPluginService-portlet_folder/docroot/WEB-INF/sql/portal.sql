create table Cpu (
	cpuId LONG not null primary key,
	time_ DATE null,
	value DOUBLE
);

create table Heap (
	heapId LONG not null primary key,
	time_ DATE null,
	value DOUBLE
);

create table NonHeap (
	nonHeapId LONG not null primary key,
	time_ DATE null,
	value DOUBLE
);

create table Ram (
	ramId LONG not null primary key,
	time_ DATE null,
	value DOUBLE
);

create table SessionRequest (
	sessionRequestId LONG not null primary key,
	sessionId VARCHAR(75) null,
	time_ DATE null,
	ip VARCHAR(75) null,
	browser VARCHAR(75) null,
	os VARCHAR(75) null,
	login BOOLEAN
);