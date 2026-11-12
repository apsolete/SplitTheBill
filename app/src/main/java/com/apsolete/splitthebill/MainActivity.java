package com.apsolete.splitthebill;

import android.os.Bundle;

import com.apsolete.splitthebill.dao.AppDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.apsolete.splitthebill.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = AppDatabase.getInstance(getApplicationContext());

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // распределяем отступы точечно
        ViewCompat.setOnApplyWindowInsetsListener(binding.container, (v, windowInsets) -> {
            Insets systemBars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());

            // 1. Фрагменту (или контейнеру) отдаем только верхний отступ (под AppBar)
            binding.navHostFragmentActivityMain.setPadding(0, systemBars.top, 0, 0);

            // 2. Нижней панели отдаем только нижний отступ (под жесты/кнопки навигации)
            binding.navView.setPadding(0, 0, 0, systemBars.bottom);

            return WindowInsetsCompat.CONSUMED; // Указываем, что отступы успешно обработаны
        });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_party, R.id.navigation_party_edit, R.id.navigation_mate, R.id.navigation_bill, R.id.navigation_split)
                .build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_activity_main);

        if (navHostFragment != null) {
            BottomNavigationView navView = findViewById(R.id.nav_view);
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(navView, navController);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.options_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.add_mate_item) {
//
//        }
//        else if (id == R.id.add_dish_item) {
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public static AppDatabase getDb() {
        return database;
    }
}