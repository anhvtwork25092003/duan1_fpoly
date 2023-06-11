/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import repository.KhachHangRepository;
import java.sql.*;

/**
 *
 * @author Huyên
 */
public class KhachHangRepositoryImpl implements KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhachHang KH = new KhachHang();
                KH.setId(rs.getString("ID"));
                KH.setMa(rs.getString("MAKH"));
                KH.setTen(rs.getString("HOTEN"));
                KH.setSoDt(rs.getString("SDT"));
                KH.setEmail(rs.getString("EMAIL"));
                KH.setTrangThai(rs.getInt("TRANGTHAI"));

                listKH.add(KH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public boolean add(KhachHang khachHang) {
        int check = 0;
        String sql = "Insert into KHACHHANG(HOTEN,SDT,EMAIL,TRANGTHAI) values(?, ?, ?, ?)";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, khachHang.getTen());
            ps.setString(2, khachHang.getSoDt());
            ps.setString(3, khachHang.getEmail());
            ps.setInt(4, khachHang.getTrangThai());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(KhachHang khachHang, String id) {
        int chech = 0;
        String sql = "update KHACHHANG set HOTEN = ?, SDT = ?, EMAIL = ?, TRANGTHAI = ? WHERE ID = ?";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, khachHang.getTen());
            ps.setString(2, khachHang.getSoDt());
            ps.setString(3, khachHang.getEmail());
            ps.setInt(4, khachHang.getTrangThai());
            ps.setString(5, id);

            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<KhachHang> timKiem(String tenTim) {
        List<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG WHERE HOTEN like ?";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, "%" + tenTim + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getString("ID"));
                khachHang.setMa(rs.getString("MAKH"));
                khachHang.setTen(rs.getString("HOTEN"));
                khachHang.setSoDt(rs.getString("SDT"));
                khachHang.setEmail(rs.getString("EMAIL"));
                khachHang.setTrangThai(rs.getInt("TRANGTHAI"));

                listKH.add(khachHang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKH;
    }
    
    public List<KhachHang> timKiemTT(int trangThai) {
        List<KhachHang> listKH = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "SELECT * FROM KHACHHANG WHERE TrangThai = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getString(1));
                khachHang.setMa(rs.getString(2));
                khachHang.setTen(rs.getString(3));
                khachHang.setSoDt(rs.getString(4));
                khachHang.setEmail(rs.getString(5));
                khachHang.setTrangThai(rs.getInt(6));

                listKH.add(khachHang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKH;
    }

    public boolean addByName(KhachHang khachHang) {
        int check = 0;
        String sql = "Insert into KHACHHANG(HOTEN) values (?)";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, khachHang.getTen());
        } catch (Exception e) {
        }
        return check > 0;
    }
    
    public List<KhachHang> getDangHD() {
        List<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG WHERE TRANGTHAI = 0";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                KhachHang KH = new KhachHang();
                KH.setId(rs.getString("ID"));
                KH.setMa(rs.getString("MAKH"));
                KH.setTen(rs.getString("HOTEN"));
                KH.setSoDt(rs.getString("SDT"));
                KH.setEmail(rs.getString("EMAIL"));
                KH.setTrangThai(rs.getInt("TRANGTHAI"));

                listKH.add(KH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public static void main(String[] args) {
        List<KhachHang> listKh = new KhachHangRepositoryImpl().getDangHD();
        System.out.println(listKh.toString());
    }
}
