package com.example.tugas5.view;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tugas5.entity.AppDatabase;
import com.example.tugas5.entity.DataKlub;

import java.util.List;

public class MainPresenter implements  MainContact.presenter {
    private MainContact.view view;

    public MainPresenter(MainContact.view view) {
        this.view = view;
    }

    class InsertData extends AsyncTask<Void,Void,Long>{
        private AppDatabase appDatabase;
        private DataKlub dataKlub;

        public InsertData(AppDatabase appDatabase,DataKlub dataKlub){
            this.appDatabase = appDatabase;
            this.dataKlub =  dataKlub;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.dao().insertData(dataKlub);
        }

        protected void onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String nama, String alamat, int jumlah, AppDatabase database) {
        final DataKlub dataKlub = new DataKlub();
        dataKlub.setName(nama);
        dataKlub.setAddress(alamat);
        dataKlub.setPemain(jumlah);
        new InsertData(database,dataKlub).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataKlub>list;
        list = database.dao().getData();
        view.getData(list);
    }


    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase appDatabase;
        private DataKlub dataKlub;

        public EditData(AppDatabase appDatabase, DataKlub dataKlub) {
            this.appDatabase = appDatabase;
            this.dataKlub = dataKlub;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return appDatabase.dao().updateData(dataKlub);
        }

        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db","onPostExecute :"+integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String nama, String alamat, int jumlah, int id, AppDatabase database) {
        final DataKlub dataKlub = new DataKlub();
        dataKlub.setName(nama);
        dataKlub.setAddress(alamat);
        dataKlub.setPemain(jumlah);
        dataKlub.setId(id);
        new EditData(database,dataKlub).execute();
    }

    class DeleteData extends AsyncTask<Void,Void,Long>{
        private AppDatabase appDatabase;
        private DataKlub dataKlub;

        public DeleteData(AppDatabase appDatabase, DataKlub dataKlub) {
            this.appDatabase = appDatabase;
            this.dataKlub = dataKlub;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            appDatabase.dao().deleteData(dataKlub);
            return null;
        }

        protected void onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(DataKlub dataKlub, AppDatabase database) {
        new DeleteData(database, dataKlub).execute();
    }
}
