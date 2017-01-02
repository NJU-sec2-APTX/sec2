/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.MemberManage;

import common.otherEnumClasses.UserRole;
import java.io.File;
import java.io.IOException;
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
public class GetMemberController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button GetMemberR;
    @FXML
    private TextField Gid;
    @FXML
    private ChoiceBox<String> Grole;

    @FXML
    public void initialize(){
        Grole.getItems().addAll("个人会员","企业会员","酒店工作人员","网站营销人员","网站管理人员");
    }
    private void clickGetMemberR(ActionEvent event) throws IOException, Exception {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/MemberManage/ShowMember.fxml").toURL()));
        all=fXMLLoader.load();
        ShowMemberController sc=fXMLLoader.getController();
        sc.show(Gid.getText(),UserRole.getUserRole(Grole.getValue()));  
    }
    
}
