/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterfaceBuku;

/**
 *
 * @author PC PRAKTIKUM
 */
import Model.ModelDataBuku;
import java.util.List;
public interface DAOImplBuku {
    public void insert(ModelDataBuku b);
    public void update(ModelDataBuku b);
    public void delete(String id);
    public List<ModelDataBuku> getAll();
}
