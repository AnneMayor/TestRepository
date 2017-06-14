package com.mycompany.myapp.dao;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

import com.mycompany.myapp.ApplicationContextLoader;
import com.mycompany.myapp.dto.Exam12Board;

public class Exam12DaoImpl3Test extends ApplicationContextLoader {
	@Resource(name = "exam12DaoImpl3")
	private Exam12Dao dao;

	//@Test
	public void insertTest() {
		// 괄호 안의 객체가 not null이라 가정하고 돌렸을 때 실제로 not null이면 테스트 성공! 아니면 실패!!
		Exam12Board board = new Exam12Board();
		board.setBtitle("JUnit Test1");
		board.setBcontent("Test package 잘 만들자!");
		board.setBwriter("DHL");
		board.setBpassword("123456");
		int bno = dao.boardInsert(board);

		Exam12Board dbBoard = dao.boardSelectByBno(bno);

		Assert.assertNotNull(dbBoard);
		Assert.assertEquals(board.getBtitle(), dbBoard.getBtitle());
		Assert.assertEquals(board.getBcontent(), dbBoard.getBcontent());
		Assert.assertEquals(board.getBwriter(), dbBoard.getBwriter());
		Assert.assertEquals(board.getBpassword(), dbBoard.getBpassword());
	}

	//@Test
	public void insertWithAttachTest() {
		// 괄호 안의 객체가 not null이라 가정하고 돌렸을 때 실제로 not null이면 테스트 성공! 아니면 실패!!
		Exam12Board board = new Exam12Board();
		board.setBtitle("JUnit Test1");
		board.setBcontent("Test package 잘 만들자!");
		board.setBwriter("DHL");
		board.setBpassword("123456");
		board.setBoriginalfilename("test.jpg");
		board.setBsavedfilename("test.jpg");
		board.setBfilecontent("image/jpg");
		int bno = dao.boardInsert(board);

		Exam12Board dbBoard = dao.boardSelectByBno(bno);

		Assert.assertNotNull(dbBoard);
		Assert.assertEquals(board.getBtitle(), dbBoard.getBtitle());
		Assert.assertEquals(board.getBcontent(), dbBoard.getBcontent());
		Assert.assertEquals(board.getBwriter(), dbBoard.getBwriter());
		Assert.assertEquals(board.getBpassword(), dbBoard.getBpassword());
		Assert.assertEquals(board.getBoriginalfilename(), dbBoard.getBoriginalfilename());
		Assert.assertEquals(board.getBsavedfilename(), dbBoard.getBsavedfilename());
		Assert.assertEquals(board.getBfilecontent(), dbBoard.getBfilecontent());
	}

	//@Test
	public void updateTest() {
		Exam12Board board = new Exam12Board();
		board.setBtitle("JUnit Test1");
		board.setBcontent("Test package 잘 만들자!");
		board.setBwriter("DHL");
		board.setBpassword("123456");
		int bno = dao.boardInsert(board);

		board.setBtitle("JUnit Test2");
		board.setBcontent("Test package");
		dao.boardUpdate(board);

		Exam12Board dbBoard = dao.boardSelectByBno(bno);

		Assert.assertNotNull(dbBoard);
		Assert.assertEquals(board.getBtitle(), dbBoard.getBtitle());
		Assert.assertEquals(board.getBcontent(), dbBoard.getBcontent());
	}

	//@Test
	public void deleteTest() {
		Exam12Board board = new Exam12Board();
		board.setBtitle("JUnit Test1");
		board.setBcontent("Test package 잘 만들자!");
		board.setBwriter("DHL");
		board.setBpassword("123456");
		board.setBoriginalfilename("test.jpg");
		board.setBsavedfilename("test.jpg");
		board.setBfilecontent("image/jpg");
		int bno = dao.boardInsert(board);
		dao.boardDelete(bno);
		Exam12Board dbBoard = dao.boardSelectByBno(bno);

		Assert.assertNull(dbBoard);
	}

	// 이렇게 test 안한다!!!
//	@Test
//	public void selectByPageTest() {
//		// 이때는 실제 데이터베이스는 절대 쓰면 안됨!!테스트용 디비 써야한다(만약 잘못하면...퇴사 + 물어주기)
//		// dao.deleteAll(); 만들어줘야 함!
//		for (int i = 1; i <= 100; i++) {
//			Exam12Board board = new Exam12Board();
//			board.setBtitle("JUnit Test1");
//			board.setBcontent("Test package 잘 만들자!");
//			board.setBwriter("DHL");
//			board.setBpassword("123456");
//			board.setBoriginalfilename("test.jpg");
//			board.setBsavedfilename("test.jpg");
//			board.setBfilecontent("image/jpg");
//			dao.boardInsert(board);
//		}
//		
//		int pageNo = 1;
//		int rowsPerPage = 10;
//		List<Exam12Board> list = dao.boardSelectPage(pageNo, rowsPerPage);
//		// 가져온 행 수 검사
//		Assert.assertEquals(rowsPerPage, list.size());
//		// 시작 번호가 같은지 검사
//		Assert.assertEquals(list.get(0).getBno(), 100-((pageNo-1)*rowsPerPage));
//		// 끝 번호가 같은지 검사
//		Assert.assertEquals(list.get(list.size()-1).getBno(), 100-(pageNo*rowsPerPage)+1);
//	}
}