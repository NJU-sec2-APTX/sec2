/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.HotelManage;

import client.businessLogicService.HotelFactory;
import common.vo.HotelVO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 叶枫
 */
public class ShowHotelController {

    @FXML
    private AnchorPane all;
    @FXML
    private Pane change;
    @FXML
    private TextField gname;
    @FXML
    private TextField gstar;
    @FXML
    private TextField gaddress;
    @FXML
    private TextField garea;
    @FXML
    private TextField gid;
    public void initialize(){
        
    }
    public void show(String name){
        HotelVO vo=HotelFactory.getHotelMaintainService().getHotelInfo(name);                
        gname.setText(vo.name);
        gid.setText(vo.id);
        gaddress.setText(vo.address);
        garea.setText(vo.area);
        gstar.setText(""+vo.star);
    }
}
