/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import client.LocalDateToDate;
import client.UI.Runner.Start;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.OrderVO;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *完成
 * @author zhuyingshan
 */
public class ExecuteReplaceController {
    @FXML
    private AnchorPane basePane;
    private ScrollPane showPane;
    @FXML
    private AnchorPane rep;
    @FXML
    private ScrollPane orderPane;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    
    /*
    *用于showpanel中添加
    */
    private void add( String orderID)throws Exception{
        Date date=LocalDateToDate.instantDate();
        OrderVO ov=OrderFactory.getOrderService().executeOrder(orderID, Start.person.id, date, null);
        if(ov==null){
            showPane.getChildrenUnmodifiable().clear();
            FXMLLoader fxmll=new FXMLLoader();
            AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Hotel/ExecuteOrder/ExecuteSingle.fxml").toURL()));
            ExecuteSingleController esc=fxmll.getController();
            esc.show(null);
            showPane.getChildrenUnmodifiable().add(addAnchorPane);
        }else{     
                    showPane.getChildrenUnmodifiable().clear();
                    FXMLLoader fxmll=new FXMLLoader();
                    AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Hotel/ExecuteOrder/ExecuteSingle.fxml").toURL()));
                    ExecuteSingleController esc=fxmll.getController();
                    esc.show(ov);
                    showPane.getChildrenUnmodifiable().add(addAnchorPane);
        }
    }
    public void initialize() {
        
    }

    @FXML
    private void searchButtonHandler(ActionEvent event) throws Exception{//通过订单号返回
        String orderID=searchField.getText();
        this.add(orderID);
    }
}
