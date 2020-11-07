package com.example.delivers.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.delivers.arquivosDAO.RoomDao;
import com.example.delivers.objetos.Endereco;

@Database(entities = {Endereco.class}, version = 1, exportSchema = false)
public abstract class EnderecosDatabase extends RoomDatabase {

    public abstract RoomDao getRoomEnderecoDao();

}
