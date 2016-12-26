package client.UI.Manager;

import static client.UI.Runner.Start.person;
import client.businessLogicService.User_Factory;
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
    private void clickExitButton(ActionEvent event) throws  Exception{
        System.out.println("exitButton");
        all.getChildren().clear();
        all.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml").toURL())));
        System.out.print("退出"+person.id);
        if (null!=person.role)
         User_Factory.getUserService().logout(person.id,person.role);
         System.out.println("登出");
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
    @FXML
    public void initialize(){
       
    }
}
