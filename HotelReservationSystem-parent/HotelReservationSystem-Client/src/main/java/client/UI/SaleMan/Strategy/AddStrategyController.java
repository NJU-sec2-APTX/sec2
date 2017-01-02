/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class AddStrategyController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private Button AddLevelStrategy;
    @FXML
    private Button AddDateStrategy;
    @FXML
    private Button AddVipandAreaStrategy;
    AnchorPane add;
    @FXML
    private void AddLevelStrategy() throws MalformedURLException, IOException {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/AddLevelStrategy.fxml").toURL()));
            add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);
    }

    @FXML
    private void AddDateStrategy(ActionEvent event) throws MalformedURLException, IOException {
        FXMLLoader fXMLLoader2 =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/AddDateStrategy.fxml").toURL()));
	add=fXMLLoader2.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);
    }

    @FXML
    private void AddVipandAreaStrategy(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader3 =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/AddVipandAreaStrategy.fxml").toURL()));
	add=fXMLLoader3.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);
    }
    
}
