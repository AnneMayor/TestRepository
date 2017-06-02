package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);

	// 여기서는 유지보수를 쉽게 하기 위해서 이렇게 인터페이스 선언하고 구현객체 만듦.
	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;
		Connection conn = null;
		try {
			// JDBC Driver 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connString, "iotuser", "iot12345");
			LOGGER.info("Connection success");
			// 매개 변수화된 SQL문 작성
			String sql = "insert into board ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?) ";
			// 매개 변수화된 SQL문 전송해서 실행
			// 값을 받을 준비가 된 statement를 만들겠다는 선언
			// Statement.RETURN_GENERATED_KEYS: 요건 적용되는 DBMS도 있고 아닌 것도 있음.
			/*
			 * 테이블 정의시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL 등)
			 * PreparedStatement pstmt = conn.prepareStatement(sql,
			 * Statement.RETURN_GENERATED_KEYS);
			 */
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			// next() 메소드는 to be continued...
			rs.next();
			bno = rs.getInt(1);
			pstmt.close();
			// 일반적인 SQL문 전송해서 실행
			/*
			 * Statement stmt = conn.createStatement(); stmt.executeUpdate(sql);
			 * stmt.close();
			 */
			LOGGER.info("행추가 성공");
		} catch (ClassNotFoundException e) {
			// 예외가 발생하면 연결을 끊을 수가 없어서 connection leak가 발생.
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 위에서 null로 선언안하면 값을 닫을게 없어서 컴파일 에러 발생
			try {
				// 연결 끊기
				conn.close();
				LOGGER.info("Connection close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bno;
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = new ArrayList<Exam12Board>();

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			ResultSet rs = pstm1.executeQuery();
			while (rs.next()) {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
			}
			rs.close();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {

		List<Exam12Board> list = new ArrayList<Exam12Board>();

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = " select * ";
			sql += " from ( select rownum as r, bno, btitle, bwriter, bdate, bhitcount ";
			sql += " from ( select bno, btitle, bwriter, bdate, bhitcount ";
			sql += " from board order by bno desc ) ";
			sql += " where rownum <= ?) ";
			// ?*?: 이런 식으로는 연산할 수가 없음.
			sql += "where r >= ? ";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setInt(1, pageNo * rowsPerPage);
			pstm1.setInt(2, (pageNo - 1) * rowsPerPage + 1);
			ResultSet rs = pstm1.executeQuery();
			while (rs.next()) {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				list.add(board);
			}
			rs.close();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public int boardCountAll() {

		int count = 0;
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "select count(*) from board ";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			ResultSet rs = pstm1.executeQuery();
			rs.next();
			count = rs.getInt(1);
			rs.close();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = null;
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "select * from board where bno=?";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setInt(1, bno);
			ResultSet rs = pstm1.executeQuery();
			// 이건 반드시 해줘야 예외발생하지 않는다...이거 명심하자!
			// 2가지의 경우가 존재. 가져오거나 가져오지 않거나!
			if (rs.next()) {
				board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("boriginalfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
				board.setBpassword(rs.getString("bpassword"));
			}
			rs.close();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "update board set bhitcount=? where bno=? ";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setInt(1, bhitcount);
			pstm1.setInt(2, bno);
			pstm1.executeUpdate();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void boardUpdate(Exam12Board board) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql;
			if (board.getBoriginalfilename() != null) {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?,  bsavedfilename=?, bfilecontent=? where bno=? ";
			} else {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=? ";
			}

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setString(1, board.getBtitle());
			pstm1.setString(2, board.getBcontent());
			pstm1.setString(3, board.getBpassword());
			if (board.getBoriginalfilename() != null) {
				pstm1.setString(4, board.getBoriginalfilename());
				pstm1.setString(5, board.getBsavedfilename());
				pstm1.setString(6, board.getBfilecontent());
				pstm1.setInt(7, board.getBno());
			} else {
				pstm1.setInt(4, board.getBno());
			}
			pstm1.executeUpdate();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void boardDelete(int bno) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = " delete from board where bno=? ";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setInt(1, bno);
			pstm1.executeUpdate();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String memberInsert(Exam12Member member) {
		String mid = null;
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "insert into member ";
			sql += "values ";
			sql += "(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setString(1, member.getMid());
			pstm1.setString(2, member.getMname());
			pstm1.setString(3, member.getMpassword());
			pstm1.setString(4, member.getMtel());
			pstm1.setString(5, member.getMemail());
			pstm1.setInt(6, member.getMage());
			pstm1.setString(7, member.getMaddress());
			pstm1.setString(8, member.getMoriginalfilename());
			pstm1.setString(9, member.getMsavedfilename());
			pstm1.setString(10, member.getMfilecontent());
			pstm1.executeUpdate();

			mid = member.getMid();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("추가된 mid: " + mid);
		return mid;
	}

	@Override
	public List<Exam12Member> memberSelectAll() {
		List<Exam12Member> list = new ArrayList<>();
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String connection = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(connection, "iotuser", "iot12345");
			LOGGER.info("Connectin Success");

			String sql = "select mname, mid, mpassword, mage from member order by mname desc";

			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Exam12Member member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMage(rs.getInt("mage"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMname(rs.getString("mname"));
				list.add(member);
			}
			rs.close();
			pstm.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> list = new ArrayList<>();

		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "select * ";
			sql += "from ( select rownum as r, mname, mid, mpassword, mage ";
			sql += "from ( select mname, mid, mpassword, mage ";
			sql += "from member order by mname desc ) ";
			sql += "where rownum <= ? ) ";
			sql += "where r >= ?";

			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, pageNo * rowsPerPage);
			psmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Exam12Member member = new Exam12Member();
				member.setMname(rs.getString("mname"));
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMage(rs.getInt("mage"));
				list.add(member);
			}
			rs.close();
			psmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int memberCountAll() {
		int count = 0;
		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = "select count(*) from member ";

			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			count = rs.getInt(1);

			rs.close();
			pstm.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member = null;
		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(url, "iotuser", "iot12345");

			String sql = "select * from member where mid=? ";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, mid);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				member = new Exam12Member();
				member.setMid(rs.getString("mid"));
				member.setMage(rs.getInt("mage"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMaddress(rs.getString("maddress"));
				member.setMdate(rs.getDate("mdate"));
				member.setMemail(rs.getString("memail"));
				member.setMtel(rs.getString("mtel"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));
			}

			rs.close();
			pstm.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public void memberUpdate(Exam12Member member) {
		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(url, "iotuser", "iot12345");

			String sql;
			if (member.getMoriginalfilename() != null) {
				sql = "update member set mname=?, mpassword=?, mdate=sysdate, mage=?, maddress=?, memail=?, mtel=?, ";
				sql += "moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=? ";
			} else {
				sql = "update member set mname=?, mpassword=?, mdate=sysdate, mage=?, maddress=?, memail=?, mtel=? where mid=? ";
			}

			PreparedStatement psmt = connection.prepareStatement(sql);
			if (member.getMoriginalfilename() != null) {
				psmt.setString(1, member.getMname());
				psmt.setString(2, member.getMpassword());
				psmt.setInt(3, member.getMage());
				psmt.setString(4, member.getMaddress());
				psmt.setString(5, member.getMemail());
				psmt.setString(6, member.getMtel());
				psmt.setString(7, member.getMoriginalfilename());
				psmt.setString(8, member.getMsavedfilename());
				psmt.setString(9, member.getMfilecontent());
				psmt.setString(10, member.getMid());
			} else {
				psmt.setString(1, member.getMname());
				psmt.setString(2, member.getMpassword());
				psmt.setInt(3, member.getMage());
				psmt.setString(4, member.getMaddress());
				psmt.setString(5, member.getMemail());
				psmt.setString(6, member.getMtel());
				psmt.setString(7, member.getMid());
			}
			psmt.executeUpdate();
			psmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void memberDelete(String mid) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = " delete from member where mid=? ";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setString(1, mid);
			pstm1.executeUpdate();
			pstm1.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//	public static void main(String... args) {
//		Exam12DaoImpl test = new
//	  Exam12DaoImpl();  List<Exam12Board> list = test.boardSelectPage(2, 20);
//	  Exam12Member member = new Exam12Member();  while(member != null) { 
//	  for (Exam12Member board : list) {  LOGGER.info(board.getBtitle()); 
//	  for (int i = 1; i <= 100; i++) {  Exam12Board board = new
//	  Exam12Board();  board.setBtitle("title" + i); 
//	  board.setBcontent("content" + i);  board.setBwriter("Dahye Lee"); 
//	  board.setBpassword("123456");  board.setBoriginalfilename("a.png"); 
//	  board.setBsavedfilename("a-111222.png"); 
//	  board.setBfilecontent("image/png");  
//	  int bno = test.insert1(board); 
//	  LOGGER.info("추가된 행 PK bno: " + bno);  }
//		Exam12DaoImpl test = new Exam12DaoImpl();
//	  Exam12Member member = new Exam12Member();
//	  for (int i = 1; i <= 100; i++) { if (i >= 1 && i < 10) {
//	  member.setMid("id00" + i); member.setMage(i); member.setMname("name00" +
//	  i); member.setMpassword("password00" + i); member.setMaddress("address00"
//	  + i); member.setMdate(new Date()); member.setMemail("email00" + i);
//	  member.setMfilecontent("photo00" + i); member.setMtel("phone00" + i); }
//	  else if (i >= 10 && i < 100) { member.setMid("id0" + i);
//	  member.setMage(i); member.setMname("name0" + i);
//	  member.setMpassword("password0" + i); member.setMaddress("address0" + i);
//	  member.setMdate(new Date()); member.setMemail("email0" + i);
//	  member.setMfilecontent("photo0" + i); member.setMtel("phone0" + i); }
//	  else { member.setMid("id" + i); member.setMage(i); member.setMname("name"
//	  + i); member.setMpassword("password" + i); member.setMaddress("address" +
//	  i); member.setMdate(new Date()); member.setMemail("email" + i);
//	  member.setMfilecontent("photo" + i); member.setMtel("phone" + i); }
//	  test.memberInsert(member); } } 
//}
}