package com.pmdb.api.controllers;

import com.pmdb.api.models.movie.Movie;
import com.pmdb.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER')")
    public Optional<Movie> getMovie(@PathVariable Long id) {
        return movieService.findById(id);
    }

}
