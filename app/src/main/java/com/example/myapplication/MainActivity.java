package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
   ChipNavigationBar chipNavigationBar;
    View constraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipNavigationBar = findViewById(R.id.chip_app_bar);
        constraint = findViewById(R.id.coordinator);

        chipNavigationBar.setItemSelected(R.id.chip_app_bar,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.root_layout, new HomeFragment()).commit();

        bottom_menu();
    }

    private void bottom_menu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.like:
                        fragment = new FavFragment();
                        break;
                    case R.id.badge:
                        fragment = new BadgeFragment();
                        break;
                    case R.id.Profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.root_layout,fragment).commit();
            }
        });
    }


}