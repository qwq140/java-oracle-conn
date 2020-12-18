package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Dept;

// Data Access Object (�����Ϳ� �����ϰ� ���ִ� ��ü) - �����ϱ� ���� ����
public class DeptDao {
	
	public static void �߰�(int id) {
		String sql = "INSERT INTO test1(id) VALUES(?)"; // ;�� ������ ������
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // ����� row count�� ����, -1 ���� �����ÿ��� ����
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ����(int id) {
		String sql = "DELETE FROM test1 WHERE id = ?"; // ;�� ������ ������
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // ����� row count�� ����, -1 ���� �����ÿ��� ����
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ����(int id) {
		String sql = "UPDATE test1 SET id = ?"; // ;�� ������ ������
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // ����� row count�� ����, -1 ���� �����ÿ��� ����
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Dept ã��(int deptno) {
		String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = ?"; // ;�� ������ ������
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
//				int deptno2 = rs.getInt("deptno"); // ������ �ִ� ������ �Ǽ��� �����ϰ� ����ϱ� ���ϱ� ������
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				System.out.println(deptno2);
//				System.out.println(dname);
//				System.out.println(loc);
			}
			// next() Ŀ���� ��ĭ ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Dept> ��üã��() {
		String sql = "SELECT deptno, dname, loc FROM dept"; // ;�� ������ ������
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
			// next() Ŀ���� ��ĭ ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
