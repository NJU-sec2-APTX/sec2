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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    public void initialize()throws Exception {
        MemberVO memberVO=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Enterprise).getInfo();
       
        nameField.setText(memberVO.getName());
        contactField.setText(memberVO.getContact());
    }    
    
    @FXML
    private void okButtonHandler(ActionEvent event)throws Exception {
        String   password=passwordField.getText();
        String name=nameField.getText();
        String contact=contactField.getText();
        if (password==null||name==null||contact==null) {
            tipLabel.setText("信息错误");
        }else{
            MemberPO mpo=new MemberPO(Start.person.id, UserRole.Enterprise);
            //修改ID
            mpo.setPassword(password);
            mpo.setName(name);
            MemberVO vo=new MemberVO(mpo);
            ResultMessage re=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Member).modifyInfo(vo);
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
