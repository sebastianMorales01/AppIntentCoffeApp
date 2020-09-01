package com.example.appintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CoffeActivity extends AppCompatActivity {

    private String name;
    private TextView titulo,txtcantidad;
    private CheckBox opt1,opt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe);

        titulo =findViewById(R.id.txtTitulo);
        txtcantidad=findViewById(R.id.txtcantidad);
        opt1=findViewById(R.id.opt1);
        opt2=findViewById(R.id.opt2);

        name= getIntent().getStringExtra(MainActivity.NAME);

        titulo.setText("Order of "+name);

    }
    public void less(View view) {
        int cant = Integer.parseInt(txtcantidad.getText().toString());
        if (cant>1){
            int cantidad= cant-1;
            txtcantidad.setText(""+cantidad);
        }
    }
    public void more(View view) {
        int cant = Integer.parseInt(txtcantidad.getText().toString());
        if (cant<10){
            int cantidad= cant+1;
            txtcantidad.setText(""+cantidad);
        }
    }

    public void order(View view) {
        /*Negocio only coffee $3
                    cream $1 - chocolate $2 */
        int agrecrem=0;
        int agrechoc=0;
        int tfinal=0;
        String crem = "", choc="";
        if (opt1.isChecked()){ //true si esta marcado
            agrecrem=1;
            crem = opt1.getText().toString(); //optenermos el texto
        }
        if (opt2.isChecked()){ //true si esta marcado
            agrechoc=2;
            choc = opt2.getText().toString(); //optenermos el texto
        }
        int agre=agrecrem+agrechoc;
        int cant = Integer.parseInt(txtcantidad.getText().toString());
        int num = cant*3;
        if (agre >0){
            int total= cant*agre;
             tfinal=num+total;
        }else{
             tfinal=num;
        }

        Uri uri= Uri.parse("mailto: contact@coffe.com");
        Intent intent=new Intent(Intent.ACTION_SENDTO,uri);

        intent.putExtra(Intent.EXTRA_TEXT,"description: "+cant+" coffe, "+crem+" "+choc);
        intent.putExtra(Intent.EXTRA_TEXT,"total $"+tfinal);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order of "+name);

        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
    public void call(View view) {
        Uri uri =Uri.parse("tel:133");
        Intent intent=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}