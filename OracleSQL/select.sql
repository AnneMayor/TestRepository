/*
SELECT�� ( �Խù� �˻� �뵵�� ���� ����)
*/

-- bno�� 1���� 10������ �Խù��� �������ÿ�
select *
from board
where bno >= 1 and bno <= 10;

-- bwriter�� Dahye Lee�� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter = 'Dahye Lee';

-- bwriter�� Dahye Lee�� �Խù��� ��� �������ÿ�
select *
from board
where bwriter='Dahye Lee';

-- bwriter�� 'ȫ'�� �����ϴ� �Խù��� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter like '%ȫ%';

-- �Խù��� ���� �߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where btitle like '%�ڹ�%';

-- �Խù��� ���� or ���� �߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� bno, btitle, bwriter�� �������ÿ�

select bno, btitle, bwriter, bcontent
from board
where btitle like '%�ڹ�' or bcontent like '%�ڹ�%';

-- �۾��̰� '���ڹ�', '��浿', '�����'�� �Խù��� ��ȣ, ����, �۾��̸� �������ÿ�

select bno, btitle, bwriter
from board
where bwriter in('���ڹ�', '��浿', '�����');

-- ÷�������� ���� �Խù��� �������ÿ�

select *
from board
where boriginalfilename is null;

-- ÷�������� �ִ� �Խù��� �������ÿ�

select *
from board
where boriginalfilename is not null;

-- �Խù� �ۼ��� ����� �̸��� �������ÿ�(�ߺ� ����)

select distinct bwriter
from board;

-- �Խñ��� �� ��¥�� 2016���� �Խñ��� �������ÿ�

select *
from board
where bdate like '%16/%';

select *
from board
where bdate between '16/01/01' and '16/12/31';

-- bno -> ��ȣ, btitle -> ����, bwriter -> �۾��̷� �÷� �̸� �����ؼ� �������ÿ�(as ��������)
select bno as ��ȣ, btitle as ����, bwriter �۾���
from board;

/*
����
*/

-- �Խù� ��ȣ�� �������� �ø��������� �������ÿ�(DB�� ���� �Է��� �� ������ ������ �����ȿ� ä�����鼭 �����.)

select *
from board
order by bno asc;

-- 2017�⵵�� �ۼ��� �Խù��� ��ȣ�� �������� ������������ �������ÿ�

select *
from board
where bdate like '%17/%'
order by bno desc;

-- �۾��̸� �������� 1�� ����(�ø�����)�ϰ� �� ��¥�� �������� 2�� ����(��������)�Ͻÿ�

select * 
from board
order by bwriter asc, bdate desc;

/*
����¡ ó��: ��Ʈ��ũ ��ſ��� �����ϴ� ������ ���� ������ �������� ResultSet�� �����ϴµ� ����� ���� ��ü�� �����Ǿ� �޸𸮰� ����.
*/
-- ����Ǿ��ִ� ������� �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

/* selector���� �Ǵٸ� selector = subquery */
/* ���� �ֱٿ� �ۼ��� ���� ó������ ������ �ϱ� ���� ������ */
-- ���� �� �� ��ȣ �ű��
select rownum bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount
from board order by bno desc);
-- Ư�� ���ȣ ���ϸ� ��������(Top N ��������)
-- from table���� �ϳ��� ���ĵ� ���� ������ ������ rownum�� ����
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount
from board order by bno desc)
where rownum >= 10;
-- ���� ���ȣ�� �� ���ȣ ������ �Խù� ��������
-- where rownum <= pageNo*rowsPerPage)
-- where r >= (pageNo -1)*rowsPerPage + 1;
select *
from ( select rownum as r, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount
from board order by bno desc)
where rownum <= 2*15)
where r >= (2-1)*15+1;

/* 
�� �� ���ϱ�
*/

select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

-- Ư�� ���ǿ� �´� ��� ���ϱ�
select count(*) from board where bwriter <> 'Dahye Lee';