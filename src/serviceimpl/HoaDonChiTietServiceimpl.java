/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.HoaDonChiTiet;
import java.util.List;
import repository.hoaDonChiTietRepository;
import repositoryimpl.HoaDonChiTietRepoimpl;
import service.HoaDonChiTietService;
import viewmodels.HoaDonChiTietViewModels;

/**
 *
 * @author User
 */
public class HoaDonChiTietServiceimpl implements HoaDonChiTietService {

    hoaDonChiTietRepository chiTietRepository = new HoaDonChiTietRepoimpl();

    public HoaDonChiTietServiceimpl() {
    }

    @Override
    public List<HoaDonChiTietViewModels> getAll(String idHD) {
        return this.chiTietRepository.getAll(idHD);
    }

    @Override
    public Boolean insert(HoaDonChiTiet hoaDonChiTiet, String idhd) {
        return chiTietRepository.insert(hoaDonChiTiet, idhd);
    }

}
