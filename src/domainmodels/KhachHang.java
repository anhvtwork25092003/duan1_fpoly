/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author Huyên
 */
public class KhachHang {

    private String id;
    private String ma;
    private String ten;
    private String soDt;
    private String email;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(String ten, String soDt, String email, int trangThai) {
        this.ten = ten;
        this.soDt = soDt;
        this.email = email;
        this.trangThai = trangThai;
    }

    public KhachHang(String id, String ma, String ten, String soDt, String email, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soDt = soDt;
        this.email = email;
        this.trangThai = trangThai;
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

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", soDt=" + soDt + ", email=" + email + ", trangThai=" + trangThai + '}';
    }

}
