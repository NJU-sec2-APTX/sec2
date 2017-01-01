/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.HotelManage;

import client.UI.SaleMan.Strategy.ChangeLevelStrategyController;
import client.businessLogicService.HotelFactory;
import common.vo.HotelVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
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
    private AnchorPane all,add;
    private TextField Cname;
    @FXML
    private Pane change;
    @FXML
    private TextField cname;
    @FXML
    private TextField cstar;
    @FXML
    private TextField caddress;
    @FXML
    private TextField cid;
    @FXML
    private ChoiceBox<String> carea;
    @FXML
    private Button AddHotelR;
    @FXML
    private Label result;
    @FXML
    public void initialize(){
        
    }
    public void ChangeHotel() throws MalformedURLException, IOException{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/ChangeHotel.fxml").toURL()));
        all.getChildren().add(add);
    }
    public void clickChangeHotelR() throws IOException, Exception{
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/HotelManage/Change.fxml").toURL()));
        all=fXMLLoader.load();
        ChangeController sc=fXMLLoader.getController();
        sc.show(Cname.getText());
        
        }
    
}
