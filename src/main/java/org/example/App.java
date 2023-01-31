package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).
                addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            //1 get any director
//            Director director = session.get(Director.class,1);
//            System.out.println(director.toString());

            //2 get any movie + its creator
//            Movie movie = session.get(Movie.class,3);
//            System.out.println(movie);
//            System.out.println(movie.getCreator());

            //add one movie with 1 director
//            Director director = session.get(Director.class,1);
//            Movie newMovie = new Movie("BooBoo2",2003,director);
//            director.setMovies(new ArrayList<>(Collections.singletonList(newMovie)));
//            session.save(newMovie);
//            session.save(director);

            //changing movie director
//            Director director = session.get(Director.class,2);
//            Movie movie = session.get(Movie.class,12);
//            movie.getCreator().getMovies().remove(director);
//            movie.setCreator(director);
//            director.getMovies().add(movie);

            //delete movie from director
            Movie movie = session.get(Movie.class, 12);
            Director director = movie.getCreator();
            session.remove(movie);
            director.getMovies().clear();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
