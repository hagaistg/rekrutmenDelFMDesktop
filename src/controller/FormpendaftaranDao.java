/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Formpendaftaran;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Wenny Adinda Siagian;
 */
public class FormpendaftaranDao implements implementsDao {

    @Override
    public void createUpload(Formpendaftaran upload) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apakah anda akan menyimpan data");
        alert.setHeaderText(null);
        alert.setContentText("Tekan OK untuk menyimpan data, Cencel untuk batal.");
        Optional result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
             //Query q = session.createSQLQuery("INSERT INTO upload (foto) VALUES (:foto)");
              Query q = session.createSQLQuery("INSERT INTO Formpendaftaran (namalengkap,email,umur,tgllahir,alamat,notlp,jeniskelamin,pendidikan,pengalamanbekerja,posisi,motivasi,cv) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            q.setString(0, upload.getNamalengkap());
            q.setString(1, upload.getEmail());
            q.setString(2, upload.getUmur());
            q.setString(3, upload.getTgllahir());

            q.setString(4, upload.getAlamat());
            q.setString(5, upload.getNotlp());
            q.setString(6, upload.getJeniskelamin());
            q.setString(7, upload.getPendidikan());
            q.setString(8, upload.getPengalamanbekerja());
            q.setString(9, upload.getPosisi());
            q.setString(10, upload.getMotivasi());
            q.setString(11, upload.getCv());
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
    
}
    }

   
    }


    

