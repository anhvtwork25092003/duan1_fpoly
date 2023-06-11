/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author User
 */
public class HoaDonViewModels {

    private String id;
    private String tenKhachHang;
    private String tenNguoiDung;
    private String ma;
    private double tongTien;
    private int chieuKhau;
    private double tongTienSauKhuyenMai;
    private String ngayTao;
    private int trangThai;

    public HoaDonViewModels() {
    }

    @Override
    public String toString() {
        return "HoaDonViewModels{" + "id=" + id + ", tenKhachHang=" + tenKhachHang + ", tenNguoiDung=" + tenNguoiDung + ", ma=" + ma + ", tongTien=" + tongTien + ", chieuKhau=" + chieuKhau + ", tongTienSauKhuyenMai=" + tongTienSauKhuyenMai + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

    

    public HoaDonViewModels(String id, String tenKhachHang, String tenNguoiDung, String ma, double tongTien, int chieuKhau, double tongTienSauKhuyenMai, String ngayTao, int trangThai) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.tenNguoiDung = tenNguoiDung;
        this.ma = ma;
        this.tongTien = tongTien;
        this.chieuKhau = chieuKhau;
        this.tongTienSauKhuyenMai = tongTienSauKhuyenMai;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }
     public HoaDonViewModels( String ma, String ngayTao, double tongTien, int trangThai) {     
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        
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

    public int getChieuKhau() {
        return chieuKhau;
    }

    public void setChieuKhau(int chieuKhau) {
        this.chieuKhau = chieuKhau;
    }

    public double getTongTienSauKhuyenMai() {
        return tongTienSauKhuyenMai;
    }

    public void setTongTienSauKhuyenMai(double tongTienSauKhuyenMai) {
        this.tongTienSauKhuyenMai = tongTienSauKhuyenMai;
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
