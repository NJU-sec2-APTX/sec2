/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import client.LocalDateToDate;
import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import common.vo.OrderVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class OutWithOrderRepController {

    @FXML
    private AnchorPane basePane;
    @FXML
    private ScrollPane orderPane;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Label orderID;
    @FXML
    private Label makeLabel;
    @FXML
    private Label memberLabel;
    @FXML
    private Label moneyLabel;
    @FXML
    private Label roomInfo;
    @FXML
    private Button outOrderButton;
    @FXML
    private ToolBar orderBar;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        orderBar.setVisible(false);
    }    

    @FXML
    private void searchButtonHandler(ActionEvent event) {
        String orderidString=searchField.getText();
        OrderVO orderVO=HotelFactory.getHotelUpdateService().onlineCheckOut(Start.person.id, orderidString, LocalDateToDate.instantDate());
        if(orderVO == null){
            orderID.setText("无");
        }else{
            orderID.setText(orderVO.id);
            makeLabel.setText(orderVO.createdTime.toString());
            memberLabel.setText(orderVO.clientId);
            moneyLabel.setText(orderVO.price+"");
            roomInfo.setText(orderVO.numOfRoom);
            outOrderButton.setText("已退房");
            outOrderButton.setDisable(true);
        }
    }

    
}
