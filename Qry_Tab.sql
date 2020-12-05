use master
go

create database DataPoolTest1

go


use DataPoolTest1
go

create table SetDatos1
(
IdRegistro int primary key identity(1,1),
DatoTest1 varchar(max),
ResultadoDatoTest1 varchar(max),
DatoTest2 varchar(max),
ResultadoDatoTest2 varchar(max)
)

insert into SetDatos1 (DatoTest1, ResultadoDatoTest1, DatoTest2, ResultadoDatoTest2)
values('dresses',null,null,null)
insert into SetDatos1 (DatoTest1, ResultadoDatoTest1, DatoTest2, ResultadoDatoTest2)
values('blouse',null,null,null)
insert into SetDatos1 (DatoTest1, ResultadoDatoTest1, DatoTest2, ResultadoDatoTest2)
values('short',null,null,null)



select * from SetDatos1..SetDatos1