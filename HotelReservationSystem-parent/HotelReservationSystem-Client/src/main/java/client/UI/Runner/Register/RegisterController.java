package UI.Runner.Register;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterController {

    public RegisterController() throws IOException {
        
    }
    

    @FXML
    private Button personButton;
    @FXML
    private Button corporateButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;
    @FXML
    private Pane repPane;
    @FXML
    private AnchorPane base;
    @FXML
    private TextField accountField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField monthField;
    @FXML
    private TextField dayField;

    @FXML
    private void personButtonHandler  ()throws  IOException{
        System.out.println("个人会员");
        repPane.getChildren().clear();
        repPane.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Register/Person.fxml")).toURL()));
    }

    @FXML
    private void corporateButtonHandler(ActionEvent event)throws IOException{
        System.out.println("企业会员");
        repPane.getChildren().clear();
        repPane.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Register/Company.fxml")).toURL()));
        //替换panel
        
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event)throws  IOException{
                base.getChildren().clear(  );
                base.getChildren().add(FXMLLoader.load((new File("src/UI/Runner/Runner.fxml")).toURL()));
                System.out.println("取消");
    }

    @FXML
    private void okButton(ActionEvent event) {
        
        System.out.println("确认");
    }

}
