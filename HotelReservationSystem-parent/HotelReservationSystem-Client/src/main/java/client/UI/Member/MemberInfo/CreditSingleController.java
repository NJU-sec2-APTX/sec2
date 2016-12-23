/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import common.otherEnumClasses.MemberItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class CreditSingleController  {

    @FXML
    private AnchorPane repBase;
    @FXML
    private Label idLabel;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label makeLabel;
    @FXML
    private Label executeLabel;
    @FXML
    private Label statueLabel;
    @FXML
    private Label creditLabel;

    /**
     * Initializes the controller class.
     */
    public void show(MemberItem memberItem){
        idLabel.setText(memberItem.getOrderID());
        hotelLabel.setText(memberItem.);
    }
    @FXML
    public void initialize() {
    }    
    
}
