/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.OrderInHotel;

import common.vo.OrderVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class SingleOrderController  {

    @FXML
    private AnchorPane basePane;
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
    private Label statueLabel;
    
    public void show(OrderVO orderVO){
        orderID.setText(orderVO.id);
        makeLabel.setText(orderVO.createdTime.toString());
        memberLabel.setText(orderVO.clientId);
        moneyLabel.setText(orderVO.price+"");
        roomInfo.setText(orderVO.numOfRoom);
        statueLabel.setText(orderVO.state+"");
    }
    public void show(){
        orderID.setText("无");
        makeLabel.setText("");
        memberLabel.setText("");
        moneyLabel.setText("");
        roomInfo.setText("");
        statueLabel.setText("");
    }
}
