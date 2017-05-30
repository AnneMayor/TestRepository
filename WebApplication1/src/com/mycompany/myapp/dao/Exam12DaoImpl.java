package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public int insert1(Exam12Board board) {
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
			/*테이블 정의시 컬럼의 속성으로 자동 증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL 등)
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);*/
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"});
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
			/*Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();*/
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
	public String insert2(Exam12Member member) {
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

	/*public static void main(String... args) {
		Exam12DaoImpl test = new Exam12DaoImpl();
		Exam12Board board = new Exam12Board();
		board.setBtitle("title");
		board.setBcontent("content");
		board.setBwriter("Dahye Lee");
		board.setBpassword("123456");
		board.setBoriginalfilename("a.png");
		board.setBsavedfilename("a-111222.png");
		board.setBfilecontent("image/png");
		int bno = test.insert1(board);
		LOGGER.info("추가된 행 PK bno: " + bno);
	}*/

}