package client.UI.Runner.Login;

import client.UI.Runner.Start;
import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.userbl.UserFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
    Stage pStage;
    @FXML
    private ToolBar selectBar;
    @FXML
    private RadioButton memberRadButton;
    @FXML
    private RadioButton ManagerRadButton;
    @FXML
    private RadioButton salesRadButton;
    @FXML
    private RadioButton adRadButton;
    
	@FXML 
	javafx.scene.control.TextField accountField;
	@FXML
	PasswordField passwordField;
	@FXML
	Button okButton,cancelButton;
        @FXML
        AnchorPane loginBase;
        AnchorPane addPane;
        UserIFactory uif=new UserFactory() ;
    @FXML
    private RadioButton enterpriseRadButton;
        UserRole checkRole(){
            if(memberRadButton.isSelected()){
                return  UserRole.Member;
            }else if(ManagerRadButton.isSelected()){
                return UserRole.Manager;
            }else if(salesRadButton.isSelected( )){
                return UserRole.Sales;
            }else if(adRadButton.isSelected()){
                return UserRole.Manager;
            }else if(enterpriseRadButton.isSelected()){
                return UserRole.Enterprise;
            }else{
                System.err.println("client.UI.Runner.Login.LoginController.checkRole()");
                return null;
            }
        }
        
        @FXML
	void okButtonHandler(){
                System.out.println("okButton");
                String account=accountField.getText();
		String password=passwordField.getText();
                UserRole userRole=checkRole();
                ResultMessage result=uif.login(account, userRole, password);
               try {
                   if(result==ResultMessage.Success){
                        Start.person.role=userRole;
                        Start.person.id=account;
                        switch(userRole){
                        case Enterprise:
                            loginBase.getChildren( ).clear();
                            System.out.println("Enterprise");
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/EnterpriseUI.fxml")).toURL()));
                            break;
                        case Member:
                            loginBase.getChildren().clear();
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberUI.fxml")).toURL()));
                           break;
                        case HotelWorker:
                            loginBase.getChildren().clear();
                            System.out.println("HotelWork");
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Hotel/HotelUI.fxml")).toURL()));
                            break;
                        case Sales:
                            loginBase.getChildren().clear();
                            System.out.println("Sales");
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/SaleFrame.fxml")).toURL()));
                            break;
                        case Manager:
                            loginBase.getChildren().clear();
                            System.out.println("Manager");
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Manager/ManagerFrame.fxml")).toURL()));
                            break;
                    }
                    }
               } catch (Exception e) { 
                   //System.out.println(userRole);
                   e.printStackTrace();
                  
            }
	}
        @FXML
	void cancelButtonHandler()throws IOException{
                loginBase.getChildren().clear(  );
                loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml")).toURL()));
                System.out.println("cancelButton");
	}

    private void chooseButtonHandler(ActionEvent event) {
        RadioButton[] arr={ memberRadButton,ManagerRadButton,salesRadButton,adRadButton};
        RadioButton getButton=(RadioButton)event.getSource();
         for (int i = 0; i < 4; i++) {
             if (arr[i]!=getButton&&arr[i].isSelected()) {
                arr[i].fire();
                System.out.println(arr[i].getText());
             }
        }
    }
}
