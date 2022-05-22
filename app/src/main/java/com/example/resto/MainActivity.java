package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewRestaurant = findViewById(R.id.btnNvRestaurant);
        Button btnListeRestaurant = findViewById(R.id.btnlisteresto);
        Button btnNewReservation = findViewById(R.id.btnreserver);
  //      Button btnListeReservation = findViewById(R.id.btnListeRservation);


        View.OnClickListener ecouteurNewRestaurant = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewRestaurantActivity.class));
            }
        };
        btnNewRestaurant.setOnClickListener(ecouteurNewRestaurant);


        View.OnClickListener ecouteurListRestaurants = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListRestaurantsActivity.class));
            }
        };
        btnListeRestaurant.setOnClickListener(ecouteurListRestaurants);


        View.OnClickListener ecouteurNewReservation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewReservationActivity.class));
            }
        };
        btnNewReservation.setOnClickListener(ecouteurNewReservation);

/*
        View.OnClickListener ecouteurListReservation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListRestaurantsActivity.class));
            }
        };
        btnListeReservation.setOnClickListener(ecouteurListReservation);
    }
    */
}
}