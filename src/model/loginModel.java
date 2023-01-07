/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gui.home;
import gui.logingpage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class loginModel {

    Connection con;

    public loginModel() {
        con = db.dbConnection.getconnection();
    }

    public String login(String username, String password) {

        String search = "SELECT usertype FROM pcgadguestshop.admin WHERE username =? AND password =?";
        String usertype = "";
        String user = "";
        logingpage p = new logingpage();
        home hbm = new home();
        try {
            PreparedStatement ps = con.prepareStatement(search);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usertype = rs.getString("usertype");
                System.out.println(usertype);
        }
                if (usertype.equals("o")) {

                    hbm.setVisible(true);
                    usertype = "Wellcome Admin";

                } else if (usertype.equals("m")) {

                    hbm.adminbt.setEnabled(false);                  
                    hbm.setVisible(true);
                    usertype = "Wellcome Manger";

                } else if (usertype.equals("c")) {
                    hbm.adminbt.setEnabled(false);
                    hbm.supplierbt.setEnabled(false);
                    hbm.databasebt.setEnabled(false);
                    hbm.jButton1.setEnabled(false);
                    hbm.jButton4.setEnabled(false);
                    usertype = "Wellcome Cachier";
                    hbm.setVisible(true);

                }  else {
               usertype  = "Check Username and password";
               p.setVisible(true);
                 
            }

           
        } catch (Exception e) {
            e.printStackTrace();
        }
      return usertype;
    }
}
