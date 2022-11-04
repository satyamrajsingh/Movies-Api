package restApi.movie.movieapi.web.restApi

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import restApi.movie.movieapi.dto.MovieDto
import restApi.movie.movieapi.service.MovieService
import restApi.movie.movieapi.utlis.MovieMapper
import java.lang.IllegalArgumentException

@RestController
class MovieController(
    private val movieService: MovieService,
    private val movieMapper: MovieMapper
) {

    @PostMapping
    fun createMovie(@RequestBody movieDto: MovieDto) :ResponseEntity<MovieDto>{
            return ResponseEntity(movieService.createMovie(movieDto),HttpStatus.CREATED)
    }

    @GetMapping
    fun getMovies(): ResponseEntity<List<MovieDto>> =
        ResponseEntity.ok(movieService.getMovies())

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Int) =
        ResponseEntity.ok(movieService.getMovie(id))

    @PutMapping
    fun updateMovie(@RequestBody movieDTO: MovieDto): ResponseEntity<MovieDto> =
        ResponseEntity.ok(movieService.updateMovie(movieDTO))

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Int): ResponseEntity<Unit> =
        ResponseEntity(movieService.deleteMovie(id), HttpStatus.NO_CONTENT)

}