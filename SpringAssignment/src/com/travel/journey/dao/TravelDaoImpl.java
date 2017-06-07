package com.travel.journey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.journey.dto.Travel;

@Component
public class TravelDaoImpl implements TravelDao {

	@Autowired
	private ServletContext servletContext;

	@Override
	public long travelInsert(Travel travel) {
		long tnumber = -1;

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");

			String sql = "insert into austrailia  ";
			sql += "values ";
			sql += "(austrailia_tnumber_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			PreparedStatement pstm = conn.prepareStatement(sql, new String[]{"tnumber"});
			pstm.setString(2, travel.getTplace());
			pstm.setString(3, travel.getTstar());
			pstm.setString(4, travel.getTduration());
			pstm.setString(5, travel.getTdescription());
			pstm.setString(6, travel.getTrecommendation());
			pstm.setString(1, travel.getTdate());
			pstm.setString(7, travel.getToriginalfilename());
			pstm.setString(8, travel.getTsavedfilename());
			pstm.setString(9, travel.getTfilecontent());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();
			
			tnumber = rs.getLong(1);
			// rs는 close 해주면 안됨! Operation not allowed 예외 발생
			// insert문 뒤에 ()안에 특정 컬럼명 명시 안해주면 테이블의 모든 컬럼값 넣어주는 코드 작성해야 함
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
		return tnumber;
	}

	@Override
	public List<Travel> travelSelectPage(int pageNo, int rowsPerPage) {
		List<Travel> list = new ArrayList<>();

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			String sql = "select tnumber, tdate, tplace, tstar, tduration, tfilecontent ";
			sql += " from ( select rownum as r, tnumber, tdate, tplace, tstar, tduration, tfilecontent ";
			sql += " from ( select tnumber, tdate, tplace, tstar, tduration, tfilecontent ";
			sql += " from austrailia order by tnumber desc) ";
			sql += " where rownum <= ?) ";
			sql += " where r >= ? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pageNo*rowsPerPage);
			pstm.setInt(2, (pageNo - 1) * rowsPerPage + 1);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Travel travel = new Travel();
				travel.setTnumber(rs.getLong("tnumber"));
				travel.setTdate(rs.getString("tdate"));
				travel.setTplace(rs.getString("tplace"));
				travel.setTstar(rs.getString("tstar"));
				list.add(travel);
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
	
	public Travel travelSelectByTnumber(int tnumber) {
		Travel travel = null;
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			
			String sql = "select * from austrailia where tnumber=?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, tnumber);
			
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				travel = new Travel();
				travel.setTdate(rs.getString("tdate"));
				travel.setTplace(rs.getString("tplace"));
				travel.setTstar(rs.getString("tstar"));
				travel.setTduration(rs.getString("tduration"));
				travel.setTdescription(rs.getString("tdescription"));
				travel.setTrecommendation(rs.getString("trecommendation"));
				travel.setTnumber(rs.getLong("tnumber"));
				travel.setToriginalfilename(rs.getString("toriginalfilename"));
				travel.setTsavedfilename(rs.getString("tsavedfilename"));
				travel.setTfilecontent(rs.getString("tfilecontent"));
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
		return travel;
	}

//	public static void main(String... args) {
//		TravelDaoImpl test = new TravelDaoImpl();
//		Travel travel = new Travel();
//		for (int i = 1; i <= 30; i++) {
//			travel.setTplace("호주" + i);
//			travel.setTstar("★★★★★");
//			travel.setTduration("8일간");
//			travel.setTdescription("정말 최고의 첫여행(패키지)");
//			travel.setTrecommendation("강추");
//			travel.setTnumber(i);
//			travel.setTdate("2013-08-20");
//			travel.setToriginalfilename("autrailia1");
//			travel.setTsavedfilename("austrailia1");
//			// DB용량이 불필요하게 증가하는 것을 막기위해 보통 서버에 미디어 파일을 저장하고 그 경로를 DB에 넣어주는 것이
//			// 일반적인 방법.
//			// https://okky.kr/article/195939
//			travel.setTfilecontent("/WEB-INF/upload/austrailia1.jpg");
//			test.travelInsert(travel);
//		}
//	}

	@Override
	public int travelCountAll() {
		int totalRows = 0;
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");

			String sql = "select count(*) from austrailia ";

			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			totalRows = rs.getInt(1);
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
		return totalRows;
	}

	@Override
	public void travelUpdate(Travel travel) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql;
			if (travel.getToriginalfilename() != null) {
				sql = "update austrailia set tdate=?, tplace=?, tstar=?, tduration=?, tdescription=?, trecommendation=?, toriginalfilename=?, tsavedfilename=?, tfilecontent=? where tnumber=? ";
			} else {
				sql = "update austrailia set tdate=?, tplace=?, tstar=?, tduration=?, tdescription=?, trecommendation=? where tnumber=? ";
			}

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, travel.getTdate());
			pstm.setString(2, travel.getTplace());
			pstm.setString(3, travel.getTstar());
			pstm.setString(4, travel.getTduration());
			pstm.setString(5, travel.getTdescription());
			pstm.setString(6, travel.getTrecommendation());
			if (travel.getToriginalfilename() != null) {
				pstm.setString(7, travel.getToriginalfilename());
				pstm.setString(8, travel.getTsavedfilename());
				pstm.setString(9, travel.getTfilecontent());
				pstm.setLong(10, travel.getTnumber());
			} else {
				pstm.setLong(7, travel.getTnumber());
			}
			pstm.executeUpdate();
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
	}

	@Override
	public void travelDelete(int tnumber) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String conn = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
			connection = DriverManager.getConnection(conn, "iotuser", "iot12345");

			String sql = " delete from austrailia where tnumber=? ";

			PreparedStatement pstm1 = connection.prepareStatement(sql);
			pstm1.setInt(1, tnumber);
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
}