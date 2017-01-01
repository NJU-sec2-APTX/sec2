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
        TextField name,beginyear,beginmonth,beginday,endyear,endmonth,endday,numberofroom,level,enterprise;
        TextField cbeginyear,cbeginmonth,cbeginday,cendyear,cendmonth,cendday,cdiscount;
        TextField gbeginyear,gbeginmonth,gbeginday,gendyear,gendmonth,gendday,gdiscount;
        TextField credit1,credit2,credit3,credit4,credit5,ccredit1,ccredit2,ccredit3,ccredit4,ccredit5,gcredit1,gcredit2,gcredit3,gcredit4,gcredit5;
        TextField count1,count2,count3,count4,count5,ccount1,ccount2,ccount3,ccount4,ccount5,gcount1,gcount2,gcount3,gcount4,gcount5;
        TextField datename,datecount;
        TextField vname,dname,Cname,clname,cdname,cvname,Gname,glname,gdname,gvname;
        @FXML
	Pane change;
	@FXML
	AnchorPane all;
	ChoiceBox<String> area,carea;
        ChoiceBox<String> type,Gtype;
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
        
        public void clickAddLevelStrategyR() throws IOException{
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).addMemberLevelStrategy(GetCredit(credit1.getText(),credit2.getText(),credit3.getText(),credit4.getText(),credit5.getText()));
                if(rm==ResultMessage.Success){
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
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).addSpecialDateStrategyPO(datename.getText(),Double.parseDouble(datecount.getText()),GetBeginDate(beginyear.getText(),beginmonth.getText(),beginday.getText()),GetEndDate(endyear.getText(),endmonth.getText(),endday.getText()));
                if(rm==ResultMessage.Success){
                    result.setText("新增特殊时段优惠策略成功");
                }else{
                    result.setText("新增失败");
                }
        }
        
        //新增商圈和VIP优惠策略
        public void AddVipandAreaStrategy() throws IOException{
                AddVipandAreaStrategyController ac=new AddVipandAreaStrategyController();
                ac.initialize();
                ac.Add();
        }
        //获得输入的一系列方法       
        public int GetNumberOfRoom(String nor) throws IOException{
            String list[]=nor.split("/");
            int number=0;
            for(int i=0;i<list.length;i++){
                number+=Integer.parseInt(list[i]);
            }
                return number;
        }
        
        public Date GetBeginDate(String y,String m,String d) throws IOException{
            Date date=new Date(Integer.parseInt(y),Integer.parseInt(m),Integer.parseInt(d));
            return date;
        }
        
        public Date GetEndDate(String y,String m,String d) throws IOException{
            Date date=new Date(Integer.parseInt(y),Integer.parseInt(m),Integer.parseInt(d));
            return date;
        }
        
        public String GetCredit(String c1,String c2,String c3,String c4,String c5) throws IOException{
                return c1+"/"+c2+"/"+c3+"/"+c4+"/"+c5;
        }
        
        public String GetCount(String c1,String c2,String c3,String c4,String c5) throws IOException{
                return c1+"/"+c2+"/"+c3+"/"+c4+"/"+c5;
        }
        
    @FXML
    //删除策略
	public void DeleteStrategy() throws IOException{
		all.getChildren().clear();
		add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/DeleteStrategy.fxml").toURL()));
                all.getChildren().add(add );
	}
        
        public void clickDeleteStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(dname.getText());
                
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).removeStrategy(vo);
                if(rm==ResultMessage.Success){
                    result.setText("删除成功");
                }else{
                    result.setText("删除失败");
                }
        }
        
        //修改策略内容
        public void ChangeStrategy() throws IOException{
            all.getChildren().clear();
            add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeStrategy.fxml").toURL()));
              all.getChildren().add(add );
            
            
        }
        
                   
        //修改会员等级制度
        public void ChangeLevelStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeLevelStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(Cname.getText());
                clname.setText(vo.getName());
                String list[]=vo.getEnterprise().split("/");
                ccredit1.setText(list[0]);
                ccredit2.setText(list[1]);
                ccredit3.setText(list[2]);
                ccredit4.setText(list[3]);
                ccredit5.setText(list[4]);
        }
        
        public void clickChangeLevelStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(clname.getText());
                StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),GetCredit(ccredit1.getText(),ccredit2.getText(),ccredit3.getText(),ccredit4.getText(),ccredit5.getText()),vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),vo.getArea(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
                StrategyVO VO=new StrategyVO(po);
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO);
                if(rm==ResultMessage.Success){
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
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(Cname.getText());
                cdname.setText(vo.getName());
                String bd=""+vo.getStartDate();
                String ed=""+vo.getEndDate();
                String listb[]=bd.split("/");
                String liste[]=ed.split("/");
                cdiscount.setText(""+vo.getCount());
                cbeginyear.setText(listb[0]);
                cbeginmonth.setText(listb[1]);
                cbeginday.setText(listb[2]);
                cendyear.setText(liste[0]);
                cendmonth.setText(liste[1]);
                cendday.setText(liste[2]);
        }
        
        public void clickChangeDateStrategyR() throws IOException{
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(Cname.getText());
                StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),vo.getEnterprise(),vo.getRoomNumber(),GetBeginDate(cbeginyear.getText(),cbeginmonth.getText(),cbeginday.getText()),GetEndDate(cendyear.getText(),cendmonth.getText(),cendday.getText()),vo.getArea(),vo.getLevel(),Double.parseDouble(cdiscount.getText()),vo.getStrategyType());
                StrategyVO VO=new StrategyVO(po);
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).modifyStrategy(VO);
                if(rm==ResultMessage.Success){
                    result.setText("修改特殊时段优惠策略成功");
                }else{
                    result.setText("修改失败");
                }
        
        }       
        
        //修改VIP商圈优惠策略
        public void ChangeVipandAreaStrategy() throws IOException{
                carea.getItems().addAll("鼓楼","栖霞","建邺","浦口","玄武");
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/ChangeVipandAreaStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(Cname.getText());
                cvname.setText(vo.getName());
                String list[]=vo.getEnterprise().split("/");
                ccount1.setText(list[0]);
                ccount2.setText(list[1]);
                ccount3.setText(list[2]);
                count4.setText(list[3]);
                ccount5.setText(list[4]);
                
        }
          
        public void clickChangeVipandAreaStrategyR() throws IOException{
                carea.getItems().addAll("鼓楼","栖霞","建邺","浦口","玄武");
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id, Start.person.role).getStrategy(cvname.getText());
                StrategyPO po=new StrategyPO(vo.getID(),vo.getUserRole(),vo.getName(),GetCount(ccount1.getText(),ccount2.getText(),ccount3.getText(),ccount4.getText(),ccount5.getText()),vo.getRoomNumber(),vo.getStartDate(),vo.getEndDate(),carea.getValue(),vo.getLevel(),vo.getCount(),vo.getStrategyType());
                StrategyVO VO=new StrategyVO(po);
                ResultMessage rm=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).modifyStrategy(VO);
                if(rm==ResultMessage.Success){
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
              all.getChildren().add(add );
        }
        //取得会员等级制度
        public void GetLevelStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetLevelStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(Gname.getText());             
                    glname.setText(vo.getName());
                    String list[]=vo.getEnterprise().split("/");
                    gcredit1.setText(list[0]);
                    gcredit2.setText(list[1]);
                    gcredit3.setText(list[2]);
                    gcredit4.setText(list[3]);
                    gcredit5.setText(list[4]);                                   
        }
        //取得特殊时段优惠策略
        public void GetDateStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetDateStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(Gname.getText());
                    gdname.setText(vo.getName());
                    String bd=""+vo.getStartDate();
                    String ed=""+vo.getEndDate();
                    String listb[]=bd.split("/");
                    String liste[]=ed.split("/");
                    gdiscount.setText(""+vo.getCount());
                    gbeginyear.setText(listb[0]);
                    gbeginmonth.setText(listb[1]);
                    gbeginday.setText(listb[2]);
                    gendyear.setText(liste[0]);
                    gendmonth.setText(liste[1]);
                    gendday.setText(liste[2]);
                       
        }
        
        //取得VIP商圈优惠策略
        public void GetVipandAreaStrategy() throws IOException{
                all.getChildren().clear();
                add=FXMLLoader.load((new File("src/main/java/client/UI/SaleMan/Strategy/GetVipandAreaStrategy.fxml").toURL()));
                all.getChildren().add(add);
                StrategyVO vo=StrategyFactory.getStrategyController(Start.person.id,Start.person.role).getStrategy(Gname.getText());
                    gvname.setText(vo.getName());
                    String list[]=vo.getEnterprise().split("/");
                    gcount1.setText(list[0]);
                    gcount2.setText(list[1]);
                    gcount3.setText(list[2]);
                    gcount4.setText(list[3]);
                    gcount5.setText(list[4]);
               
        }
        
}
