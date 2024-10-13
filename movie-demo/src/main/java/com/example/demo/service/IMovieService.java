package com.example.demo.service;


import com.example.demo.entity.Movie;
import com.example.demo.repository.IMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IMovieService {

    private IMovieRepository movieRepository;

    public List<Movie> getAll()
    {
        return movieRepository.findAll();
    }
    public Movie store(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public void update(Long id, Movie movie)
    {
        Movie m = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("movie not found"));

        m.setName(movie.getName());
        m.setDescription(movie.getDescription());
        m.setDirector(movie.getDirector());
        m.setYear(movie.getYear());

        movieRepository.save(m);
    }
    public Movie findById(Long id)
    {
        Optional<Movie> mvn = movieRepository.findById(id);
        if (mvn.isEmpty())
        {
            throw  new RuntimeException("movie not found");
        }
        return mvn.get();
    }
    public void delete(Long id)
    {
        movieRepository.deleteById(id);
    }

    public List<Movie> search(String keyword)
    {
        return movieRepository.findByName(keyword);
    }
}
