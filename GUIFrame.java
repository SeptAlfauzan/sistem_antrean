import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.text.SimpleDateFormat;


public class GUIFrame extends javax.swing.JFrame implements ActionListener {
    Antrean antrean = new Antrean();
    DetailFrame detailFrame;
    int nomor = 0;
    private JButton btnTambahNomorAntrian;
    private JButton btnProsesAntrian;
    private JButton btnTambahAntrian;
    private JLabel labelTotalAntrian, labelNomorPanggilan, judul, jLabel5, jLabel6, lbPanggilAntrian, lbTotalAntrian, txtWaktu;
    private JComboBox<String> comboJenisKelamin;
    private JPanel jPanel2, jPanel5;
    private JTextArea txtAntrian;
    private JTable table;
    private JFrame tambahFrame;
    private JTextField textfieldNama, textfieldAlamat, textfieldJenisKelamin;
    private DefaultTableModel model;

    public GUIFrame() {
        initComponents();
        inisialisasi();
    }

    private void inisialisasi() {
        lbTotalAntrian.setText("0");
        lbPanggilAntrian.setText("-----");

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        txtWaktu.setText("Data Antrian: " + timeStamp);
    }

    private void initComponents() {
        txtAntrian = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lbTotalAntrian = new javax.swing.JLabel();
        lbPanggilAntrian = new javax.swing.JLabel();
        btnProsesAntrian = new javax.swing.JButton();
        btnTambahNomorAntrian = new javax.swing.JButton();

        judul = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTotalAntrian = new javax.swing.JLabel();
        labelNomorPanggilan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtWaktu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] { "Nomor Antrean", "Nama", "Alamat", "Jenis Kelamin" });
        table = new JTable(model);
        table.setEnabled(false);

        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor =  new Color(37, 24, 112);
            }
        });

        setTitle("Aplikasi Antrian Pengambilan Obat");

        jPanel5.setBackground( new Color(255, 255, 255));

        lbTotalAntrian.setBackground( new Color(64, 77, 163));
        lbTotalAntrian.setFont( new Font("Tahoma", 1, 24)); // NOI18N
        lbTotalAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalAntrian.setBorder(
                        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbPanggilAntrian.setBackground( new Color(64, 77, 163));
        lbPanggilAntrian.setFont( new Font("Tahoma", 1, 24)); // NOI18N
        lbPanggilAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanggilAntrian.setBorder(
                        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnProsesAntrian.setBackground( new Color(133, 30, 250));
        btnProsesAntrian.setForeground( new Color(255, 255, 255));
        btnProsesAntrian.setText("Proses Antrian");
        btnProsesAntrian.setFont(new Font("Calibri", 1, 14));


        btnTambahNomorAntrian.setBackground( new Color(133, 30, 250));
        btnTambahNomorAntrian.setForeground( new Color(255, 255, 255));
        btnTambahNomorAntrian.setText("Ambil Nomor Antrian");
        btnTambahNomorAntrian.setFont(new Font("Calibri", 1, 14));

        judul.setText("Loket Antrean Sehat");
        labelTotalAntrian.setText("Total Antrian");
        labelNomorPanggilan.setText("Panggilan Nomor Antrian");

        labelNomorPanggilan.setFont(new Font("Calibri", 1, 14));
        labelTotalAntrian.setFont(new Font("Calibri", 1, 14));
        judul.setFont(new Font("Calibri", 1, 30));
        labelTotalAntrian.setForeground( new Color(78, 36, 214));
        labelNomorPanggilan.setForeground( new Color(78, 36, 214));
        judul.setForeground( new Color(78, 36, 214));

        jPanel2.setBackground( new Color(61, 73, 161));
        txtWaktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtWaktu.setForeground( new Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        // layout untuk tabel
        jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtWaktu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                                        .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sp)));
        // layout utama
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup().addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                        .addGroup(jPanel5Layout
                                                                                        .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jPanel5Layout
                                                                                                        .createSequentialGroup()
                                                                                                        .addGap(8, 8, 8)
                                                                                                        .addGroup(jPanel5Layout
                                                                                                                        .createParallelGroup(
                                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                        false)
                                                                                                                        .addComponent(lbPanggilAntrian,
                                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                        Short.MAX_VALUE)
                                                                                                                        .addGroup(jPanel5Layout
                                                                                                                                        .createSequentialGroup()
                                                                                                                                        .addGap(18, 18, 18)
                                                                                                                                        .addGroup(jPanel5Layout
                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                        .addComponent(labelTotalAntrian)
                                                                                                                                                        .addComponent(lbTotalAntrian,
                                                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                        190,
                                                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                                        .addGroup(jPanel5Layout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(btnProsesAntrian,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        220,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jPanel5Layout
                                                                                                        .createSequentialGroup()
                                                                                                        .addGap(10, 10, 10)
                                                                                                        .addComponent(labelNomorPanggilan)))
                                                                        .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        91, Short.MAX_VALUE)
                                                                        .addGroup(jPanel5Layout
                                                                                        .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        jPanel5Layout.createSequentialGroup()
                                                                                                                        .addGroup(jPanel5Layout
                                                                                                                                        .createParallelGroup(
                                                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                        .addComponent(jPanel2,
                                                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                        .addGap(8, 8, 8))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        jPanel5Layout.createSequentialGroup()
                                                                                                                        .addComponent(btnTambahNomorAntrian,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                        215,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addGap(37, 37, 37)))
                                                                        .addComponent(jLabel6,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        19,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addContainerGap())
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                        .addComponent(judul)
                                                                        .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                        .addComponent(jLabel5)
                                                                        .addGap(142, 142, 142)))));

        jPanel5Layout.setVerticalGroup(jPanel5Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup().addGap(36, 36, 36)
                                        .addGroup(jPanel5Layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(judul).addComponent(jLabel5))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel5Layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                        .addGroup(jPanel5Layout
                                                                                        .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(labelTotalAntrian))
                                                                        .addGap(8, 8, 8)
                                                                        .addGroup(jPanel5Layout
                                                                                        .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                        false)
                                                                                        .addComponent(lbTotalAntrian,
                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                        57,
                                                                                                        Short.MAX_VALUE))
                                                                        .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                        90, Short.MAX_VALUE)
                                                                        .addComponent(labelNomorPanggilan)
                                                                        .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lbPanggilAntrian,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        100,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(0, 18, 18)
                                                                        .addComponent(btnProsesAntrian,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        48,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(41, 41, 41))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                        .addComponent(btnTambahNomorAntrian,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        48,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(11, 11, 11)
                                                                        .addComponent(jPanel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addContainerGap(37, Short.MAX_VALUE))
                                                        .addComponent(jLabel6,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))));

            // [KETIKA TOMBOL TAMBAH DITEKAN]
            btnTambahNomorAntrian.addActionListener(this);
            btnProsesAntrian.addActionListener(this);
            table.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int row = table.rowAtPoint(evt.getPoint());
                    int nomorUrut = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                    if (detailFrame != null) {
                        detailFrame.frame.dispose();//dispose frame dari objek detail frame
                        System.out.println("jframe ada");
                    }
                    detailFrame = new DetailFrame(table, getAllDataRow(nomorUrut));
                    detailFrame.show();
                }
                });

            getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            pack();
    }
    
    protected String[] getAllDataRow(int nomorUrut){

        // cari data sesuai dengan nomor urut antrian
        // System.out.println(antrean.selanjutnya);
        Antrean hasilAntrean = antrean.getSpecificData(nomorUrut);
        if (hasilAntrean != null) {
            return hasilAntrean.getDataDiri();
        }
        return null;
    }

    private void btnTriggerForm(java.awt.event.ActionEvent evt) {
        if (tambahFrame != null) {
            tambahFrame.dispose();//dispose window tambah jika sudah ada window lama
        }
            tambahFrame = new JFrame();
            tambahFrame.setBounds(400, 400, 400, 300);
            tambahFrame.setTitle("Tambah Data Antrian Baru");
            Border border = BorderFactory.createLineBorder( new Color(130, 36, 224), 1);

            JLabel labelNama = new JLabel("Nama : ");
            JLabel labelAlamat = new JLabel("Alamat : ");
            JLabel labelJenisKelamin = new JLabel("Jenis Kelamin : ");
            String gender[] = { "Laki-laki", "Perempuan" };// COMBOBOX pilihan
            comboJenisKelamin = new JComboBox<String>(gender);

            labelNama.setBounds(25, 25, 100, 25);
            labelAlamat.setBounds(25, 80, 100, 25);
            labelJenisKelamin.setBounds(25, 135, 100, 25);

            textfieldNama = new JTextField();
            textfieldAlamat = new JTextField();
            textfieldJenisKelamin = new JTextField();
            textfieldNama.setBounds(125, 25, 250, 25);
            textfieldAlamat.setBounds(125, 80, 250, 25);
            comboJenisKelamin.setBounds(125, 135, 250, 25);
            textfieldNama.setBorder(border);
            textfieldAlamat.setBorder(border);
            comboJenisKelamin.setBackground(Color.WHITE);

            btnTambahAntrian = new JButton("Tambah antrian");
            btnTambahAntrian.setFont( new Font("Tahoma", 1, 16));
            btnTambahAntrian.setBounds(25, 175, 350, 60);
            btnTambahAntrian.setBackground( new Color(133, 30, 250));
            btnTambahAntrian.setForeground( new Color(255, 255, 255));

            tambahFrame.add(labelNama);
            tambahFrame.add(labelAlamat);
            tambahFrame.add(labelJenisKelamin);
            tambahFrame.add(textfieldNama);
            tambahFrame.add(textfieldAlamat);
            tambahFrame.add(comboJenisKelamin);
            tambahFrame.add(btnTambahAntrian);

            tambahFrame.getContentPane().setBackground( new Color(255, 255, 255));
            tambahFrame.setLayout(null);
            tambahFrame.setVisible(true);
            // HANYA AKAN MENGHILANGKAN WINDOW TAMBAH ANTRIAN
            tambahFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tambahFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    tambahFrame = null;//set tambahframe menjadi null ketika ditutup
                }
            });

            btnTambahAntrian.addActionListener(this);
    }

    public void updateTable(Antrean antrean) {
        model.setRowCount(0);// menghapus semua isi tabel
        while (antrean != null && Antrean.getPanjangAntrean() != 0) {
            model.addRow(new Object[] { antrean.getNomorUrut(), antrean.getNama(), antrean.getAlamat(), antrean.getJenisKelamin() });
            antrean = antrean.selanjutnya;
        }
        lbTotalAntrian.setText("" + Antrean.getPanjangAntrean());
        table.repaint();
    }

    public void setNewAntrian(JTextField nama, JTextField alamat, JComboBox jenisKelamin, int urutan) {
        antrean = antrean.tambah(new Antrean(nama.getText(), alamat.getText(), jenisKelamin.getSelectedItem().toString(), urutan));
        System.out.println(jenisKelamin.getSelectedItem().toString());
        
        // ganti text
        String antr = "Antrian " + antrean.getNomorUrut();
        // antrian.add(antr);
        txtAntrian.append(antr + "\n");
    }

    private boolean checkInput(String str) throws ValidatorException{
        if(str.trim().equals("")){//jika string kosong
            throw new ValidatorException("Input tidak boleh kosong!");
        }
        //jika string mengandung tanda baca 
        String[] rules = {"!", ",", ".", ";", ":", "-", "?", "/", "'", Character.toString('"'), "[", "]", "(", ")"  };
        for (int i = 0; i < rules.length; i++) {
            if (str.contains(rules[i])) {
                throw new ValidatorException("Input tidak boleh mengandung tanda baca!");
            }
        }
        return false;
    }

    private void prosesAntrian() {
        try {
            Boolean antreanKosong = (antrean.getNama() == null && antrean.getAlamat() == null && antrean.getJenisKelamin() == null
                    && antrean.getNomorUrut() == 0);
            if (antreanKosong) {
                JOptionPane.showMessageDialog(this, "Ambil Nomor antrian terlebih dahulu !");
                lbPanggilAntrian.setText("-----");
            } else {
                lbPanggilAntrian.setText("" + antrean.getNomorUrut());
            }
            antrean = antrean.kurangi();
            updateTable(antrean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnTambahAntrian) {
            try {
                checkInput(textfieldNama.getText());
                checkInput(textfieldAlamat.getText());
                // tambah antrian
                setNewAntrian(textfieldNama, textfieldAlamat, comboJenisKelamin, ++nomor);
                updateTable(antrean);
                // refresh table
                tambahFrame.dispose();
                tambahFrame = null;
            } catch (ValidatorException e) {
                JOptionPane.showMessageDialog(tambahFrame, e.getMessage());
            }
        }
        if (event.getSource() == btnTambahNomorAntrian) {
            btnTriggerForm(event);
        }
        if (event.getSource() == btnProsesAntrian) {
            prosesAntrian();// ,memproses (menghapus) antrian
        }
    }
}
