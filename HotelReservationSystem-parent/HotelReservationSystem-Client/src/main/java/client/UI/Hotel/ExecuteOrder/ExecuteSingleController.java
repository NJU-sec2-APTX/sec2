/*
完成
 */
package client.UI.Hotel.ExecuteOrder;

import client.LocalDateToDate;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.vo.OrderVO;
import java.net.URL;
import java.util.Calendar;
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
 * @author zhuyingshan
 */
public class ExecuteSingleController  {

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
    private Button executeOrderButton;
    public void show(OrderVO orderVO){
        if(orderVO == null){
            orderID.setText("无");
            executeOrderButton.setVisible(false);
        }else{
            orderID.setText(orderVO.id);
            makeLabel.setText(orderVO.createdTime.toString());
            memberLabel.setText(orderVO.clientId);
            moneyLabel.setText(orderVO.price+"");
            roomInfo.setText(orderVO.numOfRoom);
            if (orderVO.checkInTime==null) {
                executeOrderButton.setText("执行");
            }else if(orderVO.checkOutTime==null){
                executeOrderButton.setText("取消");
            }
        }
    }
    
    @FXML
    private void executeOrderButtonHandler(ActionEvent event) {
        executeOrderButton.setText("已执行");
        executeOrderButton.setDisable(true);
        Date time=LocalDateToDate.instantDate();
        OrderFactory.getOrderService().executeOrder(orderID.getText(), memberLabel.getText(), time,null);
    }
    
}
