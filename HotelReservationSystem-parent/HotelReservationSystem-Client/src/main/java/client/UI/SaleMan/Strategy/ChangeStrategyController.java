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
  AnchorPane add;
    @FXML
    ChoiceBox<String> type;
    @FXML
    private Button ChangeStrategyR;
    @FXML
    private TextField Cname;
    @FXML
    private AnchorPane all;
    public void initialize(){
        type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
    }
    @FXML
    public void clickChangeStrategyR() throws IOException{
        
        if(null != type.getValue())switch (type.getValue()) {
            case "会员等级制度":
                FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeLevelStrategy.fxml").toURL()));
                add=fXMLLoader.load();
                all.getChildren().clear();
                all.getChildren().add(add);
                ChangeLevelStrategyController sc=fXMLLoader.getController();
                sc.show(Cname.getText());
                break;
            case "特殊时段优惠策略":
                FXMLLoader fXMLLoader2 =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeDateStrategy.fxml").toURL()));
                add=fXMLLoader2.load();
                all.getChildren().clear();
                all.getChildren().add(add);
                ChangeDateStrategyController sc2=fXMLLoader2.getController();
                sc2.show(Cname.getText());
                break;
            case "VIP商圈优惠策略":
                FXMLLoader fXMLLoader3=new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeVipandAreaStrategy.fxml").toURL()));
                add=fXMLLoader3.load();
                all.getChildren().clear();
                all.getChildren().add(add);
                ChangeDateStrategyController sc3=fXMLLoader3.getController();
                sc3.show(Cname.getText());             
                break;               
            default:            
                break;
            }
        
        }
}
