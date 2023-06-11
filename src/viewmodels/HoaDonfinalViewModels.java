/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author User
 */
public class HoaDonfinalViewModels {

    private String id;
    private String tenKhachHang;
    private String tenNguoiDung;
    private String ma;
    private double tongTien;
    private double khachCanTra;
    private String ngayTao;
    private int trangThai;

    public HoaDonfinalViewModels() {
    }

    public HoaDonfinalViewModels(String id, String tenKhachHang, String tenNguoiDung, String ma, double tongTien, double khachCanTra, String ngayTao, int trangThai) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.tenNguoiDung = tenNguoiDung;
        this.ma = ma;
        this.tongTien = tongTien;
        this.khachCanTra = khachCanTra;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getKhachCanTra() {
        return khachCanTra;
    }

    public void setKhachCanTra(double khachCanTra) {
        this.khachCanTra = khachCanTra;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
