package client.UI.Manager.HotelManage;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HotelManageController {
	@FXML
	Button  AddHotel,DeleteHotel,ChangeHotel,GetHotel;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
	public void  AddHotel() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
	}
	
    @FXML
	public void DeleteHotel() throws IOException{
		all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
	}
        
        public void ChangeHotel() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
        }
          
    @FXML
        public void GetHotel() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
        }

  
}
