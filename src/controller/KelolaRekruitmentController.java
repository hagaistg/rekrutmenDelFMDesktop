/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Formpendaftaran;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class KelolaRekruitmentController implements Initializable {
    @FXML
    private AnchorPane panes;
     @FXML
    private ImageView lihatgambar;
    @FXML
    private TextField namaF;
    @FXML
    private TextField emailF;
    @FXML
    private TextField umurF;
    @FXML
    private DatePicker tgllahirF;
    @FXML
    private TextField alamatF;
    @FXML
    private TextField notlpF;
    @FXML
    private TextField pendidikanF;
    @FXML
    private Button btnSubmit;
    private SplitMenuButton jeniskelaminF;
    @FXML
    private Button btnAdd;
    @FXML
    private TextArea pengalamanF;
    @FXML
    private TextArea motivasiF;
    private SplitMenuButton posisiF;
    private File file;
     private FileChooser fileChooser;
    private String gambar;
    private Path copy,files;
    private implementsDao implement;
    private FileInputStream fis;
    private FileChooser filechooser;
    private Stage stage;
    private Window Stage;
    private final Desktop desktop = Desktop.getDesktop();
    @FXML
    private Button btnSubmit1;
    @FXML
    private ComboBox<String> jk;
    @FXML
    private ComboBox<String> posisi;
    ObservableList<String> list = FXCollections.observableArrayList("Laki-Laki","Perempuan");
     ObservableList<String> list1 = FXCollections.observableArrayList("Produser","Penyiar","Music Director");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         jk.setItems(list);
         posisi.setItems(list1);
        implement =  new FormpendaftaranDao();
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("All Files", "*.png","*.jpg","*jpeg","*.bmp", "*.mp4")
    );
        // TODO
    }    
   
    @FXML
    private void ActionAdd(ActionEvent event) throws IOException {
          file =  fileChooser.showOpenDialog(null);
          if(file != null){
        try { 
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            lihatgambar.setFitWidth(180);
            lihatgambar.setFitHeight(110);
            lihatgambar.setPreserveRatio(true);
            lihatgambar.setImage(image);
            gambar = file.getName();
            files = Paths.get(file.toURI());
        } catch (IOException ex) {
            Logger.getLogger(KelolaRekruitmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
          }
    
      
      
        
    }
      @FXML
    private void submitAction(ActionEvent event) throws IOException {
        if (namaF.getText().equals("") || emailF.getText().equals("") || alamatF.getText().equals("") || pendidikanF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
             
         Formpendaftaran upload = new Formpendaftaran();
            upload.setNamalengkap(namaF.getText());
            upload.setEmail(emailF.getText());
            upload.setUmur(umurF.getText());
            upload.setTgllahir(tgllahirF.getValue().toString());
            upload.setAlamat(alamatF.getText());
            upload.setNotlp(notlpF.getText());
            upload.setJeniskelamin(jk.getValue());
            upload.setPendidikan(pendidikanF.getText());
            upload.setPengalamanbekerja(pengalamanF.getText());
            upload.setPosisi(posisi.getValue());
            upload.setMotivasi(motivasiF.getText());
            upload.setCv(gambar);
            implement.createUpload(upload);
        
         if (gambar != null) {
        try {
            File dir = new File(System.getProperty("user.dir"));
            copy = Paths.get(dir+"/src/img/"+gambar);
            CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
            };
            Files.copy(files, copy, options);
           
              AnchorPane paness = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            panes.getChildren().setAll(paness);
        } catch (IOException ex) {
            Logger.getLogger(KelolaRekruitmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
            
        }
    }
}
