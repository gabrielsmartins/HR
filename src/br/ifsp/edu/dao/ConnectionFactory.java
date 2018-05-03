package br.ifsp.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String USR = "root";
	private static String PWD = "12345";
	
	private static Connection instance;
	
	public static Connection getinstance() {
		
		if(instance!=null) {
			return instance;
		}else {
			try {
				instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdhr",USR , PWD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

}
