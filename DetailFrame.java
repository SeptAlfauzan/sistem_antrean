import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import java.awt.event.*;

public class DetailFrame implements ActionListener {

    private String[] data;
    private JTable table;
    private JButton btnTutup;
    public JFrame frame;

    public DetailFrame(JTable table, String[] data) {
        this.table = table;
        this.data = data;
    }
   
    public void show() {
        if (frame != null) {
            
        }else{
            
            frame = new JFrame();
            frame.setBounds(400, 400, 400, 300);
            frame.setTitle("Detail data");
            Border border = BorderFactory.createLineBorder( new Color(130, 36, 224), 1);

            JLabel labelNama = new JLabel("Nama               : ");
            JLabel labelAlamat = new JLabel("Alamat             : ");
            JLabel labelJenisKelamin = new JLabel("Jenis Kelamin    : ");

            labelNama.setBounds(50, 25, 150, 25);
            labelAlamat.setBounds(50, 80, 150, 25);
            labelJenisKelamin.setBounds(50, 135, 150, 25);

            JLabel dataNama = new JLabel();
            JLabel dataAlamat = new JLabel();
            JLabel dataJenisKelamin = new JLabel();
            dataNama.setBounds(220, 25, 200, 25);
            dataAlamat.setBounds(220, 80, 200, 25);
            dataJenisKelamin.setBounds(225, 135, 200, 25);
           
            dataNama.setText(this.data[0]);
            dataAlamat.setText(this.data[1]);
            dataJenisKelamin.setText(this.data[2]);

            labelNama.setFont( new Font("Tahoma", 1, 14));
            labelAlamat.setFont( new Font("Tahoma", 1, 14));
            labelJenisKelamin.setFont( new Font("Tahoma", 1, 14));
            dataNama.setFont( new Font("Tahoma", 1, 14));
            dataAlamat.setFont( new Font("Tahoma", 1, 14));
            dataJenisKelamin.setFont( new Font("Tahoma", 1, 14));
            
            btnTutup = new JButton("Tutup");
            btnTutup.setFont( new Font("Tahoma", 1, 16));
            btnTutup.setBounds(25, 175, 350, 60);
            btnTutup.setBackground( new Color(133, 30, 250));
            btnTutup.setForeground( new Color(255, 255, 255));
            
            dataNama.setBackground( new Color(133, 30, 250));
            dataAlamat.setBackground( new Color(133, 30, 250));
            dataJenisKelamin.setBackground( new Color(133, 30, 250));
            
            frame.add(labelNama);
            frame.add(labelAlamat);
            frame.add(labelJenisKelamin);
            frame.add(dataNama);
            frame.add(dataAlamat);
            frame.add(dataJenisKelamin);
            frame.add(btnTutup);

            frame.getContentPane().setBackground( new Color(255, 255, 255));
            frame.setLayout(null);
            frame.setVisible(true);
            // HANYA AKAN MENGHILANGKAN WINDOW TAMBAH ANTRIAN
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // frame.addWindowListener(new java.awt.event.WindowAdapter() {
            //     @Override
            //     public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            //         this = null;//set tambahframe menjadi null ketika ditutup
            //     }
            // });
            btnTutup.addActionListener(this);
        }
          
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnTutup) {
            frame.dispose();
            // frame = null;
        }
    }
}
