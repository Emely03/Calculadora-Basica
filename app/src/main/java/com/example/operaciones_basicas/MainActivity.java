package com.example.operaciones_basicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Diseño de los objetos de java equivalentes a los objetos de xml
    EditText jetnumero1, jetnumero2;
    TextView jtvsuma, jtvresta, jtvmultiplicacion, jtvdivision;
    Button jbtcalcular, jbtlimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Esconder el titulo por defecto
        getSupportActionBar().hide();

        //Asociando objetos Java con los objetos xml
        jetnumero1=findViewById(R.id.etnumero1);
        jetnumero2 = findViewById(R.id.etnumero2);
        jtvsuma=findViewById(R.id.tvsuma);
        jtvresta=findViewById(R.id.tvresta);
        jtvmultiplicacion=findViewById(R.id.tvmultiplicacion);
        jtvdivision=findViewById(R.id.tvdivision);
        jbtcalcular=findViewById(R.id.btcalcular);
        jbtlimpiar=findViewById(R.id.btlimpiar);

    }
    //Si no se coloca View no se puede llamar, convertir al numero toString(), numeros vacios .isEmpty() ;
    public void calcular (View view){
        String numero1, numero2;
        numero1=jetnumero1.getText().toString();
        numero2=jetnumero2.getText().toString();
        if (numero1.isEmpty() || numero2.isEmpty()){
            Toast.makeText(this, "Los dos números son requeridos", Toast.LENGTH_SHORT).show();
            jetnumero1.requestFocus();
        }
        else{
            //convertir a entero Integer.parseInt y covertir a float Float.parseFloat
            float num1, num2, suma, resta, multiplicacion, division;
            num1=Float.parseFloat(numero1);
            num2=Float.parseFloat(numero2);
            suma=num1 + num2;
            resta=num1 - num2;
            multiplicacion= num1 * num2;

            jtvsuma.setText(String.valueOf(suma));
            jtvresta.setText(String.valueOf(resta));
            jtvmultiplicacion.setText(String.valueOf(multiplicacion));
            if (num2 == 0)
                Toast.makeText(this, "Division no valida", Toast.LENGTH_SHORT).show();
            else {
                division = num1 / num2;
                jtvdivision.setText(String.valueOf(division));
            }
        }
    }
    public void Limpiar (View view){
        jetnumero1.setText("");
        jetnumero2.setText("");
        jetnumero1.requestFocus();
    }
}