/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import client.LocalDateToDate;
import static client.LocalDateToDate.localDateToDate;
import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import client.businessLogicService.OrderFactory;
import common.vo.OrderVO;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class InHotelController {

    @FXML
    private AnchorPane basePane;
    @FXML
    private Button inButton;
    private DatePicker inPicker;
    @FXML
    private DatePicker outPicker;
    @FXML
    private ChoiceBox<Integer> sinBox;
    @FXML
    private ChoiceBox<Integer> douBox;
    @FXML
    private ChoiceBox<Integer> famBox;
    @FXML
    private Label tipLabel;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        int single,dou,fam;
        single=HotelFactory.getHotelMaintainService().getHotelInfo(Start.person.id).rooms.get(0).restNum;
        dou=HotelFactory.getHotelMaintainService().getHotelInfo(Start.person.id).rooms.get(1).restNum;
        fam=HotelFactory.getHotelMaintainService().getHotelInfo(Start.person.id).rooms.get(2).restNum;
        while(single!=0){
            sinBox.getItems().add(single);
            single--;
        }
        while(dou!=0){
            douBox.getItems().add(dou);
            dou--;
        }
        while(fam!=0){
            famBox.getItems().add(fam);
            fam--;
        }
    }    

    @FXML
    private void inButtonHandler(ActionEvent event)throws  Exception {
         
        
        Date left=localDateToDate(inPicker.getValue());//离开时间
        Date date=LocalDateToDate.instantDate();//实现当前日期
        if (left.before(date)||(sinBox.getValue().equals(0)&&douBox.getValue().equals(0)&&
            famBox.getValue().equals(0))) {
            tipLabel.setText("请正确输入信息");
        }else{
            HotelFactory.getHotelUpdateService().offlineCheckIn(Start.person.id, "/"+sinBox.getValue()+"/"+douBox.getValue()+"/"+
                   famBox.getValue(),date, left);
            tipLabel.setText("成功更新");
        }
    }
    
}
