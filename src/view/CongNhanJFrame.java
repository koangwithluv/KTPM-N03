/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CongNhanController;
import model.CongNhan;

/**
 *
 * @author Acer-PC
 */
public class CongNhanJFrame extends javax.swing.JFrame {

    /**
     * Creates new form CongNhanJFrame
     */
    public CongNhanJFrame(CongNhan congNhan) {
        initComponents();
        //QuanLiCongNhanController quanLiCongNhanController = new QuanLiCongNhanController();
        CongNhanController controller = new CongNhanController(jbtnSave, jtfFullName, jtfMaCongNhan, jtfDiaChi, jtfGioiTinh,jtfEmail,jtfSdt,jlbMessage);
        
        controller.setView(congNhan);
        controller.setEvent();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnSave = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        jlbfullName = new javax.swing.JLabel();
        jlbMaCongNhan = new javax.swing.JLabel();
        jlbDiaChi = new javax.swing.JLabel();
        jlbGioiTinh = new javax.swing.JLabel();
        jtfFullName = new javax.swing.JTextField();
        jtfMaCongNhan = new javax.swing.JTextField();
        jtfDiaChi = new javax.swing.JTextField();
        jtfGioiTinh = new javax.swing.JTextField();
        jlbEmail = new javax.swing.JLabel();
        jlbSdt = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfSdt = new javax.swing.JTextField();
        jlbMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jbtnSave.setBackground(new java.awt.Color(0, 102, 102));
        jbtnSave.setText("Lưu Dữ Liệu");

        jpnView.setBackground(new java.awt.Color(255, 255, 255));
        jpnView.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Công Nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jpnView.setForeground(new java.awt.Color(51, 51, 51));

        jlbfullName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbfullName.setForeground(new java.awt.Color(51, 51, 51));
        jlbfullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbfullName.setText("Họ Và Tên");

        jlbMaCongNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbMaCongNhan.setForeground(new java.awt.Color(51, 51, 51));
        jlbMaCongNhan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbMaCongNhan.setText("Mã Công Nhân");

        jlbDiaChi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbDiaChi.setForeground(new java.awt.Color(51, 51, 51));
        jlbDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDiaChi.setText("Địa Chỉ");

        jlbGioiTinh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbGioiTinh.setForeground(new java.awt.Color(51, 51, 51));
        jlbGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbGioiTinh.setText("Giới Tính");

        jtfFullName.setBackground(new java.awt.Color(204, 204, 204));
        jtfFullName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfFullName.setForeground(new java.awt.Color(51, 51, 51));
        jtfFullName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfMaCongNhan.setBackground(new java.awt.Color(204, 204, 204));
        jtfMaCongNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfMaCongNhan.setForeground(new java.awt.Color(51, 51, 51));
        jtfMaCongNhan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfDiaChi.setBackground(new java.awt.Color(204, 204, 204));
        jtfDiaChi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfDiaChi.setForeground(new java.awt.Color(51, 51, 51));
        jtfDiaChi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfGioiTinh.setBackground(new java.awt.Color(204, 204, 204));
        jtfGioiTinh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfGioiTinh.setForeground(new java.awt.Color(51, 51, 51));
        jtfGioiTinh.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlbEmail.setBackground(new java.awt.Color(255, 255, 255));
        jlbEmail.setForeground(new java.awt.Color(51, 51, 51));
        jlbEmail.setText("Email");

        jlbSdt.setBackground(new java.awt.Color(255, 255, 255));
        jlbSdt.setForeground(new java.awt.Color(51, 51, 51));
        jlbSdt.setText("SĐT");

        jtfEmail.setBackground(new java.awt.Color(204, 204, 204));
        jtfEmail.setForeground(new java.awt.Color(51, 51, 51));
        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });

        jtfSdt.setBackground(new java.awt.Color(204, 204, 204));
        jtfSdt.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnViewLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMaCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbfullName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnViewLayout.createSequentialGroup()
                        .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMaCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbfullName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMaCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMaCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnViewLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jtfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnViewLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jlbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jlbMessage.setBackground(new java.awt.Color(204, 204, 204));
        jlbMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbMessage.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addComponent(jbtnSave)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JLabel jlbDiaChi;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbGioiTinh;
    private javax.swing.JLabel jlbMaCongNhan;
    private javax.swing.JLabel jlbMessage;
    private javax.swing.JLabel jlbSdt;
    private javax.swing.JLabel jlbfullName;
    private javax.swing.JPanel jpnView;
    private javax.swing.JTextField jtfDiaChi;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfFullName;
    private javax.swing.JTextField jtfGioiTinh;
    private javax.swing.JTextField jtfMaCongNhan;
    private javax.swing.JTextField jtfSdt;
    // End of variables declaration//GEN-END:variables
}
