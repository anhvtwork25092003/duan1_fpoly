/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.TheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.TheLoaiRepository;

/**
 *
 * @author User
 */
public class repoTheLoai implements TheLoaiRepository {

    public ArrayList<TheLoai> getAll() {
        ArrayList<TheLoai> listTheLoai = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = " select * from theloai ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangthai = rs.getInt("trangThai");
                TheLoai s = new TheLoai(id, ma, ten, ten, ma, trangthai);
                listTheLoai.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTheLoai;
    }

    public boolean insert(TheLoai tl) {
        int check = 0;
        String query = "insert into THELOAI (Ten, TrangThai) values (?, ?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, tl.getTen());
            ps.setInt(2, tl.getTrangthai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(TheLoai s, String id) {
        try {
            Connection con = DBContext.getConnection();
            String query = "Update THELOAI set TEN = ?, TRANGTHAI = ? Where ID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getTrangthai());
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return true;
    }

    public List<TheLoai> timKiem(String tenTim) {
        List<TheLoai> listTL = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "Select * from TheLoai where ten like ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + tenTim + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                TheLoai tacgia = new TheLoai();
                tacgia.setId(rs.getString(1));
                tacgia.setMa(rs.getString(2));
                tacgia.setTen(rs.getString(3));
                tacgia.setTrangthai(rs.getInt(4));
                listTL.add(tacgia);
            }

        } catch (Exception e) {
        }

        return listTL;
    }

    public List<TheLoai> timKiemTT(int trangThai) {
        List<TheLoai> listTL = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "Select * from TheLoai where TrangThai = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                TheLoai tacgia = new TheLoai();
                tacgia.setId(rs.getString(1));
                tacgia.setMa(rs.getString(2));
                tacgia.setTen(rs.getString(3));
                tacgia.setTrangthai(rs.getInt(4));
                listTL.add(tacgia);
            }

        } catch (Exception e) {
        }

        return listTL;
    }

    @Override
    public TheLoai getOne(String ten) {
        TheLoai tl = new TheLoai();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "SELECT * FROM TheLoai WHERE TEN LIKE ? COLLATE Vietnamese_CI_AI";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                tl.setId(rs.getString("ID"));
                tl.setMa(rs.getString("MA"));
                tl.setTen(rs.getString("Ten"));
                tl.setTrangthai(rs.getInt("TrangThai"));

            }

        } catch (Exception e) {
        }
        return tl;
    }

    public ArrayList<TheLoai> getAllDangKD() {
        ArrayList<TheLoai> listTheLoai = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = " select * from theloai Where trangThai = 0 ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangthai = rs.getInt("trangThai");
                TheLoai s = new TheLoai(id, ma, ten, ten, ma, trangthai);
                listTheLoai.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTheLoai;
    }

    public static void main(String[] args) {
        List<TheLoai> listTK = new repoTheLoai().getAllDangKD();
        System.out.println(listTK.toString());
    }
}
