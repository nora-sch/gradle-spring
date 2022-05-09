package fr.eni.movielibrary.service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;

import java.util.List;

public interface MovieService {

List<Movie> getAllMovies();
Movie getMovieById(long id);
List<Genre> getGenres();
List<Participant> getParticipants();
Genre getGenreById(long id);
Participant getParticipantById(long id);
void saveMovie(Movie movie);


}
