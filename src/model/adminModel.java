
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;


public class adminModel {
      static Logger log = Logger.getLogger(adminModel.class.getName());
  
    Connection con;

    public adminModel() {
        con= db.dbConnection.getconnection();
    }

    public String insertAdmin(String username, String password, String usertype) {
       String msg;
       String insertQuery ="INSERT INTO pcgadguestshop.admin(username, password,usertype)VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,usertype);
            ps.execute();
            msg="Success";
            
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="error"+e.getMessage();
        }
       return null;
    }

    public void loadtableAdmin(String keyword, DefaultTableModel admintdm) {
         
        String loadtb = "SELECT * FROM pcgadguestshop.admin WHERE username like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            admintdm.setRowCount(0);
            while (rs.next()) {

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String usertype = rs.getString("usertype");
                

                rowData = new Object[]{id, username, password,usertype};
                admintdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Object[] getSelectId(int adminId) {
     
        String getData ="SELECT * FROM pcgadguestshop.admin WHERE id =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setInt(1, adminId);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               int adminid = rs.getInt("id");
               String username = rs.getString("username");
               String password = rs.getString("password");
               String usertype = rs.getString("usertype");
               rowData = new Object[]{adminid,username,password,usertype};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
        }
        return null;
        
    }

    public String updateadmin(String aId, String username, String password, String usertype) {
       String msg;
       String updateQuary="UPDATE pcgadguestshop.admin SET username=?, password=?,usertype=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, usertype);
            ps.setString(4, aId);
            ps.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error"+e.getMessage();
            log.debug(e.getMessage());
        }
        return null;
    }

    public String deleteAdmin(String aId) {
        
        String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.admin WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, aId);
            ps.execute();
            msg="success";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
             msg="Error"+e.getMessage();
        }
        return null;
        }
    
    
    
}
