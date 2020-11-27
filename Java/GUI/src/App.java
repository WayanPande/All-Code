import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Form {

    void input() {
        // Window isi form
        JFrame frame = new JFrame("Form");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Title form registrasi
        JLabel title = new JLabel("Form Registrasi");
        title.setBounds(190, 5, 300, 30);
        frame.add(title);

        // Label nama
        JLabel nama = new JLabel("Nama");
        nama.setBounds(30, 60, 100, 20);
        frame.add(nama);

        // Text field untuk nama
        JTextField tnama = new JTextField();
        tnama.setBounds(150, 60, 200, 20);
        frame.add(tnama);

        // Label alamat
        JLabel alamat = new JLabel("Alamat");
        alamat.setBounds(30, 90, 100, 20);
        frame.add(alamat);

        // Text field alamat
        JTextField talamat = new JTextField();
        talamat.setBounds(150, 90, 200, 20);
        frame.add(talamat);

        // Label Usia
        JLabel usia = new JLabel("Usia");
        usia.setBounds(30, 120, 100, 20);
        frame.add(usia);

        // Text field untuk nama
        JTextField tusia = new JTextField();
        tusia.setBounds(150, 120, 200, 20);
        frame.add(tusia);

        // Label Username
        JLabel username = new JLabel("Username");
        username.setBounds(30, 150, 100, 20);
        frame.add(username);

        // Text field untuk username
        JTextField tusername = new JTextField();
        tusername.setBounds(150, 150, 200, 20);
        frame.add(tusername);

        // Label password
        JLabel password = new JLabel("Password");
        password.setBounds(30, 180, 100, 20);
        frame.add(password);

        // Text field password
        JPasswordField tpassword = new JPasswordField();
        tpassword.setBounds(150, 180, 200, 20);
        frame.add(tpassword);

        // Label retype password
        JLabel Repassword = new JLabel("Retype Password");
        Repassword.setBounds(30, 210, 100, 20);
        frame.add(Repassword);

        // Text field retype password
        JPasswordField tRepassword = new JPasswordField();
        tRepassword.setBounds(150, 210, 200, 20);
        frame.add(tRepassword);

        // Label term & condition
        JCheckBox term = new JCheckBox("Accept privacy policy and terms", false);
        term.setBounds(150, 240, 300, 30);
        frame.add(term);

        // Tombol Submit
        JButton tombol = new JButton("REGISTER");
        tombol.setBounds(40, 280, 400, 30);
        frame.add(tombol);

        // Tombol Login
        JButton tLogin = new JButton("Login");
        tLogin.setBounds(190, 330, 100, 30);
        frame.add(tLogin);

        // Fungsi ketika tombol login ditekan
        tLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(tusername.getText(), tpassword.getText());
                frame.dispose();
            }
        });

        // Fungsi ketika tombol register ditekan
        tombol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // mengecek apakah privacy policy sudah dipilih
                if (term.isSelected()) {
                    FormRegistrasi tes = new FormRegistrasi(tnama.getText(), talamat.getText(), tusia.getText());
                } else {
                    JFrame notif = new JFrame();
                    JOptionPane.showMessageDialog(notif, "You need to accept our privacy policy and terms");
                }
            }
        });
    }
}

class SelamatDatang {

}

class FormRegistrasi {
    FormRegistrasi(String nama, String alamat, String usia) {
        // Window untuk tampilan data form
        JFrame frame = new JFrame("Form");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Label
        JLabel title = new JLabel("Form Registrasi");
        title.setSize(300, 30);
        title.setLocation(350, 5);
        frame.add(title);

        // Text area untuk menampilkan data registrasi
        JTextArea area = new JTextArea();
        area.setBounds(0, 0, 500, 500);
        area.setEditable(false);
        frame.add(area);

        // Menampilkan data registrasi
        String data;
        data = "Nama: " + nama + "\nAlamat: " + alamat + "\nUsia: " + usia;
        area.setText(data);

    }
}

class Login {
    Login() {
        JFrame login = new JFrame("LOJIK");
        login.setSize(400, 400);
        login.setLayout(null);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("LOGIN FORM");
        title.setBounds(140, 5, 300, 30);
        title.setFont(new Font("verdana", Font.PLAIN, 18));
        login.add(title);

        JTextField username = new JTextField();
        username.setBounds(45, 70, 300, 40);
        username.setFont(new Font("verdana", Font.PLAIN, 18));
        login.add(username);

        JLabel tUsername = new JLabel("Username");
        tUsername.setBounds(45, 50, 70, 15);
        login.add(tUsername);

        JPasswordField password = new JPasswordField();
        password.setBounds(45, 140, 300, 40);
        password.setFont(new Font("verdana", Font.PLAIN, 18));
        login.add(password);

        JLabel tPassword = new JLabel("Password");
        tPassword.setBounds(45, 120, 70, 15);
        login.add(tPassword);

        // Tombol registrasi
        JButton regis = new JButton("Registrasi");
        regis.setBounds(45, 330, 300, 30);
        login.add(regis);

        JButton masuk = new JButton("Login");
        masuk.setBounds(45, 280, 300, 30);
        login.add(masuk);

        regis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.dispose();
                Form frame = new Form();
                frame.input();
            }
        });

        masuk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame notif = new JFrame();
                if (username.getText().equals("root")) {
                    if (password.getText().equals("root")) {
                        JOptionPane.showMessageDialog(notif, "Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(notif, "Password salah");
                    }
                } else {
                    if (password.getText().equals("root")) {
                        JOptionPane.showMessageDialog(notif, "Username salah");
                    } else {
                        JOptionPane.showMessageDialog(notif, "Username dan Password salah");
                    }
                }
            }
        });
        login.setVisible(true);
    }

    Login(String userName, String passWord) {
        System.out.println(userName);
        JFrame login = new JFrame("LOJIK");
        login.setSize(400, 400);
        login.setLayout(null);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);

        JLabel title = new JLabel("LOGIN FORM");
        title.setBounds(160, 5, 300, 30);
        title.setFont(new Font("verdana", Font.PLAIN, 18));
        login.add(title);

        JTextField username = new JTextField();
        username.setBounds(45, 70, 300, 40);
        username.setFont(new Font("verdana", Font.PLAIN, 18));
        login.add(username);

        JLabel tUsername = new JLabel("Username");
        tUsername.setBounds(45, 50, 70, 15);
        login.add(tUsername);

        JPasswordField password = new JPasswordField();
        password.setBounds(45, 140, 300, 40);
        password.setFont(new Font("verdana", Font.PLAIN, 18));
        login.add(password);

        JLabel tPassword = new JLabel("Password");
        tPassword.setBounds(45, 120, 70, 15);
        login.add(tPassword);

        // Tombol registrasi
        JButton regis = new JButton("Registrasi");
        regis.setBounds(45, 330, 300, 30);
        login.add(regis);

        JButton masuk = new JButton("Login");
        masuk.setBounds(45, 280, 300, 30);
        login.add(masuk);

        // cek tombol registrasi ditekan, masuk ke form login
        regis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.dispose();
                Form frame = new Form();
                frame.input();
            }
        });

        // cek tombol login ditekan dan cek username
        masuk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame notif = new JFrame();
                if (username.getText().equals(userName)) {
                    if (password.getText().equals(passWord)) {
                        JOptionPane.showMessageDialog(notif, "Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(notif, "Password salah");
                    }
                } else {
                    if (password.getText().equals(passWord)) {
                        JOptionPane.showMessageDialog(notif, "Username salah");
                    } else {
                        JOptionPane.showMessageDialog(notif, "Username dan Password salah");
                    }
                }
            }
        });

    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Login frame = new Login();
    }
}
