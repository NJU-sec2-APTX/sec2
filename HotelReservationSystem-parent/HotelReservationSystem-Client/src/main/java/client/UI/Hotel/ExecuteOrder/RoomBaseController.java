/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.ExecuteOrder;

import client.UI.Runner.Start;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.otherEnumClasses.Person;
import common.vo.OrderVO;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class RoomBaseController  {

    @FXML
    private AnchorPane basePane;
    @FXML
    private AnchorPane repPanel;
    @FXML
    private Button executeButton;
    @FXML
    private Button cancelRoomWithOrderButton;
    @FXML
    private Button outHotelButton;
    @FXML
    private Button inHotelButton;

   
    @FXML
    public void initialize() throws Exception{
        FXMLLoader fxmll=new FXMLLoader();
        repPanel=fxmll.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/ExecuteReplace.fxml").toURL()));
        ExecuteReplaceController erc=fxmll.getController();
    }

    @FXML
    private void executeButtonHandler(ActionEvent event) throws Exception{
        FXMLLoader fxmll=new FXMLLoader();
        repPanel=fxmll.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/ExecuteReplace.fxml").toURL()));
    }

    @FXML
    private void cancelRoomWithOrderButtonHandler(ActionEvent event) throws Exception{
        FXMLLoader fxmll=new FXMLLoader();
        repPanel=fxmll.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/OutWithOrderRep.fxml").toURL()));
    }

    @FXML
    private void outHotelButtonHandler(ActionEvent event) throws Exception{
        repPanel.getChildren().clear();
        repPanel.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/OutHotel.fxml").toURL())));
    }

    @FXML
    private void inHotelButtonHandler(ActionEvent event) throws Exception{
        repPanel.getChildren().clear();
        repPanel.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/ExecuteOrder/InHotel.fxml").toURL())));
    }
    
}
