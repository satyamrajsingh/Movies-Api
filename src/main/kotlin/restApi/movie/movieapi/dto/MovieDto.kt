package restApi.movie.movieapi.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


data class MovieDto (


    val id: Int? = null,
    var name: String,
    var rating: Double

)