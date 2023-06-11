/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.tacGia;
import java.util.List;

/**
 *
 * @author Huyên
 */
public interface tacGiaSevice {

    List<tacGia> getAll();

    String add(tacGia TG);

    String update(tacGia tg, String id);

    List<tacGia> timKiem(String tenTim);

    public List<tacGia> timKiemTT(int trangThai);

    tacGia getOne(String ten);

    public List<tacGia> getAllDangKD();
}
