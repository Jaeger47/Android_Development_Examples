package com.example.myapplication;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottonNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottonNav = findViewById(R.id.bottomNavBar);

        // Set the initial fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.baseFrag,
                new fragment1()).commit();

        bottonNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;

                int itemId = item.getItemId();

                if (itemId == R.id.home_btn) {
                    selectedFragment = new fragment1();

                } else if (itemId == R.id.list_btn) {
                    selectedFragment = new fragment2();
                } else if (itemId == R.id.notifications_btn) {
                    selectedFragment = new fragment3();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.baseFrag,
                        selectedFragment).commit();

                return true;
            }
        });




    }

}