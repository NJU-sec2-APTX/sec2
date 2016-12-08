package UI.Runner;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class RunnerController {
    @FXML
    Button loginButton;
    @FXML
    Button registerButton;
    AnchorPane addPane;
    public  AnchorPane base;
    
    @FXML
	public void loginButtonHandler() throws IOException{
		System.out.println("��¼");
		base.getChildren().clear();
		base.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Login/Login.fxml")).toURL()));
		System.out.println("�����¼����");
	}
    @FXML
	public void  registerButtonHandler()throws  IOException{
		System.out.println("ע��");
                base.getChildren().clear();
                File f=new File("src/UI/Runner/Register/Register.fxml");
                System.out.println(f.exists());
                base.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Register/Register.fxml")).toURL()));
                System.out.println("����ע�����");
                
	}
}
