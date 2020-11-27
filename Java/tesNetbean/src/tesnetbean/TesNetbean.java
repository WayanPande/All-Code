/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesnetbean;

/**
 *
 * @author Togami
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Form {

    public String kocak;

    void input() {
        JFrame frame = new JFrame("Testing");

        JLabel title = new JLabel("Form Registrasi");
        title.setSize(300, 30);
        title.setLocation(350, 5);
        frame.add(title);

        JLabel nama = new JLabel("Nama");
        nama.setSize(100, 20);
        nama.setLocation(30, 100);
        frame.add(nama);

        JTextField tnama = new JTextField();
        tnama.setSize(100, 20);
        tnama.setLocation(100, 100);
        frame.add(tnama);

        JLabel alamat = new JLabel("Alamat");
        alamat.setSize(100, 20);
        alamat.setLocation(30, 130);
        frame.add(alamat);

        JTextField talamat = new JTextField();
        talamat.setSize(100, 20);
        talamat.setLocation(100, 130);
        frame.add(talamat);

        JTextArea area = new JTextArea();
        area.setBounds(250, 30, 300, 300);

        JButton tombol = new JButton("sini");
        tombol.setBounds(100, 200, 100, 30);

        tombol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data;

                data = "Nama: " + tnama.getText() + "\nAlamat: " + talamat.getText();
                area.setText(data);
                area.setEditable(false);
                kocak = tnama.getText();
                Login frame = new Login();
            }
        });

        frame.add(tombol);
        frame.add(area);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void form() {
        JFrame frame2 = new JFrame("LOJIK");
        frame2.setSize(600, 400);
        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame2.setVisible(true);
    }

}

class Cek {
    public String tes = "saya";
}

class Login extends Form {
    Login() {
        JFrame login = new JFrame("LOJIK");
        login.setSize(600, 400);
        login.setLayout(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField talamat = new JTextField();
        talamat.setSize(100, 20);
        talamat.setLocation(100, 130);
        login.add(talamat);

        login.setVisible(true);
        // Tombol registrasi
        JButton regis = new JButton("Registrasi");
        regis.setBounds(230, 200, 100, 30);
        login.add(regis);

        JButton masuk = new JButton("Login");
        masuk.setBounds(120, 200, 100, 30);
        login.add(masuk);

        regis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // login.dispose();
                Form frame = new Form();
                frame.input();
            }
        });
        masuk.addActionListener(this);
        
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == masuk) {
                    if (talamat.getText() == "saya") {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                }
                }

            }

    }
}

public class TesNetbean {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login frame = new Login();
    }
    
}
