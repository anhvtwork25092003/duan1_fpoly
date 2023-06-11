/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface KhachHangService {

    public List<KhachHang> getAll();

    public String add(KhachHang khachHang);

    public String sua(KhachHang khachHang, String id);

    public List<KhachHang> timKiem(String tenTim);

    public List<KhachHang> timKiemTT(int trangThai);

    public String addByName(KhachHang khachHang);

    public List<KhachHang> getDangHD();
}
