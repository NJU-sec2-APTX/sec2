/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.MemberManage;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class ChangeMemberController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Button ChangeMemberR;
    @FXML
    private TextField Cid;
    @FXML
    private ChoiceBox<String> Crole;

    @FXML
    public void initialize(){
        Crole.getItems().addAll("个人会员","企业会员","酒店工作人员","网站营销人员","网站管理人员");
    }
    private void clickChangeMemberR(ActionEvent event) throws MalformedURLException, IOException, Exception {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/MemberManage/Change.fxml").toURL()));
        all=fXMLLoader.load();
        ChangeController sc=fXMLLoader.getController();
        sc.show(Cid.getText(),UserRole.getUserRole(Crole.getValue()));      
    }
    
}
