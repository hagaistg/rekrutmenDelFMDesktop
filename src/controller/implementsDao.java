/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entitiy.Formpendaftaran;
import java.io.FileInputStream;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Wenny Adinda Siagian;
 */
public interface implementsDao {

    /**
     *
     * @param upload
     */
    public void createUpload(Formpendaftaran upload);
}

 