package com.example.movie.service;

import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    //Default Methods

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(@PathVariable Integer id){
        return movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Error"));
    }
    public Movie addMovie(@RequestBody Movie newMovie){
        return movieRepository.save(newMovie);
    }
    public Optional<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie updatedMovie){
        return movieRepository.findById(id).map(
                exsisting -> {
                    exsisting.setTitle(updatedMovie.getTitle());
                    exsisting.setGenre(updatedMovie.getGenre());
                    exsisting.setPriceTicked(updatedMovie.getPriceTicked());
return movieRepository.save(updatedMovie);

                });
}
    public String deleteMovie(@PathVariable Integer id){
        if (movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return "Movie Deleted";
        }
        return "Error";
    }
    //Find Methods
    public List<Movie > getAllMoviesByTitle(String title){
        return movieRepository.findByTitle(title);
    }
    public List<Movie > getAllMoviesByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
//Pageable
    public Page<Movie> getMoviesByPage(@PathVariable int page, @PathVariable int size){
        Pageable pageable = PageRequest.of(page, size);
        return movieRepository.findAll(pageable);
    }
}
