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
public class TambahBeritaController implements Initializable {
    
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


    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void executeHQLQuery() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery("INSERT INTO berita (judul,topik,tanggal,deskripsi) VALUES (:namaproduk,:hargaproduk,:harga,:tgl)");
       
            q.setParameter("namaproduk", judul.getText());
            
            q.setParameter("hargaproduk", topik.getText());
            
            q.setParameter("harga", tanggal.getText());
            q.setParameter("tgl", deskripsi.getText());
            
            q.executeUpdate();
            
            session.getTransaction().commit();
            
            session.close();
            
            //pindah();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void SimpanAction(ActionEvent event) throws IOException {
          if (judul.getText().equals("") || topik.getText().equals("") || tanggal.getText().equals("")|| deskripsi.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQuery();
            Alert alert = new Alert(Alert.AlertType.NONE, "Data Berita Telah ditambahkan", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
              AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaBerita.fxml"));
            pane.getChildren().setAll(panes);
        }
         
    
    }
    
    
}
