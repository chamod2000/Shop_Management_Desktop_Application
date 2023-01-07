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
public class accessoryModel {
    static Logger log = Logger.getLogger(accessoryModel.class.getName());
    
    Connection con;

    public accessoryModel() {
        con=db.dbConnection.getconnection();
    }

    public String insertAcc(String accname) {
        String msg;
       String insertQuery ="INSERT INTO pcgadguestshop.pcaccerserise(name)VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,accname);
            ps.execute();
            msg="Successfully Insert!";
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="Accessory part Already Using!";
        }
       return msg;
    }

    

    public String deleteAcc(String accid) {
       String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.pcaccerserise WHERE id_pcaccerserise=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, accid);
            ps.execute();
            msg="successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
             msg="Somthing wrong check Input Fileds";
        }
        return msg;
    }

    public void loadtable(String keyword, DefaultTableModel accessorytdm) {
        String loadtb = "SELECT * FROM pcgadguestshop.pcaccerserise WHERE name like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            accessorytdm.setRowCount(0);
            while (rs.next()) {

                int id = rs.getInt("id_pcaccerserise");
                String name = rs.getString("name");
                
                

                rowData = new Object[]{id,name};
                accessorytdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getselectid(int id) {
         String getData ="SELECT * FROM pcgadguestshop.pcaccerserise WHERE id_pcaccerserise =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
                String idacc = rs.getString("id_pcaccerserise");
                String name = rs.getString("name");
               
               rowData = new Object[]{idacc,name};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateacc(String vaccidd, String vaccnamee) {
        String msg="";
        String update = "UPDATE pcgadguestshop.pcaccerserise SET name=? WHERE id_pcaccerserise=?";
        try {
            PreparedStatement ps = con.prepareStatement(update);
           
            ps.setString(1, vaccnamee);
             ps.setString(2, vaccidd);
            ps.execute();
            msg="Scussessfully Updated!";
        } catch (Exception e) {
            log.debug(e.getMessage());
            e.printStackTrace();
            msg="Cannot updated Accessoty name already taken!";
        }
        return msg;
    }

    
    
}
