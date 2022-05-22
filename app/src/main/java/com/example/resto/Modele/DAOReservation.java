package com.example.resto.Modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import static com.example.resto.Modele.StructureBDD.*;

public class DAOReservation extends DAOModele {

    public DAOReservation(Context context) {
        super(context);
    }

    public long insererReservation(Reservation unReservation) {
//Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOMRESTAU, unReservation.getNomrestau());
        values.put(COL_NOMRESA, unReservation.getNomresa());
        values.put(COL_HORAIRERESA, unReservation.getHoraire());
        values.put(COL_NBPERS, unReservation.getNbpersonnes());

//on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_RESA, null, values);
    }

    public Cursor getDataReservation() {
        return db.rawQuery("SELECT * FROM tresa", null);
    }

    public Reservation getReservationWithId(long id) {

        Cursor c = db.query(TABLE_RESA, new String[]{COL_IDRESA,
                        COL_NOMRESTAU, COL_NOMRESTAU, COL_NOMRESA, COL_HORAIRERESA,COL_NBPERS}, COL_IDRESA + " =\"" +
                id + "\"", null, null, null, null);
        return cursorToReservation(c);
    }

    public Reservation cursorToReservation(Cursor c) {
        //Cette méthode permet de convertir un cursor en un client
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        Reservation unReservation = new Reservation(null,null,null, null); //On créé une resa
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unReservation.setNomrestau(c.getString(1));
        unReservation.setNomresa(c.getString(2));
        unReservation.setHoraire(c.getString(3));
        unReservation.setNbpersonnes(c.getString(4));
        c.close(); //On ferme le cursor
        return unReservation; //On retourne le client
    }

    public boolean deleteReservation(long id){
        return db.delete(TABLE_RESA, COL_IDRESA + "=" + id, null) > 0;
    }
}