package com.example.resto.Modele;

import static com.example.resto.Modele.StructureBDD.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAORestaurant extends DAOModele {

    public DAORestaurant(Context context) {
        super(context);
    }

    public long insererRestaurant(Restaurant unRestaurant) {
//Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOMRESTO, unRestaurant.getNom());
        values.put(COL_ADRESSE, unRestaurant.getAdresse());
        values.put(COL_STYLE, unRestaurant.getStyle());
        values.put(COL_HORAIRE, unRestaurant.getHoraire());
        values.put(COL_TEL, unRestaurant.getTelephone());

//on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_RESTO, null, values);
    }

    public Cursor getDataRestaurant() {
        return db.rawQuery("SELECT * FROM tresto", null);
    }

    public Restaurant getRestaurantWithId(long id) {

        Cursor c = db.query(TABLE_RESTO, new String[]{COL_IDRESTO,
                        COL_NOMRESTO, COL_ADRESSE, COL_HORAIRE, COL_STYLE,COL_TEL}, COL_IDRESTO + " =\"" +
                id + "\"", null, null, null, null);
        return cursorToRestaurant(c);
    }

    public Restaurant cursorToRestaurant(Cursor c) {
        //Cette méthode permet de convertir un cursor en un client
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        Restaurant unRestaurant = new Restaurant(null, null, null, null, null); //On créé un client
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unRestaurant.setNom(c.getString(1));
        unRestaurant.setAdresse(c.getString(2));
        unRestaurant.setHoraire(c.getString(3));
        unRestaurant.setStyle(c.getString(4));
        unRestaurant.setTelephone(c.getString(5));
        c.close(); //On ferme le cursor
        return unRestaurant; //On retourne le client
    }

    public boolean deleteClient(long id){
        return db.delete(TABLE_RESTO, COL_IDRESTO + "=" + id, null) > 0;
    }
}