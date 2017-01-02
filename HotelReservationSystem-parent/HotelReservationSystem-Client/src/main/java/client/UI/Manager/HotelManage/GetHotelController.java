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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class GetHotelController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button GetSaleR;
    @FXML
    private TextField Gname;

    @FXML
    public void initialize(){
        
    }
    private void clickGetSaleR() throws IOException {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/HotelManage/ShowHotel.fxml").toURL()));
        AnchorPane add =fXMLLoader.load();
        all.getChildren().add(add);
        ShowHotelController sc=fXMLLoader.getController();
        sc.show(Gname.getText());
    }
    
}
