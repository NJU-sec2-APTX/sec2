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
        final SimpleStringProperty orderID = new SimpleStringProperty();
        final SimpleStringProperty hotel = new SimpleStringProperty();
        final SimpleStringProperty makeTime = new SimpleStringProperty();
        final SimpleStringProperty executeTime = new SimpleStringProperty();
        final SimpleStringProperty orderStatue = new SimpleStringProperty();
         OrderShow(String id, String hotelstr, String make,String execute,String statue) {
             orderID.set(id);
             hotel.set(hotelstr);
             makeTime.set(make);
             executeTime.set(execute);
             orderStatue.set(statue);
       }

}
