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
    private Label makeLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private Label oprationLabel;
    @FXML
    private Label changeLabel;

    /**
     * Initializes the controller class.
     */
    public void show(MemberItem memberItem){
        idLabel.setText(memberItem.getOrderID());
        oprationLabel.setText(memberItem.getOperation().toString());
        makeLabel.setText(memberItem.getDate().toString());
        changeLabel.setText(memberItem.getChange()+"");
        creditLabel.setText(memberItem.getCredit()+"");
    }
    @FXML
    public void initialize() {
    }    
    
}
