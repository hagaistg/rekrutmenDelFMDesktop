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
public class ProgramController implements Initializable {

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void executeHQLQuery() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery("INSERT INTO program (namaprogram,penyiar,jadwal,deskripsi) VALUES (:namaproduk,:penyiarproduk,:jadwalproduk,:des)");
       
            q.setParameter("namaproduk", nama.getText());
            q.setParameter("penyiarproduk", penyiar.getText());
            q.setParameter("jadwalproduk", jadwal.getText());
            q.setParameter("des", desc.getText());
            
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
          if (nama.getText().equals("") || penyiar.getText().equals("") || jadwal.getText().equals("") || desc.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQuery();
            Alert alert = new Alert(Alert.AlertType.NONE, "Program Telah ditambahkan", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
              AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaProgram.fxml"));
            pane.getChildren().setAll(panes);
        }
         
    
    }
}
