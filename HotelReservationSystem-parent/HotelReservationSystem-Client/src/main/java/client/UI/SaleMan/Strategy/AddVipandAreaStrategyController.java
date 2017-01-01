/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
public class AddVipandAreaStrategyController {
    @FXML
    ChoiceBox<String> area;
    @FXML
    AnchorPane all;
    AnchorPane add;
    @FXML
    Label result;
    @FXML
    private Pane change;
    @FXML
    private TextField vname;
    @FXML
    private TextField count1;
    @FXML
    private TextField count2;
    @FXML
    private TextField count3;
    @FXML
    private TextField count5;
    @FXML
    private TextField count4;
    @FXML
    private Button AddVipandAreaStrategyR;
    @FXML
    public void initialize(){
        area.getItems().addAll("鼓楼","栖霞","建邺","玄武","浦口");
    }
    public void Add() throws MalformedURLException, IOException{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/AddVipandAreaStrategy.fxml").toURL()));
        all.getChildren().add(add );      
    }
    @FXML
    public void clickAddVipandAreaStrategyR() throws IOException{
                StrategyController sc=new StrategyController();
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addVipandAreaStrategyPO( vname.getText(), sc.GetCount(count1.getText(),count2.getText(),count3.getText(),count4.getText(),count5.getText()), area.getValue());
                if(rm==ResultMessage.Success){
                    result.setText("新增VIP商圈优惠策略成功");
                }else{
                    result.setText("新增失败");
                }
        }
}
