package com.example.tugas5.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataKlubDAO {
    @Insert
    Long insertData(DataKlub dataKlub);

    @Query("Select * from klub_db")
    List<DataKlub> getData();

    @Update
    int updateData(DataKlub item);

    @Delete
    void deleteData(DataKlub item);

}
