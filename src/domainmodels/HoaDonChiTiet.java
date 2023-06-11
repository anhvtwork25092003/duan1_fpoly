/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author User
 */
public class HoaDonChiTiet {

    private String id;
    private String idSach;
    private String idHd;
    private double donGia;
    private int soLuong;
    private double thanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idSach, double donGia, int soLuong, double thanhTien) {
        this.idSach = idSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public HoaDonChiTiet(String id, String idSach, String idHd, double donGia, int soLuong, double thanhTien) {
        this.id = id;
        this.idSach = idSach;
        this.idHd = idHd;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getIdHd() {
        return idHd;
    }

    public void setIdHd(String idHd) {
        this.idHd = idHd;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", idSach=" + idSach + ", idHd=" + idHd + ", donGia=" + donGia + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }
    
    
    

}
