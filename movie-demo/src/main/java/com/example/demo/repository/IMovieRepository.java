package com.example.demo.repository;


import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByName(String name);
}
