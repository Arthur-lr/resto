package com.example.resto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.resto.Modele.Restaurant;
import com.example.resto.Modele.DAORestaurant;

public class AfficheUnRestaurantActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficheunrestaurant);

        long idcli = getIntent().getLongExtra("id", 0);

        DAORestaurant restaurantBdd = new DAORestaurant(this);
        restaurantBdd.open();

        Restaurant restaurant = restaurantBdd.getRestaurantWithId(idcli);

        TextView Nom = findViewById(R.id.textViewNom);
        TextView Adresse = findViewById(R.id.textViewAdresse);
        TextView Horaire = findViewById(R.id.textViewhoraire);
        TextView Style = findViewById(R.id.textViewstyle);
        TextView Telephone = findViewById(R.id.textViewTel);

        Nom.setText(restaurant.getNom());
        Adresse.setText(restaurant.getAdresse());
        Horaire.setText(restaurant.getHoraire());
        Style.setText(restaurant.getStyle());
        Telephone.setText(restaurant.getTelephone());

        Button btnSupprimerUnClient = findViewById(R.id.btnSupprimerUnClient);
        Button btnQuitter = findViewById(R.id.btnQuitterAfficheUnClient);

        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnSupprimerUnClient:
                        restaurantBdd.deleteClient(idcli);
                        finish();
                        break;
                    case R.id.btnQuitterAfficheUnClient:
                        finish();
                        break;

                }
            }
        };
        btnSupprimerUnClient.setOnClickListener(ecouteur);
        btnQuitter.setOnClickListener(ecouteur);


    }
}
