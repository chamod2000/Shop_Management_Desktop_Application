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



public class employeeModel {
     static Logger log = Logger.getLogger(employeeModel.class.getName());
   
    Connection con;

    public employeeModel() {
        con=db.dbConnection.getconnection();
    }

    public String insertemp(String empname, String empnaddress, String empmodile, String empoost, String empnic) {
     
         String msg="";
         String postid ="SELECT id_post FROM pcgadguestshop.posts WHERE post=?";
       String insertQuery ="INSERT INTO pcgadguestshop.emplyee(emp_name, emp_address, emp_mobile, posts_id_post, nic)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(postid);
            ps.setString(1,empoost);            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int ID = rs.getInt("id_post");
                System.out.println(ID);
                String postID = String.valueOf(ID);
                
                PreparedStatement ps2 = con.prepareStatement(insertQuery);
                ps2.setString(1, empname);
                ps2.setString(2, empnaddress);
                ps2.setString(3, empmodile);
                ps2.setString(4, postID);
                ps2.setString(5, empnic);
                ps2.execute();
                msg="Successfully Insert";
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="Employee number Already taken";
        }
       return msg;
        
    }

    public String deleteemp(String empId) {
      
         String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.emplyee WHERE idemplyee=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, empId);
            ps.execute();
            msg="Employee Deleted";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
             msg="Cannot Delete Employee,Employee Id Already using";
        }
        return msg;
    }

    public String updateemp(String empId, String empname, String empnaddress, String empmodile, String empoost, String empnic) {
        
         String msg="";
         String postid ="SELECT id_post FROM pcgadguestshop.posts WHERE post=?";
       String updateQuary="UPDATE pcgadguestshop.emplyee SET emp_name=?, emp_address=?, emp_mobile=?, posts_id_post=?, nic=? WHERE idemplyee=?";
        try {
             PreparedStatement ps = con.prepareStatement(postid);
            ps.setString(1,empoost);            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int ID = rs.getInt("id_post");
                System.out.println(ID);
                String postID = String.valueOf(ID);
                
                PreparedStatement ps2 = con.prepareStatement(updateQuary);
                ps2.setString(1, empname);
                ps2.setString(2, empnaddress);
                ps2.setString(3, empmodile);
                ps2.setString(4, postID);
                 ps2.setString(5, empnic);
                ps2.setString(6, empId);
                ps2.execute();
                msg="Successfully updated";
                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Cannot Updated Mobile Numer already taken";
           
        }
        return msg;
        
    }

    public void loadtableEmp(String keyword, DefaultTableModel emptdm) {
       
        String loadtable = "SELECT posts.post,emplyee.idemplyee,emplyee.emp_name,emplyee.emp_address,emplyee.nic,"
                + "emplyee.emp_mobile,emplyee.posts_id_post,posts.id_post FROM emplyee INNER JOIN posts ON emplyee.posts_id_post = posts.id_post WHERE emp_name like ? ";

        
        try {
            PreparedStatement ps = con.prepareStatement(loadtable);
            ps.setString(1, "%" + keyword + "%");
           
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            emptdm.setRowCount(0);
            while (rs.next()) {

               int empid = rs.getInt("idemplyee");
                String empname = rs.getString("emp_name");
                String empaddre = rs.getString("emp_address");
                String empmobile = rs.getString("emp_mobile");
               String emppost = rs.getString("post");   
                 String nic = rs.getString("nic");

                rowData = new Object[]{empid,empname,empaddre,empmobile,emppost,nic};
                emptdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getSelectId(int empID) {
      
         String getData ="SELECT * FROM pcgadguestshop.emplyee WHERE idemplyee = ?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setInt(1, empID);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               int empiid = rs.getInt("idemplyee");
               String empname = rs.getString("emp_name");
               String empaddress = rs.getString("emp_address");
               String empmobile = rs.getString("emp_mobile");
               String emppostid = rs.getString("posts_id_post");
               String nic = rs.getString("nic");
               
               
               String getpostname ="SELECT post FROM  pcgadguestshop.posts WHERE id_post=? ";
               PreparedStatement ps2 = con.prepareStatement(getpostname);
               ps2.setString(1, emppostid);
               ResultSet rs2 =ps2.executeQuery();
               while(rs2.next()){
               
                   String postname = rs2.getString("post");
                   System.out.println(postname);
                   emppostid=postname;
                   
                   
               rowData = new Object[]{empiid,empname,empaddress,empmobile,emppostid,nic};
               return rowData;
               }
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    
    }
    
    
    
}
