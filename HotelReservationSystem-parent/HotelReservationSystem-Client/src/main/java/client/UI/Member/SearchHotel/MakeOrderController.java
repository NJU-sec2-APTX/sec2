/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class MakeOrderController implements Initializable {

    @FXML
    private Button okButton;
    @FXML
    private TextField hotelNameField;
    @FXML
    private ChoiceBox<?> famBox;
    @FXML
    private ChoiceBox<?> singleBox;
    @FXML
    private Button cancelButton;
    @FXML
    private ChoiceBox<String> douBox;
    @FXML
    private DatePicker inDatepicker;
    @FXML
    private DatePicker outDatePicker;
    @FXML
    private Button calButton;
    @FXML
    private Label moneyLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okButtonHandler(ActionEvent event) {
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
    }

    @FXML
    private void calButtonHandler(ActionEvent event) {
    }
    
}
