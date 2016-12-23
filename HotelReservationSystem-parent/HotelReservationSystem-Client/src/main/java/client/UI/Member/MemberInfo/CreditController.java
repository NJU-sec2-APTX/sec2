/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import client.UI.Runner.Start;
import client.businessLogicService.MemberFactory;
import common.otherEnumClasses.MemberItem;
import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.UserRole;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class CreditController  {

    @FXML
    private AnchorPane repBase;
    @FXML
    private Button backButton;
    @FXML
    private ScrollPane showPane;
    @FXML
     public void initialize ()throws Exception{
         MemberList memberItem=MemberFactory.getMemberMaintainService(Start.person.id, Start.person.role).getMemberCreditInfo();
         ArrayList<MemberItem> creditList=memberItem.getMemberList();
         int size=creditList.size();
         while(size!=0){
             
         }
     }

    @FXML
    private void backButtonHandler(ActionEvent event) {
    }
}
