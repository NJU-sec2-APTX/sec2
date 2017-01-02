/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import common.vo.StrategyVO;
import java.rmi.RemoteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @aut
 */
public class DeleteStrategyController {

    @FXML
    private AnchorPane all;
    @FXML
    private Button DeleteStrategyR;
    @FXML
    private TextField dname;
    @FXML
    private Label result;

    @FXML
    private void clickDeleteStrategyR() throws RemoteException {
        StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(dname.getText());         
        ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).removeStrategy(vo);
        if(rm==ResultMessage.Success){
            result.setText("删除成功");
        }else{
            result.setText("删除失败");
        }
    }
    
}
