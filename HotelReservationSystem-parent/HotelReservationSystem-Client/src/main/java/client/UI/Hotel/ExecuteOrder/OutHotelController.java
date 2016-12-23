/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import client.businessLogicService.OrderFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class OutHotelController  {

    @FXML
    private AnchorPane basePane;
    @FXML
    private ChoiceBox<Integer> sinBox;
    @FXML
    private ChoiceBox<Integer> douBox;
    @FXML
    private ChoiceBox<Integer> famBox;
    @FXML
    private Button outButton;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        for(int i=0;i<6;i++){
            sinBox.getItems().add(i);
            douBox.getItems().add(i);
            famBox.getItems().add(i);
        }
    }    

    @FXML
    private void outButtonHandler(ActionEvent event) {
        int sin,dou,fam;
        if (sinBox.getValue()==null) {//防范措施
            sin=0;
        }else{
            sin=sinBox.getValue();
        }
        if (douBox.getValue()==null) {
            dou=0;
        }else{
            dou=douBox.getValue();
        }
        
        if (famBox.getValue()==null) {
            fam=0;
        }else{
            fam=famBox.getValue();
        }
        LocalDate now=LocalDate.now();
        HotelFactory.getHotelUpdateService().checkOut(Start.person.id, "/"+sin+"/"+dou+"/"+fam+"/", now);
    }
}
