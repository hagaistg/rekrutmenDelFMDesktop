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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class DetailSyaratUserController implements Initializable {

 
    @FXML
    private AnchorPane panes;
    @FXML
    private Label nama;
    @FXML
    private Label deskripsi;
    @FXML
    private Button kembali;
     public static Integer id2;
    public static String nama2;
    public static String deskripsi2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         addData();
    }    

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
              AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
           panes.getChildren().setAll(paness);
    }

    private void addData() {
        this.id2 = FXMLpersyaratanUserController.id2;
        this.nama2 = FXMLpersyaratanUserController.nama2;
        this.deskripsi2 = FXMLpersyaratanUserController.deskripsi2;
        
        
        nama.setText(nama2);
        deskripsi.setText(deskripsi2);
    }
}
   
