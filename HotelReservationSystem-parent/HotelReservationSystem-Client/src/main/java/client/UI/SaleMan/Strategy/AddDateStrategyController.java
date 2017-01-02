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
import java.util.Date;
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
public class AddDateStrategyController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField datename;
    @FXML
    private TextField beginyear;
    @FXML
    private TextField beginmonth;
    @FXML
    private TextField beginday;
    @FXML
    private TextField endyear;
    @FXML
    private TextField endmonth;
    @FXML
    private TextField endday;
    @FXML
    private TextField datecount;
    @FXML
    private Button AddDateStrategyR;
    @FXML
    private Label result;
    @FXML
    public void clickChangeDateStrategyR() throws IOException{
        ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).addSpecialDateStrategyPO(datename.getText(),Double.parseDouble(datecount.getText()),GetBeginDate(beginyear.getText(),beginmonth.getText(),beginday.getText()),GetEndDate(endyear.getText(),endmonth.getText(),endday.getText()));
        if(rm==ResultMessage.Success){
            result.setText("新增特殊时段优惠策略成功");
        }else{
            result.setText("新增失败");
        }
    }
    
    public Date GetBeginDate(String y,String m,String d) throws IOException{
        Date date=new Date(Integer.parseInt(y),Integer.parseInt(m),Integer.parseInt(d));
        return date;
    }
        
    public Date GetEndDate(String y,String m,String d) throws IOException{
        Date date=new Date(Integer.parseInt(y),Integer.parseInt(m),Integer.parseInt(d));
        return date;
    }
}
