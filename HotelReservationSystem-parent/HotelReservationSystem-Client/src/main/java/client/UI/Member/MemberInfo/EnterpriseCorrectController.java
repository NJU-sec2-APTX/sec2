/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import client.UI.Runner.Start;
import client.businessLogicService.MemberFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class EnterpriseCorrectController  {

    @FXML
    private AnchorPane repBase;
    @FXML
    private Pane replacePane;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label tipLabel;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize()throws Exception {
        MemberVO memberVO=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Enterprise).getInfo();
        idField.setText(memberVO.getId());
        nameField.setText(memberVO.getName());
        contactField.setText(memberVO.getContact());
    }    
    
    @FXML
    private void okButtonHandler(ActionEvent event)throws Exception {
        String  id=idField.getText();
        String   password=passwordField.getText();
        String name=nameField.getText();
        String contact=contactField.getText();
        if (id==null||password==null||name==null||contact==null) {
            tipLabel.setText("信息错误");
        }else{
            MemberPO pO=new MemberPO(Start.person.id, UserRole.Member);
            pO.setContact(contact);
            pO.setPassword(password);
            pO.setName(name);
            ResultMessage re=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Member).modifyInfo(pO);
            if (re==ResultMessage.Failure) {
                tipLabel.setText("更新错误");
            }else{
                tipLabel.setText("更新完成");
            }
        }
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event)throws Exception {
            repBase.getChildren().clear();
            repBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberInfo/EnterpriseInfoRep.fxml")).toURL()));
    
    }
    
}
