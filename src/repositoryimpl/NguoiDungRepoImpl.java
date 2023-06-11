/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.NguoiDungRepository;

/**
 *
 * @author User
 */
public class NguoiDungRepoImpl implements NguoiDungRepository {

    @Override
    public List<NguoiDung> getAll() {
        List<NguoiDung> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " select * from NguoiDung ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("HoTen");
                String email = rs.getString("email");
                int gioiTinh = rs.getInt("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                String chucVu = rs.getString("chucVu");
                String image = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                NguoiDung nd = new NguoiDung(id, ma, ten, email, gioiTinh, ngaySinh, diaChi, sdt, matKhau, chucVu, image, trangthai);
                listAll.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public NguoiDung getOne(String maSearch) {
        NguoiDung ndung = new NguoiDung();
        try {
            Connection conn = DBContext.getConnection();
            String query = " SELECT * FROM nguoidung WHERE ma LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maSearch);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("HoTen");
                String email = rs.getString("email");
                int gioiTinh = rs.getInt("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                String chucVu = rs.getString("chucVu");
                String image = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                NguoiDung nd = new NguoiDung(id, ma, ten, email, gioiTinh, ngaySinh, diaChi, sdt, matKhau, chucVu, image, trangthai);
                ndung = nd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ndung;

    }

    @Override
    public Boolean insert(NguoiDung nguoiDung) {
        int check = 0;
        String query = "insert into NguoiDung(hoten, email, gioitinh, ngaysinh, diachi, sdt, matkhau, chucvu, imagelink, trangthai ) values(?, ?,?,?,?,?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, nguoiDung.getHoTen());
            ps.setString(2, nguoiDung.getEmail());
            ps.setInt(3, nguoiDung.getGioiTinh());
            ps.setString(4, nguoiDung.getNgaySinh());
            ps.setString(5, nguoiDung.getDiaChi());
            ps.setString(6, nguoiDung.getSdt());
            ps.setString(7, nguoiDung.getMatKhau());
            ps.setString(8, nguoiDung.getChucVu());
            ps.setString(9, nguoiDung.getImage());
            ps.setInt(10, nguoiDung.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean update(NguoiDung nguoiDung, String ma) {
        try {
            Connection con = DBContext.getConnection();
            String query = "UPDATE [dbo].[NGUOIDUNG]\n"
                    + "   SET \n"
                    + "     [HOTEN] =?\n"
                    + "      ,[EMAIL] =?\n"
                    + "      ,[GIOITINH] = ?\n"
                    + "      ,[NGAYSINH] =?\n"
                    + "      ,[DIACHI] = ?\n"
                    + "      ,[SDT] = ?\n"
                    + "      ,[MATKHAU] = ?\n"
                    + "      ,[CHUCVU] = ?\n"
                    + "      ,[Imagelink] = ?\n"
                    + "      ,[TRANGTHAI] = ? where ma = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nguoiDung.getHoTen());
            ps.setString(2, nguoiDung.getEmail());
            ps.setInt(3, nguoiDung.getGioiTinh());
            ps.setString(4, nguoiDung.getNgaySinh());
            ps.setString(5, nguoiDung.getDiaChi());
            ps.setString(6, nguoiDung.getSdt());
            ps.setString(7, nguoiDung.getMatKhau());
            ps.setString(8, nguoiDung.getChucVu());
            ps.setString(9, nguoiDung.getImage());
            ps.setInt(10, nguoiDung.getTrangThai());
            ps.setString(11, ma);
            ps.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return false;

    }

    @Override
    public Boolean validate(String username, String password) {
        boolean loggedIn = false;
        try ( Connection conn = DBContext.getConnection()) {
            String sql = "SELECT * FROM nguoidung WHERE ma = ? AND matKhau = ?";
            try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try ( ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        loggedIn = true;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return loggedIn;
    }

    public static void main(String[] args) {
        System.out.println(new NguoiDungRepoImpl().getOne("ND001"));
    }

    @Override
    public List<NguoiDung> getAllWithTrangThai(int trangThai) {
        List<NguoiDung> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " select * from NguoiDung where trangthai = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("HoTen");
                String email = rs.getString("email");
                int gioiTinh = rs.getInt("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                String chucVu = rs.getString("chucVu");
                String image = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                NguoiDung nd = new NguoiDung(id, ma, ten, email, gioiTinh, ngaySinh, diaChi, sdt, matKhau, chucVu, image, trangthai);
                listAll.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public List<NguoiDung> search(String tenSearch) {
        List<NguoiDung> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " SELECT * FROM nguoidung WHERE hoten LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tenSearch + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("HoTen");
                String email = rs.getString("email");
                int gioiTinh = rs.getInt("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                String chucVu = rs.getString("chucVu");
                String image = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                NguoiDung nd = new NguoiDung(id, ma, ten, email, gioiTinh, ngaySinh, diaChi, sdt, matKhau, chucVu, image, trangthai);
                listAll.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public Boolean rePassword(String username, String oldPass, String newPass) {
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT * FROM nguoidung WHERE ma = ? AND matkhau = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, oldPass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                query = "UPDATE nguoidung SET matkhau = ? WHERE ma = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, newPass);
                ps.setString(2, username);
                int result = ps.executeUpdate();
                conn.close();
                return result > 0;
            } else {
                conn.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
