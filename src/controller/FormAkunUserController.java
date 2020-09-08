/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.User;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class FormAkunUserController implements Initializable {

    @FXML
    private ImageView imageprofil;
    @FXML
    private Button addprofil;
    @FXML
    private Button gantipass;
    @FXML
    private Label labelnama;
    @FXML
    private Label labelemail;
    public static Integer idakun2;
    public static String namaakun2;
    public static String emailakun2;
      private FileChooser fileChooser;
    private String gambar;
    private Path copy,files;
    private implementsDao implement;
    private FileInputStream fis;
    private FileChooser filechooser;
    private Stage stage;
    private Window Stage;
    private File file;
    private final Desktop desktop = Desktop.getDesktop();
    @FXML
    private AnchorPane pane;
    @FXML
    private Button kembali;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
         implement =  new FormpendaftaranDao();
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("All Files", "*.png","*.jpg","*jpeg","*.bmp", "*.mp4")
                  );
    }
        // TODO
     
   
            
    

       
    
    @FXML
    private void addProfilAction(ActionEvent event) {
          file =  fileChooser.showOpenDialog(null);
          if(file != null){
        try { 
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageprofil.setFitWidth(180);
            imageprofil.setFitHeight(110);
            imageprofil.setPreserveRatio(true);
            imageprofil.setImage(image);
            gambar = file.getName();
            files = Paths.get(file.toURI());
        } catch (IOException ex) {
            Logger.getLogger(KelolaRekruitmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
          }
    }

    @FXML
    private void gantiPassAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/GantiPassword.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            pane.getChildren().setAll(panes);
    }
    
}
