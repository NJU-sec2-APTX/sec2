package client.UI.Manager.MemberManage;

import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import java.io.File;
import java.io.IOException;
import client.businessLogicService.User_Factory;
import client.UI.Runner.Start;
import common.otherEnumClasses.ResultMessage;
import common.vo.UserVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MemberManageController {
	@FXML
	Button  AddMember,ChangeMember,GetMember,AddMemberR,GetMemberR,ChangeMemberR,ChangeR;
	@FXML
	Pane change;
        @FXML
        TextField name,password,contact,hotel,id,cname,cid,chotel,ccontact;
        @FXML
        TextField gname,gid,ghotel,grole,gcontact;
        @FXML
        TextField Cid,Gid;
	@FXML
	AnchorPane all;
	Label result;
        ChoiceBox<String> role,Crole,crole,Grole;
	AnchorPane add;
    @FXML
    //新增用户
	public void  AddMember() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/AddMember.fxml").toURL()));
                all.getChildren().add(add );
        }
            
    @FXML
    //修改用户信息
        public void ChangeMember() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/ChangeMember.fxml").toURL()));
                all.getChildren().add(add);
        }
                
    //查看用户
        public void GetMember() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/GetMember.fxml").toURL()));
                all.getChildren().add(add);
        }

   
}
