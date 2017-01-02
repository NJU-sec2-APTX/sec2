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
import common.po.UserPO;
import common.vo.UserVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class AddSaleController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField contact;
    @FXML
    private TextField id;
    @FXML
    private Button AddSaleR;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        
    }
    private void clickAddSaleR(ActionEvent event) throws Exception {
        UserPO po=new UserPO(id.getText(),UserRole.Sales);
        po.setContact(contact.getText());
        po.setName(name.getText());
        po.setPassword(password.getText());
        UserVO vo=new UserVO(po);
        ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo);
        if(rm==ResultMessage.Success){
            result.setText("新增营销人员成功");
        }else{
            result.setText("新增失败");
        }
    }
    
}
