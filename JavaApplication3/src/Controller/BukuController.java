/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author PC PRAKTIKUM
 */
import DAOBuku.DAOBuku;
import Model.ModelDataBuku;
import Model.ModelTabelBuku;
import view.inputFrame;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.*;
public class BukuController {
    private final inputFrame view;
    private final DAOBuku dao;

    public BukuController(inputFrame view) {
        this.view = view;
        dao = new DAOBuku();
    }

    public void insert(){
        if (view.getjTJudul().getText().trim().isEmpty() || view.getjTGenre().getText().trim().isEmpty() || view.getjTPenulis().getText().trim().isEmpty() || view.getjTPenerbit().getText().trim().isEmpty() || view.getjTLokasi().getText().trim().isEmpty() || view.getjTStock().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            return;
        }
        ModelDataBuku b = new ModelDataBuku();
        b.setJudulBuku(view.getjTJudul().getText());
        b.setGenreBuku(view.getjTGenre().getText());
        b.setPenulisBuku(view.getjTPenulis().getText());
        b.setPenerbitBuku(view.getjTPenerbit().getText());
        b.setLokasi(view.getjTLokasi().getText());
        try{
            b.setJumlahBuku(Integer.parseInt(view.getjTStock().getText()));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Jumlah Buku Harus Angka");
            return;
        }
        // System.out.println(b.getJudulBuku() + b.getGenreBuku() + b.getPenulisBuku() + b.getPenerbitBuku() + b.getLokasi() + b.getJumlahBuku());
        dao.insert(b);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
    }

    public void delete(){
        if (view.getjTID().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ID Tidak Boleh Kosong");
            return;
        }
        String id = view.getjTID().getText();
        dao.delete(id);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }

    public void update(){
        if (view.getjTID().getText().trim().isEmpty() || view.getjTJudul().getText().trim().isEmpty() || view.getjTGenre().getText().trim().isEmpty() || view.getjTPenulis().getText().trim().isEmpty() || view.getjTPenerbit().getText().trim().isEmpty() || view.getjTLokasi().getText().trim().isEmpty() || view.getjTStock().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            return;
        }
        ModelDataBuku b = new ModelDataBuku();
        b.setIdBuku(Integer.parseInt(view.getjTID().getText()));
        b.setJudulBuku(view.getjTJudul().getText());
        b.setGenreBuku(view.getjTGenre().getText());
        b.setPenulisBuku(view.getjTPenulis().getText());
        b.setPenerbitBuku(view.getjTPenerbit().getText());
        b.setLokasi(view.getjTLokasi().getText());
        try{
            b.setJumlahBuku(Integer.parseInt(view.getjTStock().getText()));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Jumlah Buku Harus Angka");
            return;
        }
        System.out.println(b.getJudulBuku() + b.getGenreBuku() + b.getPenulisBuku() + b.getPenerbitBuku() + b.getLokasi() + b.getJumlahBuku());
        dao.update(b);
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
    }

    public void fillTable(){
        List<ModelDataBuku> list = dao.getAll();
        ModelTabelBuku mtb = new ModelTabelBuku((ArrayList<ModelDataBuku>) list);
        view.getJTable1().setModel(mtb);
    }

    public void fillTableByID(int id){
        ModelDataBuku list = dao.getAll().stream()
                                    .filter(d -> d.getIdBuku() == id)
                                    .findFirst()
                                    .get();
        view.getjTID().setText(Integer.toString(list.getIdBuku()));
        view.getjTJudul().setText(list.getJudulBuku());
        view.getjTGenre().setText(list.getGenreBuku());
        view.getjTPenulis().setText(list.getPenulisBuku());
        view.getjTPenerbit().setText(list.getPenerbitBuku());
        view.getjTLokasi().setText(list.getLokasi());
        view.getjTStock().setText(Integer.toString(list.getJumlahBuku()));

    }

    public void cari(String KeyWord){
        if (KeyWord.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Keyword Tidak Boleh Kosong");
        }
        String filter = view.getComboBox1().getSelectedItem().toString();
        if (filter == "judul"){
            List<ModelDataBuku> list = dao.getAll().stream()
                                        .filter(d -> d.getJudulBuku().toLowerCase().contains(KeyWord.toLowerCase()))
                                        .collect(Collectors.toList());
            if (list.isEmpty()){
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            } else{
                ModelTabelBuku mtb = new ModelTabelBuku((ArrayList<ModelDataBuku>) list);
                view.getJTable1().setModel(mtb);
            }
        } else if (filter == "genre"){
            List<ModelDataBuku> list = dao.getAll().stream()
                                        .filter(d -> d.getGenreBuku().toLowerCase().contains(KeyWord.toLowerCase()))
                                        .collect(Collectors.toList());
            if (list.isEmpty()){
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            } else{
                ModelTabelBuku mtb = new ModelTabelBuku((ArrayList<ModelDataBuku>) list);
                view.getJTable1().setModel(mtb);
            }
        } else if (filter == "penulis"){
            List<ModelDataBuku> list = dao.getAll().stream()
                                        .filter(d -> d.getPenulisBuku().toLowerCase().contains(KeyWord.toLowerCase()))
                                        .collect(Collectors.toList());
            if (list.isEmpty()){
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            } else{
                ModelTabelBuku mtb = new ModelTabelBuku((ArrayList<ModelDataBuku>) list);
                view.getJTable1().setModel(mtb);
            }
        } else if (filter == "penerbit"){
            List<ModelDataBuku> list = dao.getAll().stream()
                                        .filter(d -> d.getPenerbitBuku().toLowerCase().contains(KeyWord.toLowerCase()))
                                        .collect(Collectors.toList());
            if (list.isEmpty()){
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            } else{
                ModelTabelBuku mtb = new ModelTabelBuku((ArrayList<ModelDataBuku>) list);
                view.getJTable1().setModel(mtb);
            }
        
        }
        
    }
}
