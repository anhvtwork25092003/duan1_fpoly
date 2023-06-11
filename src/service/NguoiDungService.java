/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodels.NguoiDung;
import java.util.List;

/**
 *
 * @author User
 */
public interface NguoiDungService {

    List<NguoiDung> getAll();

    List<NguoiDung> getAllWithTrangThai(int trangThai);

    List<NguoiDung> search(String ten);

    NguoiDung getOne(String ma);

    String insert(NguoiDung nguoiDung);

    String update(NguoiDung nguoiDung, String ma);

    Boolean validate(String username, String password);

    Boolean rePassword(String username, String oldPass, String newPass);
}
