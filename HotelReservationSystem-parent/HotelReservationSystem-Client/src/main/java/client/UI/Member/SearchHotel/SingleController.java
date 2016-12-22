/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import common.vo.HotelVO;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
    private Button browseButton;

    private HotelVO hotelVO;

    @FXML
    private void bookButtonHandler(ActionEvent event) throws Exception{
        FXMLLoader fxmll=new FXMLLoader();
        AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Member/OrderBrowse/MakeOrder.fxml").toURL()));
        MakeOrderController moc=fxmll.getController();
        moc.show(hotelVO);
    }

    void show(HotelVO h) {
        hotelVO=h;
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

    @FXML
    private void browseButtonHandler(ActionEvent event)throws  Exception{
        FXMLLoader fxmll=new FXMLLoader();
        AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Member/OrderBrowse/HotelDetial.fxml").toURL()));
        HotelDetialController hdc=fxmll.getController();
        hdc.show(hotelVO);
    }
    
}
