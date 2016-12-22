/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import common.otherEnumClasses.OrderState;
import common.vo.OrderVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class ReveredOrderController  {

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
    public void show(OrderVO o){
        if (o==null) {
            IDLabel.setText("无");
        }else{
            IDLabel.setText(o.id);
            hotelLabel.setText(o.hotel);
            makeTimeLabel.setText(o.createdTime.toString());
            if(o.state==OrderState.Done){
            statueLabel.setText(o.state.toString());
            executeTimeLabel.setText(o.checkInTime.toString());
            }else {
            statueLabel.setText(o.state.toString());
            executeTimeLabel.setText("");
        }
        }
        
    }
    @FXML
    public void initialize() {
        
    }    
    
}
