/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author User
 */
public class SanPhamViewModels {

    private String id;
    private String ma;
    private String ten;
    private double giaBan;
    private int soLuong;
    private double thanhTien;

    public SanPhamViewModels() {
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    

    public SanPhamViewModels(String id, String ma, String ten, double giaBan, int soLuong, double thanhTien) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public SanPhamViewModels(String id, String ma, String ten, double giaBan, int soLuong) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPhamViewModels{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", giaBan=" + giaBan + ", soLuong=" + soLuong + '}';
    }
}
