package client.UI.Runner;
import client.Client;
import client.businessLogicService.User_Factory;
import client.businessLogicService.userblService.UserIFactory;
import client.businessLogicServiceImpl.userbl.UserFactory;
import common.otherEnumClasses.Person;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import java.io.File;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
/**
 *
 * @author zhuyingshan
 */

public class Start extends Application  {
        public static Person person=new Person();
        
	public static void main(String[] args) {
                new Client();
		Application.launch(Start.class,args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load((new File("src/main/java/client/UI/Runner/Runner.fxml")).toURL());
		
                Scene scene=new Scene(root);
                
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(scene);
		primaryStage.setTitle("隽程酒店管理系统");
		primaryStage.show();
                primaryStage.setOnCloseRequest((WindowEvent event) -> {
                    System.out.print("监听到窗口关闭");
                    if (person.id!=null) {
                        System.out.print("退出"+person.id);
                        if (null!=person.role)
                            User_Factory.getUserService().logout(person.id,person.role);
                        System.out.println("登出");
                    }else{
                        System.out.println("没有登录情况下的");
                    }
                });
	}
}
