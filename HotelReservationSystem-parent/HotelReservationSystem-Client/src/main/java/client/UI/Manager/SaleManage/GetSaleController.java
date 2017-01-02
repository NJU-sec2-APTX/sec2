/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.SaleManage;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.UserRole;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class GetSaleController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button GetSaleR;
    @FXML
    private TextField Gid;
    AnchorPane add;
    @FXML
    private Label result;
    @FXML
    public void initialize(){
        
    }
    @FXML
    private void clickGetSaleR(ActionEvent event) throws IOException, Exception {
        if(User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(Gid.getText(), UserRole.Sales)==null){
            result.setText("用户不存在");
        }else{
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/ShowSale.fxml").toURL()));
        add=fXMLLoader.load();  
        ShowSaleController sc=fXMLLoader.getController();
        sc.show(Gid.getText(),UserRole.Sales);  
        all.getChildren().clear();
        all.getChildren().add(add);
      
    }
    }
}
