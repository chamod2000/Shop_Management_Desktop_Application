package model;

import gui.home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import static model.testlogin.log;
import org.apache.log4j.Logger;

public class grnModel {

    static Logger log = Logger.getLogger(grnModel.class.getName());

    Connection con;

    public grnModel() {
        con = db.dbConnection.getconnection();
    }

    public String insertgrn(Date grndate, String amunt, String suplier) {
        String msg = "";
        String supid = "SELECT id_suplier FROM pcgadguestshop.suplier WHERE sup_name=?";
        String insertQuery = "INSERT INTO pcgadguestshop.grn(date, payment, suplier_id_suplier)VALUES(?,?,?)";
        String setgid = "SELECT MAX(`id_grn`)FROM pcgadguestshop.grn";
        try {
            PreparedStatement ps2 = con.prepareStatement(supid);
            ps2.setString(1, suplier);
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                int re = rs.getInt("id_suplier");
                String supplierid = String.valueOf(re);

                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setDate(1, new java.sql.Date(grndate.getTime()));
                ps.setString(2, amunt);
                ps.setString(3, supplierid);

                ps.execute();

                msg = "Successfully Insert";

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "error";
        }
        return msg;
    }

    public String updategrn(String grnid, Date grndate, String amunt, String suplier) {
        String msg = "";
        String supid = "SELECT id_suplier FROM pcgadguestshop.suplier WHERE sup_name=?";
        String updateQuary = "UPDATE pcgadguestshop.grn SET date=?, payment=?, suplier_id_suplier=? WHERE id_grn=?";
        try {
            PreparedStatement ps2 = con.prepareStatement(supid);
            ps2.setString(1, suplier);
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                int re = rs.getInt("id_suplier");
                String supplierid = String.valueOf(re);

                PreparedStatement ps = con.prepareStatement(updateQuary);
                ps.setDate(1, new java.sql.Date(grndate.getTime()));
                ps.setString(2, amunt);
                ps.setString(3, supplierid);
                ps.setString(4, grnid);

                ps.execute();
                msg = "Successfully Updated";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Error" + e.getMessage();

        }
        return msg;
    }

    public String deletegrn(String grnid) {
        String msg;
        String DeleteQueary = "DELETE FROM pcgadguestshop.grn WHERE id_grn=?";
        try {
            PreparedStatement ps = con.prepareStatement(DeleteQueary);
            ps.setString(1, grnid);
            ps.execute();
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "Error" + e.getMessage();
        }
        return null;
    }

    public void loadtable(String keyword, DefaultTableModel grntdm) {
        String loadtb = "SELECT suplier.sup_name,grn.suplier_id_suplier,suplier.id_suplier,suplier.sup_mobile,grn.payment,grn.date,id_grn "
                + "FROM pcgadguestshop.suplier INNER JOIN pcgadguestshop.grn ON pcgadguestshop.grn.suplier_id_suplier = pcgadguestshop.suplier.id_suplier WHERE id_grn like ?";
//         String loadtb = "SELECT pcgadguestshop.suplier.sup_name,\n" +
//"	pcgadguestshop.grn.suplier_id_suplier,\n" +
//"	pcgadguestshop.suplier.id_suplier,\n" +
//"	pcgadguestshop.suplier.sup_mobile,\n" +
//"	pcgadguestshop.grn.payment,\n" +
//"	pcgadguestshop.grn.date,\n" +
//"	pcgadguestshop.grn.id_grn\n" +
//"FROM pcgadguestshop.suplier\n" +
//"	INNER JOIN pcgadguestshop.grn ON \n" +
//"	 pcgadguestshop.grn.suplier_id_suplier = pcgadguestshop.suplier.id_suplier WHERE id_grn like ?";
        try {
            PreparedStatement ps = con.prepareStatement(loadtb);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            grntdm.setRowCount(0);
            while (rs.next()) {

                String id = rs.getString("id_grn");
                Date date = rs.getDate("date");
                String payment = rs.getString("payment");
                String name = rs.getString("sup_name");
                String mobile = rs.getString("sup_mobile");

                rowData = new Object[]{id, date, payment, name, mobile};
                grntdm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] getselectid(String grid) {
        String getData = "SELECT * FROM  pcgadguestshop.grn WHERE id_grn = ?";
        try {
            PreparedStatement ps = con.prepareStatement(getData);
            ps.setString(1, grid);
            ResultSet rs = ps.executeQuery();
            Object[] rowData = null;
            while (rs.next()) {
                int id = rs.getInt("id_grn");
                Date date = rs.getDate("date");
                String payment = rs.getString("payment");
                String sid = rs.getString("suplier_id_suplier");

                String getpostname = "SELECT sup_name FROM pcgadguestshop.suplier WHERE id_suplier=? ";
                PreparedStatement ps2 = con.prepareStatement(getpostname);
                ps2.setString(1, sid);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {

                    String supname = rs2.getString("sup_name");
                    sid = supname;

                    rowData = new Object[]{id, date, payment, sid};
                    return rowData;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
