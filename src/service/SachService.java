/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.NguoiDung;
import domainmodels.Sach;
import java.util.List;
import viewmodels.SachTacGiaViewmodels;
import viewmodels.SachTheLoaiViewModels;
import viewmodels.SachViewModels;

/**
 *
 * @author User
 */
public interface SachService {

    List<SachViewModels> getAll();

    List<SachViewModels> getAllWithTrangThai(int trangThai);

    List<SachViewModels> search(String ten);

    SachViewModels getOne(String ma);

    String insert(Sach sach);

    String update(Sach sach, String ma);

    String insertTheLoai(SachTheLoaiViewModels sachth);

    String deleteSachTheLoai(String idSach);

    Boolean insertSachTacGia(SachTacGiaViewmodels sachTG);

    Boolean deleteSachTacGia(String idSach);
}
