package com.example.resto;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resto.Modele.DAORestaurant;
import com.example.resto.Modele.Restaurant;
import com.example.resto.Modele.Restaurant;
import com.example.resto.Modele.DAORestaurant;

public class NewRestaurantActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newrestaurant);

        //programmation des boutons enregistrer et quitter
        Button btnEnregistrerClient = findViewById(R.id.btnEnregistrerRestaurant);
        Button btnQuitterNewClient = findViewById(R.id.btnQuitterNewClient);

        final DAORestaurant RestaurantBdd = new DAORestaurant(this);
            RestaurantBdd.open();

        //récupération des données saisies
        final EditText nom = findViewById(R.id.editTextPersonName);

        final EditText adresse = findViewById(R.id.editTextadresse);

        final EditText style = findViewById(R.id.editTextStyle);

        final EditText horaire = findViewById(R.id.editTextHoraire);

        final EditText tel = findViewById(R.id.editTextTel);

        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnEnregistrerRestaurant:
                        Toast.makeText(getApplicationContext(), "enregistrement du nouveau restaurant !", Toast.LENGTH_LONG).show();
                        Restaurant unrestaurant = new Restaurant(nom.getText().toString(), adresse.getText().toString(), style.getText().toString(), horaire.getText().toString(), tel.getText().toString());
                        RestaurantBdd.insererRestaurant(unrestaurant);
                        //le curseur pour afficher le nombre de clients dans la base
                        Cursor c = RestaurantBdd.getDataRestaurant();
                        Toast.makeText(getApplicationContext(), " il y a " + String.valueOf(c.getCount()) + " restaurant ", Toast.LENGTH_LONG).show();
                        RestaurantBdd.close();
                        finish();
                        break;
                    case R.id.btnQuitterNewClient:
                        finish();
                        break;

                }
            }
        };
        //on affecte au bouton l'écouteur
        btnEnregistrerClient.setOnClickListener(ecouteur);
        btnQuitterNewClient.setOnClickListener(ecouteur);
    }

}
