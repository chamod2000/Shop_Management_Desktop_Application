/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.glass.events.KeyEvent;
import java.awt.Component;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javafx.scene.control.Spinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.accessoryModel;
import model.adminModel;
import model.*;
import model.attendanceModel;
import model.backResoreCode;
import model.customerModel;
import model.employeeModel;
import model.grnItemModel;
import model.grnModel;
import model.invoiceItemModel;
import model.invoiceModel;
import model.pCategoryModel;
import model.paymentEmployeeModel;
import model.postModel;
import model.productModel;
import model.stocksModel;
import model.supplierModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import java.io.*;
import java.util.*;
import javax.swing.SwingUtilities;
import javax.xml.ws.Response;

/**
 *
 * @author Acer
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    private adminModel adminM;
    private customerModel customerM;
    private postModel postM;
    private employeeModel empM;
    private attendanceModel attendanceM;
    private paymentEmployeeModel payM;
    private pCategoryModel categoryM;
    private productModel productM;
    private supplierModel suplierM;
    private grnModel grnM;
    private grnItemModel grnitemM;
    private stocksModel stockM;
    private accessoryModel accessotyM;
    private invoiceModel invoiceM;
    private invoiceItemModel invoiceItemM;

    private DefaultTableModel posttdm;
    private DefaultTableModel admintdm;
    private DefaultTableModel customertdm;
    private DefaultTableModel emptdm;
    private DefaultTableModel attendancetdm;
    private DefaultTableModel paymenttdm;
    private DefaultTableModel categorytdm;
    private DefaultTableModel producttdm;
    private DefaultTableModel product3tdm;
    private DefaultTableModel supliertdm;
    private DefaultTableModel grntdm;
    private DefaultTableModel grnitemtdm;
    private DefaultTableModel stocktdm;
    private DefaultTableModel accessorytdm;
    private DefaultTableModel invoiceProducttdm;
    private DefaultTableModel customer2tdm;
    private DefaultTableModel invoicebuyitemtdm;
    private DefaultTableModel invoiceItemtdm;
    private DefaultTableModel invoicedatatdm;
    private DefaultComboBoxModel dcm;

    Connection con;

    public home() {
        initComponents();
        con = db.dbConnection.getconnection();

        Date d = new Date();
     
        searchdateChooser.setMaxSelectableDate(d);
        paymentDateChooser1.setMaxSelectableDate(d);
        grndateChooser.setMaxSelectableDate(d);
        invoicedate.setMaxSelectableDate(d);
 
        showdate();
        showtime();
        component();
        autoId();
        adminM = new adminModel();
        customerM = new customerModel();
        postM = new postModel();
        empM = new employeeModel();
        attendanceM = new attendanceModel();
        payM = new paymentEmployeeModel();
        categoryM = new pCategoryModel();
        productM = new productModel();
        suplierM = new supplierModel();
        grnM = new grnModel();
        grnitemM = new grnItemModel();
        stockM = new stocksModel();
        accessotyM = new accessoryModel();
        invoiceM = new invoiceModel();
        invoiceItemM = new invoiceItemModel();

        admintdm = (DefaultTableModel) admintable.getModel();
        customertdm = (DefaultTableModel) customertable.getModel();
        posttdm = (DefaultTableModel) posttable.getModel();
        emptdm = (DefaultTableModel) employeeTable.getModel();
        attendancetdm = (DefaultTableModel) attendanceTable.getModel();
        paymenttdm = (DefaultTableModel) employeePaymentTable.getModel();
        categorytdm = (DefaultTableModel) categorytable.getModel();
        producttdm = (DefaultTableModel) producttable.getModel();
        product3tdm = (DefaultTableModel) producttable3.getModel();
        supliertdm = (DefaultTableModel) suplierTable.getModel();
        grntdm = (DefaultTableModel) grntable.getModel();
        grnitemtdm = (DefaultTableModel) grnitemtable.getModel();
        stocktdm = (DefaultTableModel) stokstable.getModel();
        accessorytdm = (DefaultTableModel) accessoryTable.getModel();
        invoiceProducttdm = (DefaultTableModel) invoicebuytable.getModel();
        customer2tdm = (DefaultTableModel) cutomer2table.getModel();
        invoicebuyitemtdm = (DefaultTableModel) invoicebuytable.getModel();
        invoiceItemtdm = (DefaultTableModel) itemitemTable.getModel();
        invoicedatatdm = (DefaultTableModel) invoiceTable.getModel();

        adminM.loadtableAdmin("", admintdm);
        customerM.loadtableAdmin("", customertdm);
        postM.loadtablepost("", posttdm);
        empM.loadtableEmp("", emptdm);
        attendanceM.loadtablebyid("", attendancetdm);
        payM.loadtable("", paymenttdm);
        categoryM.loadtable("", categorytdm);
        productM.loadtable("", producttdm);
        productM.loadtable("", product3tdm);
        suplierM.loadtable("", supliertdm);
        grnM.loadtable("", grntdm);
        grnitemM.loadtable("", grnitemtdm);
        stockM.loadStocktb("", stocktdm);
        accessotyM.loadtable("", accessorytdm);
        customerM.loadtableAdmin("", customer2tdm);
        invoiceItemM.loadtableitem("", invoiceItemtdm);
        invoiceM.loadtableInvoice("", invoicedatatdm);

        adminIDfiled.setEditable(false);
        employeeIdFiled.setEditable(false);
        attendanceiDFiled.setEditable(false);
        paymentidFiled.setEditable(false);
        salempNameFild.setEditable(false);
        postidField.setEditable(false);
        pnamefiled.setEditable(false);
        priceFiled.setEditable(false);
        employeeIdFiled.setEditable(false);
        attendanceiDFiled.setEditable(false);
        postidField.setEditable(false);
        customerIDfiled.setEditable(false);
        prodIdFiled.setEditable(false);
        categoryIdFiled.setEditable(false);
        accessoryIdFiled.setEditable(false);
        stocksIdFiled.setEditable(false);
        supplierIDFiled.setEditable(false);
        grnIdFiled.setEditable(false);
        grnItemIdFiled.setEditable(false);
        
        

        //attConbobt.setEnabled(false);
        //jButton82.setEnabled(false);
        component();
        stocks();
    }

    public void component() {
        String category = "SELECT * FROM pcgadguestshop.category";
        try {
            PreparedStatement ps = con.prepareStatement(category);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("categor_name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            procategoryComboo.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String supplier = "SELECT * FROM pcgadguestshop.suplier";
        try {
            PreparedStatement ps = con.prepareStatement(supplier);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("sup_name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            grnsupplerCombo.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String post = "SELECT * FROM pcgadguestshop.posts";
        try {
            PreparedStatement ps = con.prepareStatement(post);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("post"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            postCombo.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String categoryy = "SELECT * FROM pcgadguestshop.category";
        try {
            PreparedStatement ps = con.prepareStatement(categoryy);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("categor_name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            procategoryComboo.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String accessory = "SELECT * FROM pcgadguestshop.pcaccerserise";
        try {
            PreparedStatement ps = con.prepareStatement(accessory);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            partSelectCombo.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stocks() {
        int qtyvalue = 5;
        String pidqty = "SELECT product_id_product FROM pcgadguestshop.stocks WHERE qty<?";
        String getproductName = "SELECT productname FROM pcgadguestshop.product WHERE id_product=?";
        try {
            PreparedStatement ps = con.prepareStatement(pidqty);
            attConbobt.setEnabled(true);
            ps.setInt(1, qtyvalue);
            Vector v = new Vector();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString("product_id_product");

                PreparedStatement ps2 = con.prepareStatement(getproductName);
                ps2.setString(1, pid);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {

                    v.add(rs2.getString("productname"));

                    dcm = new DefaultComboBoxModel(v);
                    attentionComboBox.setModel(dcm);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(int index) {
        dcm.removeElementAt(index);
    }

    public void removeStocks() {
        int qtyvalue = 5;
        String pidqty = "SELECT product_id_product FROM pcgadguestshop.stocks WHERE qty>?";
        String getproductName = "SELECT productname FROM pcgadguestshop.product WHERE id_product=?";
        try {
            PreparedStatement ps = con.prepareStatement(pidqty);
            ps.setInt(1, qtyvalue);
            Vector v = new Vector();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pid = rs.getString("product_id_product");

                PreparedStatement ps2 = con.prepareStatement(getproductName);
                ps2.setString(1, pid);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {

                    DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);

                    //  dcm.(1);
                    // attentionComboBox.setModel(dcm);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        customerbt = new javax.swing.JButton();
        adminbt = new javax.swing.JButton();
        databasebt = new javax.swing.JButton();
        supplierbt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        f1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        f2 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adminIDfiled = new javax.swing.JTextField();
        adminusernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        admintypeCombo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        admintable = new javax.swing.JTable();
        adminSearchFiled = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        f3 = new javax.swing.JInternalFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customerIDfiled = new javax.swing.JTextField();
        customernameFiled = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        customerMdeilfiled = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customertable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        customerSearchfiled = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        f4 = new javax.swing.JInternalFrame();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel66 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        backupField = new javax.swing.JTextField();
        backpPath = new javax.swing.JButton();
        backbt = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        restoreField = new javax.swing.JTextField();
        resotrePathbt = new javax.swing.JButton();
        restorebt = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        f5 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        invoiceIDfiled = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        amountFiled = new javax.swing.JTextField();
        priceFiled = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        totalFiled = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        balanceFiled = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        paymentFiled = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cuMobileFiled = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        porodictid = new javax.swing.JTextField();
        pnamefiled = new javax.swing.JTextField();
        invoicedate = new com.toedter.calendar.JDateChooser();
        jLabel97 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        qty2Filed = new javax.swing.JTextField();
        jButton39 = new javax.swing.JButton();
        jPanel78 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        invoicebuytable = new javax.swing.JTable();
        billtabe = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cutomer2table = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        invoiceCustomersearchfiled = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        cutomer = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton36 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        itemsearchfiled = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        itemitemTable = new javax.swing.JTable();
        jPanel79 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        proSearchFiled3 = new javax.swing.JTextField();
        jButton99 = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        producttable3 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        searchfiled3 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        f6 = new javax.swing.JInternalFrame();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        employeeIdFiled = new javax.swing.JTextField();
        empmobileFiled = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        empnnameFiled = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        postCombo = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        empaddressFiled = new javax.swing.JTextArea();
        jButton71 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        employeeNicFiled = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        emprSearchfiled = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jButton50 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        attendanceiDFiled = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        attendanceEmpIdFiled = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        attendanceCombo = new javax.swing.JComboBox<>();
        searchdateChooser = new com.toedter.calendar.JDateChooser();
        jButton51 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        searchAttendaceFiled = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        jPanel65 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jButton54 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        postidField = new javax.swing.JTextField();
        postsalaryFiled = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        postnameFiled = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        postSearchfiled3 = new javax.swing.JTextField();
        jButton43 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        posttable = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        salEmpIDFiled = new javax.swing.JTextField();
        salempNameFild = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        salSararyFiled = new javax.swing.JTextField();
        salETFFiled = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        checEtf = new javax.swing.JCheckBox();
        jLabel98 = new javax.swing.JLabel();
        salgrosssalarayFiled = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        salAllowanceFiled = new javax.swing.JTextField();
        salNetSalaryFiled = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jButton100 = new javax.swing.JButton();
        checEpf = new javax.swing.JCheckBox();
        jLabel87 = new javax.swing.JLabel();
        salEPFFiled = new javax.swing.JTextField();
        jButton101 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        paymentDateChooser1 = new com.toedter.calendar.JDateChooser();
        paymentidFiled = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel80 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        emprPaymentSearchfield1 = new javax.swing.JTextField();
        jButton102 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        employeePaymentTable = new javax.swing.JTable();
        jPanel81 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jButton103 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        f7 = new javax.swing.JInternalFrame();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel46 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        prodIdFiled = new javax.swing.JTextField();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        proNameFiled = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        prosellFiled = new javax.swing.JTextField();
        procategoryComboo = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        partSelectCombo = new javax.swing.JComboBox<>();
        jPanel53 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        proSearchFiled = new javax.swing.JTextField();
        jButton64 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        jPanel76 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jButton52 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        categoryIdFiled = new javax.swing.JTextField();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        categoryNameFiled = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        categorySearchFiled = new javax.swing.JTextField();
        jButton59 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        categorytable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        accessoryIdFiled = new javax.swing.JTextField();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        accessoryNameFiled = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        accessorySearchFiled = new javax.swing.JTextField();
        jButton98 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        accessoryTable = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        stocksIdFiled = new javax.swing.JTextField();
        jButton88 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        StocksPIdFiled = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        StocksQtyFiled1 = new javax.swing.JTextField();
        jButton93 = new javax.swing.JButton();
        jPanel72 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        stocksSearchFiled = new javax.swing.JTextField();
        jButton92 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        stokstable = new javax.swing.JTable();
        jPanel77 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jButton53 = new javax.swing.JButton();
        f8 = new javax.swing.JInternalFrame();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        supplierIDFiled = new javax.swing.JTextField();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        suppnameFiled = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        supEmailField = new javax.swing.JTextField();
        supMobileFiled = new javax.swing.JTextField();
        jPanel56 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        supSearchFiled = new javax.swing.JTextField();
        jButton69 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        suplierTable = new javax.swing.JTable();
        jPanel68 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jButton72 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        grnIdFiled = new javax.swing.JTextField();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        grnAmountField = new javax.swing.JTextField();
        grnsupplerCombo = new javax.swing.JComboBox<>();
        grndateChooser = new com.toedter.calendar.JDateChooser();
        jButton85 = new javax.swing.JButton();
        jPanel61 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        grnSearchFiled = new javax.swing.JTextField();
        jButton79 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        grntable = new javax.swing.JTable();
        jPanel69 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jButton73 = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        grnitemSearchFiled = new javax.swing.JTextField();
        jButton80 = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        grnitemtable = new javax.swing.JTable();
        jPanel70 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jButton74 = new javax.swing.JButton();
        jPanel64 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        grnItemIdFiled = new javax.swing.JTextField();
        jButton81 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        grnitembuypFiled = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        grnitemQtyFiled = new javax.swing.JTextField();
        grnitemPIdFiled1 = new javax.swing.JTextField();
        grnitemGrnIdFeild = new javax.swing.JTextField();
        jButton86 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        attentionComboBox = new javax.swing.JComboBox<>();
        attConbobt = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home page");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.orange));

        customerbt.setBackground(new java.awt.Color(102, 102, 255));
        customerbt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        customerbt.setForeground(new java.awt.Color(255, 255, 255));
        customerbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        customerbt.setText("Customers");
        customerbt.setContentAreaFilled(false);
        customerbt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerbt.setOpaque(true);
        customerbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerbtActionPerformed(evt);
            }
        });

        adminbt.setBackground(new java.awt.Color(102, 255, 102));
        adminbt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adminbt.setForeground(new java.awt.Color(255, 255, 255));
        adminbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        adminbt.setText("Admin Option");
        adminbt.setContentAreaFilled(false);
        adminbt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminbt.setOpaque(true);
        adminbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminbtActionPerformed(evt);
            }
        });

        databasebt.setBackground(new java.awt.Color(255, 153, 51));
        databasebt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        databasebt.setForeground(new java.awt.Color(255, 255, 255));
        databasebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database.png"))); // NOI18N
        databasebt.setText("Database Option");
        databasebt.setContentAreaFilled(false);
        databasebt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        databasebt.setOpaque(true);
        databasebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databasebtActionPerformed(evt);
            }
        });

        supplierbt.setBackground(new java.awt.Color(102, 102, 102));
        supplierbt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplierbt.setForeground(new java.awt.Color(255, 255, 255));
        supplierbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-supplier-32.png"))); // NOI18N
        supplierbt.setText("Supplier");
        supplierbt.setContentAreaFilled(false);
        supplierbt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        supplierbt.setOpaque(true);
        supplierbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierbtActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
        jButton1.setText("Employee");
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cachier.png"))); // NOI18N
        jButton2.setText("Cashier");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-1.png"))); // NOI18N
        jButton3.setText("LogOut");
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product1.png"))); // NOI18N
        jButton4.setText("Products & Stocks");
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(databasebt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(adminbt, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(customerbt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(supplierbt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(databasebt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(adminbt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(545, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        f1.setBackground(new java.awt.Color(204, 204, 204));
        f1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 58)); // NOI18N
        jLabel1.setText(" PC-GADGUEST");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home-icon.png"))); // NOI18N

        javax.swing.GroupLayout f1Layout = new javax.swing.GroupLayout(f1.getContentPane());
        f1.getContentPane().setLayout(f1Layout);
        f1Layout.setHorizontalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f1Layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addGroup(f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(427, 427, 427))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(333, 333, 333))))
        );
        f1Layout.setVerticalGroup(
            f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jDesktopPane1.add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1140, 650));

        f2.setVisible(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Admin ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Password");

        adminIDfiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adminIDfiled.setText(" ");
        adminIDfiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminIDfiledActionPerformed(evt);
            }
        });

        adminusernameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton5.setBackground(new java.awt.Color(102, 102, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Insert");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Update");
        jButton6.setContentAreaFilled(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Delete");
        jButton7.setContentAreaFilled(false);
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 255, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Refresh page");
        jButton8.setContentAreaFilled(false);
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel37.setText("User Type");

        admintypeCombo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        admintypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "owner", "manager", "cachier", "prodcut" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admintypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adminIDfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adminusernameField))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(passwordField)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminIDfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminusernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admintypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data of Admin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        admintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Admin USername", "Admin Password", "Usertype"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        admintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admintableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(admintable);
        if (admintable.getColumnModel().getColumnCount() > 0) {
            admintable.getColumnModel().getColumn(0).setResizable(false);
            admintable.getColumnModel().getColumn(0).setHeaderValue("Admin ID");
            admintable.getColumnModel().getColumn(1).setHeaderValue("Admin USername");
            admintable.getColumnModel().getColumn(2).setHeaderValue("Admin Password");
            admintable.getColumnModel().getColumn(3).setHeaderValue("Usertype");
        }

        jButton16.setBackground(new java.awt.Color(255, 255, 102));
        jButton16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton16.setText("Search");
        jButton16.setContentAreaFilled(false);
        jButton16.setOpaque(true);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("By User name");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout f2Layout = new javax.swing.GroupLayout(f2.getContentPane());
        f2.getContentPane().setLayout(f2Layout);
        f2Layout.setHorizontalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        f2Layout.setVerticalGroup(
            f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jDesktopPane1.add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1140, 650));

        f3.setVisible(false);
        f3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Customer Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Customer ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Customer Phone Number");

        customerIDfiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        customerIDfiled.setText(" ");
        customerIDfiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDfiledActionPerformed(evt);
            }
        });

        customernameFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton9.setBackground(new java.awt.Color(102, 102, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Insert");
        jButton9.setContentAreaFilled(false);
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 153, 51));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Update");
        jButton10.setContentAreaFilled(false);
        jButton10.setOpaque(true);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 51, 51));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Delete");
        jButton11.setContentAreaFilled(false);
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(51, 204, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Refresh page");
        jButton12.setContentAreaFilled(false);
        jButton12.setOpaque(true);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(customerIDfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(customerMdeilfiled))
                            .addComponent(customernameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerIDfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerMdeilfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customernameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        f3.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 440, 560));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        customertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Mobile Number", "Customer Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customertableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customertable);
        if (customertable.getColumnModel().getColumnCount() > 0) {
            customertable.getColumnModel().getColumn(0).setResizable(false);
            customertable.getColumnModel().getColumn(1).setResizable(false);
            customertable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel11.setText("By Mobile Number");

        customerSearchfiled.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerSearchfiledKeyTyped(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 102));
        jButton14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton14.setText("Search");
        jButton14.setContentAreaFilled(false);
        jButton14.setOpaque(true);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerSearchfiled)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(customerSearchfiled, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        f3.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 520, 440));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Generate Customer Details as Report");

        jButton13.setBackground(new java.awt.Color(0, 102, 102));
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Report");
        jButton13.setContentAreaFilled(false);
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        f3.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 410, 90));

        jDesktopPane1.add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1130, 660));

        f4.setVisible(false);
        f4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrator Backup and Restore Database", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 0), null));

        backpPath.setBackground(new java.awt.Color(51, 153, 0));
        backpPath.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backpPath.setForeground(new java.awt.Color(255, 255, 255));
        backpPath.setText("Backup Path");
        backpPath.setContentAreaFilled(false);
        backpPath.setOpaque(true);
        backpPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backpPathActionPerformed(evt);
            }
        });

        backbt.setBackground(new java.awt.Color(51, 102, 0));
        backbt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backbt.setForeground(new java.awt.Color(255, 255, 255));
        backbt.setText("BackUp");
        backbt.setContentAreaFilled(false);
        backbt.setOpaque(true);
        backbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(backupField, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(backpPath, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backupField)
                    .addComponent(backpPath, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backbt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backup-database.png"))); // NOI18N

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Bacup Database", jPanel66);

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        resotrePathbt.setBackground(new java.awt.Color(0, 102, 102));
        resotrePathbt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resotrePathbt.setForeground(new java.awt.Color(255, 255, 255));
        resotrePathbt.setText("Restore Path");
        resotrePathbt.setContentAreaFilled(false);
        resotrePathbt.setOpaque(true);
        resotrePathbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resotrePathbtActionPerformed(evt);
            }
        });

        restorebt.setBackground(new java.awt.Color(0, 51, 51));
        restorebt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        restorebt.setForeground(new java.awt.Color(255, 255, 255));
        restorebt.setText("Resotore");
        restorebt.setContentAreaFilled(false);
        restorebt.setOpaque(true);
        restorebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restorebtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(restorebt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(restoreField, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(resotrePathbt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restoreField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resotrePathbt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(restorebt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel51))
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Restore Database", jPanel67);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addGap(64, 64, 64))
        );

        f4.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1090, 600));

        jDesktopPane1.add(f4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -26, 1130, 650));

        f5.setVisible(false);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel24.setText("Price");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setText("Qty");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel26.setText("Product ID");

        invoiceIDfiled.setBackground(new java.awt.Color(204, 204, 255));
        invoiceIDfiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        invoiceIDfiled.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invoiceIDfiled.setText(" ");
        invoiceIDfiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceIDfiledadminIDfiled1ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel91.setText("Invoice ID");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel92.setText("Total");

        amountFiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountFiled.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        priceFiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        priceFiled.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFiledActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel93.setText("Amount");

        totalFiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalFiledActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        balanceFiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        balanceFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceFiledActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel94.setText("Balance");

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel95.setText("Payment ");

        paymentFiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        paymentFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFiledActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(0, 102, 255));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("Bill");
        jButton30.setContentAreaFilled(false);
        jButton30.setOpaque(true);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel27.setText("Product Name");

        cuMobileFiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cuMobileFiled.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuMobileFiled.setText("Guest");
        cuMobileFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuMobileFiledActionPerformed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel96.setText("Customer ");

        jButton31.setBackground(new java.awt.Color(51, 51, 255));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Add Product");
        jButton31.setContentAreaFilled(false);
        jButton31.setOpaque(true);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        porodictid.setBackground(new java.awt.Color(255, 255, 102));
        porodictid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        porodictid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        porodictid.setText(" ");
        porodictid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porodictidadminIDfiled1ActionPerformed(evt);
            }
        });
        porodictid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porodictidKeyPressed(evt);
            }
        });

        pnamefiled.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pnamefiled.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnamefiled.setText(" ");
        pnamefiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnamefiledadminIDfiled1ActionPerformed(evt);
            }
        });

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel97.setText("Date");

        jButton15.setBackground(new java.awt.Color(255, 51, 51));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Remove Product ");
        jButton15.setContentAreaFilled(false);
        jButton15.setOpaque(true);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(51, 204, 0));
        jButton38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 255, 255));
        jButton38.setText("Refresh page");
        jButton38.setContentAreaFilled(false);
        jButton38.setOpaque(true);
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        qty2Filed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qty2FiledKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qty2FiledKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty2FiledKeyTyped(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(255, 153, 0));
        jButton39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Update Product");
        jButton39.setContentAreaFilled(false);
        jButton39.setOpaque(true);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceIDfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qty2Filed, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26))
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(porodictid, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(pnamefiled, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(amountFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(balanceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel96)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoicedate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(cuMobileFiled))
                .addGap(30, 30, 30))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceIDfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paymentFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porodictid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnamefiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cuMobileFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(balanceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(qty2Filed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(amountFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(invoicedate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addComponent(jSeparator1)))
        );

        jPanel78.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buying Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        invoicebuytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Qty", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoicebuytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicebuytableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(invoicebuytable);
        if (invoicebuytable.getColumnModel().getColumnCount() > 0) {
            invoicebuytable.getColumnModel().getColumn(0).setResizable(false);
            invoicebuytable.getColumnModel().getColumn(1).setResizable(false);
            invoicebuytable.getColumnModel().getColumn(2).setResizable(false);
            invoicebuytable.getColumnModel().getColumn(3).setResizable(false);
            invoicebuytable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        cutomer2table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name", "Customer Mobile Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cutomer2table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cutomer2tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cutomer2table);
        if (cutomer2table.getColumnModel().getColumnCount() > 0) {
            cutomer2table.getColumnModel().getColumn(0).setResizable(false);
            cutomer2table.getColumnModel().getColumn(1).setResizable(false);
            cutomer2table.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel17.setText("By Customer Mobile");

        jButton21.setBackground(new java.awt.Color(255, 255, 102));
        jButton21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton21.setText("Search");
        jButton21.setContentAreaFilled(false);
        jButton21.setOpaque(true);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        cutomer.setBackground(new java.awt.Color(102, 102, 255));
        cutomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cutomer.setForeground(new java.awt.Color(255, 255, 255));
        cutomer.setText("New Customer");
        cutomer.setContentAreaFilled(false);
        cutomer.setOpaque(true);
        cutomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutomerActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Register New Customer");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(cutomer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cutomer, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton36.setBackground(new java.awt.Color(51, 255, 51));
        jButton36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton36.setText("Refresh");
        jButton36.setContentAreaFilled(false);
        jButton36.setOpaque(true);
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(invoiceCustomersearchfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(52, Short.MAX_VALUE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceCustomersearchfiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        billtabe.addTab("Customer", jPanel15);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(billtabe, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billtabe, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Pyment", jPanel18);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data of Invoice Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel19.setText("By Invoice ID");

        jButton22.setBackground(new java.awt.Color(255, 255, 102));
        jButton22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton22.setText("Search");
        jButton22.setContentAreaFilled(false);
        jButton22.setOpaque(true);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        itemitemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InvoiceItem ID", "Product Id", "Qty", "Invoice ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(itemitemTable);
        if (itemitemTable.getColumnModel().getColumnCount() > 0) {
            itemitemTable.getColumnModel().getColumn(0).setResizable(false);
            itemitemTable.getColumnModel().getColumn(1).setResizable(false);
            itemitemTable.getColumnModel().getColumn(2).setResizable(false);
            itemitemTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel79.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Product  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel61.setText("By Product Name");

        jButton99.setBackground(new java.awt.Color(255, 255, 102));
        jButton99.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton99.setText("Search");
        jButton99.setContentAreaFilled(false);
        jButton99.setOpaque(true);
        jButton99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton99ActionPerformed(evt);
            }
        });

        producttable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product  ID", "Name", "Selling Price", "Product Category", "Accessory Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                producttable3MouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(producttable3);
        if (producttable3.getColumnModel().getColumnCount() > 0) {
            producttable3.getColumnModel().getColumn(0).setResizable(false);
            producttable3.getColumnModel().getColumn(1).setResizable(false);
            producttable3.getColumnModel().getColumn(2).setResizable(false);
            producttable3.getColumnModel().getColumn(3).setResizable(false);
            producttable3.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proSearchFiled3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21))
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proSearchFiled3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemsearchfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemsearchfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buy Items", jPanel19);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data of Invoice ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel20.setText("By Invoice ID");

        jButton23.setBackground(new java.awt.Color(255, 255, 102));
        jButton23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton23.setText("Search");
        jButton23.setContentAreaFilled(false);
        jButton23.setOpaque(true);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Date", "Payment", "Customer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(invoiceTable);
        if (invoiceTable.getColumnModel().getColumnCount() > 0) {
            invoiceTable.getColumnModel().getColumn(0).setResizable(false);
            invoiceTable.getColumnModel().getColumn(1).setResizable(false);
            invoiceTable.getColumnModel().getColumn(2).setResizable(false);
            invoiceTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Generate Invoice Details as Report");

        jButton37.setBackground(new java.awt.Color(0, 102, 102));
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Report");
        jButton37.setContentAreaFilled(false);
        jButton37.setOpaque(true);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchfiled3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchfiled3)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Details of Invoices", jPanel21);

        javax.swing.GroupLayout f5Layout = new javax.swing.GroupLayout(f5.getContentPane());
        f5.getContentPane().setLayout(f5Layout);
        f5Layout.setHorizontalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        f5Layout.setVerticalGroup(
            f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jDesktopPane1.add(f5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1130, 660));

        f6.setVisible(false);

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel14.setText("post");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setText("Employee ID");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setText(" Phone Number");

        employeeIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employeeIdFiled.setText(" ");
        employeeIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdFiledActionPerformed(evt);
            }
        });

        empmobileFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton17.setBackground(new java.awt.Color(102, 102, 255));
        jButton17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Insert");
        jButton17.setContentAreaFilled(false);
        jButton17.setOpaque(true);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(255, 153, 51));
        jButton18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Update");
        jButton18.setContentAreaFilled(false);
        jButton18.setOpaque(true);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 51, 51));
        jButton19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Delete");
        jButton19.setContentAreaFilled(false);
        jButton19.setOpaque(true);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(51, 204, 0));
        jButton20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Refresh page");
        jButton20.setContentAreaFilled(false);
        jButton20.setOpaque(true);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel35.setText("Employee Name");

        postCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel41.setText("Address");

        empaddressFiled.setColumns(20);
        empaddressFiled.setRows(5);
        jScrollPane9.setViewportView(empaddressFiled);

        jButton71.setBackground(new java.awt.Color(0, 102, 153));
        jButton71.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton71.setForeground(new java.awt.Color(255, 255, 255));
        jButton71.setText("Post");
        jButton71.setContentAreaFilled(false);
        jButton71.setOpaque(true);
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel43.setText("NIC Number");

        employeeNicFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                    .addComponent(employeeIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(empnnameFiled)
                                .addComponent(jScrollPane9))
                            .addComponent(empmobileFiled)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(postCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 35, Short.MAX_VALUE)
                                .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(employeeNicFiled, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empnnameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empmobileFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeNicFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel21.setText("By Employee Name");

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", " Name", "  Address", "Mobile Number", "Post of Employee", "NIC No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(employeeTable);
        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(0).setResizable(false);
            employeeTable.getColumnModel().getColumn(1).setResizable(false);
            employeeTable.getColumnModel().getColumn(2).setResizable(false);
            employeeTable.getColumnModel().getColumn(3).setResizable(false);
            employeeTable.getColumnModel().getColumn(4).setResizable(false);
            employeeTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Generate Employees Details as Report");

        jButton50.setBackground(new java.awt.Color(0, 102, 102));
        jButton50.setForeground(new java.awt.Color(255, 255, 255));
        jButton50.setText("Report");
        jButton50.setContentAreaFilled(false);
        jButton50.setOpaque(true);
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton24.setBackground(new java.awt.Color(255, 255, 102));
        jButton24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton24.setText("Search");
        jButton24.setContentAreaFilled(false);
        jButton24.setOpaque(true);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emprSearchfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emprSearchfiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jTabbedPane2.addTab("Employee Registration", jPanel23);

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel22.setText("Employee ID");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel23.setText("Attendance ID");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel28.setText("Date");

        attendanceiDFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        attendanceiDFiled.setText(" ");
        attendanceiDFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceiDFiledActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(102, 102, 255));
        jButton25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Insert");
        jButton25.setContentAreaFilled(false);
        jButton25.setOpaque(true);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(255, 153, 51));
        jButton26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Update");
        jButton26.setContentAreaFilled(false);
        jButton26.setOpaque(true);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(255, 51, 51));
        jButton27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Delete");
        jButton27.setContentAreaFilled(false);
        jButton27.setOpaque(true);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(51, 204, 0));
        jButton28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Refresh page");
        jButton28.setContentAreaFilled(false);
        jButton28.setOpaque(true);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel31.setText("Status");

        attendanceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Absent", "HalfDay" }));

        jButton51.setBackground(new java.awt.Color(102, 102, 102));
        jButton51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton51.setForeground(new java.awt.Color(255, 255, 255));
        jButton51.setText("Employee Details");
        jButton51.setContentAreaFilled(false);
        jButton51.setOpaque(true);
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(attendanceiDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel34Layout.createSequentialGroup()
                                    .addComponent(attendanceEmpIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(attendanceCombo, 0, 230, Short.MAX_VALUE)
                                .addComponent(searchdateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attendanceiDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attendanceEmpIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(searchdateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attendanceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jButton29.setBackground(new java.awt.Color(255, 255, 102));
        jButton29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton29.setText("Search");
        jButton29.setContentAreaFilled(false);
        jButton29.setOpaque(true);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attendance ID", "Employee Name", "Date", "Satatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendanceTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(attendanceTable);
        if (attendanceTable.getColumnModel().getColumnCount() > 0) {
            attendanceTable.getColumnModel().getColumn(0).setResizable(false);
            attendanceTable.getColumnModel().getColumn(1).setResizable(false);
            attendanceTable.getColumnModel().getColumn(2).setResizable(false);
            attendanceTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("Generate Employees AttendanceDetails as Report");

        jButton54.setBackground(new java.awt.Color(0, 102, 102));
        jButton54.setForeground(new java.awt.Color(255, 255, 255));
        jButton54.setText("Report");
        jButton54.setContentAreaFilled(false);
        jButton54.setOpaque(true);
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel12.setText("By Employee ID");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12)
                        .addGap(80, 80, 80)
                        .addComponent(searchAttendaceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchAttendaceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Attendance", jPanel24);

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Post", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel30.setText("Salary of post");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel32.setText("Post ID");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel33.setText("Post");

        postidField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        postidField.setText(" ");
        postidField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postidFieldActionPerformed(evt);
            }
        });

        postsalaryFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton32.setBackground(new java.awt.Color(102, 102, 255));
        jButton32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Insert");
        jButton32.setContentAreaFilled(false);
        jButton32.setOpaque(true);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(255, 153, 51));
        jButton33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Update");
        jButton33.setContentAreaFilled(false);
        jButton33.setOpaque(true);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 51, 51));
        jButton34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Delete");
        jButton34.setContentAreaFilled(false);
        jButton34.setOpaque(true);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(51, 204, 0));
        jButton35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Refresh page");
        jButton35.setContentAreaFilled(false);
        jButton35.setOpaque(true);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        postnameFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postnameFiledActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                    .addComponent(postidField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(postnameFiled))
                            .addComponent(postsalaryFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postidField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postnameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postsalaryFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Posit Details of Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel34.setText(" By Post Name");

        jButton43.setBackground(new java.awt.Color(255, 255, 102));
        jButton43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton43.setText("Search");
        jButton43.setContentAreaFilled(false);
        jButton43.setOpaque(true);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        posttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Post ID", "Post Name", "Salary of post"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        posttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posttableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(posttable);
        if (posttable.getColumnModel().getColumnCount() > 0) {
            posttable.getColumnModel().getColumn(0).setResizable(false);
            posttable.getColumnModel().getColumn(1).setResizable(false);
            posttable.getColumnModel().getColumn(2).setResizable(false);
            posttable.getColumnModel().getColumn(2).setHeaderValue("Employee  Address");
        }

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postSearchfiled3)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postSearchfiled3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jTabbedPane2.addTab("Post", jPanel29);

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 51))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel39.setText("Payment ID");

        salEmpIDFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salEmpIDFiled.setText(" ");
        salEmpIDFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salEmpIDFiledActionPerformed(evt);
            }
        });
        salEmpIDFiled.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salEmpIDFiledKeyPressed(evt);
            }
        });

        salempNameFild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salempNameFild.setText(" ");
        salempNameFild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salempNameFildActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel38.setText("Employee Name");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel40.setText("Date");

        salSararyFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salSararyFiled.setText(" ");
        salSararyFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salSararyFiledActionPerformed(evt);
            }
        });

        salETFFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salETFFiled.setText(" ");
        salETFFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salETFFiledActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel86.setText("ETF Amount");

        checEtf.setText("ETF");

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel98.setText("Gross Salary ");

        salgrosssalarayFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salgrosssalarayFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salgrosssalarayFiledActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel100.setText("NetSalary");

        salAllowanceFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salAllowanceFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salAllowanceFiledActionPerformed(evt);
            }
        });

        salNetSalaryFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salNetSalaryFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salNetSalaryFiledActionPerformed(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel99.setText("Allowances ");

        jButton100.setBackground(new java.awt.Color(69, 34, 39));
        jButton100.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton100.setForeground(new java.awt.Color(255, 255, 255));
        jButton100.setText("Cal");
        jButton100.setContentAreaFilled(false);
        jButton100.setOpaque(true);
        jButton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton100ActionPerformed(evt);
            }
        });

        checEpf.setText("EPF");
        checEpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checEpfActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel87.setText("EPF Amount");

        salEPFFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salEPFFiled.setText(" ");
        salEPFFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salEPFFiledActionPerformed(evt);
            }
        });

        jButton101.setBackground(new java.awt.Color(255, 51, 51));
        jButton101.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton101.setForeground(new java.awt.Color(255, 255, 255));
        jButton101.setText("Delete");
        jButton101.setContentAreaFilled(false);
        jButton101.setOpaque(true);
        jButton101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton101ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(102, 102, 255));
        jButton41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("Insert");
        jButton41.setContentAreaFilled(false);
        jButton41.setOpaque(true);
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(255, 153, 51));
        jButton42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton42.setForeground(new java.awt.Color(255, 255, 255));
        jButton42.setText("Update");
        jButton42.setContentAreaFilled(false);
        jButton42.setOpaque(true);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel42.setText("Salary");

        paymentidFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel103.setText("Employee ID");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(checEpf)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salETFFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(checEtf)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel103))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(paymentidFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(salEmpIDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addComponent(salempNameFild)
                                    .addComponent(salSararyFiled)
                                    .addComponent(paymentDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salEPFFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(salNetSalaryFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(salgrosssalarayFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel99)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(salAllowanceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paymentidFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salEmpIDFiled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salempNameFild, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salSararyFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paymentDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checEtf)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salETFFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checEpf)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salEPFFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salgrosssalarayFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salAllowanceFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salNetSalaryFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel80.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel101.setText("By Employee ID");

        jButton102.setBackground(new java.awt.Color(255, 255, 102));
        jButton102.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton102.setText("Search");
        jButton102.setContentAreaFilled(false);
        jButton102.setOpaque(true);
        jButton102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton102ActionPerformed(evt);
            }
        });

        employeePaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Date of Payment", "Employee ID", "EPF", "ETF", "Allowances", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeePaymentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeePaymentTableMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(employeePaymentTable);
        if (employeePaymentTable.getColumnModel().getColumnCount() > 0) {
            employeePaymentTable.getColumnModel().getColumn(0).setResizable(false);
            employeePaymentTable.getColumnModel().getColumn(1).setResizable(false);
            employeePaymentTable.getColumnModel().getColumn(2).setResizable(false);
            employeePaymentTable.getColumnModel().getColumn(3).setResizable(false);
            employeePaymentTable.getColumnModel().getColumn(4).setResizable(false);
            employeePaymentTable.getColumnModel().getColumn(5).setResizable(false);
            employeePaymentTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel102.setText("Generate Payments Details as Report");

        jButton103.setBackground(new java.awt.Color(0, 102, 102));
        jButton103.setForeground(new java.awt.Color(255, 255, 255));
        jButton103.setText("Report");
        jButton103.setContentAreaFilled(false);
        jButton103.setOpaque(true);
        jButton103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton103ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton44.setBackground(new java.awt.Color(51, 204, 0));
        jButton44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton44.setForeground(new java.awt.Color(255, 255, 255));
        jButton44.setText("Refresh page");
        jButton44.setContentAreaFilled(false);
        jButton44.setOpaque(true);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emprPaymentSearchfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emprPaymentSearchfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Monthly payment", jPanel25);

        javax.swing.GroupLayout f6Layout = new javax.swing.GroupLayout(f6.getContentPane());
        f6.getContentPane().setLayout(f6Layout);
        f6Layout.setHorizontalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        f6Layout.setVerticalGroup(
            f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jDesktopPane1.add(f6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -36, 1130, 670));

        f7.setVisible(false);

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel55.setText("Product  ID");

        prodIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        prodIdFiled.setText(" ");
        prodIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodIdFiledActionPerformed(evt);
            }
        });

        jButton60.setBackground(new java.awt.Color(102, 102, 255));
        jButton60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton60.setForeground(new java.awt.Color(255, 255, 255));
        jButton60.setText("Insert");
        jButton60.setContentAreaFilled(false);
        jButton60.setOpaque(true);
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton61.setBackground(new java.awt.Color(255, 153, 51));
        jButton61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton61.setForeground(new java.awt.Color(255, 255, 255));
        jButton61.setText("Update");
        jButton61.setContentAreaFilled(false);
        jButton61.setOpaque(true);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setBackground(new java.awt.Color(255, 51, 51));
        jButton62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton62.setForeground(new java.awt.Color(255, 255, 255));
        jButton62.setText("Delete");
        jButton62.setContentAreaFilled(false);
        jButton62.setOpaque(true);
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton63.setBackground(new java.awt.Color(51, 204, 0));
        jButton63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton63.setForeground(new java.awt.Color(255, 255, 255));
        jButton63.setText("Refresh page");
        jButton63.setContentAreaFilled(false);
        jButton63.setOpaque(true);
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel57.setText("Product Name");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel60.setText("Selling Price");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel64.setText("Brand");

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel88.setText("Accerssory");

        partSelectCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partSelectComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addComponent(prodIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proNameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(138, Short.MAX_VALUE))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prosellFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(partSelectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(procategoryComboo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proNameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prosellFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procategoryComboo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partSelectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Product  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel59.setText("By Product Name");

        jButton64.setBackground(new java.awt.Color(255, 255, 102));
        jButton64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton64.setText("Search");
        jButton64.setContentAreaFilled(false);
        jButton64.setOpaque(true);
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        producttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product  ID", "Name", "Selling Price", "Product Category", "Accessory Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        producttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                producttableMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(producttable);
        if (producttable.getColumnModel().getColumnCount() > 0) {
            producttable.getColumnModel().getColumn(0).setResizable(false);
            producttable.getColumnModel().getColumn(1).setResizable(false);
            producttable.getColumnModel().getColumn(2).setResizable(false);
            producttable.getColumnModel().getColumn(3).setResizable(false);
            producttable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Generate Product Details as Report");

        jButton52.setBackground(new java.awt.Color(0, 102, 102));
        jButton52.setForeground(new java.awt.Color(255, 255, 255));
        jButton52.setText("Report");
        jButton52.setContentAreaFilled(false);
        jButton52.setOpaque(true);
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Product", jPanel46);

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Brand", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel54.setText("Product Brand ID");

        categoryIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        categoryIdFiled.setText(" ");
        categoryIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryIdFiledActionPerformed(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(102, 102, 255));
        jButton55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton55.setForeground(new java.awt.Color(255, 255, 255));
        jButton55.setText("Insert");
        jButton55.setContentAreaFilled(false);
        jButton55.setOpaque(true);
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton56.setBackground(new java.awt.Color(255, 153, 51));
        jButton56.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton56.setForeground(new java.awt.Color(255, 255, 255));
        jButton56.setText("Update");
        jButton56.setContentAreaFilled(false);
        jButton56.setOpaque(true);
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setBackground(new java.awt.Color(255, 51, 51));
        jButton57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton57.setForeground(new java.awt.Color(255, 255, 255));
        jButton57.setText("Delete");
        jButton57.setContentAreaFilled(false);
        jButton57.setOpaque(true);
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(51, 204, 0));
        jButton58.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton58.setForeground(new java.awt.Color(255, 255, 255));
        jButton58.setText("Refresh page");
        jButton58.setContentAreaFilled(false);
        jButton58.setOpaque(true);
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel56.setText("Brand Name");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                                .addComponent(categoryIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(categoryNameFiled))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryNameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List of Product Brand", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel58.setText("By Brand Name");

        jButton59.setBackground(new java.awt.Color(255, 255, 102));
        jButton59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton59.setText("Search");
        jButton59.setContentAreaFilled(false);
        jButton59.setOpaque(true);
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        categorytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Brand ID", "Brand Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categorytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categorytableMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(categorytable);
        if (categorytable.getColumnModel().getColumnCount() > 0) {
            categorytable.getColumnModel().getColumn(0).setResizable(false);
            categorytable.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categorySearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorySearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane6.addTab("Brands", jPanel48);

        jPanel73.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel74.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Accessory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel62.setText("Accessory ID");

        accessoryIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        accessoryIdFiled.setText(" ");
        accessoryIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessoryIdFiledActionPerformed(evt);
            }
        });

        jButton94.setBackground(new java.awt.Color(102, 102, 255));
        jButton94.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton94.setForeground(new java.awt.Color(255, 255, 255));
        jButton94.setText("Insert");
        jButton94.setContentAreaFilled(false);
        jButton94.setOpaque(true);
        jButton94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton94ActionPerformed(evt);
            }
        });

        jButton95.setBackground(new java.awt.Color(255, 153, 51));
        jButton95.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton95.setForeground(new java.awt.Color(255, 255, 255));
        jButton95.setText("Update");
        jButton95.setContentAreaFilled(false);
        jButton95.setOpaque(true);
        jButton95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton95ActionPerformed(evt);
            }
        });

        jButton96.setBackground(new java.awt.Color(255, 51, 51));
        jButton96.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton96.setForeground(new java.awt.Color(255, 255, 255));
        jButton96.setText("Delete");
        jButton96.setContentAreaFilled(false);
        jButton96.setOpaque(true);
        jButton96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton96ActionPerformed(evt);
            }
        });

        jButton97.setBackground(new java.awt.Color(51, 204, 0));
        jButton97.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton97.setForeground(new java.awt.Color(255, 255, 255));
        jButton97.setText("Refresh page");
        jButton97.setContentAreaFilled(false);
        jButton97.setOpaque(true);
        jButton97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton97ActionPerformed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel89.setText("Accessory Name");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                        .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                                .addComponent(accessoryIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(accessoryNameFiled))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accessoryIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accessoryNameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel75.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List of Product Accessory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel90.setText("By Accessory Name");

        jButton98.setBackground(new java.awt.Color(255, 255, 102));
        jButton98.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton98.setText("Search");
        jButton98.setContentAreaFilled(false);
        jButton98.setOpaque(true);
        jButton98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton98ActionPerformed(evt);
            }
        });

        accessoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Accessory ID", "Accessory Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accessoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accessoryTableMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(accessoryTable);
        if (accessoryTable.getColumnModel().getColumnCount() > 0) {
            accessoryTable.getColumnModel().getColumn(0).setResizable(false);
            accessoryTable.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accessorySearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton98, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accessorySearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane6.addTab("Accessory", jPanel10);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addGap(39, 39, 39))
        );

        jTabbedPane3.addTab("Product Brand and Accerssory", jPanel47);

        jPanel58.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel71.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stocks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel71.setText("Stocks ID");

        stocksIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stocksIdFiled.setText(" ");
        stocksIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksIdFiledActionPerformed(evt);
            }
        });

        jButton88.setBackground(new java.awt.Color(102, 102, 255));
        jButton88.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton88.setForeground(new java.awt.Color(255, 255, 255));
        jButton88.setText("Insert");
        jButton88.setContentAreaFilled(false);
        jButton88.setOpaque(true);
        jButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton88ActionPerformed(evt);
            }
        });

        jButton89.setBackground(new java.awt.Color(255, 153, 51));
        jButton89.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton89.setForeground(new java.awt.Color(255, 255, 255));
        jButton89.setText("Update");
        jButton89.setContentAreaFilled(false);
        jButton89.setOpaque(true);
        jButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton89ActionPerformed(evt);
            }
        });

        jButton90.setBackground(new java.awt.Color(255, 51, 51));
        jButton90.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton90.setForeground(new java.awt.Color(255, 255, 255));
        jButton90.setText("Delete");
        jButton90.setContentAreaFilled(false);
        jButton90.setOpaque(true);
        jButton90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton90ActionPerformed(evt);
            }
        });

        jButton91.setBackground(new java.awt.Color(51, 204, 0));
        jButton91.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton91.setForeground(new java.awt.Color(255, 255, 255));
        jButton91.setText("Refresh page");
        jButton91.setContentAreaFilled(false);
        jButton91.setOpaque(true);
        jButton91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton91ActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel72.setText("Qty");

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel85.setText("Product ID");

        jButton93.setBackground(new java.awt.Color(153, 153, 153));
        jButton93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton93.setForeground(new java.awt.Color(255, 255, 255));
        jButton93.setText("Product");
        jButton93.setContentAreaFilled(false);
        jButton93.setOpaque(true);
        jButton93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton93ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                        .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                                .addComponent(stocksIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(StocksQtyFiled1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addComponent(StocksPIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stocksIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StocksPIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StocksQtyFiled1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel72.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details of Stocks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel73.setText("By ");

        jButton92.setBackground(new java.awt.Color(255, 255, 102));
        jButton92.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton92.setText("Search");
        jButton92.setContentAreaFilled(false);
        jButton92.setOpaque(true);
        jButton92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton92ActionPerformed(evt);
            }
        });

        stokstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stocks ID", "Product Name", "Product ID", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stokstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stokstableMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(stokstable);
        if (stokstable.getColumnModel().getColumnCount() > 0) {
            stokstable.getColumnModel().getColumn(0).setResizable(false);
            stokstable.getColumnModel().getColumn(1).setResizable(false);
            stokstable.getColumnModel().getColumn(2).setResizable(false);
            stokstable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("Generate Stock Details as Report");

        jButton53.setBackground(new java.awt.Color(0, 102, 102));
        jButton53.setForeground(new java.awt.Color(255, 255, 255));
        jButton53.setText("Report");
        jButton53.setContentAreaFilled(false);
        jButton53.setOpaque(true);
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stocksSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stocksSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Stocks", jPanel57);

        javax.swing.GroupLayout f7Layout = new javax.swing.GroupLayout(f7.getContentPane());
        f7.getContentPane().setLayout(f7Layout);
        f7Layout.setHorizontalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        f7Layout.setVerticalGroup(
            f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jDesktopPane1.add(f7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -36, 1130, 660));

        f8.setVisible(false);

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel63.setText("Supplier ID");

        supplierIDFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supplierIDFiled.setText(" ");
        supplierIDFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierIDFiledActionPerformed(evt);
            }
        });

        jButton65.setBackground(new java.awt.Color(102, 102, 255));
        jButton65.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton65.setForeground(new java.awt.Color(255, 255, 255));
        jButton65.setText("Insert");
        jButton65.setContentAreaFilled(false);
        jButton65.setOpaque(true);
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton66.setBackground(new java.awt.Color(255, 153, 51));
        jButton66.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton66.setForeground(new java.awt.Color(255, 255, 255));
        jButton66.setText("Update");
        jButton66.setContentAreaFilled(false);
        jButton66.setOpaque(true);
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jButton67.setBackground(new java.awt.Color(255, 51, 51));
        jButton67.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton67.setForeground(new java.awt.Color(255, 255, 255));
        jButton67.setText("Delete");
        jButton67.setContentAreaFilled(false);
        jButton67.setOpaque(true);
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jButton68.setBackground(new java.awt.Color(51, 204, 0));
        jButton68.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton68.setForeground(new java.awt.Color(255, 255, 255));
        jButton68.setText("Refresh page");
        jButton68.setContentAreaFilled(false);
        jButton68.setOpaque(true);
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel65.setText(" Mobile Number");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel67.setText("Supplier Name");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel68.setText("Email");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addComponent(supplierIDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(suppnameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supMobileFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierIDFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppnameFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supMobileFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(supEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel66.setText("By Supllier Name");

        jButton69.setBackground(new java.awt.Color(255, 255, 102));
        jButton69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton69.setText("Search");
        jButton69.setContentAreaFilled(false);
        jButton69.setOpaque(true);
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        suplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Mobile Number", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suplierTableMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(suplierTable);
        if (suplierTable.getColumnModel().getColumnCount() > 0) {
            suplierTable.getColumnModel().getColumn(0).setResizable(false);
            suplierTable.getColumnModel().getColumn(1).setResizable(false);
            suplierTable.getColumnModel().getColumn(2).setResizable(false);
            suplierTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setText("Generate Supplier Details as Report");

        jButton72.setBackground(new java.awt.Color(0, 102, 102));
        jButton72.setForeground(new java.awt.Color(255, 255, 255));
        jButton72.setText("Report");
        jButton72.setContentAreaFilled(false);
        jButton72.setOpaque(true);
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Supplier", jPanel54);

        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel74.setText("GRN ID");

        grnIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        grnIdFiled.setText(" ");
        grnIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnIdFiledActionPerformed(evt);
            }
        });

        jButton75.setBackground(new java.awt.Color(102, 102, 255));
        jButton75.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton75.setForeground(new java.awt.Color(255, 255, 255));
        jButton75.setText("Insert");
        jButton75.setContentAreaFilled(false);
        jButton75.setOpaque(true);
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });

        jButton76.setBackground(new java.awt.Color(255, 153, 51));
        jButton76.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton76.setForeground(new java.awt.Color(255, 255, 255));
        jButton76.setText("Update");
        jButton76.setContentAreaFilled(false);
        jButton76.setOpaque(true);
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76ActionPerformed(evt);
            }
        });

        jButton77.setBackground(new java.awt.Color(255, 51, 51));
        jButton77.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton77.setForeground(new java.awt.Color(255, 255, 255));
        jButton77.setText("Delete");
        jButton77.setContentAreaFilled(false);
        jButton77.setOpaque(true);
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });

        jButton78.setBackground(new java.awt.Color(51, 204, 0));
        jButton78.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton78.setForeground(new java.awt.Color(255, 255, 255));
        jButton78.setText("Refresh page");
        jButton78.setContentAreaFilled(false);
        jButton78.setOpaque(true);
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton78ActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel75.setText("Amont");

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel76.setText("Date");

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel77.setText("Supplier  Name");

        grnsupplerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jButton85.setBackground(new java.awt.Color(255, 153, 255));
        jButton85.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton85.setForeground(new java.awt.Color(255, 255, 255));
        jButton85.setText("Supplier");
        jButton85.setContentAreaFilled(false);
        jButton85.setOpaque(true);
        jButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton85ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel60Layout.createSequentialGroup()
                                        .addComponent(grnIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(grndateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel60Layout.createSequentialGroup()
                                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel60Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel60Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(grnAmountField)))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(grnsupplerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(grndateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grnAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnsupplerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRN Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel78.setText("By GRN ID");

        jButton79.setBackground(new java.awt.Color(255, 255, 102));
        jButton79.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton79.setText("Search");
        jButton79.setContentAreaFilled(false);
        jButton79.setOpaque(true);
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });

        grntable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Date", "Amount", "Supplier", "Supplier Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grntable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grntableMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(grntable);
        if (grntable.getColumnModel().getColumnCount() > 0) {
            grntable.getColumnModel().getColumn(0).setResizable(false);
            grntable.getColumnModel().getColumn(1).setResizable(false);
            grntable.getColumnModel().getColumn(2).setResizable(false);
            grntable.getColumnModel().getColumn(3).setResizable(false);
            grntable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel69.setText("Generate Supplier GRN Details as Report");

        jButton73.setBackground(new java.awt.Color(0, 102, 102));
        jButton73.setForeground(new java.awt.Color(255, 255, 255));
        jButton73.setText("Report");
        jButton73.setContentAreaFilled(false);
        jButton73.setOpaque(true);
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grnSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1089, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane4.addTab("Good Recive Note", jPanel43);

        jPanel62.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 204, 0))); // NOI18N

        jPanel63.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRN  Item Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 255, 0))); // NOI18N

        jLabel79.setText("By GRN ID");

        grnitemSearchFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnitemSearchFiledActionPerformed(evt);
            }
        });

        jButton80.setBackground(new java.awt.Color(255, 255, 102));
        jButton80.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton80.setText("Search");
        jButton80.setContentAreaFilled(false);
        jButton80.setOpaque(true);
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });

        grnitemtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Item ID", "Product Name", "Qty", "Product Buy Price", "GRN ID", "MFD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grnitemtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grnitemtableMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(grnitemtable);
        if (grnitemtable.getColumnModel().getColumnCount() > 0) {
            grnitemtable.getColumnModel().getColumn(0).setResizable(false);
            grnitemtable.getColumnModel().getColumn(1).setResizable(false);
            grnitemtable.getColumnModel().getColumn(2).setResizable(false);
            grnitemtable.getColumnModel().getColumn(3).setResizable(false);
            grnitemtable.getColumnModel().getColumn(4).setResizable(false);
            grnitemtable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel70.setText("Generate Supplier GRN Item Details as Report");

        jButton74.setBackground(new java.awt.Color(0, 102, 102));
        jButton74.setForeground(new java.awt.Color(255, 255, 255));
        jButton74.setText("Report");
        jButton74.setContentAreaFilled(false);
        jButton74.setOpaque(true);
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grnitemSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnitemSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel64.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GRN Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel80.setText("GRN IItem D");

        grnItemIdFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        grnItemIdFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnItemIdFiledActionPerformed(evt);
            }
        });

        jButton81.setBackground(new java.awt.Color(102, 102, 255));
        jButton81.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton81.setForeground(new java.awt.Color(255, 255, 255));
        jButton81.setText("Insert");
        jButton81.setContentAreaFilled(false);
        jButton81.setOpaque(true);
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton81ActionPerformed(evt);
            }
        });

        jButton82.setBackground(new java.awt.Color(255, 153, 51));
        jButton82.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton82.setForeground(new java.awt.Color(255, 255, 255));
        jButton82.setText("Update");
        jButton82.setContentAreaFilled(false);
        jButton82.setOpaque(true);
        jButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton82ActionPerformed(evt);
            }
        });

        jButton83.setBackground(new java.awt.Color(255, 51, 51));
        jButton83.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton83.setForeground(new java.awt.Color(255, 255, 255));
        jButton83.setText("Delete");
        jButton83.setContentAreaFilled(false);
        jButton83.setOpaque(true);
        jButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton83ActionPerformed(evt);
            }
        });

        jButton84.setBackground(new java.awt.Color(51, 204, 0));
        jButton84.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton84.setForeground(new java.awt.Color(255, 255, 255));
        jButton84.setText("Refresh page");
        jButton84.setContentAreaFilled(false);
        jButton84.setOpaque(true);
        jButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton84ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel81.setText("Product Buy Price");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel82.setText("Qty");

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel83.setText("GRN ID");

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel84.setText("Product ID");

        grnitemQtyFiled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        grnitemQtyFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnitemQtyFiledActionPerformed(evt);
            }
        });

        grnitemPIdFiled1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        grnitemPIdFiled1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnitemPIdFiled1ActionPerformed(evt);
            }
        });

        grnitemGrnIdFeild.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        grnitemGrnIdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnitemGrnIdFeildActionPerformed(evt);
            }
        });

        jButton86.setBackground(new java.awt.Color(153, 153, 153));
        jButton86.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton86.setForeground(new java.awt.Color(255, 255, 255));
        jButton86.setText("Product");
        jButton86.setContentAreaFilled(false);
        jButton86.setOpaque(true);
        jButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton86ActionPerformed(evt);
            }
        });

        jButton87.setBackground(new java.awt.Color(255, 153, 102));
        jButton87.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton87.setForeground(new java.awt.Color(255, 255, 255));
        jButton87.setText("GRN");
        jButton87.setContentAreaFilled(false);
        jButton87.setOpaque(true);
        jButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton87ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel64Layout.createSequentialGroup()
                                .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel64Layout.createSequentialGroup()
                                .addComponent(grnItemIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel64Layout.createSequentialGroup()
                                .addComponent(grnitemGrnIdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(grnitembuypFiled, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grnitemPIdFiled1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(grnitemQtyFiled, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnItemIdFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnitemPIdFiled1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnitemQtyFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnitembuypFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grnitemGrnIdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1089, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane4.addTab("Good Recive Item", jPanel44);

        javax.swing.GroupLayout f8Layout = new javax.swing.GroupLayout(f8.getContentPane());
        f8.getContentPane().setLayout(f8Layout);
        f8Layout.setHorizontalGroup(
            f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        f8Layout.setVerticalGroup(
            f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jDesktopPane1.add(f8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -26, 1130, 650));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PC - GADGUEST COMPUTER SHOP");

        date.setBackground(new java.awt.Color(255, 153, 153));
        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        time.setBackground(new java.awt.Color(255, 153, 153));
        time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        attConbobt.setBackground(new java.awt.Color(255, 51, 51));
        attConbobt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        attConbobt.setForeground(new java.awt.Color(255, 255, 255));
        attConbobt.setText("Clear");
        attConbobt.setContentAreaFilled(false);
        attConbobt.setOpaque(true);
        attConbobt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attConbobtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
                .addComponent(attConbobt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attentionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(attConbobt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(attentionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Exist");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem9.setText("Home");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem2.setText("Admin");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Customer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Databse");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Supplier");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Employee");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Cachier");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Product");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem10.setText("About");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
void showdate() {

        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        date.setText(s.format(d));
        paymentDateChooser1.setDate(d);
        invoicedate.setDate(d);
    }

    void showtime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                time.setText(s.format(d));

            }
        }).start();

    }

    private void autoId() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id_invoice) FROM pcgadguestshop.invoice ");
            if (rs.next()) {
                int invoiceNo = rs.getInt(1) + 1;
                invoiceIDfiled.setText(Integer.toString(invoiceNo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void load() {

    }

    private void supplierbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierbtActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(true);
    }//GEN-LAST:event_supplierbtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(true);
        f7.setVisible(false);
        f8.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        new logingpage().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void adminbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminbtActionPerformed

        f1.setVisible(false);
        f2.setVisible(true);

    }//GEN-LAST:event_adminbtActionPerformed

    private void customerbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerbtActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(true);

    }//GEN-LAST:event_customerbtActionPerformed

    private void adminIDfiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminIDfiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminIDfiledActionPerformed

    private void customerIDfiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDfiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDfiledActionPerformed

    private void backpPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backpPathActionPerformed

        JFileChooser backupPathfilebt = new JFileChooser();
        int returnval = backupPathfilebt.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            String selectedFilename = backupPathfilebt.getSelectedFile().getName();
            String selectedFilepath = backupPathfilebt.getCurrentDirectory().getPath();

            String backuppath = selectedFilepath + "//" + selectedFilename;
            backupField.setText(backuppath);
        }

    }//GEN-LAST:event_backpPathActionPerformed

    private void backbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtActionPerformed

        String backuppath = backupField.getText();
        System.out.println(backuppath);
        String result = new backResoreCode().backupDb(backuppath);
        JOptionPane.showConfirmDialog(backbt, result, "info", -1, 1);

        backupField.setText("");

    }//GEN-LAST:event_backbtActionPerformed

    private void resotrePathbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resotrePathbtActionPerformed

        JFileChooser restorePathfilebt = new JFileChooser();
        int returnvall = restorePathfilebt.showOpenDialog(this);
        if (returnvall == JFileChooser.APPROVE_OPTION) {
            String selectedFilename = restorePathfilebt.getSelectedFile().getName();
            String selectedFilepath = restorePathfilebt.getCurrentDirectory().getPath();

            String resotre = selectedFilepath + "//" + selectedFilename;
            restoreField.setText(resotre);
        }

    }//GEN-LAST:event_resotrePathbtActionPerformed

    private void restorebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restorebtActionPerformed

        String restorepath = restoreField.getText();
        System.out.println(restorepath);
        String result = new backResoreCode().restore(restorepath);
        JOptionPane.showConfirmDialog(restorebt, result, "info", -1, 1);
        restoreField.setText("");

    }//GEN-LAST:event_restorebtActionPerformed

    private void databasebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databasebtActionPerformed

        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(true);
    }//GEN-LAST:event_databasebtActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        new customerReportjDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void invoiceIDfiledadminIDfiled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceIDfiledadminIDfiled1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceIDfiledadminIDfiled1ActionPerformed

    private void cutomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutomerActionPerformed

        new addNewcutomerDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_cutomerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String aId = adminIDfiled.getText();
        String username = adminusernameField.getText();
        char[] passwordArr = passwordField.getPassword();
        String password = new String(passwordArr, 0, passwordArr.length);
        Object a = admintypeCombo.getSelectedItem();
        String usertype = String.valueOf(a);
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Username", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Password", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String insertAdmin = adminM.insertAdmin(username, password, usertype);
            JOptionPane.showMessageDialog(this, "Insert Details", "massege", JOptionPane.INFORMATION_MESSAGE);
            adminusernameField.setText("");
            passwordField.setText("");
            adminM.loadtableAdmin("", admintdm);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String keyword = adminSearchFiled.getText();
        adminM.loadtableAdmin(keyword, admintdm);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void admintableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admintableMouseClicked
        int row = admintable.getSelectedRow();
        int adminId = (int) admintdm.getValueAt(row, 0);
        Object[] admindata = adminM.getSelectId(adminId);
        // adminIDfiled.setText(new String(admindata[0]+""));
        adminIDfiled.setText(String.valueOf(admindata[0]));
        adminusernameField.setText((String) admindata[1]);
        passwordField.setText((String) admindata[2]);
        admintypeCombo.setSelectedItem((String) admindata[3]);
    }//GEN-LAST:event_admintableMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String aId = adminIDfiled.getText();
        String username = adminusernameField.getText();
        char[] passwordArr = passwordField.getPassword();
        String password = new String(passwordArr, 0, passwordArr.length);
        Object a = admintypeCombo.getSelectedItem();
        String usertype = String.valueOf(a);
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds are emply?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds are emply?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String updateAdmin = adminM.updateadmin(aId, username, password, usertype);
            JOptionPane.showMessageDialog(this, "Updated Details", "massege", JOptionPane.OK_CANCEL_OPTION);
            adminIDfiled.setText("");
            adminusernameField.setText("");
            passwordField.setText("");
            adminM.loadtableAdmin("", admintdm);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String aId = adminIDfiled.getText();
        String username = adminusernameField.getText();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select data From Table!", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String deleteAdmin = adminM.deleteAdmin(aId);

            JOptionPane.showMessageDialog(this, "Deleted Details", "massege", JOptionPane.QUESTION_MESSAGE);
            adminIDfiled.setText("");
            adminusernameField.setText("");
            passwordField.setText("");
            adminM.loadtableAdmin("", admintdm);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String cusId = customerIDfiled.getText();
        String customername = customernameFiled.getText();
        String customerModile = customerMdeilfiled.getText();

        if (customerModile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (customername.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Customer Name", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String insertcustomer = customerM.insertCustomer(customername, customerModile);

            JOptionPane.showConfirmDialog(rootPane, insertcustomer, "Massege", -1, 1);

            customerIDfiled.setText("");
            customernameFiled.setText("");
            customerMdeilfiled.setText("");
            customerM.loadtableAdmin("", customertdm);
            customerM.loadtableAdmin("", customer2tdm);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        String keyword = customerSearchfiled.getText();
        customerM.loadtableAdmin(keyword, customertdm);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void customertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customertableMouseClicked

        int row = customertable.getSelectedRow();
        String cusId = (String) customertdm.getValueAt(row, 0);
        Object[] customerdata = customerM.getSelectId(cusId);

        customerIDfiled.setText(String.valueOf(customerdata[0]));
        customerMdeilfiled.setText((String) customerdata[1]);
        customernameFiled.setText((String) customerdata[2]);
    }//GEN-LAST:event_customertableMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String cusId = customerIDfiled.getText();
        String customername = customernameFiled.getText();
        String customerModile = customerMdeilfiled.getText();

        if (customername.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds ", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (customerModile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds ", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String updateCustomer = customerM.updateCustomer(cusId, customername, customerModile);
            JOptionPane.showConfirmDialog(rootPane, updateCustomer, "Massege", -1, 1);
            customerIDfiled.setText("");
            customernameFiled.setText("");
            customerMdeilfiled.setText("");
            customerM.loadtableAdmin("", customertdm);
            customerM.loadtableAdmin("", customer2tdm);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String cusId = customerIDfiled.getText();
        String customername = customernameFiled.getText();
        if (customername.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select data from table! ", "massege", JOptionPane.QUESTION_MESSAGE);
            System.out.println("cuid" + cusId);
        } else {
            String deleteCustomer = customerM.deleteCustomer(cusId);
            JOptionPane.showMessageDialog(this, deleteCustomer, "massege", JOptionPane.QUESTION_MESSAGE);
            System.out.println("cuid" + cusId);
            customerIDfiled.setText("");
            customernameFiled.setText("");
            customerMdeilfiled.setText("");
            customerM.loadtableAdmin("", customertdm);
            customerM.loadtableAdmin("", customer2tdm);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void supplierIDFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierIDFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierIDFiledActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed

        String sid = supplierIDFiled.getText();
        String sname = suppnameFiled.getText();
        String sMbile = supMobileFiled.getText();
        String sEmail = supEmailField.getText();

        if (sname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Insert supplier name", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (sMbile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Insert Supplier Mobile", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String inserts = suplierM.inserSuplier(sname, sMbile, sEmail);
            JOptionPane.showMessageDialog(this, inserts, "massege", JOptionPane.INFORMATION_MESSAGE);
            supplierIDFiled.setText("");
            suppnameFiled.setText("");
            supMobileFiled.setText("");
            supEmailField.setText("");
            suplierM.loadtable("", supliertdm);
            component();
        }
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        String sid = supplierIDFiled.getText();
        String sname = suppnameFiled.getText();
        String sMbile = supMobileFiled.getText();
        String sEmail = supEmailField.getText();
//        if(sname.isEmpty()){
//             JOptionPane.showMessageDialog(this, "Please Enter Supplier Name", "massege", JOptionPane.INFORMATION_MESSAGE);
//        }else 
        if (sMbile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From Table", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String update = suplierM.updateSuplier(sid, sname, sMbile, sEmail);
            JOptionPane.showMessageDialog(this, update, "massege", JOptionPane.OK_CANCEL_OPTION);
            supplierIDFiled.setText("");
            suppnameFiled.setText("");
            supMobileFiled.setText("");
            supEmailField.setText("");
            suplierM.loadtable("", supliertdm);
            component();
        }
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        String sid = supplierIDFiled.getText();
        String delete = suplierM.deleteSuplier(sid);
        String sMbile = supMobileFiled.getText();
        if (sMbile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From Table", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, delete, "massege", JOptionPane.QUESTION_MESSAGE);
            supplierIDFiled.setText("");
            suppnameFiled.setText("");
            supMobileFiled.setText("");
            supEmailField.setText("");
            suplierM.loadtable("", supliertdm);
            component();
        }
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        String keyword = supSearchFiled.getText();
        suplierM.loadtable(keyword, supliertdm);
    }//GEN-LAST:event_jButton69ActionPerformed

    private void suplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suplierTableMouseClicked
        int row = suplierTable.getSelectedRow();
        String sid = (String) supliertdm.getValueAt(row, 0);
        Object[] supllierdata = suplierM.detselectid(sid);
        supplierIDFiled.setText(String.valueOf(supllierdata[0]));
        suppnameFiled.setText((String) supllierdata[1]);
        supMobileFiled.setText((String) supllierdata[2]);
        supEmailField.setText((String) supllierdata[3]);
    }//GEN-LAST:event_suplierTableMouseClicked

    private void grnIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnIdFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grnIdFiledActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed

        String grnid = grnIdFiled.getText();
        Date grndate = grndateChooser.getDate();
        String amunt = grnAmountField.getText();
        Object o = grnsupplerCombo.getSelectedItem();
        String suplier = String.valueOf(o);

        if (amunt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pleace Check Data input fields are empty?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String insert = grnM.insertgrn(grndate, amunt, suplier);
            JOptionPane.showMessageDialog(this, insert, "massege", JOptionPane.INFORMATION_MESSAGE);
            grnIdFiled.setText("");
            grndateChooser.setDate(null);
            grnAmountField.setText("");
            grnM.loadtable("", grntdm);

            String setgid = "SELECT MAX(id_grn) FROM pcgadguestshop.grn";
            try {
                PreparedStatement ps3 = con.prepareStatement(setgid);
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {

                    String gid = rs3.getString("MAX(id_grn)");
                    System.out.println(gid);
                    grnitemGrnIdFeild.setText(gid);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed
        String grnid = grnIdFiled.getText();
        Date grndate = grndateChooser.getDate();
        String amunt = grnAmountField.getText();
        Object o = grnsupplerCombo.getSelectedItem();
        String suplier = String.valueOf(o);
        if (amunt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pleace Select data from table", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String update = grnM.updategrn(grnid, grndate, amunt, suplier);
            JOptionPane.showMessageDialog(this, update, "massege", JOptionPane.OK_CANCEL_OPTION);
            grnIdFiled.setText("");
            grndateChooser.setDate(null);
            grnAmountField.setText("");
            grnM.loadtable("", grntdm);
        }
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        String grnid = grnIdFiled.getText();
        String amunt = grnAmountField.getText();
        if (amunt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pleace Select data from table", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String delete = grnM.deletegrn(grnid);
            JOptionPane.showMessageDialog(this, "Delete SuccessFully", "massege", JOptionPane.QUESTION_MESSAGE);
            grnIdFiled.setText("");
            grndateChooser.setDate(null);
            grnAmountField.setText("");
            grnM.loadtable("", grntdm);
        }
    }//GEN-LAST:event_jButton77ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        String keyword = grnSearchFiled.getText();
        grnM.loadtable(keyword, grntdm);
    }//GEN-LAST:event_jButton79ActionPerformed

    private void grntableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grntableMouseClicked

        int row = grntable.getSelectedRow();
        String grid = (String) grntdm.getValueAt(row, 0);
        Object[] grndata = grnM.getselectid(grid);
        grnIdFiled.setText(String.valueOf(grndata[0]));
        grndateChooser.setDate((Date) grndata[1]);
        grnAmountField.setText((String) grndata[2]);
        grnsupplerCombo.setSelectedItem((String) grndata[3]);
    }//GEN-LAST:event_grntableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(false);
        f7.setVisible(true);
        f8.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed

        String keyword = grnitemSearchFiled.getText();
        grnitemM.loadtable(keyword, grnitemtdm);
    }//GEN-LAST:event_jButton80ActionPerformed

    private void grnitemtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnitemtableMouseClicked
        int row = grnitemtable.getSelectedRow();
        String grnitemid = (String) grnitemtdm.getValueAt(row, 0);
        Object[] grnitemdata = grnitemM.getselectid(grnitemid);
        grnItemIdFiled.setText(((String) grnitemdata[0]));
        grnitemPIdFiled1.setText(((String) grnitemdata[1]));
        grnitemQtyFiled.setText(((String) grnitemdata[2]));
        grnitembuypFiled.setText(((String) grnitemdata[3]));
        grnitemGrnIdFeild.setText(((String) grnitemdata[4]));
        // grnMfdDateChooser.setDate((Date) grnitemdata[5]);
    }//GEN-LAST:event_grnitemtableMouseClicked

    private void grnItemIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnItemIdFiledActionPerformed
        // TODO add your handling code here:g
    }//GEN-LAST:event_grnItemIdFiledActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed

        String grnitemid = grnItemIdFiled.getText();
        String pid = grnitemPIdFiled1.getText();
        String qty = grnitemQtyFiled.getText();

        String buyprice = grnitembuypFiled.getText();
        String grnid = grnitemGrnIdFeild.getText();
        // Date grnMfd = grnMfdDateChooser.getDate();

        if (pid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Insert Product ID", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Insert qty", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (buyprice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plaase Insert buprice", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (grnid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Insert GRN ID", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String insert = grnitemM.insergrnitem(pid, qty, buyprice, grnid);
            removeStocks();
            stocks();
            JOptionPane.showMessageDialog(this, "Insert Details", "massege", JOptionPane.INFORMATION_MESSAGE);
            grnItemIdFiled.setText("");
            grnitemPIdFiled1.setText("");
            grnitemQtyFiled.setText("");
            grnitembuypFiled.setText("");
            grnitemGrnIdFeild.setText("");

            grnitemM.loadtable("", grnitemtdm);
            stockM.loadStocktb("", stocktdm);
        }
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
        String grnitemid = grnItemIdFiled.getText();
        String pid = grnitemPIdFiled1.getText();
        String qty = grnitemQtyFiled.getText();
        String buyprice = grnitembuypFiled.getText();
        String grnid = grnitemGrnIdFeild.getText();
        // Date grnMfd = grnMfdDateChooser.getDate();

        if (pid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Somthing wrong Check Data Input Filed", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (grnid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Somthing wrong Check Data Input Filed", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String update = grnitemM.updategrnitem(grnitemid, pid, qty, buyprice, grnid);
            stocks();
            JOptionPane.showMessageDialog(this, "Updated Details", "massege", JOptionPane.OK_CANCEL_OPTION);
            grnItemIdFiled.setText("");
            grnitemPIdFiled1.setText("");
            grnitemQtyFiled.setText("");
            grnitembuypFiled.setText("");
            grnitemGrnIdFeild.setText("");
            // grnMfdDateChooser.setDate(null);
            grnitemM.loadtable("", grnitemtdm);
            stockM.loadStocktb("", stocktdm);
        }
    }//GEN-LAST:event_jButton82ActionPerformed

    private void jButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton83ActionPerformed
        String grnitemid = grnItemIdFiled.getText();
        String pid = grnitemPIdFiled1.getText();
        String qty = grnitemQtyFiled.getText();
        if (pid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From table", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String delete = grnitemM.deletegrnitem(grnitemid, qty, pid);
            stocks();
            JOptionPane.showMessageDialog(this, "Deleted Details", "massege", JOptionPane.QUESTION_MESSAGE);
            grnItemIdFiled.setText("");
            grnitemPIdFiled1.setText("");
            grnitemQtyFiled.setText("");
            grnitembuypFiled.setText("");
            grnitemGrnIdFeild.setText("");

            grnitemM.loadtable("", grnitemtdm);
            stockM.loadStocktb("", stocktdm);
        }
    }//GEN-LAST:event_jButton83ActionPerformed

    private void grnitemQtyFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnitemQtyFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grnitemQtyFiledActionPerformed

    private void grnitemPIdFiled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnitemPIdFiled1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grnitemPIdFiled1ActionPerformed

    private void grnitemGrnIdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnitemGrnIdFeildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grnitemGrnIdFeildActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        new supplerReportDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton85ActionPerformed
        new suppliertableDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton85ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        new grnInvoiceDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton86ActionPerformed
        new productDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton86ActionPerformed

    private void jButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton87ActionPerformed
        new grntableDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton87ActionPerformed

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        new grnitemReportDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton74ActionPerformed

    private void grnitemSearchFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnitemSearchFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grnitemSearchFiledActionPerformed

    private void customerSearchfiledKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerSearchfiledKeyTyped
        String keyword = customerSearchfiled.getText();
        customerM.loadtableAdmin(keyword, customertdm);
    }//GEN-LAST:event_customerSearchfiledKeyTyped

    private void stokstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokstableMouseClicked

        int row = stokstable.getSelectedRow();
        String id = (String) stocktdm.getValueAt(row, 0);
        Object[] stockdata = stockM.getselecedid(id);
        stocksIdFiled.setText(((String) stockdata[0]));
        StocksPIdFiled.setText(((String) stockdata[1]));
        StocksQtyFiled1.setText(((String) stockdata[2]));
        // stocksMfdChooser.setDate((Date) stockdata[3]);
    }//GEN-LAST:event_stokstableMouseClicked

    private void jButton92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton92ActionPerformed
        String keyword = stocksSearchFiled.getText();
        stockM.loadStocktb(keyword, stocktdm);
    }//GEN-LAST:event_jButton92ActionPerformed

    private void jButton93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton93ActionPerformed
        new productDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton93ActionPerformed

    private void jButton90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton90ActionPerformed
        String stid = stocksIdFiled.getText();
        String stpid = StocksPIdFiled.getText();
        String stqty = StocksQtyFiled1.getText();

        if (stid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select Data from table", "massege", JOptionPane.QUESTION_MESSAGE);
        } else if (stqty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select Data from table", "massege", JOptionPane.QUESTION_MESSAGE);
        } else {

            String delete = stockM.deleteStock(stid);
            stocks();
            JOptionPane.showMessageDialog(this, delete, "massege", JOptionPane.QUESTION_MESSAGE);
            stocksIdFiled.setText("");
            StocksPIdFiled.setText("");
            StocksQtyFiled1.setText("");

            stockM.loadStocktb("", stocktdm);
        }
    }//GEN-LAST:event_jButton90ActionPerformed

    private void jButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton89ActionPerformed
        String stid = stocksIdFiled.getText();
        String stpid = StocksPIdFiled.getText();
        String stqty = StocksQtyFiled1.getText();

        if (stid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot Update Please Check input Fileds!", "massege", JOptionPane.QUESTION_MESSAGE);
        } else if (stqty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot Update Please Check input Fileds!", "massege", JOptionPane.QUESTION_MESSAGE);
        } else {

            String update = stockM.updatetStock(stid, stpid, stqty);
            stocks();
            JOptionPane.showMessageDialog(this, update, "massege", JOptionPane.QUESTION_MESSAGE);
            stocksIdFiled.setText("");
            StocksPIdFiled.setText("");
            StocksQtyFiled1.setText("");

            stockM.loadStocktb("", stocktdm);
        }
    }//GEN-LAST:event_jButton89ActionPerformed

    private void jButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton88ActionPerformed
        String stid = stocksIdFiled.getText();
        String stpid = StocksPIdFiled.getText();
        String stqty = StocksQtyFiled1.getText();

        if (stpid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product ID", "massege", JOptionPane.QUESTION_MESSAGE);
        } else if (stqty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Qty", "massege", JOptionPane.QUESTION_MESSAGE);
        } else {

            String inter = stockM.insertStock(stpid, stqty);
            JOptionPane.showMessageDialog(this, inter, "massege", JOptionPane.QUESTION_MESSAGE);
            stocksIdFiled.setText("");
            StocksPIdFiled.setText("");
            StocksQtyFiled1.setText("");
            stocks();
            //   stocksMfdChooser.setDate(null);

            stockM.loadStocktb("", stocktdm);
        }
    }//GEN-LAST:event_jButton88ActionPerformed

    private void stocksIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksIdFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stocksIdFiledActionPerformed

    private void categorytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorytableMouseClicked

        int row = categorytable.getSelectedRow();
        String cid = (String) categorytdm.getValueAt(row, 0);
        Object[] categorydata = categoryM.getselectid(cid);
        categoryIdFiled.setText(String.valueOf(categorydata[0]));
        categoryNameFiled.setText((String) categorydata[1]);
    }//GEN-LAST:event_categorytableMouseClicked

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        String keyword = categorySearchFiled.getText();
        categoryM.loadtable(keyword, categorytdm);
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        String id = categoryIdFiled.getText();
        String name = categoryNameFiled.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From Table", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String deleteCategoty = categoryM.deletecate(id);
            JOptionPane.showMessageDialog(this, deleteCategoty, "massege", JOptionPane.QUESTION_MESSAGE);
            categoryIdFiled.setText("");
            categoryNameFiled.setText("");
            categoryM.loadtable("", categorytdm);
            component();
        }
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        String id = categoryIdFiled.getText();
        String name = categoryNameFiled.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Feilds", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String updateCategoty = categoryM.updateCate(id, name);
            JOptionPane.showMessageDialog(this, updateCategoty, "massege", JOptionPane.OK_CANCEL_OPTION);
            categoryIdFiled.setText("");
            categoryNameFiled.setText("");
            categoryM.loadtable("", categorytdm);
            component();
        }
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        String id = categoryIdFiled.getText();
        String name = categoryNameFiled.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Name", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String insertcategory = categoryM.insertcate(name);
            JOptionPane.showMessageDialog(this, insertcategory, "massege", JOptionPane.INFORMATION_MESSAGE);
            categoryIdFiled.setText("");
            categoryNameFiled.setText("");
            categoryM.loadtable("", categorytdm);
            component();
        }
    }//GEN-LAST:event_jButton55ActionPerformed

    private void categoryIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryIdFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryIdFiledActionPerformed

    private void producttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producttableMouseClicked

        int row = producttable.getSelectedRow();
        String proid = (String) producttdm.getValueAt(row, 0);
        Object[] productdata = productM.getselectid(proid);

        prodIdFiled.setText(String.valueOf(productdata[0]));
        proNameFiled.setText((String) productdata[1]);
        prosellFiled.setText((String) productdata[2]);
        procategoryComboo.setSelectedItem((String) productdata[3]);
        partSelectCombo.setSelectedItem((String) productdata[4]);
    }//GEN-LAST:event_producttableMouseClicked

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        String keyword = proSearchFiled.getText();
        productM.loadtable(keyword, producttdm);
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        String pid = prodIdFiled.getText();
        String pname = proNameFiled.getText();
        //  String pqty = proQtyFied.getText();
        String psellprice = prosellFiled.getText();

        if (pname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (psellprice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String delete = productM.deletepro(pid);
            JOptionPane.showMessageDialog(this, "Deleted Details", "massege", JOptionPane.QUESTION_MESSAGE);
            prodIdFiled.setText("");
            proNameFiled.setText("");
            //   proQtyFied.setText("");
            prosellFiled.setText("");

            productM.loadtable("", producttdm);
        }
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        String pid = prodIdFiled.getText();
        String pname = proNameFiled.getText();
        //  String pqty = proQtyFied.getText();
        String psellprice = prosellFiled.getText();

        Object o = procategoryComboo.getSelectedItem();
        String pcategory = String.valueOf(o);
        Object o2 = partSelectCombo.getSelectedItem();
        String pacc = String.valueOf(o2);

        if (pname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (psellprice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Input Fileds?", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String update = productM.updatepro(pid, pname, psellprice, pcategory, pacc);
            JOptionPane.showMessageDialog(this, update, "massege", JOptionPane.OK_CANCEL_OPTION);
            prodIdFiled.setText("");
            proNameFiled.setText("");
            //  proQtyFied.setText("");
            prosellFiled.setText("");

            productM.loadtable("", producttdm);
        }
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        String pid = prodIdFiled.getText();
        String pname = proNameFiled.getText();
        //String pqty = proQtyFied.getText();
        String psellprice = prosellFiled.getText();

        Object o = procategoryComboo.getSelectedItem();
        String pcategory = String.valueOf(o);
        Object o2 = partSelectCombo.getSelectedItem();
        String pacc = String.valueOf(o2);
        System.out.println(pacc);

        if (pname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Name", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else if (psellprice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Sell Price", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String insertp = productM.insertpro(pname, psellprice, pcategory, pacc);
            JOptionPane.showMessageDialog(this, insertp, "massege", JOptionPane.INFORMATION_MESSAGE);
            prodIdFiled.setText("");
            proNameFiled.setText("");
            //  proQtyFied.setText("");
            prosellFiled.setText("");

            productM.loadtable("", producttdm);
        }
    }//GEN-LAST:event_jButton60ActionPerformed

    private void prodIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodIdFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodIdFiledActionPerformed

    private void accessoryIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessoryIdFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accessoryIdFiledActionPerformed

    private void jButton94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton94ActionPerformed
        String getAccid = accessoryIdFiled.getText();
        String getAccname = accessoryNameFiled.getText();
        if (getAccname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Insert Accrssory Name!", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String insert = accessotyM.insertAcc(getAccname);
            JOptionPane.showMessageDialog(this, insert, "massege", JOptionPane.INFORMATION_MESSAGE);
            accessoryIdFiled.setText("");
            accessoryNameFiled.setText("");
            accessotyM.loadtable("", accessorytdm);
            component();

        }
    }//GEN-LAST:event_jButton94ActionPerformed

    private void jButton95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton95ActionPerformed
        String vaccidd = accessoryIdFiled.getText();
        String vaccnamee = accessoryNameFiled.getText();
        System.out.println(vaccidd);
        System.out.println(vaccnamee);
        if (vaccnamee.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check input fileds are empty!", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String update = accessotyM.updateacc(vaccidd, vaccnamee);
            JOptionPane.showMessageDialog(this, update, "massege", JOptionPane.INFORMATION_MESSAGE);
            accessoryIdFiled.setText("");
            accessoryNameFiled.setText("");
            accessotyM.loadtable("", accessorytdm);
            component();
        }
    }//GEN-LAST:event_jButton95ActionPerformed

    private void jButton96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton96ActionPerformed
        String getAccid = accessoryIdFiled.getText();
        String getAccname = accessoryNameFiled.getText();
        if (getAccname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data from table!", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String delete = accessotyM.deleteAcc(getAccid);
            JOptionPane.showMessageDialog(this, delete, "massege", JOptionPane.INFORMATION_MESSAGE);
            accessoryIdFiled.setText("");
            accessoryNameFiled.setText("");
            accessotyM.loadtable("", accessorytdm);
            component();
        }
    }//GEN-LAST:event_jButton96ActionPerformed

    private void jButton98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton98ActionPerformed
        String keyword = accessorySearchFiled.getText();
        accessotyM.loadtable(keyword, accessorytdm);
    }//GEN-LAST:event_jButton98ActionPerformed

    private void accessoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoryTableMouseClicked
        int row = accessoryTable.getSelectedRow();
        int id = (int) accessorytdm.getValueAt(row, 0);
        Object[] accdata = accessotyM.getselectid(id);
        accessoryIdFiled.setText((String) accdata[0]);
        accessoryNameFiled.setText((String) accdata[1]);
    }//GEN-LAST:event_accessoryTableMouseClicked

    private void partSelectComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partSelectComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partSelectComboActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        home h = new home();
        h.component();
        prodIdFiled.setText("");
        proNameFiled.setText("");
        //  proQtyFied.setText("");
        prosellFiled.setText("");

        productM.loadtable("", producttdm);
        String category = "SELECT * FROM pcgadguestshop.category";
        try {
            PreparedStatement ps = con.prepareStatement(category);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("categor_name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            procategoryComboo.setModel(dcm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        new productreportDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        new stockreportDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton53ActionPerformed

    private void totalFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalFiledActionPerformed

    private void balanceFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceFiledActionPerformed

    private void paymentFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentFiledActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        balance();
        String invid = invoiceIDfiled.getText();
        String cusmob = cuMobileFiled.getText();
        String invTotal = totalFiled.getText();
        String payment = paymentFiled.getText();
        String balance = balanceFiled.getText();
        Date pdate = invoicedate.getDate();

        if (pdate.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter payment date", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String inserInv = invoiceM.insertinv(invid, cusmob, invTotal, pdate);
            invoiceItemM.loadtableitem("", invoiceItemtdm);
            invoiceItemM.loadtableitem("", invoiceItemtdm);
            stocks();
            System.out.println(invid);

            JOptionPane.showMessageDialog(this, inserInv, "massege", JOptionPane.INFORMATION_MESSAGE);

            autoId();

            for (int i = 0; i < invoicebuytable.getRowCount(); i++) {
                String iPId = (String) invoicebuyitemtdm.getValueAt(i, 0);
                String iqty = (String) invoicebuyitemtdm.getValueAt(i, 2);
                System.out.println(iPId + "" + iqty);
                String invoiceItem = invoiceM.insertItem(iPId, iqty, invid);
                String stockupdate = invoiceM.updateStock(iPId, iqty);
            }

            invoicebuyitemtdm.setRowCount(0);
            invoiceItemM.loadtableitem("", invoiceItemtdm);

            try {

                String getid = "SELECT id_invoice FROM pcgadguestshop.invoice WHERE id_invoice=?";
                PreparedStatement ps = con.prepareStatement(getid);
                ps.setString(1, invid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("id_invoice");
                    System.out.println(id + "id");
                    String idd = "11";
                    String reportPath = "C:\\Users\\Acer\\JaspersoftWorkspace\\MyReports\\bill11.jrxml";
                    Map m = new HashMap();
                    m.put("p1", id);
                    m.put("cpayment", payment);
                    m.put("balance", balance);

                    try {

                        JasperReport jr = JasperCompileManager.compileReport(reportPath);
                        JasperPrint jp = JasperFillManager.fillReport(jr, m, con);
                        JRViewer jvv = new JRViewer(jp);

                        billframe bf = new billframe();
                        bf.billtabepane.add(jvv);
                        bf.setVisible(true);
                        // billtabe.add(jvv);
                        stockM.loadStocktb("", stocktdm);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totalFiled.setText("");
            paymentFiled.setText("");
            balanceFiled.setText("");
            cuMobileFiled.setText("Guest");

        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void cuMobileFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuMobileFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuMobileFiledActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        String keyword = invoiceCustomersearchfiled.getText();
        customerM.loadtableAdmin(keyword, customer2tdm);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void priceFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFiledActionPerformed


    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed

        invoiceProducttdm.addRow(new Object[]{
            porodictid.getText(), pnamefiled.getText(), qty2Filed.getText(), priceFiled.getText(), amountFiled.getText()
        });

        double sum = 0;
        for (double i = 0; i < invoicebuytable.getRowCount(); i++) {
            sum = sum + Double.parseDouble(invoicebuytable.getValueAt((int) i, 4).toString());

        }
        totalFiled.setText(Double.toString(sum));
        porodictid.setText("");
        pnamefiled.setText("");
        priceFiled.setText("");
        amountFiled.setText("");
        qty2Filed.setText("0");
        porodictid.requestFocus();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void porodictidadminIDfiled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porodictidadminIDfiled1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porodictidadminIDfiled1ActionPerformed

    private void pnamefiledadminIDfiled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnamefiledadminIDfiled1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnamefiledadminIDfiled1ActionPerformed

    private void porodictidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porodictidKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String pid = porodictid.getText();

                Object[] getpdetails = invoiceM.searchProduct(pid);
                // JOptionPane.showMessageDialog((Component) getpdetails[2], "Please Select Data from table!", "massege", JOptionPane.INFORMATION_MESSAGE);
                pnamefiled.setText((String) getpdetails[0]);
                priceFiled.setText((String) getpdetails[1]);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_porodictidKeyPressed

    private void cutomer2tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cutomer2tableMouseClicked
        int row = cutomer2table.getSelectedRow();
        String cusId = (String) customer2tdm.getValueAt(row, 0);
        Object[] customerdata = customerM.getSelectId(cusId);

        cuMobileFiled.setText(String.valueOf(customerdata[1]));
    }//GEN-LAST:event_cutomer2tableMouseClicked

    private void invoicebuytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoicebuytableMouseClicked

        int row = invoicebuytable.getSelectedRow();
        porodictid.setText(String.valueOf(invoiceProducttdm.getValueAt(row, 0)));
        pnamefiled.setText(String.valueOf(invoiceProducttdm.getValueAt(row, 1)));
        qty2Filed.setText(String.valueOf(invoiceProducttdm.getValueAt(row, 2)));
        priceFiled.setText(String.valueOf(invoiceProducttdm.getValueAt(row, 3)));
        amountFiled.setText(String.valueOf(invoiceProducttdm.getValueAt(row, 4)));

    }//GEN-LAST:event_invoicebuytableMouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        int row = invoicebuytable.getSelectedRow();
        invoicebuyitemtdm.removeRow(row);

        double sum = 0;
        for (double i = 0; i < invoicebuytable.getRowCount(); i++) {
            sum = sum + Double.parseDouble(invoicebuytable.getValueAt((int) i, 4).toString());

        }
        totalFiled.setText(Double.toString(sum));
        porodictid.setText("");
        pnamefiled.setText("");
        priceFiled.setText("");
        amountFiled.setText("");
        // qtySpinner.setValue(0);
        porodictid.requestFocus();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String keyword = searchfiled3.getText();
        invoiceM.loadtableInvoice(keyword, invoicedatatdm);
        invoiceItemM.loadtableitem("", invoiceItemtdm);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        customerM.loadtableAdmin("", customer2tdm);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        new invoiceReportDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        adminIDfiled.setText("");
        adminusernameField.setText("");
        passwordField.setText("");
        adminM.loadtableAdmin("", admintdm);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        customerIDfiled.setText("");
        customernameFiled.setText("");
        customerMdeilfiled.setText("");
        customerM.loadtableAdmin("", customertdm);
        customerM.loadtableAdmin("", customer2tdm);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        totalFiled.setText("");
        paymentFiled.setText("");
        balanceFiled.setText("");
        invoicedate.setDate(null);
        cuMobileFiled.setText("Guest");
        porodictid.setText("");
        pnamefiled.setText("");
        priceFiled.setText("");
        amountFiled.setText("");
        customerM.loadtableAdmin("", customer2tdm);
        invoiceItemM.loadtableitem("", invoiceItemtdm);
        invoiceM.loadtableInvoice("", invoicedatatdm);

    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        categoryIdFiled.setText("");
        categoryNameFiled.setText("");
        categoryM.loadtable("", categorytdm);
        component();
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton97ActionPerformed
        accessoryIdFiled.setText("");
        accessoryNameFiled.setText("");
        accessotyM.loadtable("", accessorytdm);
        component();
    }//GEN-LAST:event_jButton97ActionPerformed

    private void jButton91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton91ActionPerformed
        stocksIdFiled.setText("");
        StocksPIdFiled.setText("");
        StocksQtyFiled1.setText("");
        //   stocksMfdChooser.setDate(null);

        stockM.loadStocktb("", stocktdm);
    }//GEN-LAST:event_jButton91ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        supplierIDFiled.setText("");
        suppnameFiled.setText("");
        supMobileFiled.setText("");
        supEmailField.setText("");
        suplierM.loadtable("", supliertdm);
        component();
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        grnIdFiled.setText("");
        grndateChooser.setDate(null);
        grnAmountField.setText("");
        grnM.loadtable("", grntdm);
    }//GEN-LAST:event_jButton78ActionPerformed

    private void jButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton84ActionPerformed
        grnItemIdFiled.setText("");
        grnitemPIdFiled1.setText("");
        grnitemQtyFiled.setText("");
        grnitembuypFiled.setText("");
        grnitemGrnIdFeild.setText("");
        // grnMfdDateChooser.setDate(null);
        grnitemM.loadtable("", grnitemtdm);
    }//GEN-LAST:event_jButton84ActionPerformed

    private void qty2FiledKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty2FiledKeyTyped

    }//GEN-LAST:event_qty2FiledKeyTyped

    private void qty2FiledKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty2FiledKeyReleased
        String qt = qty2Filed.getText();

        if (qt != null) {
            int qty = Integer.parseInt(qt);
            double price = Double.parseDouble(priceFiled.getText());

            double total = qty * price;

            amountFiled.setText(String.valueOf(total));
        } else {
            amountFiled.setText("");
        }
    }//GEN-LAST:event_qty2FiledKeyReleased

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        int i = invoicebuytable.getSelectedRow();
        if (i >= 0) {
            invoicebuyitemtdm.setValueAt(porodictid.getText(), i, 0);
            invoicebuyitemtdm.setValueAt(qty2Filed.getText(), i, 2);
            invoicebuyitemtdm.setValueAt(priceFiled.getText(), i, 3);
            invoicebuyitemtdm.setValueAt(amountFiled.getText(), i, 4);

            porodictid.setText("");
            pnamefiled.setText("");
            priceFiled.setText("");
            amountFiled.setText("");
            qty2Filed.setText("0");

        }

        double sum = 0;
        for (double m = 0; m < invoicebuytable.getRowCount(); m++) {
            sum = sum + Double.parseDouble(invoicebuytable.getValueAt((int) m, 4).toString());

        }
        totalFiled.setText(Double.toString(sum));
    }//GEN-LAST:event_jButton39ActionPerformed

    private void qty2FiledKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty2FiledKeyPressed

    }//GEN-LAST:event_qty2FiledKeyPressed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        String keyword = itemsearchfiled.getText();
        invoiceItemM.loadtableitem(keyword, invoiceItemtdm);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton99ActionPerformed
        String keyword = proSearchFiled3.getText();
        productM.loadtable(keyword, product3tdm);
    }//GEN-LAST:event_jButton99ActionPerformed

    private void producttable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producttable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_producttable3MouseClicked

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        salempNameFild.setText("");
        salgrosssalarayFiled.setText("");
        salSararyFiled.setText("");
        salEmpIDFiled.setText("");
        paymentidFiled.setText("");
        salETFFiled.setText("");
        salEPFFiled.setText("");
        salAllowanceFiled.setText("");
        salNetSalaryFiled.setText("");
        payM.loadtable("", paymenttdm);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton103ActionPerformed
        new empPaymentInvoiceDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton103ActionPerformed

    private void employeePaymentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeePaymentTableMouseClicked

        int ro = employeePaymentTable.getSelectedRow();
        String paymeid = (String) paymenttdm.getValueAt(ro, 0);
        Object[] emppaydata = payM.getselectid(paymeid);

        paymentidFiled.setText((String) emppaydata[0]);
        salEmpIDFiled.setText((String) emppaydata[2]);
        salNetSalaryFiled.setText((String) emppaydata[6]);

        salETFFiled.setText((String) emppaydata[3]);
        salEPFFiled.setText((String) emppaydata[4]);
        salAllowanceFiled.setText((String) emppaydata[5]);
        paymentDateChooser1.setDate((Date) emppaydata[1]);

    }//GEN-LAST:event_employeePaymentTableMouseClicked

    private void jButton102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton102ActionPerformed
        String keyword = emprPaymentSearchfield1.getText();
        payM.loadtable(keyword, paymenttdm);
    }//GEN-LAST:event_jButton102ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        String payId = paymentidFiled.getText();
        Date payDate = paymentDateChooser1.getDate();
        String payempID = salEmpIDFiled.getText();
        String etf = salETFFiled.getText();
        String epf = salEPFFiled.getText();
        String allowns = salAllowanceFiled.getText();
        String netsalary = salNetSalaryFiled.getText();

        if (payempID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee ID! ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (netsalary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Again ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String update = payM.updatepay(payId, payDate, payempID, etf, epf, allowns, netsalary);
            JOptionPane.showMessageDialog(this, update, "massege", JOptionPane.OK_CANCEL_OPTION);
            salEmpIDFiled.setText("");
            paymentidFiled.setText("");
            salETFFiled.setText("");
            salEPFFiled.setText("");
            salgrosssalarayFiled.setText("");
            salAllowanceFiled.setText("");
            salNetSalaryFiled.setText("");
            payM.loadtable("", paymenttdm);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        String payId = paymentidFiled.getText();
        Date payDate = paymentDateChooser1.getDate();
        String payempID = salEmpIDFiled.getText();
        String etf = salETFFiled.getText();
        String epf = salEPFFiled.getText();
        String allowns = salAllowanceFiled.getText();
        String netsalary = salNetSalaryFiled.getText();

        if (payempID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee ID! ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (netsalary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Check Again ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String insertpay = payM.insertpay(payDate, payempID, etf, epf, allowns, netsalary);
            JOptionPane.showMessageDialog(this, insertpay, "massege", JOptionPane.INFORMATION_MESSAGE);
            salEmpIDFiled.setText("");
            paymentidFiled.setText("");
            salETFFiled.setText("");
            salEPFFiled.setText("");
            salAllowanceFiled.setText("");
            salNetSalaryFiled.setText("");
            payM.loadtable("", paymenttdm);
        }

    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton101ActionPerformed
        String payId = paymentidFiled.getText();
        String payempID = salEmpIDFiled.getText();
        if (payempID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From table! ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String delete = payM.deletepay(payId);
            JOptionPane.showMessageDialog(this, delete, "massege", JOptionPane.QUESTION_MESSAGE);
            salEmpIDFiled.setText("");
            paymentidFiled.setText("");
            salETFFiled.setText("");
            salEPFFiled.setText("");
            salgrosssalarayFiled.setText("");
            salAllowanceFiled.setText("");
            salNetSalaryFiled.setText("");
            payM.loadtable("", paymenttdm);
        }
    }//GEN-LAST:event_jButton101ActionPerformed

    private void salEPFFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salEPFFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salEPFFiledActionPerformed

    private void checEpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checEpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checEpfActionPerformed

    private void jButton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100ActionPerformed
        double epfamount = 0;
        double etfamount = 0;
        double allow = 0;
        double salary = Double.parseDouble(salSararyFiled.getText());
        if (checEtf.isSelected() == true) {
            etfamount = salary * 10 / 100;
        }
        if (checEpf.isSelected() == true) {
            epfamount = salary * 3 / 100;
        }
        salETFFiled.setText(String.valueOf(etfamount));
        salEPFFiled.setText(String.valueOf(epfamount));

        double gross = salary - (etfamount + epfamount);
        salgrosssalarayFiled.setText(String.valueOf(gross));

        if (salary > 30000) {
            allow = 1000;
        } else if (salary > 20000) {
            allow = 500;
        } else {
            allow = 0;
        }
        salAllowanceFiled.setText(String.valueOf(allow));
        double netsalary = gross + allow;
        salNetSalaryFiled.setText(String.valueOf(netsalary));

    }//GEN-LAST:event_jButton100ActionPerformed

    private void salNetSalaryFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salNetSalaryFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salNetSalaryFiledActionPerformed

    private void salAllowanceFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salAllowanceFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salAllowanceFiledActionPerformed

    private void salgrosssalarayFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salgrosssalarayFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salgrosssalarayFiledActionPerformed

    private void salETFFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salETFFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salETFFiledActionPerformed

    private void salSararyFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salSararyFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salSararyFiledActionPerformed

    private void salempNameFildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salempNameFildActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salempNameFildActionPerformed

    private void salEmpIDFiledKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salEmpIDFiledKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {

                int month = jMonthChooser1.getMonth() + 1;
                String mon = String.valueOf(month);
              //  System.out.println(mon);
                String emp = salEmpIDFiled.getText();
               // System.out.println(emp);

                String salarayAmount = payM.calSalary(emp, mon);
                System.out.println("Total Absent days" + salarayAmount);
                
                String halfday = payM.half(emp, mon);
                System.out.println("Total half days" + halfday);
                
                String absentCount = salarayAmount;
                String halfCount = halfday;
                Object[] getempdetails = payM.getempdata(emp, absentCount,halfCount);

                salempNameFild.setText((String) getempdetails[0]);
                salSararyFiled.setText((String) getempdetails[1]);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_salEmpIDFiledKeyPressed

    private void salEmpIDFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salEmpIDFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salEmpIDFiledActionPerformed

    private void posttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posttableMouseClicked

        int row = posttable.getSelectedRow();
        int postID = (int) posttdm.getValueAt(row, 0);
        Object[] postdata = postM.getSelectId(postID);
        //customernameFiled.setText(new String(customerdata[0]+""));
        postidField.setText(String.valueOf(postdata[0]));
        postnameFiled.setText((String) postdata[1]);
        postsalaryFiled.setText((String) postdata[2]);
    }//GEN-LAST:event_posttableMouseClicked

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed

        String keyword = postSearchfiled3.getText();
        postM.loadtablepost(keyword, posttdm);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void postnameFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postnameFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postnameFiledActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        postidField.setText("");
        postnameFiled.setText("");
        postsalaryFiled.setText("");
        postM.loadtablepost("", posttdm);
        component();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        String postId = postidField.getText();
        String postname = postnameFiled.getText();
        if (postname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From Table!", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String deletepost = postM.deletepost(postId);
            JOptionPane.showMessageDialog(this, deletepost, "massege", JOptionPane.QUESTION_MESSAGE);
            postidField.setText("");
            postnameFiled.setText("");
            postsalaryFiled.setText("");
            postM.loadtablepost("", posttdm);
            component();
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed

        String postId = postidField.getText();
        String postname = postnameFiled.getText();
        String salary = postsalaryFiled.getText();

        if (postname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Data From Table!", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {

            String updatepost = postM.updatepost(postId, postname, salary);
            JOptionPane.showMessageDialog(this, updatepost, "massege", JOptionPane.OK_CANCEL_OPTION);
            postidField.setText("");
            postnameFiled.setText("");
            postsalaryFiled.setText("");
            postM.loadtablepost("", posttdm);
            component();
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed

        String postId = postidField.getText();
        String postname = postnameFiled.getText();
        String salary = postsalaryFiled.getText();

        if (postname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Post Name", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Amount Of Salary", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {

            String insertpost = postM.insertpost(postname, salary);
            JOptionPane.showMessageDialog(this, insertpost, "massege", JOptionPane.INFORMATION_MESSAGE);
            postidField.setText("");
            postnameFiled.setText("");
            postsalaryFiled.setText("");
            postM.loadtablepost("", posttdm);
            component();
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void postidFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postidFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postidFieldActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        new attendanceReportDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton54ActionPerformed

    private void attendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendanceTableMouseClicked

        int row = attendanceTable.getSelectedRow();
        int attenID = (int) attendancetdm.getValueAt(row, 0);
        Object[] attData = attendanceM.getSelectId(attenID);

        attendanceiDFiled.setText(String.valueOf(attData[0]));
        attendanceEmpIdFiled.setText((String) attData[1]);
        searchdateChooser.setDate((Date) attData[2]);
        attendanceCombo.setSelectedItem((String) attData[3]);
    }//GEN-LAST:event_attendanceTableMouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed

        String keyword = searchAttendaceFiled.getText();

        //Date getdate = DateChooser.getDate();
        //        if (keyword != null) {
        attendanceM.loadtablebyid(keyword, attendancetdm);
        //        } else {
        //            attendanceM.loadtablebydate(getdate, attendancetdm);
        //            System.out.println(getdate);
        //        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        new EmployeIDDetailsDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        attendanceiDFiled.setText("");
        attendanceEmpIdFiled.setText("");
        searchdateChooser.setDate(null);
        attendanceM.loadtablebyid("", attendancetdm);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        String attId = attendanceiDFiled.getText();
        String attEmpId = attendanceEmpIdFiled.getText();
        if (attEmpId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select data from table! ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String deleteatt = attendanceM.attenDelete(attId);
            JOptionPane.showMessageDialog(this, "Deleted Details", "massege", JOptionPane.QUESTION_MESSAGE);
            attendanceiDFiled.setText("");
            attendanceEmpIdFiled.setText("");
            searchdateChooser.setDate(null);
            attendanceM.loadtablebyid("", attendancetdm);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed

        String attId = attendanceiDFiled.getText();
        String attEmpId = attendanceEmpIdFiled.getText();
        Date ada = searchdateChooser.getDate();
        System.out.println(ada);
        Object o = attendanceCombo.getSelectedItem();
        String status = String.valueOf(o);

        if (attEmpId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select data from table! ", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {

            String updateatt = attendanceM.attenUpdate(attId, attEmpId, ada, status);
            JOptionPane.showMessageDialog(this, updateatt, "massege", JOptionPane.OK_CANCEL_OPTION);
            attendanceiDFiled.setText("");
            attendanceEmpIdFiled.setText("");
            searchdateChooser.setDate(null);
            attendanceM.loadtablebyid("", attendancetdm);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed

        String attId = attendanceiDFiled.getText();
        String attEmpId = attendanceEmpIdFiled.getText();
        Date ada = searchdateChooser.getDate();
        Object o = attendanceCombo.getSelectedItem();
        String status = String.valueOf(o);

        if (attEmpId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Id", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {

            String insertatten = attendanceM.insertatten(attEmpId, ada, status);
            JOptionPane.showMessageDialog(this, insertatten, "massege", JOptionPane.INFORMATION_MESSAGE);
            attendanceiDFiled.setText("");
            attendanceEmpIdFiled.setText("");
            searchdateChooser.setDate(null);
            attendanceM.loadtablebyid("", attendancetdm);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void attendanceiDFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceiDFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attendanceiDFiledActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

        String keyword = emprSearchfiled.getText();
        empM.loadtableEmp(keyword, emptdm);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed

        new empoyeeReportDialogbox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked

        int row = employeeTable.getSelectedRow();
        int empID = (int) emptdm.getValueAt(row, 0);
        Object[] empdata = empM.getSelectId(empID);
        //customernameFiled.setText(new String(customerdata[0]+""));
        employeeIdFiled.setText(String.valueOf(empdata[0]));
        empnnameFiled.setText((String) empdata[1]);
        empaddressFiled.setText((String) empdata[2]);
        empmobileFiled.setText((String) empdata[3]);
        postCombo.setSelectedItem((String) empdata[4]);
        employeeNicFiled.setText((String) empdata[5]);

    }//GEN-LAST:event_employeeTableMouseClicked

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        new posttableDialogBox(this, true).setVisible(true);
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        employeeIdFiled.setText("");
        empnnameFiled.setText("");
        empaddressFiled.setText("");
        empmobileFiled.setText("");
        employeeNicFiled.setText("");
        empM.loadtableEmp("", emptdm);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        String empId = employeeIdFiled.getText();
        String empname = empnnameFiled.getText();

        if (empname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plese Select data from table", "massege", JOptionPane.QUESTION_MESSAGE);
        } else {
            String deleteEmp = empM.deleteemp(empId);
            JOptionPane.showMessageDialog(this, deleteEmp, "massege", JOptionPane.QUESTION_MESSAGE);
            employeeIdFiled.setText("");
            empnnameFiled.setText("");
            empaddressFiled.setText("");
            empmobileFiled.setText("");
            employeeNicFiled.setText("");
            empM.loadtableEmp("", emptdm);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        String empId = employeeIdFiled.getText();
        String empname = empnnameFiled.getText();
        String empnaddress = empaddressFiled.getText();
        String empmodile = empmobileFiled.getText();
        String empnic = employeeNicFiled.getText();
        Object o = postCombo.getSelectedItem();
        String empoost = String.valueOf(o);

        if (empId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select data from table", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (empname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Name", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (empnaddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Address", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (empmodile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Mobile", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (empnic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee NIC Number", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {
            String insertEmp = empM.updateemp(empId, empname, empnaddress, empmodile, empoost, empnic);
            JOptionPane.showMessageDialog(this, insertEmp, "massege", JOptionPane.OK_CANCEL_OPTION);
            employeeIdFiled.setText("");
            empnnameFiled.setText("");
            empaddressFiled.setText("");
            empmobileFiled.setText("");
            employeeNicFiled.setText("");

            empM.loadtableEmp("", emptdm);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        String empId = employeeIdFiled.getText();
        String empname = empnnameFiled.getText();
        String empnaddress = empaddressFiled.getText();
        String empmodile = empmobileFiled.getText();
        String empnic = employeeNicFiled.getText();
        Object o = postCombo.getSelectedItem();
        String empoost = String.valueOf(o);

        if (empname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Name", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (empnaddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Address", "Massege", JOptionPane.WARNING_MESSAGE);
        } else if (empmodile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee Mobile", "Massege", JOptionPane.WARNING_MESSAGE);

        } else if (empnic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Employee NIC", "Massege", JOptionPane.WARNING_MESSAGE);
        } else {

            String insertEmp = empM.insertemp(empname, empnaddress, empmodile, empoost, empnic);
            JOptionPane.showMessageDialog(this, insertEmp, "massege", JOptionPane.INFORMATION_MESSAGE);
            employeeIdFiled.setText("");
            empnnameFiled.setText("");
            empaddressFiled.setText("");
            empmobileFiled.setText("");
            employeeNicFiled.setText("");
            empM.loadtableEmp("", emptdm);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void employeeIdFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdFiledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdFiledActionPerformed


    private void attConbobtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attConbobtActionPerformed
        delete(attentionComboBox.getSelectedIndex());

    }//GEN-LAST:event_attConbobtActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        f1.setVisible(false);
        f2.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(true);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(true);
        f7.setVisible(false);
        f8.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(false);
        f7.setVisible(true);
        f8.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        f1.setVisible(true);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f6.setVisible(false);
        f7.setVisible(false);
        f8.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new ab(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    public void balance() {
        String p = paymentFiled.getText();
        if (p.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Payment Amount!", "massege", JOptionPane.INFORMATION_MESSAGE);
        } else {
            double total = Double.parseDouble(totalFiled.getText());
            double pay = Double.parseDouble(paymentFiled.getText());

            double bal = pay - total;
            balanceFiled.setText(String.valueOf(bal) + "0");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField StocksPIdFiled;
    private javax.swing.JTextField StocksQtyFiled1;
    private javax.swing.JTextField accessoryIdFiled;
    private javax.swing.JTextField accessoryNameFiled;
    private javax.swing.JTextField accessorySearchFiled;
    private javax.swing.JTable accessoryTable;
    private javax.swing.JTextField adminIDfiled;
    private javax.swing.JTextField adminSearchFiled;
    public javax.swing.JButton adminbt;
    private javax.swing.JTable admintable;
    private javax.swing.JComboBox<String> admintypeCombo;
    private javax.swing.JTextField adminusernameField;
    private javax.swing.JTextField amountFiled;
    public javax.swing.JButton attConbobt;
    private javax.swing.JComboBox<String> attendanceCombo;
    private javax.swing.JTextField attendanceEmpIdFiled;
    private javax.swing.JTable attendanceTable;
    private javax.swing.JTextField attendanceiDFiled;
    public javax.swing.JComboBox<String> attentionComboBox;
    private javax.swing.JButton backbt;
    private javax.swing.JButton backpPath;
    private javax.swing.JTextField backupField;
    private javax.swing.JTextField balanceFiled;
    private javax.swing.JTabbedPane billtabe;
    private javax.swing.JTextField categoryIdFiled;
    private javax.swing.JTextField categoryNameFiled;
    private javax.swing.JTextField categorySearchFiled;
    private javax.swing.JTable categorytable;
    private javax.swing.JCheckBox checEpf;
    private javax.swing.JCheckBox checEtf;
    private javax.swing.JTextField cuMobileFiled;
    private javax.swing.JTextField customerIDfiled;
    private javax.swing.JTextField customerMdeilfiled;
    private javax.swing.JTextField customerSearchfiled;
    public javax.swing.JButton customerbt;
    private javax.swing.JTextField customernameFiled;
    public javax.swing.JTable customertable;
    private javax.swing.JButton cutomer;
    public javax.swing.JTable cutomer2table;
    public javax.swing.JButton databasebt;
    private javax.swing.JLabel date;
    private javax.swing.JTextArea empaddressFiled;
    private javax.swing.JTextField employeeIdFiled;
    private javax.swing.JTextField employeeNicFiled;
    private javax.swing.JTable employeePaymentTable;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTextField empmobileFiled;
    private javax.swing.JTextField empnnameFiled;
    private javax.swing.JTextField emprPaymentSearchfield1;
    private javax.swing.JTextField emprSearchfiled;
    private javax.swing.JInternalFrame f1;
    private javax.swing.JInternalFrame f2;
    private javax.swing.JInternalFrame f3;
    private javax.swing.JInternalFrame f4;
    private javax.swing.JInternalFrame f5;
    private javax.swing.JInternalFrame f6;
    private javax.swing.JInternalFrame f7;
    private javax.swing.JInternalFrame f8;
    private javax.swing.JTextField grnAmountField;
    private javax.swing.JTextField grnIdFiled;
    private javax.swing.JTextField grnItemIdFiled;
    private javax.swing.JTextField grnSearchFiled;
    private com.toedter.calendar.JDateChooser grndateChooser;
    public javax.swing.JTextField grnitemGrnIdFeild;
    public javax.swing.JTextField grnitemPIdFiled1;
    private javax.swing.JTextField grnitemQtyFiled;
    private javax.swing.JTextField grnitemSearchFiled;
    private javax.swing.JTextField grnitembuypFiled;
    private javax.swing.JTable grnitemtable;
    private javax.swing.JComboBox<String> grnsupplerCombo;
    private javax.swing.JTable grntable;
    private javax.swing.JTextField invoiceCustomersearchfiled;
    private javax.swing.JTextField invoiceIDfiled;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JTable invoicebuytable;
    private com.toedter.calendar.JDateChooser invoicedate;
    private javax.swing.JTable itemitemTable;
    private javax.swing.JTextField itemsearchfiled;
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    public javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    public javax.swing.JButton jButton4;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    public javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    public javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    public javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JComboBox<String> partSelectCombo;
    private javax.swing.JPasswordField passwordField;
    private com.toedter.calendar.JDateChooser paymentDateChooser1;
    private javax.swing.JTextField paymentFiled;
    private javax.swing.JTextField paymentidFiled;
    private javax.swing.JTextField pnamefiled;
    private javax.swing.JTextField porodictid;
    private javax.swing.JComboBox<String> postCombo;
    private javax.swing.JTextField postSearchfiled3;
    private javax.swing.JTextField postidField;
    private javax.swing.JTextField postnameFiled;
    private javax.swing.JTextField postsalaryFiled;
    private javax.swing.JTable posttable;
    private javax.swing.JTextField priceFiled;
    private javax.swing.JTextField proNameFiled;
    private javax.swing.JTextField proSearchFiled;
    private javax.swing.JTextField proSearchFiled3;
    private javax.swing.JComboBox<String> procategoryComboo;
    private javax.swing.JTextField prodIdFiled;
    private javax.swing.JTable producttable;
    private javax.swing.JTable producttable3;
    private javax.swing.JTextField prosellFiled;
    private javax.swing.JTextField qty2Filed;
    private javax.swing.JButton resotrePathbt;
    private javax.swing.JTextField restoreField;
    private javax.swing.JButton restorebt;
    private javax.swing.JTextField salAllowanceFiled;
    private javax.swing.JTextField salEPFFiled;
    private javax.swing.JTextField salETFFiled;
    private javax.swing.JTextField salEmpIDFiled;
    private javax.swing.JTextField salNetSalaryFiled;
    private javax.swing.JTextField salSararyFiled;
    private javax.swing.JTextField salempNameFild;
    private javax.swing.JTextField salgrosssalarayFiled;
    private javax.swing.JTextField searchAttendaceFiled;
    private com.toedter.calendar.JDateChooser searchdateChooser;
    private javax.swing.JTextField searchfiled3;
    private javax.swing.JTextField stocksIdFiled;
    private javax.swing.JTextField stocksSearchFiled;
    private javax.swing.JTable stokstable;
    private javax.swing.JTextField supEmailField;
    private javax.swing.JTextField supMobileFiled;
    private javax.swing.JTextField supSearchFiled;
    private javax.swing.JTable suplierTable;
    private javax.swing.JTextField supplierIDFiled;
    public javax.swing.JButton supplierbt;
    private javax.swing.JTextField suppnameFiled;
    private javax.swing.JLabel time;
    private javax.swing.JTextField totalFiled;
    // End of variables declaration//GEN-END:variables
}
