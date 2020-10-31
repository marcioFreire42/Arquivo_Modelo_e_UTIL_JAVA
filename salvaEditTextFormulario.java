package com.example.delivers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.delivers.arquivosDAO.EnderecosDAO;
import com.example.delivers.objetos.Endereco;

public class CadastraAlteraEndereco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastra_altera_endereco);
        setTitle("Atualiza / Cadastra Endereço");

        final EditText campoNomedaRua = findViewById(R.id.formulario_nome_da_rua);
        final EditText campoNumero = findViewById(R.id.numero_da_casa);
        final EditText campoBairro = findViewById(R.id.bairro);
        final EditText campoComplemento = findViewById(R.id.complemento);
        final EditText campoNomeDoEndereco = findViewById(R.id.nome_deste_endereco);
        final EditText campoDica = findViewById(R.id.dica);
            //Associa campos e layouts;

        Button botaoSalvarEndereco = findViewById(R.id.botao_salvar);

        botaoSalvarEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Ação executada quando o botão for clicado;
                String nomeDoEndereco = campoNomeDoEndereco.getText().toString();
                String rua = campoNomedaRua.getText().toString();
                String numero = campoNumero.getText().toString();
                String bairro = campoBairro.getText().toString();
                String complemento = campoComplemento.getText().toString();
                String dica = campoDica.getText().toString();
                    // Objetos setados pelas edittext;

                Endereco novoEndereco = new Endereco(nomeDoEndereco, rua, bairro, numero, complemento, dica);
                    // Objeto criado com as informações recebidas pelos EditTexts;

                EnderecosDAO enderecosDAO = new EnderecosDAO();
                enderecosDAO.salvaEndereco(novoEndereco);

                Toast.makeText(CadastraAlteraEndereco.this,  "Endereço " + novoEndereco.toString(),
                        Toast.LENGTH_LONG).show();
                // Toast que recebe os dados do nova classe e mostra em tela.

                finish(); // Conclui e encerra essa activity;
            }
        });

    }
}