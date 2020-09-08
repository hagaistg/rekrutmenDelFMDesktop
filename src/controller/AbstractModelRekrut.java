/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Wenny Adinda Siagian;
 */
class AbstractModelRekrut<T> {
     private Class<T> entity;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public AbstractModelRekrut(Class<T> entity) {
        this.entity = entity;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List<T> result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = session.createQuery("from " + entity.getName()).list();
            transaction.commit();
        } catch(Exception e) {
            result = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public T find(Object id) {
        T result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = (T) session.get(entity, (Serializable) id);
            transaction.commit();
        } catch(Exception e) {
            result = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
    


}
