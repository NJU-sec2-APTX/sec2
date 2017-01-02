/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.SaleManage;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import com.sun.xml.internal.bind.v2.model.core.ID;
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
public class ChangeController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField Name;
    @FXML
    private TextField Contact;
    @FXML
    private TextField ID;
    @FXML
    private Button ChangeR;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        
    }
    public void show(String id,UserRole ur) throws Exception{
        UserVO vo=User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(id, ur);
        Name.setText(vo.getName());
        ID.setText(vo.getId());
        Contact.setText(vo.getContact());
    }
    private void clickChangeR(ActionEvent event) throws Exception {
        UserPO po=new UserPO(ID.getText(),UserRole.Sales);
        po.setContact(Contact.getText());
        po.setName(Name.getText());
        UserVO vo=new UserVO(po);
        ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo);
        if(rm==ResultMessage.Success){
            result.setText("修改成功");
        }else{
            result.setText("修改失败");
        }
    }
    
}
