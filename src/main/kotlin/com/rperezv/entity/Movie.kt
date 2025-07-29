package com.rperezv.entity

import com.rperezv.domain.Genre
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Movie (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var title: String = "",
    var releaseYear: Int = 0,

    @Enumerated(EnumType.STRING)
    var genre: Genre = Genre.UNKNOWN

)
