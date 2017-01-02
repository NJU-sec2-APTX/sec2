/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class ChangeStrategyController {
    AnchorPane all;
    @FXML
    AnchorPane add;
    @FXML
    ChoiceBox<String> type;
    @FXML
    private AnchorPane change;
    @FXML
    private Button ChangeStrategyR;
    @FXML
    private TextField Cname;
    @FXML
    public void initialize(){
        type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
    }
    @FXML
    public void clickChangeStrategyR() throws IOException{
        
        if(null != type.getValue())switch (type.getValue()) {
            case "会员等级制度":
                FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeLevelStrategy.fxml").toURL()));
                all=fXMLLoader.load();
                ChangeLevelStrategyController sc=fXMLLoader.getController();
                sc.show(Cname.getText());
                break;
            case "特殊时段优惠策略":
                FXMLLoader fXMLLoader2 =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeDateStrategy.fxml").toURL()));
                all=fXMLLoader2.load();
                ChangeDateStrategyController sc2=fXMLLoader2.getController();
                sc2.show(Cname.getText());
                break;
            case "VIP商圈优惠策略":
                FXMLLoader fXMLLoader3=new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeVipandAreaStrategy.fxml").toURL()));
                all=fXMLLoader3.load();
                ChangeDateStrategyController sc3=fXMLLoader3.getController();
                sc3.show(Cname.getText());             
                break;               
            default:            
                break;
            }
        
        }
}
