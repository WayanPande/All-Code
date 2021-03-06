package projectakhir;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class kasir_resto extends javax.swing.JFrame {
    DefaultTableModel model;
    String[] judul = {"Menu", "Harga", "Jumlah Beli", "Sub Total"};
    Date tglp = new Date();
    SimpleDateFormat tgl = new SimpleDateFormat("dd-mm-yyyy");
    
    
    menurestoran menu1 = new menurestoran();
    

  
    public kasir_resto() {
        initComponents();
        //initComponents();
        simpan.setEnabled(false);
    }
    
    void isimenu(){
        try{
            Connection c = KonekMYSQL.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM `menu_restoran`";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                menutam.addItem("nama_menu");
                
            }
            r.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Kesalahan isi menu");
        }
    }
    
    void nomor(){
        Connection c = KonekMYSQL.getKoneksi();
        Date a = new Date();
        SimpleDateFormat b = new SimpleDateFormat("ddMMyy-");
        String time = b.format(a);
        try{
            Statement s = c.createStatement();
            String sql = "SELECT RIGHT (no_order,3) AS x FROM `transaksi_menu` ORDER BY no_order desc";
            ResultSet r = s.executeQuery(sql);
            if(r.next()){
                int kode = Integer.parseInt(r.getString("x"))+1;
                txtorder.setText(time+"00"+Integer.toString(kode));
                
            }
            else{
                int kode = 1;
                txtorder.setText(time+"00"+Integer.toString(kode));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Kesalahan tidak boleh ditiru");
        }
    }
    
     void tampilmenu(){
        Connection c = KonekMYSQL.getKoneksi();
        
        try{
            Statement s = c.createStatement();
            String sql = "SELECT * `menu_restoran` WHERE nama_menu '"+menutam.getSelectedItem().toString()+"'";
            ResultSet r = s.executeQuery(sql);
            if(r.next()){
                txtharga.setText(r.getString("harga"));
                
            }
            else{
               txtharga.setText("");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Kesalahan tampil");
        }
    }
    
    void tampil2(){
        model=new DefaultTableModel(null,judul);
        try{
           Connection c = KonekMYSQL.getKoneksi();
           Statement s = c.createStatement();
            String sql = "SELECT * `sementara_men`";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                String a=r.getString("nama_menu");
                String b=r.getString("harga");
                String f=r.getString("jumbel");
                String d=r.getString("subtotal");
                
                String data[]={a,b,f,d};
                model.addRow(data);
                
            }
            tabelmenu.setModel(model);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "tamilan tabel hilang");
        }
    }
    
    void bersih(){
        txtorder.setText("");
        menutam.setSelectedItem("Pilih");
        txtharga.setText("");
        txtbayar.setText("");
        txtjumbel.setText("");
        txttanggal.setText("");
        txtsubtotal.setText("");
        txttotal.setText("");
        txtkembalian.setText("");
        tabelmenu.setSelectionModel(null);
        
    }
    
    void aktif(){
        menutam.setEnabled(true);
        txttotal.setEnabled(true);
        txtbayar.setEnabled(true);
    }
    
    void nonaktif(){
        txtorder.setEnabled(false);
        txttanggal.setEnabled(false);
        menutam.setEnabled(false);
        txtharga.setEnabled(false);
        txttotal.setEnabled(false);
        txtbayar.setEnabled(false);
        txtsubtotal.setEnabled(false);
        txtkembalian.setEnabled(false);
        txttotal.setEnabled(false);
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
        jPanel2 = new javax.swing.JPanel();
        Kembali = new javax.swing.JButton();
        KASIRRESTO = new javax.swing.JLabel();
        datapesana = new javax.swing.JLabel();
        noorder = new javax.swing.JLabel();
        tangggal = new javax.swing.JLabel();
        datatransaksi = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        jumlahbeli = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        uangbayar = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        uangkembalian = new javax.swing.JLabel();
        txtorder = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        menutam = new javax.swing.JComboBox<>();
        txtharga = new javax.swing.JTextField();
        txtjumbel = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmenu = new javax.swing.JTable();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        pesan = new javax.swing.JButton();
        batal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        Kembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Kembali.setText("Kembali");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });

        KASIRRESTO.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        KASIRRESTO.setForeground(new java.awt.Color(255, 255, 255));
        KASIRRESTO.setText("KASIR RESTORAN HOTEL3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(KASIRRESTO)
                .addGap(126, 126, 126)
                .addComponent(Kembali)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kembali)
                    .addComponent(KASIRRESTO))
                .addContainerGap())
        );

        datapesana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        datapesana.setForeground(new java.awt.Color(255, 255, 255));
        datapesana.setText("DATA PESANAN");

        noorder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noorder.setForeground(new java.awt.Color(255, 255, 255));
        noorder.setText("No. Order");

        tangggal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tangggal.setForeground(new java.awt.Color(255, 255, 255));
        tangggal.setText("Tanggal");

        datatransaksi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        datatransaksi.setForeground(new java.awt.Color(255, 255, 255));
        datatransaksi.setText("DATA TRANSAKSI");

        menu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("Menu");

        harga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        harga.setForeground(new java.awt.Color(255, 255, 255));
        harga.setText("Harga");

        jumlahbeli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jumlahbeli.setForeground(new java.awt.Color(255, 255, 255));
        jumlahbeli.setText("Jumlah Beli");

        subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subtotal.setForeground(new java.awt.Color(255, 255, 255));
        subtotal.setText("Sub Total");

        uangbayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uangbayar.setForeground(new java.awt.Color(255, 255, 255));
        uangbayar.setText("Uang Bayar");

        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("Total");

        uangkembalian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uangkembalian.setForeground(new java.awt.Color(255, 255, 255));
        uangkembalian.setText("Uang Kembalian");

        txtorder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txttanggal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        menutam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menutam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtharga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtjumbel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtjumbel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtjumbelKeyPressed(evt);
            }
        });

        txtsubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tabelmenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelmenu);

        txttotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtbayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbayarKeyPressed(evt);
            }
        });

        txtkembalian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        simpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        pesan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pesan.setText("PESAN");

        batal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        batal.setText("BATAL");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(datapesana)
                                .addComponent(datatransaksi)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(noorder)
                                        .addComponent(tangggal))
                                    .addGap(84, 84, 84)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtorder, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(txttanggal)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(menu)
                                        .addComponent(harga)
                                        .addComponent(jumlahbeli)
                                        .addComponent(subtotal))
                                    .addGap(79, 79, 79)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(menutam, 0, 183, Short.MAX_VALUE)
                                        .addComponent(txtharga)
                                        .addComponent(txtjumbel)
                                        .addComponent(txtsubtotal))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total)
                                    .addComponent(uangbayar)
                                    .addComponent(uangkembalian))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(txtbayar)
                                    .addComponent(txtkembalian))
                                .addGap(122, 122, 122)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(simpan)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datapesana)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noorder)
                    .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tangggal)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(datatransaksi)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menu)
                            .addComponent(menutam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(harga)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlahbeli)
                            .addComponent(txtjumbel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subtotal)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(total))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(simpan)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uangbayar)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesan))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uangkembalian)
                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtjumbelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumbelKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            menu1.setjumbel(Long.parseLong(txtjumbel.getText()));
            menu1.setHrga(Long.parseLong(txtharga.getText()));
            menu1.setnoordr(txtorder.getText());
            menu1.setmenurt(menutam.getSelectedItem().toString());
            txtsubtotal.setText(Long.toString(menu1.getsubtotal()));
            txttotal.setText(Long.toString(menu1.gettotal()));
            menu1.simpansementara();
            menu1.simpandetail();
            
            tampil2();
            int x;
            x=JOptionPane.showConfirmDialog(null,"Anda Yakin Ingin Beli Lagi?","konfirmasi",JOptionPane.YES_NO_OPTION);
            if(x==JOptionPane.YES_OPTION){
                aktif();
                menutam.setSelectedItem("pilih");
                txtharga.setText("");
                txtjumbel.setText("");
                txtsubtotal.setText("");
                pesan.setEnabled(false);
            }
            else{
                txtbayar.grabFocus();
            }
        }
    }//GEN-LAST:event_txtjumbelKeyPressed

    private void txtbayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbayarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            menu1.settotal(Long.parseLong(txttotal.getText()));
            menu1.setbayar(Long.parseLong(txtbayar.getText()));
            txtkembalian.setText(Long.toString(menu1.getkembali()));
        }
    }//GEN-LAST:event_txtbayarKeyPressed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        menu1.setnoordr(txtorder.getText());
        menu1.settgl(txttanggal.getText());
        menu1.setmenurt(menutam.getSelectedItem().toString());
        menu1.setHrga((Long.parseLong(txtharga.getText())));
        menu1.simpantransaksi();
        menu1.hapusgrid();
        bersih();
        nonaktif();
        pesan.setEnabled(true);
        simpan.setEnabled(false);
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        bersih();
        nonaktif();
    }//GEN-LAST:event_batalActionPerformed

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Reservasi reservasi = new Reservasi();
        reservasi.setVisible(true);
        reservasi.pack();
        reservasi.setLocationRelativeTo(null);
    }//GEN-LAST:event_KembaliActionPerformed

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
            java.util.logging.Logger.getLogger(kasir_resto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir_resto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir_resto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir_resto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir_resto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel KASIRRESTO;
    private javax.swing.JButton Kembali;
    private javax.swing.JButton batal;
    private javax.swing.JLabel datapesana;
    private javax.swing.JLabel datatransaksi;
    private javax.swing.JLabel harga;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlahbeli;
    private javax.swing.JLabel menu;
    private javax.swing.JComboBox<String> menutam;
    private javax.swing.JLabel noorder;
    private javax.swing.JButton pesan;
    private javax.swing.JButton simpan;
    private javax.swing.JLabel subtotal;
    private javax.swing.JTable tabelmenu;
    private javax.swing.JLabel tangggal;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumbel;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtorder;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttotal;
    private javax.swing.JLabel uangbayar;
    private javax.swing.JLabel uangkembalian;
    // End of variables declaration//GEN-END:variables
}
