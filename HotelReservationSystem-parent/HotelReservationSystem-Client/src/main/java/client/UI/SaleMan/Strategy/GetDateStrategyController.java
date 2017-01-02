/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.vo.StrategyVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class GetDateStrategyController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField gdname;
    @FXML
    private TextField gbeginyear;
    @FXML
    private TextField gbeginmonth;
    @FXML
    private TextField gbeginday;
    @FXML
    private TextField gdiscount;
    @FXML
    private TextField gendyear;
    @FXML
    private TextField gendmonth;
    @FXML
    private TextField gendday;
    
    public void show(String name)throws Exception{
               
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(name);
                gdname.setText(vo.getName());
                String bd=""+vo.getStartDate();
                String ed=""+vo.getEndDate();
                String listb[]=bd.split("-");
                String liste[]=ed.split("-");
                gdiscount.setText(""+vo.getCount());
                gbeginyear.setText(""+(Integer.parseInt(listb[0])-1900));
                gbeginmonth.setText(""+(Integer.parseInt(listb[1])-1));
                gbeginday.setText(listb[2]);
                gendyear.setText(""+(Integer.parseInt(liste[0])-1900));
                gendmonth.setText(""+(Integer.parseInt(liste[1])-1));
                gendday.setText(liste[2]);
    }
}
