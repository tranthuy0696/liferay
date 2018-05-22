create table Cpu (
	cpuId LONG not null primary key,
	time_ DATE null,
	min DOUBLE,
	max DOUBLE,
	aver DOUBLE
);

create table Ram (
	ramId LONG not null primary key,
	time_ DATE null,
	min DOUBLE,
	max DOUBLE,
	aver DOUBLE
);

create table diachi (
	id_ LONG not null primary key,
	tinh VARCHAR(75) null,
	huyen VARCHAR(75) null,
	xa VARCHAR(75) null,
	duong VARCHAR(75) null,
	duongKhac VARCHAR(75) null,
	khuPho VARCHAR(75) null,
	soNha VARCHAR(75) null,
	quocGia VARCHAR(75) null
);