/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import client.UI.Hotel.ExecuteOrder.ExecuteSingleController;
import client.businessLogicService.HotelFactory;
import common.otherEnumClasses.SortFlag;
import common.vo.HotelVO;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class SearchHotelController {
    @FXML
    private ScrollPane showPane;
    @FXML
    private TextField hotelNameField;
    @FXML
    private Button priceButton;
    @FXML
    private Button starButton;
    @FXML
    private Button markButton;
    @FXML
    private Button clearSearchButton;
    @FXML
    private ChoiceBox<String> areaBox;
    @FXML
    private ChoiceBox<String> starBox;
    @FXML
    private CheckBox isRerveredCheeckBox;
    @FXML
    private ChoiceBox<String> roomTypeBox;
    @FXML
    private ChoiceBox<String> priceBox;
    @FXML
    private ChoiceBox<String> markBox;
    @FXML
    private Button roughSearchButton;
    @FXML
    private DatePicker inDatepicker;
    @FXML
    private DatePicker outDatePicker;
    @FXML
    private TextField numOfHotelField;
    public ArrayList<HotelVO> hotelList;
    @FXML
    private Label tipLabel;
    @FXML
    private TextField addressField;
    @FXML
    private void markButtonHandler(ActionEvent event)throws Exception {//评分排序
        
        hotelList=HotelFactory.getHotelBrowseService().sortHotelList(areaBox.getValue(),addressField.getText(), null, null , SortFlag.star, true);
        show();
    }

    @FXML
    private void starButtonHandler(ActionEvent event)throws Exception {//星级排序
         hotelList=HotelFactory.getHotelBrowseService().sortHotelList(areaBox.getValue(),addressField.getText(), null, null , SortFlag.star, true);
        show();
    }


    @FXML
    private void clearSearchButtonHandler(ActionEvent event)throws  Exception{//明确搜索
        String areaString=areaBox.getValue();
        if(areaString==null){
            tipLabel.setVisible(true);
        }else{
            tipLabel.setVisible(false);
            String name=hotelNameField.getText();
            String address=addressField.getText();
            hotelList=HotelFactory.getHotelBrowseService().getHotelList(name, address, null, null);
            show();
        }
    }
    private void show()throws Exception{
        if (hotelList.isEmpty()) {
                FXMLLoader fxmll=new FXMLLoader();
                AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Member/OrderBrowse/Single.fxml").toURL()));
               SingleController sc=fxmll.getController();
                sc.show(null);
                showPane.getChildrenUnmodifiable().add(addAnchorPane);
        }else{
                for(int i=0;i<hotelList.size();i++){
                    
                    if(isRerveredCheeckBox.isSelected()){
                        if (hotelList.get(i).isEverReserved) {
                            FXMLLoader fxmll=new FXMLLoader();
                            AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            SingleController sc=fxmll.getController();
                            sc.show(hotelList.get(i));
                            showPane.getChildrenUnmodifiable().add(addAnchorPane);
                        }else{
                            continue;
                        }
                    }else{
                        FXMLLoader fxmll=new FXMLLoader();
                        AnchorPane addAnchorPane=fxmll.load((new File("src/UI/Member/OrderBrowse/Single.fxml").toURL()));
                        SingleController sc=fxmll.getController();
                        sc.show(hotelList.get(i));
                        showPane.getChildrenUnmodifiable().add(addAnchorPane);
                    }
                    
                }
            }
    }
    @FXML
    private void roughSearchButtonHandler(ActionEvent event) throws Exception{//大致搜索
        String areaString=areaBox.getValue();
        if(areaString==null){
            tipLabel.setVisible(true);
        }else{
            tipLabel.setVisible(false);
            String name=hotelNameField.getText();
            String address=addressField.getText();
            hotelList=HotelFactory.getHotelBrowseService().getHotelList(name, address, null, null);
            show();
        }
    }
    
    public void initialize(){
        areaBox.getItems().addAll("栖霞","建邺","鼓楼","浦口","玄武");
        starBox.getItems().addAll("一星以上","两星以上","三星以上","四星以上","五星");
        markBox.getItems().addAll("一分以上","两分以上","三分以上","四分以上","五分");
        priceBox.getItems().addAll("");
        roomTypeBox.getItems().addAll("单人","双人","家庭");
        tipLabel.setVisible(false);
    }
    
    
}
