package com.example.weather;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button minskWeather;
    private Button vilniusWeather;
    private Button moscowWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minskWeather = this.findViewById(R.id.minskWeather);
        vilniusWeather = this.findViewById(R.id.vilniusWeather);
        moscowWeather = this.findViewById(R.id.moscowWeather);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {});

        String minsk = getString(R.string.minsk);
        String vilnius = getString(R.string.vilnius);
        String moscow = getString(R.string.moscow);
        minskWeather.setOnClickListener(getWeatherButtonListener(this, minsk, launcher));
        vilniusWeather.setOnClickListener(getWeatherButtonListener(this, vilnius, launcher));
        moscowWeather.setOnClickListener(getWeatherButtonListener(this, moscow, launcher));
    }

    private View.OnClickListener getWeatherButtonListener(AppCompatActivity from, String town, ActivityResultLauncher<Intent> launcher){
        Class to = WeatherActivity.class;
        return v -> {
            Intent intent = new Intent(from, to);
            intent.putExtra("town", town);
            launcher.launch(intent);
        };
    }
}