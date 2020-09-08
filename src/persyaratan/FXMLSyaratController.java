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
public class FXMLSyaratController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField nama;
    @FXML
    private TextArea desc;
    @FXML
    private Button simpan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void SimpanAction(ActionEvent event) throws IOException {
          if (nama.getText().equals("") || desc.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
            executeHQLQuery();
            Alert alert = new Alert(Alert.AlertType.NONE, "Daftar Syarat Telah ditambahkan", ButtonType.OK);
            alert.setTitle("Berhasil");
             alert.showAndWait();
              AnchorPane panes = FXMLLoader.load(getClass().getResource("/persyaratan/kelolaPersyaratan.fxml"));
            pane.getChildren().setAll(panes);
        }
         
    
    }

    private void executeHQLQuery() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery("INSERT INTO syarat (nama,deskripsi) VALUES (:namaproduk,:hargaproduk)");
       
            q.setParameter("namaproduk", nama.getText());
            
         
            q.setParameter("hargaproduk", desc.getText());
            
            q.executeUpdate();
            
            session.getTransaction().commit();
            
            session.close();
            
            //pindah();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
    
    

