package UI.Admintor;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Controller {
	@FXML
	Button  ��վӪ��,�û�,�Ƶ�,ȡ��;
	@FXML
	StackPane y;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  click�û�() throws IOException {
		y.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource("������Ա-�����û�.fxml"));
                y.getChildren().add(add );
	}
	
	public void click��վӪ��() throws IOException{
		y.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("������Ա-����Ӫ����Ա.fxml"));
                y.getChildren().add(add);
	}
        
        public void click�Ƶ�() throws IOException{
                y.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("������Ա-����Ƶ�.fxml"));
                y.getChildren().add(add);
             
        }
}
