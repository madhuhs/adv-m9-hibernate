package com.jspiders.project.bms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo3 {
    public static void main(String[] args) {
        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        //get session from session factory
        Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");

        Scanner scanner  = new Scanner(System.in);

        String selectUsersByName_HQL2 = "FROM Movie mov WHERE mov.status = :status";
        Query<Movie> query2 = session.createQuery(selectUsersByName_HQL2, Movie.class);

        System.out.println("Enter movie status to Search");
        String status =  scanner.next();
        query2.setParameter("status",MovieStatus.valueOf(status));
        List<Movie> resultList2 = query2.getResultList();

        for (Movie mov:resultList2)
        {
            System.out.println(mov);
        }

        //close session
        session.close();
        System.out.println("session closed..");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

        System.out.println("Program ends...");
    }
}
