import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.text.SimpleDateFormat;

// [Objek antrian]
class Antrean {
    protected Antrean selanjutnya;
    protected int nomorUrut;
    protected String nama;
    protected String alamat;
    protected String jenisKelamin;
    private static int panjangAntrean = 0;

    Antrean(String nama, String alamat, String jenisKelamin, int nomorUrut) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.nomorUrut = nomorUrut;
        this.selanjutnya = null;
    }

    Antrean() {}

    public Antrean tambah(Antrean selanjutnya) {
        Antrean temp = this;
        // jika data antrian pertama kososng
        if (temp.nama == null && temp.alamat == null && temp.jenisKelamin == null && temp.nomorUrut == 0) {
            System.out.println("antrian baru");
            panjangAntrean += 1;
            return selanjutnya;
        }

        while (temp.selanjutnya != null) {
            temp = temp.selanjutnya;
        }
        temp.selanjutnya = selanjutnya;
        panjangAntrean += 1;
        return this;
    }

    public Antrean kurangi() {
        if (this.selanjutnya == null) {
            panjangAntrean = 0;
            return new Antrean();
        }
        panjangAntrean -= 1;
        return this.selanjutnya;// mengganti nilai objek antrian saat ini dengan objek antrian sebelumnya
    }

    public static int getPanjangAntrean() {
        return panjangAntrean;
    }
}

public class AntreanProcedural extends javax.swing.JFrame implements ActionListener {
    Antrean antrean = new Antrean();
    Queue<Object> antrian = new LinkedList<>();

    int nomor = 0;
    private JButton btnTambahNomorAntrian;
    private JButton btnProsesAntrian;
    private JButton btnTambahAntrian;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, lbJmlAntrian, lbPanggilAntrian, lbTotalAntrian,
            txtAtas, txtAtas1, txtAtas2, txtAtas3, txtAtas4, txtAtas5, txtAtas6, txtAtas7;
    private Font defaultFont = UIManager.getFont("Label.font");


    private JPanel jPanel1, jPanel2, jPanel5;
    private JTextArea txtAntrian;

    private JTable table;

    private JFrame tambahFrame;
    private JTextField textfieldNama, textfieldAlamat, textfieldJenisKelamin;
    private DefaultTableModel model;


    public AntreanProcedural() {
        initComponents();
        inisialisasi();
    }

    private void inisialisasi() {
        lbJmlAntrian.setText("0");
        lbTotalAntrian.setText("0");
        lbPanggilAntrian.setText("-----");

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        txtAtas.setText("Rumah Sakit KSZ");
        txtAtas1.setText("Jl. Sehat Sentosa, Kota Malang");
        txtAtas2.setText("Kota Malang, Jawa Timur");
        txtAtas3.setText("Data Antrian: " + timeStamp);
        txtAtas4.setText("Nomor Tunggu");
        txtAtas5.setText("--------");
    }

    private void prosesAntrian() {
        try {
            Boolean antreanKosong = (antrean.nama == null && antrean.alamat == null && antrean.jenisKelamin == null && antrean.nomorUrut == 0);
           
            if (antreanKosong) {
                JOptionPane.showMessageDialog(this, "Ambil Nomor antrian terlebih dahulu !");

            }
            
            if (antreanKosong) {
                lbPanggilAntrian.setText("-----");
            } else {
                lbPanggilAntrian.setText("" + antrean.nomorUrut);
            }
            antrean = antrean.kurangi();
            updateTable(antrean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void initComponents() {
        txtAntrian = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lbTotalAntrian = new javax.swing.JLabel();
        lbJmlAntrian = new javax.swing.JLabel();
        lbPanggilAntrian = new javax.swing.JLabel();
        btnProsesAntrian = new javax.swing.JButton();
        btnTambahNomorAntrian = new javax.swing.JButton();

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

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] { "Nomor Antrean", "Nama", "Alamat", "Jenis Kelamin" });
        table = new JTable(model);
        table.setEnabled(false);
        // ganti warna header tabel
        // table.getTableHeader().setOpaque(true);
        JTableHeader tableHeader = table.getTableHeader();
        

        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new java.awt.Color(37, 24, 112);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Antrian Pengambilan Obat");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lbTotalAntrian.setBackground(new java.awt.Color(64, 77, 163));
        lbTotalAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTotalAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbJmlAntrian.setBackground(new java.awt.Color(64, 77, 163));
        lbJmlAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbJmlAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJmlAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbPanggilAntrian.setBackground(new java.awt.Color(64, 77, 163));
        lbPanggilAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbPanggilAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanggilAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnProsesAntrian.setBackground(new java.awt.Color(133, 30, 250));
        btnProsesAntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnProsesAntrian.setText("Proses Antrian");

        btnTambahNomorAntrian.setBackground(new java.awt.Color(133, 30, 250));
        btnTambahNomorAntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahNomorAntrian.setText("Ambil Nomor Antrian");

        jLabel4.setText("Loket Antrean Sehat");
        jLabel5.setText("Antrian Sehat");
        jLabel1.setText("Jumlah Antrian");
        jLabel2.setText("Total Antrian");
        jLabel3.setText("Panggilan Nomor Antrian");
        jLabel4.setFont(new Font( "Calibri", Font.BOLD, 30));
        jLabel4.setForeground(new java.awt.Color(78, 36, 214));
        
        txtAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAtas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAtas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        jPanel2.setBackground(new java.awt.Color(61, 73, 161));
        txtAtas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAtas3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtAtas3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE));

        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addComponent(txtAtas3, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(sp)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel5Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout
                                        .createSequentialGroup().addGap(8, 8, 8)
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(lbJmlAntrian,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel5Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2).addComponent(lbTotalAntrian,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel5Layout.createSequentialGroup().addGap(53, 53, 53).addComponent(
                                        btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(
                                        jPanel5Layout.createSequentialGroup().addGap(67, 67, 67).addComponent(jLabel3))
                                .addGroup(
                                        jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                .createSequentialGroup()
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel5Layout.createSequentialGroup()
                                                        .addComponent(btnTambahNomorAntrian,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(37, 37, 37)))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5).addGap(142, 142, 142)))));

        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4).addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1).addComponent(jLabel2))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbJmlAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, 57,
                                                        Short.MAX_VALUE)
                                                .addComponent(lbTotalAntrian, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnTambahNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(37, Short.MAX_VALUE))
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        // [KETIKA TOMBOL TAMBAH DITEKAN]
        btnTambahNomorAntrian.addActionListener(this);
        btnProsesAntrian.addActionListener(this);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void btnTriggerForm(java.awt.event.ActionEvent evt) {
        if (tambahFrame == null) {
            tambahFrame = new JFrame();
            tambahFrame.setBounds(400, 400, 400, 300);
            tambahFrame.setTitle("Tambah Data Antrian Baru");
            Border border = BorderFactory.createLineBorder(new java.awt.Color(130, 36, 224), 1);

            JLabel labelNama = new JLabel("Nama : ");
            JLabel labelAlamat = new JLabel("Alamat : ");
            JLabel labelJenisKelamin = new JLabel("Jenis Kelamin : ");
            labelNama.setBounds(25, 25, 100, 25);
            labelAlamat.setBounds(25, 80, 100, 25);
            labelJenisKelamin.setBounds(25, 135, 100, 25);

            textfieldNama = new JTextField();
            textfieldAlamat = new JTextField();
            textfieldJenisKelamin = new JTextField();
            textfieldNama.setBounds(125, 25, 250, 25);
            textfieldAlamat.setBounds(125, 80, 250, 25);
            textfieldJenisKelamin.setBounds(125, 135, 250, 25);
            textfieldNama.setBorder(border);
            textfieldAlamat.setBorder(border);
            textfieldJenisKelamin.setBorder(border);

            btnTambahAntrian = new JButton("Tambah antrian");
            btnTambahAntrian.setBounds(25, 175, 350, 60);
            btnTambahAntrian.setBackground(new java.awt.Color(133, 30, 250));
            btnTambahAntrian.setForeground(new java.awt.Color(255, 255, 255));

            tambahFrame.add(labelNama);
            tambahFrame.add(labelAlamat);
            tambahFrame.add(labelJenisKelamin);
            tambahFrame.add(textfieldNama);
            tambahFrame.add(textfieldAlamat);
            tambahFrame.add(textfieldJenisKelamin);
            tambahFrame.add(btnTambahAntrian);

            tambahFrame.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
            tambahFrame.setLayout(null);
            tambahFrame.setVisible(true);
            // HANYA AKAN MENGHILANGKAN WINDOW TAMBAH ANTRIAN
            tambahFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            btnTambahAntrian.addActionListener(this);
        }
    }

    public void updateTable(Antrean antrean){
        model.setRowCount(0);//menghapus semua isi tabel
        Boolean antreanKosong = (antrean.nama == null && antrean.alamat == null && antrean.jenisKelamin == null && antrean.nomorUrut == 0);
        while (antrean != null && Antrean.getPanjangAntrean() != 0) {
            System.out.println("asdasd"+antreanKosong);
            System.out.println(Antrean.getPanjangAntrean() == 0);
            model.addRow(new Object[] { antrean.nomorUrut, antrean.nama, antrean.alamat, antrean.jenisKelamin});
            antrean = antrean.selanjutnya;
        }
        table.repaint();
    }

    public void setNewAntrian(JTextField nama, JTextField alamat, JTextField jenisKelamin, int urutan){
        antrean = antrean.tambah(new Antrean(nama.getText(), alamat.getText(), jenisKelamin.getText(), urutan));
        // ganti text
        String antr = "Antrian " + antrean.nomorUrut;
        antrian.add(antr);
        lbTotalAntrian.setText("" + Antrean.getPanjangAntrean());
        txtAntrian.append(antr + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnTambahAntrian) {
            System.out.println("antrian tambah");


            setNewAntrian(textfieldNama, textfieldAlamat, textfieldJenisKelamin, ++nomor);
            updateTable(antrean);
            
            tambahFrame.dispose();
            tambahFrame = null;
            // tambah antrian
            // refresh table
        }
        if (event.getSource() == btnTambahNomorAntrian) {
            btnTriggerForm(event);
        }
        if (event.getSource() == btnProsesAntrian) {
            prosesAntrian();//,memproses (menghapus) antrian
        }
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
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntreanProcedural.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntreanProcedural().setVisible(true);
            }
        });
    }

}
