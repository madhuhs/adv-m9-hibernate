package com.jspiders.project.bms;

import com.jspiders.demo.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo2 {
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

        //logics FROM Entity ref WHERE ref.dataMember = value;
        String selectUsersByName_HQL = "FROM Movie mov WHERE mov.status = 'AVAILABLE'";

        Query<Movie> query = session.createQuery(selectUsersByName_HQL, Movie.class);
        List<Movie> resultList = query.getResultList();

        for (Movie mov:resultList)
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
