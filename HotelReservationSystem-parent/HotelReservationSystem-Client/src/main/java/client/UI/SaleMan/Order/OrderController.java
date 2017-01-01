package client.UI.SaleMan.Order;

import java.io.File;
import java.io.IOException;
import client.businessLogicService.OrderFactory;
import common.vo.OrderVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class OrderController {
	@FXML
	Button  ChangeOrder,GetOrder,GetOrderR,ChangeOrderR;
	@FXML
        TextField number,Number,ID,Hotel,CreatedTime,Plantime,LastDoneTime,CheckinTime,CheckoutTime,CancelTime,NumberOfPerson,NumberOfRoom,hasChild,Day,Price,CreditChange;
        @FXML
	Pane change;
        @FXML 
        ChoiceBox<String> isall;
	@FXML
	AnchorPane all;
	Label result;
	AnchorPane add;
	
    @FXML
    //修改订单，恢复信用
        public void ChangeOrder() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Saleman/Order/ChangeOrder.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        
          
    @FXML
    //查看具体订单信息
        public void GetOrder() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Saleman/Order/GetOrder.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        public void clickGetOrderR() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Saleman/Order/ShowOrder.fxml").toURL()));
                all.getChildren().add(add);
                OrderFactory.getOrderService();
        }
     
}

        

