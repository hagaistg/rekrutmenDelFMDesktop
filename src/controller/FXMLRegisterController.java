/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.User;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * FXML Controller class
 *
 * @author Wenny Adinda Siagian;
 */
public class FXMLRegisterController implements Initializable {

    @FXML
    private AnchorPane apane;
    @FXML
    private TextField email;
    @FXML
    private PasswordField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField nama;
    public static Integer idakun2;
    public static String namaakun2;
    public static String emailakun2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//         User user = new User();
//           this.namaakun2 = user.getNama();
//           this.emailakun2= user.getEmail();
//        // TODO
    }    
    private void executeHQLQuery() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery("INSERT INTO User (nama,email,username,password) VALUES (:nama,:email,:username,:password)");
            q.setParameter("nama", nama.getText());
            q.setParameter("email", email.getText());
            q.setParameter("username", username.getText());
            q.setParameter("password", password.getText());
            
//            nama.setText(namaakun2);
//            email.setText(emailakun2);
          
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void actionRegister(ActionEvent event) throws IOException {
        if (password.getText().equals("") || nama.getText().equals("") || email.getText().equals("") || username.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
            alert.setTitle("Gagal");
            alert.showAndWait();
        } else {
            executeHQLQuery();
            Alert alert = new Alert(Alert.AlertType.NONE, "Data berhasil di daftarkan", ButtonType.OK);
            alert.setTitle("Success");
            alert.showAndWait();

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            pane.getChildren().setAll(pane);
        }
    }

    @FXML
    private void actionReset(ActionEvent event) {
        nama.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
    }

    @FXML
    private void actionCancel(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            pane.getChildren().setAll(pane);
         
    }
}
