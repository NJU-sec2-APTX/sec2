package client.UI.Manager.HotelManage;

import common.po.HotelPO;
import java.io.File;
import java.io.IOException;
import client.businessLogicService.HotelFactory;
import common.vo.HotelVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HotelManageController {
	@FXML
	Button AddHotel,ChangeHotel,GetHotel;
        Button AddHotelR,ChangeHotelR,GetHotelR,ChangeR;
        @FXML
        TextField name,star,address,id;
        @FXML
        TextField cname,cstar,caddress,cid,gname,gstar,gaddress,gid,garea;
        @FXML
        TextField Cname,Gname;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	ChoiceBox<String> area,carea;
	AnchorPane add;
        Label result;
    @FXML
	public void  AddHotel() throws IOException {
		AddHotelController ahc=new AddHotelController();
                ahc.initialize();
                ahc.AddHotel();
	}
        
        
        
               
    

        
     
        //修改酒店信息
        public void ChangeHotel() throws IOException{
                ChangeHotelController chc=new ChangeHotelController();
                chc.initialize();
                chc.ChangeHotel();   
        }
        
        //查看酒店
        public void GetHotel() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/GetHotel.fxml").toURL()));
                all.getChildren().add(add);
        }

        public void clickGetSaleR() throws IOException, Exception{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/ShowHotel.fxml").toURL()));
                all.getChildren().add(add);
                HotelVO vo=HotelFactory.getHotelMaintainService().getHotelInfo(Gname.getText());                
                    gname.setText(vo.name);
                    gid.setText(vo.id);
                    gaddress.setText(vo.address);
                    garea.setText(vo.area);
                    gstar.setText(""+vo.star);
                
        }
}