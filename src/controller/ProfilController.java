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
public class ProfilController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button kembali;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            pane.getChildren().setAll(panes);
    }
    
}