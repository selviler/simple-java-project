package com.example.demo.controller;


import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final IMovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> index()
    {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/store")
    public ResponseEntity<Movie> store(@RequestBody Movie mvn)
    {
        movieService.store(mvn);
        return new ResponseEntity<>(mvn, HttpStatus.CREATED);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Movie> show(@PathVariable Long id)
    {
        try{
            return new ResponseEntity<>( movieService.findById(id), HttpStatus.OK);
        }catch (MovieNotFoundException e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Movie mvn)
    {
        movieService.update(id, mvn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> search(@RequestParam(required = false) String keyword)
    {
        List<Movie> movie = movieService.search(keyword);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


//    @GetMapping("/all")
//    public String index()
//    {
//        return "index";
//    }

//    @GetMapping("/show/{id}")
//    public ResponseEntity<Movie> show(@PathVariable String id)
//    {
////        // classic
////        Movie mvie = null;
////        for (int i = 0; i < movies.size(); i++)
////        {
////            Movie m = movies.get(i);
////            if (m.getId().equals(id))
////            {
////                mvie = m;
////                break;
////            }
////        }
////        if (mvie == null)
////        {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
//
//        // stream api
//          Movie result = movies.stream()
//                 .filter(mv -> mv.getId().equals(id))
//                 .findFirst()
//                 .orElseThrow(() -> new RuntimeException("movie not found"));
//
//          return new ResponseEntity<>(result, HttpStatus.OK);
//        //System.out.println(id);
//    }
//
//    @PostMapping("/store")
//    public ResponseEntity<Movie> store(@RequestBody Movie mvn)
//    {
//        movies.add(mvn);
//        return new ResponseEntity<>(mvn, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Movie mvn)
//    {
//        Movie m = movies.stream()
//                .filter(mv -> mv.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("movie not found"));
//
//        m.setName(mvn.getName());
//        m.setDescription(mvn.getDescription());
//        m.setDirector(mvn.getDirector());
//        m.setYear(mvn.getYear());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id)
//    {
//        Movie m = movies.stream()
//                .filter(mv -> mv.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("movie not found"));
//
//        movies.remove(m);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
