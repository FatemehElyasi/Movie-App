package ir.fatemelyasii.movie.models

import ir.fatemelyasii.movie.models.Data
import ir.fatemelyasii.movie.models.Metadata

data class MoviesList(
    val data: List<Data>,
    val metadata: Metadata
)