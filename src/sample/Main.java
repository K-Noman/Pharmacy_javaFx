package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("View/LoginUser.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("View/AdminLogin.fxml"));
        Parent root=FXMLLoader.load(getClass().getResource("View/MainScreen.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Database database = new Database();
//        database.dbConnect();
//        database.dbDisconnect();
        launch(args);
    }
}
