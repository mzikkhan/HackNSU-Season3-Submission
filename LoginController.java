package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
			String url = "jdbc:sqlserver://SHELBY-30102000;databaseName=master";
	    	String user= "Ritu";
	    	String password = "password";
	    	Connection conn = DriverManager.getConnection(url,user,password);
	        Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT Name FROM pseudo");
	        while(rs.next()) {
	        	//System.out.println(rs.getString("Email"));
	        	if(rs.getString("Name").equals(this.mail.getText()) /*&& rs.getString("PlayerPassword").equals(this.password.getText())*/ ) {
	        		//System.out.println("found");
	        		this.found=true;
	        		//player.setPlayerName(rs.getString("Email"));
	        		//player.setPlayerName(rs.getString("PlayerName"));
	        		//player.setPlayerPhonenumber(rs.getString("Phonenumber"));
	        		//player.setPlayerPassword("PlayerPassword");
	        		break;
	        	}
	        }
	        
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	if(found) {
    		try {
				root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
	  		  alert.setTitle("Warning");
	  		  alert.setHeaderText("There is no account with this email or password.");
	  		  alert.setContentText("Please try again.");
	  		  
	  		  if(alert.showAndWait().get() == ButtonType.OK) {
		  			try {
			    		  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			    		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  			      scene = new Scene(root);
		  			      stage.setScene(scene);
		  			      stage.show();
		  		    } catch (IOException e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		    }
	  		  }
    	}
    }
    
}
