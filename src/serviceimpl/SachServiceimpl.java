/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.Sach;
import java.util.List;
import repository.SachRepository;
import repositoryimpl.Sachrepoimpl;
import service.SachService;
import viewmodels.SachTacGiaViewmodels;
import viewmodels.SachTheLoaiViewModels;
import viewmodels.SachViewModels;

/**
 *
 * @author User
 */
public class SachServiceimpl implements SachService {

    SachRepository sachRepository = new Sachrepoimpl();

    @Override
    public List<SachViewModels> getAll() {
        return this.sachRepository.getAll();
    }

    @Override
    public List<SachViewModels> getAllWithTrangThai(int trangThai) {
        return this.sachRepository.getAllWithTrangThai(trangThai);
    }

    @Override
    public List<SachViewModels> search(String ten) {
        return this.sachRepository.search(ten);
    }

    @Override
    public SachViewModels getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insert(Sach sach) {
        if (this.sachRepository.insert(sach)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(Sach sach, String ma) {
        if (this.sachRepository.update(sach, ma)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String insertTheLoai(SachTheLoaiViewModels sachth) {
        if (this.sachRepository.insertTheLoai(sachth)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String deleteSachTheLoai(String idSach) {
        if (this.sachRepository.deleteSachTheLoai(idSach)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public Boolean insertSachTacGia(SachTacGiaViewmodels sachTG) {
        return this.sachRepository.insertSachTacGia(sachTG);
    }

    @Override
    public Boolean deleteSachTacGia(String idSach) {
        return this.sachRepository.deleteSachTacGia(idSach);
    }

}
