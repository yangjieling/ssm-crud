package DBTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionTest {
	
	private static Logger log = LoggerFactory.getLogger(ConnectionTest.class);
	
	/**
	 * 使用JDBC测试数据库连接配置是否正确
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		log.info("前置");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm-crud", "root", "123456");
		System.out.println(connection);
		log.info(connection.toString());
	}
}
