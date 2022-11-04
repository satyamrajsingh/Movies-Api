package restApi.movie.movieapi.utlis

import org.springframework.stereotype.Component
import restApi.movie.movieapi.dto.MovieDto
import restApi.movie.movieapi.entity.Movie
import javax.swing.text.html.parser.Entity


@Component
class MovieMapper: Mapper<MovieDto,Movie>{
    override fun fromEntity(entity: Movie): MovieDto = MovieDto(
            id=entity.id,
            name=entity.name,
            rating = entity.rating
    )



    override fun toEntity(dto: MovieDto): Movie = Movie(
               id=dto.id,
               name = dto.name,
               rating = dto.rating
    )




}