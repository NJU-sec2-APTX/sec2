/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.MemberInfo;

import client.UI.Runner.Start;
import client.businessLogicService.memberblService.MemberMaintainService;
import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.memberbl.MemberController;
import client.businessLogicServiceImpl.userbl.UserFactory;
import common.otherEnumClasses.UserRole;
import common.vo.MemberVO;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import oracle.jrockit.jfr.parser.ChunkParser;

/**
 * FXML Controller class
 *
 * @author zhuyingshan
 */
public class EnterpriseInfoRepController {
    @FXML
    private AnchorPane repBase;
    @FXML
    private Pane replacePane;
    @FXML
    private Button creditButton;
    @FXML
    private Button correctInfoButton;
    @FXML
    private Label idField;
    @FXML
    private Label nameField;
    @FXML
    private Label contactField;
    @FXML
    private Label creditField;
    @FXML
    private Label rankField;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() throws Exception{
        MemberMaintainService uif=new MemberController(Start.person.id, UserRole.Enterprise);
        
    }    

    @FXML
    private void creditButtonHandler(ActionEvent event) throws Exception {
        repBase.getChildren().clear();
        repBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Mmeber/MmeberInfo/Credit.fxml").toURL())));
    
    }

    @FXML
    private void correctInfoButtonHandler(ActionEvent event) throws Exception{
        repBase.getChildren().clear();
        repBase.getChildren().add(FXMLLoader.load((new File("src/main/java/client/UI/Mmeber/MemberInfo/EnterpriseCorrect.fxml").toURL())));
    }
    
}
