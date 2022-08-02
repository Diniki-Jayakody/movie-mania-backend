package com.movieMania.backend.Repository.exception;

import com.movieMania.backend.Entity.logins;
import com.movieMania.backend.Entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepository extends JpaRepository<movie, Long> {
}
