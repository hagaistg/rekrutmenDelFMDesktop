/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Formpendaftaran;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class KelolaRekruitmentAdminController implements Initializable {
    
 

    @FXML
    private TableView<Formpendaftaran> tabelview;
    @FXML
    private TableColumn nomor;
    @FXML
    private TableColumn nama;
    @FXML
    private TableColumn email;
    @FXML
    private TableColumn posisi;
    @FXML
    private TableColumn cv;
    ObservableList<Formpendaftaran> tableData = null;
    public static Integer id2;
    public static String nama2;
    public static String email2;
    public static String umur2;
    public static String tgllahir2;
    public static String alamat2;
    public static String notlp2;
    public static String jk2;
    public static String pendidikan2;
    public static String pengalaman2;
    public static String posisi2;
    public static String motivasi2;
    public static String cv2;
    private FileChooser fileChooser;
    private String gambar;
    private Path copy,files;
    private implementsDao implement;
    private FileInputStream fis;
    private FileChooser filechooser;
    private Stage stage;
    private Window Stage;
    private File file;
    @FXML
    private AnchorPane panes;
    @FXML
    private Button kembali;
    @FXML
    private Button detail;

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
          AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/DetailKelolaRekruitment.fxml"));
            panes.getChildren().setAll(paness);
    }
    public void tampil(){
        displayList();
    }
     
    private void displayList(){
       tableData = FXCollections.observableArrayList();
         
         ModelRekruitment mm = new ModelRekruitment();

        for (Formpendaftaran m : mm.findAll()) {
            tableData.add(m);
        }
        nomor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("namalengkap"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        posisi.setCellValueFactory(new PropertyValueFactory<>("posisi"));
        cv.setCellValueFactory(new PropertyValueFactory<>("cv"));

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
           Formpendaftaran barangSelect = tabelview.getSelectionModel().getSelectedItem();
           
           this.id2= (barangSelect.getId());
           this.nama2 = barangSelect.getNamalengkap();
           this.email2 = barangSelect.getEmail();
           this.umur2 = barangSelect.getUmur();
           this.tgllahir2 = barangSelect.getTgllahir();
           this.alamat2 = barangSelect.getAlamat();
           this.notlp2 = barangSelect.getNotlp();
           this.jk2 = barangSelect.getJeniskelamin();
           this.pendidikan2 = barangSelect.getPendidikan();
           this.pengalaman2 = barangSelect.getPengalamanbekerja();
           this.posisi2 = barangSelect.getPosisi();
           this.motivasi2 = barangSelect.getMotivasi();
           this.cv2 = barangSelect.getCv();
//           File kk = new File ("src/img/"+cv2);
//           Image img = new Image(kk.toURI().toString());
//           lihatGambar.setImage(img);
                 
        }
    

    }
    
    
}
