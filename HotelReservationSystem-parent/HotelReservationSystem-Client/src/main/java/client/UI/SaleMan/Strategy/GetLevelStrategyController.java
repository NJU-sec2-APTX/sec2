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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class GetLevelStrategyController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField gcredit4;
    @FXML
    private TextField gcredit5;
    @FXML
    private TextField gcredit1;
    @FXML
    private TextField gcredit2;
    @FXML
    private TextField gcredit3;
    @FXML
    private TextField glname;
    public void initialize(){
        
    }
    
    public void show (String name) throws MalformedURLException, IOException{
        all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetLevelStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(name);             
                glname.setText(vo.getName());
                String list[]=vo.getEnterprise().split("/");
                gcredit1.setText(list[0]);
                gcredit2.setText(list[1]);
                gcredit3.setText(list[2]);
                gcredit4.setText(list[3]);
                gcredit5.setText(list[4]);         
    }
}
