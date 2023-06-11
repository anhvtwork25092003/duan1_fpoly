/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.KhachHang;
import java.util.List;
import repository.KhachHangRepository;
import repositoryimpl.KhachHangRepositoryImpl;
import service.KhachHangService;

/**
 *
 * @author Huyên
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository khachHangRepo = new KhachHangRepositoryImpl();

    public List<KhachHang> getAll() {
        return khachHangRepo.getAll();
    }

    public String add(KhachHang khachHang) {
        if (khachHangRepo.add(khachHang)) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    public String sua(KhachHang khachHang, String id) {
        boolean test = khachHangRepo.sua(khachHang, id);
        if (test) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    public List<KhachHang> timKiem(String tenTim) {
        return khachHangRepo.timKiem(tenTim);
    }

    public List<KhachHang> timKiemTT(int trangThai) {
        return khachHangRepo.timKiemTT(trangThai);
    }

    public String addByName(KhachHang khachHang) {
        boolean check = khachHangRepo.addByName(khachHang);
        if (check) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }

    public List<KhachHang> getDangHD() {
        return khachHangRepo.getDangHD();
    }
}
