/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryimpl;

import domainmodels.NXB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.NXBRepository;

/**
 *
 * @author Huyên
 */
public class NXBrepositoryImpl implements NXBRepository {

    public ArrayList<NXB> getAll() {
        ArrayList<NXB> listNXB = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = " select * from NXB ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                NXB nxb = new NXB();
                nxb.setId(rs.getString(1));
                nxb.setMa(rs.getString(2));
                nxb.setTen(rs.getString(3));
                nxb.setTrangthai(rs.getInt(4));

                listNXB.add(nxb);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNXB;
    }

    public boolean add(NXB nxb) {
        int check = 0;
        String query = "insert into NXB(ten, TrangThai) values(?, ?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, nxb.getTen());
            ps.setInt(2, nxb.getTrangthai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public boolean update(NXB s, String id) {
        try {
            Connection con = DBContext.getConnection();
            String query = "UPDATE NXB Set Ten = ?, TrangThai = ? WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getTrangthai());
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return true;
    }

    public List<NXB> timKiem(String tenTim) {
        List<NXB> listNXB = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "Select * from NXB where ten like ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + tenTim + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                NXB nxb = new NXB();
                nxb.setId(rs.getString(1));
                nxb.setMa(rs.getString(2));
                nxb.setTen(rs.getString(3));
                nxb.setTrangthai(rs.getInt(4));
                listNXB.add(nxb);
            }

        } catch (Exception e) {
        }
        return listNXB;
    }

    public List<NXB> timKiemTT(int trangThai) {
        List<NXB> listNXB = new ArrayList<>();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "Select * from NXB where TrangThai = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                NXB nxb = new NXB();
                nxb.setId(rs.getString(1));
                nxb.setMa(rs.getString(2));
                nxb.setTen(rs.getString(3));
                nxb.setTrangthai(rs.getInt(4));
                listNXB.add(nxb);
            }

        } catch (Exception e) {
        }
        return listNXB;
    }

    @Override
    public NXB getOne(String ten) {
        NXB nxb = new NXB();
        try ( Connection connect = DBContext.getConnection()) {
            String sql = "SELECT * FROM NXB WHERE TEN LIKE ? COLLATE Vietnamese_CI_AI";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                nxb.setId(rs.getString("ID"));
                nxb.setMa(rs.getString("MA"));
                nxb.setTen(rs.getString("Ten"));
                nxb.setTrangthai(rs.getInt("TrangThai"));

            }

        } catch (Exception e) {
        }
        return nxb;
    }

    public ArrayList<NXB> getAllDangKD() {
        ArrayList<NXB> listNXB = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String query = " select * from NXB WHERE TrangThai = 0 ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                NXB nxb = new NXB();
                nxb.setId(rs.getString(1));
                nxb.setMa(rs.getString(2));
                nxb.setTen(rs.getString(3));
                nxb.setTrangthai(rs.getInt(4));

                listNXB.add(nxb);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNXB;
    }

    public static void main(String[] args) {
        System.out.println(new NXBrepositoryImpl().getAllDangKD());
    }
}
