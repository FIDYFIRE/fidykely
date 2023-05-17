package com.example.fidy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidy.R;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextTextPersonName;
    TextView textView2;
    SmsManager s1;
    ListView list1;

    String [] vecteur = { "Sony Ericsson" , "Apple" , "Samsung" , "Redmi","Sony Ericsson" , "Apple" , "Samsung" , "Redmi"};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        textView2 = findViewById(R.id.textView2);
        list1 = findViewById(R.id.list1);
                adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, vecteur);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, list1.getItemAtPosition(position).toString() , Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this , MainActivity2.class);
                //i.putExtra("Telephone", "0340673926");
                i.putExtra("nom", list1.getItemAtPosition(position).toString());
                startActivity(i);
            }
        });

        textView2.setText("TEST123");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView2.setText("Bonsoir" + " " + editTextTextPersonName.getText() );
                //Toast.makeText(MainActivity.this, "Message envoyé " + editTextTextPersonName.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}