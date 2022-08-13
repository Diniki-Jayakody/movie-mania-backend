package com.movieMania.backend.Entity;

import lombok.Data;

@Data
public class requestResponse {

    request request;
    movie movie;

    public requestResponse() {
    }

    public com.movieMania.backend.Entity.request getRequest() {
        return request;
    }

    public void setRequest(com.movieMania.backend.Entity.request request) {
        this.request = request;
    }

    public com.movieMania.backend.Entity.movie getMovie() {
        return movie;
    }

    public void setMovie(com.movieMania.backend.Entity.movie movie) {
        this.movie = movie;
    }
}
