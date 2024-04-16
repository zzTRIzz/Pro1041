package gui.admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Service.KhuyenMaiService;
import Service.TaiKhoanService;
import Service.VoucherService;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import raven.toast.Notifications;
import gui.nhanvien.Main_NhanVien;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.prefs.Preferences;
import javax.swing.SwingUtilities;
import model.ThongTinNhanVien;

/**
 *
 * @author ADMIN
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    TaiKhoanService taiKhoanService = new TaiKhoanService();
    ThongTinNhanVien thongTinNhanVien = new ThongTinNhanVien();
    VoucherService svVC = new VoucherService();
    KhuyenMaiService svKM = new KhuyenMaiService();
    public static String maNV, tenNV;

    //by Tri
    public login() {
        initComponents();
        init();
        Notifications.getInstance().setJFrame(this);
        rememberCheckBoxLogin();
        TrangLogin();
//        txtGmail.setVisible(false);
//        txtUser.setVisible(true);
//        txtNewPassword.setVisible(false);
//
//        txtOTP.setVisible(false);
//        txtPassword.setVisible(true);
//        txtNewPasswordAgain.setVisible(false);
//
//        btnGuiOPTtoGmail.setVisible(false);
    }

    void init() {
        setLocationRelativeTo(null);
        lblBackLogin.setVisible(false);
        svVC.updateTrangThaiVoucher();
        svVC.updateTrangThai();
        LocalDateTime ngayQuyetDinh = LocalDateTime.now();
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String thoiGianQD = ngayQuyetDinh.format(dinhDang);
        svKM.updateTrangThaiCoupon3();
        svKM.updateTrangThaiCoupon2(thoiGianQD);

    }

    Preferences pres = Preferences.userNodeForPackage(login.class);

    void rememberCheckBoxLogin() {  // Ghi nhớ sự kiện : Nhớ tài khoản
        Boolean saveCheck = pres.getBoolean("checkBoxState", false);
        checkBoxRememberAccount.setSelected(saveCheck);
        if (saveCheck) {
            RememberTextField();
        }
        checkBoxRememberAccount.addActionListener((ActionEvent e) -> {
            boolean isChecked = checkBoxRememberAccount.isSelected();
            pres.putBoolean("checkBoxState", isChecked);

            if (isChecked) {
                SuccesRememberLogin();
            } else {
                DeleteRememberWrongLogin();
            }
        });
    }

    void RememberTextField() {
        String saveTextUsername = pres.get("saveUsername", "");
        String saveTextPassword = pres.get("savePassword", "");
        txtUser.setText(saveTextUsername);
        txtPassword.setText(saveTextPassword);
    }

    void DeleteRememberWrongLogin() {
        pres.remove("saveUsername");
        pres.remove("savePassword");
    }

    void SuccesRememberLogin() {
        pres.put("saveUsername", txtUser.getText());
        pres.put("savePassword", txtPassword.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuiOPTtoGmail = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtGmail = new javax.swing.JTextField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        txtOTP = new javax.swing.JTextField();
        txtNewPasswordAgain = new javax.swing.JPasswordField();
        lblNhapGmail = new javax.swing.JLabel();
        lblNhapGmail1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        checkBoxRememberAccount = new javax.swing.JCheckBox();
        lblBackLogin = new javax.swing.JLabel();
        lblQuenPassword = new javax.swing.JLabel();
        btnXacNhanOTP = new javax.swing.JButton();
        btnXacNhanChangePassword = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTrangDangNhap = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuiOPTtoGmail.setBackground(new java.awt.Color(239, 239, 239));
        btnGuiOPTtoGmail.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnGuiOPTtoGmail.setForeground(new java.awt.Color(18, 13, 13));
        btnGuiOPTtoGmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/SendMail.png"))); // NOI18N
        btnGuiOPTtoGmail.setText("Gửi");
        btnGuiOPTtoGmail.setToolTipText("");
        btnGuiOPTtoGmail.setBorder(null);
        btnGuiOPTtoGmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuiOPTtoGmailMouseClicked(evt);
            }
        });
        btnGuiOPTtoGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiOPTtoGmailActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuiOPTtoGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 160, 80, 35));

        txtUser.setBackground(new java.awt.Color(239, 239, 239));
        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUser.setBorder(null);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 40));

        txtGmail.setBackground(new java.awt.Color(239, 239, 239));
        txtGmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGmail.setBorder(null);
        getContentPane().add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));
        txtGmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGmailFocusLost(evt);
            }
        });
        txtGmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGmailMouseClicked(evt);
            }
        });
        txtGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 40));

        txtNewPassword.setBackground(new java.awt.Color(239, 239, 239));
        getContentPane().add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 40));
        txtNewPassword.setBorder(null);
        getContentPane().add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));

        txtPassword.setBackground(new java.awt.Color(239, 239, 239));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPassword.setBorder(null);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, 40));

        txtOTP.setBackground(new java.awt.Color(239, 239, 239));
        txtOTP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtOTP.setBorder(null);
        getContentPane().add(txtOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));
        txtOTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtOTPMouseClicked(evt);
            }
        });
        txtOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOTPActionPerformed(evt);
            }
        });
        getContentPane().add(txtOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, 40));

        txtNewPasswordAgain.setBackground(new java.awt.Color(239, 239, 239));
        getContentPane().add(txtNewPasswordAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, 40));
        txtNewPasswordAgain.setBorder(null);
        getContentPane().add(txtNewPasswordAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));

        lblNhapGmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        getContentPane().add(lblNhapGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lblNhapGmail1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        getContentPane().add(lblNhapGmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setBackground(new java.awt.Color(0, 51, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(252, 252, 252));
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 38, 344, 49));

        checkBoxRememberAccount.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        checkBoxRememberAccount.setText("Nhớ tài khoản");
        checkBoxRememberAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRememberAccountActionPerformed(evt);
            }
        });
        jPanel3.add(checkBoxRememberAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, -1, -1));

        lblBackLogin.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblBackLogin.setForeground(new java.awt.Color(0, 102, 0));
        lblBackLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackLoginMouseClicked(evt);
            }
        });
        jPanel3.add(lblBackLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 190, 30));

        lblQuenPassword.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblQuenPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuenPassword.setText("Quên mật khẩu ?");
        lblQuenPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenPasswordMouseClicked(evt);
            }
        });
        jPanel3.add(lblQuenPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 8, -1, -1));

        btnXacNhanOTP.setBackground(new java.awt.Color(0, 51, 153));
        btnXacNhanOTP.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXacNhanOTP.setForeground(new java.awt.Color(252, 252, 252));
        btnXacNhanOTP.setText("Xác nhận mã OTP");
        btnXacNhanOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanOTPActionPerformed(evt);
            }
        });
        jPanel3.add(btnXacNhanOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 38, 344, 49));

        btnXacNhanChangePassword.setBackground(new java.awt.Color(0, 153, 0));
        btnXacNhanChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnXacNhanChangePassword.setForeground(new java.awt.Color(252, 252, 252));
        btnXacNhanChangePassword.setText("Xác nhận");
        btnXacNhanChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanChangePasswordActionPerformed(evt);
            }
        });
        jPanel3.add(btnXacNhanChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 38, 344, 49));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 380, 210));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 380, 210));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 102));

        jLabel2.setFont(new java.awt.Font("Montserrat Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("  Thật là tuyệt khi gặp lại bạn.");
        jLabel2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Montserrat Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chúng tôi rất vui mừng khi bạn ở đây");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clotify");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTrangDangNhap.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTrangDangNhap.setForeground(new java.awt.Color(0, 0, 102));
        lblTrangDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangDangNhap.setText("Trang đăng nhập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 100));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 798, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtUserMouseClicked

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed

    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        String username = txtUser.getText();
        String password = TaiKhoanService.getMD5Hash(txtPassword.getText().trim());
        boolean truycap = taiKhoanService.dangnhap(username, password);
        if (username.trim().isEmpty() && password.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Username và password đang bị trống");
            return;
        } else if (username.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Username đang bị trống");
            return;
        } else if (password.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Password đang bị trống");
        } else {
            if (truycap) {
                // Thêm Action vào InputMap và ActionMap của JTextField
                txtPassword.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "doEnterAction");
                //Ghi nhớ tài khoản đúng
                SuccesRememberLogin();
                dispose();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Username hoặc password không đúng");
                //xóa mấy tài khoản sai khỏi nhớ
                DeleteRememberWrongLogin();
            }
        }
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordKeyReleased


    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username = txtUser.getText().trim();
        String password = TaiKhoanService.getMD5Hash(txtPassword.getText().trim());
        boolean truycap = taiKhoanService.dangnhap(username, password);
        if (username.trim().isEmpty() && password.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Username và password đang bị trống");
            return;
        } else if (username.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Username đang bị trống");
            return;
        } else if (password.trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Password đang bị trống");
        } else {
            if (truycap) {
                //Ghi nhớ tài khoản đúng để sau chỉ việc ấn login
                System.out.println("ID used to login : " + TaiKhoanService.layThongTin_maNV());
                System.out.println("Name : " + TaiKhoanService.layThongTin_tenNV());
                SuccesRememberLogin();
                dispose();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Username hoặc password không đúng");
                //xóa mấy tài khoản sai khỏi nhớ
                DeleteRememberWrongLogin();
            }
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    void trangQuenMatKhau() {
        lblQuenPassword.setVisible(false);
        lblTrangDangNhap.setFont(new Font("Roboto", WIDTH, 22));
        lblTrangDangNhap.setText("Quên mật khẩu");
        lblNhapGmail.setText("Nhập gmail của tài khoản muốn khôi phục");
        lblNhapGmail1.setText("Nhập mã OTP");
        lblBackLogin.setText("Quay lại trang đăng nhập");
        lblBackLogin.setVisible(true);
        checkBoxRememberAccount.setVisible(false);
        btnLogin.setVisible(false);

        txtGmail.setVisible(true);
        txtUser.setVisible(false);
        txtNewPassword.setVisible(false);

        txtOTP.setVisible(true);
        txtPassword.setVisible(false);
        txtNewPasswordAgain.setVisible(false);

        btnGuiOPTtoGmail.setVisible(true);
    }

    void TrangLogin() {
        lblQuenPassword.setVisible(true);
        lblTrangDangNhap.setFont(new Font("Verdana", BOLD, 24));
        lblTrangDangNhap.setText("Trang đăng nhập");
        lblNhapGmail.setText("");
        lblNhapGmail1.setText("");
        lblBackLogin.setText("");
        lblBackLogin.setVisible(false);
        checkBoxRememberAccount.setVisible(true);
        btnLogin.setVisible(true);
        btnXacNhanOTP.setVisible(true);

        txtGmail.setVisible(false);
        txtUser.setVisible(true);
        txtNewPassword.setVisible(false);

        txtOTP.setVisible(false);
        txtPassword.setVisible(true);
        txtNewPasswordAgain.setVisible(false);

        btnGuiOPTtoGmail.setVisible(false);
    }

    void trangXacNhanChangePassword() {
        lblQuenPassword.setVisible(false);
        lblTrangDangNhap.setFont(new Font("Roboto", WIDTH, 22));
        lblTrangDangNhap.setText("Thay đổi mật khẩu");
        lblNhapGmail.setText("Mật khẩu mới");
        lblNhapGmail1.setText("Nhập lại mật khẩu");
        lblBackLogin.setText("Quay lại trang đăng nhập");
        lblBackLogin.setVisible(true);
        checkBoxRememberAccount.setVisible(false);
        btnLogin.setVisible(false);
        btnXacNhanOTP.setVisible(false);
        btnXacNhanChangePassword.setVisible(true);

        txtGmail.setVisible(false);
        txtUser.setVisible(false);
        txtNewPassword.setVisible(true);

        txtOTP.setVisible(false);
        txtPassword.setVisible(false);
        txtNewPasswordAgain.setVisible(true);

        btnGuiOPTtoGmail.setVisible(false);
    }
    private void lblQuenPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenPasswordMouseClicked
        // TODO add your handling code here:
        trangQuenMatKhau();

    }//GEN-LAST:event_lblQuenPasswordMouseClicked

    private void btnXacNhanOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanOTPActionPerformed
        // TODO add your handling code here:

        String otpEmail = TaiKhoanService.otp;
        String otpCanNhap = txtOTP.getText().trim();
        String txtmail = txtGmail.getText();
        if (txtmail.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Vui lòng nhập email rồi gửi mã xác nhận");
            return;
        } else if (otpCanNhap.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Vui lòng nhập mã OTP");
            return;
        } else if (otpEmail.equals(otpCanNhap)) {
            trangXacNhanChangePassword();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Mã OTP không đúng");
        }


    }//GEN-LAST:event_btnXacNhanOTPActionPerformed

    private void lblBackLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackLoginMouseClicked
        // TODO add your handling code here:
        TrangLogin();
    }//GEN-LAST:event_lblBackLoginMouseClicked

    private void btnXacNhanChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanChangePasswordActionPerformed
        // TODO add your handling code here:
        String email = txtGmail.getText();
        String password = TaiKhoanService.getMD5Hash(txtNewPassword.getText());
        String passwordAgain = TaiKhoanService.getMD5Hash(txtNewPasswordAgain.getText());

        if (password.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Vui lòng nhập mật khẩu mới");
            return;
        } else if (passwordAgain.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Vui lòng xác nhận lại mật khẩu mới");
            return;
        } else if (!passwordAgain.equals(password)) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Xác nhận mật khẩu đang sai");
            return;
        } else {
            boolean xacNhan = taiKhoanService.ChangeMatKhatLogin(password, email);
            if (xacNhan) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_LEFT, "Đổi mật khẩu thành công");
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Hãy quay lại màn hình đăng nhập để đăng nhập");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Đổi mật khẩu không thành công");
            }
        }
    }//GEN-LAST:event_btnXacNhanChangePasswordActionPerformed

    private void checkBoxRememberAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRememberAccountActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_checkBoxRememberAccountActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void txtGmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailMouseClicked

    private void txtGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailActionPerformed

    private void txtOTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOTPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOTPMouseClicked

    private void txtOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOTPActionPerformed

    private void txtGmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGmailFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtGmailFocusLost

    private void btnGuiOPTtoGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiOPTtoGmailActionPerformed
        // TODO add your handling code here:

        String to = txtGmail.getText();
        if (to.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Vui lòng nhập Email khôi phục");
            return;
        }

        Thread sendOTPThread = new Thread(() -> {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_LEFT, "Đang gửi mã OTP ...");
            boolean guiOTP = taiKhoanService.timkiemGmail(to);
            SwingUtilities.invokeLater(() -> {
                if (guiOTP) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_LEFT, "Gửi mã xác nhận OTP thành công");
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_LEFT, "Gửi mã xác nhận OTP thất bại");
                    return;
                }
            });
        });
        sendOTPThread.start();

    }//GEN-LAST:event_btnGuiOPTtoGmailActionPerformed

    private void btnGuiOPTtoGmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuiOPTtoGmailMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnGuiOPTtoGmailMouseClicked

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
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiOPTtoGmail;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnXacNhanChangePassword;
    private javax.swing.JButton btnXacNhanOTP;
    private javax.swing.JCheckBox checkBoxRememberAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblBackLogin;
    private javax.swing.JLabel lblNhapGmail;
    private javax.swing.JLabel lblNhapGmail1;
    private javax.swing.JLabel lblQuenPassword;
    private javax.swing.JLabel lblTrangDangNhap;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtNewPasswordAgain;
    private javax.swing.JTextField txtOTP;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
