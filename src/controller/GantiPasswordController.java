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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import static persyaratan.EditDaftarSyaratController.deskripsi2;
import static persyaratan.EditDaftarSyaratController.id2;
import static persyaratan.EditDaftarSyaratController.nama2;
import persyaratan.KelolaPersyaratanController;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class GantiPasswordController implements Initializable {

    @FXML
    private AnchorPane login;
    @FXML
    private Label loginpengguna;
    @FXML
    private TextField passlama;
    @FXML
    private TextField passbaru;
    @FXML
    private Button buttonlogin;
    @FXML
    private Button daftar;
    @FXML
    private Button kembali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
         if (passlama.getText().equals("") ||passbaru.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryUpdate();
            Alert alert = new Alert(Alert.AlertType.NONE, "Anda Telah Mengubah Password Anda", ButtonType.OK);
            alert.setTitle("Berhasil");
            alert.showAndWait();
            AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            login.getChildren().setAll(paness);
        }
        
    }

    private void executeHQLQueryUpdate() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("UPDATE User SET password = :namaproduk Where username = :username");
         //String Query = "UPDATE produklist SET buku = '"+nbuku+"',harga = '"+nharga+"',pengarang = '"+npengarang+"',jumlah = '"+njumlah+"' WHERE id = '"+id2+"'";
            q.setParameter("username", passlama.getText());  
            q.setParameter("namaproduk", passbaru.getText());
         
            q.executeUpdate();
            
            session.getTransaction().commit();
            
            session.close();
            
            //pindah();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 

    @FXML
    private void daftarAction(ActionEvent event) {
        passbaru.clear();
        passlama.clear();
    }

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            login.getChildren().setAll(paness);
    }
    
}
