package com.rperezv.controller

import com.rperezv.domain.Genre
import com.rperezv.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {

    @GetMapping
    fun getAllMovies() = movieService.getAllMovies()

    @GetMapping("{genre}")
    fun getAllMoviesByGenre(@PathVariable genre: Genre) = movieService.getAllMoviesByGenre(genre)

}