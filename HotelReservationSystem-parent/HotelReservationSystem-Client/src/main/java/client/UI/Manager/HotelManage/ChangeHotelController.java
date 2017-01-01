/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.HotelManage;

import client.businessLogicService.HotelFactory;
import common.vo.HotelVO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
public class ChangeHotelController {


    @FXML
    private AnchorPane all,add;
    private TextField Cname;
    @FXML
    private Pane change;
    @FXML
    private TextField cname;
    @FXML
    private TextField cstar;
    @FXML
    private TextField caddress;
    @FXML
    private TextField cid;
    @FXML
    private ChoiceBox<String> carea;
    @FXML
    private Button AddHotelR;
    @FXML
    private Label result;
    @FXML
    public void initialize(){
        carea.getItems().addAll("鼓楼","建邺","浦口","栖霞","玄武");
    }
    public void ChangeHotel() throws MalformedURLException, IOException{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/ChangeHotel.fxml").toURL()));
        all.getChildren().add(add);
    }
    public void clickChangeHotelR() throws IOException, Exception{
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/Change.fxml").toURL()));
        all.getChildren().add(add);
        HotelVO vo=HotelFactory.getHotelMaintainService().getHotelInfo(Cname.getText());
        carea.setAccessibleText(vo.area);
        cname.setText(vo.name);
        cid.setText(vo.id);
        caddress.setText(vo.address);
        cstar.setText(""+vo.star);
        }
    public void clickChangeR() throws IOException, Exception{
        HotelVO vo=new HotelVO();
        vo.name=cname.getText();
        vo.star=Integer.parseInt(cstar.getText());
        vo.address=caddress.getText();
        vo.area=carea.getValue();
        vo.id=cid.getText();
        boolean b=HotelFactory.getHotelMaintainService().setHotelInfo(vo);
        if(b){
            result.setText("修改成功");
        }else{
            result.setText("修改失败");
        }
    }
}
