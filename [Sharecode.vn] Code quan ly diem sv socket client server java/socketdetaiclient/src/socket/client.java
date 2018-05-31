package socket;

import socket.Check;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DoanNhatNam
 */
public class client extends javax.swing.JFrame {

    //private DefaultTableModel dtm;

    public client() {
        initComponents();
        //showuser();
    }

    private Socket connect() throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 8080
        String addip;
        addip = ip.getText();
        Socket sk = new Socket(addip, 9876);
        System.out.println("Client da duoc tao...");

        return sk;
    }

    private String connectToServer() throws Exception {

        Socket sk = connect();

        //3.3 tao luon ket noiw den sever
        DataOutputStream gui_server = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream nhan_server = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        gui_server.writeUTF("showAll");// gui du lieu len server

        String ketqua = nhan_server.readUTF();
        System.out.println("Client gui:" + ketqua);//doc tu sever
        sk.close();

        return ketqua;
    }

    public boolean kiemtrathongtin() {
        Check c = new Check();
        if (!c.checkID(MaSV1.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã SV sai...yêu cầu nhập từ 2-> 4 ký tự vừa chữ và số ", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            MaSV1.setText("");
            MaSV1.requestFocus();
            return false;
        } else if (!c.check_hoten(TenSV1.getText()) || !c.checkSpace(TenSV1.getText())) {
            //else if (!c.checkSpace(TenSV1.getText()) || !c.check(TenSV1.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn nhập tên sinh viên chua dung... yeu cau nhap tu 5->20 ky tu..", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            TenSV1.setText("");
            TenSV1.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MaSV1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TenSV1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DIem1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        them = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        nut_xoa_ = new javax.swing.JButton();
        lammoi = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        ketnoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        thongbao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ban = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("đoàn cư");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Computer-Network-icon.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/system.png"))); // NOI18N
        jLabel2.setText("Mã Sinh Viên");
        jPanel2.add(jLabel2);

        MaSV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaSV1ActionPerformed(evt);
            }
        });
        jPanel2.add(MaSV1);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/graduated-icon (1).png"))); // NOI18N
        jLabel3.setText("Tên Sinh viên");
        jPanel2.add(jLabel3);
        jPanel2.add(TenSV1);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/calculate.png"))); // NOI18N
        jLabel4.setText("Điểm Sinh Viên");
        jPanel2.add(jLabel4);

        DIem1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        DIem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DIem1ActionPerformed(evt);
            }
        });
        jPanel2.add(DIem1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn"));
        jPanel3.setLayout(new java.awt.GridLayout(5, 1));

        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/ListMenuPatient1.png"))); // NOI18N
        them.setText("Thêm ");
        them.setEnabled(false);
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        jPanel3.add(them);

        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/bill.png"))); // NOI18N
        sua.setText("Sửa");
        sua.setEnabled(false);
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        jPanel3.add(sua);

        nut_xoa_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Remove.png"))); // NOI18N
        nut_xoa_.setText("xóa");
        nut_xoa_.setEnabled(false);
        nut_xoa_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nut_xoa_ActionPerformed(evt);
            }
        });
        jPanel3.add(nut_xoa_);

        lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/reset.png"))); // NOI18N
        lammoi.setText("Clear");
        lammoi.setEnabled(false);
        lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiActionPerformed(evt);
            }
        });
        jPanel3.add(lammoi);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Button-Delete-icon.png"))); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập Thông Tin Server"));

        jLabel5.setText("Nhập IP Server :");

        ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipActionPerformed(evt);
            }
        });

        ketnoi.setText("Kết Nối");
        ketnoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ketnoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ketnoi)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ketnoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        thongbao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        thongbao.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thongbao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thongbao, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
        );

        ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sinh Viên", "Tên Sinh Viên", "Điểm Sinh Viên"
            }
        ));
        ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ban);

        jPanel7.setLayout(new java.awt.GridLayout(0, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MaSV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaSV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaSV1ActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        if (!kiemtrathongtin()) {
            return;
        }
        //kiem tra masv ten sv khong dc rong
        if (!MaSV1.getText().trim().equals("") && !TenSV1.getText().trim().equals("")) {
            //DefaultTableModel model = (DefaultTableModel) ban.getModel();//xuat ra tabe
            //model.addRow(new Object[]{MaSV1.getText(), TenSV1.getText(), DIem1.getSelectedItem().toString()});//xuat ra tabe
            try {
                accept_Client(MaSV1.getText(), TenSV1.getText(), DIem1.getSelectedItem().toString());
            } catch (Exception ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetForm();
            thongbao.setText("Đã gửi lên server...");
    }//GEN-LAST:event_themActionPerformed
        else
            thongbao.setText("Xin mời bạn nhập thông tin đầy đủ...");
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ketnoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ketnoiActionPerformed
        Check c = new Check();
        if (!c.check_IP(ip.getText())) {
         JOptionPane.showMessageDialog(this, "Nhập địa chỉ IP bị sai...yêu cầu nhập lại dạng 192.168.1.1  ", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
         ip.setText("");
         ip.requestFocus();
                 
         }   else{
         
        try {
            String traloi = connectToServer();
            handleReturnData(traloi);//result
            if (null != traloi && !traloi.equals("DBError")) {
                JOptionPane.showMessageDialog(null, "Kết nối thành công... ...");
                them.setEnabled(true);
                sua.setEnabled(true);
                nut_xoa_.setEnabled(true);
                lammoi.setEnabled(true);
                ketnoi.setEnabled(false);
            } else if (null != traloi && traloi.equals("DBError")) {
                JOptionPane.showMessageDialog(null, "Khong the ket noi den database... ...");
            }

        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Kết nối thất bại... ...");
        }
        } 
    }//GEN-LAST:event_ketnoiActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        if (!kiemtrathongtin()) {
            return;
        }
        int b = JOptionPane.showConfirmDialog(null, "Chắc chắn bạn có muốn sửa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                suadulieu(MaSV1.getText(), TenSV1.getText(), DIem1.getSelectedItem().toString());
            } catch (Exception ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetForm();
            thongbao.setText("Đã gửi yêu cầu sửa dữ liệu lên server...");
        }
    }//GEN-LAST:event_suaActionPerformed

    private void lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiActionPerformed
        this.resetForm();
    }//GEN-LAST:event_lammoiActionPerformed

    private void DIem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DIem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DIem1ActionPerformed

    private void ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipActionPerformed

    private void nut_xoa_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nut_xoa_ActionPerformed
        //tao thong bao
        if (!kiemtrathongtin()) {
            return;
        }
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                xoa(MaSV1.getText(), TenSV1.getText(), DIem1.getSelectedItem().toString());
                //this.resetForm();
            } catch (Exception ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetForm();
            thongbao.setText("Yêu cầu xóa của bạn đã được chuyển lên server...");
    }//GEN-LAST:event_nut_xoa_ActionPerformed
    }
    private void banMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banMouseClicked
        int row = ban.getSelectedRow();
        if (row != -1) {
            String id = ban.getValueAt(row, 0).toString();
            MaSV1.setText(id);
            TenSV1.setText(ban.getValueAt(row, 1).toString());
            DIem1.setSelectedItem(ban.getValueAt(row, 2).toString());
        }

    }//GEN-LAST:event_banMouseClicked

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }

    public void resetForm() {
        DIem1.getSelectedItem();
        MaSV1.setText("");
        TenSV1.setText("");
        thongbao.setText("");
    }

    public void accept_Client(String masv, String tensv, String diem) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 8080
        Socket sk = connect();
        String chen = "add";

        //3.3 tao luon ket noi den sever
        DataOutputStream gui_server = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream nhan_server = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        gui_server.writeUTF(masv + "#" + tensv + "#" + diem + "#" + chen);// gui du lieu len server
        String result = nhan_server.readUTF();
        System.out.println("Client gui:" + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }

    public void xoa(String masv, String tensv, String diem) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 6789

        String chen = "xoa";

        Socket sk = connect();

        //3.3 tao luon ket noi den sever
        DataOutputStream dos = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream din = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        dos.writeUTF(masv + "#" + tensv + "#" + diem + "#" + chen);// gui du lieu len server
        String result = din.readUTF();
        System.out.println("Du lieu nhan duoc tu server: " + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }

    public void suadulieu(String masv, String tensv, String diem) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 6789
        String chen = "suadl";
        Socket sk = connect();

        //3.3 tao luon ket noi den sever
        DataOutputStream dos = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream din = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        dos.writeUTF(masv + "#" + tensv + "#" + diem + "#" + chen);// gui du lieu len server
        String result = din.readUTF();
        System.out.println("Du lieu nhan duoc tu server: " + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }

    private void handleReturnData(String result) {

        DefaultTableModel model = (DefaultTableModel) ban.getModel();//xuat ra tabe
        model.getDataVector().clear();
        if (null != result
                && !result.isEmpty()
                && !result.equalsIgnoreCase("OK")
                && !result.equals("DBError")) {
            String[] students = result.split(";");
            if (null != students && students.length != 0) {
                for (int i = 0; i < students.length; i++) {
                    String student = students[i];
                    if (null != student && !student.isEmpty()) {
                        String[] parts = student.split(",");
                        model.addRow(new Object[]{parts[0], parts[1], parts[2]});
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DIem1;
    private javax.swing.JTextField MaSV1;
    private javax.swing.JTextField TenSV1;
    private javax.swing.JTable ban;
    private javax.swing.JTextField ip;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ketnoi;
    private javax.swing.JButton lammoi;
    private javax.swing.JButton nut_xoa_;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    private javax.swing.JLabel thongbao;
    // End of variables declaration//GEN-END:variables

}
