package client.UI.SaleMan;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class SaleFrameController {
	@FXML
	Button  Strategy,Order,Charge;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
	public void  clickStrategy() throws IOException {
		change.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/Strategy.fxml")).toURL());
                change.getChildren().add(add );
	}
	
    @FXML
	public void clickOrder() throws IOException{
		change.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Order/Order.fxml")).toURL());
                change.getChildren().add(add);
	}
        
    @FXML
        public void clickCharge() throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Charge/Charge.fxml")).toURL());
                change.getChildren().add(add);
             
        }
}
