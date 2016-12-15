package client.UI.Manager;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ManagerFrameController {
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
    private Label accountLabel;
    @FXML
    private Button exitButton;
    @FXML
    private Button hotelButton;
    @FXML
    private Button saleButton;
    @FXML
    private Button memberButton;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button getHotelButton;

    @FXML
    private void clickExitButton(ActionEvent event) {
    }

    @FXML
    private void clickHotelButton(ActionEvent event)  throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/HotelManage.fxml")).toURL());
                change.getChildren().add(add);
    }

    @FXML
    private void clickSaleButton(ActionEvent event) throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/SaleManage.fxml")).toURL());
                change.getChildren().add(add);
    }

    @FXML
    private void clickMemberButton(ActionEvent event)throws IOException {
                change.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/MemberManage.fxml")).toURL());
                change.getChildren().add(add );
    }

    @FXML
    private void clickAddButton(ActionEvent event) {
    }

    @FXML
    private void clickDeleteButton(ActionEvent event) {
    }

    @FXML
    private void clickModifyButton(ActionEvent event) {
    }

    @FXML
    private void clickGetHotelButton(ActionEvent event) {
    }
}
