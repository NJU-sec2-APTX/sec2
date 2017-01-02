package client.UI.SaleMan.Strategy;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class StrategyController {
	
        @FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
    @FXML
    private Button DeleteStrategy;
    @FXML
    private Button AddStrategy;
    @FXML
    private Button ChangeStrategy;
    @FXML
    private Button GetStrategy;
        
                        
    @FXML
    //新增策略
        public void AddStrategy() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/AddStrategy.fxml").toURL()));
            add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);   
        }
    //删除策略
    @FXML
	public void DeleteStrategy() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/DeleteStrategy.fxml").toURL()));
            add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add);        
	}
        
        
        //修改策略内容
    @FXML
        public void ChangeStrategy() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeStrategy.fxml").toURL()));
           add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add); 
        }
    @FXML
    //查看策略，输入策略名，选择策略类型
        public void GetStrategy() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/SaleMan/Strategy/GetStrategy.fxml").toURL()));
            add=fXMLLoader.load();           
           all.getChildren().clear();   
           all.getChildren().add(add); 
        }
       
       
       
       
        
}
