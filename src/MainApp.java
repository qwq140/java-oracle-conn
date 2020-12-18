import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import dao.DeptDao;
import model.Dept;

public class MainApp {

	public static void main(String[] args) {
//		추가(9);
//		삭제(1);
//		수정(9);
//		Dept dept = 찾기(10);
//		System.out.println(dept);
		List<Dept> alDept = DeptDao.전체찾기(); // 데이터 엑세스 오브젝트를 통해서 데이터베이스 접근
		System.out.println(alDept);
	}
}
