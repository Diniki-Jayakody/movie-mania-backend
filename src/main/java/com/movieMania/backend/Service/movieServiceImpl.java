package com.movieMania.backend.Service;

import com.movieMania.backend.Entity.movie;
import com.movieMania.backend.Entity.request;
import com.movieMania.backend.Repository.movieRepository;
import com.movieMania.backend.Repository.requestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class movieServiceImpl implements movieService{

    @Autowired
    private com.movieMania.backend.Repository.movieRepository movieRepository;

    @Autowired
    private requestRepository requestRepository;


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
        List<movie> movies =movieRepository.findAll();
       // List<movie> moviesRecent = new ArrayList<>();

        for (int j=0; j<movies.size()-1; j++){

            if (Long.parseLong(movies.get(j).getAddDate())>Long.parseLong(movies.get(j+1).getAddDate())){
                movie newMovie = movies.get(j+1);
                movies.get(j+1).equals(movies.get(j));
                movies.get(j).equals(newMovie);

                for(int k=j; k>0; k--){
                    if (Long.parseLong(movies.get(k).getAddDate())>Long.parseLong(movies.get(k+1).getAddDate())){
                        movie newMovie2 = movies.get(k);
                        movies.get(k).equals(movies.get(k+1));
                        movies.get(k+1).equals(newMovie2);
                    }
                }
            }
        }
        return movies;
    }

    @Override
    public List<movie> getByCategory(String category) {
        return movieRepository.findByCategory(category);
    }

    @Override
    public List<movie> getByName(String name) {
        List<movie> movies = movieRepository.findAll();
        List<movie> movies1 = new ArrayList<>();

        for (movie movie : movies){
            boolean logic = movie.getName().contains(name);
            if (logic){
                movies1.add(movie);
            }
        }
        return movies1;
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

    @Override
    public List<movie> getTopRated() {
        List<movie> movies = movieRepository.findAll();
        List<movie> moviesFiltered = new ArrayList<>();
        //List<Integer> requestAmounts = new ArrayList<>();

        int i=0;
        for (movie movie : movies){
            if (i<12){
                moviesFiltered.add(movie);
            }
            else {
                int j=0;
                for (com.movieMania.backend.Entity.movie movie1 : moviesFiltered){
                    if (movie1.getRate()<movie.getRate()){
                        moviesFiltered.get(j).equals(movie);
                        break;
                    }
                    j++;
                }
            }
            i++;
        }

        for (int j=0; j<moviesFiltered.size()-1; j++){
            if (moviesFiltered.get(j).getRate()>moviesFiltered.get(j+1).getRate()){
                movie newMovie = moviesFiltered.get(j+1);
                moviesFiltered.get(j+1).equals(moviesFiltered.get(j));
                moviesFiltered.get(j).equals(newMovie);

                for(int k=j; k>0; k--){
                    if (moviesFiltered.get(k).getRate()<moviesFiltered.get(k+1).getRate()){
                        movie newMovie2 = moviesFiltered.get(k);
                        moviesFiltered.get(k).equals(moviesFiltered.get(k+1));
                        moviesFiltered.get(k+1).equals(newMovie2);
                    }
                }
            }
        }

        return moviesFiltered;
    }

    @Override
    public List<String> getCategories() {

        List<String> categories = new ArrayList<>();
        List<movie> movies = movieRepository.findAll();
        categories.add(movies.get(0).getCategory());
        for (movie movie : movies){
            String category = movie.getCategory();
            boolean sameCat = false;
            for (String string : categories){
                if (string.equalsIgnoreCase(category)) {
                    sameCat = true;
                    break;
                }
            }
            if (!sameCat){
                categories.add(category);
            }
        }

        return categories;
    }

    @Override
    public String deleteMovie(Long id) {
        Optional<movie> movie = movieRepository.findById(id);
        if (movie.isPresent()){
            List<request> requests = movie.get().getRequests();
            for (request request : requests){
                requestRepository.deleteByRequestId(request.getRequestId());
            }
            movieRepository.deleteById(id);
            return "successfully deleted";
        }
        return "error Id";
    }

    @Override
    public movie getById(Long id) {
        Optional<movie> movie =movieRepository.findById(id);
        return movie.orElse(null);
    }
}
