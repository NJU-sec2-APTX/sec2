package UI.Admintor;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Controller {
	@FXML
	Button  网站营销,用户,酒店,取消;
	@FXML
	StackPane y;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  click用户() throws IOException {
		y.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource("管理人员-管理用户.fxml"));
                y.getChildren().add(add );
	}
	
	public void click网站营销() throws IOException{
		y.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("管理人员-管理营销人员.fxml"));
                y.getChildren().add(add);
	}
        
        public void click酒店() throws IOException{
                y.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("管理人员-管理酒店.fxml"));
                y.getChildren().add(add);
             
        }
}
