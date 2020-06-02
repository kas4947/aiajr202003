package ver07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.daoVersion.ConnectionProvider;
import jdbc.daoVersion.Dept;
import ver07.dto.AllDTO;
import ver07.infordfly.PhoneInfor;

public class PhoneBookDao {
	// DAO = Data Acess Object
	// 데이터베이스 처리 하는 클래스
	// 
	
	// MVC -> Model, View, Controller
	// model -> Service , Dao
	// 데이터베이스 
	
	

	public int deptEdit(/* Dept newDept, Connection conn */) {

		// JDBC 사용 객체
		//Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		
		try {
			// Connection 객체 생성
			//conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// 주의 !!!!!
			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.
	
			String sql = "update dept  set  dname=?, loc=? " + " where deptno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newDept.getDname());
			pstmt.setString(2, newDept.getLoc());
			pstmt.setInt(3, newDept.getDeptno());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
		return resultCnt;

	}

	public int deptDelete(/* String dname */) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;


		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			String sql = "delete from dept  where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			
			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
		return resultCnt;

	}

	public List<PhoneInfor> deptSearch(/* String dname */) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<PhoneInfor> list = new ArrayList<PhoneInfor>();


		try {

			// 2. 데이터베이스 연결
			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// Mysql
			// "SELECT * FROM dept WHERE dname LIKE ?"
			// psmt.setString(1, "%"+name+"%");

			// Oracle
			// select * from dept where dname like '%'||?||'%'

			String sql = "select * from dept  where dname like '%'||?||'%' or  loc like '%'||?||'%'";
			// String sql = "select * from dept where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, dname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Dept(
						rs.getInt("deptno"), 
						rs.getString("dname"), 
						rs.getString("loc")));
			}
			


			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
		return list;

	}

	public int createInfo(/* Dept dept */) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;


		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into dept  (deptno, dname, loc)  values (?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			resultCnt = pstmt.executeUpdate();


			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
		return resultCnt;

	}

	public List<AllDTO> phoneBookList(Connection conn) {
		
		// VO : Value Object , read only , getter
		// DTO : Data Transfer Object  getter/setter , toString, equals

		// JDBC 사용 객체
		//Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// Dao 클래스 추가
		List<AllDTO> allBooks = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 2. 데이터베이스 연결
			//conn = ConnectionProvider.getConnection();

			String sql = "select *\r\n" + 
					"from phoneinfo_basic b left outer join phoneinfo_univ y\r\n" + 
					"on b.idx = y.fr_ref\r\n" + 
					"left outer join phoneinfo_com c\r\n" + 
					"on b.idx = c.fr_ref\r\n" + 
					"left outer join phoneinfo_cafe ca\r\n" + 
					"on b.idx = ca.fr_ref";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			
			while (rs.next()) {
				
				AllDTO allDto = new AllDTO(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getString(12),
						rs.getInt(13),
						rs.getInt(14),
						rs.getString(15),
						rs.getString(16),
						rs.getInt(16)
						);
				
				allBooks.add(allDto);
				
//				System.out.print(rs.getInt("deptno") + "\t");
//				System.out.printf("%15s", rs.getString("dname") + "\t");
//				System.out.printf("%15s", rs.getString("loc") + "\n");
//				resultCnt++;
			}

			System.out.println("=======================================================================");
			

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}

		}
		return allBooks;

	}

	
	
	
	public int deptSearchCount(String searchName, Connection conn) {
		
		//Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int rowCnt = 0;
		
		try {
			//conn = ConnectionProvider.getConnection();
			
			String sql = "select count(*) from dept where dname=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rowCnt = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rowCnt;
	}
	
	
	public PhoneInfor deptSearchName(String searchName, Connection conn) {
		
		
		Dept dept = null;
		
		//Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//conn = ConnectionProvider.getConnection();
			
			String sql = "select * from dept where dname=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return dept;
		
		
	}
}
