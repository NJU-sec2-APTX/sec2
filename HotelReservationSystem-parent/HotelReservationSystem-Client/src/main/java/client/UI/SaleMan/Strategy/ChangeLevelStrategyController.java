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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class ChangeLevelStrategyController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField ccredit4;
    @FXML
    private TextField ccredit5;
    @FXML
    private TextField ccredit1;
    @FXML
    private TextField ccredit2;
    @FXML
    private TextField ccredit3;
    @FXML
    private TextField clname;
    @FXML
    private Button ChangeLevelStrategyR;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        
    }
    public void show(String name) throws MalformedURLException, IOException{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeLevelStrategy.fxml").toURL()));
        all.getChildren().add(add);
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(name);
        clname.setText(vo.getName());
        String list[]=vo.getEnterprise().split("/");
        ccredit1.setText(list[0]);
        ccredit2.setText(list[1]);
        ccredit3.setText(list[2]);
        ccredit4.setText(list[3]);
        ccredit5.setText(list[4]);
    }
    private void clickChangeLevelStrategyR(ActionEvent event) throws MalformedURLException, IOException {
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(clname.getText());
        StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),GetCredit(ccredit1.getText(),ccredit2.getText(),ccredit3.getText(),ccredit4.getText(),ccredit5.getText()),vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),vo.getArea(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
        StrategyVO VO=new StrategyVO(po);
        ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO);
        if(rm==ResultMessage.Success){
            result.setText("修改会员等级制度成功");
        }else{
            result.setText("修改失败");
        }
    }
    public String GetCredit(String c1,String c2,String c3,String c4,String c5) throws IOException{
        return c1+"/"+c2+"/"+c3+"/"+c4+"/"+c5;
    }
}
