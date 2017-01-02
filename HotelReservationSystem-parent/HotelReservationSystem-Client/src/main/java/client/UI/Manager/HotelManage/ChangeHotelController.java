/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.HotelManage;

import client.businessLogicService.HotelFactory;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class ChangeHotelController {


    @FXML
    private AnchorPane all;
    private AnchorPane addAnchorPane;
    private TextField Cname;
   
    @FXML
    private  Label result;
    @FXML
    public void initialize(){
        
    }
    public void clickChangeHotelR() throws IOException, Exception{
        if(HotelFactory.getHotelMaintainService().getHotelInfo(Cname.getText())==null){
            result.setText("酒店不存在");
        }else{
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/HotelManage/Change.fxml").toURL()));
        addAnchorPane=fXMLLoader.load();
        ChangeController sc=fXMLLoader.getController();
        all.getChildren().add(addAnchorPane);
        sc.show(Cname.getText());
        }
    }
}
