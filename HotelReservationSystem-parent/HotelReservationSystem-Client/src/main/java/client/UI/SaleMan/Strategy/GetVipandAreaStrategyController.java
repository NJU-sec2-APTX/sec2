/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.vo.StrategyVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 叶枫
 */
public class GetVipandAreaStrategyController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField gvname;
    @FXML
    private TextField gcount1;
    @FXML
    private TextField gcount2;
    @FXML
    private TextField gcount3;
    @FXML
    private TextField gcount5;
    @FXML
    private TextField gcount4;
    @FXML
    private ChoiceBox<String > area;
    @FXML
    private Button AddVipandAreaStrategyR;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        
    }    
    public void show(String name) throws MalformedURLException, IOException{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetVipandAreaStrategy.fxml").toURL()));
        all.getChildren().add(add);
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(name);
        gvname.setText(vo.getName());
        String list[]=vo.getEnterprise().split("/");
        gcount1.setText(list[0]);
        gcount2.setText(list[1]);
        gcount3.setText(list[2]);
        gcount4.setText(list[3]);
        gcount5.setText(list[4]);
    }
    
    
}
