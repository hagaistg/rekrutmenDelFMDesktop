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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class HalamanUtamaUserController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button kelolaProfil;
    @FXML
    private Button kelolaProgram;
    @FXML
    private Button kelolaBerita;
    @FXML
    private Button kelolaRekruitment;
    @FXML
    private Button kelolaSyarat;
    @FXML
    private Button kelolaAkun;
    @FXML
    private Button keluar;
    @FXML
    private Button about;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML
    private void kelolaProfilAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/Profil.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void kelolaProgramAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/ProgramUser.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void kelolaBeritaAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/KelolaBeritaUser.fxml"));
            pane.getChildren().setAll(panes);
    }
    

    @FXML
    private void kelolaRekruitmentAction(ActionEvent event) throws IOException {
          AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/formrekruitmentuser.fxml"));
            pane.getChildren().setAll(panes);
        
    }

    @FXML
    private void kelolaSyaratAction(ActionEvent event) throws IOException {
          AnchorPane panes = FXMLLoader.load(getClass().getResource("/persyaratan/FXMLpersyaratanUser.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void kelolaAkunAction(ActionEvent event) throws IOException {
          AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/FormAkunUser.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void keluarAction(ActionEvent event) {
          System.exit(0);
    }

    @FXML
    private void aboutAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/about/About.fxml"));
            pane.getChildren().setAll(panes);
    }
    
    
}
