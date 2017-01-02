/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.HotelManage;

import client.businessLogicService.HotelFactory;
import common.po.HotelPO;
import common.vo.HotelVO;
import java.io.IOException;
import javafx.fxml.FXML;
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
public class AddHotelController {

    @FXML
    private AnchorPane all,add;
    @FXML
    private Pane change;
    @FXML
    private TextField name;
    @FXML
    private TextField star;
    @FXML
    private TextField address;
    @FXML
    private TextField id;
    @FXML
    private ChoiceBox<String> area;
    @FXML
    private Button AddHotelR;
    @FXML
    private Button back;
    @FXML
    private Label result;

    @FXML
    public void initialize(){
        area.getItems().addAll("鼓楼","建邺","栖霞","玄武","浦口");
    }
    public void clickAddHotelR() throws IOException{
        HotelPO po=new HotelPO();
        po.setAddress(address.getText());
        po.setArea(area.getValue());
        po.setName(name.getText());
        po.setStar(Integer.parseInt(star.getText()));
        HotelVO vo=new HotelVO(po);
        boolean b=HotelFactory.getHotelMaintainService().addHotel(vo);
        if(b){
            result.setText("新增酒店成功");
        }else{
            result.setText("新增失败");
        }
    }
    
}
