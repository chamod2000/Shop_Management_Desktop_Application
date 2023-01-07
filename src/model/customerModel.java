 
package model;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;

public class customerModel {
       static Logger log = Logger.getLogger(customerModel.class.getName());
   
    Connection con;

    public customerModel() {
        
        con= db.dbConnection.getconnection();
    }

    public String insertCustomer(String customername, String customerModile) {
         String msg;
       String insertQuery ="INSERT INTO pcgadguestshop.customer(customer_mobile, customer_name)VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,customerModile);
            ps.setString(2,customername);
            ps.execute();
            msg="Successfully Insert Customer";
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="Mobile Number Already taken!";
            
        }
       return msg;
        
    }

    public void loadtableAdmin(String keyword, DefaultTableModel customertdm) {
          String loadtb = "SELECT * FROM pcgadguestshop.customer WHERE customer_mobile like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            customertdm.setRowCount(0);
            while (rs.next()) {

               String idCustomer = rs.getString("id_customer");
                String customerMobile = rs.getString("customer_mobile");
                String customername = rs.getString("customer_name");
                

                rowData = new Object[]{idCustomer,customerMobile, customername};
                customertdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }

     

    public Object[] getSelectId(String cusId) {
        String getData ="SELECT * FROM pcgadguestshop.customer WHERE id_customer =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, cusId);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               String idCustomer = rs.getString("id_customer");
               String customerMobile = rs.getString("customer_mobile");
               String customerName = rs.getString("customer_name");
               
               rowData = new Object[]{idCustomer,customerMobile,customerName};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }


    

    public String updateCustomer(String cusId, String customername, String customerModile) {
     String msg;
       String updateQuary="UPDATE pcgadguestshop.customer SET customer_mobile=?, customer_name=? WHERE id_customer=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1, customerModile);
            ps.setString(2, customername);
            ps.setString(3, cusId);
            
            ps.execute();
            msg="Successfully Updated Customer";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Cannot Update Mobile Number Already taken!";
           
        }
        return msg;
    }

    public String deleteCustomer(String cusId) {
       String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.customer WHERE id_customer=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, cusId);
            ps.execute();
            msg="Successfully Delete Customer";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
             msg="Error"+e.getMessage();
        }
        return msg;
    }
    }
        
          

    
        
        
        
    
    

