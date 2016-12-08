package UI.Sales;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ChargeController {
	@FXML
	Button  ≥‰÷µ;
	@FXML
	StackPane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
	public void  click≥‰÷µ() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add );
	}
}
