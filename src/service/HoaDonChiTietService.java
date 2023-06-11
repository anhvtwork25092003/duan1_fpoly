/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.HoaDonChiTiet;
import java.util.List;
import viewmodels.HoaDonChiTietViewModels;

/**
 *
 * @author User
 */
public interface HoaDonChiTietService {

    List<HoaDonChiTietViewModels> getAll(String idHD);

    Boolean insert(HoaDonChiTiet hoaDonChiTiet, String idhd);
}
