package UI.Sales;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ControllerWeb {
	@FXML
	Button  Ӫ������,����,���ó�ֵ;
	@FXML
	StackPane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  clickӪ������() throws IOException {
		change.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource("��վӪ����Ա-����.fxml"));
                change.getChildren().add(add );
	}
	
	public void click����() throws IOException{
		change.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("��վӪ����Ա-����.fxml"));
                change.getChildren().add(add);
	}
        
        public void click���ó�ֵ() throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("��վӪ����Ա-���ó�ֵ.fxml"));
                change.getChildren().add(add);
             
        }
}
