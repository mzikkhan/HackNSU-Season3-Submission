package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VerificationController {
	@FXML
    private TextField verificationField;

    @FXML
    private Button verifyButton;

    @FXML
    void verify(ActionEvent event) {
    	if(Integer.valueOf(this.verificationField.getText())==CreateNewAccountController.otp) {
    		System.out.println("Verification Done");
    	}
    }
}
