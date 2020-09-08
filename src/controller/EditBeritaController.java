/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Hagai Stg
 */
public class EditBeritaController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField topik;

    @FXML
    private TextField tanggal;

    @FXML
    private TextField deskripsi;

    @FXML
    private TextField judul;

    @FXML
    private Button simpan;

    public static Integer id2;
    public static String judul2;
    public static String topik2;
    public static String tanggal2;
    public static String deskripsi2;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addData();
    }    
      public void addData(){
        this.id2 = KelolaBeritaController.id2;
        this.judul2 = KelolaBeritaController.judul2;
        this.topik2 = KelolaBeritaController.topik2;
        this.tanggal2 = KelolaBeritaController.tanggal2;
        this.deskripsi2 = KelolaBeritaController.deskripsi2;
        
        
        judul.setText(judul2);
        topik.setText(topik2);
        tanggal.setText(tanggal2);
        deskripsi.setText(deskripsi2);
        
        
    }
     private void executeHQLQueryUpdate() {
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("UPDATE berita SET judul = :namaproduk, topik = :hargaproduk , tanggal = :produk,deskripsi =:tgl Where id = :id");
         //String Query = "UPDATE produklist SET buku = '"+nbuku+"',harga = '"+nharga+"',pengarang = '"+npengarang+"',jumlah = '"+njumlah+"' WHERE id = '"+id2+"'";
            q.setParameter("namaproduk", judul.getText());
            
            q.setParameter("hargaproduk", topik.getText());
            q.setParameter("produk", tanggal.getText());
            q.setParameter("tgl", deskripsi.getText());
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
    private void simpanAction(ActionEvent event) throws IOException {
        if (judul.getText().equals("") || topik.getText().equals("")|| tanggal.getText().equals("")|| deskripsi.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryUpdate();
            Alert alert = new Alert(Alert.AlertType.NONE, "Data Berita Telah diUpdate", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
              AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaBerita.fxml"));
            pane.getChildren().setAll(panes);
        }
        
    }
     
    
}
