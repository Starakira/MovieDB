package com.lab.moviedb.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lab.moviedb.R;
import com.lab.moviedb.helper.Const;
import com.lab.moviedb.model.Movies;
import com.lab.moviedb.viewmodel.MovieViewModel;

public class MovieDetailsActivity extends AppCompatActivity {

    private TextView lbl_title, lbl_synopsis, lbl_genre, lbl_duration, lbl_rating;
    private ImageView img_poster_details;
    private MovieViewModel viewModel;
    private String movie_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        lbl_title = findViewById(R.id.lbl_title_card_moviedetails);
        lbl_synopsis = findViewById(R.id.lbl_synopsis_card_moviedetails);
        lbl_genre = findViewById(R.id.lbl_genre_card_moviedetails);
        lbl_duration = findViewById(R.id.lbl_duration_card_moviedetails);
        lbl_rating = findViewById(R.id.lbl_rating_card_moviedetails);
        img_poster_details = findViewById(R.id.img_poster_card_moviedetails);

        viewModel = new ViewModelProvider(MovieDetailsActivity.this).get(MovieViewModel.class);

        Intent intent = getIntent();
        movie_id = intent.getStringExtra("movie_id");



        viewModel.getMovieById(movie_id);
        viewModel.getResultGetMovieById().observe(MovieDetailsActivity.this, showMovieDetails);
    }

    private Observer<Movies> showMovieDetails = new Observer<Movies>() {
        @Override
        public void onChanged(Movies movies) {
            String title = movies.getTitle();
            String synopsis = movies.getOverview();
            String duration = String.valueOf(movies.getRuntime());
            String rating = String.valueOf(movies.getVote_average());
            String genre = "";
            String img_path = Const.IMG_URL + movies.getPoster_path().toString();

            Glide.with(MovieDetailsActivity.this).load(img_path).into(img_poster_details);
            for (int i = 0; i < movies.getGenres().size(); i++) {
                if (i == movies.getGenres().size() - 1) {
                    genre += movies.getGenres().get(i).getName();
                } else {
                    genre += movies.getGenres().get(i).getName() + ", ";
                }
            }
            lbl_title.setText(title);
            lbl_synopsis.setText(synopsis);
            lbl_duration.setText(duration);
            lbl_rating.setText(rating);
            lbl_genre.setText(genre);
        }
    };

    @Override
    public void onBackPressed() {
        finish();
    }
}