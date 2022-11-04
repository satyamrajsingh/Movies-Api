package restApi.movie.movieapi.service

import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import restApi.movie.movieapi.dto.MovieDto
import restApi.movie.movieapi.repository.MovieRepository
import restApi.movie.movieapi.utlis.MovieMapper
import restApi.movie.movieapi.utlis.exceptions.MovieException
import java.lang.IllegalArgumentException

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {

    override fun createMovie(movieDto: MovieDto): MovieDto {

        if(movieDto.id != null){
            throw IllegalArgumentException("Id must be null")
        }

        val movie=movieMapper.toEntity(movieDto)
        movieRepository.save(movie)
        return movieMapper.fromEntity(movie)

    }
    override fun getMovies(): List<MovieDto> {
        val movies = movieRepository.getAllMovies()

        if (movies.isEmpty())
            throw MovieException("List of movies is empty.")

        return movies.map {
            movieMapper.fromEntity(it)
        }
    }

    override fun getMovie(id: Int):MovieDto{
        val optionalMovie = movieRepository.findById(id)
        val movie = optionalMovie.orElseThrow{ MovieException("Movie with id $id is not present") }
        return movieMapper.fromEntity(movie)
    }
    override fun updateMovie(movieDto: MovieDto): MovieDto {

        if(movieDto.id==null) throw MovieException("Id is missing")

        val exists = movieRepository.existsById(movieDto.id)

        if(!exists) throw MovieException("Movie with id ${movieDto.id} is not present")

        if(movieDto.rating == 0.0 || movieDto.name == "Default movie")
           throw MovieException("Complete movie object is expected")

        movieRepository.save(movieMapper.toEntity(movieDto))
        return movieDto


    }

    override fun deleteMovie(id: Int) {
        val exists = movieRepository.existsById(id)

        if (!exists)
            throw MovieException("Movie with id $id is not present")

        movieRepository.deleteById(id)
    }
}