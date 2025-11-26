package com.jspiders.project.bms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

        //Step : Close SessionFactory
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}
