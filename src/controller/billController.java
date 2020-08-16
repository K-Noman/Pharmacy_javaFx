package controller;

import Classes.TEMP;
import Classes.dbDataBase;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class billController {
    @FXML
    private JFXButton pay;
    @FXML
    private Label bill;

    @FXML
    private VBox namesListVBox;
    @FXML
    private VBox quantityListVBox;
    @FXML
    private VBox priceListVBox;
    @FXML
    private Button btnFinalise;
    @FXML
    private JFXTextField productChoice;

    @FXML
    private JFXTextField productName;
    @FXML
    private JFXTextField inStock;
    @FXML
    private JFXTextField quantity;


    public void initialize(){
        updateBasket();
    }

    private void updateBasket() {
        namesListVBox.getChildren().clear();
        quantityListVBox.getChildren().clear();
        priceListVBox.getChildren().clear();
        bill.setText(null);


        for (TEMP ignored : dbDataBase.getDataTEMP()) {
            Label name = new Label(" "+ignored.getNAME());
            Label quantity = new Label("" + ignored.getQUANTITY());
            Label amount=new Label(""+ignored.getTOTAL());


            name.setTooltip(new Tooltip((ignored.getNAME())));
            quantity.setTooltip(new Tooltip("" + ignored.getQUANTITY()));
            amount.setTooltip(new Tooltip(""+ignored.getTOTAL()));

            namesListVBox.getChildren().add(name);
            quantityListVBox.getChildren().add(quantity);
            priceListVBox.getChildren().add(amount);
        }
        bill.setText(dbDataBase.getTEMPTotalColumn());
    }


    public void payAction(ActionEvent event) {
        Stage stage = (Stage) pay.getScene().getWindow();
        stage.close();

    }
}
