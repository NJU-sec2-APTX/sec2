/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.OrderBrowse;

import client.UI.Runner.Start;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.vo.OrderVO;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class OrderUIController  {

    @FXML
    private AnchorPane basePane;
    @FXML
    private ScrollPane showPane;
    @FXML
    private Button orderNumButton;
    @FXML
    private Button hotelNameButton;
    @FXML
    private Button makeOrderTimeButton;
    @FXML
    private Button ExecuteOrderTimeButton;
    @FXML
    private Button operateButton;


    @FXML
    private void orderNumButtonHandler(ActionEvent event) {
        
    }

    @FXML
    private void hotelNameButtonHandler(ActionEvent event) {
    }

    @FXML
    private void makeOrderTimeButtonHandler(ActionEvent event) {
    }

    @FXML
    private void ExecuteOrderTimeButtonHandler(ActionEvent event) {
        
    }

    @FXML
    private void operateButtonHandler(ActionEvent event) {
        
    }
    @FXML
    public void initialize() {
        ArrayList<OrderVO> OrderList = OrderFactory.getOrderService().searchOrderListFromData(Start.person, null, null);
        if(OrderList.isEmpty()){
            for(int i=0;i<OrderList.size();i++){
                //table view
            }
        }
    }
}
