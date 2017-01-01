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
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 叶枫
 */
public class ChangeStrategyController {
    @FXML
    AnchorPane all,add;
    @FXML
    ChoiceBox<String> type;
    @FXML
    public void initialize(){
        type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
    }
    public void ChangeStrategy() throws IOException{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeStrategy.fxml").toURL()));
        all.getChildren().add(add);
        }
    public void clickChangeStrategyR() throws IOException{
        StrategyController sc=new StrategyController();
    if(null != type.getValue())switch (type.getValue()) {
            case "会员等级制度":
                sc.ChangeLevelStrategy();
                break;
            case "特殊时段优惠策略":
                sc.ChangeDateStrategy();
                break;
            case "VIP商圈优惠策略":
                sc.ChangeVipandAreaStrategy();                
                break;               
            default:            
                break;
            }
        
        }
}
