package client.UI.SaleMan.Order;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class OrderController {
	Pane change;
        @FXML 
	AnchorPane all;
	Label result;
	AnchorPane add;
	
    @FXML
    //修改订单，恢复信用
        public void ChangeOrder() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Order/ChangeOrder.fxml").toURL()));
            all=fXMLLoader.load();           
            ChangeOrderController coc=fXMLLoader.getController();    
            coc.initialize();
        }              
    @FXML
    //查看具体订单信息
        public void GetOrder() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Order/GetOrder.fxml").toURL()));
            all=fXMLLoader.load();           
            GetOrderController goc=fXMLLoader.getController();           
        }            
}

        

