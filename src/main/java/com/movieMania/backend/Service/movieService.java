package com.movieMania.backend.Service;

import com.movieMania.backend.Entity.movie;

import java.util.List;

public interface movieService {

    movie addMovie(movie movie);
    List<movie> getAllMovies();
    List<movie> getByCategory(String category);
    List<movie> getByName(String name);
    String updateMovie(movie movie,Long id);
}
