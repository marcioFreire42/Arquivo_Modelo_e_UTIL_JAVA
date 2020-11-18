package com.example.retornoentresctivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActivityComRetornaIntenResult extends AppCompatActivity {

    RadioButton rbOpcao01;
    RadioButton rbOpcao02;
    RadioButton rbOpcao03;
    TextView valorParametro;

    // Essa activity retorna para a MainActivity a opção escolhida pelo usuário, e é finalizada logo em seguida.
    // Ela também setá um TextView com uma mensagem vinda pela Intent que a gerou

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitye_escolha);

        rbOpcao01 = findViewById(R.id.activity_escolha_radioButton01);
        rbOpcao02 = findViewById(R.id.activity_escolha_radioButton2);
        rbOpcao03 = findViewById(R.id.activity_escolha_radioButton3);
        valorParametro = findViewById(R.id.activity_escolha_mensage);

        Intent intent = getIntent(); // Captura a Intent geradora;

        if ((intent.hasExtra("Mensagem"))){
            valorParametro.setText(intent.getStringExtra("Mensagem"));
        }

        rbOpcao01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retornaEscolha("Primeira Opção");
            }
        });

        rbOpcao02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retornaEscolha("Segunda Opção");
            }
        });

        rbOpcao03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retornaEscolha("Terceira Opção");
            }
        });
    }

    private void retornaEscolha(String opcao) {
        Intent intent = new Intent();
        intent.putExtra("retorno", opcao);
        setResult(RESULT_OK, intent); // Avisa que está tudo OK e envia uma intent setada com o valor desejado;
        finish();   // Encerra a activity;
    }
}