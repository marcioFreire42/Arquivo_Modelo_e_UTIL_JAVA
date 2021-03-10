package com.example.delivers.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.delivers.arquivosDAO.RoomDao;
import com.example.delivers.objetos.Endereco;

@Database(entities = {Endereco.class}, version = 1, exportSchema = false)
    // entities representa o objeto que servirá de base para este Database;
    // Version é o número da versão, podemos usar o 1 mesmo;
    // exportSchema false é para não ficar criando automaticamente arquivos jason;
public abstract class EnderecosDatabase extends RoomDatabase {

    public abstract RoomDao getRoomEnderecoDao();
    
    public static EnderecosDatabase getIntance(Context contexto){
        return Room.databaseBuilder(context, JogadoresDatabase.class, "Enderecos.db")
        .allowMainThreadQueries().build();
    }
        // Este método tem que ser refeito em toda classe que faz uso do database, o que esse método faz é receber essa missão;
        // Agora na classe basta setar o database com este método  
        // database = EnderecoDatabase.getInstance(this);
        // E esse método tambéms serve para criar o roomDao, com o seguinte seta:
        //  roomDatabase = EnderecoDatabase.getInstance(this).getRoomEnderecoDao();

}
