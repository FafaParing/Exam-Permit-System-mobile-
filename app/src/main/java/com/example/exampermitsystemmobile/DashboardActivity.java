package com.example.exampermitsystemmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_dashboard);

        // INIT VIEWS
        bottomNav = findViewById(R.id.bottomNav);
        topAppBar = findViewById(R.id.topAppBar);

        // =========================
        // TOP APP BAR ACTIONS
        // =========================
        topAppBar.setOnMenuItemClickListener(item -> {

            int id = item.getItemId();

            if (id == R.id.action_notifications) {
                Toast.makeText(this, "No new notifications", Toast.LENGTH_SHORT).show();
                return true;
            }

            if (id == R.id.action_logout) {
                Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();

                // go back to login
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                return true;
            }

            return false;
        });

        // =========================
        // BOTTOM NAVIGATION
        // =========================
        bottomNav.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_dashboard) {
                return true;

            } else if (id == R.id.nav_permit) {
                startActivity(new Intent(this, PermitActivity.class));
                return true;

            } else if (id == R.id.nav_records) {
                startActivity(new Intent(this, RecordsActivity.class));
                return true;
            }

            return false;
        });
    }
}