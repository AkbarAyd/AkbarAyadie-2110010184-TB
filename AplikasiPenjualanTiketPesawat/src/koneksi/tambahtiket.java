/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class tambahtiket {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    
    private String sql;
    
    public String nama;
    public String maskapai;
    public String tujuan;
    public String kelas;
    public String tanggal;
    public String jumlahtiket;
    public String harga;
    
    
    public void simpan()throws SQLException{
        conn = koneksi.Connect();
        sql = "INSERT INTO pemesanan(nama,maskapai,tujuan,kelas,tanggal,harga,jumlah)VALUES(?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, nama);
        ps.setString(2, maskapai);
        ps.setString(3, tujuan);  //koding untuk tambah data ke database
        ps.setString(4, kelas);
        ps.setString(5, tanggal);
        ps.setString(6, harga);
        ps.setString(7, jumlahtiket);
        ps.execute();
        ps.close();
        
    }
     
      public void edit()throws SQLException{
        conn = koneksi.Connect();
        sql = "UPDATE pemesanan set maskapai=?,tujuan=?,kelas=?,tanggal=?, harga=?,jumlah=? where nama=?";
        ps = conn.prepareStatement(sql);
        
        ps.setString(1, maskapai);
        ps.setString(2, tujuan);  //koding untuk tambah data ke database
        ps.setString(3, kelas);
        ps.setString(4, tanggal);
        ps.setString(5, harga);
        ps.setString(6, jumlahtiket);
        ps.setString(7, nama);
        ps.executeUpdate();
        ps.close();
        
    }

      
      public void hapus()throws SQLException{
       conn = koneksi.Connect();
       String sql = "DELETE from pemesanan where nama=?";
       try{
        ps = conn.prepareStatement(sql);  //koding untuk  hapus data ke database
        ps.setString(1, nama);
        ps.execute();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
      
      public ResultSet TableUpdate()throws SQLException {
       conn = koneksi.Connect();
       sql = "select nama,maskapai,tujuan,kelas,tanggal,harga,jumlah from pemesanan";
       ps = conn.prepareStatement(sql); 
       rs = ps.executeQuery();  //koding untuk menampilkan data dari database ke tabel
       return rs;
    }
    
}
