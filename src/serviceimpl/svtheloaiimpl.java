/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.TheLoai;
import repositoryimpl.repoTheLoai;
import java.util.ArrayList;
import java.util.List;
import service.svtheloai;

/**
 *
 * @author User
 */
public class svtheloaiimpl implements svtheloai {

    repoTheLoai repotheloai = new repoTheLoai();

    @Override
    public ArrayList<TheLoai> getall() {
        return repotheloai.getAll();
    }

    @Override
    public String insert(TheLoai tl) {
        boolean test = repotheloai.insert(tl);
        if (test) {
            return "Thành công!";
        } else {
            return "That bai!";
        }
    }

    @Override
    public String update(TheLoai tl, String id) {
        boolean test = repotheloai.update(tl, id);
        if (test) {
            return "Thành công!";
        } else {
            return "That bai!";
        }
    }

    public List<TheLoai> timKiem(String tenTim) {
        return repotheloai.timKiem(tenTim);
    }

    public List<TheLoai> timKiemTT(int trangThai) {
        return repotheloai.timKiemTT(trangThai);
    }

    @Override
    public TheLoai getOne(String ten) {
        return this.repotheloai.getOne(ten);
    }

    public ArrayList<TheLoai> getAllDangKD() {
        return repotheloai.getAllDangKD();
    }
}
