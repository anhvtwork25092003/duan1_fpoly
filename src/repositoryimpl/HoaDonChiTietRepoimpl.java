/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.hoaDonChiTietRepository;
import viewmodels.HoaDonChiTietViewModels;
import viewmodels.HoaDonViewModels;

/**
 *
 * @author User
 */
public class HoaDonChiTietRepoimpl implements hoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTietViewModels> getAll(String idHDsearch) {
        List<HoaDonChiTietViewModels> listAll = new ArrayList<>();

        try {
            Connection conn = DBContext.getConnection();
            String query = " SELECT sach.Ma, sach.TENSACH, hoadonct.SoLuong, HOADONCT.DonGia, hoadonct.thanhtien\n"
                    + "FROM hoadonct\n"
                    + "JOIN sach ON hoadonct.IDSACH = sach.ID\n"
                    + "where hoadonct.idhd = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idHDsearch);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("ma");
                String tensach = rs.getString("tensach");
                double donGia = rs.getDouble("dongia");
                int soLuong = rs.getInt("soluong");
                double thanhTien = rs.getDouble("thanhTien");
                HoaDonChiTietViewModels hoaDonChiTietViewModels = new HoaDonChiTietViewModels(ma, tensach, donGia, soLuong, thanhTien);
                listAll.add(hoaDonChiTietViewModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAll;
    }

    @Override
    public Boolean insert(HoaDonChiTiet hoaDonChiTiet, String idhd) {
        int check = 0;
        String query = "insert into hoadonct(idsach, idhd, dongia, soluong, thanhtien)  values(?, ?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, hoaDonChiTiet.getIdSach());
            ps.setString(2, idhd);
            ps.setDouble(3, hoaDonChiTiet.getDonGia());
            ps.setInt(4, hoaDonChiTiet.getSoLuong());
            ps.setDouble(5, hoaDonChiTiet.getThanhTien());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
