/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import client.UI.Runner.Start;
import client.businessLogicService.MemberFactory;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;
import common.vo.OrderVO;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class PersonInfoRepController {

    @FXML
    private AnchorPane basePane;
    @FXML
    private Pane replacePane;
    @FXML
    private Button creditButton;
    @FXML
    private Button correctInfoButton;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label contactLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private Label rankLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Label dayLabel;

  

    @FXML
    private void creditButtonHandler(ActionEvent event) throws Exception{
        basePane.getChildren().clear();
        basePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Mmeber/MmeberInfo/Credit.fxml").toURL())));
    }

    @FXML
    private void correctInfoButtonHandler(ActionEvent event) throws Exception{
        basePane.getChildren().clear();
        basePane.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Mmeber/PersonCorrect/Credit.fxml").toURL())));
        
    }
    
    @FXML
    public void initialize()throws Exception{
        MemberVO mvo=MemberFactory.getMemberMaintainService(Start.person.id, UserRole.Member).getInfo();
        nameLabel.setText(mvo.getName());
        idLabel.setText(mvo.getId());
        contactLabel.setText(mvo.getContact());
        creditLabel.setText(mvo.getCredit()+"");
        rankLabel.setText(mvo.getLevel()+"");
        yearLabel.setText(mvo.getBirthday().getYear()+"");
        monthLabel.setText(mvo.getBirthday().getMonth()+"");
        dayLabel.setText(mvo.getBirthday().getDay()+"");
    }
}
