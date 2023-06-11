/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.ThongKe;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kunrl
 */
public class ThongKeRepository {

    public ArrayList<ThongKe> finByBieuDo() {

        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT year(NgayTao) as ngay, sum(TongTien) as Tien\n"
                    + "                     FROM HoaDon \n"
                    + "					 where TrangThai =0\n"
                    + "					 Group by year(NgayTao)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("Tien"));
                listsp.add(bhsp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listsp;
    }
    public static ArrayList<ThongKe> finByNgayThanhToanNamanhTT(int ma, int mi) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Year(NgayTao) as Ngay, TongTien, TrangThai \n"
                    + "                     FROM HoaDon where Year(NgayTao) like '" + ma + "%'and TrangThai like '" + mi + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                bhsp.setTien(rs.getInt("TrangThai"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }


    public static ArrayList<ThongKe> finByNgayThanhToanThanganhTT(int ma, int mi) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Month(NgayTao) as Ngay, TongTien, TrangThai \n"
                    + "                     FROM HoaDon where Month(NgayTao) like '" + ma + "%'and TrangThai like '" + mi + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                bhsp.setTien(rs.getInt("TrangThai"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<ThongKe> finByNgayThanhToanandNgay(int ma, int mi) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Day(NgayTao) as Ngay, TongTien, TrangThai \n"
                    + "                     FROM HoaDon where Day(NgayTao) like '" + ma + "%'and TrangThai like '" + mi + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                bhsp.setTien(rs.getInt("TrangThai"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<ThongKe> finByNgayThanhToanNgay(int ma) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Day(NgayTao) as Ngay, TongTien \n"
                    + "                     FROM HoaDon where Day(NgayTao) like '" + ma + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<ThongKe> finByNgayThanhToanThang(int ma) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Month(NgayTao) as Ngay, TongTien \n"
                    + "                     FROM HoaDon where Month(NgayTao) like '" + ma + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<ThongKe> finByNgayThanhToanNam(int ma) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Year(NgayTao) as Ngay, TongTien \n"
                    + "                     FROM HoaDon where Year(NgayTao) like '" + ma + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;

    }

    public static ArrayList<ThongKe> finByTongtienNgayThanhToanNgay(int ma) throws Exception {
       ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Day(NgayTao) as Ngay, TongTien \n"
                    + "                     FROM HoaDon where Day(NgayTao) like '" + ma + "' and TrangThai=0 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<ThongKe> finByTongtienNgayThanhToanThang(int ma) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Month(NgayTao) as Ngay, TongTien \n"
                    + "                     FROM HoaDon where Month(NgayTao) like '" + ma + "' and TrangThai=0 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;
    }

    public static ArrayList<ThongKe> finByTongtienNgayThanhToanNam(int ma) throws Exception {
        ArrayList<ThongKe> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Year(NgayTao) as Ngay, TongTien \n"
                    + "                     FROM HoaDon where Year(NgayTao) like '" + ma + "' and TrangThai=0";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                ThongKe bhsp = new ThongKe();
                bhsp.setNgay(rs.getString("Ngay"));
                bhsp.setTien(rs.getInt("TongTien"));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listsp;

    }

}
