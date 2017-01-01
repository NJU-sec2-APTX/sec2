/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import static common.otherEnumClasses.CreditOperation.Recharge;
import common.otherEnumClasses.MemberItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
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
    @FXML
    private ToolBar toolbar;

    /**
     * Initializes the controller class.
     */
    public void show(MemberItem memberItem){
        if (memberItem.getOrderID()==null||memberItem.getOrderID().equals("null")) {
            System.out.println("1");
             idLabel.setText("无");
        }else{
            System.out.println("2");
             idLabel.setText(memberItem.getOrderID());
        }
        switch(memberItem.getOperation()){
            case Recharge:
                 oprationLabel.setText("充值");
                break;
            case Exception:
                 oprationLabel.setText("异常");
                break;
            case Cancel:
                 oprationLabel.setText("取消订单");
                break;
            case ExceptionCancel:
                 oprationLabel.setText("异常订单取消");
                break;
            case Execute:
                 oprationLabel.setText("执行");
                break;
        }
        makeLabel.setText(memberItem.getDate().toString());
        changeLabel.setText(memberItem.getChange()+"");
        creditLabel.setText(memberItem.getCredit()+"");
    }
    public void initialize() {
    }    
    
}
