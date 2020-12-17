package test.config;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import config.DBConnection;

public class DBConnectionTest {
	
	// junit : 테스트 할 때 사용
	@Test
	public void 데이터베이스연결_테스트() {
		Connection conn = DBConnection.getInstance();
		assertNotNull(conn); // 테스트 할 때 쓰는 함수
	}
}
