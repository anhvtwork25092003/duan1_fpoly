/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.tacGia;
import java.util.ArrayList;
import java.util.List;
import repository.tacGiaRepository;
import java.sql.*;

/**
 *
 * @author Huyên
 */
public class tacGiaRepositoryImpl implements tacGiaRepository {

    @Override
    public List<tacGia> getAll() {
        List<tacGia> listTG = new ArrayList<>();
        String sql = "SELECT * FROM TACGIA";
        try ( Connection connet = DBContext.getConnection();  PreparedStatement ps = connet.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tacGia tacgia = new tacGia();
                tacgia.setId(rs.getInt(1));
                tacgia.setMa(rs.getString(2));
                tacgia.setTen(rs.getString(3));
                tacgia.setTrangThai(rs.getInt(4));
                listTG.add(tacgia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listTG;
    }

    public boolean add(tacGia TG) {
        int check = 0;
        String query = "insert into Tacgia(ten, TrangThai) values(?, ?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, TG.getTen());
            ps.setInt(2, TG.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(tacGia s, String id) {
        try {
            Connection con = DBContext.getConnection();
            String query = "UPDATE TacGia Set Ten = ?, TrangThai = ? WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getTrangThai());
            ps.setString(3, id);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return true;
    }

    public List<tacGia> timKiem(String tenTim) {
        List<tacGia> listTG = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "Select * from TacGia where ten like ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + tenTim + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                tacGia tacgia = new tacGia();
                tacgia.setId(rs.getInt(1));
                tacgia.setMa(rs.getString(2));
                tacgia.setTen(rs.getString(3));
                tacgia.setTrangThai(rs.getInt(4));
                listTG.add(tacgia);
            }

        } catch (Exception e) {
        }

        return listTG;
    }

    public List<tacGia> timKiemTT(int trangThai) {
        List<tacGia> listTG = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "Select * from TacGia where TrangThai = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                tacGia tacgia = new tacGia();
                tacgia.setId(rs.getInt(1));
                tacgia.setMa(rs.getString(2));
                tacgia.setTen(rs.getString(3));
                tacgia.setTrangThai(rs.getInt(4));
                listTG.add(tacgia);
            }

        } catch (Exception e) {
        }

        return listTG;
    }

    @Override
    public tacGia getOne(String ten) {
        tacGia nxb = new tacGia();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "SELECT * FROM tacgia WHERE TEN LIKE ? COLLATE Vietnamese_CI_AI";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                nxb.setId(rs.getInt("id"));
                nxb.setMa(rs.getString("MA"));
                nxb.setTen(rs.getString("Ten"));
                nxb.setTrangThai(rs.getInt("TrangThai"));
            }

        } catch (Exception e) {
        }
        return nxb;
    }

    public List<tacGia> getAllDangKD() {
        List<tacGia> listTG = new ArrayList<>();
        String sql = "SELECT * FROM TACGIA WHERE TrangThai = 0";
        try ( Connection connet = DBContext.getConnection();  PreparedStatement ps = connet.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tacGia tacgia = new tacGia();
                tacgia.setId(rs.getInt(1));
                tacgia.setMa(rs.getString(2));
                tacgia.setTen(rs.getString(3));
                tacgia.setTrangThai(rs.getInt(4));
                listTG.add(tacgia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listTG;
    }
    
        public static void main(String[] args) {
        List<tacGia> tacGias = new tacGiaRepositoryImpl().getAllDangKD();
        System.out.println(tacGias);
    }
}
