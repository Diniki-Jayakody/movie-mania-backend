package com.movieMania.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long movieId;
    String story;
    String addDate;
    String actors;
    String category;
    String launchingImageUrl;
    String name;
    String trailerLink;
    String imageUrl;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("movie-request")
    @ToString.Exclude
    private List<request> requests;

    public movie() {
    }

    public List<request> getRequests() {
        return requests;
    }

    public void setRequests(List<request> requests) {
        this.requests = requests;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLaunchingImageUrl() {
        return launchingImageUrl;
    }

    public void setLaunchingImageUrl(String launchingImageUrl) {
        this.launchingImageUrl = launchingImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
