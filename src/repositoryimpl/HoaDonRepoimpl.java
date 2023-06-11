/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.HoaDon;
import domainmodels.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.HoaDonRepository;
import viewmodels.HoaDonViewModels;
import viewmodels.HoaDonfinalViewModels;

/**
 *
 * @author User
 */
public class HoaDonRepoimpl implements HoaDonRepository {

    @Override
    public List<HoaDonfinalViewModels> getAll(String ngayHomNay) {
        List<HoaDonfinalViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT hoadon.id AS id, KHACHHANG.hoten AS ten_khach_hang, NGUOIDUNG.hoten AS ten_nguoi_dung, hoadon.ma AS ma_hoa_don, hoadon.tongtien AS tong_tien,  hoadon.TONGTIENSAUKHUYENMAI AS tong_tien_khach_can_tra, hoadon.ngaytao AS ngay_tao, hoadon.trangthai AS trang_thai\n"
                    + "                    FROM hoadon \n"
                    + "                    INNER JOIN KHACHHANG ON hoadon.IDkh = KHACHHANG.id\n"
                    + "                   INNER JOIN nguoidung ON HOADON.idnd = NGUOIDUNG.id where ngaytao = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ngayHomNay);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenKhachHang = rs.getString("ten_khach_hang");
                String tenNguoiDung = rs.getString("ten_nguoi_dung");
                String ma = rs.getString("ma_hoa_don");
                Double tongTien = rs.getDouble("tong_tien");
                Double khachCanTra = rs.getDouble("tong_tien_khach_can_tra");
                String ngayTao = rs.getString("ngay_tao");
                int trangThai = rs.getInt("trang_thai");
                HoaDonfinalViewModels donfinalViewModels = new HoaDonfinalViewModels(id, tenKhachHang, tenNguoiDung, ma, tongTien, khachCanTra, ngayTao, trangThai);
                listAll.add(donfinalViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public List<HoaDonfinalViewModels> getAllwithDate(String beginDate, String enDate) {
        List<HoaDonfinalViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT hoadon.id AS id, KHACHHANG.hoten AS ten_khach_hang, NGUOIDUNG.hoten AS ten_nguoi_dung, hoadon.ma AS ma_hoa_don, hoadon.tongtien AS tong_tien,  hoadon.TONGTIENSAUKHUYENMAI AS tong_tien_khach_can_tra, hoadon.ngaytao AS ngay_tao, hoadon.trangthai AS trang_thai\n"
                    + "                    FROM hoadon \n"
                    + "                    INNER JOIN KHACHHANG ON hoadon.IDkh = KHACHHANG.id\n"
                    + "                   INNER JOIN nguoidung ON HOADON.idnd = NGUOIDUNG.id  WHERE ngaytao BETWEEN ? AND ?; ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, beginDate);
            ps.setString(2, enDate);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenKhachHang = rs.getString("ten_khach_hang");
                String tenNguoiDung = rs.getString("ten_nguoi_dung");
                String ma = rs.getString("ma_hoa_don");
                Double tongTien = rs.getDouble("tong_tien");
                Double khachCanTra = rs.getDouble("tong_tien_khach_can_tra");
                String ngayTao = rs.getString("ngay_tao");
                int trangThai = rs.getInt("trang_thai");
                HoaDonfinalViewModels donfinalViewModels = new HoaDonfinalViewModels(id, tenKhachHang, tenNguoiDung, ma, tongTien, khachCanTra, ngayTao, trangThai);
                listAll.add(donfinalViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public int insert(HoaDon hoadon) {
        ResultSet rs = null;
        int hoaDonId = 0; // ID hóa đơn mới được thêm vào
        String sql = "INSERT INTO hoadon (idkh, idnd, tongtien, TONGTIENSAUKHUYENMAI, NgayTao, TrangThai) "
                + "VALUES (?, ?, ?, ?,  ?, ?);";
        try ( Connection connect = DBContext.getConnection();  PreparedStatement ps = connect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, hoadon.getIdnd());
            ps.setString(2, hoadon.getIdnd());
            ps.setDouble(3, hoadon.getTongTien());
            ps.setDouble(4, hoadon.getKhachCanTra());
            ps.setString(5, hoadon.getNgayTao());
            ps.setInt(6, hoadon.getTrangThai());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    hoaDonId = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Trả về ID hóa đơn mới được thêm vào
        return hoaDonId;
    }

    @Override
    public List<HoaDonfinalViewModels> getOnewithMa(String masearch) {
        List<HoaDonfinalViewModels> listAll = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT hoadon.id AS id, KHACHHANG.hoten AS ten_khach_hang, NGUOIDUNG.hoten AS ten_nguoi_dung, hoadon.ma AS ma_hoa_don, hoadon.tongtien AS tong_tien,  hoadon.TONGTIENSAUKHUYENMAI AS tong_tien_khach_can_tra, hoadon.ngaytao AS ngay_tao, hoadon.trangthai AS trang_thai\n"
                    + "                    FROM hoadon \n"
                    + "                    INNER JOIN KHACHHANG ON hoadon.IDkh = KHACHHANG.id\n"
                    + "                   INNER JOIN nguoidung ON HOADON.idnd = NGUOIDUNG.id where hoadon.ma like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + masearch + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenKhachHang = rs.getString("ten_khach_hang");
                String tenNguoiDung = rs.getString("ten_nguoi_dung");
                String ma = rs.getString("ma_hoa_don");
                Double tongTien = rs.getDouble("tong_tien");
                Double khachCanTra = rs.getDouble("tong_tien_khach_can_tra");
                String ngayTao = rs.getString("ngay_tao");
                int trangThai = rs.getInt("trang_thai");
                HoaDonfinalViewModels donfinalViewModels = new HoaDonfinalViewModels(id, tenKhachHang, tenNguoiDung, ma, tongTien, khachCanTra, ngayTao, trangThai);
                listAll.add(donfinalViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public HoaDonfinalViewModels getOnewithId(int idhdserahc) {
        HoaDonfinalViewModels hdon = null;
        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT hoadon.id AS id, KHACHHANG.hoten AS ten_khach_hang, NGUOIDUNG.hoten AS ten_nguoi_dung, hoadon.ma AS ma_hoa_don, hoadon.tongtien AS tong_tien,  hoadon.TONGTIENSAUKHUYENMAI AS tong_tien_khach_can_tra, hoadon.ngaytao AS ngay_tao, hoadon.trangthai AS trang_thai\n"
                    + "                    FROM hoadon \n"
                    + "                    INNER JOIN KHACHHANG ON hoadon.IDkh = KHACHHANG.id\n"
                    + "                   INNER JOIN nguoidung ON HOADON.idnd = NGUOIDUNG.id where hoadon.id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,idhdserahc);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenKhachHang = rs.getString("ten_khach_hang");
                String tenNguoiDung = rs.getString("ten_nguoi_dung");
                String ma = rs.getString("ma_hoa_don");
                Double tongTien = rs.getDouble("tong_tien");
                Double khachCanTra = rs.getDouble("tong_tien_khach_can_tra");
                String ngayTao = rs.getString("ngay_tao");
                int trangThai = rs.getInt("trang_thai");
                HoaDonfinalViewModels donfinalViewModels = new HoaDonfinalViewModels(id, tenKhachHang, tenNguoiDung, ma, tongTien, khachCanTra, ngayTao, trangThai);
                hdon = donfinalViewModels;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hdon;
    }

     public List<HoaDon> getAllHoaDon() {
        List<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MA, NgayTao, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where TrangThai=5 or TrangThai=4 or TrangThai=2"
            + " ORDER BY Cast(SUBSTRING(dbo.HoaDon.MA, 3,2) as int)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    
    public ArrayList<HoaDon> finByTrangThai(int ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT MA, NgayTao, TOngTIEN, TrangThai\n"
                    + " FROM     dbo.HoaDon where TrangThai like '%" + ma + "%'";
                    // + "ORDER BY Cast(SUBSTRING(dbo.HoaDon.MA, 3,2) as int)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    public ArrayList<HoaDon> finByNgayThanhToan(String ma) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Ma, NgayTao, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayTao like '%" + ma + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    public ArrayList<HoaDon> finByNgayThanhToanandTH(int ma, int mi) {
        ArrayList<HoaDon> listsp = new ArrayList<>();
        Connection con;
        try {
            con = DBContext.getConnection();
            String sql = "SELECT Ma, NgayTao, TongTien, TrangThai\n"
                    + " FROM     dbo.HoaDon where NgayTao like '%" + ma + "%' and TrangThai like '%" + mi + "%'"
                    +  "ORDER BY Cast(SUBSTRING(dbo.HoaDon.Ma, 3,2) as int)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                HoaDon bhsp = new HoaDon(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
                listsp.add(bhsp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonRepoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listsp;
    }

    @Override
    public List<HoaDonfinalViewModels> getAll() {
        List<HoaDonfinalViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = "SELECT hoadon.id AS id, KHACHHANG.hoten AS ten_khach_hang, NGUOIDUNG.hoten AS ten_nguoi_dung, hoadon.ma AS ma_hoa_don, hoadon.tongtien AS tong_tien,  hoadon.TONGTIENSAUKHUYENMAI AS tong_tien_khach_can_tra, hoadon.ngaytao AS ngay_tao, hoadon.trangthai AS trang_thai\n"
                    + "                    FROM hoadon \n"
                    + "                    INNER JOIN KHACHHANG ON hoadon.IDkh = KHACHHANG.id\n"
                    + "                   INNER JOIN nguoidung ON HOADON.idnd = NGUOIDUNG.id";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("id");
                String tenKhachHang = rs.getString("ten_khach_hang");
                String tenNguoiDung = rs.getString("ten_nguoi_dung");
                String ma = rs.getString("ma_hoa_don");
                Double tongTien = rs.getDouble("tong_tien");
                Double khachCanTra = rs.getDouble("tong_tien_khach_can_tra");
                String ngayTao = rs.getString("ngay_tao");
                int trangThai = rs.getInt("trang_thai");
                HoaDonfinalViewModels donfinalViewModels = new HoaDonfinalViewModels(id, tenKhachHang, tenNguoiDung, ma, tongTien, khachCanTra, ngayTao, trangThai);
                listAll.add(donfinalViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }
}
