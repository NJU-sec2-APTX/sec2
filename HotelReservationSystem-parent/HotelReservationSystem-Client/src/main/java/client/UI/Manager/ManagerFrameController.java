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
import client.UI.Manager.HotelManage.HotelManageController;

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
    private AnchorPane rep;

    @FXML
    private void clickExitButton(ActionEvent event) throws  Exception{
        System.out.println("exitButton");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml").toURL())));
        System.out.print("退出"+person.id);
        if (null!=person.role)
         User_Factory.getUserService().logout(person.id,person.role);
    }

    @FXML
    private void clickHotelButton(ActionEvent event)  throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/HotelManage.fxml")).toURL());
                all.getChildren().add(add);
    }

    @FXML
    private void clickSaleButton(ActionEvent event) throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/SaleManage.fxml")).toURL());
                all.getChildren().add(add);
    }

    @FXML
    private void clickMemberButton(ActionEvent event)throws IOException {
                all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/MemberManage.fxml")).toURL());
                all.getChildren().add(add );
    }

    @FXML
    private void clickAddButton(ActionEvent event) throws IOException {
        all.getChildren().clear();
	add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/AddHotel.fxml")).toURL());
        all.getChildren().add(add );
    }


    @FXML
    private void clickModifyButton(ActionEvent event) throws IOException {
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/ChangeHotel.fxml")).toURL());
        all.getChildren().add(add );
    }

    @FXML
    private void clickGetHotelButton(ActionEvent event) throws IOException {
        all.getChildren().clear();
        add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/GetMember.fxml").toURL()));
        all.getChildren().add(add );
    }
    public void initialize(){
       
    }
}
