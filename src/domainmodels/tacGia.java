/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author Huyên
 */
public class tacGia {
    private int id;
    private String ma;
    private String  ten;
    private int trangThai;

    public tacGia() {
    }

    public tacGia(String ten, int trangThai) {
        this.ten = ten;
        this.trangThai = trangThai;
    }
    

    public tacGia(int id, String ma, String ten, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "tacGia{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", trangThai=" + trangThai + '}';
    }
    
    
}
