/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Order;

import client.businessLogicService.OrderFactory;
import common.vo.OrderVO;
import java.io.IOException;
import javafx.fxml.FXML;
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
    @FXML
    public void clickChangeOrderR() throws IOException{
        Boolean IsAll= "全部".equals(isall.getValue());
        //先找出要修改的订单
        OrderVO vo=OrderFactory.getOrderService().searchOrderById(number.getText());
        //更改订单并恢复信用
        OrderFactory.getOrderService().managerCancalOrder(vo, IsAll);
        if(OrderFactory.getOrderService().managerCancalOrder(vo, IsAll)){
            result.setText("恢复信用成功");
        }else{
            result.setText("恢复失败");
        }
    }
}
