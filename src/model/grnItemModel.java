/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;

/**
 *
 * @author Acer
 */
public class grnItemModel {
      static Logger log = Logger.getLogger(grnItemModel.class.getName());
   
    Connection con;

    public grnItemModel() {
        con = db.dbConnection.getconnection();
    }

    public String insergrnitem(String pid,String qty, String buyprice, String grnid) {
       String msg;
       String getstockqty = "SELECT qty FROM pcgadguestshop.stocks WHERE product_id_product=?";
       String updateqty = "UPDATE pcgadguestshop.stocks SET qty=? WHERE product_id_product=?";
       String insertQuery ="INSERT INTO pcgadguestshop.grn_item(qty, buyprice, product_id_product, grn_id_grn)VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,qty);
            ps.setString(2,buyprice);
            ps.setString(3,pid);
            ps.setString(4,grnid);
           // ps.setDate(5,new java.sql.Date(grnMfd.getTime()));
            
            ps.execute();
            msg="Success";
            PreparedStatement ps2 = con.prepareStatement(getstockqty);
            ps2.setString(1, pid);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                int availableQty = rs2.getInt("qty");              
                int intqty = Integer.parseInt(qty);
                int newqty = availableQty+intqty;
                 
            PreparedStatement ps3 = con.prepareStatement(updateqty);
            ps3.setInt(1, newqty);
            ps3.setString(2, pid);
            ps3.execute();
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
              log.debug(e.getMessage());
            msg="error"+e.getMessage();
        }
       return msg;    
    }

    public String updategrnitem(String grnitemid, String pid, String qty, String buyprice, String grnid) {
          String msg;
           int updatedqty;
           int newupdatedqty;
           String getstockqty = "SELECT qty FROM pcgadguestshop.stocks WHERE product_id_product=?";
       String updateqty = "UPDATE pcgadguestshop.stocks SET qty=? WHERE product_id_product=?";
       String grnitemqty = "SELECT qty FROM pcgadguestshop.grn_item WHERE id_grn_item=?";
       String updateQuary="UPDATE pcgadguestshop.grn_item SET qty=?, buyprice=?, product_id_product=?, grn_id_grn=? WHERE id_grn_item=?";
        try {
            int newqty = Integer.parseInt(qty);
            
            PreparedStatement ps1 = con.prepareStatement(grnitemqty);
            ps1.setString(1, grnitemid);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
            int grnqty = rs.getInt("qty");
            
            PreparedStatement ps2 = con.prepareStatement(getstockqty);
            ps2.setString(1, pid);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
            int stockqty =rs2.getInt("qty");
            
            if(newqty>grnqty){
            updatedqty = newqty - grnqty;
            newupdatedqty = stockqty + updatedqty;
            
            }else if(grnqty>newqty){
                updatedqty = grnqty -newqty ;
              newupdatedqty = stockqty - updatedqty;
            }else{
                newupdatedqty = 0 + stockqty;
            }
            
                
            PreparedStatement ps3 = con.prepareStatement(updateqty);
            ps3.setInt(1, newupdatedqty);
            ps3.setString(2, pid);
            ps3.execute();
            
                
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1,qty);
            ps.setString(2,buyprice);
            ps.setString(3,pid);
            ps.setString(4,grnid);
           // ps.setDate(5,new java.sql.Date(grnMfd.getTime()));
            ps.setString(5,grnitemid); 
            ps.execute();
            msg="Success";
            } }
        } catch (Exception e) {
            e.printStackTrace();
              log.debug(e.getMessage());
            msg = "Error"+e.getMessage();
           
        }
        return null;
    }

    public String deletegrnitem(String grnitemid, String qty, String pid) {
        String msg;
        String getstockqty = "SELECT qty FROM pcgadguestshop.stocks WHERE product_id_product=?";
        String updateqty = "UPDATE pcgadguestshop.stocks SET qty=? WHERE product_id_product=?";
        String DeleteQueary ="DELETE FROM pcgadguestshop.grn_item WHERE id_grn_item=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, grnitemid);
            ps.execute();
            msg="success";
            
            PreparedStatement ps2 = con.prepareStatement(getstockqty);
            ps2.setString(1, pid);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                int availableQty = rs2.getInt("qty");              
                int intqty = Integer.parseInt(qty);
                int newqty = availableQty-intqty;
                 
            PreparedStatement ps3 = con.prepareStatement(updateqty);
            ps3.setInt(1, newqty);
            ps3.setString(2, pid);
            ps3.execute();
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
              log.debug(e.getMessage());
             msg="Error"+e.getMessage();
        }
        return null;
    }

    public void loadtable(String keyword, DefaultTableModel grnitemtdm) {
         String loadtb = "SELECT grn_item.id_grn_item,grn_item.qty,grn_item.buyprice,grn_item.product_id_product,"
                 + "grn_item.grn_id_grn,product.id_product,pcgadguestshop.product.productname FROM pcgadguestshop.product INNER JOIN pcgadguestshop.grn_item ON "
                 + "pcgadguestshop.grn_item.product_id_product = pcgadguestshop.product.id_product WHERE grn_id_grn like ?";
//         String loadtb = "SELECT pcgadguestshop.grn_item.id_grn_item,\n" +
//"	pcgadguestshop.grn_item.qty,\n" +
//"	pcgadguestshop.grn_item.buyprice,\n" +
//"	pcgadguestshop.grn_item.product_id_product,\n" +
//"	pcgadguestshop.grn_item.grn_id_grn,\n" +
//"	pcgadguestshop.product.id_product,\n" +
//"	pcgadguestshop.product.productname\n" +
//"FROM pcgadguestshop.product\n" +
//"	INNER JOIN pcgadguestshop.grn_item ON \n" +
//"	 pcgadguestshop.grn_item.product_id_product = pcgadguestshop.product.id_product WHERE grn_id_grn like ?";

         try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            grnitemtdm.setRowCount(0);
            while (rs.next()) {

               String id = rs.getString("id_grn_item");
                String  name = rs.getString("productname");
                String  qty = rs.getString("qty");
                String  buyprice = rs.getString("buyprice");
                String  grnid = rs.getString("grn_id_grn");
                //Date mfdDate = rs.getDate("mfd");

                rowData = new Object[]{id,name,qty,buyprice,grnid};
                grnitemtdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getselectid(String grnitemid) {
         String getData ="SELECT * FROM pcgadguestshop.grn_item WHERE id_grn_item =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, grnitemid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
              String id = rs.getString("id_grn_item");
                String  pname = rs.getString("product_id_product");
                String  qty = rs.getString("qty");
                String  buyprice = rs.getString("buyprice");
                String  grnid = rs.getString("grn_id_grn");
               //Date mfdDate = rs.getDate("mfd");
               
               rowData = new Object[]{id,pname,qty,buyprice,grnid};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
    

