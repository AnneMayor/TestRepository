package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

/* 여기서 작성한 코드는 JDBC API를 직접 활용한 것이다. 스프링을 사용하면 이렇게 할 필요없음. 이런 식으로 사용할 경우, DB계정이 노출되고 비밀번호 변경시 다시 다 코드를 바꿔줘야한다. 보다 큰 문제는 dao가 예외처리를 한다면
 여기서 예외가 발생할 시, service가 알아채지 못할수도 있음.
*/

@Component
public class Exam12DaoImpl2 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl2.class);
	// 이렇게 선언해주면 스프링에서 DB연결을 관리해주는건데 만약 이 클래스만 단독으로 런하게 되면 연결이 열리지 않아 실행이 안됨.
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 여기서는 유지보수를 쉽게 하기 위해서 이렇게 인터페이스 선언하고 구현객체 만듦.
	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;

		final String sql = "insert into board " + "values "
				+ "(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?) ";

		/*
		 * jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(),
		 * board.getBwriter(), board.getBpassword(),
		 * board.getBoriginalfilename(), board.getBsavedfilename(),
		 * board.getBfilecontent());
		 */

		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setString(4, board.getBpassword());
				pstmt.setString(5, board.getBoriginalfilename());
				pstmt.setString(6, board.getBsavedfilename());
				pstmt.setString(7, board.getBfilecontent());
				return pstmt;
			}

		};

		KeyHolder key = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, key);

		bno = key.getKey().intValue();

		LOGGER.info(String.valueOf(bno));

		return bno;
	}

	@Override
	public List<Exam12Board> boardSelectAll() {

		String sql = "select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc";

		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				return board;
			}
		};
		// rowMapper: 하나의 행을 어떤 객체로 만들어줄지 결정하고 만듦.
		List<Exam12Board> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {

		String sql = " select * ";
		sql += " from ( select rownum as r, bno, btitle, bwriter, bdate, bhitcount ";
		sql += " from ( select bno, btitle, bwriter, bdate, bhitcount ";
		sql += " from board order by bno desc ) ";
		sql += " where rownum <= ?) ";
		// ?*?: 이런 식으로는 연산할 수가 없음.
		sql += "where r >= ? ";

		Object[] args = { pageNo * rowsPerPage, (pageNo - 1) * rowsPerPage + 1 };

		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {

			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				return board;
			}

		};

		List<Exam12Board> list = jdbcTemplate.query(sql, args, rowMapper);
		return list;
	}

	@Override
	public int boardCountAll() {
		String sql = "select count(*) from board ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {

		String sql = "select * from board where bno=?";
		// queryForObject: 얘는 무조건 하나는 반드시 가지고 와야한다!만약 반드시 가지고 올 필요가 없는 경우에는
		// query를 써줘야한다.
		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {

			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBdate(rs.getDate("bdate"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
				return board;
			}
		};
		Exam12Board board = jdbcTemplate.queryForObject(sql, rowMapper, bno);
		return board;

	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {

		String sql = "update board set bhitcount=? where bno=? ";
		// 앞에 int i = 이거 붙여주게 되면 jdbcTemplate.update된 행의 개수를 리턴함.
		jdbcTemplate.update(sql, bhitcount, bno);
	}

	@Override
	public void boardUpdate(Exam12Board board) {
		String sql;
		if (board.getBoriginalfilename() != null) {
			sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?,  bsavedfilename=?, bfilecontent=? where bno=? ";
			jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(), board.getBpassword(),
					board.getBoriginalfilename(), board.getBsavedfilename(), board.getBfilecontent(), board.getBno());
		} else {
			sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=? ";
			jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(), board.getBpassword(), board.getBno());
		}

	}

	@Override
	public void boardDelete(int bno) {
		String sql = " delete from board where bno=? ";
		jdbcTemplate.update(sql, bno);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String memberInsert(Exam12Member member) {
		String sql = "insert into member ";
		sql += "values ";
		sql += "(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, member.getMid(), member.getMname(), member.getMpassword(), member.getMtel(),
				member.getMemail(), member.getMage(), member.getMaddress(), member.getMoriginalfilename(),
				member.getMsavedfilename(), member.getMfilecontent());
		return member.getMid();
	}

	@Override
	public List<Exam12Member> memberSelectAll() {
		String sql = "select mname, mid, mpassword, mage from member order by mname desc";

		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMname(rs.getString("mname"));
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMage(rs.getInt("mage"));
				return member;
			}
		};

		List<Exam12Member> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {

		String sql = "select * ";
		sql += "from ( select rownum as r, mname, mid, mpassword, mage ";
		sql += "from ( select mname, mid, mpassword, mage ";
		sql += "from member order by mname desc ) ";
		sql += "where rownum <= ? ) ";
		sql += "where r >= ?";

		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {

			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMname(rs.getString("mname"));
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMage(rs.getInt("mage"));
				return member;

			}

		};

		List<Exam12Member> list = jdbcTemplate.query(sql,
				new Object[] { pageNo * rowsPerPage, (pageNo - 1) * rowsPerPage + 1 }, rowMapper);
		return list;
	}

	@Override
	public int memberCountAll() {
		String sql = "select count(*) from member ";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public Exam12Member memberSelectByMid(String mid) {

		String sql = "select * from member where mid=? ";

		RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {

			@Override
			public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				member.setMage(rs.getInt("mage"));
				member.setMaddress(rs.getString("maddress"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));
				return member;
			}
		};

		Exam12Member member = jdbcTemplate.queryForObject(sql, rowMapper, mid);
		return member;
	}

	@Override
	public void memberUpdate(Exam12Member member) {
		String sql;
		if (member.getMoriginalfilename() != null) {
			sql = "update member set mname=?, mpassword=?, mdate=sysdate, mage=?, maddress=?, memail=?, mtel=?, ";
			sql += "moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=? ";
			jdbcTemplate.update(sql, member.getMname(), member.getMpassword(), member.getMage(), member.getMaddress(),
					member.getMemail(), member.getMtel(), member.getMoriginalfilename(), member.getMsavedfilename(),
					member.getMfilecontent(), member.getMid());
		} else {
			sql = "update member set mname=?, mpassword=?, mdate=sysdate, mage=?, maddress=?, memail=?, mtel=? where mid=? ";
			jdbcTemplate.update(sql, member.getMname(), member.getMpassword(), member.getMage(), member.getMaddress(),
					member.getMemail(), member.getMtel(), member.getMid());
		}
	}

	@Override
	public void memberDelete(String mid) {
		 String sql = " delete from member where mid=? ";
		 jdbcTemplate.update(sql, mid);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}