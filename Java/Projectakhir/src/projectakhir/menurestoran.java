package projectakhir;
import java.sql.*;
import javax.swing.*;

public class menurestoran {
    Statement st;
    ResultSet rs;
    
    String noordr,menurt,tgl;
    long harga,total=0,subtotal,bayar,jumbel,kembali;
    
    public menurestoran(){
        Connection c = KonekMYSQL.getKoneksi();
    }
    
    public long getHarga(){
        return harga;
    }
    
    public void setHrga(long harga){
        this.harga=harga;
    }
    
    public long getjumbel(){
        return jumbel;
    }
    
    public void setjumbel(long jumbel){
        this.jumbel=jumbel;
    }
    
    public long getsubtotal(){
        subtotal=harga*jumbel;
        return subtotal;
    }
    
    public void setsubtotal(long subtotal){
        this.subtotal=subtotal;
    }
    
    public long gettotal(){
        total=subtotal+total;
        return total;
    }
    
    public long getbayar(){
        return bayar;
    }
    
    public void setbayar(long bayar){
        this.bayar=bayar;
    }
    
    public long getkembali(){
        kembali=bayar-total;
        return kembali;
    }
    
    public void setkembali(long kembali){
        this.kembali=kembali;
    }
    
    public void settotal(long total){
        this.total=total;
    }
    public String getmenurt(){
        return menurt;
    }
    
    public void setmenurt(String menurt){
        this.menurt=menurt;
    }
    
    public String getnoordr(){
        return noordr;
    }
    
    public void setnoordr(String noordr){
        this.noordr=noordr;
    }
    
    public String gettgl(){
        return tgl;
    }
    
    public void settgl(String tgl){
        this.tgl=tgl;
    }
    
    void hapusgrid(){
        try{
            Connection c = KonekMYSQL.getKoneksi();
            st = c.createStatement();
            st.executeUpdate("DELETE FROM `sementara_men`");
            JOptionPane.showMessageDialog(null, "Berhasil hapus grid");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal hapus grid");
        }
    }
    
    void simpansementara(){
        try{
            Connection c = KonekMYSQL.getKoneksi();
            st = c.createStatement();
            st.executeUpdate("INSERT INTO `sementara_men`(`nama_menu`, `harga`, `jumbel`, `subtotal`) VALUES ('"+this.menurt+"','"+this.harga+"','"+this.jumbel+"', '"+this.subtotal+"');");
            JOptionPane.showMessageDialog(null, "Disimpan");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan");
        }
    }
    
    void simpandetail(){
        try{
            Connection c = KonekMYSQL.getKoneksi();
            st = c.createStatement();
            st.executeUpdate("INSERT INTO `detail_menu`(`no_order`, `nama_menu`, `jumbel`, `subtotal`) VALUES ('"+this.noordr+"','"+this.menurt+"','"+this.jumbel+"','"+this.subtotal+"')");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan");
        }
    }
    
    void simpantransaksi(){
        try{
            Connection c = KonekMYSQL.getKoneksi();
            st = c.createStatement();
            st.executeUpdate("INSERT INTO `transaksi_menu`(`no_order`, `tanggal`, `total`) VALUES ('"+this.noordr+"','"+this.tgl+"','"+this.total+"')");
            JOptionPane.showMessageDialog(null, "Data sudah tersimpan");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal disimpan");
        }
    }
}
