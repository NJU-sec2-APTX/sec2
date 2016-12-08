package UI.Sales;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ControllerWeb {
	@FXML
	Button  营销策略,订单,信用充值;
	@FXML
	StackPane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  click营销策略() throws IOException {
		change.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource("网站营销人员-策略.fxml"));
                change.getChildren().add(add );
	}
	
	public void click订单() throws IOException{
		change.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("网站营销人员-订单.fxml"));
                change.getChildren().add(add);
	}
        
        public void click信用充值() throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource("网站营销人员-信用充值.fxml"));
                change.getChildren().add(add);
             
        }
}
