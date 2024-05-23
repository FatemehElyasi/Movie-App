package ir.fatemelyasii.movie.Domain

import com.mkrdeveloper.movieinfoappmvvm.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

   //http://moviesapi.ir/api/v1/movies?page=1
    interface ApiInterface {
        @GET("movies?")
        suspend fun getMovies(
            @Query("page") page: Int
        ): Response<MoviesList>
    }
