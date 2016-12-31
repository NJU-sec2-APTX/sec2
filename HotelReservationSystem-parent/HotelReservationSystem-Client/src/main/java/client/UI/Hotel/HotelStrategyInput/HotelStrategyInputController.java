/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Hotel.HotelStrategyInput;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.StrategyLineItem;
import common.otherEnumClasses.StrategyList;
import common.otherEnumClasses.StrategyType;
import common.otherEnumClasses.UserRole;
import common.vo.StrategyVO;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class HotelStrategyInputController {

    @FXML
    private Button correctButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button addBirthdayButton;
    @FXML
    private TextField birthField;
    @FXML
    private TextField threeField;
    @FXML
    private Button addThreeButton;
    @FXML
    private TextField enterpriseField;
    @FXML
    private Button addEnterpriseButton;
    @FXML
    private TextField douElevenField;
    @FXML
    private Button addDouElevenButton;
    @FXML
    private AnchorPane repPane;

    boolean isEdit=false;
    
    @FXML
    public  void initialize()throws Exception{
        show();
        exitEdit();
    }
    
    public void show() throws RemoteException{
        ArrayList<StrategyVO> list=StrategyFactory.getStrategyController(Start.person.id, UserRole.HotelWorker).getAllStrategy();
        for(int i=0;i<list.size();i++){
            StrategyType type=list.get(i).getStrategyType();
             switch (type){
                 case Birthday:
                     birthField.setText(list.get(i).getCount()+"");
                     break;
                case SpecialDate:
                    douElevenField.setText(list.get(i).getCount()+"");
                    break;
                case CorporationEnterPrise:
                    enterpriseField.setText(list.get(i).getCount()+"");
                    break;
                case RoomNumber:
                    threeField.setText(list.get(i).getCount()+"");
                    break;
            }
        }
    }
    void inEdit(){
        correctButton.setText("确定");
        birthField.setEditable(true);
        douElevenField.setEditable(true);
        threeField.setEditable(true);
        enterpriseField.setEditable(true);
    }
    void exitEdit(){
        correctButton.setText("更改");
        birthField.setEditable(true);
        douElevenField.setEditable(true);
        threeField.setEditable(true);
        enterpriseField.setEditable(true);
    }
    @FXML
    private void correctButtonHandler(ActionEvent event) {
        inEdit();
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        
    }

    @FXML
    private void addBirthdayButtonHandler(ActionEvent event) {
        
        
    }

    @FXML
    private void addThreeButtonHandler(ActionEvent event) {
    }

    @FXML
    private void addEnterpriseButtonHandler(ActionEvent event) {
    }

    @FXML
    private void addDouElevenButtonHandler(ActionEvent event) {
        
    }
   
}
