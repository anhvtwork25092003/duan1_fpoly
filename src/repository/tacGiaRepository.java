/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainmodels.tacGia;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface tacGiaRepository {

    public List<tacGia> getAll();

    boolean add(tacGia TG);

    public boolean update(tacGia s, String id);

    public List<tacGia> timKiem(String tenTim);

    public List<tacGia> timKiemTT(int trangThai);

    tacGia getOne(String ten);

    public List<tacGia> getAllDangKD();
}
