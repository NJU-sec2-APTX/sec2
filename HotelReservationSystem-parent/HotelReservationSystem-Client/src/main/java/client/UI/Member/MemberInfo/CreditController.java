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
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
         try{
         if (size!=0) {
             VBox box=new VBox();
            for(int i=0;i<size;i++){
                FXMLLoader fxml=new FXMLLoader((new File("src/main/java/client/UI/Member/MemberInfo/CreditSingle.fxml").toURL()));
                AnchorPane addAnchorPane=fxml.load();
                CreditSingleController cc=fxml.getController();
                cc.show(creditList.get(i));
                box.getChildren().add(addAnchorPane);
            }
            showPane.setContent(box);
            }
         }catch (Exception e) {
            e.printStackTrace();
        }
     }

    @FXML
    private void backButtonHandler(ActionEvent event)throws Exception {
         if(Start.person.role==UserRole.Member){
            System.out.println("memberInfoButton");
            repBase.getChildren().clear();
            repBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberInfo/PersonInfoRep.fxml")).toURL()));
        }else{
            System.out.println("memberInfoButton");
            repBase.getChildren().clear();
            repBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberInfo/EnterpriseInfoRep.fxml")).toURL()));
        }
    }
}
