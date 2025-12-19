package com.example.movie.controller;

import com.example.movie.entity.Movie;
import com.example.movie.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Integer id){
        return movieService.getMovie(id);
    }
    @PutMapping("/update/{id}")
    public Optional<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie updatedMovie){
        return movieService.updateMovie(id, updatedMovie);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id){
        return movieService.deleteMovie(id);
    }

    //Find Methods
    @GetMapping("/title/{title}")
    public List<Movie> getAllMovieByTitle(String title){
        return movieService.getAllMoviesByTitle(title);
    }
    @GetMapping("/genre/{genre}")
    public List<Movie> getAllMovieByGenre(String genre){
        return movieService.getAllMoviesByGenre(genre);
    }
    //Pagination
    @GetMapping("/pagination")
    public Page<Movie> getPagination(@RequestParam(defaultValue = "0")
                                         int page,@RequestParam(defaultValue = "5") int size){
        return movieService.getMoviesByPage(page, size);
    }
}
