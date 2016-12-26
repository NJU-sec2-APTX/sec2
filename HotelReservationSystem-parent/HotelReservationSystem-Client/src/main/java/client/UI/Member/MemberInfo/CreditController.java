/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import client.UI.Member.SearchHotel.SingleController;
import client.UI.Runner.Start;
import client.businessLogicService.MemberFactory;
import common.otherEnumClasses.MemberItem;
import common.otherEnumClasses.MemberList;
import common.otherEnumClasses.UserRole;
import java.io.File;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
         if (size!=0) {
            for(int i=0;i<size;i++){
                FXMLLoader fxml=new FXMLLoader();
                AnchorPane addAnchorPane=fxml.load((new File("src/main/java/client/UI/Member/MemberInfo/CreditSingle.fxml").toURL()));
                CreditSingleController cc=fxml.getController();
                cc.show(creditList.get(i));
                showPane.getChildrenUnmodifiable().add(addAnchorPane);
            }
        }
     }

    @FXML
    private void backButtonHandler(ActionEvent event) {
        
    }
}
