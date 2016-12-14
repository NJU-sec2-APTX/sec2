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

    Button 网站营销;
	@FXML
	Button  用户,酒店,取消;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
    private Button 上线酒店;
    @FXML
    private Button 删除酒店;
    @FXML
    private Button 修改酒店信息;
    @FXML
    private Button 查看酒店;
    @FXML
	public void  click用户() throws IOException {
		change.getChildren().clear();
		add=FXMLLoader.load((new File("src/UI/Manager/MemberManage/MemberManage.fxml")).toURL());
                change.getChildren().add(add );
	}
	
    @FXML
	public void click网站营销() throws IOException{
		change.getChildren().clear();
                add=FXMLLoader.load((new File("src/UI/Manager/SaleManage/SaleManage.fxml")).toURL());
                change.getChildren().add(add);
	}
        
    @FXML
        public void click酒店() throws IOException{
                change.getChildren().clear();
                add=FXMLLoader.load((new File("src/UI/Manager/HotelManage/HotelManage.fxml")).toURL());
                change.getChildren().add(add);
             
        }

    @FXML
    private void click上线酒店(ActionEvent event) {
    }

    @FXML
    private void click删除酒店(ActionEvent event) {
    }

    @FXML
    private void click删除酒店信息(ActionEvent event) {
    }

    @FXML
    private void click查看酒店(ActionEvent event) {
    }
}
