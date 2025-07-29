package com.rperezv.service

import com.rperezv.domain.Genre
import com.rperezv.dto.MovieDto
import com.rperezv.mapper.toDtoList
import com.rperezv.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {

    fun getAllMovies() : List<MovieDto> {
        return movieRepository.findAll().toDtoList()
    }

    fun getAllMoviesByGenre(genre: Genre): List<MovieDto> {
        return movieRepository.findByGenre(genre).toDtoList()
    }

}