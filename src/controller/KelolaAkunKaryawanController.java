/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Formpendaftaran;
import entitiy.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class KelolaAkunKaryawanController implements Initializable {

    @FXML
    private TableView<User> tabelview;
    @FXML
    private TableColumn nomor;
    @FXML
    private TableColumn nama;
    @FXML
    private TableColumn email;
    @FXML
    private TableColumn username;
    @FXML
    private TableColumn password;
    @FXML
    private Button kembali;
    @FXML
    private Button detail;
    ObservableList<User> tableData = null;
    public static Integer id2;
    public static String nama2;
    public static String email2;
    public static String username2;
    public static String password2;
    @FXML
    private AnchorPane panes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tampil();
        // TODO
    }    

        @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
          AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaAdmin.fxml"));
            panes.getChildren().setAll(paness);
    }

    @FXML
    private void detailAction(ActionEvent event) throws IOException {
          AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/DetailKelolaAkun.fxml"));
            panes.getChildren().setAll(paness);
    }
    
    public void tampil(){
        displayList();
    }
     
    private void displayList(){
       tableData = FXCollections.observableArrayList();
         
         ModelUser mm = new ModelUser();

        for (User m : mm.findAll()) {
            tableData.add(m);
        }
        nomor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        //tabelview.getColumns().clear();
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
           User barangSelect = tabelview.getSelectionModel().getSelectedItem();
           this.id2= (barangSelect.getId());
           this.nama2 = barangSelect.getNama();
           this.email2 = barangSelect.getEmail();
           this.username2 = barangSelect.getUsername();
           this.password2 = barangSelect.getPassword();
           
        }
    

    }
    
}
