package restApi.movie.movieapi.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import restApi.movie.movieapi.entity.Movie

@Repository
interface MovieRepository : CrudRepository<Movie,Int> {
    @Query("SELECT m FROM Movie as m")
    fun getAllMovies(): List<Movie>
}