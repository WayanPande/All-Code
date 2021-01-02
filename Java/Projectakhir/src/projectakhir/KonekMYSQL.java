package projectakhir;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KonekMYSQL {
    static Connection koneksi;
    public static Connection getKoneksi(){
        try{
            String url = "jdbc:mysql://localhost/hotel";
            String user = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, password);
        }catch(SQLException t){
            JOptionPane.showMessageDialog(null, "Error membuat koneksi");
        }
        return koneksi;
    }   
}
