/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Member.OrderBrowse;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author zhuyingshan
 */
public class OrderShow {
       private final SimpleStringProperty orderID = new SimpleStringProperty();
       private final SimpleStringProperty hotel = new SimpleStringProperty();
       private final SimpleStringProperty makeTime = new SimpleStringProperty();
       private final SimpleDoubleProperty executeTime = new SimpleDoubleProperty();
       private final SimpleStringProperty orderStatue = new SimpleStringProperty();
        public OrderShow(String id, String hotel, String make,String execute,String statue) {
           setOrderStatue(statue);
           setOrderID(id);
           setMakeTime(make);
           setExecuteTime(execute);
           setHotel(hotel);
       }

    private void setOrderStatue(String status) {
    }

    private void setOrderID(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setMakeTime(String dlSpeed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setExecuteTime(String progress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setHotel(String hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
