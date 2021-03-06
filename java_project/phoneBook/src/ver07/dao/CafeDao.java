package ver07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ver07.dto.CafeDTO;

public class CafeDao {
	
	private CafeDao() {	}
	
	private static CafeDao dao = new CafeDao();
	
	public static CafeDao getInstance() {
		return dao;
	}

	public int cafeBasicEdit(CafeDTO newCafe, Connection conn) throws SQLException {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {
			String sql = "update phoneinfo_basic  set fr_name = ? , fr_phonenumber = ? , fr_email = ? , fr_address = ? where fr_name=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newCafe.getName());
			pstmt.setString(2, newCafe.getPhoneNumber());
			pstmt.setString(3, newCafe.getEmail());
			pstmt.setString(4, newCafe.getAddr());
			pstmt.setString(5, newCafe.getName());

			resultCnt = pstmt.executeUpdate();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return resultCnt;

	}

	public int cafeEdit(CafeDTO newCafe, Connection conn) throws SQLException {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {
			String sql = "update phoneinfo_cafe  set fr_c_cafename = ? , fr_nicname = ? where fr_ref=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newCafe.getCafaName());
			pstmt.setString(2, newCafe.getNicName());
			pstmt.setInt(3, newCafe.getIdx1());

			resultCnt = pstmt.executeUpdate();

		}  finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return resultCnt;

	}

	// 동호회 친구 검색
	public CafeDTO cafeSearch(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CafeDTO cafe = null;

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where  fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cafe = new CafeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}

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

		}

		return cafe;

	}

	// 동호회 친구 검색 (list)
	public List<CafeDTO> cafeSearchList(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CafeDTO> cafeList = new ArrayList<CafeDTO>();

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where  fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cafeList.add(new CafeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

		}

		return cafeList;

	}

	// 동호회 친구 검색 (boolean)
	public boolean cafeSearchBool(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean checkNull = false;

		try {


			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where  fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				checkNull = true;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

		}

		return checkNull;

	}

	// 동호회 친구 기본 정보 입력
		public int cafeBasicInsert(CafeDTO cafe, Connection conn) throws SQLException {

			// JDBC 사용 객체
			PreparedStatement pstmt = null;
			int resultCnt = 0;

			try {
				// 3. SQL 처리
				String sql = "insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cafe.getName());
				pstmt.setString(2, cafe.getPhoneNumber());
				pstmt.setString(3, cafe.getAddr());
				pstmt.setString(4, cafe.getEmail());
				pstmt.setDate(5, cafe.getRegdate());

				resultCnt = pstmt.executeUpdate();

				

			}  finally {

				}

				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				return resultCnt;
			}


	
	// 동호회 친구 입력
	public int cafeInsert(CafeDTO cafe, Connection conn) throws SQLException {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			// 3. SQL 처리
			String sql = "insert into phoneinfo_cafe values (PB_UNIV_IDX_SEQ.nextval, ?, ?, PB_BASIC_IDX_SEQ.currval)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cafe.getCafaName());
			pstmt.setString(2, cafe.getNicName());

			resultCnt += pstmt.executeUpdate();

		}  finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		return resultCnt;

	}

	// 동호회 친구 출력
	public List<CafeDTO> cafeList(Connection conn) {
		
		

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CafeDTO> cafeBooks = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			
			String sql = "select * from phoneinfo_basic b join phoneinfo_cafe ca on b.idx = ca.fr_ref";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CafeDTO cafeDto = new CafeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));

				cafeBooks.add(cafeDto);

			}

			System.out.println("=======================================================================");

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

		}
		return cafeBooks;

	}
}
