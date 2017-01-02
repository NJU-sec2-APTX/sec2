/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.SaleManage;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class DeleteSaleController {

    @FXML
    private AnchorPane change;
    @FXML
    private Button DeleteSaleR;
    @FXML
    private TextField Did;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        
    }
    @FXML
    private void clickDeleteSaleR(ActionEvent event) throws Exception {
        ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).removeUser(Did.getText(), UserRole.Sales);
        if(rm==ResultMessage.Success){
            result.setText("删除成功");
        }else{
            result.setText("删除失败");
        }
    }
    
}
