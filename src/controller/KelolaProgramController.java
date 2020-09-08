/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Program;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
//import koneksi.koneksi;
//import interfaces.interProgram;
import entitiy.Program;
//import implement.implProgram;
/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class KelolaProgramController implements Initializable {
    
      @FXML
    private AnchorPane pane;

    @FXML
    private Label aplikasi;

    @FXML
    private TableView<Program> tabelview;

    @FXML
    private TableColumn nomor;

    @FXML
    private TableColumn nama;

    @FXML
    private TableColumn penyiar;

    @FXML
    private TableColumn jadwal;
//    @FXML
//    private TextField txtCari;
    

    @FXML
    private TableColumn deskripsi;

    @FXML
    private Button tambah;

    @FXML
    private Button edit;

    @FXML
    private Button hapus;

    @FXML
    private Button detail;

    @FXML
    private Button simpan;

    @FXML
    private Button keluar;
    
    ObservableList<Program> tableData;
//    interProgram crudData = new implProgram();
    public static Integer id2;
    public static String nama2;
    public static String penyiar2;
    public static String jadwal2;
    public static String deskripsi2;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tampil();
    }  
    
    public void tampil(){
        displayList();
    }
    
    private void displayList(){     
        tableData = FXCollections.observableArrayList();
         Model mm = new Model();
        for (Program m : mm.findAll()) {
            tableData.add(m);
        }
        nomor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("namaprogram"));
        penyiar.setCellValueFactory(new PropertyValueFactory<>("penyiar"));
        jadwal.setCellValueFactory(new PropertyValueFactory<>("jadwal"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        

//        tabelview.getColumns().clear();
        tabelview.setItems(tableData);
        //tabelview.getColumns().addAll(nomor,nama,hargaas,tanggal); 
        tabelview.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                onClick();
            }
            
        });
    }
    
    public void onClick(){
        if(tabelview.getSelectionModel().getSelectedItem() != null){
           Program barangSelect = (Program) tabelview.getSelectionModel().getSelectedItem();
           this.id2 = (barangSelect.getId());
           this.nama2 = barangSelect.getNamaprogram();
           this.penyiar2 = barangSelect.getPenyiar();
           this.jadwal2 = barangSelect.getJadwal();
           this.deskripsi2 = barangSelect.getDeskripsi();
           
        }
    

    }
    @FXML
    private void tambahAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/Program.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void editAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/ProgramEdit.fxml"));
            pane.getChildren().setAll(panes);
    }
    
    private void executeHQLQueryDelete() {
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("DELETE FROM program WHERE id = :id");
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
    private void hapusAction(ActionEvent event) {
         if(id2 == -1) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Program Tidak dipilih", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryDelete();
            Alert alert = new Alert(Alert.AlertType.NONE, "Program Telah diHapus", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
        }
         tampil();
    }
    
    @FXML
    private void detailAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/ProgramDeskripsi.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaAdmin.fxml"));
            pane.getChildren().setAll(panes);
    }
//    @FXML
//    private void aksiCari(KeyEvent event) {
//        tableData = crudData.likeByNama(txtCari.getText());
//        tabelview.setItems(tableData);
//    }
    @FXML
    private void keluarAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
   
    
   

    
}
