package jpa;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class TestJdbc {

	public static void selectStatement(Statement statement, String id) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM pupils where id = " + id);//����� ������ ��-DB
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "- " + rs.getString("name"));
		}
	}
	
	
	public static void insertStatement(Statement statement, int id, String name) throws SQLException {//statement - ������ ���� ����� ������� ��� �-DB
		String s = "insert into [dbo].[pupils] (id, name) values ("+ id +", '" + name  + "')";
		int numOfAffectedRows = statement.executeUpdate(s);//����� ������ �-DB
		System.out.println("numOfAffectedRows=" + numOfAffectedRows);

	}
	
	
	public static void insertPreparedStatement(Connection connection, int id, String name) throws SQLException {//PreparedStatemet - ������ ����� ������� ��� �-DB - ����
		//���� ���� ��� ���� ���������
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO [dbo].[pupils] (id, name) values (?, ?)");//������ ������ ����� �������, ������� ������ ���� ���������
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}
	
	public static void selectPreparedStatement(Connection connection, int id, String name) throws SQLException {//PreparedStatemet - ������ ����� ������� ��� �-DB - ����
		//���� ���� ��� ���� ���������
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pupils where id = ?");//������ ������ ����� �������, ������� ������ ���� ���������
		preparedStatement.setInt(1, id);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "- " + rs.getString("name"));
		}
		preparedStatement.close();

	}

	public static void main(String[] args) throws SQLException {

		DriverManager.registerDriver(new SQLServerDriver());
		String dbURL = "jdbc:sqlserver://DESKTOP-V5DR227;DatabaseName=javaproject;integratedSecurity=false";
		Connection connection = DriverManager.getConnection(dbURL, "java2", "123456789123456789");//������ ������ �-DB

		System.out.println("Connection to DB is on!!");
		
		insertPreparedStatement(connection, 6, "Lea");
		Statement statement = connection.createStatement();//������ ������ ����� ������� ��� �-DB
		insertStatement(statement, 5,  "Shoshi");
		selectStatement(statement, "999");
		selectPreparedStatement(connection, 1, "Ester");
		//statement.close();
		connection.close();
		System.out.println("end of program");

	}

}
