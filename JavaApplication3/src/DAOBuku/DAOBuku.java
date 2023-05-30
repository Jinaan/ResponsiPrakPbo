/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOBuku;

/**
 *
 * @author PC PRAKTIKUM
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koneksi.Koneksi;
import Model.ModelDataBuku;
public class DAOBuku implements DAOInterfaceBuku.DAOImplBuku{
    Connection con = Koneksi.connection();

    @Override
    public void insert(ModelDataBuku b) {
        String sql = "INSERT INTO dataperpus (judul,genre,penulis,penerbit,lokasi,stock) VALUES (?,?,?,?,?,?);";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getJudulBuku());
            ps.setString(2, b.getGenreBuku());
            ps.setString(3, b.getPenulisBuku());
            ps.setString(4, b.getPenerbitBuku());
            ps.setString(5, b.getLokasi());
            ps.setInt(6, b.getJumlahBuku());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ModelDataBuku b) {
        String sql = "UPDATE dataperpus SET judul=?,genre=?,penulis=?,penerbit=?,lokasi=?,stock=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getJudulBuku());
            ps.setString(2, b.getGenreBuku());
            ps.setString(3, b.getPenulisBuku());
            ps.setString(4, b.getPenerbitBuku());
            ps.setString(5, b.getLokasi());
            ps.setInt(6, b.getJumlahBuku());
            ps.setInt(7, b.getIdBuku());
            System.out.println();
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM dataperpus WHERE id=?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelDataBuku> getAll() {
        List<ModelDataBuku> lb = new ArrayList<>();
        String sql = "SELECT * FROM dataperpus;";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ModelDataBuku b = new ModelDataBuku();
                b.setIdBuku(rs.getInt(1));
                b.setJudulBuku(rs.getString(2));
                b.setGenreBuku(rs.getString(3));
                b.setPenulisBuku(rs.getString(4));
                b.setPenerbitBuku(rs.getString(5));
                b.setLokasi(rs.getString(6));
                b.setJumlahBuku(rs.getInt(7));
                lb.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lb;
    }

}
