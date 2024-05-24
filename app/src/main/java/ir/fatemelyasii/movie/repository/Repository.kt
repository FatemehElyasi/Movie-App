package ir.fatemelyasii.movie.repository

import ir.fatemelyasii.movie.models.MoviesList
import ir.fatemelyasii.movie.Utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page: Int): Response<MoviesList> {
        return RetrofitInstance.api.getMovies(page)
    }
}
