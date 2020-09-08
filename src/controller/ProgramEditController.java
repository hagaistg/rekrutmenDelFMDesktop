/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ProgramDeskripsiController.deskripsi2;
import static controller.ProgramDeskripsiController.jadwal2;
import static controller.ProgramDeskripsiController.nama2;
import static controller.ProgramDeskripsiController.penyiar2;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class ProgramEditController implements Initializable {
    
    
    
    @FXML
    private AnchorPane pane;
    @FXML
    private TextField penyiar;

    @FXML
    private TextField jadwal;

    @FXML
    private TextArea desc;

    @FXML
    private TextField nama;

    @FXML
    private Label aplikasi;

    @FXML
    private Button simpan;
    
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
         addData();
    }

public void addData(){
         this.id2 = KelolaProgramController.id2;
        this.nama2 = KelolaProgramController.nama2;
        this.penyiar2 = KelolaProgramController.penyiar2;
        this.jadwal2 = KelolaProgramController.jadwal2;
        this.deskripsi2 = KelolaProgramController.deskripsi2;
        
        
        nama.setText(nama2);
        penyiar.setText(penyiar2);
        jadwal.setText(jadwal2);
        desc.setText(deskripsi2);
        
        
        
    }
     private void executeHQLQueryUpdate() {
      try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery ("UPDATE program SET namaprogram = :namaproduk, penyiar = :penyiarproduk, jadwal = :jadwalproduk ,deskripsi =:des Where id = :id");
         //String Query = "UPDATE produklist SET buku = '"+nbuku+"',harga = '"+nharga+"',pengarang = '"+npengarang+"',jumlah = '"+njumlah+"' WHERE id = '"+id2+"'";
            q.setParameter("namaproduk", nama.getText());
            q.setParameter("penyiarproduk", penyiar.getText());
            q.setParameter("jadwalproduk", jadwal.getText());
            q.setParameter("des", desc.getText());
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
        if (nama.getText().equals("") || penyiar.getText().equals("") || jadwal.getText().equals("") || desc.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQueryUpdate();
            Alert alert = new Alert(Alert.AlertType.NONE, "Program Telah diUpdate", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
              AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaProgram.fxml"));
            pane.getChildren().setAll(panes);
        }
        
    }    
    
}
