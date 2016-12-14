package UI.Manager.MemberManage;

import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MemberManageController {
	@FXML
	Button  添加用户,删除用户,修改用户信息,查看用户;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
	public void  click添加用户() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add );
	}
	
    @FXML
	public void click删除用户() throws IOException{
		all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
	}
        
        public void click修改用户信息() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }
          
        public void click查看用户() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load(getClass().getResource(".fxml"));
                all.getChildren().add(add);
        }

    @FXML
    private void click删除用户信息(ActionEvent event) {
    }
}
