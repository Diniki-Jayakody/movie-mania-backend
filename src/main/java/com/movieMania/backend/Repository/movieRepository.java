package com.movieMania.backend.Repository;

import com.movieMania.backend.Entity.logins;
import com.movieMania.backend.Entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movieRepository extends JpaRepository<movie, Long> {
    List<movie> findByCategory(String category);
    List<movie> findByNameLike(String name);
}
