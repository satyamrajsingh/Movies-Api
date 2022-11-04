package restApi.movie.movieapi.utlis

import restApi.movie.movieapi.dto.MovieDto
import javax.swing.text.html.parser.Entity

interface Mapper<D,E> {

    //for mapping from Entity object to Dto
    fun fromEntity(entity: E): D


    //for mapping Dto object toEntity
    fun toEntity(dto: D): E

}