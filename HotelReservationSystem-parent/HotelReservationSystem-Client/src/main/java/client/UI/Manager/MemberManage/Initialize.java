/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UI.Manager.MemberManage;

import javafx.scene.control.ChoiceBox;

/**
 *
 * @author 叶枫
 */
public class Initialize {
    public void initialize(ChoiceBox<String> cb){
        cb.getItems().addAll("个人客户","企业客户","酒店工作人员","网站营销人员","网站管理人员");
    }
}
