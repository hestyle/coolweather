package cn.hestyle.coolweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import cn.hestyle.coolweather.service.AutoUpdateService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.getString("weather", null) != null) {
            // 有缓存则展示
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }
        // 启动自动更新天气缓存的service
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);
    }
}