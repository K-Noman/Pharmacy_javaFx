package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainScreen {

    @FXML
    private TextField UserName;
    @FXML
    private PasswordField Password;
    @FXML
    private Button LoginMain;
    @FXML
    private RadioButton adminRadio;
    @FXML
    private RadioButton userRadio;
//    @FXML
//    final ToggleGroup user_AdminGroup = new ToggleGroup();

    public void initialize() {
        LoginMain.setDisable(true);
    }

    @FXML
    public void LoginAction(ActionEvent event) throws Exception {
        String Login = (userRadio.isSelected()) ? "USER" : "ADMIN";
        System.out.println(Login + " trying to logged in");
        System.out.println(UserName.getText());
        System.out.println(Password.getText());
        if (Login == "USER") {
            changeScene("view/MainScreen.fxml");
        }
    }

    private String changeScene(String s) {

        System.out.println(s);
        return s;
    }




    @FXML
    public void enableButton() {
        boolean disableButton = UserName.getText().isEmpty() || UserName.getText().trim().isEmpty();
        LoginMain.setDisable(disableButton);

    }

}
