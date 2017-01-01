package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class StrategyController {
	
        @FXML
	Pane change;
	@FXML
	AnchorPane all;
	
	AnchorPane add;
                        
    @FXML
    //删除策略
	public void DeleteStrategy() throws IOException{
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/DeleteStrategy.fxml").toURL()));
                all.getChildren().add(add );
	}
        
        
        //修改策略内容
        public void ChangeStrategy() throws IOException{
            all.getChildren().clear();
            add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeStrategy.fxml").toURL()));
            all.getChildren().add(add );
            
            
        }
    @FXML
    //查看策略，输入策略名，选择策略类型
        public void GetStrategy() throws IOException{
            all.getChildren().clear();
            add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetStrategy.fxml").toURL()));
            all.getChildren().add(add );
        }
       
       
       
       
        
}
