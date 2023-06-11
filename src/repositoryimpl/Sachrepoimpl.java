/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.NguoiDung;
import domainmodels.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.SachRepository;
import viewmodels.SachTacGiaViewmodels;
import viewmodels.SachTheLoaiViewModels;
import viewmodels.SachViewModels;

/**
 *
 * @author User
 */
public class Sachrepoimpl implements SachRepository {

    public static void main(String[] args) {
        System.out.println(new Sachrepoimpl().getAll());
    }

    @Override
    public List<SachViewModels> getAll() {
        List<SachViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " SELECT s.id, s.ma, s.tenSach, nxb.ten AS ten_nxb,\n"
                    + "		STUFF((\n"
                    + "			SELECT ', ' + tg.ten\n"
                    + "			FROM Sach_tacGia stg \n"
                    + "			INNER JOIN TacGia tg ON stg.id_Tg = tg.id\n"
                    + "			WHERE stg.id_Sach = s.id\n"
                    + "			FOR XML PATH('')\n"
                    + "		), 1, 2, '') AS ten_tacgia, \n"
                    + "		STUFF((\n"
                    + "			SELECT ', ' + tl.ten\n"
                    + "			FROM Sach_TheLoai stl \n"
                    + "			INNER JOIN TheLoai tl ON stl.id_tl = tl.id\n"
                    + "			WHERE stl.id_Sach = s.id\n"
                    + "			FOR XML PATH('')\n"
                    + "		), 1, 2, '') AS ten_theloai,\n"
                    + "		s.mota, s.giaNhap, s.giaBan, s.TRANGTHAI, s.IMAGELINK, s.MAVACH\n"
                    + "FROM Sach s\n"
                    + "JOIN nxb ON s.idnxb = nxb.id\n"
                    + "GROUP BY s.id, s.ma, s.tenSAch,  nxb.ten, s.mota, s.giaNhap, s.giaBan, s.TRANGTHAI,s.IMAGELINK, s.MAVACH ORDER BY s.id DESC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("tenSach");
                String tenNxb = rs.getString("ten_nxb");
                String tenTacGia = rs.getString("ten_tacgia");
                String tenTheLoai = rs.getString("ten_theloai");
                String moTa = rs.getString("mota");
                double giaNhap = rs.getDouble("giaNhap");
                double giaBan = rs.getDouble("giaBan");
                String maVach = rs.getString("maVach");
                String imageLink = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                SachViewModels sachViewModels = new SachViewModels(id, ma, ten, tenNxb, tenTacGia, tenTheLoai, moTa, giaNhap, giaBan, trangthai, imageLink, maVach);
                listAll.add(sachViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public List<SachViewModels> search(String tenSearch) {
        List<SachViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " SELECT s.id, s.ma, s.tenSach, nxb.ten AS ten_nxb,\n"
                    + "		STUFF((\n"
                    + "			SELECT ', ' + tg.ten\n"
                    + "			FROM Sach_tacGia stg \n"
                    + "			INNER JOIN TacGia tg ON stg.id_Tg = tg.id\n"
                    + "			WHERE stg.id_Sach = s.id\n"
                    + "			FOR XML PATH('')\n"
                    + "		), 1, 2, '') AS ten_tacgia, \n"
                    + "		STUFF((\n"
                    + "			SELECT ', ' + tl.ten\n"
                    + "			FROM Sach_TheLoai stl \n"
                    + "			INNER JOIN TheLoai tl ON stl.id_tl = tl.id\n"
                    + "			WHERE stl.id_Sach = s.id\n"
                    + "			FOR XML PATH('')\n"
                    + "		), 1, 2, '') AS ten_theloai,\n"
                    + "		s.mota, s.giaNhap, s.giaBan, s.TRANGTHAI, s.IMAGELINK, s.MAVACH\n"
                    + "FROM Sach s\n"
                    + "JOIN nxb ON s.idnxb = nxb.id  WHERE s.tenSach LIKE ?\n"
                    + "GROUP BY s.id, s.ma, s.tenSAch,  nxb.ten, s.mota, s.giaNhap, s.giaBan, s.TRANGTHAI,s.IMAGELINK, s.MAVACH";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tenSearch + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("tenSach");
                String tenNxb = rs.getString("ten_nxb");
                String tenTacGia = rs.getString("ten_tacgia");
                String tenTheLoai = rs.getString("ten_theloai");
                String moTa = rs.getString("mota");
                double giaNhap = rs.getDouble("giaNhap");
                double giaBan = rs.getDouble("giaBan");
                String maVach = rs.getString("maVach");
                String imageLink = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                SachViewModels sachViewModels = new SachViewModels(id, ma, ten, tenNxb, tenTacGia, tenTheLoai, moTa, giaNhap, giaBan, trangthai, imageLink, maVach);
                listAll.add(sachViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public List<SachViewModels> getAllWithTrangThai(int trangThaii) {
        List<SachViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " SELECT s.id, s.ma, s.tenSach, nxb.ten AS ten_nxb,\n"
                    + "		STUFF((\n"
                    + "			SELECT ', ' + tg.ten\n"
                    + "			FROM Sach_tacGia stg \n"
                    + "			INNER JOIN TacGia tg ON stg.id_Tg = tg.id\n"
                    + "			WHERE stg.id_Sach = s.id\n"
                    + "			FOR XML PATH('')\n"
                    + "		), 1, 2, '') AS ten_tacgia, \n"
                    + "		STUFF((\n"
                    + "			SELECT ', ' + tl.ten\n"
                    + "			FROM Sach_TheLoai stl \n"
                    + "			INNER JOIN TheLoai tl ON stl.id_tl = tl.id\n"
                    + "			WHERE stl.id_Sach = s.id\n"
                    + "			FOR XML PATH('')\n"
                    + "		), 1, 2, '') AS ten_theloai,\n"
                    + "		s.mota, s.giaNhap, s.giaBan, s.TRANGTHAI, s.IMAGELINK, s.MAVACH\n"
                    + "FROM Sach s\n"
                    + "JOIN nxb ON s.idnxb = nxb.id  WHERE s.trangthai LIKE ?\n"
                    + "GROUP BY s.id, s.ma, s.tenSAch,  nxb.ten, s.mota, s.giaNhap, s.giaBan, s.TRANGTHAI,s.IMAGELINK, s.MAVACH";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, trangThaii);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("tenSach");
                String tenNxb = rs.getString("ten_nxb");
                String tenTacGia = rs.getString("ten_tacgia");
                String tenTheLoai = rs.getString("ten_theloai");
                String moTa = rs.getString("mota");
                double giaNhap = rs.getDouble("giaNhap");
                double giaBan = rs.getDouble("giaBan");
                String maVach = rs.getString("maVach");
                String imageLink = rs.getString("imagelink");
                int trangthai = rs.getInt("trangThai");
                SachViewModels sachViewModels = new SachViewModels(id, ma, ten, tenNxb, tenTacGia, tenTheLoai, moTa, giaNhap, giaBan, trangthai, imageLink, maVach);
                listAll.add(sachViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public Sach getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean insert(Sach sach) {
        int check = 0;
        String query = "insert into Sach(tensach, idnxb, mota, gianhap, giaban, trangThai, imagelink, mavach ) values(?, ?,?,?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, sach.getTen());
            ps.setString(2, sach.getIdnxb());
            ps.setString(3, sach.getMota());
            ps.setDouble(4, sach.getGiaNhap());
            ps.setDouble(5, sach.getGiaBan());
            ps.setInt(6, sach.getTrangThai());
            ps.setString(7, sach.getImageLink());
            ps.setString(8, sach.getMaVach());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean update(Sach sach, String ma) {
        try {
            Connection con = DBContext.getConnection();
            String query = "UPDATE [dbo].[SACH]\n"
                    + "   SET[TENSACH] = ?\n"
                    + "      ,[IdNXB] = ?\n"
                    + "      ,[MOTA] = ?\n"
                    + "      ,[GIANHAP] = ?\n"
                    + "      ,[GIABAN] =?\n"
                    + "      ,[TRANGTHAI] = ?\n"
                    + "      ,[IMAGELINK] = ?\n"
                    + "      ,[MAVACH] = ?\n"
                    + " WHERE ma = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sach.getTen());
            ps.setString(2, sach.getIdnxb());
            ps.setString(3, sach.getMota());
            ps.setDouble(4, sach.getGiaNhap());
            ps.setDouble(5, sach.getGiaBan());
            ps.setInt(6, sach.getTrangThai());
            ps.setString(7, sach.getImageLink());
            ps.setString(8, sach.getMaVach());
            ps.setString(9, ma);
            ps.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public Boolean insertTheLoai(SachTheLoaiViewModels sachth) {
        int check = 0;
        String query = "   INSERT INTO [dbo].[SACH_THELOAI]\n"
                + "         ([ID_SACH]\n"
                + "           ,[ID_TL])\n"
                + "    VALUES\n"
                + "          (?\n"
                + "          ,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, sachth.getIdSach());
            ps.setString(2, sachth.getIdTheLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean deleteSachTheLoai(String idSach) {
        int check = 0;
        String query = " delete from SACH_THELOAI where id_Sach = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, idSach);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean insertSachTacGia(SachTacGiaViewmodels sachTG) {
        int check = 0;
        String query = " insert into Sach_tacgia(id_sach, id_tg) values (?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, sachTG.getIdSach());
            ps.setInt(2, sachTG.getIdTacGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean deleteSachTacGia(String idSach) {
        int check = 0;
        String query = " delete from SACH_TACGIA where id_Sach = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, idSach);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
