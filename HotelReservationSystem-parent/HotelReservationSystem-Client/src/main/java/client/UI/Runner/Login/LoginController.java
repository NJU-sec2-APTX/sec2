package UI.Runner.Login;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tool.ResultMessage;
import tool.UserRole;

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
        
        
        @FXML
	void okButtonHandler(){
                UserRole userRole=UserRole.Member;
		System.out.println("ȷ��");
		String account=accountField.getText();
		String password=passwordField.getText();
               try {
                   if(ResultMessage.Success==ResultMessage.Success){
                        switch(userRole){
                        case Member:
                            loginBase.getChildren().clear();
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/UI/Member/MemberUI.fxml")).toURL()));
                           break;
                        case HotelWorker:
                            loginBase.getChildren().clear();
                            System.out.println("HotelWork");
                            loginBase.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/HotelUI.fxml")).toURL()));
                            break;
                        case Sales:
                            loginBase.getChildren().clear();
                            System.out.println("Sales");
                            //loginBase.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/HotelUI.fxml")).toURL()));
                            break;
                        case Manager:
                            loginBase.getChildren().clear();
                            System.out.println("Manager");
                            //loginBase.getChildren().add(FXMLLoader.load((new File("src/UI/Hotel/HotelUI.fxml")).toURL()));
                            break;
                    }
                    System.out.println("��¼�ɹ�");
                    }
                /*else{
			
		}*/
               } catch (Exception e) { 
                   //System.out.println(userRole);
                   e.printStackTrace();
                  
            }
	}
        @FXML
	void cancelButtonHandler()throws IOException{
		//���ؿ�������
                loginBase.getChildren().clear(  );
                loginBase.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Runner.fxml")).toURL()));
                System.out.println("ȡ��");
                
	}

    @FXML
    private void chooseButtonHandler(ActionEvent event) {
        RadioButton[] arr={ memberRadButton,ManagerRadButton,salesRadButton,adRadButton};
        RadioButton getButton=(RadioButton)event.getSource();
        switch(getButton.getText()){
            case "��Ա":
                System.out.println("ѡ��ͻ�");
                break;
            case"�Ƶ������Ա":
                break;
            case"��վӪ����Ա":
                break;
            case"��վ������Ա":
                break;
            default:
                    System.out.println("����ȷѡ��");
        }
         for (int i = 0; i < 4; i++) {
             if (arr[i]!=getButton&&arr[i].isSelected()) {
                arr[i].fire();
                System.out.println(arr[i].getText());
             }
        }
        
    }
}
