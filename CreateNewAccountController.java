package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateNewAccountController {
	@FXML
    private Button createAccountButton;

    @FXML
    private TextField emailIDField;

    @FXML
    private TextField playerName;

    @FXML
    private PasswordField playerPassword;

    @FXML
    private TextField playerPhoneNumber;

    @FXML
    void createAccount(ActionEvent event) {
		DataBase.sendData(this.emailIDField.getText(), this.playerName.getText(), this.playerPhoneNumber.getText(), this.playerPassword.getText());

    }
}
