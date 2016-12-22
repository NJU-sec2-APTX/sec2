/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class InHotelController implements Initializable {

    @FXML
    private AnchorPane basePane;
    @FXML
    private Button inButton;
    @FXML
    private DatePicker inPicker;
    @FXML
    private DatePicker outPicker;
    @FXML
    private ChoiceBox<?> sinBox;
    @FXML
    private ChoiceBox<?> douBox;
    @FXML
    private ChoiceBox<?> famBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inButtonHandler(ActionEvent event) {
    }
    
}
