package UI.SaleMan.Order;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class OrderController {
	@FXML
	Button  �޸�,�鿴;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	
    @FXML
        public void click�޸�() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
          
    @FXML
        public void click�鿴() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
}
