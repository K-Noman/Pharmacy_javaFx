package classes;

import controller.table.salesTable;

import java.sql.SQLException;


public class test  {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        salesTable salesTable =new salesTable("123","20mg","1","10","10","aspirine");

        System.out.println(salesTable.getAll());



    }


//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        //MAIN
////        Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
//        //Admin
////        Parent root = FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
//        //test
////        Parent root = FXMLLoader.load(getClass().getResource("/test/test.fxml"));
//        //Add Employee
////        Parent root = FXMLLoader.load(getClass().getResource("/view/addNew/empAdd.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/view/salesTab.fxml"));
//        primaryStage.setTitle("Pharmacy ");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();






}
