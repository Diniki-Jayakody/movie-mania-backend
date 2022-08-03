package com.movieMania.backend.Service;

import com.movieMania.backend.Entity.movie;
import com.movieMania.backend.Repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class movieServiceImpl implements movieService{

    @Autowired
    private movieRepository movieRepository;


    private String dateInCount(){
        Date date = new Date();
        SimpleDateFormat sdt = new SimpleDateFormat("dd");
        SimpleDateFormat sdt2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdt3 = new SimpleDateFormat("YYYY");
        //SimpleDateFormat sdt5 = new SimpleDateFormat("hh");

        String day= sdt.format(date);
        String month = sdt2.format(date);
        String year = sdt3.format(date);

        return dayCount(day,month,year).toString();

    }

    private Long dayCount(String day, String month, String year) {
        Long years = Long.parseLong(year);
        Long days = Long.parseLong(day);
        Long months = Long.parseLong(month);
        years-=2022;
        Long dayCount=years*365+months*30+days;
        return dayCount;
    }

    @Override
    public movie addMovie(movie movie) {

        movie.setAddDate(dateInCount());
        return movieRepository.save(movie);
    }

    @Override
    public List<movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<movie> getByCategory(String category) {
        return movieRepository.findByCategory(category);
    }

    @Override
    public List<movie> getByName(String name) {
        return movieRepository.findByNameLike(name);
    }

    @Override
    public String updateMovie(movie movie, Long id) {
        Optional<movie> movie1 = movieRepository.findById(id);
        if (movie1.isPresent()){
            com.movieMania.backend.Entity.movie movie2 = movie1.get();
            movie2.setActors(movie.getActors());
            movie2.setAddDate(dateInCount());
            movie2.setCategory(movie.getCategory());
            movie2.setImageUrl(movie.getImageUrl());
            movie2.setLaunchingImageUrl(movie.getLaunchingImageUrl());
            movie2.setName(movie.getName());
            movie2.setStory(movie.getStory());
            movie2.setTrailerLink(movie.getTrailerLink());

            movieRepository.save(movie2);

            return "successfully updated";
        }
        return "error Id";
    }
}
