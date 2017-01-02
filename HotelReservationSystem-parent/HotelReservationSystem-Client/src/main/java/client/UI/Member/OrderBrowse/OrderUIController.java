/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.OrderBrowse;

import client.UI.Hotel.ExecuteOrder.ExecuteSingleController;
import client.UI.Member.MemberInfo.CreditSingleController;
import client.UI.Runner.Start;
import client.businessLogicService.OrderFactory;
import static common.otherEnumClasses.CreditOperation.ExceptionCancel;
import common.otherEnumClasses.OrderState;
import static common.otherEnumClasses.OrderState.*;
import static common.otherEnumClasses.OrderState.NotDone;
import common.vo.OrderVO;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class OrderUIController  {

    @FXML
    private AnchorPane basePane;
    @FXML
    private ScrollPane showPane;
    @FXML
    private ChoiceBox<String> orderStatuechooseButton;
    @FXML
    private Button find;


    public void initialize()throws Exception  {//初始化列表
        orderStatuechooseButton.getItems().addAll("已执行订单","未执行订单","异常订单","异常取消订单","已评论订单","已取消订单");
        System.out.println(Start.person.id);
        ArrayList<OrderVO> OrderList = OrderFactory.getOrderService().searchOrderListFromData(Start.person, null, null);
        if(OrderList.isEmpty())System.out.println("client.UI.Member.OrderBrowse.OrderUIController.initialize()");
        
        VBox box=new VBox();
        if(OrderList.isEmpty()){
                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                AnchorPane addAnchorPane=fxmll.load();
                SingleController sc=fxmll.getController();
                sc.show(null);
                box.getChildren().add(addAnchorPane);
        }else{  
                for(int i=0;i<OrderList.size();i++){
                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                AnchorPane addAnchorPane=fxmll.load();
                SingleController sc=fxmll.getController();
                sc.show(OrderList.get(i));
                box.getChildren().add(addAnchorPane);
            }
        }
        showPane.setContent(box);
    }
//Done.toString(),NotDone.toString(),Exceptional.toString(),ExceptionCancel.toString() ,Commented.toString(),Canceled.toString()
    @FXML
    private void findHandler(ActionEvent event) throws Exception{
        if (orderStatuechooseButton.getValue()==null) {
                ArrayList<OrderVO> OrderList = OrderFactory.getOrderService().searchOrderListFromData(Start.person, null, null);
                VBox box=new VBox();
                if(OrderList.isEmpty()){
                    FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                    AnchorPane addAnchorPane=fxmll.load();
                    SingleController sc=fxmll.getController();
                    sc.show(null);
                    box.getChildren().add(addAnchorPane);
                }else{  
                    for(int i=0;i<OrderList.size();i++){
                        FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                        AnchorPane addAnchorPane=fxmll.load();
                        SingleController sc=fxmll.getController();
                        sc.show(OrderList.get(i));
                        box.getChildren().add(addAnchorPane);
                    }
                }
                showPane.setContent(box);
        }else{
            VBox box=new VBox();
             switch (orderStatuechooseButton.getValue()){
                case"已执行订单":
                        ArrayList<OrderVO> OrderList = OrderFactory.getOrderService().searchOrderListFromData(Start.person, Done, null);
                        if(OrderList.isEmpty()){
                            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            AnchorPane addAnchorPane=fxmll.load();
                            SingleController sc=fxmll.getController();
                            sc.show(null);
                            box.getChildren().add(addAnchorPane);
                        }else{  
                            for(int i=0;i<OrderList.size();i++){
                                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                                AnchorPane addAnchorPane=fxmll.load();
                                SingleController sc=fxmll.getController();
                                sc.show(OrderList.get(i));
                                box.getChildren().add(addAnchorPane);
                        }
                     }
                    showPane.setContent(box);
                    break;
                case "未执行订单":
                        ArrayList<OrderVO> OrderList1 = OrderFactory.getOrderService().searchOrderListFromData(Start.person, NotDone, null);
                       
                        if(OrderList1.isEmpty()){
                            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            AnchorPane addAnchorPane=fxmll.load();
                            SingleController sc=fxmll.getController();
                            sc.show(null);
                            box.getChildren().add(addAnchorPane);
                        }else{  
                            for(int i=0;i<OrderList1.size();i++){
                                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                                AnchorPane addAnchorPane=fxmll.load();
                                SingleController sc=fxmll.getController();
                                sc.show(OrderList1.get(i));
                                box.getChildren().add(addAnchorPane);
                             }
                        }
                    showPane.setContent(box);
                    break;
                case "异常订单":
                    ArrayList<OrderVO> OrderList2 = OrderFactory.getOrderService().searchOrderListFromData(Start.person, Exceptional, null);
                       
                        if(OrderList2.isEmpty()){
                            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            AnchorPane addAnchorPane=fxmll.load();
                            SingleController sc=fxmll.getController();
                            sc.show(null);
                            box.getChildren().add(addAnchorPane);
                        }else{  
                            for(int i=0;i<OrderList2.size();i++){
                                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                                AnchorPane addAnchorPane=fxmll.load();
                                SingleController sc=fxmll.getController();
                                sc.show(OrderList2.get(i));
                                box.getChildren().add(addAnchorPane);
                             }
                        }
                    showPane.setContent(box);
                    break;
                case "异常取消订单":
                    ArrayList<OrderVO> OrderList3 = OrderFactory.getOrderService().searchOrderListFromData(Start.person, ExceptionalCanceled, null);
                        if(OrderList3.isEmpty()){
                            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            AnchorPane addAnchorPane=fxmll.load();
                            SingleController sc=fxmll.getController();
                            sc.show(null);
                            box.getChildren().add(addAnchorPane);
                        }else{  
                            for(int i=0;i<OrderList3.size();i++){
                                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                                AnchorPane addAnchorPane=fxmll.load();
                                SingleController sc=fxmll.getController();
                                sc.show(OrderList3.get(i));
                                box.getChildren().add(addAnchorPane);
                             }
                        }
                    showPane.setContent(box);
                    break;
                case "已评论订单":
                    ArrayList<OrderVO> OrderList4 = OrderFactory.getOrderService().searchOrderListFromData(Start.person, Commented, null);
                       
                        if(OrderList4.isEmpty()){
                            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            AnchorPane addAnchorPane=fxmll.load();
                            SingleController sc=fxmll.getController();
                            sc.show(null);
                            box.getChildren().add(addAnchorPane);
                        }else{  
                            for(int i=0;i<OrderList4.size();i++){
                                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                                AnchorPane addAnchorPane=fxmll.load();
                                SingleController sc=fxmll.getController();
                                sc.show(OrderList4.get(i));
                                box.getChildren().add(addAnchorPane);
                             }
                        }
                    showPane.setContent(box);
                    break;
                case "已取消订单":
                    ArrayList<OrderVO> OrderList5 = OrderFactory.getOrderService().searchOrderListFromData(Start.person, Canceled, null);
                       
                        if(OrderList5.isEmpty()){
                            FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                            AnchorPane addAnchorPane=fxmll.load();
                            SingleController sc=fxmll.getController();
                            sc.show(null);
                            box.getChildren().add(addAnchorPane);
                        }else{  
                            for(int i=0;i<OrderList5.size();i++){
                                FXMLLoader fxmll=new FXMLLoader((new File("src/main/java/client/UI/Member/OrderBrowse/Single.fxml").toURL()));
                                AnchorPane addAnchorPane=fxmll.load();
                                SingleController sc=fxmll.getController();
                                sc.show(OrderList5.get(i));
                                box.getChildren().add(addAnchorPane);
                             }
                        }
                    showPane.setContent(box);
                    break;
            }
        
        }
       
    }

}
