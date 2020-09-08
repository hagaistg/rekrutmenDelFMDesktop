/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Program;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class ProgramUserController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label aplikasi;

    @FXML
    private TableView<Program> tabelview;

    @FXML
    private TableColumn nomor;

    @FXML
    private TableColumn nama;

    @FXML
    private TableColumn penyiar;

    @FXML
    private TableColumn jadwal;
   
     @FXML
    private TableColumn deskripsi;
     
     @FXML
    private Button detail;
     @FXML
     
    private Button keluar;
     
     ObservableList<Program> tableData;
    public static Integer id2;
    public static String nama2;
    public static String penyiar2;
    public static String jadwal2;
    public static String deskripsi2;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tampil();
    }  
    
    public void tampil(){
        displayList();
    }
    private void displayList(){     
        tableData = FXCollections.observableArrayList();
         Model mm = new Model();
        for (Program m : mm.findAll()) {
            tableData.add(m);
        }
        nomor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("namaprogram"));
        penyiar.setCellValueFactory(new PropertyValueFactory<>("penyiar"));
        jadwal.setCellValueFactory(new PropertyValueFactory<>("jadwal"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        

//        tabelview.getColumns().clear();
        tabelview.setItems(tableData);
        //tabelview.getColumns().addAll(nomor,nama,hargaas,tanggal); 
        tabelview.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                onClick();
            }
            
        });
    }
    
    public void onClick(){
        if(tabelview.getSelectionModel().getSelectedItem() != null){
           Program barangSelect = (Program) tabelview.getSelectionModel().getSelectedItem();
           this.id2 = (barangSelect.getId());
           this.nama2 = barangSelect.getNamaprogram();
           this.penyiar2 = barangSelect.getPenyiar();
           this.jadwal2 = barangSelect.getJadwal();
           this.deskripsi2 = barangSelect.getDeskripsi();
           
        }
    }
    
    @FXML
    private void detailAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/deskripsi.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            pane.getChildren().setAll(panes);
    }
//    @FXML
//    private void aksiCari(KeyEvent event) {
//        tableData = crudData.likeByNama(txtCari.getText());
//        tabelview.setItems(tableData);
//    }
    @FXML
    private void keluarAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
}
