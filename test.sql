create table MonHoc(
	MaMH varchar(10) not null,
	TenMH varchar(30) not null,
	SoTC int,
	primary key(MaMH)
);

create table GiaoVien(
	MaGV varchar(10) not null,
	HoGV varchar(30) not null,
	TenGV varchar(30) not null,
	DonVi varchar(30) not null,
	primary key(MaGV)
);

create table SinhVien(
	MaSV varchar(10) not null,
	HoSV varchar(30) not null,
	TenSV varchar(30) not null,
	NgaySinh date,
	NoiSinh varchar(50),
	primary key(MaSV)
);

create table Lop(
	MaLop varchar(10) not null,
	MaMH varchar(10) not null,
	NamHoc int,
	HocKy int,
	MaGV varchar(10) not null,
	primary key(MaLop),
	foreign key(MaMH) references MonHoc(MaMH) on delete cascade,
	foreign key(MaGV) references GiaoVien(MaGV) on delete cascade
);

create table SinhVienLop(
	MaSV varchar(10) not null,
	MaLop varchar(10) not null,
	Diem double check(Diem between 0 and 10),
	primary key(MaSV, MaLop),
	foreign key(MaSV) references SinhVien(MaSV) on delete cascade,
	foreign key(MaLop) references Lop(MaLop) on delete cascade
);

insert into MonHoc values ('MH001','Math',3);
insert into MonHoc values ('MH002','Science',2);
insert into MonHoc values ('MH003','History',2);
insert into MonHoc values ('MH004','Chemistry',3);

insert into GiaoVien values ('GV001','Winston','Churchill','Math Division');
insert into GiaoVien values ('GV002','Martin','Luther','Math Division');
insert into GiaoVien values ('GV003','Mohandas','Gandhi','Science Division');
insert into GiaoVien values ('GV004','Mikhail','Gorbachyov','History Division');
insert into GiaoVien values ('GV005','Adolf','Hitler','Chemistry Division');

insert into SinhVien values ('SV001','Ruhollah','Khomeini','1999-01-01','London');
insert into SinhVien values ('SV002','Vladimir','Lenin','1999-03-02','Moscow');
insert into SinhVien values ('SV003','Nelson','Mandela','1999-02-18','Bangkok');
insert into SinhVien values ('SV004','John','Paul','1999-10-21','Shanghai');

insert into Lop values ('L001','MH001',2020,1,'GV001');
insert into Lop values ('L002','MH002',2020,1,'GV003');
insert into Lop values ('L003','MH003',2020,1,'GV004');
insert into Lop values ('L004','MH004',2020,1,'GV005');

insert into SinhVienLop values ('SV001','L001',6);
insert into SinhVienLop values ('SV001','L002',8);
insert into SinhVienLop values ('SV001','L004',7);

insert into SinhVienLop values ('SV002','L002',9);
insert into SinhVienLop values ('SV002','L003',8);
insert into SinhVienLop values ('SV002','L004',7);

insert into SinhVienLop values ('SV003','L001',6);
insert into SinhVienLop values ('SV003','L002',4);
insert into SinhVienLop values ('SV003','L003',5);

insert into SinhVienLop values ('SV004','L001',8);
insert into SinhVienLop values ('SV004','L003',10);
insert into SinhVienLop values ('SV004','L004',9);