/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.MemberManage;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class AddMemberController {

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
    private TextField hotel;
    @FXML
    private TextField id;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Button AddMemberR;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        role.getItems().addAll("个人用户","企业用户","酒店工作人员","网站营销人员","网站管理人员");
    }
    private void clickAddMemberR(ActionEvent event) throws Exception {
        UserPO po=new UserPO(id.getText(),UserRole.getUserRole(role.getValue()));
        po.setContact(contact.getText());
        po.setName(name.getText());
        po.setPassword(password.getText());
        po.setbelonghotel(hotel.getText());
        UserVO vo=new UserVO(po);
        ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo);
        if(rm==ResultMessage.Success){
            result.setText("新增用户成功");
        }else{
            result.setText("新增失败");
        }
    }
    
}
