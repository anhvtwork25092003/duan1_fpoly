/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodels.NguoiDung;
import java.util.List;

/**
 *
 * @author User
 */
public interface NguoiDungRepository {

    List<NguoiDung> getAll();

    List<NguoiDung> search(String ten);

    List<NguoiDung> getAllWithTrangThai(int trangThai);

    NguoiDung getOne(String ma);

    Boolean insert(NguoiDung nguoiDung);

    Boolean update(NguoiDung nguoiDung, String ma);

    Boolean validate(String username, String password);

    Boolean rePassword(String username, String oldPass, String newPass);

}
