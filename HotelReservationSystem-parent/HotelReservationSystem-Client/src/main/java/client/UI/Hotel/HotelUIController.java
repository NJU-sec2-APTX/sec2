/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
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
    private AnchorPane base;
    @FXML
    private AnchorPane rep;
    @FXML
    private Button checkOrderButton;

    

    @FXML
    private void exitButtonHandler(ActionEvent event)throws IOException {
        System.out.println("exitButton");
        base.getChildren().clear();
        base.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml").toURL())));
    }


    @FXML
    private void HotelInfoButtonHandler(ActionEvent event)throws  IOException{
        System.out.println("HotelInfoButton");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/HotelInfo/HotelInfo.fxml").toURL())));
    }

    @FXML
    private void StrategyAddButtonHandler(ActionEvent event) throws IOException{
        System.out.println("StrategyAddButton");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/HotelStrategyInput/HotelStrategyInput.fxml").toURL())));
    }
    
    @FXML
    private void executeOrderButtonHandler(ActionEvent event) throws  IOException{
        System.out.println("executeOrderButton");
         rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("ssrc/main/java/client/UI/Hotel/ExecuteOrder/ExecuteReplace.fxml").toURL())));
        
    }
    @FXML
    private void checkOrderButtonHandler(ActionEvent event)throws  IOException{
        System.out.println("checkOrderButton");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/OrderInHotel/OrderInHotel.fxml").toURL())));
        
    }
    @FXML 
    public void initialize()throws IOException{
         System.out.println("executeOrderButton");
         rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("ssrc/main/java/client/UI/Hotel/ExecuteOrder/ExecuteReplace.fxml").toURL())));
    }
    
}
