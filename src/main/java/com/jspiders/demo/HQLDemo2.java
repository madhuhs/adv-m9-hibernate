package com.jspiders.demo;

import com.jspiders.project.bms.Movie;
import jakarta.persistence.criteria.Predicate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;

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
        Movie movie = query.uniqueResult();
        System.out.println(movie);

        //close session
        session.close();
        System.out.println("session closed..");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

        System.out.println("Program ends...");
    }
}
