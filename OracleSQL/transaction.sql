drop table account;
create table account(
   ano varchar(20) primary key,
   aowner varchar(10) not null,
   abalance number not null
);

--Rollback(������ commit���� �ǵ����� = ���� �۾��� ����Ѵ�)
insert into account values(
   '111-111', '�̴���', 100000000
);
insert into account values(
   '111-112', 'Dahye Lee', 1000000000
);
insert into account values(
   '222-222', 'Spring', 0
);
select * from account;
rollback;

--Commit(���� �۾��� ���������� �����Ѵ�(�ݿ��Ѵ�))
select * from account;
commit;

--��� ������ Ʈ����� ó��
update account set abalance=abalance-10000 where ano='111-111';
update account set abalance=abalance+10000 where ano='222-223';
rollback;
select * from account;