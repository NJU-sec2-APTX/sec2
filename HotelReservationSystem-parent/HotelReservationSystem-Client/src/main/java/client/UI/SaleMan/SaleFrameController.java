package client.UI.SaleMan;

import static client.UI.Runner.Start.person;
import client.businessLogicService.User_Factory;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SaleFrameController {
	@FXML
	Button  Strategy,Order,Charge;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane rep;
    @FXML
	public void  clickStrategy() throws IOException {
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/Strategy.fxml").toURL()));
            add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);  
	}
	
    @FXML
	public void clickOrder() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Order/Order.fxml").toURL()));
           add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);  
	}
        
    @FXML
        public void clickCharge() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Charge/Charge.fxml").toURL()));
            add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add); 
        }

    @FXML
    private void exitButtonHander(ActionEvent event)throws Exception{
        System.out.println("exitButton");
        rep.getChildren().clear();
        rep.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml").toURL())));
        System.out.print("退出"+person.id);
        if (null!=person.role)
         User_Factory.getUserService().logout(person.id,person.role);
    }
}
