package ir.fatemelyasii.movie.Domain

import ir.fatemelyasii.movie.models.Details
import ir.fatemelyasii.movie.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

   //http://moviesapi.ir/api/v1/movies?page=1
    interface ApiInterface {
        @GET("movies?")
        suspend fun getMovies(
            @Query("page") page: Int
        ): Response<MoviesList>


        // SEND ID TO DETAILS
       @GET("movies/{movie_id}")
       suspend fun getDetailsById(
           @Path("movie_id")id: Int
       ):Response<Details>
    }
