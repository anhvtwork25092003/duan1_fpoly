/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.HoaDon;
import java.util.ArrayList;
import java.util.List;
import viewmodels.HoaDonViewModels;
import viewmodels.HoaDonfinalViewModels;

/**
 *
 * @author User
 */
public interface HoaDonService {

    List<HoaDonfinalViewModels> getAll(String ngayhomnay);

    List<HoaDonfinalViewModels> getAllwithDate(String beginDate, String enDate);

    int insert(HoaDon hoaDon);

    List<HoaDonfinalViewModels> getonewithma(String ma);

    HoaDonfinalViewModels getonewithid(int id);
    
    ArrayList<HoaDonViewModels> finbyngaythanhToan(String hd);

    ArrayList<HoaDonViewModels> finbyngaytrangThai(int ma);

    ArrayList<HoaDon> finByNgayThanhToanandTrangThai(int ma, int mi);

    //List<HoaDonViewModels> finByKhoangNgayThanhToan(Date ngay1, Date ngay2);

    List<HoaDonViewModels> GetListHoaSon();

    List<HoaDonfinalViewModels> getAll();

}
