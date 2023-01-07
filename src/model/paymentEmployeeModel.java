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
public class paymentEmployeeModel {

    static Logger log = Logger.getLogger(paymentEmployeeModel.class.getName());

    Connection con;

    public paymentEmployeeModel() {
        con = db.dbConnection.getconnection();
    }

    public String deletepay(String payId) {

        String msg;
        String DeleteQueary = "DELETE FROM pcgadguestshop.salarypayment WHERE id_salarypayment=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, payId);
            ps.execute();
            msg = "Successfully Deleted!";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Somthing wrong check Input Fileds!";
        }
        return msg;
    }

    public void loadtable(String keyword, DefaultTableModel paymenttdm) {

        String loadtb = "SELECT pcgadguestshop.emplyee.idemplyee,\n"
                + "	pcgadguestshop.emplyee.emp_name,\n"
                + "	pcgadguestshop.salarypayment.id_salarypayment,\n"
                + "	pcgadguestshop.salarypayment.date,\n"
                + "	pcgadguestshop.salarypayment.emplyee_idemplyee,\n"
                + "	pcgadguestshop.salarypayment.etf,\n"
                + "	pcgadguestshop.salarypayment.epf,\n"
                + "	pcgadguestshop.salarypayment.allowns,\n"
                + "	pcgadguestshop.salarypayment.netsalary\n"
                + "FROM pcgadguestshop.salarypayment\n"
                + "	INNER JOIN pcgadguestshop.emplyee ON \n"
                + "	 pcgadguestshop.salarypayment.emplyee_idemplyee = pcgadguestshop.emplyee.idemplyee WHERE emplyee_idemplyee like ?";

        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            paymenttdm.setRowCount(0);
            while (rs.next()) {

                String id = rs.getString("id_salarypayment");
                String pdate = rs.getString("date");
                String payemid = rs.getString("emplyee_idemplyee");
                String etf = rs.getString("etf");
                String epf = rs.getString("epf");
                String allowns = rs.getString("allowns");
                String netsalary = rs.getString("netsalary");

                rowData = new Object[]{id, pdate, payemid, etf, epf, allowns, netsalary};
                paymenttdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object[] getselectid(String paymeid) {

        String getData = "SELECT * FROM pcgadguestshop.salarypayment WHERE id_salarypayment =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, paymeid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData = null;
            while (rs.next()) {
                String id = rs.getString("id_salarypayment");
                Date pdate = rs.getDate("date");
                String payemid = rs.getString("emplyee_idemplyee");
                String etf = rs.getString("etf");
                String epf = rs.getString("epf");
                String allowns = rs.getString("allowns");
                String netsalary = rs.getString("netsalary");

                rowData = new Object[]{id, pdate, payemid, etf, epf, allowns, netsalary};
            }
            return rowData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[] getempdata(String emp, String absentCount, String halfCount) {

        String empdata = "SELECT * FROM pcgadguestshop.emplyee WHERE idemplyee=?";
        String emppostdata = "SELECT * FROM pcgadguestshop.posts WHERE id_post=?";
        int daysAb = Integer.parseInt(absentCount);
        int daysH = Integer.parseInt(halfCount);
        
        

        double dailySalary;
        double absentlessSalary;
        double totalnetSalary;
        double halfdaySalary;
        double halfdaylessSalary =0.0;

        try {
            PreparedStatement ps = con.prepareStatement(empdata);
            ps.setString(1, emp);
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            String name = "";
            while (rs.next()) {
                name = rs.getString("emp_name");
                String postid = rs.getString("posts_id_post");

                PreparedStatement ps2 = con.prepareStatement(emppostdata);
                ps2.setString(1, postid);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    Double salaray = rs2.getDouble("salary");

                    if (daysAb > 0 || daysH > 0) {

                        dailySalary = salaray / 30;
                        halfdaySalary = dailySalary/2;
                      //  System.out.println("per halfday"+halfdaySalary);
                        
                        absentlessSalary = daysAb * dailySalary;
                      //  System.out.println("hhh"+daysH);
                        halfdaylessSalary = daysH * halfdaySalary;
                        
                     //  System.out.println("halfday loss amount"+ halfdaylessSalary);
                        
                        totalnetSalary = salaray - (absentlessSalary + halfdaylessSalary);
                        String sal = String.valueOf(totalnetSalary);
                        System.out.println(name);
                        System.out.println(sal);
                        rowData = new Object[]{name, sal};
                        return rowData;
                    }
                    else if (daysAb == 0 && daysH ==0) {
                        System.out.println(name);
                        System.out.println(salaray);
                        String sall = String.valueOf(salaray);
                        rowData = new Object[]{name, sall};
                        return rowData;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String insertpay(Date payDate, String payempID, String etf, String epf, String allowns, String netsalary) {
        String msg;
        String insert = "INSERT INTO pcgadguestshop.salarypayment(date, emplyee_idemplyee, etf, epf,allowns,netsalary)VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setDate(1, new java.sql.Date(payDate.getTime()));
            ps.setString(2, payempID);
            ps.setString(3, etf);
            ps.setString(4, epf);
            ps.setString(5, allowns);
            ps.setString(6, netsalary);

            ps.execute();
            msg = "Successfully insert!";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Somthing wrong check Input Fileds!";
        }
        return msg;
    }

    public String updatepay(String payId, Date payDate, String payempID, String etf, String epf, String allowns, String netsalary) {
        String msg = "";
        String updateQuary = "UPDATE pcgadguestshop.salarypayment SET date=?, emplyee_idemplyee=?, etf=?, epf=?, allowns=?, netsalary=? WHERE id_salarypayment=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setDate(1, new java.sql.Date(payDate.getTime()));
            ps.setString(2, payempID);
            ps.setString(3, etf);
            ps.setString(4, epf);
            ps.setString(5, allowns);
            ps.setString(6, netsalary);
            ps.setString(7, payId);
            ps.execute();
            msg = "Successfully updated";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Somthing wrong check Input Fileds";

        }
        return msg;
    }

    public String calSalary(String emp, String mon) {

        String absent = "Absent";
        String getAbsentCount = "SELECT * FROM pcgadguestshop.attendance WHERE MONTH(date)='" + mon + "' AND status=? AND emplyee_idemplyee=?";
        int day = 0;
        try {
            PreparedStatement ps = con.prepareStatement(getAbsentCount);
            ps.setString(1, absent);
            ps.setString(2, emp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                day++;
                Date d = rs.getDate("date");
            }
        } catch (Exception e) {
        }
        String absentdays = String.valueOf(day);
        return absentdays;

    }

    public String half(String emp, String mon) {
         String absent = "HalfDay";
        String gethalfdayCount = "SELECT * FROM pcgadguestshop.attendance WHERE MONTH(date)='" + mon + "' AND status=? AND emplyee_idemplyee=?";
        int hday = 0;
        try {
            PreparedStatement ps = con.prepareStatement(gethalfdayCount);
            ps.setString(1, absent);
            ps.setString(2, emp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hday++;
                Date d = rs.getDate("date");
            }
        } catch (Exception e) {
        }
        String halfDaydays = String.valueOf(hday);
        return halfDaydays;
    }

}
