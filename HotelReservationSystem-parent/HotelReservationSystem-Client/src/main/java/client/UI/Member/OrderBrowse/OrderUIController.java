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
import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private Button makeOrderTimeButton1;
    @FXML
    private ChoiceBox<?> orderStatuechooseButton;
    @FXML
    private Button cancelOrderTimeButton;
    @FXML
    private TableView<?> table;

    @FXML
    private void makeOrderTimeButtonHandler(ActionEvent event) {
    }

    public void initialize()throws Exception  {
        ArrayList<OrderVO> OrderList = OrderFactory.getOrderService().searchOrderListFromData(Start.person, null, null);
        if(OrderList.isEmpty()){
            for(int i=0;i<OrderList.size();i++){
                AnchorPane addAnchorPane=FXMLLoader.load((new File("src/main/java/client/UI/Hotel/HotelUI.fxml")).toURL());
                
                showPane.getChildrenUnmodifiable().add(addAnchorPane);
            }
        }
    }

    @FXML
    private void cacnelOrderTimeButtonHandler(ActionEvent event) {
    }
}
