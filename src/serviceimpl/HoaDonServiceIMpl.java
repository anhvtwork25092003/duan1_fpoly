/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.HoaDon;
import java.util.ArrayList;
import java.util.List;
import repository.HoaDonRepository;
import repositoryimpl.HoaDonRepoimpl;
import service.HoaDonService;
import viewmodels.HoaDonViewModels;
import viewmodels.HoaDonfinalViewModels;

/**
 *
 * @author User
 */
public class HoaDonServiceIMpl implements HoaDonService {

    HoaDonRepository hoaDonRepository = new HoaDonRepoimpl();

    @Override
    public List<HoaDonfinalViewModels> getAll(String ngayHomNay) {
        return hoaDonRepository.getAll(ngayHomNay);
    }

    @Override
    public List<HoaDonfinalViewModels> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public List<HoaDonfinalViewModels> getAllwithDate(String beginDate, String enDate) {
        return this.hoaDonRepository.getAllwithDate(beginDate, enDate);
    }

    @Override
    public int insert(HoaDon hoaDon) {
        return this.hoaDonRepository.insert(hoaDon);
    }

    @Override
    public List<HoaDonfinalViewModels> getonewithma(String ma) {
        return this.hoaDonRepository.getOnewithMa(ma);
    }

    @Override
    public HoaDonfinalViewModels getonewithid(int id) {
        return this.hoaDonRepository.getOnewithId(id);
    }

    @Override
    public ArrayList<HoaDonViewModels> finbyngaythanhToan(String timkiem) {
        ArrayList<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.finByNgayThanhToan(timkiem);
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMa(), hd.getNgayTao(), hd.getTongTien(), hd.getTrangThai()));
        }
        return list;
    }

    @Override
    public ArrayList<HoaDonViewModels> finbyngaytrangThai(int ma) {
        ArrayList<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.finByTrangThai(ma);
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMa(), hd.getNgayTao(), hd.getTongTien(), hd.getTrangThai()));
        }
        return list;
    }

    @Override
    public ArrayList<HoaDon> finByNgayThanhToanandTrangThai(int ma, int mi) {
        return hoaDonRepository.finByNgayThanhToanandTH(ma, mi);
    }

    @Override
    public List<HoaDonViewModels> GetListHoaSon() {
        List<HoaDonViewModels> list = new ArrayList();
        var HD = hoaDonRepository.getAllHoaDon();
        for (HoaDon hd : HD) {
            list.add(new HoaDonViewModels(hd.getMa(), hd.getNgayTao(), hd.getTongTien(), hd.getTrangThai()));
        }
        return list;
    }

}
