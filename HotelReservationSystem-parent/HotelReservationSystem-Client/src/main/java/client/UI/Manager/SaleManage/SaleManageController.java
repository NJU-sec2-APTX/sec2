package client.UI.Manager.SaleManage;

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
        TextField name,password,contact,id,Name,ID,Contact;
        @FXML 
        TextField Did,Cid,Gid,gname,gid,grole,gcontact;
	@FXML
	AnchorPane all;
	Label result;
	AnchorPane add;
        
        //新增营销人员
	public void  AddSale() throws IOException {
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/AddSale.fxml").toURL()));
            all=fXMLLoader.load();           
            AddSaleController asc=fXMLLoader.getController();            
	}                                  
        //删除营销人员
	public void DeleteSale() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/DeleteSale.fxml").toURL()));
            all=fXMLLoader.load();           
            DeleteSaleController dsc=fXMLLoader.getController();           
	}            
        //修改营销人员信息
        public void ChangeSale() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/ChangeSale.fxml").toURL()));
            all=fXMLLoader.load();           
            ChangeSaleController csc=fXMLLoader.getController();     
        }                 
        //查看营销人员
        public void GetSale() throws IOException{
            FXMLLoader fXMLLoader =new FXMLLoader((new File("src/main/java/client/UI/Manager/SaleManage/GetSale.fxml").toURL()));
            all=fXMLLoader.load();           
            GetSaleController gsc=fXMLLoader.getController();     
        }                           
}
