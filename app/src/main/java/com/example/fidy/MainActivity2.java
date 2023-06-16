package com.example.fidy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText e2, e3, e4;
    Button inserer;
    SQLiteOpenHelper helper;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        inserer = findViewById(R.id.inserer);

        /* Intent x = getIntent();
        e2.setText( x.getStringExtra("nom"));
        */
        helper = new SQLiteOpenHelper(MainActivity2.this, "Database.db", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE Voitures ( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, Nom TEXT, Prix REAL, Couleur TEXT, Annee INTEGER, Km INTEGER, Marque TEXT)");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL(" DROP TABLE Voitures");
                onCreate(db);
            }
        };
        database = helper.getWritableDatabase();

        inserer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.execSQL(" INSERT INTO Voitures (Nom, Prix, Km) VALUES ( '" + e2.getText() + "', "+ e3.getText()+", "+ e4.getText()+" )");
            }
        });
    }
}