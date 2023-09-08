package com.theshekharmaharaj.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Declarations
    EditText searchField;
    TextView dayContainer, locationContainer,temperatureContainer,humidityContainer,windContainer;
    ImageView imageView;
    public String apiURL = "http://api.openweathermap.org/data/2.5/weather";
    public String apiKey = "1a810c5e406e7810b55b3ea6aecb3d58";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all components
        searchField = findViewById(R.id.searchField);
        dayContainer = findViewById(R.id.dayContainer);
        locationContainer = findViewById(R.id.locationContainer);
        temperatureContainer = findViewById(R.id.temperatureContainer);
        humidityContainer = findViewById(R.id.humidityContainer);
        windContainer = findViewById(R.id.windContainer);
        imageView = findViewById(R.id.imageView);

    }

    public void GetWeatherDetails(View view) {
        String tempURL = "";
        String city = searchField.getText().toString().trim();

        if(city.equals("")){
            // Throw error
        }else{
            tempURL = apiURL + "?q="+city+"&appid"+apiKey;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, tempURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_SHORT).show();
            }
        });
        // Instantiate the request queue
    }
}