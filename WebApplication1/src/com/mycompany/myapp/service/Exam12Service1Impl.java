package com.mycompany.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mycompany.myapp.dao.Exam12Dao;
import com.mycompany.myapp.dto.Exam07Board;
import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12Service1Impl implements Exam12Serivce1 {

	@Autowired
	private Exam12Dao exam12Dao;
	
	@Override
	public void boardWrite(Exam12Board board) {
		exam12Dao.boardInsert(board);
	}
	
	@Override
	public List<Exam12Board> boardListAll() {
		List<Exam12Board> list = exam12Dao.boardSelectAll();
		return list;
	}
	
	@Override
	public List<Exam12Board> boardListPage(int pageNo, int rowsPerPage) {
		List<Exam12Board> list = exam12Dao.boardSelectPage(pageNo, rowsPerPage);
		return list;
	}
	

	@Override
	public int boardTotalRows() {
		int totalRows = exam12Dao.boardCountAll();
		return totalRows;
	}
	

	// service객체를 사용하는 이유 = 객체로 관리하여 주기 위해서!
	@Override
	public Exam12Board getBoard(int bno) {
		Exam12Board board = exam12Dao.boardSelectByBno(bno);
		board.setBhitcount(board.getBhitcount()+1);
		exam12Dao.boardUpdateBhitcount(bno, board.getBhitcount());
		return board;
	}
	
	@Override
	public String boardCheckBpassword(int bno, String bpassword) {
		String result = "fail";
		Exam12Board board = exam12Dao.boardSelectByBno(bno);
		if(board.getBpassword().equals(bpassword)) {
			result = "success";
		}
		return result;
	}
	
	@Override
	public void boardUpdate(Exam12Board board) {
		exam12Dao.boardUpdate(board);
	}
	

	@Override
	public void boardDelete(int bno) {
		exam12Dao.boardDelete(bno);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void memberJoin(Exam12Member member) {
		exam12Dao.memberInsert(member);
	}

	@Override
	public List<Exam12Member> memberListAll() {
		List<Exam12Member> list = exam12Dao.memberSelectAll();
		return list;
	}

	@Override
	public List<Exam12Member> membeListPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> list = exam12Dao.memberSelectPage(pageNo, rowsPerPage);
		return list;
	}

	@Override
	public int memberTotalRows() {
		int totalRows = exam12Dao.memberCountAll();
		return totalRows;
	}
	
	@Override
	public Exam12Member getMember(String mid) {
		Exam12Member member = exam12Dao.memberSelectByMid(mid);
		return member;
	}
	
	@Override
	public String memberCheckMpassword(String mid, String mpassword) {
		String result = "fail";
		Exam12Member member = exam12Dao.memberSelectByMid(mid);
		if(member.getMpassword().equals(mpassword)) {
			result = "success";
		}
		return result;
	}
	
	@Override
	public void memberUpdate(Exam12Member member) {
		exam12Dao.memberUpdate(member);
	}

	@Override
	public void memberDelete(String mid) {
	}

}