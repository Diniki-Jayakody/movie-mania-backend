package com.movieMania.backend.Repository.exception;

import com.movieMania.backend.Entity.logins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface logindRepository extends JpaRepository<logins , Long> {
}
