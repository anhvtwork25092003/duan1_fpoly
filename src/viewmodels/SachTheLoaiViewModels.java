/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author User
 */
public class SachTheLoaiViewModels {
    private String idSach;
    private String idTheLoai;

    public SachTheLoaiViewModels() {
    }

    public SachTheLoaiViewModels(String idSach, String idTheLoai) {
        this.idSach = idSach;
        this.idTheLoai = idTheLoai;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(String idTheLoai) {
        this.idTheLoai = idTheLoai;
    }
    
    
}
