import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Dept;

public class MainApp {

	

	public static void 추가(int id) {
		String sql = "INSERT INTO test1(id) VALUES(?)"; // ;을 넣으면 오류뜸
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, -1 값은 오류시에만 리턴
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void 삭제(int id) {
		String sql = "DELETE FROM test1 WHERE id = ?"; // ;을 넣으면 오류뜸
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, -1 값은 오류시에만 리턴
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void 수정(int id) {
		String sql = "UPDATE test1 SET id = ?"; // ;을 넣으면 오류뜸
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, -1 값은 오류시에만 리턴
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Dept 찾기(int deptno) {
		String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = ?"; // ;을 넣으면 오류뜸
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
				System.out.println(dept);
				return dept;
//				int deptno2 = rs.getInt("deptno"); // 변수에 넣는 이유는 실수를 방지하고 사용하기 편하기 때문에
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				System.out.println(deptno2);
//				System.out.println(dname);
//				System.out.println(loc);
			}
			// next() 커서를 한칸 내림
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Dept> 전체찾기() {
		String sql = "SELECT deptno, dname, loc FROM dept"; // ;을 넣으면 오류뜸
		Connection conn = DBConnection.getInstance();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Dept> alDept = new ArrayList<>();
			while (rs.next()) {

				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc")).build();

				alDept.add(dept);	
			}
			return alDept;
			// next() 커서를 한칸 내림
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
//		추가(9);
//		삭제(1);
//		수정(9);
//		Dept dept = 찾기(10);
//		System.out.println(dept);
		List<Dept> alDept =전체찾기();
		System.out.println(alDept);
	}
}
