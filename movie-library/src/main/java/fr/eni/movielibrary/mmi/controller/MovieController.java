package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("movieBean")
public class MovieController {

    private MovieService movieService;

    // injection dependance par constructeur
    @Autowired
    public MovieController(MovieService movieService){
        System.out.println("Appel du construteur MovieController");
        this.movieService = movieService;
    }
    public List<Movie> showAllMovies() {
        List<Movie> lstMovies = movieService.getAllMovies();
        System.out.println(lstMovies);
        return lstMovies;
    }
    public Movie findMovie(long id) {
        Movie movie = movieService.getMovieById(id);
        System.out.println(movie);
        return movie;
    }

}
