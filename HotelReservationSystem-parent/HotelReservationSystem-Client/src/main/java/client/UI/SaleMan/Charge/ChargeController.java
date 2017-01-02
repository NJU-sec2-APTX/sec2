package client.UI.SaleMan.Charge;

import java.io.IOException;
import client.businessLogicService.User_Factory;
import client.UI.Runner.Start;
import common.otherEnumClasses.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ChargeController {
        @FXML
	Button  Charge;
	@FXML
	Pane change;
        @FXML
	AnchorPane all;
	@FXML
        TextField id;
        @FXML
        TextField money;
        @FXML
	AnchorPane add;
        @FXML
        Label result;
   
        @FXML
        public void initialize(){
            
        }
	public void  Charge() throws IOException, Exception {
		ResultMessage rm=User_Factory.getWebsiteSalesController(Start.person.id).recharge(GetId(), GetMoney());
                if(rm==ResultMessage.Success){
                    result.setText("充值成功");
                }else{
                    result.setText("充值失败");
                }
	}
        
    @FXML
        public String GetId() throws IOException{
                return id.getText();
        }
        
    @FXML
        public int GetMoney() throws IOException{
                return Integer.parseInt(money.getText());
        }
}
