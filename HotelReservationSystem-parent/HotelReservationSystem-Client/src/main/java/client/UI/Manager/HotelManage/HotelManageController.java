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
	Button  上线酒店,删除酒店,修改酒店信息,查看酒店;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
	public void  click上线酒店() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
	}
	
    @FXML
	public void click删除酒店() throws IOException{
		all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
	}
        
        public void click修改酒店信息() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
        }
          
    @FXML
        public void click查看酒店() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("").toURL()));
                all.getChildren().add(add );
        }

    @FXML
    private void click删除酒店信息(ActionEvent event) {
    }
}
