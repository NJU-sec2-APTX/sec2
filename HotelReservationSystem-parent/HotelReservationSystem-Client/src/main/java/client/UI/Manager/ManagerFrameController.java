package UI.Manager;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ManagerFrameController {

    Button ��վӪ��;
	@FXML
	Button  �û�,�Ƶ�,ȡ��;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
    private Button ���߾Ƶ�;
    @FXML
    private Button ɾ���Ƶ�;
    @FXML
    private Button �޸ľƵ���Ϣ;
    @FXML
    private Button �鿴�Ƶ�;
    @FXML
	public void  click�û�() throws IOException {
		change.getChildren().clear();
		add=FXMLLoader.load((new File("src/UI/Manager/MemberManage/MemberManage.fxml")).toURL());
                change.getChildren().add(add );
	}
	
    @FXML
	public void click��վӪ��() throws IOException{
		change.getChildren().clear();
                add=FXMLLoader.load((new File("src/UI/Manager/SaleManage/SaleManage.fxml")).toURL());
                change.getChildren().add(add);
	}
        
    @FXML
        public void click�Ƶ�() throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load((new File("src/UI/Manager/HotelManage/HotelManage.fxml")).toURL());
                change.getChildren().add(add);
             
        }

    @FXML
    private void click���߾Ƶ�(ActionEvent event) {
    }

    @FXML
    private void clickɾ���Ƶ�(ActionEvent event) {
    }

    @FXML
    private void clickɾ���Ƶ���Ϣ(ActionEvent event) {
    }

    @FXML
    private void click�鿴�Ƶ�(ActionEvent event) {
    }
}
