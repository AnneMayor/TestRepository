package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Serivce1 {
	public void boardWrite(Exam12Board board);
	public List<Exam12Board> boardListAll();
	public List<Exam12Board> boardListPage(int pageNo, int rowsPerPage);
	public int boardTotalRows();
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void memberJoin(Exam12Member member);
	public List<Exam12Member> memberListAll();
	public List<Exam12Member> membeListPage(int pageNo, int rowsPerPage);
	public int memberTotalRows();
}