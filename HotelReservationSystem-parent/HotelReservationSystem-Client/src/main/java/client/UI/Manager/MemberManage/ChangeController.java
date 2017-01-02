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
public class ChangeController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField cname;
    @FXML
    private TextField ccontact;
    @FXML
    private TextField chotel;
    @FXML
    private TextField cid;
    @FXML
    private ChoiceBox<String> crole;
    @FXML
    private Button ChangeR;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        crole.getItems().addAll("个人会员","企业会员","酒店工作人员","网站营销人员","网站管理人员");
    }
    public void show(String id,UserRole ur) throws Exception{
        UserVO vo=User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(id,ur);               
        cname.setText(vo.getName());
        cid.setText(vo.getId());
        ccontact.setText(vo.getContact());
        chotel.setText(vo.getBelongHotel());
        crole.setAccessibleText(vo.getUserRole().toString());
    }
    @FXML
    private void clickChangeR(ActionEvent event) throws Exception {
        UserPO po=new UserPO(cid.getText(),UserRole.getUserRole(crole.getValue()));
        po.setContact(ccontact.getText());
        po.setName(cname.getText());
        po.setbelonghotel(chotel.getText());
        UserVO vo=new UserVO(po);
        ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo);
        if(rm==ResultMessage.Success){
            result.setText("修改成功");
        }else{
            result.setText("修改失败");
        }
    }
    
}
