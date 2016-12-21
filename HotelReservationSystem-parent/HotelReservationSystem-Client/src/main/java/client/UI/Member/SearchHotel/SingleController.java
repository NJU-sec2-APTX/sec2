/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import common.vo.HotelVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class SingleController  {

    @FXML
    private Label hotelNameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label starLabel;
    @FXML
    private Label markLabel;
    @FXML
    private Label statueLabel;
    @FXML
    private Button bookButton;

   

    @FXML
    private void bookButtonHandler(ActionEvent event) {
        
    }

    void show(HotelVO hotelVO) {
        if (hotelVO==null) {
            hotelNameLabel.setText("无");
        }else{
            hotelNameLabel.setText(hotelVO.name);
            addressLabel.setText(hotelVO.address);
            priceLabel.setText(hotelVO.price+"");
            starLabel.setText(hotelVO.star+"");
            markLabel.setText(hotelVO.mark+"");
            statueLabel.setText(hotelVO.isEverReserved+"");
        }
        
    }
    
}
