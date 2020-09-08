/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.KelolaRekruitmentAdminController.cv2;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class DetailKelolaRekruitmentController implements Initializable {

    @FXML
    private Label nama;
    @FXML
    private Label email;
    @FXML
    private Label umur;
    @FXML
    private Button kembali;
    @FXML
    private Label tgllahir;
    @FXML
    private Label alamat;
    @FXML
    private Label notlp;
    @FXML
    private Label jk;
    @FXML
    private Label pendidikan;
    @FXML
    private Label pengalaman;
    @FXML
    private Label posisi;
    @FXML
    private Label motivasi;
    @FXML
    private Label cv;
    @FXML
    private Button terima;
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
    @FXML
    private AnchorPane panes;
    @FXML
    private ImageView imagecv;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addData();
    }
        // TODO
        
      public void addData(){
        this.id2 = KelolaRekruitmentAdminController.id2;
        this.nama2 = KelolaRekruitmentAdminController.nama2;
        this.email2 =KelolaRekruitmentAdminController.email2;
        this.umur2 =KelolaRekruitmentAdminController.umur2;
        this.tgllahir2 = KelolaRekruitmentAdminController.tgllahir2;
        this.alamat2 = KelolaRekruitmentAdminController.alamat2;
        this.notlp2 = KelolaRekruitmentAdminController.notlp2;
        this.jk2 = KelolaRekruitmentAdminController.jk2;
        this.pendidikan2 = KelolaRekruitmentAdminController.pendidikan2;
        this.pengalaman2 = KelolaRekruitmentAdminController.pengalaman2;
        this.posisi2 = KelolaRekruitmentAdminController.posisi2;
        this.motivasi2 = KelolaRekruitmentAdminController.motivasi2;
        this.cv2 = KelolaRekruitmentAdminController.cv2;
        
        
        nama.setText(nama2);
        email.setText(email2);
        umur.setText(umur2);
        tgllahir.setText(tgllahir2);
        alamat.setText(alamat2);
        notlp.setText(notlp2);
        
        jk.setText(jk2);
        pendidikan.setText(pendidikan2);
        pengalaman.setText(pengalaman2);
        posisi.setText(posisi2);
        motivasi.setText(motivasi2);
        cv.setText(cv2);
         File kk = new File ("src/img/"+cv2);
           Image img = new Image(kk.toURI().toString());
           imagecv.setImage(img);
        
        
      }
    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/PengelolaanRekruitment.fxml"));
            panes.getChildren().setAll(paness);
    }

    @FXML
    private void terimaAction(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.NONE, "Username atau password salah", ButtonType.OK);
            alert.setTitle("Username atau password salah");
            alert.showAndWait();
         AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/PengelolaanRekruitment.fxml"));
            panes.getChildren().setAll(paness);
          
    }
    
}
