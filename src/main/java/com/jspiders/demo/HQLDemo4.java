package com.jspiders.demo;

import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;

public class HQLDemo4 {
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

        //Step:1 -> get CriteriaBuilder
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();

        //Step:2 -> create Dynamic-Query using CriteriaBuilder with Entity Class
        JpaCriteriaQuery<Movie> query = cb.createQuery(Movie.class);

        //Step:3 -> define the table name
        JpaRoot<Movie> table = query.from(Movie.class);

        //Step:4 -> Define the conditions/criteria/predicates
        JpaPredicate condition1 = cb.equal(table.get("status"), MovieStatus.AVAILABLE);

        //Step:5 -> Build the query using table and conditions
        query.select(table).where(condition1);

        Query<Movie> query1 = session.createQuery(query);
        List<Movie> resultList = query1.getResultList();

        for (Movie mov : resultList) {
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
