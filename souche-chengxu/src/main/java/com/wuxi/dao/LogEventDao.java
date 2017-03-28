package com.wuxi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LogEventDao {

	private String driver = "com.mysql.jdbc.Driver";
	private String dburl = "jdbc:mysql://127.0.0.1:3306/log";
	private String user = "root";
	private String password = "root123";
	
	private Connection connection = null;
	
	public Connection connect(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void query(String sql,Object[] params){
		try {
			if(connection == null || connection.isClosed()){
				this.connect();
			}
			System.out.println("是否默认提交：" + connection.getAutoCommit());
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		
		ResultSet resultSet = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		try {
			if(params == null || params.length == 0){
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()){
					System.out.println("行：" + resultSet.getRow() + " " + resultSet.getLong(1));
				}
			}else{
				preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				for(int i=1; i<=params.length; i++){
					preparedStatement.setString(i, params[i-1].toString());
				}
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					System.out.println("行：" + resultSet.getRow() + " " + resultSet.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null){
					resultSet.close();
				}
				if(statement != null){
					statement.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(this.connection != null){
					this.connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}