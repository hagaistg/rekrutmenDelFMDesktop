/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DeskripsiController.deskripsi2;
import static controller.DeskripsiController.jadwal2;
import static controller.DeskripsiController.nama2;
import static controller.DeskripsiController.penyiar2;
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
 * @author Amri Simanjuntak;
 */
public class DeskripsiController implements Initializable {

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
        this.id2 = ProgramUserController.id2;
        this.nama2 = ProgramUserController.nama2;
        this.penyiar2 = ProgramUserController.penyiar2;
        this.jadwal2 = ProgramUserController.jadwal2;
        this.deskripsi2 = ProgramUserController.deskripsi2;
        
        
        nama.setText(nama2);
        penyiar.setText(penyiar2);
        jadwal.setText(jadwal2);
        deskripsi.setText(deskripsi2);
        
        
    }
    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            pane.getChildren().setAll(panes);
    }   
    
}
