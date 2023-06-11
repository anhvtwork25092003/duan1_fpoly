/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.NguoiDung;
import java.util.List;

import repository.NguoiDungRepository;
import repositoryimpl.NguoiDungRepoImpl;
import service.NguoiDungService;

/**
 *
 * @author User
 */
public class NguoiDungServiceImpl implements NguoiDungService {

    NguoiDungRepository nguoiDungRepo = new NguoiDungRepoImpl();

    @Override
    public List<NguoiDung> getAll() {
        return this.nguoiDungRepo.getAll();
    }

    @Override
    public NguoiDung getOne(String ma) {
        return this.nguoiDungRepo.getOne(ma);
    }

    @Override
    public String insert(NguoiDung nguoiDung) {
        if (this.nguoiDungRepo.insert(nguoiDung)) {
            return "Thanh Cong1";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(NguoiDung nguoiDung, String ma) {
        if (this.nguoiDungRepo.update(nguoiDung, ma)) {
            return "Thanh Cong1";
        } else {
            return "That Bai";
        }
    }

    @Override
    public Boolean validate(String username, String password) {
        return this.nguoiDungRepo.validate(username, password);
    }

    @Override
    public List<NguoiDung> getAllWithTrangThai(int trangThai) {
        return this.nguoiDungRepo.getAllWithTrangThai(trangThai);
    }

    @Override
    public List<NguoiDung> search(String ten) {
        return this.nguoiDungRepo.search(ten);
    }

    @Override
    public Boolean rePassword(String username, String oldPass, String newPass) {
        return this.nguoiDungRepo.rePassword(username, oldPass, newPass);
    }

}
