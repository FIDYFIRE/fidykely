package com.example.fidy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity2 extends AppCompatActivity {

    EditText e2, e3, e4, e5;
    Button inserer;
    ListView list2;
    SimpleCursorAdapter adapter;
    SQLiteOpenHelper helper;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        inserer = findViewById(R.id.inserer);
        list2 = findViewById(R.id.list2);

        /* Intent x = getIntent();
        e2.setText( x.getStringExtra("nom"));
        */
        helper = new SQLiteOpenHelper(MainActivity2.this, "Database2.db", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE Voitures ( _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, Nom TEXT, Prix REAL, Couleur TEXT, Annee INTEGER, Km INTEGER, Marque TEXT)");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL(" DROP TABLE Voitures");
                onCreate(db);
            }
        };

        database = helper.getReadableDatabase();
        Cursor c =  database.rawQuery(" SELECT * FROM Voitures ", null);
        c.moveToNext();

        String [] from = {"Nom", "Prix", "Km"};
        int [] to = { R.id.x1, R.id.x2, R.id.x3  };
        adapter = new SimpleCursorAdapter(MainActivity2.this, R.layout.element,c, from, to, 0);

        list2.setAdapter(adapter);

        inserer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = helper.getWritableDatabase();
                database.execSQL(" INSERT INTO Voitures (Nom, Prix, Km) VALUES ( '" + e2.getText() + "', "+ e3.getText()+", "+ e4.getText()+" )");
            }
        });
    }
}