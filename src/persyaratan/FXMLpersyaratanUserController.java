/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persyaratan;

import entitiy.Syarat;
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
 * @author Sondang;
 */
public class FXMLpersyaratanUserController implements Initializable {

    @FXML
    AnchorPane panes;
    @FXML
    private TableView<Syarat> tabelview;
    @FXML
    private TableColumn nomor;
    @FXML
    private TableColumn nama;
    @FXML
    private TableColumn deskripsi;
    @FXML
    private Button detail;
     @FXML
    private Button kembali;
    ObservableList<Syarat> tableData = null;
    public static Integer id2;
    public static String nama2;
    public static String deskripsi2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tampil();
    }    
  public void tampil(){
        displayList();
    }
     
    private void displayList(){
       tableData = FXCollections.observableArrayList();
         
         ModelSyarat mm = new ModelSyarat();

        for (Syarat m : mm.findAll()) {
            tableData.add(m);
        }
        nomor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        

        //tabelview.getColumns().clear();
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
           Syarat barangSelect = tabelview.getSelectionModel().getSelectedItem();
           this.id2 = (barangSelect.getId());
           this.nama2 = barangSelect.getNama();
         
           this.deskripsi2 = barangSelect.getDeskripsi();
           
        }
    

    }
    @FXML
    private void tambahAction(ActionEvent event) throws IOException {
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/persyaratan/FXMLSyarat.fxml"));
            panes.getChildren().setAll(paness);
    }

    @FXML
    private void editAction(ActionEvent event) throws IOException {
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/persyaratan/EditDaftarSyarat.fxml"));
            panes.getChildren().setAll(paness);
    }
     private void executeHQLQueryDelete() {
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("DELETE FROM syarat WHERE id = :id");
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
            Alert alert = new Alert(Alert.AlertType.NONE, "Daftar Syarat Tidak dipilih", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryDelete();
            Alert alert = new Alert(Alert.AlertType.NONE, "Daftar Syarat Telah diHapus", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
        }
         tampil();
    }

        
    
    @FXML
    private void detailAction(ActionEvent event) throws IOException {
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/persyaratan/DetailSyaratUser.fxml"));
            panes.getChildren().setAll(paness);
    }

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            panes.getChildren().setAll(paness);
    }
    
}
