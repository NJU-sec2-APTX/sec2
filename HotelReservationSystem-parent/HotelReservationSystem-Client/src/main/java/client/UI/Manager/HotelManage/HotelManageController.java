package UI.Manager.HotelManage;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class HotelManageController {
	@FXML
	Button  ���߾Ƶ�,ɾ���Ƶ�,�޸ľƵ���Ϣ,�鿴�Ƶ�;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
	public void  click���߾Ƶ�() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
	}
	
    @FXML
	public void clickɾ���Ƶ�() throws IOException{
		all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
	}
        
        public void click�޸ľƵ���Ϣ() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
        }
          
    @FXML
        public void click�鿴�Ƶ�() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
        }

    @FXML
    private void clickɾ���Ƶ���Ϣ(ActionEvent event) {
    }
}
