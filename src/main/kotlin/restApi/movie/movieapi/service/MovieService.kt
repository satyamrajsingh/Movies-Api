package restApi.movie.movieapi.service

import restApi.movie.movieapi.dto.MovieDto

interface MovieService {

    fun createMovie(movieDto: MovieDto): MovieDto

    fun getMovies(): List<MovieDto>

    fun getMovie(id: Int): MovieDto

    fun updateMovie(movieDto: MovieDto) : MovieDto

    fun deleteMovie(id: Int)


}