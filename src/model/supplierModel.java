
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;


public class supplierModel {
    static Logger log = Logger.getLogger(supplierModel.class.getName());
   
    Connection con;

    public supplierModel() {
        con = db.dbConnection.getconnection();
    }

    public String inserSuplier(String sname, String sMbile, String sEmail) {
           String msg;
       String insertQuery ="INSERT INTO pcgadguestshop.suplier(sup_name, sup_mobile, email)VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,sname);
            ps.setString(2,sMbile);
            ps.setString(3,sEmail);
            
            ps.execute();
            msg="Successfully Insert Supplier";
            
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="Mobile Number Aready taken!";
        }
       return msg;     
    }

    public String updateSuplier(String sid, String sname, String sMbile, String sEmail) {
        String msg;
       String updateQuary="UPDATE pcgadguestshop.suplier SET sup_name=?, sup_mobile=?, email=? WHERE id_suplier=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1,sname);
            ps.setString(2,sMbile);
            ps.setString(3,sEmail);
            ps.setString(4,sid);
            
            ps.execute();
            msg="Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg = "Mobile Number Aready taken!";
           
        }
        return msg;
    }

    public String deleteSuplier(String sid) {
         String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.suplier WHERE id_suplier=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, sid);
            ps.execute();
            msg="successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
             msg="Cannot Delete,Supplier Number Already Using";
        }
        return null;
    }

    public void loadtable(String keyword, DefaultTableModel supliertdm) {
        String loadtb = "SELECT * FROM pcgadguestshop.suplier WHERE sup_name like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            supliertdm.setRowCount(0);
            while (rs.next()) {

               String id = rs.getString("id_suplier");
                String  name = rs.getString("sup_name");
                String  mobile = rs.getString("sup_mobile");
                String  email = rs.getString("email");
                

                rowData = new Object[]{id,name,mobile,email};
                supliertdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] detselectid(String sid) {
       String getData ="SELECT * FROM pcgadguestshop.suplier WHERE id_suplier =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               String id = rs.getString("id_suplier");
                String  name = rs.getString("sup_name");
                String  mobile = rs.getString("sup_mobile");
                String  email = rs.getString("email");
               
               
               rowData = new Object[]{id,name,mobile,email};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
