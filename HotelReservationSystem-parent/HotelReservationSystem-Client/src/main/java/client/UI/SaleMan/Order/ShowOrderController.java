/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Order;

import client.businessLogicService.OrderFactory;
import common.vo.OrderVO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class ShowOrderController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField number;
    @FXML
    private TextField plantime,createtime;
    @FXML
    private TextField lasttime;
    @FXML
    private TextField checkouttime;
    @FXML
    private TextField checkintime;
    @FXML
    private TextField id;
    @FXML
    private TextField hotel;
    @FXML
    private TextField canceltime;
    @FXML
    private TextField numberofperson;
    @FXML
    private TextField child;
    @FXML
    private TextField numberofroom;
    @FXML
    private TextField day;
    @FXML
    private TextField price;
    public void initialize(){
        
    }
    public void show(String Number){
        String Child = null;
        OrderVO vo=OrderFactory.getOrderService().searchOrderById(Number);
        number.setText(vo.id);
        id.setText(vo.clientId);
        hotel.setText(vo.hotel);
        createtime.setText(vo.cancelTime.toString());
        plantime.setText(vo.planExecuteTime.toString());
        lasttime.setText(vo.latestDoneTime.toString());
        checkintime.setText(vo.checkInTime.toString());
        checkouttime.setText(vo.checkOutTime.toString());
        canceltime.setText(vo.cancelTime.toString());
        numberofperson.setText(""+vo.numberOfPerson);
        child.setText(Child);
        numberofroom.setText(vo.numOfRoom);
        day.setText(""+vo.day);
        price.setText(""+vo.price);
        if(vo.hasChild){
            Child="有";
        }else{
            Child="没有";
        }
    }
}
