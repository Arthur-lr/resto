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


        View.OnClickListener ecouteurNewClient = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewRestaurantActivity.class));
            }
        };
        btnNewRestaurant.setOnClickListener(ecouteurNewClient);

        View.OnClickListener ecouteurNewReleve = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListRestaurantsActivity.class));
            }
        };
        btnListeRestaurant.setOnClickListener(ecouteurNewReleve);


    }
}