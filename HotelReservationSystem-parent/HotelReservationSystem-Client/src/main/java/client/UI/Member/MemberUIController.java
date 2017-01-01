/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member;

import client.UI.Runner.RunnerController;
import client.UI.Runner.Start;
import static client.UI.Runner.Start.person;
import client.businessLogicService.MemberFactory;
import client.businessLogicService.User_Factory;
import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.userbl.UserFactory;
import common.otherEnumClasses.UserRole;
import common.po.MemberPO;
import common.vo.MemberVO;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class MemberUIController  {
    @FXML
    private AnchorPane base;
    @FXML
    private Label accountField;
    @FXML
    private Button exitButton;
    @FXML
    private Button memberInfoButton;
    @FXML
    private Button searchHotelButton;
    @FXML
    private Button orderButton;
    @FXML
    private Pane replacePane;

  

    @FXML
   private void exitButtonHandler(ActionEvent event) throws IOException{//登出按键，更改用户的状态
        System.out.println("exitButton");
        base.getChildren().clear();
        base.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml").toURL())));
        System.out.print("退出"+person.id);
        if (null!=person.role){
         User_Factory.getUserService().logout(person.id,person.role);
         System.out.println("登出");
        }
        
    }

    @FXML
    private void memberInfoButtonHandler(ActionEvent event)throws IOException{
        if(Start.person.role==UserRole.Member){
            System.out.println("memberInfoButton");
            replacePane.getChildren().clear();
            replacePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberInfo/PersonInfoRep.fxml")).toURL()));
        }else{
            System.out.println("memberInfoButton");
            replacePane.getChildren().clear();
            replacePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberInfo/EnterpriseInfoRep.fxml")).toURL()));
        }
        
    }

    @FXML
    private void searchHotelButtonHandler(ActionEvent event)throws IOException {
        System.out.println("searchHotelButton");
        replacePane.getChildren().clear();
         replacePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/SearchHotel/SearchHotel.fxml")).toURL()));
    }

    @FXML
    private void orderButtonHandler(ActionEvent event)throws IOException{
        System.out.println("orderButton");
        replacePane.getChildren().clear();
        replacePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/OrderBrowse/OrderUI.fxml")).toURL()));
    }
    @FXML
    public  void initialize()throws Exception{
        replacePane.getChildren().clear();
        replacePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/SearchHotel/SearchHotel.fxml")).toURL()));
        System.err.println(person.id);
        MemberVO vO=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Member).getInfo();
        accountField.setText("Welcome! "+vO.getName());
    }
    
}
