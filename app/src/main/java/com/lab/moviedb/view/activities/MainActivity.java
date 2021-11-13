package com.lab.moviedb.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.lab.moviedb.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavHostFragment navHostFragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        toolbar = findViewById(R.id.toolbar_main);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main);

        setSupportActionBar(toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.nowPlayingFragment, R.id.upcomingFragment).build();
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.getNavController(), appBarConfiguration);

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navHostFragment.getNavController().navigateUp() || super.onSupportNavigateUp();
    }
}