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
                isall.getItems().addAll("一半","全部");
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Saleman/Order/ChangeOrder.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        public void clickChangeOrderR() throws IOException{
                OrderVO vo=new OrderVO();
                String Isall=isall.getValue();
                Boolean IsAll;
                if(Isall=="全部"){
                    IsAll=true;
                }else{
                    IsAll=false;
                }
                //先找出要修改的订单
                OrderFactory.getOrderService();
                //更改订单并恢复信用
                OrderFactory.getOrderService().managerCancalOrder(vo, IsAll);
                if(OrderFactory.getOrderService().managerCancalOrder(vo, IsAll)){
                    result.setText("恢复信用成功");
                }else{
                    result.setText("恢复失败");
                }
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
        
        public String GetNumber() throws IOException{
                return number.getText();
        }
        
        public void ShowNumber() throws IOException{
                
        }
        
        public void ShowID() throws IOException{
            
        }
        
        public void ShowHotel() throws IOException{
            
        }
        
        public void ShowCreatedTime(){
            
        }
        
        public void ShowLastDoneTime(){
           
        }
        
        public void ShowPlanTime(){
            
        }
        
        public void ShowCheckinTime(){
            
        }
        
        public void ShowCheckoutTime(){
            
        }
        
        public void ShowCancelTime(){
            
        }
        
        public void ShowNumberOfPerson(){
            
        }
        
        public void ShowNumberOfRoom(){
            
        }  
        
        public void ShowDay(){
            
        }
        
        public void ShowhasChild(){
            
        }
        
        public void ShowPrice(){
            
        }
        
        public void ShowCreditChange(){
            
        }
}

        

