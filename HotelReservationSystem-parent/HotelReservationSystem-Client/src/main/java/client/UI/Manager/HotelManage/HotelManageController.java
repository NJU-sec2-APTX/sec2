package client.UI.Manager.HotelManage;

import common.po.HotelPO;
import java.io.File;
import java.io.IOException;
import client.businessLogicService.HotelFactory;
import common.vo.HotelVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HotelManageController {
	@FXML
	Button AddHotel,ChangeHotel,GetHotel;
        Button AddHotelR,ChangeHotelR,GetHotelR,ChangeR;
        @FXML
        TextField name,star,address,id;
	@FXML
	Pane change;
	@FXML
	AnchorPane all;
	ChoiceBox<String> area;
	AnchorPane add;
        Label result;
    @FXML
	public void  AddHotel() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/AddHotel.fxml").toURL()));
                all.getChildren().add(add );
	}
        
        public void clickAddHotelR() throws IOException{
                HotelPO po=new HotelPO();
                po.setAddress(GetAddress());
                po.setArea(GetArea());
                po.setName(GetName());
                po.setStar(GetStar());
                HotelVO vo=new HotelVO(po);
                HotelFactory.getHotelMaintainService().addHotel(vo);
                if(HotelFactory.getHotelMaintainService().addHotel(vo)){
                    result.setText("新增酒店成功");
                }else{
                    result.setText("新增失败");
                }
        }
        
        public String GetName() throws IOException{
                return name.getText();
        }
        
        public String GetAddress() throws IOException{
                return address.getText();
        }
	
        public int GetStar() throws IOException{
                return Integer.parseInt(star.getText());
        }
         
        public String GetArea() throws IOException{
                area.getItems().addAll("栖霞","建邺","鼓楼","浦口","玄武");
                return area.getValue();
        }
        
        public String GetId() throws IOException{
                return id.getText();
        }
        //修改酒店信息
        public void ChangeHotel() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/ChangeHotel.fxml").toURL()));
                all.getChildren().add(add);
        }
        
        public void clickChangeHotelR() throws IOException, Exception{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/SaleManage/Change.fxml").toURL()));
                all.getChildren().add(add);
                HotelVO vo=HotelFactory.getHotelMaintainService().getHotelInfo(GetName());
                name.setText(vo.name);
                id.setText(vo.id);
                address.setText(vo.address);
                star.setText(""+vo.star);
        }
        
        public void clickChangeR() throws IOException, Exception{
                HotelVO vo=new HotelVO();
                vo.name=GetName();
                vo.star=GetStar();
                vo.address=GetAddress();
                vo.area=GetArea();
                vo.id=GetId();
                HotelFactory.getHotelMaintainService().setHotelInfo(vo);
                if(HotelFactory.getHotelMaintainService().setHotelInfo(vo)){
                    result.setText("修改成功");
                }else{
                    result.setText("修改失败");
                }
        }
        
        //查看酒店
        public void GetHotel() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/GetHotel.fxml").toURL()));
                all.getChildren().add(add);
        }

        public void clickGetSaleR() throws IOException, Exception{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/Manager/HotelManage/ShowHotel.fxml").toURL()));
                all.getChildren().add(add);
                HotelVO vo=HotelFactory.getHotelMaintainService().getHotelInfo(GetName());                
                    name.setText(vo.name);
                    id.setText(vo.id);
                    address.setText(vo.address);
                    area.setAccessibleText(vo.area);
                    star.setText(""+vo.star);
                
        }
}