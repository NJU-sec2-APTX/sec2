package client.UI.SaleMan.Strategy;

import client.UI.Runner.Start;
import client.businessLogicService.StrategyFactory;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class StrategyController {
	@FXML
	Button AddStrategy,DeleteStrategy,ChangeStrategy,GetStrategy,DeleteStrategyR,GetStrategyR,ChangeStrategyR;
        Button ChangeLevelStrategy,ChangeDateStrategy,ChangeVipandAreaStrategy;
        Button GetLevelStrategy,GetDateStrategy,GetVipandAreaStrategy;
        Button AddLevelStrategy,AddLevelStrategyR;
        Button AddDateStrategy,AddDateStrategyR;
        Button AddVipandAreaStrategy,AddVipandAreaStrategyR;
	@FXML
        TextField name,beginyear,beginmonth,beginday,endyear,endmonth,endday,numberofroom,level,discount,enterprise;
        TextField credit1,credit2,credit3,credit4,credit5;
        TextField count1,count2,count3,count4,count5;
        @FXML
	Pane change;
	@FXML
	AnchorPane all;
	ChoiceBox<String> area;
        ChoiceBox<String> type;
	AnchorPane add;
        Label result;
    @FXML
    //新增策略项目
	public void  AddStrategy() throws IOException {
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/AddStrategy.fxml").toURL()));
                all.getChildren().add(add );
	}
        //选择新增策略类型
       
        //新增会员等级升级策略
        
        public void AddLevelStrategy() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/AddLevelStrategy.fxml").toURL()));
                all.getChildren().add(add );
        }
        
        public void clickAddLevelStrategy() throws IOException{
                StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addMemberLevelStrategy(GetCredit());
                if(StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addMemberLevelStrategy(GetCredit())==ResultMessage.Success){
                    result.setText("新增会员等级制度成功");
                }else{
                    result.setText("新增失败");
                }
        
        }
        
        //新增特殊日期优惠策略
        public void AddDateStrategy() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/AddDateStrategy.fxml").toURL()));
                all.getChildren().add(add );
        }
        
        public void clickAddDateStrategyR() throws IOException{
                StrategyFactory.getStrategyController(Start.person.id,Start.person.role).addSpecialDateStrategyPO(GetName(), GetDiscount(), GetBeginDate(), GetEndDate());
                if(StrategyFactory.getStrategyController(Start.person.id,Start.person.role).addSpecialDateStrategyPO( GetName(), GetDiscount(), GetBeginDate(), GetEndDate())==ResultMessage.Success){
                    result.setText("新增特殊时段优惠策略成功");
                }else{
                    result.setText("新增失败");
                }
        }
        
        //新增商圈和VIP优惠策略
        public void AddVipandAreaStrategy() throws IOException{
                all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/AddVipandAreaStrategy.fxml").toURL()));
                all.getChildren().add(add );
        }
        
        public void clickAddVipandAreaStrategyR() throws IOException{
                StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addVipandAreaStrategyPO( GetName(), GetCount(), GetArea());
                if(StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addVipandAreaStrategyPO( GetName(), GetCount(), GetArea())==ResultMessage.Success){
                    result.setText("新增VIP商圈优惠策略成功");
                }else{
                    result.setText("新增失败");
                }
        }
        
        //获得输入的一系列方法
        public String GetName() throws IOException{
                return name.getText();
        }
        
        public Date GetBeginDate() throws IOException{
                Date date=new Date(Integer.parseInt(beginyear.getText())-1900,Integer.parseInt(beginmonth.getText())-1,Integer.parseInt(beginday.getText()));
                return date;
        }
	
        public Date GetEndDate() throws IOException{
                Date date=new Date(Integer.parseInt(endyear.getText())-1900,Integer.parseInt(endmonth.getText())-1,Integer.parseInt(endday.getText()));
                return date;
        }
        
        public String  GetArea() throws IOException{
                area.getItems().addAll("栖霞","建邺","鼓楼","浦口","玄武");
                return area.getValue();
        }
        
        public int GetNumberOfRoom() throws IOException{
            String list[]=numberofroom.getText().split("/");
            int number=0;
            for(int i=0;i<list.length;i++){
                number+=Integer.parseInt(list[i]);
            }
                return number;
        }
        
        public int GetLevel() throws IOException{
                return Integer.parseInt(level.getText());
        }
        
        public double GetDiscount() throws IOException{
                return Double.parseDouble(discount.getText());
        }
        
        public String GetEnterprise() throws IOException{
                return enterprise.getText();
        }
        
        public String GetCredit() throws IOException{
                return credit1.getText()+"/"+credit2.getText()+"/"+credit3.getText()+"/"+credit4.getText()+"/"+credit5.getText();
        }
        
        public String GetCount() throws IOException{
                return count1.getText()+"/"+count2.getText()+"/"+count3.getText()+count4.getText()+count5.getText();
        }
        
    @FXML
    //删除策略
	public void DeleteStrategy() throws IOException{
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/DeleteStrategy.fxml").toURL()));
                all.getChildren().add(add );
	}
        
        public void clickDeleteStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                
                StrategyFactory.getStrategyController(Start.person.id,Start.person.role).removeStrategy(vo);
                if(StrategyFactory.getStrategyController(Start.person.id,Start.person.role).removeStrategy(vo)==ResultMessage.Success){
                    result.setText("删除成功");
                }else{
                    result.setText("删除失败");
                }
        }
        
        //修改策略内容
        public void ChangeStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeStrategy.fxml").toURL()));
                all.getChildren().add(add);
                type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
        }
        
        public void clickChangeStrategyR() throws IOException{
                type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
                String Type =type.getValue();
                if(Type=="会员等级制度"){
                    this.ChangeLevelStrategy();
                }else if(Type=="特殊时段优惠策略"){
                    this.ChangeDateStrategy();
                }else if(Type=="VIP商圈优惠策略"){
                    this.ChangeVipandAreaStrategy();
                }
        }
                   
        //修改会员等级制度
        public void ChangeLevelStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeLevelStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                name.setText(vo.getName());
                String list[]=vo.getEnterprise().split("/");
                credit1.setText(list[0]);
                credit2.setText(list[1]);
                credit3.setText(list[2]);
                credit4.setText(list[3]);
                credit5.setText(list[4]);
        }
        
        public void clickChangeLevelStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(GetName());
                StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),GetCredit(),vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),vo.getArea(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
                StrategyVO VO=new StrategyVO(po);
                StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO);
                if(StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO)==ResultMessage.Success){
                    result.setText("修改会员等级制度成功");
                }else{
                    result.setText("修改失败");
                }
        }
       
        //修改特殊时段优惠策略
        public void ChangeDateStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeDateStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                name.setText(vo.getName());
                String bd=""+vo.getStartDate();
                String ed=""+vo.getEndDate();
                String listb[]=bd.split("/");
                String liste[]=ed.split("/");
                discount.setText(""+vo.getCount());
                beginyear.setText(listb[0]);
                beginmonth.setText(listb[1]);
                beginday.setText(listb[2]);
                endyear.setText(liste[0]);
                endmonth.setText(liste[1]);
                endday.setText(liste[2]);
        }
        
        public void clickChangeDateStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(GetName());
                StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),vo.getEnterprise(),vo.getRoomNumber(),GetBeginDate(),GetEndDate(),vo.getArea(),vo.getLevel(),GetDiscount(),vo.getStrategyType());
                StrategyVO VO=new StrategyVO(po);
                StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO);
                if(StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO)==ResultMessage.Success){
                    result.setText("修改特殊时段优惠策略成功");
                }else{
                    result.setText("修改失败");
                }
        
        }       
        
        //修改VIP商圈优惠策略
        public void ChangeVipandAreaStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeVipandAreaStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                name.setText(vo.getName());
                String list[]=vo.getEnterprise().split("/");
                count1.setText(list[0]);
                count2.setText(list[1]);
                count3.setText(list[2]);
                count4.setText(list[3]);
                count5.setText(list[4]);
                
        }
          
        public void clickChangeVipandAreaStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(GetName());
                StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),GetCount(),vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),GetArea(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
                StrategyVO VO=new StrategyVO(po);
                StrategyFactory.getStrategyController(Start.person.id,Start.person.role).modifyStrategy(VO);
                if(StrategyFactory.getStrategyController(Start.person.id,Start.person.role).modifyStrategy(VO)==ResultMessage.Success){
                    result.setText("修改VIP商圈优惠策略成功");
                }else{
                    result.setText("修改失败");
                }
        }
        
    @FXML
    //查看策略，输入策略名，选择策略类型
        public void GetStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetStrategy.fxml").toURL()));
                all.getChildren().add(add);
                type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
        }
        
        public void clickGetStrategyR() throws IOException{
                type.getItems().addAll("会员等级制度","特殊时段优惠策略","VIP商圈优惠策略");
                String Type=type.getValue();
                if(Type=="会员等级制度"){
                    this.GetLevelStrategy();
                }else if(Type=="特殊时段优惠策略"){
                    this.GetDateStrategy();
                }else if(Type=="VIP商圈优惠策略"){
                    this.GetVipandAreaStrategy();
                }
        }
        
       
        //取得会员等级制度
        public void GetLevelStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetLevelStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                if(vo.getName()==null){
                    
                }else{
                    name.setText(vo.getName());
                    String list[]=vo.getEnterprise().split("/");
                    credit1.setText(list[0]);
                    credit2.setText(list[1]);
                    credit3.setText(list[2]);
                    credit4.setText(list[3]);
                    credit5.setText(list[4]);
                    
                }
        }
        //取得特殊时段优惠策略
        public void GetDateStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetDateStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                    name.setText(vo.getName());
                    String bd=""+vo.getStartDate();
                    String ed=""+vo.getEndDate();
                    String listb[]=bd.split("/");
                    String liste[]=ed.split("/");
                    discount.setText(""+vo.getCount());
                    beginyear.setText(listb[0]);
                    beginmonth.setText(listb[1]);
                    beginday.setText(listb[2]);
                    endyear.setText(liste[0]);
                    endmonth.setText(liste[1]);
                    endday.setText(liste[2]);
                       
        }
        
        //取得VIP商圈优惠策略
        public void GetVipandAreaStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetVipandAreaStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(GetName());
                    name.setText(vo.getName());
                    String list[]=vo.getEnterprise().split("/");
                    count1.setText(list[0]);
                    count2.setText(list[1]);
                    count3.setText(list[2]);
                    count4.setText(list[3]);
                    count5.setText(list[4]);
               
        }
        
}
