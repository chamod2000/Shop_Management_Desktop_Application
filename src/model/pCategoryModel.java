/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;

/**
 *
 * @author Acer
 */
public class pCategoryModel {
     static Logger log = Logger.getLogger(pCategoryModel.class.getName());
   
    Connection con;

    public pCategoryModel() {
        con = db.dbConnection.getconnection();
    }

    public String updateCate(String id, String name) {
       String msg;
       String updateQuary="UPDATE pcgadguestshop.category SET categor_name=? WHERE id_category=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1, name);
            ps.setString(2, id);
           
            
            ps.execute();
            msg="Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Cannot Update Category Name Alredy exsist";
           
        }
        return msg;
        
    }

    public String deletecate(String id) {
       String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.category WHERE id_category=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, id);
            ps.execute();
            msg="successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
             msg="Somthing Wrong Plase Chack Again";
        }
        return msg;
    }

    public void loadtable(String keyword, DefaultTableModel categorytdm) {
        String loadtb = "SELECT * FROM pcgadguestshop.category WHERE categor_name like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            categorytdm.setRowCount(0);
            while (rs.next()) {

               String idc = rs.getString("id_category");
                String catName = rs.getString("categor_name");
                

                rowData = new Object[]{idc,catName};
                categorytdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String insertcate(String name) {
          String msg;
       String insertQuery ="INSERT INTO pcgadguestshop.category(categor_name)VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,name);
            
            ps.execute();
            msg="Successfully Updated";
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="Cannot Insert Category Name Alredy exsist";
        }
       return msg;
        
    }

    public Object[] getselectid(String cid) {
       String getData ="SELECT * FROM pcgadguestshop.category WHERE id_category =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               String idcat = rs.getString("id_category");
               String catename = rs.getString("categor_name");
               
               
               rowData = new Object[]{idcat,catename};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return null;
    }
    
    
}
