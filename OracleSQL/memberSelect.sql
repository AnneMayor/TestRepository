select * from ( select rownum as r, mname, mid, mpassword, mage 
from ( select mname, mid, mpassword, mage
from member order by mname desc ) 
where rownum <= 40 )
where r >= 30;

delete from member where mname='nan'; 