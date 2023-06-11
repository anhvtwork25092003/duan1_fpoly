/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodels.NguoiDung;
import domainmodels.Sach;
import domainmodels.SachTacGia;
import java.util.List;
import viewmodels.SachTacGiaViewmodels;
import viewmodels.SachTheLoaiViewModels;
import viewmodels.SachViewModels;

/**
 *
 * @author User
 */
public interface SachRepository {

    List<SachViewModels> getAll();

    List<SachViewModels> search(String ten);

    List<SachViewModels> getAllWithTrangThai(int trangThai);

    Sach getOne(String ma);

    Boolean insert(Sach sach);

    Boolean update(Sach sach, String ma);

    Boolean insertTheLoai(SachTheLoaiViewModels sachth);

    Boolean deleteSachTheLoai(String idSach);

    Boolean insertSachTacGia(SachTacGiaViewmodels sachTG);

    Boolean deleteSachTacGia(String idSach);
}
