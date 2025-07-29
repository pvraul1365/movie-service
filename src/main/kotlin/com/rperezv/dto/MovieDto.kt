package com.rperezv.dto

import com.rperezv.domain.Genre

data class MovieDto(
    var id: Int? = null,
    var title: String = "",
    var releaseYear: Int = 0,
    var genre: Genre = Genre.UNKNOWN
)
