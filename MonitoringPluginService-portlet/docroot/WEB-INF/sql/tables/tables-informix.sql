create table Cpu (
	cpuId int8 not null primary key,
	time_ datetime YEAR TO FRACTION,
	value float
)
extent size 16 next size 16
lock mode row;

create table Heap (
	heapId int8 not null primary key,
	time_ datetime YEAR TO FRACTION,
	value float
)
extent size 16 next size 16
lock mode row;

create table Network (
	networkId int8 not null primary key,
	time_ datetime YEAR TO FRACTION,
	down float,
	up float
)
extent size 16 next size 16
lock mode row;

create table NonHeap (
	nonHeapId int8 not null primary key,
	time_ datetime YEAR TO FRACTION,
	value float
)
extent size 16 next size 16
lock mode row;

create table Ram (
	ramId int8 not null primary key,
	time_ datetime YEAR TO FRACTION,
	value float
)
extent size 16 next size 16
lock mode row;


create table SessionRequest (
	sessionRequestId int8 not null primary key,
	sessionId varchar(75),
	time_ datetime YEAR TO FRACTION,
	ip varchar(75),
	browser varchar(75),
	os varchar(75),
	login boolean
)
extent size 16 next size 16
lock mode row;
