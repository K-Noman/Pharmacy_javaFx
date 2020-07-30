package Classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene  {
    public void changeSceneAfterLogin(ActionEvent event, String fxml) throws IOException {
        String FXML="/view/"+fxml+".fxml";
        Parent notRoot= FXMLLoader.load(getClass().getResource(FXML));
        javafx.scene.Scene notRootScene=new javafx.scene.Scene(notRoot,700,400);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(notRootScene);
        window.show();
    }
    
}
