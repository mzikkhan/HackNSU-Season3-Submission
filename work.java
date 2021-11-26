package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import javafx.application.Application;
import javafx.stage.Stage;

public class work {
	
	static String url = "jdbc:sqlserver://SHELBY-30102000;databaseName=master";
	static String user= "Ritu";
	static String password = "password";
	
	Connection conn=null;
	PreparedStatement statement=null;
	
	public static void main(String[] args) {
		try {
			Connection conn=null;
			PreparedStatement statement=null;
			conn = DriverManager.getConnection(url,user,password);

			String sql = "INSERT INTO player_info (Email,PlayerName,Phonenumber,Password)\r\n"
					+ "			VALUES ('Zaed@gmail.com','Zaed','0171','zaedk');";
			
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			
			conn.close();
		} catch (SQLException e1) {
			System.out.println(e1);
			
		}
	}
	
	
}

