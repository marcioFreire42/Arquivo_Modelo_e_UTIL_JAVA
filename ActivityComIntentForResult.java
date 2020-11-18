package com.example.retornoentresctivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityComIntentForResult extends AppCompatActivity {

    TextView resultado;
    Button botaoDeEscolha;
    static int ACAO_BUSCA_PREFERENCIA_USUARIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoDeEscolha = findViewById(R.id.main_activity_button_escolher);

        botaoDeEscolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityComIntentForResult.this, ActivityeEscolha.class);
                intent.putExtra("Mensagem", "Escolha Sabiamente");
                startActivityForResult(intent, ACAO_BUSCA_PREFERENCIA_USUARIO);
                    // O startActivityForResult informa nossa activity que ela espera um retorno, um resultado do próxima activity;
            }
        });
    }

    @Override // Método que recebe o Resultado enviado da activity ativada pelo startActivityForResult;
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            // requestCode é o código da ação executada, no nosso exemplo ACAO_BUSCA_PREFERENCIA_USUARIO;
            // Result código se a ação foi RESULT_OK ou RESULT_CANCELED;
            // E em data recebemos o que foi transferido;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACAO_BUSCA_PREFERENCIA_USUARIO){
            if (resultCode == RESULT_OK){
                resultado = findViewById(R.id.main_activity_texto_opcao_escolhida);
                resultado.setText(data.getStringExtra("retorno"));
            }
        }
    }
}