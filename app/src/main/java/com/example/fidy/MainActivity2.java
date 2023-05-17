package com.example.fidy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e2 = findViewById(R.id.e2);

        intent x = getIntent();
        e2.setText( x.getStringExtra("nom"));

    }
}