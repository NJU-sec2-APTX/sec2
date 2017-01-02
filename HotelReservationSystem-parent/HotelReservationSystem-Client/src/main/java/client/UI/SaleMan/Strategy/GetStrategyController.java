/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
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
public class GetStrategyController {
    @FXML
    private AnchorPane all,add;
    @FXML
    private Button GetStrategyR;
    @FXML
    private TextField Gname;
    @FXML
    private ChoiceBox<String> Gtype;
    @FXML
    public void initialize(){
        Gtype.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
    }
    @FXML
    public void clickGetStrategyR() throws Exception{
        String Type=Gtype.getValue();
        
        if(null != Type)switch (Type) {
            case "会员等级制度":
                FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/GetLevelStrategy.fxml").toURL()));
                all=fXMLLoader.load();
                GetLevelStrategyController sc=fXMLLoader.getController();
                sc.show(Gname.getText());
                break;
            case "特殊时段优惠策略":
                FXMLLoader fXMLLoader1 =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/GetDateStrategy.fxml").toURL()));
                all=fXMLLoader1.load();
                GetDateStrategyController sc1=fXMLLoader1.getController();
                sc1.show(Gname.getText());
                break;
            case "VIP商圈优惠策略":
                
                FXMLLoader fXMLLoader2 =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/GetVipandAreaStrategy.fxml").toURL()));
                all=fXMLLoader2.load();
                GetVipandAreaStrategyController sc2=fXMLLoader2.getController();
                sc2.show(Gname.getText());
                break;
            default:
                break;
            }
        }
}
