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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hagai Stg
 */
public class DetailBeritaController implements Initializable {
    @FXML
    private AnchorPane pane;
    
    @FXML
    private Label judul;

    @FXML
    private Label topik;

    @FXML
    private Label tanggal;

    @FXML
    private Label deskripsi;
    @FXML
    private Button kembail;
    
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
    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaBerita.fxml"));
            pane.getChildren().setAll(panes);
    }
}
