/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import client.LocalDateToDate;
import client.UI.Runner.Start;
import client.businessLogicService.MemberFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class PersonCorrectController  {

    @FXML
    private AnchorPane repBase;
    @FXML
    private Pane replacePane;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker birPicker;
    @FXML
    private Label tipLabel;

    /**
     * Initializes the controller class.
     */
    public void initialize()throws Exception {
        MemberVO personVO=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Member).getInfo();
        
        nameField.setText(personVO.getName());
        contactField.setText(personVO.getContact());
    }    

    @FXML
    private void okButtonHandler(ActionEvent event)throws Exception {
        String   password=passwordField.getText();
        String name=nameField.getText();
        Date bir=LocalDateToDate.localDateToDate(birPicker.getValue());
        String contact=contactField.getText();
        if (bir.after(LocalDateToDate.instantDate())||password==null||name==null||contact==null) {
            tipLabel.setText("信息错误");
        }else{
            MemberPO pO=new MemberPO(Start.person.id, UserRole.Member);
            pO.setBirthday(bir);
            pO.setContact(contact);
            pO.setPassword(password);
            pO.setName(name);
            MemberVO vO=new MemberVO(pO);
            ResultMessage re=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Member).modifyInfo(vO);
            if (re==ResultMessage.Failure) {
                tipLabel.setText("更新错误");
            }else{
                tipLabel.setText("更新完成");
            }
        }
        
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) throws Exception{
            System.out.println("memberInfoButton");
            repBase.getChildren().clear();
            repBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberInfo/PersonInfoRep.fxml")).toURL()));
    }
    
}
