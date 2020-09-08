/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Berita;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Hagai Stg
 */
public class KelolaBeritaUserController implements Initializable {
    
    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<Berita> ttable;

    @FXML
    private TableColumn tno;

    @FXML
    private TableColumn tjudul;

    @FXML
    private TableColumn ttopik;

    @FXML
    private TableColumn ttanggal;

    @FXML
    private TableColumn tdeskripsi;


    @FXML
    private Button detail;

    
    ObservableList<Berita> tableData = null;
    public static Integer id2;
    public static String judul2;
    public static String topik2;
    public static String tanggal2;
    public static String deskripsi2;
    @FXML
    private Button kembali;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tampil();
        // TODO
    }    
    public void tampil(){
        displayList();
    }
    private void displayList(){
       tableData = FXCollections.observableArrayList();
         
         ModelBerita mm = new ModelBerita();

        for (Berita m : mm.findAll()) {
            tableData.add(m);
        }
        tno.setCellValueFactory(new PropertyValueFactory<>("id"));
        tjudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        ttopik.setCellValueFactory(new PropertyValueFactory<>("topik"));
        ttanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        tdeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));

        //tabelview.getColumns().clear();
        ttable.setItems(tableData);
        //tabelview.getColumns().addAll(nomor,nama,hargaas,tanggal); 
        ttable.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                onClick();
            }
            
        });
    }
    public void onClick(){
        if(ttable.getSelectionModel().getSelectedItem() != null){
           Berita barangSelect = ttable.getSelectionModel().getSelectedItem();
           this.id2 = (barangSelect.getId());
           this.judul2 = barangSelect.getJudul();
           this.topik2 = barangSelect.getTopik();
           this.tanggal2 = barangSelect.getTanggal();
           this.deskripsi2 = barangSelect.getDeskripsi();
           
        }
    

    }

    @FXML
    void detailAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/DetailBeritaUser.fxml"));
        pane.getChildren().setAll(panes);
    }

    void editAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/EditBerita.fxml"));
            pane.getChildren().setAll(panes);
    }

    void hapusAction(ActionEvent event) {
        if(id2 == -1) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Daftar Wisata Tidak dipilih", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryDelete();
            Alert alert = new Alert(Alert.AlertType.NONE, "Daftar Wisata Telah diHapus", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
        }
         tampil();
    }

    void tambahAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/TambahBerita.fxml"));
            pane.getChildren().setAll(panes);
    }
    private void executeHQLQueryDelete() {
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("DELETE FROM berita WHERE id = :id");
         //String Query = "UPDATE produklist SET buku = '"+nbuku+"',harga = '"+nharga+"',pengarang = '"+npengarang+"',jumlah = '"+njumlah+"' WHERE id = '"+id2+"'";
//            q.setParameter("namaproduk", namaProduk.getText());
//            
//            q.setParameter("hargaproduk", hargaProduk.getText());
//            q.setParameter("tgl", tglMasuk.getText());
           q.setParameter("id", id2);
            q.executeUpdate();
            
            session.getTransaction().commit();
            
            session.close();
            
            //pindah();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
        pane.getChildren().setAll(panes);
    }

    
}

