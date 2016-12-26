package client.UI.Manager.SaleManage;

import client.UI.Runner.Start;
import client.businessLogicService.User_Factory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.UserPO;
import common.vo.UserVO;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class SaleManageController {
	@FXML
	Button  AddSale,DeleteSale,ChangeSale,GetSale,GetSaleR,DeleteSaleR,AddSaleR,ChangeSaleR,ChangeR;
	@FXML
	StackPane change;
        @FXML
        TextField name,password,contact,id,Name,ID,Role,Contact;
	@FXML
	AnchorPane all;
	Label result;
	AnchorPane add;
        
        //新增营销人员
	public void  AddSale() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/AddSale.fxml").toURL()));
                all.getChildren().add(add );
	}
        
        public void clickAddSaleR() throws IOException, Exception{
                UserPO po=new UserPO(GetId(),UserRole.Sales);
                po.setContact(GetContact());
                po.setName(GetName());
                po.setPassword(GetPassword());
                UserVO vo=new UserVO(po);
                User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo);
                if(User_Factory.getWebsiteManagerController(Start.person.id).addUser(vo)==ResultMessage.Success){
                    result.setText("新增营销人员成功");
                }else{
                    result.setText("新增失败");
                }
        }
	
        public String GetName() throws IOException{
                return name.getText();
        }
        
        public String GetId() throws IOException{
                return id.getText();
        }
        
        public String GetPassword() throws IOException{
                return password.getText();
        }
        
        public String GetContact() throws IOException{
                return contact.getText();
        }
        
        //删除营销人员
	public void DeleteSale() throws IOException{
		all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/DeleteSale.fxml").toURL()));
                all.getChildren().add(add);
	}
        
        public void clickDeleteSaleR() throws IOException, Exception{
                User_Factory.getWebsiteManagerController(Start.person.id).removeUser(GetId(), UserRole.Sales);
                if(User_Factory.getWebsiteManagerController(Start.person.id).removeUser(GetId(), UserRole.Sales)==ResultMessage.Success){
                    result.setText("删除成功");
                }else{
                    result.setText("删除失败");
                }
        }
        //修改营销人员信息
        public void ChangeSale() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/ChangeSale.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        public void clickChangeSaleR() throws IOException, Exception{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/Change.fxml").toURL()));
                all.getChildren().add(add);
              
                Name.setText(ShowName());
                ID.setText(ShowID());
                Role.setText(ShowRole().toString());
                Contact.setText(ShowContact());
        }
        
        public void clickChangeR() throws IOException, Exception{
                UserPO po=new UserPO(ID.getText(),UserRole.Sales);
                po.setContact(Contact.getText());
                po.setName(Name.getText());
                UserVO vo=new UserVO(po);
                User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo);
                if(User_Factory.getWebsiteManagerController(Start.person.id).modifyUserInfo(vo)==ResultMessage.Success){
                    result.setText("修改成功");
                }else{
                    result.setText("修改失败");
                }
        }
        
        //查看营销人员
        public void GetSale() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/GetSale.fxml").toURL()));
                all.getChildren().add(add);
        }

        public void clickGetSaleR() throws IOException, Exception{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/ShowSale.fxml").toURL()));
                all.getChildren().add(add);
                UserVO vo=User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),UserRole.Sales);
               
                    Name.setText(ShowName());
                    ID.setText(ShowID());
                    Role.setText(ShowRole().toString());
                    Contact.setText(ShowContact());
                
        }
        
        public String ShowName() throws IOException, Exception{ 
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),UserRole.Sales).getName();
        }
        
        public String ShowID() throws IOException, Exception{
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),UserRole.Sales).getId();
        }
        
        public UserRole ShowRole() throws IOException, Exception{
                return UserRole.Sales;
        }
        
        public String ShowContact() throws IOException, Exception{
                return User_Factory.getWebsiteManagerController(Start.person.id).getUserInfo(GetId(),UserRole.Sales).getContact();
        }
}
