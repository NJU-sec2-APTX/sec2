/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Order;

import client.UI.Manager.SaleManage.ChangeController;
import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.UserRole;
import common.vo.UserVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class GetOrderController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button GetOrderR;
    @FXML
    private TextField number;

    @FXML
    public void initialize(){
        
    }
    @FXML
    private void clickGetOrderR(ActionEvent event) throws MalformedURLException, IOException {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/Change.fxml").toURL()));
        all=fXMLLoader.load();
        ShowOrderController sc=fXMLLoader.getController();
        sc.show(number.getText());  
    }
    
}
