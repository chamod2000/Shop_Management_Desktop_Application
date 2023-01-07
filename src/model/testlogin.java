
package model;

import gui.home;
import gui.logingpage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class testlogin {

    static Logger log = Logger.getLogger(testlogin.class.getName());
    Connection con;

    public testlogin() {
        con = db.dbConnection.getconnection();
    }

    public String login(String username, String password) {
        String search = "SELECT usertype FROM pcgadguestshop.admin WHERE username =? AND password =?";
        String usertype = "";

        try {
            PreparedStatement ps = con.prepareStatement(search);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usertype = rs.getString("usertype");

            }

        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            usertype = "Error";
        }
        return usertype;
    }

}
