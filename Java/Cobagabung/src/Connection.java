/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Togami
 */



import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    static java.sql.Connection koneksi;
    public static java.sql.Connection getKoneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306/datamhs";
            String user = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, password);
        }catch (SQLException t){
            System.out.println("Error membuat koneksi");
        }
        return koneksi;
    }
}
