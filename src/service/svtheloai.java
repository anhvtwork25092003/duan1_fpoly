/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodels.TheLoai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public interface svtheloai {

    ArrayList<TheLoai> getall();

    String insert(TheLoai tl);

    String update(TheLoai tl, String id);

    List<TheLoai> timKiem(String tenTim);

    public List<TheLoai> timKiemTT(int trangThai);

    TheLoai getOne(String ten);

    public ArrayList<TheLoai> getAllDangKD();
}
