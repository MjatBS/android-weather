package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    private WebView webWeatherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Intent intent = getIntent();
        String town = intent.getStringExtra("town");

        webWeatherView = this.findViewById(R.id.webWeatherView);
        webWeatherView.getSettings().setJavaScriptEnabled(true);
        if(town.equals(getString(R.string.minsk))){
            String htmlCodeWeather = "<a class=\"weatherwidget-io\" href=\"https://forecast7.com/en/53d9027d56/minsk/\" data-label_1=\"MINSK\" data-label_2=\"WEATHER\" data-theme=\"original\" >MINSK WEATHER</a>\n" +
                    "<script>\n" +
                    "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');\n" +
                    "</script>";
            String base64 = Base64.encodeToString(htmlCodeWeather.getBytes(), Base64.DEFAULT);
            webWeatherView.loadData(base64,"text/html; charset=utf-8", "base64");
        }
        else if(town.equals(getString(R.string.vilnius))){
            String htmlCodeWeather = "<a class=\"weatherwidget-io\" href=\"https://forecast7.com/en/54d6925d28/vilnius/\" data-label_1=\"VILNIUS\" data-label_2=\"WEATHER\" data-theme=\"original\" >VILNIUS WEATHER</a>\n" +
                    "<script>\n" +
                    "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');\n" +
                    "</script>";
            String base64 = Base64.encodeToString(htmlCodeWeather.getBytes(), Base64.DEFAULT);
            webWeatherView.loadData(base64,"text/html; charset=utf-8", "base64");
        }
        else if(town.equals(getString(R.string.moscow))){
            String htmlCodeWeather = "<a class=\"weatherwidget-io\" href=\"https://forecast7.com/en/55d7637d62/moscow/\" data-label_1=\"MOSCOW\" data-label_2=\"WEATHER\" data-theme=\"original\" >MOSCOW WEATHER</a>\n" +
                    "<script>\n" +
                    "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');\n" +
                    "</script>";
            String base64 = Base64.encodeToString(htmlCodeWeather.getBytes(), Base64.DEFAULT);
            webWeatherView.loadData(base64,"text/html; charset=utf-8", "base64");
        }
    }

}