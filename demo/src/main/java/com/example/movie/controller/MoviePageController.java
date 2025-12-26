package com.example.movie.controller;

import com.example.movie.entity.Movie;
import com.example.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/movies")
public class MoviePageController {
    private final MovieService movieService;

    public MoviePageController(MovieService movieService) {
        this.movieService = movieService;
    }
       @GetMapping
    public String list(Model model){
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/list";
   }
      @GetMapping("/new")
        public String form(Model model){
         model.addAttribute("movie",new Movie());
         return "movies/new";
      }
      @PostMapping
    public String save(@ModelAttribute Movie movie){
        movieService.addMovie(movie);
        return "redirect:/list";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("movie",movieService.getMovie(id));
        return "movies/edit";
    }
@PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
      movieService.deleteMovie(id);
      return "redirect:/list";
}
}
