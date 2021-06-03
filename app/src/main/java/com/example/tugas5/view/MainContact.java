package com.example.tugas5.view;

import android.view.View;

import com.example.tugas5.entity.AppDatabase;
import com.example.tugas5.entity.DataKlub;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataKlub> list);
        void editData(DataKlub item);
        void deleteData(DataKlub item);
    }

    interface presenter{
        void insertData(String nama, String alamat, int jumlah, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String alamat, int jumlah, int id, AppDatabase database);
        void deleteData(DataKlub dataKlub, AppDatabase database);
    }
}
