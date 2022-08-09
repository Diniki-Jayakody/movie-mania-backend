package com.movieMania.backend.Controller;

import com.movieMania.backend.Entity.movie;
import com.movieMania.backend.Service.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    private com.movieMania.backend.Service.movieService movieService;

//    movie addMovie(movie movie);
//    List<movie> getAllMovies();
//    List<movie> getByCategory(String category);
//    List<movie> getByName(String name);
//    String updateMovie(movie movie,Long id);
//    List<movie> getTopRated();
//    List<String> getCategories();
//    String deleteMovie(Long id);

    @PostMapping("/addMovie")
    private String addMovie(@RequestBody movie movie){
        movieService.addMovie(movie);
        return "successfully added";
    }

    @PutMapping("/updateMovie/{id}")
    private String updateMovie(@RequestBody movie movie , @PathVariable Long id){
        return movieService.updateMovie(movie,id);
    }

    @DeleteMapping("/deleteMovie/{id}")
    private String deleteMovie(@PathVariable Long id){
        return movieService.deleteMovie(id);
    }

    @GetMapping("/getMovies")
    private List<movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/getMovie/{id}")
    private movie getMovie(@PathVariable Long id){
        return movieService.getById(id);
    }

    @GetMapping("/getMovieByCategory/{category}")
    private List<movie> getMoviesByCat(@PathVariable String category){
        return movieService.getByCategory(category);
    }

    @GetMapping("/getMovieByName/{name}")
    private List<movie> getMoviesByName(@PathVariable String name){
        return movieService.getByName(name);
    }

    @GetMapping("/getMovieTop")
    private List<movie> getMovieTop(){
        return movieService.getTopRated();
    }

    @GetMapping("/getCategories")
    private List<String> getMovieCat(){
        return movieService.getCategories();
    }
}
