package client.UI.SaleMan.Charge;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ChargeController {
	Button  Charge;
	@FXML
	Pane change;
	AnchorPane all;
	
        @FXML
	AnchorPane add;
	public void  Charge() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add );
	}
}
