/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Member;

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
 * @author 陈长生
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
    private Button creditButton;
    @FXML
    private Button correctInfoButton;
    @FXML
    private Label idField;
    @FXML
    private Label nameField;
    @FXML
    private Label contactField;
    @FXML
    private Label creditField;
    @FXML
    private Label rankField;

  

    @FXML
   private void exitButtonHandler(ActionEvent event) throws IOException{
        System.out.println("退出登录状态");
        base.getChildren().clear();
        base.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Runner.fxml").toURL())));
    }

    @FXML
    private void memberInfoButtonHandler(ActionEvent event)throws IOException{
        System.out.println("进入memeberinfo");
        replacePane.getChildren().clear();
        replacePane.getChildren().add(FXMLLoader.load((new File("src/UI/Member/MemberInfo/MemberInfoRep.fxml")).toURL()));
    }

    @FXML
    private void searchHotelButtonHandler(ActionEvent event)throws IOException {
        System.out.println("进入searchHotel");
        replacePane.getChildren().clear();
         replacePane.getChildren().add(FXMLLoader.load((new File("src/UI/Member/SearchHotel/SearchHotel.fxml")).toURL()));
    }

    @FXML
    private void orderButtonHandler(ActionEvent event)throws IOException{
        System.out.println("查看订单");
        replacePane.getChildren().clear();
        replacePane.getChildren().add(FXMLLoader.load((new File("src/UI/Member/OrderBrowse/OrderUI.fxml")).toURL()));
    }

    @FXML
    private void creditButtonHandler(ActionEvent event) throws IOException{
        System.out.println("进入查看信用值");
        
    }

    @FXML
    private void correctInfoButtonHandler(ActionEvent event) {
        System.out.println("修改个人信息");
    }
    
}
