/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.SaleManage;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.UserRole;
import common.vo.UserVO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class ShowSaleController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField gname;
    @FXML
    private TextField grole;
    @FXML
    private TextField gcontact;
    @FXML
    private TextField gid;
    public void initialize(){
        
    }
    public void show(String id,UserRole ur) throws Exception{
        UserVO vo=User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(id,ur);
        gname.setText(vo.getName());
        gid.setText(vo.getId());
        grole.setText(vo.getUserRole().toString());
        gcontact.setText(vo.getContact());
    }
}
