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
public class invoiceModel {
    
     static Logger log = Logger.getLogger(invoiceModel.class.getName());
   
    Connection con;

    public invoiceModel() {
        con=db.dbConnection.getconnection();
    }



    public Object[] searchProduct(String pid) {
        String msg="";
        String getData ="SELECT * FROM pcgadguestshop.product WHERE id_product=?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            

            while(rs.next()){
               String pname = rs.getString("productname");
               String  sellprice = rs.getString("sell_price");
              
              rowData = new Object[]{pname,sellprice,msg};
                 
            }
            return rowData;
            
           // }
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
        }
        return null;
    }

    public String insertinv(String invid, String cusmob, String invTotal,Date pdate) {
        String msg="";
        String inser = "INSERT INTO pcgadguestshop.invoice (id_invoice, date, payment, customer)VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(inser);
            ps.setString(1, invid);
            ps.setDate(2, new java.sql.Date(pdate.getTime()));
            ps.setString(3, invTotal);
            ps.setString(4, cusmob);
            
            
            ps.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="Please Select Date Of Payment";
        }
        return msg;
    }

    public String insertItem(String iPId, String iqty, String invid) {
 
     
        String msg="";
        String inserti ="INSERT INTO pcgadguestshop.invoice_item (qty, product_id_product, invoice_id_invoice)VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(inserti);
            ps.setString(1, iqty);
            ps.setString(2, iPId);
            ps.setString(3, invid);
            ps.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
            msg="error";
        }
        return msg;
    }

    public String updateStock(String iPId, String iqty) {
       String msg="";
       String getqty ="SELECT qty FROM pcgadguestshop.stocks WHERE product_id_product=?";
       String stock = "UPDATE pcgadguestshop.stocks SET qty=? WHERE product_id_product=?";
        try {
            PreparedStatement ps = con.prepareStatement(getqty);
            ps.setString(1, iPId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               int pQty = rs.getInt("qty");
               int buyQty = Integer.parseInt(iqty);
               int newQty = pQty - buyQty;
               
               
               PreparedStatement ps2 = con.prepareStatement(stock);
               ps2.setInt(1, newQty);
               ps2.setString(2, iPId);
               ps2.execute();
            }
           
        } catch (Exception e) {
             log.debug(e.getMessage());
        }
       return msg;
    }

    public void loadtableInvoice(String keyword, DefaultTableModel invoicedatatdm) {
         String loadtb = "SELECT * FROM pcgadguestshop.invoice WHERE id_invoice like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            invoicedatatdm.setRowCount(0);
            while (rs.next()) {

               String id = rs.getString("id_invoice");
               
                String  date = rs.getString("date");
                String  payment = rs.getString("payment");
                String  customer = rs.getString("customer");
                

                rowData = new Object[]{id,date,payment,customer};
                invoicedatatdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String delete() {
       String msg="";
       String delete = "DELETE pcgadguestshop.invoice";
        try {
            PreparedStatement ps = con.prepareStatement(delete);
            ps.execute();
            msg="Successfully All Deleted";
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
        }
        return msg;
    }
    
    
}
