package com.example.resto;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resto.Modele.DAOReservation;
import com.example.resto.Modele.Reservation;

public class NewReservationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newreservation);

        //programmation des boutons enregistrer et quitter
        Button btnEnregisterReservation = findViewById(R.id.btnEnregistrerReservation);
        Button btnQuitterNewReservation = findViewById(R.id.btnQuitternewreservation);

        final DAOReservation ReservationBdd = new DAOReservation(this);
            ReservationBdd.open();

        //récupération des données saisies
        final EditText nomresto = findViewById(R.id.editTextnomresto);

        final EditText nomresa = findViewById(R.id.editTextNomresa);

        final EditText nbpers = findViewById(R.id.editTextnbpersonne);

        final EditText horaire = findViewById(R.id.editTextHoraireresa);



        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnEnregistrerReservation:
                        Toast.makeText(getApplicationContext(), "enregistrement d'une nouvelle réservation !", Toast.LENGTH_LONG).show();
                        Reservation unReservation = new Reservation(nomresto.getText().toString(), nomresa.getText().toString(), nbpers.getText().toString(), horaire.getText().toString());
                        ReservationBdd.insererReservation(unReservation);
                        //le curseur pour afficher le nombre de clients dans la base
                        Cursor c = ReservationBdd.getDataReservation();
                        Toast.makeText(getApplicationContext(), " il y a " + String.valueOf(c.getCount()) + " réservations ", Toast.LENGTH_LONG).show();
                        ReservationBdd.close();
                        finish();
                        break;
                    case R.id.btnQuitternewreservation:
                        finish();
                        break;

                }
            }
        };
        //on affecte au bouton l'écouteur
        btnEnregisterReservation.setOnClickListener(ecouteur);
        btnQuitterNewReservation.setOnClickListener(ecouteur);
    }

}
