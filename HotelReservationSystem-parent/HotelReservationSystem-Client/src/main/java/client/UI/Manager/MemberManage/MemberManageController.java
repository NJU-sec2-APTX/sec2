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
	
         public void clickAddMemberR() throws IOException, Exception{
                Initialize chushi=new Initialize();
                chushi.initialize(role);
                UserPO po=new UserPO(id.getText(),UserRole.getUserRole(role.getValue()));
                po.setContact(contact.getText());
                po.setName(name.getText());
                po.setPassword(password.getText());
                po.setbelonghotel(hotel.getText());
                UserVO vo=new UserVO(po);
                ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo);
                if(rm==ResultMessage.Success){
                    result.setText("新增用户成功");
                }else{
                    result.setText("新增失败");
                }
        }

     
        
    @FXML
    //修改用户信息
        public void ChangeMember() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/ChangeMember.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        public void clickChangeMemberR() throws IOException, Exception{
                Initialize chushi=new Initialize();
                chushi.initialize(Crole);
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/Change.fxml").toURL()));
                all.getChildren().add(add);
                UserVO vo=User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(Cid.getText(), UserRole.getUserRole(Crole.getValue()));
                chushi.initialize(crole);
                cname.setText(vo.getName());
                cid.setText(vo.getId());
                ccontact.setText(vo.getContact());
                chotel.setText(vo.getBelongHotel());
                crole.setAccessibleText(vo.getUserRole().toString());
        }
        
        public void clickChangeR() throws IOException, Exception{
                UserPO po=new UserPO(cid.getText(),UserRole.getUserRole(crole.getValue()));
                po.setContact(ccontact.getText());
                po.setName(cname.getText());
                po.setbelonghotel(chotel.getText());
                UserVO vo=new UserVO(po);
                ResultMessage rm=User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo);
                if(rm==ResultMessage.Success){
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
                Initialize chushi=new Initialize();
                chushi.initialize(Grole);
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/MemberManage/ShowMember.fxml").toURL()));
                all.getChildren().add(add);
                UserVO vo=User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(Gid.getText(),UserRole.getUserRole(Grole.getValue()));
                //显示信息                                              
                gname.setText(vo.getName());
                gid.setText(vo.getId());
                ghotel.setText(vo.getBelongHotel());
                grole.setText(vo.getUserRole().toString());
                gcontact.setText(vo.getContact());
        }
}
