/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.HotelInfo;

import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import common.po.HotelPO;
import common.vo.HotelVO;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class HotelInfoController {
    HotelVO hotelVO;
    @FXML
    private AnchorPane basePane;
    @FXML
    private Label hotelNameLabel;
    @FXML
    private Button hotelInfoButton;
    @FXML
    private Button hotelIntroduceButton;
    @FXML
    private TextArea showArea;
    @FXML
    private Button correctButton;
    @FXML
    private Button cancelButton;
    boolean isEditing;
    @FXML
    private TextField nameField;
    @FXML
    private TextField areaField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField serviceField;
    @FXML
    private Label tipLabel;
    @FXML
    private Label starLabel;
    @FXML
    private Label markField;
    
    private void hotelIntroduceButtonHandler(ActionEvent event) {
        showArea.setText(hotelVO.introduction);
    }
    @FXML
    private void hotelInfoButtonHandler(ActionEvent event) {
        showArea.setText(hotelVO.name+"\n"+hotelVO.star+"\n"+hotelVO.area+"\n"+hotelVO.address+"\n");
        correctButton.setDisable(true);
    }

    void setEdited(boolean a){//false，不能编辑
        showArea.setEditable(a);
        nameField.setEditable(a);
        serviceField.setEditable(a);
        addressField.setEditable(a);
        areaField.setEditable(a);
    }


    @FXML
    private void correctButtonHandler(ActionEvent event) {
        correctButton.setDisable(false);
        if(isEditing){
            isEditing=false;
            setEdited(true);
            if(showArea.getText().equals(hotelVO.introduction)&&nameField.getText().equals(hotelVO.name)&&serviceField.equals(hotelVO.rooms.size())&&
                    addressField.getText().equals(hotelVO.address)&&areaField.getText().equals(hotelVO.area)){
                tipLabel.setText("信息未变动");
            }else{
                HotelPO po=new HotelPO();
                po.setAddress(addressField.getText());
                po.setName(nameField.getText());
                po.setIntroduction(showArea.getText());
                po.setArea(nameField.getText());
                HotelVO changeHotelVO=new HotelVO(po);
                HotelFactory.getHotelMaintainService().setHotelInfo(hotelVO);
                correctButton.setText("更改");
            }
        }else{
            isEditing=true;
            setEdited(true);
            correctButton.setText("确定");
        }
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) throws Exception{
         System.out.println("executeOrderButton");
         basePane.getChildren().clear();
        basePane.getChildren().add(FXMLLoader.load((new File("ssrc/main/java/client/UI/Hotel/ExecuteOrder/ExecuteReplace.fxml").toURL())));
    }
    
    public void initialize(){
        isEditing=false;
        showArea.setEditable(false);
        String id=Start.person.id ;
        hotelVO=HotelFactory.getHotelMaintainService().getHotelInfo(id);
        showArea.setText(hotelVO.introduction);
        nameField.setText(hotelVO.name);
        areaField.setText(hotelVO.area);
        addressField.setText(hotelVO.address);
        starLabel.setText(hotelVO.star+"");
        markField.setText(hotelVO.mark+"");
        serviceField.setText(hotelVO.rooms.size()+"");
            }
}
