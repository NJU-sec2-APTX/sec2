/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.SaleManage;

import common.otherEnumClasses.UserRole;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
public class ChangeSaleController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button ChangeSaleR;
    @FXML
    private TextField Cid;

    @FXML
    public void initialize(){
        
    }
    private void clickChangeSaleR(ActionEvent event) throws MalformedURLException, IOException, Exception {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/Change.fxml").toURL()));
        all=fXMLLoader.load();
        ChangeController sc=fXMLLoader.getController();
        sc.show(Cid.getText(),UserRole.Sales);  
    }
    
}
