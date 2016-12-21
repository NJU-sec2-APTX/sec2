/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import client.UI.Runner.Start;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.OrderVO;
import java.io.File;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class ExecuteReplaceController {
    @FXML
    private AnchorPane basePane;
    @FXML
    private ScrollPane showPane;
    @FXML
    private AnchorPane rep;
  
    /*
    *用于showpanel中添加
    */
    private void add( Person p)throws Exception{
        ArrayList <OrderVO> orderInHotelList=OrderFactory.getOrderService().searchOrderListFromData(p, OrderState.NotDone, null);
        if(orderInHotelList.isEmpty()){
            FXMLLoader fxmll=new FXMLLoader();
            AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Hotel/ExecuteOrder/ExecuteSingle.fxml").toURL()));
            ExecuteSingleController esc=fxmll.getController();
            esc.show(null);
            showPane.getChildrenUnmodifiable().add(addAnchorPane);
        }else{
                    for(int i=0;i<orderInHotelList.size();i++){
                    FXMLLoader fxmll=new FXMLLoader();
                    AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Hotel/ExecuteOrder/ExecuteSingle.fxml").toURL()));
                    ExecuteSingleController esc=fxmll.getController();
                    esc.show(orderInHotelList.get(i));
                    showPane.getChildrenUnmodifiable().add(addAnchorPane);
                }
        }
    }
    
    public void initialize() throws Exception{
        this.add(Start.person);
    }
}
