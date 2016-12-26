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
	Button  Charge;
	@FXML
	Pane change;
	AnchorPane all;
	TextField id,money;
        @FXML
	AnchorPane add;
        Label result;
	public void  Charge() throws IOException, Exception {
		User_Factory.getWebsiteSalesController(Start.person.id).recharge(GetId(), GetMoney());
                if(User_Factory.getWebsiteSalesController(Start.person.id).recharge(GetId(), GetMoney())==ResultMessage.Success){
                    result.setText("充值成功");
                }else{
                    result.setText("充值失败");
                }
	}
        
        public String GetId() throws IOException{
                return id.getText();
        }
        
        public int GetMoney() throws IOException{
                return Integer.parseInt(money.getText());
        }
}
