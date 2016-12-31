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
        TextField name,password,contact,hotel,id,Name,Contact,Hotel,ID;
	@FXML
	AnchorPane all;
	Label result;
        ChoiceBox<String> type;
	AnchorPane add;
    @FXML
    //新增用户
	public void  AddMember() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/AddMember.fxml").toURL()));
                all.getChildren().add(add );
	}
	
         public void clickAddMemberR() throws IOException, Exception{
                UserPO po=new UserPO(GetId(),GetRole());
                po.setContact(GetContact());
                po.setName(GetName());
                po.setPassword(GetPassword());
                po.setbelonghotel(GetHotel());
                UserVO vo=new UserVO(po);
                User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo);
                if(User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo)==ResultMessage.Success){
                    result.setText("新增用户成功");
                }else{
                    result.setText("新增失败");
                }
        }

        public String GetName() throws IOException{
                return name.getText();
        }
        
        public String GetPassword() throws IOException{
                return password.getText();
        }
	
        public UserRole GetRole() throws IOException{
            type.getItems().addAll("个人客户","企业客户","酒店工作人员","网站营销人员","网站管理人员");
                return UserRole.getUserRole(type.getValue());
        }
        
        public String GetHotel() throws IOException{
                return hotel.getText();
        }
         
        public String GetContact() throws IOException{
                return contact.getText();
        }
        
        public String GetId() throws IOException{
                return id.getText();
        }
        
    @FXML
    //修改用户信息
        public void ChangeMember() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/ChangeMember.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        public void clickChangeMemberR() throws IOException, Exception{
            type.getItems().addAll("个人客户","企业客户","酒店工作人员","网站营销人员","网站管理人员");
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/Change.fxml").toURL()));
                all.getChildren().add(add);
              
                Name.setText(ShowName());
                ID.setText(ShowID());
                type.setAccessibleText(ShowRole().toString());
                Hotel.setText(ShowHotel());
                Contact.setText(ShowContact());
        }
        
        public void clickChangeR() throws IOException, Exception{
                UserPO po=new UserPO(GetId(),GetRole());
                po.setContact(Contact.getText());
                po.setName(Name.getText());
                po.setbelonghotel(Hotel.getText());
                UserVO vo=new UserVO(po);
                User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo);
                if(User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo)==ResultMessage.Success){
                    result.setText("修改成功");
                }else{
                    result.setText("修改失败");
                }
        }
        
    //查看用户
        public void GetMember() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/GetMember.fxml").toURL()));
                all.getChildren().add(add);
        }

        public void clickGetMemberR() throws IOException, Exception{
            type.getItems().addAll("个人客户","企业客户","酒店工作人员","网站营销人员","网站管理人员");
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/ShowMember.fxml").toURL()));
                all.getChildren().add(add);
                //显示信息                                              
                    Name.setText(ShowName());
                    ID.setText(ShowID());
                    type.setAccessibleText(ShowRole().toString());
                    Hotel.setText(ShowHotel());
                    Contact.setText(ShowContact());
                
        }
        
        public String ShowName() throws IOException, Exception{ 
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),GetRole()).getName();
        }
        
        public String ShowID() throws IOException, Exception{
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),GetRole()).getId();
        }
        
        public UserRole ShowRole() throws IOException, Exception{
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),GetRole()).getUserRole();
        }
        
        public String ShowHotel() throws IOException, Exception{
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),GetRole()).getBelongHotel();
        }
        
        public String ShowContact() throws IOException, Exception{
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),GetRole()).getContact();
        }
}
