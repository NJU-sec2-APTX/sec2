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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *完成
 * @author zhuyingshan
 */
public class ExecuteReplaceController {
    @FXML
    private AnchorPane basePane;
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
        System.out.println("client.UI.Hotel.ExecuteOrder.ExecuteReplaceController.add()"+ov==null);
        VBox box=new VBox();
        if(ov==null){
            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Hotel/ExecuteOrder/ExecuteSingle.fxml").toURL()));
            AnchorPane addAnchorPane=fxmll.load();
            ExecuteSingleController esc=fxmll.getController();
            esc.show(null);
            box.getChildren().add(addAnchorPane);
        }else{     
                    FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Hotel/ExecuteOrder/ExecuteSingle.fxml").toURL()));
                    AnchorPane addAnchorPane=fxmll.load();
                    ExecuteSingleController esc=fxmll.getController();
                    esc.show(ov);
                    box.getChildren().add(addAnchorPane);
        }
        orderPane.setContent(box);
    }

    @FXML
    private void searchButtonHandler(ActionEvent event) throws Exception{//通过订单号返回
        String orderID=searchField.getText();
        this.add(orderID);
    }
}
