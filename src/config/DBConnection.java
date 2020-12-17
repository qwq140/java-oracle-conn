package config;

import java.sql.Connection;
import java.sql.DriverManager;

// 오라클과 연동
public class DBConnection {

	public static Connection getInstance() { 
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		// jdbc:oracle:thin:@ 기본형식
		//thin, oci 두 형식
		String user = "SCOTT";
		String password = "TIGER";
		
		// OracleDriver 클래스를 메모리에 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//OracleDriver c = new acleDriver();
			conn =DriverManager.getConnection(url, user, password); // 바이트스트림에 연결
			System.out.println("DB연결 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DB연결 실패");
		return null;
	}
}
