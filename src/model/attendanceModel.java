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
public class attendanceModel {
static Logger log = Logger.getLogger(attendanceModel.class.getName());
   
    Connection con;

    public attendanceModel() {
        con = db.dbConnection.getconnection();
    }

    public String insertatten(String attId, Date ada, String status) {
        String msg;
        String insert = "INSERT INTO pcgadguestshop.attendance (date, status, emplyee_idemplyee)VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setDate(1, new java.sql.Date(ada.getTime()));
            ps.setString(2, status);
            ps.setString(3, attId);
            ps.execute();
            msg = "Successfully insert!";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Somthing wrong check Input Fileds!";
        }
        return msg;
    }

    public void loadtablebyid(String keyword, DefaultTableModel attendancetdm) {

        String search = "SELECT pcgadguestshop.emplyee.idemplyee,emplyee.emp_name,attendance.id_attendance,attendance.date,"
                + "attendance.status,attendance.emplyee_idemplyee FROM pcgadguestshop.attendance "
                + "INNER JOIN pcgadguestshop.emplyee ON pcgadguestshop.emplyee.idemplyee = pcgadguestshop.attendance.emplyee_idemplyee WHERE emplyee_idemplyee like ?";

//String search="SELECT * FROM pcgadguestshop.attendance WHERE id_attendance like ?";
        try {
            PreparedStatement ps = con.prepareStatement(search);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            attendancetdm.setRowCount(0);
            while (rs.next()) {

                int attid = rs.getInt("id_attendance");
                String date = rs.getString("date");
                String status = rs.getString("status");
                String empName = rs.getString("emp_name");

                rowData = new Object[]{attid, empName, date, status};
               
                attendancetdm.addRow(rowData);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadtablebydate(Date date, DefaultTableModel attendancetdm) {

        String search = "SELECT pcgadguestshop.emplyee.idemplyee,\n"
                + "	pcgadguestshop.emplyee.emp_name,\n"
                + "	pcgadguestshop.attendance.id_attendance,\n"
                + "	pcgadguestshop.attendance.date,\n"
                + "	pcgadguestshop.attendance.status,\n"
                + "	pcgadguestshop.attendance.emplyee_idemplyee\n"
                + "FROM pcgadguestshop.attendance\n"
                + "	INNER JOIN pcgadguestshop.emplyee ON \n"
                + "	 pcgadguestshop.emplyee.idemplyee = pcgadguestshop.attendance.emplyee_idemplyee WHERE date like ?";

 
        try {
            PreparedStatement ps = con.prepareStatement(search);
            ps.setString(1, "%" + date + "%");

            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            attendancetdm.setRowCount(0);
            while (rs.next()) {

                int attid = rs.getInt("id_attendance");
                String datee = rs.getString("date");
                String status = rs.getString("status");
                String empName = rs.getString("emp_name");
                System.out.println("date");
                rowData = new Object[]{attid, empName, datee, status};
                System.out.println("done 53");
                attendancetdm.addRow(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getSelectId(int attenID) {
    
         String getData ="SELECT * FROM pcgadguestshop.attendance WHERE id_attendance =?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setInt(1, attenID);
            ResultSet rs = ps.executeQuery();
            Object[] rowData=null;
            while(rs.next()){
                 int attid = rs.getInt("id_attendance");
              //  String datee = rs.getString("date");
                 Date datee= rs.getDate("date");
                String status = rs.getString("status");
                String empid = rs.getString("emplyee_idemplyee");
                
               
               rowData = new Object[]{attid, empid, datee, status};
            }
            return rowData;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }

    public String attenUpdate(String attId, String attEmpId, Date ada, String status) {
       
    
         String msg;
       String updateQuary="UPDATE pcgadguestshop.attendance SET date=?, status=?, emplyee_idemplyee=? WHERE id_attendance=?";
        try {
            PreparedStatement ps = con.prepareStatement(updateQuary);
            ps.setDate(1, new java.sql.Date(ada.getTime()));
            ps.setString(2, status);
            ps.setString(3, attEmpId);
            ps.setString(4, attId);
            
            ps.execute();
            msg="Successfully Updated";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Somthing wrong check again!";
           
        }
        return msg;
    }

    public String attenDelete(String attId) {
    
        String msg;
        String DeleteQueary ="DELETE FROM pcgadguestshop.attendance WHERE id_attendance=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, attId);
            ps.execute();
            msg="success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
             msg="Somthing wrong check again!";
        }
        return null;

    
    }

}
