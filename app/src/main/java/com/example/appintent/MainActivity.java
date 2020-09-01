package com.example.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    public static final String NAME="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt1);
    }

    public void confirm(View view) {
        if(txt.getText().toString().isEmpty()){
            Toast.makeText(this,"Please complete your name",Toast.LENGTH_LONG).show();
        }else{
            Intent intent= new Intent(this,CoffeActivity.class);
            intent.putExtra(NAME,txt.getText().toString().toUpperCase());
            startActivity(intent);
        }
    }

}