/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.NXB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface NXBService {

    public ArrayList<NXB> getAll();

    public NXB getOne(String ten);

    public String add(NXB nxb);

    public String update(NXB s, String id);

    public List<NXB> timKiem(String tenTim);

    public List<NXB> timKiemTT(int trangThai);

    public ArrayList<NXB> getAllDangKD();

}
