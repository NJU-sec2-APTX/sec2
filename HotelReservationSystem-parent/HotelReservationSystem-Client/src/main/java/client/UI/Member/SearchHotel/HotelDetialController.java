/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.OrderState;
import common.vo.HotelVO;
import common.vo.OrderVO;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class HotelDetialController {

    @FXML
    private Label hotelNameLabel;
    @FXML
    private TextArea showArea;
    @FXML
    private Button bookButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label starLabel;
    @FXML
    private Label tipLabel;
    @FXML
    private Label markField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label areaLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label tipLabel1;
    @FXML
    private Label singleLabel;
    @FXML
    private Label douLabel;
    @FXML
    private Label famLabel;
    @FXML
    private Label IDLabel;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label makeTimeLabel;
    @FXML
    private Label executeTimeLabel;
    @FXML
    private Label statueLabel;
    @FXML
    private AnchorPane basePanel;
    @FXML
    private ScrollPane orderPanel;
    HotelVO hotelVO;

    @FXML
    private void cancelButtonHandler(ActionEvent event)throws Exception {
        basePanel.getChildren().clear();    
        basePanel.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/SearchHotel/SearchHotel.fxml")).toURL()));
    }

    @FXML
    private void bookButtonHandler(ActionEvent event)throws Exception {
        FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/SearchHotel/MakeOrder.fxml").toURL()));
        AnchorPane addAnchorPane=fxmll.load();
        MakeOrderController moc=fxmll.getController();
        moc.show(hotelVO);
        basePanel.getChildren().clear();
        basePanel.getChildren().add (addAnchorPane);
    }
    private void add(HotelVO hotelVO)throws Exception{//添加历史订单
        ArrayList<OrderVO> orderVOs=OrderFactory.getOrderService().searchOrderListFromData(Start.person,null, hotelVO);
        if (orderVOs.size()==0) {
                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/SearchHotel/ReveredOrder.fxml").toURL()));
                AnchorPane addAnchorPane=fxmll.load();
                ReveredOrderController sc=fxmll.getController();
                sc.show(null);
        }else{
            for(int i=0;i<orderVOs.size();i++){
                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/SearchHotel/ReveredOrder.fxml").toURL()));
                AnchorPane addAnchorPane=fxmll.load();
                ReveredOrderController sc=fxmll.getController();
                sc.show(orderVOs.get(i));
            }
        }
       
        
    }
    void show(HotelVO h) throws Exception{//初始化载入
       hotelVO=h;
       hotelNameLabel.setText(hotelVO.name);
       showArea.setText(hotelVO.introduction);
       showArea.setEditable(false);
       nameLabel.setText(hotelVO.name);
       markField.setText(hotelVO.mark+"");
       starLabel.setText(hotelVO.star+"");
       singleLabel.setText(hotelVO.rooms.get(0).restNum+"");
       douLabel.setText(hotelVO.rooms.get(1).restNum+"");
       famLabel.setText(hotelVO.rooms.get(2).restNum+"");
       areaLabel.setText(hotelVO.area);
       addressLabel.setText(hotelVO.address);
       add(hotelVO);
    }
    
}
