package server.dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import common.dataService.StrategyDataService;
import common.otherEnumClasses.ResultMessage;
import common.otherEnumClasses.StrategyType;
import common.otherEnumClasses.UserRole;
import common.po.StrategyPO;
import common.vo.StrategyVO;

public class StrategyDataServiceImpl extends UnicastRemoteObject implements StrategyDataService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8831632291308378492L;
	
	public StrategyDataServiceImpl() throws RemoteException {
	}
	
	DBHelper databasehelper;
	ResultSet resultset;
	String sql;
	
	@SuppressWarnings("deprecation")
	public ResultMessage insert(StrategyPO spo){
		try {
			if(spo.getStrategyType()==StrategyType.MemberLevel){
				sql="select * from strategy where strategytype='MemberLevel';";
				databasehelper=new DBHelper(sql);
				resultset=databasehelper.pst.executeQuery();
				if(resultset.next()){
					return ResultMessage.Failure;
				}
			}
			sql="insert into strategy(id,userrole,name,strategytype,room,startdate,enddate,level,count,enterprise,area)"+
				"value('"+spo.getID()+"','"+spo.getUserRole()+"','"+spo.getName()+"','"+spo.getStrategyType()+"',";
			sql+=spo.getRoomNumber()+",";
			if(spo.getStartDate()==null){
				sql+="null,";
			}else{
				sql+="'"+(spo.getStartDate().getYear()+1900)+"-"+(spo.getStartDate().getMonth()+1)+"-"+spo.getStartDate().getDate()+"',";
			}
			if(spo.getEndDate()==null){
				sql+="null,";
			}else{
				sql+="'"+(spo.getEndDate().getYear()+1900)+"-"+(spo.getEndDate().getMonth()+1)+"-"+spo.getEndDate().getDate()+"',";
			}
			sql+=spo.getLevel()+","+spo.getCount()+",'"+spo.getEnterprise()+"','"+spo.getArea()+"');";
			databasehelper=new DBHelper(sql);
			databasehelper.pst.execute(sql);
			return ResultMessage.Success;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	@SuppressWarnings("deprecation")
	public ResultMessage update(String ID,String name,StrategyPO po){
		sql="update strategy set name='"+po.getName()+"',userrole='"+po.getUserRole()+"',strategytype='"+po.getStrategyType()+"',room="+po.getRoomNumber()+",startdate=";
		if(po.getStartDate()==null){
			sql+="null,enddate=";
		}else{
			sql+="'"+(po.getStartDate().getYear()+1900)+"-"+(po.getStartDate().getMonth()+1)+"-"+po.getStartDate().getDate()+"',enddate=";
		}
		if(po.getEndDate()==null){
			sql+="null,level=";
		}else{
			sql+="'"+(po.getEndDate().getYear()+1900)+"-"+(po.getEndDate().getMonth()+1)+"-"+po.getEndDate().getDate()+"',level=";
		}
		sql+=po.getLevel()+",count="+po.getCount()+",enterprise='"+po.getEnterprise()+"',area='"+po.getArea()+"' where id='"
				+ID+"'&&name='"+name+"';";
		databasehelper=new DBHelper(sql);
		try {
			databasehelper.pst.execute(sql);
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage delete(StrategyPO spo){
		sql="delete from strategy where id='"+spo.getID()+"'&&name='"+spo.getName()+"';";
		databasehelper=new DBHelper(sql);
		try {
			databasehelper.pst.execute(sql);
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
//	String id,UserRole ur,String strategy_name,ArrayList<String> enterpriseList,int roomNumber,
//	Date start_date,Date end_date,ArrayList<String> businessarea,int level,double count,boolean IsBirthday
	public ArrayList<StrategyVO> CalAll(){
		sql="select * from strategy where name !='MemberLevel';";
		ArrayList<StrategyVO> allStrategy=null;
		try {
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery(sql);
			if(resultset.next()){
				allStrategy=new ArrayList<StrategyVO>();
				do{
					String name=null;
					String ID=resultset.getString(1);
					UserRole ur=UserRole.getUserRole(resultset.getString(2));
					StrategyType type=null;
					int room=0;
					Date startdate=null;
					Date enddate=null;
					int level=0;
					double count=0;
					String enterprise=null;
					String area=null;
					if(resultset.getString(3)!=null){
						name=resultset.getString(3);
					}
					if(resultset.getString(4)!=null){
						type=StrategyType.getType(resultset.getString(4));
					}
					if(resultset.getString(5)!=null){
						room=resultset.getInt(5);
					}
					if(resultset.getString(6)!=null){
						startdate=resultset.getDate(6);
					}
					if(resultset.getString(7)!=null){
						enddate=resultset.getDate(7);
					}
					if(resultset.getString(8)!=null){
						level=resultset.getShort(8);
					}
					if(resultset.getString(9)!=null){
						count=resultset.getDouble(9);
					}
					if(resultset.getString(10)!=null){
						enterprise=resultset.getString(10);
					}
					if(resultset.getString(11)!=null){
						area=resultset.getString(11);
					}
					StrategyPO po=new StrategyPO(ID,ur,name,enterprise,room,startdate,
							enddate,area,level,count,type);
					allStrategy.add(new StrategyVO(po));
				}while(resultset.next());
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allStrategy;
	}
	
	public ArrayList<StrategyVO> findAll(String ID,UserRole ur){
		sql="select * from strategy where id='"+ID+"'&&userrole='"+ur+"';";
		ArrayList<StrategyVO> allStrategy=null;
		try {
			databasehelper=new DBHelper(sql);
			resultset=databasehelper.pst.executeQuery(sql);
			if(resultset.next()){
				allStrategy=new ArrayList<StrategyVO>();
				do{
					String name=null;
					StrategyType type=null;
					int room=0;
					Date startdate=null;
					Date enddate=null;
					int level=0;
					double count=0;
					String enterprise=null;
					String area=null;
					if(resultset.getString(3)!=null){
						name=resultset.getString(3);
					}
					if(resultset.getString(4)!=null){
						type=StrategyType.getType(resultset.getString(4));
					}
					if(resultset.getString(5)!=null){
						room=resultset.getInt(5);
					}
					if(resultset.getString(6)!=null){
						startdate=resultset.getDate(6);
					}
					if(resultset.getString(7)!=null){
						enddate=resultset.getDate(7);
					}
					if(resultset.getString(8)!=null){
						level=resultset.getShort(8);
					}
					if(resultset.getString(9)!=null){
						count=resultset.getDouble(9);
					}
					if(resultset.getString(10)!=null){
						enterprise=resultset.getString(10);
					}
					if(resultset.getString(11)!=null){
						area=resultset.getString(11);
					}
					StrategyPO po=new StrategyPO(ID,ur,name,enterprise,room,startdate,
							enddate,area,level,count,type);
					allStrategy.add(new StrategyVO(po));
				}while(resultset.next());
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return allStrategy;
	}
	//其实都不用find，只要一开始findall就可以，然后在里面查找，只要每次更新都调用findall就ok


}
