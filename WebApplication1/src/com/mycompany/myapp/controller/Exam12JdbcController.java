package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;
import com.mycompany.myapp.service.Exam12Serivce1;

@Controller
public class Exam12JdbcController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12JdbcController.class);
	
	@Resource(name="exam12Service1Impl2")
	private Exam12Serivce1 service;
	
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/jdbc/exam01")
	public String exam01() {
		Exam12Board board = new Exam12Board();
		board.setBtitle("title");
		board.setBcontent("content");
		board.setBwriter("Dahye Lee");
		board.setBpassword("123456");
		board.setBoriginalfilename("a.png");
		board.setBsavedfilename("a-111222.png");
		board.setBfilecontent("image/png");
		service.boardWrite(board);
		return "redirect:/";
	}
	
	//a tag 방식
	@RequestMapping(value = "/jdbc/exam02", method=RequestMethod.GET)
	public String exam02Get() {
		return "jdbc/exam02";
	}
	
	// form method=post
	@RequestMapping(value = "/jdbc/exam02", method=RequestMethod.POST)
	public String exam02Post(Exam12Board board) throws IllegalStateException, IOException {
		// 첨부 파일에 대한 정보를 컬럼값으로 설정
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		board.setBfilecontent(board.getBattach().getContentType());
		
		// Eclipse는 최종산출물을 metadata/plugins 폴더 안에 생성(넷빈즈는 build에 생성함)
		// 첨부 파일을 서버 로컬 시스템에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		String fileName = new Date().getTime() + "-" + board.getBoriginalfilename();
		File file = new File(realPath + fileName);
		board.getBattach().transferTo(file);
		board.setBsavedfilename(fileName);
		
		service.boardWrite(board);
		
		return "redirect:/jdbc/exam05";
	}
	
	@RequestMapping(value = "/jdbc/exam03", method=RequestMethod.GET)
	public String exam03Get() {
		return "jdbc/exam03";
	}
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
	public String exam03Post(Exam12Member member) throws IllegalStateException, IOException {
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String realPath1 = servletContext.getRealPath("/WEB-INF/upload/");
		String fileName1 = new Date().getTime() + member.getMoriginalfilename();
		File file = new File(realPath1 + fileName1);
		member.getMattach().transferTo(file);
		member.setMsavedfilename(fileName1);
		
		service.memberJoin(member);
		
		return "jdbc/exam03";
	}
	
	@RequestMapping("/jdbc/exam04")
	public String exam04(Model model) {
		List<Exam12Board> list = service.boardListAll();
		model.addAttribute("list", list);
		return "jdbc/exam04";
	}
	
	@RequestMapping("/jdbc/exam05")
	public String exam05(@RequestParam(defaultValue="1")int pageNo, Model model) {
		// 한 페이지를 구성하는 행의 개수
		int rowsPerPage = 10;
		// 한 그룹을 구성하는 페이지 수
		int pagesPerGroup = 7;
		// 총 행수
		int totalRows = service.boardTotalRows();
		// 전체 페이지 수
		int totalPageNo = totalRows/rowsPerPage + ((totalRows%rowsPerPage != 0) ? 1:0);
		// 전체 그룹 수
		int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup != 0)? 1:0);
		// 현재 그룹 번호
		int groupNo = (pageNo - 1)/pagesPerGroup + 1;
		// 현재 그룹의 시작 페이지 번호 
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		// 현재 그룹의 마지막 페이지 번호
		int endPageNo = startPageNo+pagesPerGroup -1;
		if(groupNo == totalGroupNo) endPageNo = totalPageNo;
		
		// 현재 페이지의 행 데이터 가져오기
		List<Exam12Board> list = service.boardListPage(pageNo, rowsPerPage);

		// View로 넘겨줄 데이터(Pager 만들 때 쓰는 값)
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		// View 이름 리턴
		return "jdbc/exam05";
	}
	
	@RequestMapping("/jdbc/exam05Detail")
	public String exam05Detail(int bno, Model model) {
		Exam12Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "jdbc/exam05Detail";
	}
	
	@RequestMapping("/jdbc/exam06")
	public String exam06(Model model) {
		List<Exam12Member> list = service.memberListAll();
		model.addAttribute("list", list);
		return "jdbc/exam06";
	}
	
	@RequestMapping("/jdbc/exam07")
	public String exam07(@RequestParam(defaultValue="1")int pageNo, Model model) {
		int rowsPerPage = 10;
		int pagesPerGroup = 7;
		int totalRows = service.memberTotalRows();
		int totalPageNo = totalRows / rowsPerPage + ((totalRows % rowsPerPage != 0)? 1:0);
		int totalGroupNo = totalPageNo / pagesPerGroup + ((totalPageNo % pagesPerGroup != 0)? 1 : 0);
		int groupNo = (pageNo -1) / pagesPerGroup + 1;
		int startPageNo = (groupNo -1)*pagesPerGroup + 1;
		// 여기 질문
		int endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
		
		List<Exam12Member> list = service.membeListPage(pageNo, rowsPerPage);
		
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		return "jdbc/exam07";
	}
	
	@RequestMapping("/jdbc/exam07Detail")
	public String exam07Detail(String mid, Model model) {
		Exam12Member member = service.getMember(mid);
		model.addAttribute("member", member);
		return "jdbc/exam07Detail";
	}
	
	@RequestMapping("/jdbc/exam07CheckMpassword")
	public String exam07CheckMpassword(String mid, String mpassword, Model model) {
		String result = service.memberCheckMpassword(mid, mpassword);
		model.addAttribute("result", result);
		return "jdbc/exam07CheckMpassword";
	}
	
	@RequestMapping(value="/jdbc/exam07Update", method=RequestMethod.GET)
	public String exam07UpdateGet(String mid, Model model) {
		Exam12Member member = service.getMember(mid);
		model.addAttribute("member", member);
		return "jdbc/exam07Update";
	}
	
	@RequestMapping(value="/jdbc/exam07Update", method=RequestMethod.POST)
	public String exam07UpdatePost(String mid, Exam12Member member) throws IllegalStateException, IOException {
		if(!member.getMattach().isEmpty()) {
			member.setMoriginalfilename(member.getMattach().getOriginalFilename());
			member.setMfilecontent(member.getMattach().getContentType());
			
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			String fileName = new Date().getTime() + "-" + member.getMoriginalfilename();
			File file = new File(realPath + fileName);
			member.getMattach().transferTo(file);
			member.setMsavedfilename(fileName);
		}
		
		service.memberUpdate(member);
		return "redirect:/jdbc/exam07Detail?mid=" + member.getMid();
	}
	
	@RequestMapping("/jdbc/exam07Delete")
	public String exam07Delete(String mid) {
		service.memberDelete(mid);
		return "redirect:/jdbc/exam07";
	}
	
	@RequestMapping("/jdbc/exam05CheckBpassword") 
		public String exam05CheckBpassword(int bno, String bpassword, Model model) {
			String result = service.boardCheckBpassword(bno, bpassword);
			model.addAttribute("result", result);
			return "jdbc/exam05CheckBpassword";
		}
	
	@RequestMapping(value="/jdbc/exam05Update", method=RequestMethod.GET)
	public String exam05UpdateGet(int bno, Model model) {
		Exam12Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "jdbc/exam05Update";
	}
	
	@RequestMapping(value="/jdbc/exam05Update", method=RequestMethod.POST)
	public String exam05UpdateGetPost(Exam12Board board) throws IllegalStateException, IOException {
		// 첨부파일이 변경되었는지 검사
		if(!board.getBattach().isEmpty()) {
			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			board.setBfilecontent(board.getBattach().getContentType());
			
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			String fileName = new Date().getTime() + "-" + board.getBoriginalfilename();
			File file = new File(realPath + fileName);
			board.getBattach().transferTo(file);
			board.setBsavedfilename(fileName);
		}
		
		// 게시물 수정 처리
		service.boardUpdate(board);
		
		return "redirect:/jdbc/exam05Detail?bno=" + board.getBno();
	}
	
	@RequestMapping("/jdbc/exam05Delete")
	public String exam05Delete(int bno) {
		service.boardDelete(bno);
		return "redirect:/jdbc/exam05";
	}
}