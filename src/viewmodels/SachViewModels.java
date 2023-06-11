/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author User
 */
public class SachViewModels {

    private String id;
    private String ma;
    private String tenSach;
    private String tenNXB;
    private String tenTacGia;
    private String tenTheLoai;
    private String moTa;
    private double giaNhap;
    private double giaBan;
    private int trangthai;
    private String imageLink;
    private String maVach;

    public SachViewModels(String id, String ma, String tenSach, String tenNXB, String tenTacGia, String tenTheLoai, String moTa, double giaNhap, double giaBan, int trangthai, String imageLink, String maVach) {
        this.id = id;
        this.ma = ma;
        this.tenSach = tenSach;
        this.tenNXB = tenNXB;
        this.tenTacGia = tenTacGia;
        this.tenTheLoai = tenTheLoai;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangthai = trangthai;
        this.imageLink = imageLink;
        this.maVach = maVach;
    }

    @Override
    public String toString() {
        return "SachViewModels{" + "id=" + id + ", ma=" + ma + ", tenSach=" + tenSach + ", tenNXB=" + tenNXB + ", tenTacGia=" + tenTacGia + ", tenTheLoai=" + tenTheLoai + ", moTa=" + moTa + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", trangthai=" + trangthai + ", imageLink=" + imageLink + ", maVach=" + maVach + '}';
    }

    public SachViewModels() {
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

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
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

  
}
