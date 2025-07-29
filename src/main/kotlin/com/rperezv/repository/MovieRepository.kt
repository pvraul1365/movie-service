package com.rperezv.repository

import com.rperezv.domain.Genre
import com.rperezv.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Int> {

    fun findByGenre(genre: Genre): List<Movie>

}