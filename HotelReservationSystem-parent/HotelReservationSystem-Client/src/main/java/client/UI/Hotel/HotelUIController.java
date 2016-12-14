/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Hotel;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class HotelUIController {

    @FXML
    private Label accountLabel;
    @FXML
    private Button exitButton;
    @FXML
    private Button HotelInfoButton;
    @FXML
    private Button strategyAddButton;
    @FXML
    private Button executeOrderButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchArea;
    @FXML
    private ScrollPane showPane;
    @FXML
    private AnchorPane base;
    @FXML
    private AnchorPane rep;
    @FXML
    private Button checkOrderButton;
    @FXML
    private Button confirmOrderButton;

    

    @FXML
    private void exitButtonHandler(ActionEvent event)throws IOException {
        System.out.println("退出");
        base.getChildren().clear();
        base.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Runner.fxml").toURL())));
    }


    @FXML
    private void HotelInfoButtonHandler(ActionEvent event)throws  IOException{
        System.out.println("查看酒店信息");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/HotelInfo/HotelInfo.fxml").toURL())));
    }

    @FXML
    private void StrategyAddButtonHandler(ActionEvent event) throws IOException{
        System.out.println("查看酒店策略");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/HotelStrategyInput/HotelStrategyInput.fxml").toURL())));
    }
    
    @FXML
    private void executeOrderButtonHandler(ActionEvent event) throws  IOException{
        System.out.println("执行订单");
         rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/ExecuteOrder/ExecuteReplace.fxml").toURL())));
        
    }

    @FXML
    private void searchButtonHandler(ActionEvent event) {
        System.out.println("搜索订单");
    }

    @FXML
    private void checkOrderButtonHandler(ActionEvent event)throws  IOException{
        System.out.println("查看订单");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/OrderInHotel/OrderInHotel.fxml").toURL())));
        
    }

    @FXML
    private void confirmOrderButtonHandler(ActionEvent event) {
        
    }
    
}
