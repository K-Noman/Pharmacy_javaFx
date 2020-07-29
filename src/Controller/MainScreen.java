package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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
    @FXML
    final ToggleGroup user_AdminGroup = new ToggleGroup();

    public void initialize() {
        LoginMain.setDisable(true);
    }
    @FXML
    public void enableButton() {
        boolean disableButton = UserName.getText().isEmpty() || UserName.getText().trim().isEmpty();
        LoginMain.setDisable(disableButton);

    }


    @FXML
    public void LoginAction(ActionEvent event) throws Exception {
        System.out.println(UserName.getText());
        System.out.println(Password.getText());
        String afterLogin=(userRadio.isSelected()?"user":"admin");
        changeScene(event,afterLogin);

    }

    public void changeScene( ActionEvent event,String fxml) throws IOException {
        String FXML="/view/"+fxml+".fxml";
        Parent notRoot= FXMLLoader.load(getClass().getResource(FXML));
        Scene notRootScene=new Scene(notRoot);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notRootScene);
        window.show();



    }



}
