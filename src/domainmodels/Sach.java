/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author User
 */
public class Sach {

    private String id;
    private String ma;
    private String ten;
    private String idnxb;
    private String mota;
    private double giaNhap;
    private double giaBan;
    private int trangThai;
    private String imageLink;
    private String maVach;

    public Sach(String ten, String idnxb, String mota, double giaNhap, double giaBan, int trangThai, String imageLink, String maVach) {
        this.ten = ten;
        this.idnxb = idnxb;
        this.mota = mota;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
        this.imageLink = imageLink;
        this.maVach = maVach;
    }

    public Sach(String id, String ma, String ten, String idnxb, String mota, double giaNhap, double giaBan, int trangThai, String imageLink, String maVach) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idnxb = idnxb;
        this.mota = mota;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
        this.imageLink = imageLink;
        this.maVach = maVach;
    }

    public Sach() {
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

    public String getIdnxb() {
        return idnxb;
    }

    public void setIdnxb(String idnxb) {
        this.idnxb = idnxb;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    @Override
    public String toString() {
        return "Sach{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", idnxb=" + idnxb + ", mota=" + mota + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", trangThai=" + trangThai + ", imageLink=" + imageLink + ", maVach=" + maVach + '}';
    }

    
    
}
