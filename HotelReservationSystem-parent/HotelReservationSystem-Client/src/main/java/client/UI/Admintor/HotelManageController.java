package UI.Admintor;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class HotelManageController {
	@FXML
	Button  ���߾Ƶ�,ɾ���Ƶ�,�޸ľƵ���Ϣ,�鿴�Ƶ�;
	@FXML
	StackPane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  click���߾Ƶ�() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add );
	}
	
	public void clickɾ���Ƶ�() throws IOException{
		all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
	}
        
        public void click�޸ľƵ���Ϣ() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
          
        public void click�鿴�Ƶ�() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
}
