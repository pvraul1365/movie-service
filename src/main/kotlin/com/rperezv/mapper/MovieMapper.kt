package com.rperezv.mapper

import com.rperezv.dto.MovieDto
import com.rperezv.entity.Movie

fun Movie.toDto(): MovieDto = MovieDto(
    id = this.id,
    title = this.title,
    releaseYear = this.releaseYear,
    genre = this.genre
)

fun MovieDto.toEntity(): Movie = Movie(
    id = this.id,
    title = this.title,
    releaseYear = this.releaseYear,
    genre = this.genre
)

fun List<Movie>.toDtoList(): List<MovieDto> = this.map { it.toDto() }