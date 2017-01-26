package cn.pfc.it;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLconnection {

	String url="jdbc:sqlserver://localhost:1433;" +
	"databaseName=Students;integratedSecurity=true;";
	private Connection connection;
	private Statement statement;

	public SQLconnection() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	}

//	Connection connection = DriverManager.getConnection(url);
//	Statement statement2 = connection.createStatement();
	public Statement getStatment() throws SQLException {
		connection = DriverManager.getConnection(url);
		statement = connection.createStatement();
		return statement;
	}
	public void toClose() throws Exception {
		connection.close();
		statement.close();
		this.getStatment().close();
	}
}
 