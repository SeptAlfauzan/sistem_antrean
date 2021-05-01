import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class AntreanProcedural extends javax.swing.JFrame {

    Queue<Object> antrian = new LinkedList<>();
    int nomor = 0;

    public queue() {
        initComponents();
        inisialisasi();
    }

    private void inisialisasi() {
        lbJmlAntrian.setText("0");
        lbTotalAntrian.setText("0");
        lbPanggilAntrian.setText("-----");

        txtAtas.setText("Rumah Sakit KSZ");
        txtAtas1.setText("Jl. Sehat Sentosa, Kota Malang");
        txtAtas2.setText("Kota Malang, Jawa Timur");
        txtAtas3.setText("Sabtu, 1 Mei 2021");
        txtAtas4.setText("Nomor Tunggu");
        txtAtas5.setText("--------");
        txtAtas6.setText("Silahkan menunggu");
        txtAtas7.setText("--------");
    }

    private void tambahAntrian() {
        nomor++;
        String antr = "Antrian " + nomor;
        antrian.add(antr);
        String cvt = String.valueOf(antrian.size());
        lbJmlAntrian.setText(cvt);
        lbPanggilAntrian.setText("" + antrian.peek());
        lbTotalAntrian.setText("" + nomor);
        txtAntrian.append(antr + "\n");

        txtAtas3.setText("Sabtu, 1 Mei 2021");
        txtAtas4.setText("Nomor Tunggu");
        txtAtas5.setText("  " + nomor);
        txtAtas6.setText("Silahkan menunggu " + cvt + " Antrian Lagi ");
        txtAtas7.setText("Mohon untuk bersabar");
    }

    private void prosesAntrian() {
        if (antrian.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ambil Nomor antrian terlebih dahulu !");
        }
        txtAntrian.setText("");
        antrian.poll();
        antrian.forEach((Object element) -> {
            txtAntrian.append("" + element + "\n");
        });
        if (antrian.isEmpty()) {
            lbPanggilAntrian.setText("-----");
        } else {
            lbPanggilAntrian.setText("" + antrian.peek());
        }
    }

    private javax.swing.JButton btnAmbilNomorAntrian;
    private javax.swing.JButton btnProsesAntrian;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, lbJmlAntrian, lbPanggilAntrian,
            lbTotalAntrian, txtAtas, txtAtas1, txtAtas2, txtAtas3, txtAtas4, txtAtas5, txtAtas6, txtAtas7;

    private javax.swing.JPanel jPanel1, jPanel2, jPanel5;
    private javax.swing.JTextArea txtAntrian;

    private void initComponents() {

        txtAntrian = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lbTotalAntrian = new javax.swing.JLabel();
        lbJmlAntrian = new javax.swing.JLabel();
        lbPanggilAntrian = new javax.swing.JLabel();
        btnProsesAntrian = new javax.swing.JButton();
        btnAmbilNomorAntrian = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtAtas = new javax.swing.JLabel();
        txtAtas1 = new javax.swing.JLabel();
        txtAtas2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtAtas3 = new javax.swing.JLabel();
        txtAtas4 = new javax.swing.JLabel();
        txtAtas5 = new javax.swing.JLabel();
        txtAtas6 = new javax.swing.JLabel();
        txtAtas7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Antrian Pengambilan Obat");

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        lbTotalAntrian.setBackground(new java.awt.Color(255, 255, 204));
        lbTotalAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTotalAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbJmlAntrian.setBackground(new java.awt.Color(255, 255, 204));
        lbJmlAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbJmlAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJmlAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbPanggilAntrian.setBackground(new java.awt.Color(255, 255, 204));
        lbPanggilAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbPanggilAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanggilAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnProsesAntrian.setBackground(new java.awt.Color(0, 153, 0));
        btnProsesAntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnProsesAntrian.setText("Proses Antrian");
        btnProsesAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesAntrianActionPerformed(evt);
            }
        });

        btnAmbilNomorAntrian.setBackground(new java.awt.Color(0, 153, 0));
        btnAmbilNomorAntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnAmbilNomorAntrian.setText("Ambil Nomor Antrian");
        btnAmbilNomorAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilNomorAntrianActionPerformed(evt);
            }
        });

        jLabel4.setText("Loket");

        jLabel5.setText("Antrian Sehat");

        jLabel1.setText("Jumlah Antrian");

        jLabel2.setText("Total Antrian");

        jLabel3.setText("Panggilan Nomor Antrian");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtAtas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(txtAtas3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        .addComponent(txtAtas4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        .addComponent(txtAtas5, javax.swing.GroupLayout.Alignment.TRAILING,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(txtAtas6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        .addComponent(txtAtas7, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE));
        
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
        .addComponent(txtAtas3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtAtas4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtAtas5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(txtAtas6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(txtAtas7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel5Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
        .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createSequentialGroup()
        .addComponent(lbJmlAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel2).addComponent(lbTotalAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addGroup(jPanel5Layout.createSequentialGroup().addGap(53, 53, 53).addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel5Layout.createSequentialGroup().addGap(67, 67, 67).addComponent(jLabel3))
        .addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel1))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91,Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,jPanel5Layout.createSequentialGroup()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,javax.swing.GroupLayout.Alignment.TRAILING,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel2,javax.swing.GroupLayout.Alignment.TRAILING,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(8, 8, 8))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,jPanel5Layout.createSequentialGroup().addComponent(btnAmbilNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(37, 37, 37))).addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19,javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap())
        .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel5).addGap(142, 142, 142)))));

        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup().addGap(36, 36, 36)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jLabel5)).addGap(19, 19, 19)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jLabel2)).addGap(8, 8, 8)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(lbJmlAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, 57,Short.MAX_VALUE).addComponent(lbTotalAntrian, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90,Short.MAX_VALUE).addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lbPanggilAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 48,javax.swing.GroupLayout.PREFERRED_SIZE).addGap(41, 41, 41))
        .addGroup(jPanel5Layout.createSequentialGroup().addComponent(btnAmbilNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 48,javax.swing.GroupLayout.PREFERRED_SIZE).addGap(11, 11, 11).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(37, Short.MAX_VALUE)).addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void btnProsesAntrianActionPerformed(java.awt.event.ActionEvent evt) {// 
        prosesAntrian();
    }

    private void btnAmbilNomorAntrianActionPerformed(java.awt.event.ActionEvent evt) {
        tambahAntrian();
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntreanProcedural().setVisible(true);
            }
        });
    }

}
