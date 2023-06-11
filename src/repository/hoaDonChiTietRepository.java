/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodels.HoaDonChiTiet;
import java.util.List;
import viewmodels.HoaDonChiTietViewModels;

/**
 *
 * @author User
 */
public interface hoaDonChiTietRepository {

    List<HoaDonChiTietViewModels> getAll(String idHD);

    Boolean insert(HoaDonChiTiet hoaDonChiTiet,String idhd);
}
