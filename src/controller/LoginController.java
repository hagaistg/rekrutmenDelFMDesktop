/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Admin;
import entitiy.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
public class LoginController implements Initializable {

    @FXML
    private AnchorPane login;
    @FXML
    private Label loginpengguna;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button buttonlogin;
     @FXML
    private Button daftar;
         public String savedUsername;
    public String savedPassword;
    public String role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAction(ActionEvent event) {
        runLogin();
        
      
    }
      @FXML
    private void loginAdminAction(ActionEvent event) {
         runLoginAdmin();
      
    }

    @FXML
    private void daftarAction(ActionEvent event) throws IOException {
         AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/register.fxml"));
            login.getChildren().setAll(panes);
      
    }
    
 private static String QUERY_LOGIN = "from User a where a.username like '";
  private static String QUERY_LOGIN_ADMIN = "from Admin a where a.username like '";
      private void runLogin() {
        executeHQLQuery(QUERY_LOGIN + username.getText() + "'");
    }

       private void runLoginAdmin() {
        executeHQLQueryAdmin(QUERY_LOGIN_ADMIN + username.getText() + "'");
    }
    private void executeHQLQuery(String sql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(sql);
            List resultList = q.list();
            for (Object o : resultList) {
                User user = (User) o;
                savedUsername = user.getUsername();
                savedPassword = user.getPassword();
            }
            session.getTransaction().commit();
            if (savedPassword == null || savedUsername == null) {
                autentikasi(" ", " ");
            } else {
                autentikasi(savedPassword, savedUsername);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     private void executeHQLQueryAdmin(String sql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(sql);
            List resultList = q.list();
            for (Object o : resultList) {
                Admin user = (Admin) o;
                savedUsername = user.getUsername();
                savedPassword = user.getPassword();
            }
            session.getTransaction().commit();
            if (savedPassword == null || savedUsername == null) {
                autentikasiAdmin(" ", " ");
            } else {
                autentikasiAdmin(savedPassword, savedUsername);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
//    @FXML
//    private void daftar(ActionEvent event) throws IOException {
//        AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/Daftar.fxml"));
//        login.getChildren().setAll(panes);
//    }

    private void autentikasi(String savedPassword, String savedUsername) throws IOException {
        if (savedPassword.equals(password.getText()) && savedUsername.equals(username.getText())) {
            AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaUser.fxml"));
            login.getChildren().setAll(panes);
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Username atau password salah", ButtonType.OK);
            alert.setTitle("Username atau password salah");
            alert.showAndWait();
        }
    }
    private void autentikasiAdmin(String savedPassword, String savedUsername) throws IOException {
        if (savedPassword.equals(password.getText()) && savedUsername.equals(username.getText())) {
            AnchorPane panes = FXMLLoader.load(getClass().getResource("/view/HalamanUtamaAdmin.fxml"));
            login.getChildren().setAll(panes);
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Username atau password salah", ButtonType.OK);
            alert.setTitle("Username atau password salah");
            alert.showAndWait();
        }

    }
}

