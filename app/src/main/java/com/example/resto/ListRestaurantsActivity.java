package com.example.resto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import static com.example.resto.Modele.StructureBDD.*;
import com.example.resto.Modele.DAORestaurant;


public class ListRestaurantsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listrestaurants);


        DAORestaurant clientBdd = new DAORestaurant(this);
        final ListView listViewRestaurants = findViewById(R.id.listViewRestaurants);
        clientBdd.open();
        Cursor c = clientBdd.getDataRestaurant();
        Toast.makeText(getApplicationContext(), "il y a " +
                        String.valueOf(c.getCount()) + " clients dans la table",
                Toast.LENGTH_LONG).show();
        String[] columns = new String[]{COL_NOM, COL_ADRESSE};

        int[] to = new int[]{R.id.textViewNomResto, R.id.textViewAdresse};

        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this,
                R.layout.activity_listrestaurants, c, columns, to, 0);
        listViewRestaurants.setAdapter(dataAdapter);
        clientBdd.close();


        listViewRestaurants.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "id Selectionné : " + String.valueOf(id),Toast.LENGTH_LONG).show();
                Intent i = new Intent(ListRestaurantsActivity.this, AfficheUnRestaurantActivity.class);
                i.putExtra("id", id);
                startActivity(i);
                finish();
            }
        });
    }
}
