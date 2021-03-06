/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.OrderInHotel;

import client.UI.Hotel.ExecuteOrder.ExecuteSingleController;
import client.UI.Runner.Start;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.Person;
import common.vo.OrderVO;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import oracle.jrockit.jfr.parser.ChunkParser;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class OrderInHotelController  {

    @FXML
    private ScrollPane showPane;
    @FXML
    public  void initialize ()throws Exception{
        Person p=Start.person;
        ArrayList<OrderVO> orderList=OrderFactory.getOrderService().searchOrderListFromData(p, null, null);
        VBox box=new VBox();
        if(orderList.isEmpty()){
             FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Hotel/OrderInHotel/SingleOrder.fxml").toURL()));
            AnchorPane addAnchorPane=fxmll.load();
            SingleOrderController soc=fxmll.getController();
            soc.show();
            box.getChildren().add(addAnchorPane);
        }else{
            for(int i=0;i<orderList.size();i++){
                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Hotel/OrderInHotel/SingleOrder.fxml").toURL()));
                AnchorPane addAnchorPane=fxmll.load();
                SingleOrderController soc=fxmll.getController();
                soc.show(orderList.get(i));
                box.getChildren().add(addAnchorPane);
            }
        }
         showPane.setContent(box);
    }
    
}
