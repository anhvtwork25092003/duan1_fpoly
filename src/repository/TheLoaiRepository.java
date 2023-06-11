/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodels.TheLoai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface TheLoaiRepository {

    public ArrayList<TheLoai> getAll();

    public boolean insert(TheLoai tl);

    public boolean update(TheLoai s, String id);

    public TheLoai getOne(String ten);

    public List<TheLoai> timKiemTT(int trangThai);

    public ArrayList<TheLoai> getAllDangKD();
}
