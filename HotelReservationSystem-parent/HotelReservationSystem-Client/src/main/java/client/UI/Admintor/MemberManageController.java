package UI.Admintor;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MemberManageController {
	@FXML
	Button  ����û�,ɾ���û�,�޸��û���Ϣ,�鿴�û�;
	@FXML
	StackPane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  click����û�() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add );
	}
	
	public void clickɾ���û�() throws IOException{
		all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
	}
        
        public void click�޸��û���Ϣ() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
          
        public void click�鿴�û�() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
}
