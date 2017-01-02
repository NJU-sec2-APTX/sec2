package client.UI.Manager.HotelManage;

import common.po.HotelPO;
import java.io.File;
import java.io.IOException;
import client.businessLogicService.HotelFactory;
import common.otherEnumClasses.UserRole;
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
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
      
	public void  AddHotel() throws IOException {
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/HotelManage/AddHotel.fxml").toURL()));
            all=fXMLLoader.load();           
            AddHotelController ahc=fXMLLoader.getController();
            ahc.initialize();
        }               
        //修改酒店信息
        public void ChangeHotel() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/HotelManage/ChangeMember.fxml").toURL()));
            all=fXMLLoader.load();           
            ChangeHotelController chc=fXMLLoader.getController();
            chc.initialize();
            
        }
        
        //查看酒店
        public void GetHotel() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/HotelManage/GetMember.fxml").toURL()));
            all=fXMLLoader.load();           
            GetHotelController ghc=fXMLLoader.getController();
            ghc.initialize();
            
        }
}