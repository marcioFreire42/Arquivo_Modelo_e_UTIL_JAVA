package com.example.delivers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.delivers.Activities.Adapters.ListaEnderecosAdapter;
import com.example.delivers.CadastraAlteraEndereco;
import com.example.delivers.R;
import com.example.delivers.arquivosDAO.EnderecosDAO;
import com.example.delivers.arquivosDAO.RoomDao;
import com.example.delivers.databases.EnderecosDatabase;
import com.example.delivers.objetos.Endereco;

import java.util.List;

public class ActivityListEnderecoRoomDao extends AppCompatActivity {

    private ListaEnderecosAdapter adapter; // Criamos um objeto que extende o BaseAdapter, usaremos ele como adapter;
        // private EnderecosDAO daoEndereco = new EnderecosDAO();
    
    private EnderecosDatabase dataBase;
    private RoomDao daoEndereco;
        // Aqui os objetos foram apenas criados, não setados 
        // Porque quando se usa um RoomDao ele não permite setar fora do onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_de_enderecos);

        setTitle("Meus Endereços");

        dataBase = Room.databaseBuilder
                (this, EnderecosDatabase.class, "enderecos.db").allowMainThreadQueries().build();
                // Setando o dataBase, o .allowMainThreadQueries() autoriza o db acessar o celular;

        daoEndereco = Room.databaseBuilder(this, EnderecosDatabase.class, "enderecos.db")
                .allowMainThreadQueries().build().getRoomEnderecoDao();
                // Setando o daoEndereço;

        configuraLista();

        configuraBotaoAdicionaEndereco();
    }

    private void configuraBotaoAdicionaEndereco() {
        Button botaoAdicionaEndereco = findViewById(R.id.botao_adiciona_endereco);
        botaoAdicionaEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityListEnderecoRoomDao.this, CadastraAlteraEndereco.class));
            }
        });
    }

    private void configuraLista() {
        ListView listaDeEnderecos = findViewById(R.id.lista_de_enderecos_listview);
        final List<Endereco> enderecos = new EnderecosDAO().retorna();
        adapter = new ListaEnderecosAdapter(enderecos, this);
        listaDeEnderecos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.atualiza(daoEndereco.retorna());
    }
}