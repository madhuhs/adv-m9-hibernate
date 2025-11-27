package com.jspiders.project.bms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class OneToManyDemo {

    static SessionFactory sessionFactory;

    static
    {
        //Step : Load Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.bms.cfg.xml");

        //Step : Build SessionFactory
         sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {

        System.out.println("Program starts...");

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        System.out.println("Creating Auditorium");
        Auditorium a1 = new Auditorium();
        a1 .setName("Audi-10");
        a1 .setSeatColumns(20);
        a1 .setSeatRows(50);

        System.out.println("Creating Show-1");
        Shows s1 = new Shows();
        s1.setEndTime(LocalDate.now());
        s1.setShowTime(LocalDate.now());
        s1.setStatus("AVAILABLE");

        System.out.println("Creating Show-2");
        Shows s2 = new Shows();
        s2.setEndTime(LocalDate.now());
        s2.setShowTime(LocalDate.now());
        s2.setStatus("AVAILABLE");

        System.out.println("Creating Show-3");
        Shows s3 = new Shows();
        s3.setEndTime(LocalDate.now());
        s3.setShowTime(LocalDate.now());
        s3.setStatus("AVAILABLE");

        //Linking Audi to Shows
        System.out.println("Linking Audi to Shows");
        a1.getShows().add(s1);
        a1.getShows().add(s2);
        a1.getShows().add(s3);

        System.out.println("Save Audi");
        session.persist(a1);

        transaction.commit();

        session.close();
        //Step : Close SessionFactory
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}
