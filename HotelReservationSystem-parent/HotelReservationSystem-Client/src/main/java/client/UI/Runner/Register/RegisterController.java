package client.UI.Runner.Register;

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

    @FXML
    private Button personButton;
    @FXML
    private Button corporateButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Pane repPane;
    @FXML
    private AnchorPane base;

    @FXML
    private void personButtonHandler  ()throws  IOException{
        System.out.println("personButton");
        repPane.getChildren().clear();
        repPane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Register/Person.fxml")).toURL()));
    }

    @FXML
    private void corporateButtonHandler(ActionEvent event)throws IOException{
        System.out.println("corporate");
        repPane.getChildren().clear();
        repPane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Register/Company.fxml")).toURL()));
        
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event)throws  IOException{
                base.getChildren().clear(  );
                base.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml")).toURL()));
                System.out.println("cancelButton");
    }
    @FXML
    public void initialize(  )throws IOException{
        System.out.println("personButton");
        repPane.getChildren().clear();
        repPane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Register/Person.fxml")).toURL()));
    }

}
