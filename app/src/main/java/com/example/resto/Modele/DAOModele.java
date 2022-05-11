package com.example.resto.Modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DAOModele {
    static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "Edfv1.db";
    protected final CreateBdd tableCourante;
    protected final Context context;
    protected SQLiteDatabase db;

    public DAOModele(Context context) {
        this.context = context;
        tableCourante = new CreateBdd(context, NOM_BDD, null, VERSION_BDD);
    }
    public DAOModele open() {
        db = tableCourante.getWritableDatabase();
        return this;
    }
    public CreateBdd close() {
        db.close();
        return null;
    }
}
