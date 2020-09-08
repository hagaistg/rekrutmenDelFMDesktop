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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class ProgramDeskripsiController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label aplikasi;

    @FXML
    private Button kembali;

    @FXML
    private Label nama;

    @FXML
    private Label penyiar;

    @FXML
    private Label jadwal;

    @FXML
    private Label deskripsi;
    
    public static Integer id2;
    public static String nama2;
    public static String penyiar2;
    public static String jadwal2;
    public static String deskripsi2;
    
    
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
        deskripsi.setText(deskripsi2);
        
        
    }
    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaProgram.fxml"));
            pane.getChildren().setAll(panes);
    }
    
}
