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
	TextField id,money;
        @FXML
	AnchorPane add;
        @FXML
        Label result;
        @FXML
	public void  Charge() throws IOException, Exception {
            if(Integer.parseInt(money.getText())>0){
                if(User_Factory.getWebsiteSalesController(Start.person.id).recharge(id.getText(), Integer.parseInt(money.getText()))==ResultMessage.Success){
                    result.setText("充值成功");
                }else{
                    result.setText("充值失败");
                }
            }else{
                    result.setText("充值失败");
            }
	}

}
