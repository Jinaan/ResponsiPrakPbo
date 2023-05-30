/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author PC PRAKTIKUM
 */
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Koneksi {
    static Connection con;

    public static Connection connection() {
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("perpustakaan");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("koneksi Berhasil");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
