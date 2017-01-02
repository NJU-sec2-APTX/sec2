/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.SaleManage;

import common.otherEnumClasses.UserRole;
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
public class GetSaleController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button GetSaleR;
    @FXML
    private TextField Gid;

    @FXML
    public void initialize(){
        
    }
    @FXML
    private void clickGetSaleR(ActionEvent event) throws IOException, Exception {
        FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/ShaowSale.fxml").toURL()));
        all=fXMLLoader.load();
        ChangeController sc=fXMLLoader.getController();
        sc.show(Gid.getText(),UserRole.Sales);  
    }
    
}
