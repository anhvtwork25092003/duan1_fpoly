/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;


import domainmodels.ThongKe;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositoryimpl.ThongKeRepository;
import service.ThongKeService;

/**
 *
 * @author kunrl
 */
public class ThongKeServiceImp implements ThongKeService {

    ThongKeRepository thongkerepo = new ThongKeRepository();

    
    //-----------------------------
    
    @Override
    public ArrayList<ThongKe>finByBieuDo() {
        return thongkerepo.finByBieuDo();
    }
    @Override
    public ArrayList<ThongKe> finByNgayThanhToanNam(int ma) {
        try {
            return thongkerepo.finByNgayThanhToanNam(ma);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finbyngaythanhToanThang(int ma) {
        try {
            return thongkerepo.finByNgayThanhToanThang(ma);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finbyngaythanhToanNgay(int ma) {
        try {
            return thongkerepo.finByNgayThanhToanNgay(ma);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finByNgayThanhToanandNgay(int ma, int mi) {
        try {
            return thongkerepo.finByNgayThanhToanandNgay(ma, mi);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finByNgayThanhToannamandTT(int ma, int mi) {
        try {
            return thongkerepo.finByNgayThanhToanNamanhTT(ma, mi);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finByNgayThanhToaThangnandTT(int ma, int mi) {
        try {
            return thongkerepo.finByNgayThanhToanThanganhTT(ma, mi);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finTongtienByNgayThanhToanNam(int ma) {
        try {
            return thongkerepo.finByTongtienNgayThanhToanNam(ma);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finbyTongtienngaythanhToanThang(int ma) {
        try {
            return thongkerepo.finByTongtienNgayThanhToanThang(ma);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public ArrayList<ThongKe> finbyTongtienngaythanhToanNgay(int ma) {
        try {
            return thongkerepo.finByTongtienNgayThanhToanNgay(ma);
        } catch (Exception ex) {
            Logger.getLogger(ThongKeServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
