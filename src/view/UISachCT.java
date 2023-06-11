/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodels.NXB;
import domainmodels.Sach;
import domainmodels.TheLoai;
import domainmodels.tacGia;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.NXBService;
import service.SachService;
import service.svtheloai;
import service.tacGiaSevice;
import serviceimpl.NXBServiceImlp;
import serviceimpl.SachServiceimpl;
import serviceimpl.svtheloaiimpl;
import serviceimpl.tacGiaServiceImpl;
import viewmodels.SachTacGiaViewmodels;
import viewmodels.SachTheLoaiViewModels;
import viewmodels.SachViewModels;

/**
 *
 * @author User
 */
public class UISachCT extends javax.swing.JFrame {

    /**
     * Creates new form UISachCT
     */
    private String duongdananh;
    private SachService sachService = new SachServiceimpl();
    private tacGiaSevice giaSevice = new tacGiaServiceImpl();
    private svtheloai theLoaiService = new svtheloaiimpl();
    private NXBService nXBService = new NXBServiceImlp();

    public UISachCT() {
        super("UISachCT");
        initComponents();
        loadTableAll(this.sachService.getAll());
        buttonGroup();
        addCbbNXB(this.nXBService.getAllDangKD());
    }

    private void resetAll() {
        txt_giaNhap.setText("");
        txt_giaBan.setText("");
        txt_id.setText("");
        txt_maSach.setText("");
        txt_maVach.setText("");
        txt_mota.setText("");
        txt_tenSach1.setText("");
        txt_choice2.setText("");
        cbb_trangThai.setSelectedIndex(0);

    }

    private void buttonGroup() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(rd_all);
        bg.add(rd_dangHoatDong);
        bg.add(rd_ngungHoatDong);
        rd_all.setSelected(true);
    }
// ham trả vè trang thai

    private String getTrangThai(int TrangThai) {
        if (TrangThai == 0) {
            return "Dang Kinh Doanh";
        } else {
            return "Ngung Kinh Doanh";
        }
    }
// load cbb nxb

    private void addCbbNXB(List<NXB> list) {
        DefaultComboBoxModel cbbnxb = (DefaultComboBoxModel) cbb_nxb.getModel();
        for (NXB nxb : list) {
            cbbnxb.addElement(nxb.getTen());
        }

    }

    public static boolean isValidCurrency(String input) {
        String pattern = "^\\d+(\\.\\d{1,2})?$"; // Kiểm tra định dạng số thập phân có hai chữ số sau dấu phẩy
        return input.matches(pattern);
    }

    private Sach getData() {
        String tenSach = txt_tenSach1.getText().trim();
        if (tenSach.equals("")) {
            JOptionPane.showMessageDialog(this, "Ban phai nhap ten Sach!");
            return null;
        }
        String giaNhapstr = txt_giaNhap.getText().trim();
        double giaNhap = 0;
        if (giaNhapstr.equals("") == false && isValidCurrency(giaNhapstr) == false) {
            JOptionPane.showMessageDialog(this, "Nhập tiền cũng sai!");
            return null;
        } else if (giaNhapstr.equals("")) {
            giaNhap = 0;
        } else {
            giaNhap = Double.parseDouble(giaNhapstr);
        }
        String giaBanstr = txt_giaBan.getText().trim();
        double giaBan = 0;
        if (giaBanstr.equals("") || giaBanstr.isBlank()) {
            JOptionPane.showMessageDialog(this, "Hay nhap gia ban!");
            return null;
        } else if (isValidCurrency(giaBanstr) == false) {
            JOptionPane.showMessageDialog(this, "Nhập tiền cũng sai!");
            return null;
        } else {
            giaBan = Double.parseDouble(giaBanstr);
        }

        String idNxb = this.nXBService.getOne(cbb_nxb.getSelectedItem().toString()).getId();
        int trangThai = 0;
        if (cbb_trangThai.getSelectedItem().equals("Dang Kinh Doanh")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }
        String imageLink = duongdananh;
        String maVach = txt_maVach.getText().trim();
        String mota = txt_mota.getText().trim();

        Sach sach = new Sach(tenSach, idNxb, mota, giaNhap, giaBan, trangThai, imageLink, maVach);

        return sach;
    }

    private void loadTableAll(List<SachViewModels> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tb_sach.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            defaultTableModel.addRow(new Object[]{
                i + 1,
                list.get(i).getId(),
                list.get(i).getMa(),
                list.get(i).getTenSach(),
                list.get(i).getTenTheLoai(),
                list.get(i).getTenTacGia(),
                list.get(i).getTenNXB(),
                list.get(i).getMoTa(),
                list.get(i).getGiaNhap(),
                list.get(i).getGiaBan(),
                getTrangThai(list.get(i).getTrangthai()),
                list.get(i).getImageLink(),
                list.get(i).getMaVach(),});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_maSach = new javax.swing.JTextField();
        txt_maVach = new javax.swing.JTextField();
        cbb_trangThai = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btn_addSach = new javax.swing.JButton();
        btn_updateSach = new javax.swing.JButton();
        cbb_nxb = new javax.swing.JComboBox<>();
        txt_nxb = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_tenSach1 = new javax.swing.JTextField();
        txt_giaNhap = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        lbl_image = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbb_theLoai1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_themTheLoai1 = new javax.swing.JButton();
        btn_goTheLoai1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ListTheLoai = new javax.swing.JTable();
        txt_choice1 = new javax.swing.JTextField();
        btn_addTheLoai = new javax.swing.JButton();
        btn_updateTheLoai = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbb_tacGia2 = new javax.swing.JComboBox<>();
        btn_themTacGia1 = new javax.swing.JButton();
        btn_goTacGia1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_listTacgia = new javax.swing.JTable();
        txt_choice2 = new javax.swing.JTextField();
        btn_addTacGia = new javax.swing.JButton();
        btn_updateTacgia = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sach = new javax.swing.JTable();
        txt_searchText = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        rd_ngungHoatDong = new javax.swing.JRadioButton();
        rd_dangHoatDong = new javax.swing.JRadioButton();
        rd_all = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Quan ly Sach");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel2.setText("ID");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("Ma Sach");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setText("Ten Sach");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txt_id.setEnabled(false);
        jPanel3.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 220, -1));

        txt_maSach.setEnabled(false);
        jPanel3.add(txt_maSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 220, -1));
        jPanel3.add(txt_maVach, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 220, -1));

        cbb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dang Kinh Doanh", "Ngung Kinh Doanh" }));
        cbb_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_trangThaiActionPerformed(evt);
            }
        });
        jPanel3.add(cbb_trangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 220, -1));

        jButton5.setText("previous");
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 680, -1, -1));

        jButton6.setText("next");
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 680, -1, -1));

        btn_addSach.setText("Thêm");
        btn_addSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addSachActionPerformed(evt);
            }
        });
        jPanel3.add(btn_addSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        btn_updateSach.setText("Cập Nhật");
        btn_updateSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateSachActionPerformed(evt);
            }
        });
        jPanel3.add(btn_updateSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jPanel3.add(cbb_nxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 220, 30));

        txt_nxb.setText("Nhà xuất bản");
        jPanel3.add(txt_nxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, 20));

        jLabel12.setText("Giá Nhập");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel14.setText("Giá bán");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel15.setText("Trạng Thái");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jLabel16.setText("Mã Vạch");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));
        jPanel3.add(txt_tenSach1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 220, -1));
        jPanel3.add(txt_giaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 220, -1));
        jPanel3.add(txt_giaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 220, -1));

        lbl_image.setText("IMAGE");
        jPanel3.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 170, 205));

        jButton3.setText("Chon anh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 94, -1));

        jLabel5.setText("Mô tả");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 50, -1));

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane1.setViewportView(txt_mota);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        jButton1.setText("Xuất file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        jTabbedPane1.addTab("Sach", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("The Loai");

        btn_themTheLoai1.setText("+");
        btn_themTheLoai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themTheLoai1ActionPerformed(evt);
            }
        });

        btn_goTheLoai1.setText("-");
        btn_goTheLoai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goTheLoai1ActionPerformed(evt);
            }
        });

        tb_ListTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "Tên"
            }
        ));
        tb_ListTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ListTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_ListTheLoai);

        txt_choice1.setEnabled(false);

        btn_addTheLoai.setText("Thêm");
        btn_addTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTheLoaiActionPerformed(evt);
            }
        });

        btn_updateTheLoai.setText("Cập nhật");
        btn_updateTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateTheLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addGap(70, 70, 70)
                        .addComponent(cbb_theLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_themTheLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_goTheLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btn_addTheLoai)
                        .addGap(76, 76, 76)
                        .addComponent(btn_updateTheLoai)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(725, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbb_theLoai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(btn_themTheLoai1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_goTheLoai1)
                        .addComponent(txt_choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_updateTheLoai)
                            .addComponent(btn_addTheLoai))
                        .addGap(89, 89, 89))))
        );

        jTabbedPane1.addTab("Thể Loại", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Tac gia");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 50, -1));

        cbb_tacGia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_tacGia2ActionPerformed(evt);
            }
        });
        jPanel2.add(cbb_tacGia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 220, -1));

        btn_themTacGia1.setText("+");
        btn_themTacGia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themTacGia1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_themTacGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 40, -1));

        btn_goTacGia1.setText("-");
        btn_goTacGia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goTacGia1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_goTacGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 40, -1));

        tb_listTacgia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "Tên"
            }
        ));
        tb_listTacgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_listTacgiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_listTacgia);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 120, 190));

        txt_choice2.setEnabled(false);
        jPanel2.add(txt_choice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 120, -1));

        btn_addTacGia.setText("Thêm");
        btn_addTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTacGiaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 226, -1, -1));

        btn_updateTacgia.setText("Cập Nhật");
        btn_updateTacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateTacgiaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_updateTacgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 226, -1, -1));

        jTabbedPane1.addTab("Tác GIả", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 370));

        tb_sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Mã Sách", "Tên Sách", "Thể Loại", "Tác Giả", "Nhà Xuất Bản", "Mô tả", "Giá Nhập", "Giá Bán", "Trạng Thái", "Ảnh", "Mã Vạch"
            }
        ));
        tb_sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sachMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_sach);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 1350, 330));
        getContentPane().add(txt_searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 220, -1));

        btn_search.setText("Tìm kiếm theo tên");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 140, -1));

        rd_ngungHoatDong.setText("Đã ngừng kinh doanh");
        rd_ngungHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_ngungHoatDongMouseClicked(evt);
            }
        });
        rd_ngungHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ngungHoatDongActionPerformed(evt);
            }
        });
        getContentPane().add(rd_ngungHoatDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        rd_dangHoatDong.setText("Đang Kinh Doanh");
        rd_dangHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_dangHoatDongMouseClicked(evt);
            }
        });
        rd_dangHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_dangHoatDongActionPerformed(evt);
            }
        });
        getContentPane().add(rd_dangHoatDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        rd_all.setText("Tất cả");
        rd_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_allMouseClicked(evt);
            }
        });
        rd_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_allActionPerformed(evt);
            }
        });
        getContentPane().add(rd_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        String search = txt_searchText.getText();

        loadTableAll(this.sachService.search(search));

    }//GEN-LAST:event_btn_searchActionPerformed

    private void rd_ngungHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_ngungHoatDongMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_rd_ngungHoatDongMouseClicked

    private void rd_dangHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_dangHoatDongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_dangHoatDongMouseClicked

    private void rd_dangHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_dangHoatDongActionPerformed
        // TODO add your handling code here:
        int trangThaii = 0;
        loadTableAll(this.sachService.getAllWithTrangThai(trangThaii));


    }//GEN-LAST:event_rd_dangHoatDongActionPerformed

    private void rd_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_allMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_rd_allMouseClicked

    private void cbb_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_trangThaiActionPerformed
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImgae = new ImageIcon(ImagePath);
        Image img = myImgae.getImage();
        Image newImg = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser f = new JFileChooser("D:\\Documents\\AnhSach");
        f.setDialogTitle("Chon file");
        f.showOpenDialog(null);
        File ftenanh = f.getSelectedFile();
        duongdananh = ftenanh.getAbsolutePath();
        System.out.println(duongdananh);
        if (duongdananh != null) {
            lbl_image.setIcon(ResizeImage(String.valueOf(duongdananh)));
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void loadTBListTacgia(List<tacGia> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tb_listTacgia.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            defaultTableModel.addRow(new Object[]{
                list.get(i).getTen(),});
        }
    }

    private void loadTBListTheLoai(List<TheLoai> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tb_ListTheLoai.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            defaultTableModel.addRow(new Object[]{
                list.get(i).getTen(),});
        }
    }


    private void tb_sachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sachMouseClicked
        // TODO add your handling code here:
        DefaultComboBoxModel cbbTacGia = (DefaultComboBoxModel) cbb_tacGia2.getModel();
        cbbTacGia.removeAllElements();
        DefaultComboBoxModel cbbTheLoai = (DefaultComboBoxModel) cbb_theLoai1.getModel();
        cbbTheLoai.removeAllElements();
        int row = tb_sach.getSelectedRow();

        try {
            lbl_image.setIcon(ResizeImage(String.valueOf(tb_sach.getValueAt(row, 11))));
            txt_id.setText(tb_sach.getValueAt(row, 1).toString());
            txt_maSach.setText(tb_sach.getValueAt(row, 2).toString());
            txt_tenSach1.setText(tb_sach.getValueAt(row, 3).toString());
            txt_giaNhap.setText(tb_sach.getValueAt(row, 8).toString());
            txt_giaBan.setText(tb_sach.getValueAt(row, 9).toString());
            cbb_trangThai.setSelectedItem(tb_sach.getValueAt(row, 10).toString());
            cbb_nxb.setSelectedItem(tb_sach.getValueAt(row, 6).toString());
            txt_mota.setText(tb_sach.getValueAt(row, 7).toString());
            txt_maVach.setText(tb_sach.getValueAt(row, 12).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // tac gia

        try {
            String tacGia = tb_sach.getValueAt(row, 5).toString();
            String tacGiaArr[] = tacGia.split(", ");

            cbbTacGia.removeAllElements();
            for (String tg : tacGiaArr) {
                cbbTacGia.addElement(tg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // the loai
        String theLoai = tb_sach.getValueAt(row, 4).toString();
        String theLoaiArr[] = theLoai.split(", ");

        cbbTheLoai.removeAllElements();
        for (String tg : theLoaiArr) {
            System.out.println(tg);
            cbbTheLoai.addElement(tg);
        }


    }//GEN-LAST:event_tb_sachMouseClicked

    private void btn_themTheLoai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themTheLoai1ActionPerformed
        // TODO add your handling code here:
        txt_choice1.setText("Thể Loại");
        loadTBListTheLoai(this.theLoaiService.getAllDangKD());
    }//GEN-LAST:event_btn_themTheLoai1ActionPerformed

    private void btn_goTheLoai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goTheLoai1ActionPerformed
        // TODO add your handling code here:
        int selectedIndex = cbb_theLoai1.getSelectedIndex();
        if (selectedIndex != -1) { // Kiểm tra mục được chọn có tồn tại không
            cbb_theLoai1.removeItemAt(selectedIndex);
        }
    }//GEN-LAST:event_btn_goTheLoai1ActionPerformed

    private void tb_ListTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ListTheLoaiMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:;
        DefaultComboBoxModel comboBoxModelTheLoai = (DefaultComboBoxModel) cbb_theLoai1.getModel();
        int row = tb_ListTheLoai.getSelectedRow();
        if (txt_choice1.getText().equalsIgnoreCase("Thể Loại")) {
            int itemCount = cbb_theLoai1.getItemCount();
            boolean found = false;
            for (int i = 0; i < itemCount; i++) {
                String item = (String) cbb_theLoai1.getItemAt(i);
                if (item.equals(tb_ListTheLoai.getValueAt(row, 0).toString())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(this, "Đã thêm thể loại này rồi!");
                return;
            } else {
                comboBoxModelTheLoai.addElement(tb_ListTheLoai.getValueAt(row, 0).toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn thể loại hoặc tác giả!");
            return;
        }
    }//GEN-LAST:event_tb_ListTheLoaiMouseClicked

    private void cbb_tacGia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_tacGia2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_tacGia2ActionPerformed

    private void btn_themTacGia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themTacGia1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // load tên tác giả lên bảng phụ
        txt_choice2.setText("Tác Giả");
        loadTBListTacgia(this.giaSevice.getAllDangKD());
    }//GEN-LAST:event_btn_themTacGia1ActionPerformed

    private void btn_goTacGia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goTacGia1ActionPerformed
        // TODO add your handling code here:
        // gỡ 1 tác giả ra khỏi cbb nếu chọn nhầm
        int selectedIndex = cbb_tacGia2.getSelectedIndex();
        if (selectedIndex != -1) { // Kiểm tra mục được chọn có tồn tại không
            cbb_tacGia2.removeItemAt(selectedIndex);
        }
    }//GEN-LAST:event_btn_goTacGia1ActionPerformed

    private void tb_listTacgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listTacgiaMouseClicked
        // TODO add your handling code here:
        DefaultComboBoxModel comboBoxModelTacGia = (DefaultComboBoxModel) cbb_tacGia2.getModel();
        int row = tb_listTacgia.getSelectedRow();
        if (txt_choice2.getText().equalsIgnoreCase("Tác Giả")) {
            int itemCount = cbb_tacGia2.getItemCount();
            boolean found = false;
            for (int i = 0; i < itemCount; i++) {
                String item = (String) cbb_tacGia2.getItemAt(i);
                if (item.equals(tb_listTacgia.getValueAt(row, 0).toString())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(this, "Đã thêm tác giả này rồi!");
                return;
            } else {
                comboBoxModelTacGia.addElement(tb_listTacgia.getValueAt(row, 0).toString());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn thể loại hoặc tác giả!");
            return;
        }
    }//GEN-LAST:event_tb_listTacgiaMouseClicked

    private void btn_addTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTheLoaiActionPerformed
        String idSachh = tb_sach.getValueAt(tb_sach.getSelectedRow(), 1).toString();
        this.sachService.deleteSachTheLoai(idSachh);

        int row = tb_sach.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Hay chon 1 cuon sach!");
            return;
        }
        String idSach = tb_sach.getValueAt(row, 1).toString();
        List<String> listTenTheLoai = new ArrayList<String>();
        for (int i = 0; i < cbb_theLoai1.getItemCount(); i++) {
            String item = (String) cbb_theLoai1.getItemAt(i);
            listTenTheLoai.add(item);
        }
        int count = 0;
        for (String string : listTenTheLoai) {
            String idTheLoai = this.theLoaiService.getOne(string).getId();
            SachTheLoaiViewModels sachTheLoaiViewModels = new SachTheLoaiViewModels(idSach, idTheLoai);
            this.sachService.insertTheLoai(sachTheLoaiViewModels);
            count++;
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Thanh Cong!");
            loadTableAll(this.sachService.getAll());
        }
        System.out.println(listTenTheLoai);


    }//GEN-LAST:event_btn_addTheLoaiActionPerformed

    private void btn_addSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addSachActionPerformed
        // TODO add your handling code here:
        Sach sach = this.getData();
        System.out.println(sach);
        if (sach == null) {
            return;
        }
        JOptionPane.showMessageDialog(this, this.sachService.insert(sach));
        loadTableAll(this.sachService.getAll());
        resetAll();


    }//GEN-LAST:event_btn_addSachActionPerformed

    private void btn_updateTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateTheLoaiActionPerformed
        // TODO add your handling code here:
        String idSach = tb_sach.getValueAt(tb_sach.getSelectedRow(), 1).toString();
        this.sachService.deleteSachTheLoai(idSach);
        int row = tb_sach.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Hay chon 1 cuon sach!");
            return;
        }
        List<String> listTenTheLoai = new ArrayList<String>();
        for (int i = 0; i < cbb_theLoai1.getItemCount(); i++) {
            String item = (String) cbb_theLoai1.getItemAt(i);
            listTenTheLoai.add(item);
        }
        int count = 0;
        for (String string : listTenTheLoai) {
            String idTheLoai = this.theLoaiService.getOne(string).getId();
            SachTheLoaiViewModels sachTheLoaiViewModels = new SachTheLoaiViewModels(idSach, idTheLoai);
            this.sachService.insertTheLoai(sachTheLoaiViewModels);
            count++;
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Thanh Cong!");
            loadTableAll(this.sachService.getAll());
        }
        System.out.println(listTenTheLoai);


    }//GEN-LAST:event_btn_updateTheLoaiActionPerformed

    private void btn_updateSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateSachActionPerformed
        // TODO add your handling code here:
        Sach sach = this.getData();
        String ma = tb_sach.getValueAt(tb_sach.getSelectedRow(), 2).toString();
        System.out.println(ma);
        System.out.println(sach);
        if (sach == null) {
            return;
        }
        JOptionPane.showMessageDialog(this, this.sachService.update(sach, ma));
        loadTableAll(this.sachService.getAll());
        System.out.println("cap nhat");
    }//GEN-LAST:event_btn_updateSachActionPerformed

    private void btn_addTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTacGiaActionPerformed
        // TODO add your handling code here:

        int row = tb_sach.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Hay chon 1 cuon sach!");
            return;
        }
        String idSachh = tb_sach.getValueAt(row, 1).toString();
        this.sachService.deleteSachTacGia(idSachh);

        String idSach = tb_sach.getValueAt(row, 1).toString();
        List<String> listTenTacGia = new ArrayList<String>();
        for (int i = 0; i < cbb_tacGia2.getItemCount(); i++) {
            String item = (String) cbb_tacGia2.getItemAt(i);
            listTenTacGia.add(item);
        }
        int count = 0;
        for (String string : listTenTacGia) {
            int idTacgia = this.giaSevice.getOne(string).getId();
            SachTacGiaViewmodels sachTg = new SachTacGiaViewmodels(Integer.valueOf(idSach), idTacgia);
            System.out.println(sachTg);
            if (this.sachService.insertSachTacGia(sachTg)) {
                count++;
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Thanh Cong!");
            loadTableAll(this.sachService.getAll());
        }

    }//GEN-LAST:event_btn_addTacGiaActionPerformed

    private void btn_updateTacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateTacgiaActionPerformed
        // TODO add your handling code here:
        int row = tb_sach.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Hay chon 1 cuon sach!");
            return;
        }
        String idSach = tb_sach.getValueAt(row, 1).toString();
        this.sachService.deleteSachTacGia(idSach);
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Hay chon 1 cuon sach!");
            return;
        }
        List<String> listTenTacGia = new ArrayList<String>();
        for (int i = 0; i < cbb_tacGia2.getItemCount(); i++) {
            String item = (String) cbb_tacGia2.getItemAt(i);
            listTenTacGia.add(item);
        }
        int count = 0;
        for (String string : listTenTacGia) {
            int idTacgia = this.giaSevice.getOne(string).getId();
            SachTacGiaViewmodels sachTg = new SachTacGiaViewmodels(Integer.valueOf(idSach), idTacgia);
            System.out.println(sachTg);
            if (this.sachService.insertSachTacGia(sachTg)) {
                count++;
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(this, "Thanh Cong!");
            loadTableAll(this.sachService.getAll());
        }
    }//GEN-LAST:event_btn_updateTacgiaActionPerformed

    private void rd_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_allActionPerformed
        // TODO add your handling code here:
        loadTableAll(this.sachService.getAll());
    }//GEN-LAST:event_rd_allActionPerformed

    private void rd_ngungHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ngungHoatDongActionPerformed
        // TODO add your handling code here:
        int trangThaii = 1;
        loadTableAll(this.sachService.getAllWithTrangThai(trangThaii));
    }//GEN-LAST:event_rd_ngungHoatDongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            XSSFWorkbook worbook = new XSSFWorkbook();
            XSSFSheet sheet = worbook.createSheet("Hoa Don");

            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("ID");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã Sách");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên Sách");
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Thê Loai");
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Tac Gia");
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Nha Xuat Ban");
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Mô Ta");
            
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Gia Nhâp");
            
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Gia Ban");
            
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Trang Thai");
            
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Anh");
            
            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("Ma Vach");
            List<SachViewModels> list = sachService.getAll();

            if (list != null) {
                int s = list.size();
                for (int i = 0; i < s; i++) {
                    SachViewModels hd = list.get(i);
                    row = sheet.createRow(4 + i);

                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(i + 1);
                    cell = row.createCell(01, CellType.STRING);
                    cell.setCellValue(hd.getId());
                    
                    cell = row.createCell(02, CellType.STRING);
                    cell.setCellValue(hd.getMa());
                    
                    cell = row.createCell(03, CellType.STRING);
                    cell.setCellValue(hd.getTenSach());
                    
                    cell = row.createCell(04, CellType.STRING);
                    cell.setCellValue(hd.getTenTheLoai());

                    cell = row.createCell(05, CellType.STRING);
                    cell.setCellValue(hd.getTenTacGia());

                    cell = row.createCell(06, CellType.STRING);
                    cell.setCellValue(hd.getTenNXB());

                    cell = row.createCell(07, CellType.STRING);
                    cell.setCellValue(hd.getMoTa());
                    
                    
                    
                    cell = row.createCell(10, CellType.STRING);
                    cell.setCellValue(hd.getTrangthai());
                    
                    cell = row.createCell(11, CellType.STRING);
                    cell.setCellValue(hd.getImageLink());
                    
                    cell = row.createCell(12, CellType.STRING);
                    cell.setCellValue(hd.getMaVach());
           
                }
                File f = new File("E:\\FileThongKeSach.xlsx");
                try {
                    FileOutputStream fis = new FileOutputStream(f);

                    worbook.write(fis);
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        JOptionPane.showMessageDialog(this, "Xuất Thành Công");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UISachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UISachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UISachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UISachCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UISachCT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addSach;
    private javax.swing.JButton btn_addTacGia;
    private javax.swing.JButton btn_addTheLoai;
    private javax.swing.JButton btn_goTacGia1;
    private javax.swing.JButton btn_goTheLoai1;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_themTacGia1;
    private javax.swing.JButton btn_themTheLoai1;
    private javax.swing.JButton btn_updateSach;
    private javax.swing.JButton btn_updateTacgia;
    private javax.swing.JButton btn_updateTheLoai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_nxb;
    private javax.swing.JComboBox<String> cbb_tacGia2;
    private javax.swing.JComboBox<String> cbb_theLoai1;
    private javax.swing.JComboBox<String> cbb_trangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JRadioButton rd_all;
    private javax.swing.JRadioButton rd_dangHoatDong;
    private javax.swing.JRadioButton rd_ngungHoatDong;
    private javax.swing.JTable tb_ListTheLoai;
    private javax.swing.JTable tb_listTacgia;
    private javax.swing.JTable tb_sach;
    private javax.swing.JTextField txt_choice1;
    private javax.swing.JTextField txt_choice2;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JTextField txt_maVach;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JLabel txt_nxb;
    private javax.swing.JTextField txt_searchText;
    private javax.swing.JTextField txt_tenSach1;
    // End of variables declaration//GEN-END:variables
}
