/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.SearchHotel;

import client.LocalDateToDate;
import client.UI.Runner.Start;
import client.businessLogicService.HotelFactory;
import client.businessLogicService.MemberFactory;
import client.businessLogicService.OrderFactory;
import common.otherEnumClasses.UserRole;
import common.vo.HotelVO;
import common.vo.MemberVO;
import common.vo.OrderVO;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 陈长生
 */
public class MakeOrderController {

    @FXML
    private Button okButton;
    @FXML
    private TextField hotelNameField;
    @FXML
    private ChoiceBox<Integer> famBox;
    @FXML
    private ChoiceBox<Integer> singleBox;
    @FXML
    private Button cancelButton;
    @FXML
    private ChoiceBox<Integer> douBox;
    @FXML
    private DatePicker inDatepicker;
    @FXML
    private DatePicker outDatePicker;
    @FXML
    private Button calButton;
    @FXML
    private Label moneyLabel;
    public  HotelVO hotelVO;
    public  OrderVO addOrderVO=new OrderVO();
     MemberVO memberVO;
    @FXML
    private Label tipLabel;
    @FXML
    private TextField numOfPersonField;
    @FXML
    private CheckBox childrenCheckButton;
    @FXML
    private AnchorPane basePanel;
    
    /*
    *提交订单
    */
    @FXML
    private void okButtonHandler(ActionEvent event) {
       if( calculate()){
           OrderFactory.getOrderService().createOrder(addOrderVO, Start.person.id);
       }
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) throws Exception{
        basePanel.getChildren().clear(); 
        basePanel.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Member/SearchHotel/SearchHotel.fxml")).toURL()));
    }
     /*
    *返回是否符合订单要求
    */
    private boolean calculate(){
            if(singleBox.getValue().equals(0)&&douBox.getValue().equals(0)&&famBox.equals(0)){
                tipLabel.setText("请输入房间");
                return false;
            }else if(Integer.parseInt(numOfPersonField.getText())<0){
                tipLabel.setText("请输入入住人数");
            }else{
                if (memberVO.getCredit()<=0) {
                    tipLabel.setText("用户信用值不足");
                    tipLabel.setVisible(true);
                }else{
                    System.out.println(101+""+(hotelVO==null));
                     System.out.println(101+""+(addOrderVO==null));
                     System.out.println(101+""+(hotelVO.name==null));
                    addOrderVO.hotel=hotelVO.name;
                    String room;
                    if (singleBox.getValue()==null) {
                        room="0/";
                    }else{
                        room=singleBox.getValue() +"/";
                    }
                    if (douBox.getValue()==null) {
                        room =room+"0/";
                    }else{
                        room=room+douBox.getValue()+"/";
                    }
                    if(famBox.getValue()==null){
                        room=room+"0";
                    }else{
                        room=room+famBox.getValue();
                    }
                    addOrderVO.hotelId=hotelVO.id;
                    addOrderVO.clientId=Start.person.id;
                addOrderVO.numOfRoom=room;
                addOrderVO.numberOfPerson=Integer.parseInt(numOfPersonField.getText());
                addOrderVO.createdTime=LocalDateToDate.localDateToDate(inDatepicker.getValue());
                addOrderVO.planExecuteTime=LocalDateToDate.localDateToDate(inDatepicker.getValue());
                addOrderVO.checkInTime=LocalDateToDate.localDateToDate(inDatepicker.getValue());
                addOrderVO.checkOutTime=LocalDateToDate.localDateToDate(outDatePicker.getValue());
                addOrderVO.hasChild=childrenCheckButton.isSelected();
                
                moneyLabel.setText(OrderFactory.getOrderService().calPrice(addOrderVO).price+"");//
                return true;
                }
            }
        return  false;
    }
    
    @FXML
    private void calButtonHandler(ActionEvent event) {
        calculate();
    }
    @FXML
    public void initialize()throws Exception{
        
    }

    void show(HotelVO h) throws  Exception{
        memberVO=MemberFactory.getMemberMaintainService(Start.person.id ,UserRole.Member).getInfo() ;
        hotelNameField.setEditable(false);
        hotelVO=h;
        System.out.println(152+""+hotelVO==null);
        hotelNameField.setText(hotelVO.name);
        for(int i=0;i<3;i++){
            System.out.print((hotelVO.rooms==null)+"*****");
            System.out.println(hotelVO.rooms.size());
            int num=hotelVO.rooms.get(i).restNum;
            while(num!=0){
                num--;
                if(i==0){
                    singleBox.getItems().add(num);
                }else if(i==1){
                    douBox.getItems().add(num);
                }else{
                    famBox.getItems().add(num);
                }
            }
        }
    }
}
