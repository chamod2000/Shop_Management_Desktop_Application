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
public class stocksModel {
     static Logger log = Logger.getLogger(stocksModel.class.getName());
   
    Connection con;

    public stocksModel() {
        con = db.dbConnection.getconnection();
    }

   

    public String updatetStock(String stid, String stpid, String stqty) {
        String msg;
       String updateQuary="UPDATE pcgadguestshop.stocks SET qty=?, product_id_product=? WHERE id_stocks=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setString(1,stqty);
            ps.setString(2,stpid);
           // ps.setDate(3, new java.sql.Date(stdate.getTime()));
            ps.setString(3,stid);
            
            ps.execute();
            msg="Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
              log.debug(e.getMessage());
            msg = "Product ID Aready taken!";
           
        }
        return msg;
    }

    public String deleteStock(String stid) {
         String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.stocks WHERE id_Stocks=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, stid);
            ps.execute();
            msg="success";
        } catch (Exception e) {
            e.printStackTrace();
              log.debug(e.getMessage());
             msg="Error"+e.getMessage();
        }
        return null;
    }

    public void loadStocktb(String keyword, DefaultTableModel stocktdm) {
        String loadtb = "SELECT  stocks.`id_stocks`,"
                + "stocks.qty,stocks.product_id_product, product.id_product,product.productname FROM pcgadguestshop.stocks INNER JOIN pcgadguestshop.product ON pcgadguestshop.stocks.product_id_product = pcgadguestshop.product.id_product WHERE product_id_product like ?";
//        String loadtb = "SELECT  stocks.`id_stocks`,\n" +
//"	 stocks.qty,\n" +
//"	 stocks.product_id_product,\n" +
//"	 product.id_product,\n" +
//"	 product.productname\n" +
//"FROM pcgadguestshop.stocks\n" +
//"	INNER JOIN pcgadguestshop.product ON \n" +
//"	 pcgadguestshop.stocks.product_id_product = pcgadguestshop.product.id_product WHERE product_id_product like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            stocktdm.setRowCount(0);
            while (rs.next()) {

               String sid = rs.getString("id_stocks");
               String  qty = rs.getString("qty");
               String  pid = rs.getString("product_id_product");
               // Date  date = rs.getDate("mfd");
               String  pname = rs.getString("productname");
                

                rowData = new Object[]{sid,pname,pid,qty};
                stocktdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Object[] getselecedid(String id) {
      String getData ="SELECT * FROM pcgadguestshop.stocks WHERE id_stocks =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
               String sid = rs.getString("id_stocks");
               String  qty = rs.getString("qty");
               String  pid = rs.getString("product_id_product");
                //Date  date = rs.getDate("mfd");
              rowData = new Object[]{sid,pid,qty};
                 
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String insertStock(String stpid, String stqty) {
        String msg="";
        String insert = "INSERT INTO pcgadguestshop.stocks (qty, product_id_product)VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, stqty);
            ps.setString(2, stpid);
            ps.execute();
            msg="Successfully Insert";
        } catch (Exception e) {
            e.printStackTrace();
              log.debug(e.getMessage());
            msg="Somthing wrong plase check input Data";
        }
        return msg;
    }
    
}
