/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Order;

import client.businessLogicService.OrderFactory;
import common.vo.OrderVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class ChangeOrderController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Button GetOrderR;
    @FXML
    private TextField number;
    @FXML
    private ChoiceBox<String> isall;
    @FXML
    private Label result;
    
    @FXML
    public void initialize(){
        isall.getItems().addAll("一半","全部");
    }
    
    public void clickChangeOrderR() throws IOException{
        OrderVO vo=new OrderVO();
        String Isall=isall.getValue();
        Boolean IsAll;
        IsAll = "全部".equals(Isall);
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
}
