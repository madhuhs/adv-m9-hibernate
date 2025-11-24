package com.jspiders.project.bms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo2 {
    public static void main(String[] args) {

        System.out.println("Program starts...");

        //Step : Load Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.bms.cfg.xml");

        //Step : Build SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Step : Open Session
        Session session = sessionFactory.openSession();

        //Step : Begin Transaction
        Transaction transaction = session.beginTransaction();

        Auditorium audi1 = new Auditorium();
        AudiAddress audiAddress = new AudiAddress();

        audi1.setName("Audi-1");
        audi1.setSeatRows(30);
        audi1.setSeatColumns(6);

        audiAddress.setStreetName("street-1");
        audiAddress.setArea("HBR");
        audiAddress.setCity("BLR");
        audiAddress.setPinCode(678912);

        //Linking Audi to AudiAddress
        audi1.setAudiAddress(audiAddress);

        //Save--> Insert
        session.persist(audi1);

        //Step : Commit transacton
        transaction.commit();

        //Step : Close Session
        session.close();

        //Step : Close SessionFactory
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}
