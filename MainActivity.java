package com.example.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        //Buscar os valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validação dos campos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if( camposValidados ){

            //Converte string para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //Faz o calculo do menor preço.
            Double resultado = valorAlcool / valorGasolina;

            // condição para retornar o melhor preço.
            if( resultado >= 0.7 ){
                textResultado.setText("Melhor utilizar Gasolina!");

            }else{
                textResultado.setText("Melhor usar álcool");
            }
        }else{
            textResultado.setText("Preencha todos os campos!");
        }

    }

    public Boolean validarCampos(String vAlcool, String vGasolina){
        Boolean camposValidados = true;

        if( vAlcool == null || vAlcool.equals("")){
            camposValidados = false;

        }else if( vGasolina == null || vGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}
