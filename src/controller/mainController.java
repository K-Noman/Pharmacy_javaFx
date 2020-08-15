package controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class mainController {

    @FXML
    private FontAwesomeIcon iconUser;
    @FXML
    private FontAwesomeIcon iconPassword;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private RadioButton user;
    @FXML
    private RadioButton admin;


    public void initialize(){
        loginBtn.setDisable(true);
    }

    public void loginBtnEnabler(KeyEvent event) {
        boolean disableButton = username.getText().isEmpty() || username.getText().trim().isEmpty();
        loginBtn.setDisable(disableButton);
        if (username.getText().trim().isEmpty()){
            iconUser.setVisible(true);
        }else iconUser.setVisible(false);

    }
    public void iconPasswordEnabler(KeyEvent event) {
        if (password.getText().trim().isEmpty()){
            iconPassword.setVisible(true);
        }else iconPassword.setVisible(false);

    }

    public void loginAction(ActionEvent event) {
        String login = null;
        controller.login login1 =new login(username.getText(),password.getText());
        login= (user.isSelected()?login1.validateUser():login1.validateAdmin());
        changeLoginScreen(event,login);
       System.out.println(login);
       System.out.println(username.getText());
       System.out.println(password.getText());

    }


    public void changeLoginScreen(ActionEvent event,String nameToLoad){

        try {
            String url="../view/"+nameToLoad;
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Stage stage=(Stage) loginBtn.getScene().getWindow();
            Scene scene= new Scene(root);
            stage.setScene(scene);

        }catch (Exception e){
            System.out.println(e+"this");
        }

    }



}
