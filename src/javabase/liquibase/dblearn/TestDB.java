package javabase.liquibase.dblearn;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			runTest();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 通过执行建表，加数据，查询表内容，删除表来测试
	 */
	public static void runTest() throws IOException, SQLException {
		Connection connection=getConnection();
		Statement statement=connection.createStatement();
		//statement.executeUpdate("create table Greetings(Message CHAR(20))");
		//statement.executeUpdate("insert into Greetings values('hellow, world!')");
		ResultSet resultSet=statement.executeQuery("SHOW DATABASES");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
		DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();
		
		connection.close();
		//statement.execute("drop table Greetings");
	}
	
	/*
	 * 从database.properties文件中取得数据库连接的信息
	 */
	public static Connection getConnection() throws IOException, SQLException {
		Properties properties=new Properties();
		InputStream inputStream=Files.newInputStream(Paths.get("src\\javabase\\liquibase\\dblearn\\database.properties"));
		properties.load(inputStream);
		String drivers=properties.getProperty("jdbc.drivers");
		String url=properties.getProperty("jdbc.url");
		String username=properties.getProperty("jdbc.username");
		String password=properties.getProperty("jdbc.password");
		if(null!=drivers) System.setProperty("jdbc.drivers", drivers);
		
		return DriverManager.getConnection(url, username, password);
	} 
}
