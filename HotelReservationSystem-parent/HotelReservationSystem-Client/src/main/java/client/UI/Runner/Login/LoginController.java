package client.UI.Runner.Login;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
//完成
public class LoginController {
	@FXML 
	javafx.scene.control.TextField accountField;
	@FXML
	PasswordField passwordField;
	@FXML
	Button okButton,cancelButton;
        @FXML
        AnchorPane loginBase;
        
    @FXML
    private Label tipLabel;
    @FXML
    private ChoiceBox<String> userBox;
    
        UserRole checkRole(){
            if (userBox.getValue()!=null){
                switch (userBox.getValue()) {
                    case "个人会员":
                        return UserRole.Member;
                    case "企业会员":
                        return UserRole.Enterprise;
                    case"酒店管理人员":
                        return  UserRole.HotelWorker;
                    case"网站营销人员":
                        return UserRole.Enterprise.Sales;
                    case"网站管理人员":
                        return UserRole.Enterprise.Manager;
                    default:
                        throw new AssertionError();
                }
            }else{
                tipLabel.setText("请选择用户类型");
                return null;
            }
            
        }
        
    @FXML
    public void initialize(){
        userBox.getItems().addAll("个人会员","企业会员","酒店管理人员","网站营销人员","网站管理人员");
    }
        @FXML
	void okButtonHandler(){
                System.out.println("okButton");
                String account=accountField.getText();
		String password=passwordField.getText();
                UserRole userRole=checkRole();
                System.out.println(userRole.toString());
                ResultMessage result=User_Factory.getUserService().login(account, userRole, password);
               try {
                   switch (result){
                       case Success:
                            switch(userRole){
                                case Enterprise:
                                loginBase.getChildren( ).clear();
                                System.out.println("Enterprise");
                                loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberUI.fxml")).toURL()));
                                break;
                            case Member:
                                loginBase.getChildren().clear();
                                loginBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/MemberUI.fxml")).toURL()));
                                break;
                            case HotelWorker:
                                loginBase.getChildren().clear();
                                System.out.println("HotelWorker");
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
                           break;
                       case Failure:
                           tipLabel.setText("密码错误");
                           break;
                       case  Logged:
                           tipLabel.setText("该账号已被注册");
                           break;
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
}
