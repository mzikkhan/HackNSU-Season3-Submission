package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
	Player player=Player.getObject();
    @FXML
    private Button login;

    @FXML
    private TextField mail;

    @FXML
    private TextField password;
    private boolean found=false;
    @FXML
    void logIN(ActionEvent event) {
    	try {
			String url = "jdbc:sqlserver://NIJHUMS-LEPTI;databaseName=master";
	    	String user= "Ritu";
	    	String password = "password";
	    	Connection conn = DriverManager.getConnection(url,user,password);
	        Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT Email,PlayerName,Phonenumber,PlayerPassword FROM player_info");
	        while(rs.next()) {
	        	//System.out.println(rs.getString("Email"));
	        	if(rs.getString("Email").equals(this.mail.getText()) && rs.getString("PlayerPassword").equals(this.password.getText())) {
	        		System.out.println("found");
	        		this.found=true;
	        		player.setPlayerName(rs.getString("Email"));
	        		player.setPlayerName(rs.getString("PlayerName"));
	        		player.setPlayerPhonenumber(rs.getString("Phonenumber"));
	        		player.setPlayerPassword("PlayerPassword");
	        		break;
	        	}
	        }
	        
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	if(found) {
    		System.out.println(player.getPlayerName());
    	}
    }
    
}
