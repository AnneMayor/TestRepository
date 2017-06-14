package com.mycompany.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

/* 여기서 작성한 코드는 JDBC API를 직접 활용한 것이다. 스프링을 사용하면 이렇게 할 필요없음. 이런 식으로 사용할 경우, DB계정이 노출되고 비밀번호 변경시 다시 다 코드를 바꿔줘야한다. 보다 큰 문제는 dao가 예외처리를 한다면
 여기서 예외가 발생할 시, service가 알아채지 못할수도 있음.
*/

@Component
public class Exam12DaoImpl3 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl3.class);
	// 이렇게 선언해주면 스프링에서 DB연결을 관리해주는건데 만약 이 클래스만 단독으로 런하게 되면 연결이 열리지 않아 실행이 안됨.
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// 여기서는 유지보수를 쉽게 하기 위해서 이렇게 인터페이스 선언하고 구현객체 만듦.
	@Override
	public int boardInsert(Exam12Board board) {
		int row = sqlSessionTemplate.insert("board.insert", board);
		LOGGER.info("" + row);
		return board.getBno();
		// int bno = -1;
		// final String sql = "insert into board " + "values "
		// + "(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?) ";

		/*
		 * jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(),
		 * board.getBwriter(), board.getBpassword(),
		 * board.getBoriginalfilename(), board.getBsavedfilename(),
		 * board.getBfilecontent());
		 */

		// PreparedStatementCreator psc = new PreparedStatementCreator() {
		//
		// @Override
		// public PreparedStatement createPreparedStatement(Connection conn)
		// throws SQLException {
		// PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {
		// "bno" });
		// pstmt.setString(1, board.getBtitle());
		// pstmt.setString(2, board.getBcontent());
		// pstmt.setString(3, board.getBwriter());
		// pstmt.setString(4, board.getBpassword());
		// pstmt.setString(5, board.getBoriginalfilename());
		// pstmt.setString(6, board.getBsavedfilename());
		// pstmt.setString(7, board.getBfilecontent());
		// return pstmt;
		// }
		//
		// };
		//
		// KeyHolder key = new GeneratedKeyHolder();
		//
		// jdbcTemplate.update(psc, key);
		//
		// bno = key.getKey().intValue();
		//
		// LOGGER.info(String.valueOf(bno));
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectAll");
		return list;
		// RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
		// @Override
		// public Exam12Board mapRow(ResultSet rs, int rowNum) throws
		// SQLException {
		// Exam12Board board = new Exam12Board();
		// board.setBno(rs.getInt("bno"));
		// board.setBtitle(rs.getString("btitle"));
		// board.setBwriter(rs.getString("bwriter"));
		// board.setBdate(rs.getDate("bdate"));
		// board.setBhitcount(rs.getInt("bhitcount"));
		// return board;
		// }
		// };
		// // rowMapper: 하나의 행을 어떤 객체로 만들어줄지 결정하고 만듦.
		// List<Exam12Board> list = jdbcTemplate.query(sql, rowMapper);
		// return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo - 1) * rowsPerPage + 1);
		map.put("endNum", pageNo * rowsPerPage);
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectByPage", map);
		return list;
		// String sql = " select * ";
		// sql += " from ( select rownum as r, bno, btitle, bwriter, bdate,
		// bhitcount ";
		// sql += " from ( select bno, btitle, bwriter, bdate, bhitcount ";
		// sql += " from board order by bno desc ) ";
		// sql += " where rownum <= ?) ";
		// // ?*?: 이런 식으로는 연산할 수가 없음.
		// sql += "where r >= ? ";
		//
		// Object[] args = { pageNo * rowsPerPage, (pageNo - 1) * rowsPerPage +
		// 1 };
		//
		// RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
		// @Override
		// public Exam12Board mapRow(ResultSet rs, int rowNum) throws
		// SQLException {
		// Exam12Board board = new Exam12Board();
		// board.setBno(rs.getInt("bno"));
		// board.setBtitle(rs.getString("btitle"));
		// board.setBwriter(rs.getString("bwriter"));
		// board.setBdate(rs.getDate("bdate"));
		// board.setBhitcount(rs.getInt("bhitcount"));
		// return board;
		// }
		// };
		//
		// List<Exam12Board> list = jdbcTemplate.query(sql, args, rowMapper);
	}

	@Override
	public int boardCountAll() {
		int count = sqlSessionTemplate.selectOne("board.countAll");
		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = sqlSessionTemplate.selectOne("board.selectByBno", bno);
		return board;
		// String sql = "select * from board where bno=?";
		// // queryForObject: 얘는 무조건 하나는 반드시 가지고 와야한다!만약 반드시 가지고 올 필요가 없는 경우에는
		// // query를 써줘야한다.
		// RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
		//
		// @Override
		// public Exam12Board mapRow(ResultSet rs, int rowNum) throws
		// SQLException {
		// Exam12Board board = new Exam12Board();
		// board.setBno(rs.getInt("bno"));
		// board.setBtitle(rs.getString("btitle"));
		// board.setBwriter(rs.getString("bwriter"));
		// board.setBcontent(rs.getString("bcontent"));
		// board.setBdate(rs.getDate("bdate"));
		// board.setBhitcount(rs.getInt("bhitcount"));
		// board.setBpassword(rs.getString("bpassword"));
		// board.setBdate(rs.getDate("bdate"));
		// board.setBoriginalfilename(rs.getString("boriginalfilename"));
		// board.setBsavedfilename(rs.getString("bsavedfilename"));
		// board.setBfilecontent(rs.getString("bfilecontent"));
		// return board;
		// }
		// };
		// Exam12Board board = jdbcTemplate.queryForObject(sql, rowMapper, bno);
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("bhitcount", bhitcount);
		map.put("bno", bno);
		sqlSessionTemplate.update("board.updateBhitcount", map);

		// String sql = "update board set bhitcount=? where bno=? ";
		// // 앞에 int i = 이거 붙여주게 되면 jdbcTemplate.update된 행의 개수를 리턴함.
		// jdbcTemplate.update(sql, bhitcount, bno);
	}

	@Override
	public void boardUpdate(Exam12Board board) {
		sqlSessionTemplate.update("board.update", board);
		// String sql;
		// if (board.getBoriginalfilename() != null) {
		// sql = "update board set btitle=?, bcontent=?, bpassword=?,
		// bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=?
		// where bno=? ";
		// jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(),
		// board.getBpassword(),
		// board.getBoriginalfilename(), board.getBsavedfilename(),
		// board.getBfilecontent(), board.getBno());
		// } else {
		// sql = "update board set btitle=?, bcontent=?, bpassword=?,
		// bdate=sysdate where bno=? ";
		// jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(),
		// board.getBpassword(), board.getBno());
		// }
		//
	}

	@Override
	public void boardDelete(int bno) {
		sqlSessionTemplate.delete("board.delete", bno);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String memberInsert(Exam12Member member) {
		sqlSessionTemplate.insert("member.insert", member);
		return member.getMid();
	}

	@Override
	public List<Exam12Member> memberSelectAll() {
		List<Exam12Member> list = sqlSessionTemplate.selectList("member.selectAll");
		return list;
	}

	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo-1)*rowsPerPage + 1);
		map.put("endNum", pageNo*rowsPerPage);
		List<Exam12Member> list = sqlSessionTemplate.selectList("member.selectByPage", map);
		return list;
	}

	@Override
	public int memberCountAll() {
		int count = sqlSessionTemplate.selectOne("member.countAll");
		return count;
	}

	@Override
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member = sqlSessionTemplate.selectOne("member.selectByMid", mid);
		return member;
	}

	@Override
	public void memberUpdate(Exam12Member member) {
		sqlSessionTemplate.update("member.update", member);
	}

	@Override
	public void memberDelete(String mid) {
		sqlSessionTemplate.delete("member.delete", mid);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}