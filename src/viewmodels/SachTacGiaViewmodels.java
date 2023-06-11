/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author User
 */
public class SachTacGiaViewmodels {
    private int idSach;
    private int idTacGia;

    public SachTacGiaViewmodels() {
    }

    @Override
    public String toString() {
        return "SachTacGiaViewmodels{" + "idSach=" + idSach + ", idTacGia=" + idTacGia + '}';
    }

    public SachTacGiaViewmodels(int idSach, int idTacGia) {
        this.idSach = idSach;
        this.idTacGia = idTacGia;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }
    
}
