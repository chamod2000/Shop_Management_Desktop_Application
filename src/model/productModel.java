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
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;

/**
 *
 * @author Acer
 */
public class productModel {
     static Logger log = Logger.getLogger(productModel.class.getName());
   
    Connection con;

    public productModel() {
        con=db.dbConnection.getconnection();
    }

    public String insertpro(String pname,String psellprice,String pcategory,String pacc) {
        String msg="";
        String getcatid ="SELECT * FROM pcgadguestshop.category WHERE categor_name =?";
        String getaccessoryid ="SELECT * FROM pcgadguestshop.pcaccerserise WHERE name =?";
       String insertQuery ="INSERT INTO pcgadguestshop.product(productname, sell_price, category_id_category, pcaccerserise_id_pcaccerserise)VALUES(?,?,?,?)";
        try {
            PreparedStatement ps1=con.prepareStatement(getcatid);
            ps1.setString(1, pcategory);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
            int categoryid = rs.getInt("id_category");
                System.out.println(categoryid);
                
            PreparedStatement ps3 = con.prepareStatement(getaccessoryid);
            ps3.setString(1, pacc);
                System.out.println("accse"+pacc);
            ResultSet r2 =ps3.executeQuery();
            while(r2.next()){
                int accid = r2.getInt("id_pcaccerserise");
                System.out.println(accid);
                                  
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,pname);
            ps.setString(2,psellprice);
            ps.setInt(3, categoryid);
            ps.setInt(4, accid);
            
            ps.execute();
            msg="Successfully Insert";
            }
            }   
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="Something Wrong Please Chack Input Data";
        }
       return msg;
    }

    public String updatepro(String pid, String pname,String psellprice,String pcategory, String pacc) {
        String msg="";
          String getcatid ="SELECT * FROM pcgadguestshop.category WHERE categor_name =?";
          String getaccessoryid ="SELECT * FROM pcgadguestshop.pcaccerserise WHERE name =?";
       String updateQuery ="UPDATE pcgadguestshop.product SET productname=?, sell_price=?, category_id_category=?, pcaccerserise_id_pcaccerserise=? WHERE id_product=?";
   
        
       try {
            PreparedStatement ps1=con.prepareStatement(getcatid);
            ps1.setString(1, pcategory);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
            int categoryid = rs.getInt("id_category");  
            
            
            PreparedStatement ps3 = con.prepareStatement(getaccessoryid);
            ps3.setString(1, pacc);
            ResultSet r2 =ps3.executeQuery();
            while(r2.next()){
                int accid = r2.getInt("id_pcaccerserise");
                System.out.println(accid);
            
            
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(1,pname);
            ps.setString(2,psellprice);
            ps.setInt(3, categoryid);
            ps.setInt(4, accid);
            ps.setString(5, pid);
            
            ps.execute();
            msg="Successfully Updated";
            }
            }   
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="Something Wrong Please Chack Input Data";
        }
       return msg;
    }

    public String deletepro(String pid) {
         String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.product WHERE id_product=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, pid);
            ps.execute();
            msg="successfully Deleted";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
             msg="Something Wrong Please Chack Input Data";
        }
        return msg;
    }

    public void loadtable(String keyword, DefaultTableModel producttdm) {
        
         String loadtb = "SELECT pcgadguestshop.product.id_product,product.productname,product.sell_price,product.category_id_category,"
                 + "product.pcaccerserise_id_pcaccerserise,category.id_category,category.categor_name,"
                 + "pcaccerserise.id_pcaccerserise,pcaccerserise.name FROM pcgadguestshop.product INNER JOIN pcgadguestshop.pcaccerserise ON pcgadguestshop.product.pcaccerserise_id_pcaccerserise = pcgadguestshop.pcaccerserise.id_pcaccerserise "
                 + "INNER JOIN pcgadguestshop.category ON "
                 + " pcgadguestshop.category.id_category = pcgadguestshop.product.category_id_category WHERE productname like ?";
//         String loadtb = "SELECT pcgadguestshop.product.id_product,\n" +
//"	pcgadguestshop.product.productname,\n" +
//"	pcgadguestshop.product.sell_price,\n" +
//"	pcgadguestshop.product.category_id_category,\n" +
//"	pcgadguestshop.product.pcaccerserise_id_pcaccerserise,\n" +
//"	pcgadguestshop.category.id_category,\n" +
//"	pcgadguestshop.category.categor_name,\n" +
//"	pcgadguestshop.pcaccerserise.id_pcaccerserise,\n" +
//"	pcgadguestshop.pcaccerserise.name\n" +
//"FROM pcgadguestshop.product\n" +
//"	INNER JOIN pcgadguestshop.pcaccerserise ON \n" +
//"	 pcgadguestshop.product.pcaccerserise_id_pcaccerserise = pcgadguestshop.pcaccerserise.id_pcaccerserise \n" +
//"	INNER JOIN pcgadguestshop.category ON \n" +
//"	 pcgadguestshop.category.id_category = pcgadguestshop.product.category_id_category WHERE productname like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            producttdm.setRowCount(0);
            while (rs.next()) {

               String productid = rs.getString("id_product");
                String name = rs.getString("productname");
                String price = rs.getString("sell_price");

                String catid = rs.getString("categor_name");
                String accid = rs.getString("name");
                

                rowData = new Object[]{productid,name,price,catid,accid};
                producttdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public Object[] getselectid(String proid) {
       
         String getData ="SELECT * FROM pcgadguestshop.product WHERE id_product = ?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, proid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               int prodid = rs.getInt("id_product");
               String proname = rs.getString("productname");
               String productsell = rs.getString("sell_price");
               String cid = rs.getString("category_id_category");
               String accid = rs.getString("pcaccerserise_id_pcaccerserise");
              
               
               String getcatname ="SELECT categor_name FROM pcgadguestshop.category WHERE id_category=? ";
               PreparedStatement ps2 = con.prepareStatement(getcatname);
               ps2.setString(1, cid);
               ResultSet rs2 =ps2.executeQuery();
               while(rs2.next()){
                   String cname = rs2.getString("categor_name");
                   cid=cname;
              
               
               String getaccname ="SELECT name FROM pcgadguestshop.pcaccerserise WHERE id_pcaccerserise=? ";
               PreparedStatement ps3 = con.prepareStatement(getaccname);
               ps3.setString(1, accid);
                  
               ResultSet rs3 =ps3.executeQuery();
               while(rs3.next()){
                   String accname = rs3.getString("name");
                   accid=accname;
                  
                   
               rowData = new Object[]{prodid,proname,productsell,cid,accid};
               return rowData;
               }
               }
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    
}
