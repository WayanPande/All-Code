import java.util.Scanner;
import pack.*;
import lojik.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static Connection con;
    public static Statement stm;

    public static void main(String[] args) throws Exception {

        getWord("orange");

        // try {
        // Connection myConn =
        // DriverManager.getConnection("jdbc:mysql://localhost/datamhs", "root", "");

        // Statement myStmt = myConn.createStatement();

        // ResultSet myRs = myStmt.executeQuery("SELECT * FROM mahasiswa");

        // while (myRs.next()) {
        // System.out.println(myRs.getString("nama"));
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        try {
            String url = "jdbc:mysql://localhost/ci4";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
    }

    public static void getWord(String awal) {

        int temp = 0;
        char[] a = awal.toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    temp++;
                }
            }
            if (temp > 1) {
                System.out.println("true");
                break;
            }
            temp = 0;
        }
        if (temp < 2) {
            System.out.println("false");
        }
    }
}
