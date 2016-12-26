/*
完成
 */
package client.UI.Hotel;

import client.UI.Runner.Start;
import client.businessLogicService.userblService.UserIFactory;
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
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/RoomBase.fxml").toURL())));
        
    }
    @FXML
    private void checkOrderButtonHandler(ActionEvent event)throws  IOException{
        System.out.println("checkOrderButton");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/OrderInHotel.fxml").toURL())));
        
    }
    @FXML 
    public void initialize()throws IOException{
         System.out.println("executeOrderButton");
         accountLabel.setText(Start.person.role+Start.person.id);
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/RoomBase.fxml").toURL())));
    }
    
}
