/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import client.UI.Hotel.ExecuteOrder.ExecuteSingleController;
import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import common.otherEnumClasses.HotelSearchConditions;
import common.otherEnumClasses.RoomType;
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
    boolean isHaveHotel;
    @FXML
    private void markButtonHandler(ActionEvent event)throws Exception {//评分排序
        if (isHaveHotel) {
            HotelSearchConditions searchConditions=makeConditions();
            hotelList=HotelFactory.getHotelBrowseService().sortHotelList(areaBox.getValue(),addressField.getText(), searchConditions, Start.person.id , SortFlag.mark, true);
            show();
        }
    }

    @FXML
    private void starButtonHandler(ActionEvent event)throws Exception {//星级排序
        if (isHaveHotel) {
            HotelSearchConditions searchConditions=makeConditions();
            hotelList=HotelFactory.getHotelBrowseService().sortHotelList(areaBox.getValue(),addressField.getText(), searchConditions, Start.person.id , SortFlag.star, true);
            show();
        }
    }


    @FXML
    private void clearSearchButtonHandler(ActionEvent event)throws  Exception{//明确搜索
        String areaString=areaBox.getValue();
        if(areaString==null){
            tipLabel.setVisible(true);
            isHaveHotel=false;
        }else{
            isHaveHotel=true;
            tipLabel.setVisible(false);
            String name=hotelNameField.getText();
            String address=addressField.getText();
            hotelList=HotelFactory.getHotelBrowseService().getHotelList(name, address, null, null);
            show();
        }
    }
    
    
    private void show()throws Exception{//把得到的list输出
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
    
    public HotelSearchConditions makeConditions(){
        HotelSearchConditions hotelSearchConditions=new HotelSearchConditions();
            try{ 
                String areaString=areaBox.getValue();
                String name=hotelNameField.getText();
                String address=addressField.getText();
                HotelSearchConditions searchItems=new HotelSearchConditions();
                hotelSearchConditions.dateDown=outDatePicker.getValue();
                hotelSearchConditions.dateUp=inDatepicker.getValue();
                hotelSearchConditions.hotelName=hotelNameField.getText();
                hotelSearchConditions.onlyEverReserved=isRerveredCheeckBox.isSelected();
                hotelSearchConditions.restHotelNumber=(numOfHotelField.getText()==null?0:Integer.parseInt(numOfHotelField.getText()));
                String star=starBox.getValue();//
                String markString=markBox.getValue();//
                String priceString=priceBox.getValue();//
                String roomtypeString=roomTypeBox.getValue();//
                hotelSearchConditions.starDown=getStar(star);
                hotelSearchConditions.starUp=5;
                hotelSearchConditions.markDown=getMark(markString);
                hotelSearchConditions.markUp=5;
                hotelSearchConditions.priceDown=getPrice(priceString)[0];
                hotelSearchConditions.priceUp=getPrice(priceString)[1];
                hotelList=HotelFactory.getHotelBrowseService().getHotelList(areaString, address, searchItems, Start.person.id);
                show();
            }catch (Exception e){
                System.out.println("client.UI.Member.SearchHotel.SearchHotelController.roughSearchButtonHandler()");
                tipLabel.setText("请正确输入信息");
                return null;
            }
                return null;
    }
    
    @FXML
    private void roughSearchButtonHandler(ActionEvent event) throws Exception{//大致搜索
        String areaString=areaBox.getValue();
        if(areaString==null){
            tipLabel.setVisible(true);
            isHaveHotel=false;
        }else{
            isHaveHotel=true;
            tipLabel.setVisible(false);
            String name=hotelNameField.getText();
            String address=addressField.getText();
            HotelSearchConditions searchItems=new HotelSearchConditions();
            searchItems=makeConditions();
        }
    }
    
    public void initialize(){//初始化
        areaBox.getItems().addAll("栖霞","建邺","鼓楼","浦口","玄武");
        starBox.getItems().addAll("一星以上","两星以上","三星以上","四星以上","五星");
        markBox.getItems().addAll("一分以上","两分以上","三分以上","四分以上","五分");
        priceBox.getItems().addAll("200以下","200-300","300-400","500以上");
        roomTypeBox.getItems().addAll("单人","双人","家庭");
        tipLabel.setVisible(false);
        isHaveHotel=false;
    }
    private RoomType getRoomType(){
        String s=roomTypeBox.getValue();
        if(s==null){
            return null;
        }else{
            switch (s){
                case "单人":return RoomType.SingleStd;
                case"双人":return RoomType.DoubleStd;
                case"家庭":return RoomType.Family;
            }
        }
        return null;
    }
    private int getMark(String mark){//获得评分搜索排序
        String markString=markBox.getValue();
        if (markString==null) {
            return 0;
        }else{
            switch(markString){
                case "一分以上":return 1;
                case "两分以上":return 2;
                case"三分以上":return 3;
                case"四分以上":return  4;
                case"五分":return 5;
            }
        }
        return 0;
    }
    private int [] getPrice(String p){//获得价格
        int r[] =new int[2];
        String s=priceBox.getValue();
        if(s==null){
            return  r;
        }else{
            switch(p){
                case"200以下":
                    r[0]=0;
                    r[1]=200;
                    return r;
                case"200-300":
                    r[0]=200;
                    r[1]=300;
                    return r;
                case"300-400":
                    r[0]=300;
                    r[1]=400;
                    return r;
                case"500以上":
                    r[0]=500;
                    return r;
            }
        }
        return r;
    }
    private int getStar(String star) {//获得星级
        if (star==null) {
            return 0;
        }else{
            switch (star){
                case "一星以上":return 1;
                case"两星以上":return 2;
                case"三星以上":return 3;
                case"四星以上":return 4;
                case"五星":return  5;
            }
        }
        return 0;
    }

    @FXML
    private void priceButtonHandler(ActionEvent event) throws Exception{
        if (isHaveHotel) {
            HotelSearchConditions searchConditions=makeConditions();
            hotelList=HotelFactory.getHotelBrowseService().sortHotelList(areaBox.getValue(),addressField.getText(), searchConditions, Start.person.id , SortFlag.star, true);
            show();
        }
    }
    
    
}
