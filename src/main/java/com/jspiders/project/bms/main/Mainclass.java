package com.jspiders.project.bms.main;

import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Mainclass {
    private static SessionFactory sessionFactory = null;

    static
    {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //create sessionfactory
        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();
    }


    public static void addMovie()
    { //create session
        System.out.println("3.Create Session");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //logics
        Movie movie1 = new Movie();
        movie1.setTitle("K.G.F");
        movie1.setLanguage("KAN");
        movie1.setCertification("U/A");
        movie1.setDuration(120);
        movie1.setStatus(MovieStatus.AVAILABLE);
        movie1.setCreatedAt(LocalDate.now());
        movie1.setCreatedBy(123l);

        try {
            System.out.println("4.Save Entity to DB");
            session.persist(movie1);//persist-->save
            transaction.commit();
            System.out.println("Save Entity to DB SUCCESS");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        System.out.println("5.Close Session");
        session.close();
    }

    public static void updateMovie()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Movie movie1 = new Movie();
        session.find(Movie.class,movie1);

        try {
            System.out.println("4.Save Entity to DB");
            session.merge(movie1);//merge-->update
            transaction.commit();
            System.out.println("Save Entity to DB SUCCESS");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println("Program starts...");

        //addMovie();
        updateMovie();

        System.out.println("6.Close Session Factory");
        sessionFactory.close();

        System.out.println("Program ends...");
    }
}











