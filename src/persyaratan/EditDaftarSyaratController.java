/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persyaratan;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Sondang;
 */
public class EditDaftarSyaratController implements Initializable {

    @FXML
    AnchorPane panes;
    @FXML
    private TextField nama;
    @FXML
    private TextArea desc;
    @FXML
    private Button simpan;
    public static Integer id2;
    public static String nama2;
    public static String deskripsi2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       addData();
    }    

    @FXML
    private void simpanAction(ActionEvent event) throws IOException {
         if (nama.getText().equals("") ||desc.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryUpdate();
            Alert alert = new Alert(Alert.AlertType.NONE, "Daftar syarat Telah diUpdate", ButtonType.OK);
            alert.setTitle("Berhasil");
            alert.showAndWait();
            AnchorPane paness = FXMLLoader.load(getClass().getResource("/persyaratan/kelolaPersyaratan.fxml"));
            panes.getChildren().setAll(paness);
        }
        
    }

    private void executeHQLQueryUpdate() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("UPDATE syarat SET nama = :namaproduk, deskripsi =:tgl Where id = :id");
         //String Query = "UPDATE produklist SET buku = '"+nbuku+"',harga = '"+nharga+"',pengarang = '"+npengarang+"',jumlah = '"+njumlah+"' WHERE id = '"+id2+"'";
            q.setParameter("namaproduk", nama.getText());
            q.setParameter("tgl", desc.getText());
            q.setParameter("id", id2);
            q.executeUpdate();
            
            session.getTransaction().commit();
            
            session.close();
            
            //pindah();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addData() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.id2 = KelolaPersyaratanController.id2;
    this.nama2 = KelolaPersyaratanController.nama2;
    this.deskripsi2 = KelolaPersyaratanController.deskripsi2;
    nama.setText(nama2);
    desc.setText(deskripsi2);
    }
    }

   
    

