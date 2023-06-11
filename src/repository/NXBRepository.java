/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodels.NXB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface NXBRepository {

    public ArrayList<NXB> getAll();

    public NXB getOne(String ten);

    public boolean add(NXB nxb);

    public boolean update(NXB s, String id);

    public List<NXB> timKiem(String tenTim);

    public List<NXB> timKiemTT(int trangThai);

    public ArrayList<NXB> getAllDangKD();
}
