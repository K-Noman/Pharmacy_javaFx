import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //MAIN
//        Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
        //Admin
        Parent root = FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
        //test
//        Parent root = FXMLLoader.load(getClass().getResource("/test/test.fxml"));
        //Add Employee
//        Parent root = FXMLLoader.load(getClass().getResource("/view/addNew/empAdd.fxml"));


//        Parent root = FXMLLoader.load(getClass().getResource("/view/user.fxml"));
        primaryStage.setTitle("Pharmacy ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
