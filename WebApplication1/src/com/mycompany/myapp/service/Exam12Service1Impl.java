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
}