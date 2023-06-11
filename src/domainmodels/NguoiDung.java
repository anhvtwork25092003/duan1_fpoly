/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author User
 */
public class NguoiDung {

    private int id;
    private String ma;
    private String hoTen;
    private String email;
    private int gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private String chucVu;
    private String image;
    private int trangThai;

    @Override
    public String toString() {
        return "NguoiDung{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", email=" + email + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", matKhau=" + matKhau + ", chucVu=" + chucVu + ", image=" + image + ", trangThai=" + trangThai + '}';
    }
    

    public NguoiDung(int id, String ma, String hoTen, String email, int gioiTinh, String ngaySinh, String diaChi, String sdt, String matKhau, String chucVu, String image, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.image = image;
        this.trangThai = trangThai;
    }

    public NguoiDung() {
    }

    public NguoiDung(String hoTen, String email, int gioiTinh, String ngaySinh, String diaChi, String sdt, String matKhau, String chucVu, String image, int trangThai) {
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.image = image;
        this.trangThai = trangThai;
    }

    public NguoiDung(String ma, String matKhau) {
        this.ma = ma;
        this.matKhau = matKhau;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
