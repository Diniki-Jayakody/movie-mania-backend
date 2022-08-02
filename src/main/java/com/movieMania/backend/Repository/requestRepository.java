package com.movieMania.backend.Repository;

import com.movieMania.backend.Entity.logins;
import com.movieMania.backend.Entity.request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface requestRepository extends JpaRepository<request, Long> {
}
