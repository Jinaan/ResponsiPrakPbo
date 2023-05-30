package Model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabelBuku extends AbstractTableModel{
    private ArrayList<ModelDataBuku> listBuku;

    public ModelTabelBuku(ArrayList<ModelDataBuku> listBuku) {
        this.listBuku = listBuku;
    }

    public int getRowCount() {
        return listBuku.size();
    }

    public int getColumnCount() {
        return 7;
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "judul";
            case 2:
                return "genre";
            case 3:
                return "penulis";
            case 4:
                return "penerbit";
            case 5:
                return "lokasi";
            case 6:
                return "stock";
            default:
                return null;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listBuku.get(rowIndex).getIdBuku();
            case 1:
                return listBuku.get(rowIndex).getJudulBuku();
            case 2:
                return listBuku.get(rowIndex).getGenreBuku();
            case 3:
                return listBuku.get(rowIndex).getPenulisBuku();
            case 4:
                return listBuku.get(rowIndex).getPenerbitBuku();
            case 5:
                return listBuku.get(rowIndex).getLokasi();
            case 6:
                return listBuku.get(rowIndex).getJumlahBuku();
            default:
                return null;
        }
    }
}
