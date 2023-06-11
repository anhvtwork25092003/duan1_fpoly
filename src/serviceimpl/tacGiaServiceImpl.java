/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.tacGia;
import java.util.List;
import repository.tacGiaRepository;
import repositoryimpl.tacGiaRepositoryImpl;
import service.tacGiaSevice;

/**
 *
 * @author Huyên
 */
public class tacGiaServiceImpl implements tacGiaSevice {

    tacGiaRepository giaRepository = new tacGiaRepositoryImpl();

    public List<tacGia> getAll() {
        return giaRepository.getAll();
    }

    public String add(tacGia TG) {
        if (giaRepository.add(TG)) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }

    public String update(tacGia tg, String id) {
        boolean test = giaRepository.update(tg, id);
        if (test) {
            return "Thành công!";
        } else {
            return "Thât bai!";
        }
    }

    public List<tacGia> timKiem(String tenTim) {
        return giaRepository.timKiem(tenTim);
    }

    public List<tacGia> timKiemTT(int trangThai) {
        return giaRepository.timKiemTT(trangThai);
    }

    @Override
    public tacGia getOne(String ten) {
        return this.giaRepository.getOne(ten);
    }

    public List<tacGia> getAllDangKD() {
        return giaRepository.getAllDangKD();
    }
}
