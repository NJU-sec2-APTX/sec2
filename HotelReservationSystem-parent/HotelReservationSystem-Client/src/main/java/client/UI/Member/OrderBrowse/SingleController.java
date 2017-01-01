/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.OrderBrowse;

import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.vo.OrderVO;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class SingleController  {

    @FXML
    private AnchorPane basePane;
    @FXML
    private Label IDLabel;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label makeTimeLabel;
    @FXML
    private Label executeTimeLabel;
    @FXML
    private Label statueLabel;
    @FXML
    private Button cancelButton;
   public void show( OrderVO orderVO){
        if(orderVO == null){
            IDLabel.setText("无");
            makeTimeLabel.setText("");
            hotelLabel.setText("");
            executeTimeLabel.setText("");
            statueLabel.setText("");
            cancelButton.setVisible(false);
        }else{
            IDLabel.setText(orderVO.id);
            makeTimeLabel.setText(orderVO.createdTime.toString());
            hotelLabel.setText(orderVO.hotel);
            executeTimeLabel.setText(orderVO.checkInTime.toString());
            statueLabel.setText(orderVO.state+"");
            if(orderVO.state==OrderState.NotDone){
                cancelButton.setVisible(true);
            }else{
                cancelButton.setVisible(false);
            }
        }
        
    }
    
    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        OrderFactory.getOrderService().clientCancelOrder(null);
        statueLabel.setText(OrderState.Canceled+""); 
        cancelButton.setVisible(false);
    }
}
