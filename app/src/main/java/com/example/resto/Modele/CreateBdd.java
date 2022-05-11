package com.example.resto.Modele;

import static com.example.resto.Modele.StructureBDD.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBdd extends SQLiteOpenHelper {

    private static final String CREATE_TABLERESTO = "CREATE TABLE " + TABLE_RESTO + " ("+COL_IDRESTO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM + " TEXT NOT NULL, " + COL_ADRESSE + " TEXT NOT NULL, " + COL_HORAIRE + " TEXT NOT NULL, " + COL_STYLE + " TEXT NOT NULL," + COL_TEL + " TEXT NOT NULL);";

 //   private static final String CREATE_TABLERELEVE = "CREATE TABLE " + TABLE_RELEVE + " ("+ COL_IDRELEVE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_HP + " TEXT NOT NULL, " + COL_HC + " TEXT NOT NULL," + COL_RAISON + " TEXT NOT NULL," + COL_IDCLI + " INTEGER NOT NULL);";

    public CreateBdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //méthodes d'instance permettant la gestion de l'objet
    @Override
    public void onCreate(SQLiteDatabase db) {
        //appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLERESTO);
  //      db.execSQL(CREATE_TABLERELEVE);

    }
    // appelée si la version de la base a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut  supprimer la table et de la recréer
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTO + ";");
  //      db.execSQL("DROP TABLE IF EXISTS " + TABLE_RELEVE + ";");
        onCreate(db);
    }
}
