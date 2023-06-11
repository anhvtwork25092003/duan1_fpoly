/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodels.HoaDon;
import java.util.ArrayList;
import java.util.List;
import viewmodels.HoaDonViewModels;
import viewmodels.HoaDonfinalViewModels;

/**
 *
 * @author User
 */
public interface HoaDonRepository {

    List<HoaDonfinalViewModels> getAll(String ngayHomNay);
    List<HoaDonfinalViewModels> getAll();
    List<HoaDonfinalViewModels> getAllwithDate(String beginDate, String enDate);

    int insert(HoaDon hoadon);

    List<HoaDonfinalViewModels> getOnewithMa(String ma);

    HoaDonfinalViewModels getOnewithId(int idhd);
    List<HoaDon> getAllHoaDon();
    ArrayList<HoaDon> finByTrangThai(int ma);
     ArrayList<HoaDon> finByNgayThanhToan(String ma);
     ArrayList<HoaDon> finByNgayThanhToanandTH(int ma, int mi);

     
     
}
