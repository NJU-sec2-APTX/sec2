/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Runner.Register;

import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.userbl.UserFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class CompanyController  {

    @FXML
    private TextField accountField;
    @FXML
    private TextField passWordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField contactField;
    @FXML
    private Button okButton;
    @FXML
    private Label tipLabel;

    @FXML
    private void okButton(ActionEvent event) {
        try{
        String account=accountField.getText();
        String passWord=passWordField.getText();
        String nameString=nameField.getText();
        String contString=contactField.getText();
        UserIFactory uif=new UserFactory();
        MemberPO po=new MemberPO(account,UserRole.Enterprise);
        po.setName(nameString);
        po.setContact(contString);
        po.setPassword(passWord);
        MemberVO vO=new MemberVO(po);
        ResultMessage result=uif.register(account, vO);
        switch(result){
            case Success:
                tipLabel.setText("注册成功");
                break;
            case Failure:
                tipLabel.setText("注册失败");
                break;
            case  Registered:
                tipLabel.setText("该ID已被注册过");
                break;
        }
        }catch(Exception e){
            tipLabel.setText("注册失败");
        }
    }

    
}
