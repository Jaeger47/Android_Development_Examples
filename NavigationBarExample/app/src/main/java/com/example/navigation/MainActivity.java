package com.example.navigation;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottonNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottonNav = findViewById(R.id.bottomNavigationView);

        // Set the initial fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,
                new FirstFragment()).commit();

        bottonNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;

                int itemId = item.getItemId();

                if (itemId == R.id.home_btn) {
                    selectedFragment = new FirstFragment();
                } else if (itemId == R.id.dashboard_btn) {
                    selectedFragment = new SecondFragment();
                } else if (itemId == R.id.notifications_btn) {
                    selectedFragment = new ThridFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,
                        selectedFragment).commit();

                return true;
            }
        });




    }
}
