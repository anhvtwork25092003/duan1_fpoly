/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodels.NguoiDung;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import service.NguoiDungService;
import serviceimpl.NguoiDungServiceImpl;
//import model.DangNhap;

/**
 *
 * @author ThisPC
 */
public class CuaSoChinh extends javax.swing.JFrame {

    NguoiDungService dungService = new NguoiDungServiceImpl();

    public CuaSoChinh(String maNguoiDung, String tenNguoiDung) {
        initComponents();
        txt_tenNguoiDung.setText(tenNguoiDung);
        txt_maNDung.setText(maNguoiDung);
        jInternalFrame1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) jInternalFrame1.getUI();
        ui.setNorthPane(null);
        setLocationRelativeTo(null);

        manChinhPage.removeAll();
        ThongKeView dangKi = new ThongKeView();
        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());
        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        manChinhPage = new javax.swing.JPanel();
        menutren = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lbMaNdung = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tenNguoiDung = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_maNDung = new javax.swing.JTextField();
        slidepage = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnLichSu = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnDoiMK = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btn_tacGIa = new javax.swing.JButton();
        btn_nhaXuatBan = new javax.swing.JButton();
        btn_banHang = new javax.swing.JButton();
        btnDangXuat4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        manChinhPage.setName(""); // NOI18N
        manChinhPage.setOpaque(false);

        javax.swing.GroupLayout manChinhPageLayout = new javax.swing.GroupLayout(manChinhPage);
        manChinhPage.setLayout(manChinhPageLayout);
        manChinhPageLayout.setHorizontalGroup(
            manChinhPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        manChinhPageLayout.setVerticalGroup(
            manChinhPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );

        menutren.setBackground(new java.awt.Color(51, 204, 255));

        btnExit.setBackground(new java.awt.Color(0, 204, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbMaNdung.setForeground(new java.awt.Color(255, 255, 255));
        lbMaNdung.setText("-");

        txt_tenNguoiDung.setEnabled(false);

        jButton1.setText("Đăng xuất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_maNDung.setEnabled(false);

        javax.swing.GroupLayout menutrenLayout = new javax.swing.GroupLayout(menutren);
        menutren.setLayout(menutrenLayout);
        menutrenLayout.setHorizontalGroup(
            menutrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menutrenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(menutrenLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lbMaNdung, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_maNDung, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txt_tenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(251, 251, 251)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(750, Short.MAX_VALUE))
        );
        menutrenLayout.setVerticalGroup(
            menutrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menutrenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menutrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNdung)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txt_maNDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        slidepage.setBackground(new java.awt.Color(51, 204, 255));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Trang Chủ");

        btnThongKe.setBackground(new java.awt.Color(54, 33, 89));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Tổng Quan");
        btnThongKe.setBorderPainted(false);
        btnThongKe.setContentAreaFilled(false);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(54, 33, 89));
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.setBorderPainted(false);
        btnSanPham.setContentAreaFilled(false);
        btnSanPham.setPreferredSize(new java.awt.Dimension(93, 27));
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(54, 33, 89));
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.setBorderPainted(false);
        btnKhachHang.setContentAreaFilled(false);
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnLichSu.setBackground(new java.awt.Color(54, 33, 89));
        btnLichSu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLichSu.setForeground(new java.awt.Color(255, 255, 255));
        btnLichSu.setText("Hóa đơn");
        btnLichSu.setBorderPainted(false);
        btnLichSu.setContentAreaFilled(false);
        btnLichSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSuActionPerformed(evt);
            }
        });

        btnKhuyenMai.setBackground(new java.awt.Color(54, 33, 89));
        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnKhuyenMai.setText("Khuyến Mãi");
        btnKhuyenMai.setBorderPainted(false);
        btnKhuyenMai.setContentAreaFilled(false);
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnDoiMK.setBackground(new java.awt.Color(54, 33, 89));
        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMK.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMK.setText("Đổi Mật Khẩu");
        btnDoiMK.setBorderPainted(false);
        btnDoiMK.setContentAreaFilled(false);
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(54, 33, 89));
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setText("Người dùng");
        btnNhanVien.setBorderPainted(false);
        btnNhanVien.setContentAreaFilled(false);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btn_tacGIa.setBackground(new java.awt.Color(54, 33, 89));
        btn_tacGIa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_tacGIa.setForeground(new java.awt.Color(255, 255, 255));
        btn_tacGIa.setText("Tác Giả");
        btn_tacGIa.setBorderPainted(false);
        btn_tacGIa.setContentAreaFilled(false);
        btn_tacGIa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tacGIaActionPerformed(evt);
            }
        });

        btn_nhaXuatBan.setBackground(new java.awt.Color(54, 33, 89));
        btn_nhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_nhaXuatBan.setForeground(new java.awt.Color(255, 255, 255));
        btn_nhaXuatBan.setText("Nhà Xuất Bản");
        btn_nhaXuatBan.setBorderPainted(false);
        btn_nhaXuatBan.setContentAreaFilled(false);
        btn_nhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhaXuatBanActionPerformed(evt);
            }
        });

        btn_banHang.setBackground(new java.awt.Color(54, 33, 89));
        btn_banHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_banHang.setForeground(new java.awt.Color(255, 255, 255));
        btn_banHang.setText("Bán Hàng");
        btn_banHang.setBorderPainted(false);
        btn_banHang.setContentAreaFilled(false);
        btn_banHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banHangActionPerformed(evt);
            }
        });

        btnDangXuat4.setBackground(new java.awt.Color(54, 33, 89));
        btnDangXuat4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat4.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat4.setText("Thể Loại");
        btnDangXuat4.setBorderPainted(false);
        btnDangXuat4.setContentAreaFilled(false);
        btnDangXuat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuat4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout slidepageLayout = new javax.swing.GroupLayout(slidepage);
        slidepage.setLayout(slidepageLayout);
        slidepageLayout.setHorizontalGroup(
            slidepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidepageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(slidepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLichSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tacGIa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_banHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(slidepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(slidepageLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnDangXuat4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        slidepageLayout.setVerticalGroup(
            slidepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidepageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tacGIa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btn_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(slidepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slidepageLayout.createSequentialGroup()
                    .addContainerGap(637, Short.MAX_VALUE)
                    .addComponent(btnDangXuat4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(177, 177, 177)))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(slidepage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menutren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(manChinhPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(menutren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manChinhPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(slidepage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        manChinhPage.removeAll();
        UISachCT uISachCT = new UISachCT();
        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(uISachCT.getContentPane());
        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        manChinhPage.removeAll();
        UIKhachHang hang = new UIKhachHang();
        manChinhPage.add(hang.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();

    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnLichSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSuActionPerformed
        // TODO add your handling code here:
        manChinhPage.removeAll();
        // TODO add your handling code here:
        UIHoaDon dangKi = new UIHoaDon();
        dangKi.setSize(1330, 750);
        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();
    }//GEN-LAST:event_btnLichSuActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        manChinhPage.removeAll();
//        KhuyenMaiViews kmf = new KhuyenMaiViews();
//        manChinhPage.add(kmf).setVisible(true);
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        manChinhPage.removeAll();
        // TODO add your handling code here:
        UIDangKi dangKi = new UIDangKi();
        dangKi.setSize(1330, 700);
        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        manChinhPage.removeAll();
        UINguoiDung uISachCT = new UINguoiDung();
        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(uISachCT.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();

    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btn_tacGIaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tacGIaActionPerformed
        // TODO add your handling code here:
        manChinhPage.removeAll();
        form_TacGia dangKi = new form_TacGia();
        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();
    }//GEN-LAST:event_btn_tacGIaActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        manChinhPage.removeAll();
        ThongKeView dangKi = new ThongKeView();

        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "ban muon dang xuat chu?");
        if (choice == ConfirmationCallback.YES) {
            this.dispose();
            UIDangNhap dangNhap = new UIDangNhap();
            dangNhap.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btn_nhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhaXuatBanActionPerformed
        // TODO add your handling code here:
        manChinhPage.removeAll();
        // TODO add your handling code here:
        UINXB dangKi = new UINXB();

        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();

    }//GEN-LAST:event_btn_nhaXuatBanActionPerformed

    private void btn_banHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banHangActionPerformed
        // TODO add your handling code here:
        String maNdung = txt_maNDung.getText();
        NguoiDung ng = this.dungService.getOne(maNdung);
        String tenNdung = txt_tenNguoiDung.getText();
        UIBanHang csh = new UIBanHang(maNdung, tenNdung);
        csh.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        csh.setVisible(true);

    }//GEN-LAST:event_btn_banHangActionPerformed

    private void btnDangXuat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuat4ActionPerformed
        // TODO add your handling code here:
        manChinhPage.removeAll();
        // TODO add your handling code here:
        UIQLtheloai dangKi = new UIQLtheloai();

        // Thêm UIDangKi vào ContentPane của manChinhPage
        manChinhPage.add(dangKi.getContentPane());

        // Cập nhật và vẽ lại manChinhPage
        manChinhPage.revalidate();
        manChinhPage.repaint();
    }//GEN-LAST:event_btnDangXuat4ActionPerformed

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
            java.util.logging.Logger.getLogger(UIBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        String maNguoiDung = "Mã người dùng"; // Thay thế bằng mã người dùng thực tế
        String tenNguoiDung = "Tên người dùng"; // Thay thế bằng tên người dùng thực tế

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuaSoChinh(maNguoiDung, tenNguoiDung).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat4;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnLichSu;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btn_banHang;
    private javax.swing.JButton btn_nhaXuatBan;
    private javax.swing.JButton btn_tacGIa;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbMaNdung;
    private javax.swing.JPanel manChinhPage;
    private javax.swing.JPanel menutren;
    private javax.swing.JPanel slidepage;
    private javax.swing.JTextField txt_maNDung;
    private javax.swing.JTextField txt_tenNguoiDung;
    // End of variables declaration//GEN-END:variables
}
