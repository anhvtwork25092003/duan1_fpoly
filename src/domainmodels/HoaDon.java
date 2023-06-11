/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author User
 */
public class HoaDon {

    private String id;
    private String idkh;
    private String idnd;
    private String ma;
    private double tongTien;
    private double khachCanTra;
    private String ngayTao;
    private int trangThai;

    public HoaDon() {
    }

    public HoaDon(String string, String string0, double aDouble, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idkh=" + idkh + ", idnd=" + idnd + ", ma=" + ma + ", tongTien=" + tongTien + ", khachCanTra=" + khachCanTra + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

    public HoaDon(String idkh, String idnd, double tongTien, double khachCanTra, String ngayTao, int trangThai) {
        this.idkh = idkh;
        this.idnd = idnd;
        this.tongTien = tongTien;
        this.khachCanTra = khachCanTra;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String idkh, String idnd, String ma, double tongTien, double khachCanTra, String ngayTao, int trangThai) {
        this.id = id;
        this.idkh = idkh;
        this.idnd = idnd;
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

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public String getIdnd() {
        return idnd;
    }

    public void setIdnd(String idnd) {
        this.idnd = idnd;
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
