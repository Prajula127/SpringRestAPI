/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    int movieId = 6;

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here
    @Override
    public ArrayList<Movie> getMovies() {
        Collection<Movie> movie = movieList.values();
        ArrayList<Movie> mv = new ArrayList<>(movie);
        return mv;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie != null) {
            return movie;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        movie.setMovieId(movieId);
        movieList.put(movieId, movie);
        movieId += 1;
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        Movie changeMovie = movieList.get(movieId);
        if (changeMovie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (movie.getMovieName() != null) {
            changeMovie.setMovieName(movie.getMovieName());
        }

        if (movie.getLeadActor() != null) {
            changeMovie.setLeadActor(movie.getLeadActor());
        }

        return changeMovie;
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie != null) {
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
