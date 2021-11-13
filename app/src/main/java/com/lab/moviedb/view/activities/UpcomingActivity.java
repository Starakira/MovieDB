package com.lab.moviedb.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lab.moviedb.R;
import com.lab.moviedb.adapter.UpcomingAdapter;
import com.lab.moviedb.model.Upcoming;
import com.lab.moviedb.viewmodel.MovieViewModel;

public class UpcomingActivity extends AppCompatActivity {

    private RecyclerView rv_upcoming;
    private MovieViewModel view_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);

        rv_upcoming = findViewById(R.id.rv_upcoming);

        view_model = new ViewModelProvider(UpcomingActivity.this).get(MovieViewModel.class);

        view_model.getUpcoming();

        view_model.getResultUpcoming().observe(UpcomingActivity.this, showUpcoming);
    }

    private Observer<Upcoming> showUpcoming = new Observer<Upcoming>() {
        @Override
        public void onChanged(Upcoming upComing) {
            rv_upcoming.setLayoutManager(new LinearLayoutManager(UpcomingActivity.this));
            UpcomingAdapter adapter = new UpcomingAdapter(UpcomingActivity.this);
            adapter.setListUpcoming(upComing.getResults());
            rv_upcoming.setAdapter(adapter);
        }
    };
}