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
public class postModel {
     static Logger log = Logger.getLogger(postModel.class.getName());
   
    Connection con;

    public postModel() {
        con = db.dbConnection.getconnection();
    }

    public String insertpost(String postname, String salary) {
       
          String msg;
       String insertQuery ="INSERT INTO pcgadguestshop.posts(post, salary)VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,postname);
            ps.setString(2,salary);
            ps.execute();
            msg="Successfully Insert!";
            
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="Post Already Using!";
        }
       return msg;
        
    }

    public void loadtablepost(String keyword, DefaultTableModel posttdm) {
       
        String loadtb = "SELECT * FROM pcgadguestshop.posts WHERE post like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            posttdm.setRowCount(0);
            while (rs.next()) {

                int id = rs.getInt("id_post");
                String postname = rs.getString("post");
                String postsalary = rs.getString("salary");
                

                rowData = new Object[]{id, postname, postsalary};
                posttdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
        }
        
    }

   

    public String deletepost(String postId) {
   
        String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.posts WHERE id_post=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, postId);
            ps.execute();
            msg="successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
             msg="Somthing wrong check Input Fileds";
        }
        return msg;
     
    }

    public String updatepost(String postId, String postname, String salary) {
        
        String msg;
       String updateQuary="UPDATE pcgadguestshop.posts SET post=?, salary=? WHERE id_post=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1, postname);
            ps.setString(2, salary);
            ps.setString(3, postId);
            ps.execute();
            msg="Successfully Updated!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "This post Name Already Using!";
           
        }
        return msg;
    
    }

    public Object[] getSelectId(int postID) {
   
         String getData ="SELECT * FROM pcgadguestshop.posts WHERE id_post =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setInt(1, postID);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               String postid = rs.getString("id_post");
               String postname = rs.getString("post");
               String postsalary = rs.getString("salary");
               
               rowData = new Object[]{postID,postname,postsalary};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
