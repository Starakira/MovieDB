package com.lab.moviedb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lab.moviedb.model.Movies;
import com.lab.moviedb.model.NowPlaying;
import com.lab.moviedb.model.Upcoming;
import com.lab.moviedb.repositories.MovieRepository;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = MovieRepository.getInstance();
    }

    //==Begin of ViewModel getMoviebyID

    private MutableLiveData<Movies> resultGetMovieById = new MutableLiveData<>();

    public void getMovieById(String movieId) {
        resultGetMovieById = repository.getMovieData(movieId);
    }

    public LiveData<Movies> getResultGetMovieById() {
        return resultGetMovieById;
    }

    //==End of ViewModel getMoviebyID

    //==Begin of ViewModel getNowPlaying

    private MutableLiveData<NowPlaying> resultGetNowPlaying = new MutableLiveData<>();

    public void getNowPlaying() {
        resultGetNowPlaying = repository.getNowPlayingData();
    }

    public LiveData<NowPlaying> getResultNowPlaying() {
        return resultGetNowPlaying;
    }

    //==End of ViewModel getNowPlaying

    //==Begin of viewmodel get upcoming
    private MutableLiveData<Upcoming> resultGetUpcoming = new MutableLiveData<>();

    public void getUpcoming() {
        resultGetUpcoming = repository.getUpcomingData();
    }

    public LiveData<Upcoming> getResultUpcoming() {
        return resultGetUpcoming;
    }
    //==End of viewmodel get upcoming

}
