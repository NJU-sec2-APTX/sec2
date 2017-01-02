/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class AddLevelStrategyController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField credit4;
    @FXML
    private TextField credit5;
    @FXML
    private TextField credit1;
    @FXML
    private TextField credit2;
    @FXML
    private TextField credit3;
    @FXML
    private Button AddLevelStrategyR;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        
    }
    @FXML
    private void clickAddLevelStrategyR(ActionEvent event) throws IOException {
        ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addMemberLevelStrategy(GetCredit(credit1.getText(),credit2.getText(),credit3.getText(),credit4.getText(),credit5.getText()));
        if(rm==ResultMessage.Success){
            result.setText("新增会员等级制度成功");
        }else{
            result.setText("新增失败");
        }
    }
    public String GetCredit(String c1,String c2,String c3,String c4,String c5) throws IOException{
        return c1+"/"+c2+"/"+c3+"/"+c4+"/"+c5;
    }
}
