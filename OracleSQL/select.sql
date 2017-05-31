/*
SELECT문 ( 게시물 검색 용도로 많이 쓰임)
*/

-- bno가 1에서 10사이의 게시물을 가져오시오
select *
from board
where bno >= 1 and bno <= 10;

-- bwriter가 Dahye Lee인 bno, btitle, bwriter를 가져오시오
select bno, btitle, bwriter
from board
where bwriter = 'Dahye Lee';

-- bwriter가 Dahye Lee인 게시물을 모두 가져오시오
select *
from board
where bwriter='Dahye Lee';

-- bwriter가 '홍'을 포함하는 게시물의 bno, btitle, bwriter를 가져오시오
select bno, btitle, bwriter
from board
where bwriter like '%홍%';

-- 게시물의 제목 중에 '자바'가 포함되어 있는 게시물의 bno, btitle, bwriter를 가져오시오
select bno, btitle, bwriter
from board
where btitle like '%자바%';

-- 게시물의 제목 or 내용 중에 '자바'가 포함되어 있는 게시물의 bno, btitle, bwriter를 가져오시오

select bno, btitle, bwriter, bcontent
from board
where btitle like '%자바' or bcontent like '%자바%';

-- 글쓴이가 '감자바', '김길동', '라즈베리'인 게시물의 번호, 제목, 글쓴이를 가져오시오

select bno, btitle, bwriter
from board
where bwriter in('감자바', '김길동', '라즈베리');

-- 첨부파일이 없는 게시물을 가져오시오

select *
from board
where boriginalfilename is null;

-- 첨부파일이 있는 게시물을 가져오시오

select *
from board
where boriginalfilename is not null;

-- 게시물 작성한 사람의 이름을 가져오시오(중복 제거)

select distinct bwriter
from board;

-- 게시글을 쓴 날짜가 2016년인 게시글을 가져오시오

select *
from board
where bdate like '%16/%';

select *
from board
where bdate between '16/01/01' and '16/12/31';

-- bno -> 번호, btitle -> 제목, bwriter -> 글쓴이로 컬럼 이름 변경해서 가져오시오(as 생략가능)
select bno as 번호, btitle as 제목, bwriter 글쓴이
from board;

/*
정렬
*/

-- 게시물 번호를 기준으로 올림차순으로 가져오시오(DB는 새로 입력할 때 이전에 지웠던 공간안에 채워지면서 저장됨.)

select *
from board
order by bno asc;

-- 2017년도에 작성한 게시물의 번호를 기준으로 내림차순으로 가져오시오

select *
from board
where bdate like '%17/%'
order by bno desc;

-- 글쓴이를 기준으로 1차 정렬(올림차순)하고 쓴 날짜를 기준으로 2차 정렬(내림차순)하시오

select * 
from board
order by bwriter asc, bdate desc;

/*
페이징 처리: 네트워크 통신에서 전송하는 워드의 양이 많아져 느려지고 ResultSet을 생성하는데 방대한 수의 객체가 생성되어 메모리가 터짐.
*/
-- 저장되어있는 순서대로 행 번호 매기기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

/* selector안의 또다른 selector = subquery */
/* 가장 최근에 작성한 글이 처음으로 나오게 하기 위한 쿼리문 */
-- 정렬 후 행 번호 매기기
select rownum bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount
from board order by bno desc);
-- 특정 행번호 이하만 가져오기(Top N 가져오기)
-- from table에서 하나씩 정렬된 값을 가져올 때마다 rownum값 생성
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount
from board order by bno desc)
where rownum >= 10;
-- 시작 행번호와 끝 행번호 사이의 게시물 가져오기
-- where rownum <= pageNo*rowsPerPage)
-- where r >= (pageNo -1)*rowsPerPage + 1;
select *
from ( select rownum as r, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount
from board order by bno desc)
where rownum <= 2*15)
where r >= (2-1)*15+1;

/* 
행 수 구하기
*/

select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

-- 특정 조건에 맞는 행수 구하기
select count(*) from board where bwriter <> 'Dahye Lee';