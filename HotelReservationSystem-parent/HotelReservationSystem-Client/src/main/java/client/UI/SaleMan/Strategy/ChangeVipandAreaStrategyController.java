/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import common.po.StrategyPO;
import common.vo.StrategyVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javafx.event.ActionEvent;
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
public class ChangeVipandAreaStrategyController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField cname;
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
    private ChoiceBox<String> carea;
    @FXML
    private Button ChangeVipandAreaStrategyR;
    @FXML
    private Label result;
@FXML
    public void initialize(){
        carea.getItems().addAll("鼓楼","栖霞","建邺","浦口","玄武");
    }
    public void show(String name) throws MalformedURLException, IOException{
        
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeVipandAreaStrategy.fxml").toURL()));
        all.getChildren().add(add);
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(name);
        cname.setText(vo.getName());
        String list[]=vo.getEnterprise().split("/");
        count1.setText(list[0]);
        count2.setText(list[1]);
        count3.setText(list[2]);
        count4.setText(list[3]);
        count5.setText(list[4]);
    }
    @FXML
    private void clickChangeVipandAreaStrategyR(ActionEvent event) throws RemoteException, IOException {  
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(cname.getText());
        StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),GetCount(count1.getText(),count2.getText(),count3.getText(),count4.getText(),count5.getText()),vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),carea.getValue(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
        StrategyVO VO=new StrategyVO(po);
        ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).modifyStrategy(VO);
        if(rm==ResultMessage.Success){
            result.setText("修改VIP商圈优惠策略成功");
        }else{
            result.setText("修改失败");
        }
        
    }
    public String GetCount(String c1,String c2,String c3,String c4,String c5) throws IOException{
        return c1+"/"+c2+"/"+c3+"/"+c4+"/"+c5;
    }
}
