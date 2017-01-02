package client.UI.Manager.HotelManage;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HotelManageController {
	
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
      
	public void  AddHotel() throws IOException {
                all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/AddHotel.fxml")).toURL());
                all.getChildren().add(add );
        }               
        //修改酒店信息
        public void ChangeHotel() throws IOException{
            all.getChildren().clear();
            add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/ChangeHotel.fxml")).toURL());
            all.getChildren().add(add );
        }
        
        //查看酒店
        public void GetHotel() throws IOException{
            all.getChildren().clear();
            add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/GetHotel.fxml").toURL()));
            all.getChildren().add(add );
        }
}