package UI.SaleMan;

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
	Button  营销策略,订单,信用充值;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
	public void  click营销策略() throws IOException {
		change.getChildren().clear();
		add=FXMLLoader.load((new File("src/UI/SaleMan/Strategy/Strategy.fxml")).toURL());
                change.getChildren().add(add );
	}
	
    @FXML
	public void click订单() throws IOException{
		change.getChildren().clear();
                add=FXMLLoader.load((new File("src/UI/SaleMan/Order/Order.fxml")).toURL());
                change.getChildren().add(add);
	}
        
    @FXML
        public void click信用充值() throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load((new File("src/UI/SaleMan/Charge/Charge.fxml")).toURL());
                change.getChildren().add(add);
             
        }
}
