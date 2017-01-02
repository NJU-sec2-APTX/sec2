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
import java.util.Date;
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
public class ChangeDateStrategyController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField cdname;
    @FXML
    private TextField cbeginyear;
    @FXML
    private TextField cbeginmonth;
    @FXML
    private TextField cbeginday;
    @FXML
    private TextField cendyear;
    @FXML
    private TextField cendmonth;
    @FXML
    private TextField cendday;
    @FXML
    private TextField cdiscount;
    @FXML
    private Button ChangeDateStrategyR;
    @FXML
    private Label result;

    String Name;
    public void show(String name) throws MalformedURLException, IOException{
        Name=name;
        
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(name);
        cdname.setText(vo.getName());
        String bd=""+vo.getStartDate();
        String ed=""+vo.getEndDate();
        String listb[]=bd.split("-");
        String liste[]=ed.split("-");
        cdiscount.setText(""+vo.getCount());
        cbeginyear.setText(""+(Integer.parseInt(listb[0])-1900));
        cbeginmonth.setText(""+(Integer.parseInt(listb[1])-1));
        cbeginday.setText(listb[2]);
        cendyear.setText(""+(Integer.parseInt(liste[0])-1900));
        cendmonth.setText(""+(Integer.parseInt(liste[1])-1));
        cendday.setText(liste[2]);
    }
    @FXML
    private void clickChangeDateStrategyR() throws RemoteException, IOException {
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(Name);
        StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),vo.getEnterprise(),vo.getRoomNumber(),GetBeginDate(cbeginyear.getText(),cbeginmonth.getText(),cbeginday.getText()),GetEndDate(cendyear.getText(),cendmonth.getText(),cendday.getText()),vo.getArea(),vo.getLevel(),Double.parseDouble(cdiscount.getText()),vo.getStrategyType());
        StrategyVO VO=new StrategyVO(po);
        ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO);
        if(rm==ResultMessage.Success){
            result.setText("修改特殊时段优惠策略成功");
        }else{
            result.setText("修改失败");
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
