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
import static model.grnModel.log;
import org.apache.log4j.Logger;

/**
 *
 * @author Acer
 */
public class invoiceItemModel {
    static Logger log = Logger.getLogger(invoiceItemModel.class.getName());
    Connection con;

    public invoiceItemModel() {
        con=db.dbConnection.getconnection();
        
    }

    public void loadtableitem(String keyword, DefaultTableModel invoiceItemtdm) {
       String loadtb = "SELECT * FROM pcgadguestshop.invoice_item WHERE invoice_id_invoice like ?";
//       String loadtb = "SELECT invoice_item.id_invoice_item,invoice_item.qty,invoice_item.product_id_product,"
//               + "invoice_item.invoice_id_invoice,product.id_product,product.productname "
//               + "FROM pcgadguestshop.invoice_item INNER JOIN pcgadguestshop.product ON "
//               + "pcgadguestshop.product.id_product = pcgadguestshop.invoice_item.product_id_product WHERE invoice_id_invoice like ?";
//       
       
//       String loadtb = "SELECT pcgadguestshop.invoice_item.id_invoice_item,\n" +
//"	pcgadguestshop.invoice_item.qty,\n" +
//"	pcgadguestshop.invoice_item.product_id_product,\n" +
//"	pcgadguestshop.invoice_item.invoice_id_invoice,\n" +
//"	pcgadguestshop.product.id_product,\n" +
//"	pcgadguestshop.product.productname\n" +
//"FROM pcgadguestshop.invoice_item\n" +
//"	INNER JOIN pcgadguestshop.product ON \n" +
//"	 pcgadguestshop.product.id_product = pcgadguestshop.invoice_item.product_id_product WHERE invoice_id_invoice like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            invoiceItemtdm.setRowCount(0);
            while (rs.next()) {

               String id = rs.getString("id_invoice_item");
               
               String  pid = rs.getString("product_id_product");
                String  qty = rs.getString("qty");
                String  inId = rs.getString("invoice_id_invoice");
                

                rowData = new Object[]{id,pid,qty,inId};
                invoiceItemtdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
}
