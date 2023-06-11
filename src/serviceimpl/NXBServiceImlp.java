/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimpl;

import domainmodels.NXB;
import java.util.ArrayList;
import java.util.List;
import repository.NXBRepository;
import repositoryimpl.NXBrepositoryImpl;
import service.NXBService;

/**
 *
 * @author Huyên
 */
public class NXBServiceImlp implements NXBService {

    NXBRepository nxbRepo = new NXBrepositoryImpl();

    @Override
    public ArrayList<NXB> getAll() {
        return nxbRepo.getAll();
    }

    public String add(NXB nxb) {
        if (nxbRepo.add(nxb)) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String update(NXB s, String id) {
        boolean test = nxbRepo.update(s, id);
        if (test) {
            return "Thành công!";
        } else {
            return "Thât bai!";
        }
    }

    public List<NXB> timKiem(String tenTim) {
        return nxbRepo.timKiem(tenTim);
    }

    public List<NXB> timKiemTT(int trangThai) {
        return nxbRepo.timKiemTT(trangThai);
    }

    @Override
    public NXB getOne(String ten) {
        return this.nxbRepo.getOne(ten);
    }

    public ArrayList<NXB> getAllDangKD() {
        return nxbRepo.getAllDangKD();
    }
}
