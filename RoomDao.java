package com.example.delivers.arquivosDAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.delivers.objetos.Endereco;

import java.util.List;

@Dao
public interface RoomDao {

    @Insert
    void salvaEndereco (Endereco endereco);

    @Delete
    void deleteEndereco (Endereco endereco);

    @Query("SELECT * FROM Endereco")
    List<Endereco> retorna();
}
