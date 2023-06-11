/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface KhachHangRepository {

    public List<KhachHang> getAll();

    public boolean add(KhachHang khachHang);

    public boolean sua(KhachHang khachHang, String id);

    public List<KhachHang> timKiem(String tenTim);

    public List<KhachHang> timKiemTT(int trangThai);

    public boolean addByName(KhachHang khachHang);

    public List<KhachHang> getDangHD();
}
