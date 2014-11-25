package com.puntodeventa.services.DAO;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author hhehs910
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {        
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException he) {            
            System.err.println("Initial SessionFactory creation failed." + he);
            throw new ExceptionInInitializerError(he);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
