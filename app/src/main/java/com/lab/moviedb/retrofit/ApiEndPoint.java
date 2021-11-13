package com.lab.moviedb.retrofit;

import com.lab.moviedb.model.Movies;
import com.lab.moviedb.model.NowPlaying;
import com.lab.moviedb.model.Upcoming;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("movie/{movie_id}")
    Call<Movies> getMovieById(
            @Path("movie_id") String movieId,
            @Query("api_key") String apiKey
    );

    @GET("movie/now_playing")
    Call<NowPlaying> getNowPlaying(
            @Query("api_key") String apiKey
    );

    @GET("movie/upcoming")
    Call<Upcoming> getUpcoming(
            @Query("api_key") String apiKey
    );
}
