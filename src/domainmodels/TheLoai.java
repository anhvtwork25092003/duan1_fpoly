/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author User
 */
public class TheLoai {
    private String id;
    private String ma;
    private String ten;
    private String ngaytao;
    private String ngaysua;
    private int trangthai;

    public TheLoai() {
    }

    public TheLoai(String id, String ma, String ten, String ngaytao, String ngaysua, int trangthai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.trangthai = trangthai;
    }

    public TheLoai(String ten, int trangthai) {
        this.ten = ten;
        this.trangthai = trangthai;
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

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(String ngaysua) {
        this.ngaysua = ngaysua;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "TheLoai{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", trangthai=" + trangthai + '}';
    }
    
    
}
