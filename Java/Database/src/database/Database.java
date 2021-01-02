/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Togami
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    
    static Connection koneksi;
    public static Connection getKoneksi() {
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
    
    public static void loadData(){
        try{
            Connection c = getKoneksi(); 
            Statement s = c.createStatement();
            String sql = "SELECT * FROM mahasiswa";
            ResultSet r = s.executeQuery(sql);
            while(r.next()){
                System.out.println( r.getString("nim"));
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println("terjadi error");
        }
    }
    
    
    
     
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        loadData();
    }
    
}
