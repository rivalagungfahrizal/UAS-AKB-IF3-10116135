package com.bnviewpager.kontak_teman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.bnviewpager.kontak_teman.Model.ModelApp;

import java.util.List;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class detail_activity extends AppCompatActivity {
    List<ModelApp> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        EditText nim = (EditText) findViewById(R.id.nim);
        EditText nama = (EditText) findViewById(R.id.nama);
        EditText kelas = (EditText) findViewById(R.id.kelas);
        EditText telephone = (EditText) findViewById(R.id.telephone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText instagram = (EditText) findViewById(R.id.instagram);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        nim.setText(extras.getString("nim"));
        nama.setText(extras.getString("nama"));
        kelas.setText(extras.getString("kelas"));
        telephone.setText(extras.getString("telephone"));
        email.setText(extras.getString("email"));
        instagram.setText(extras.getString("instagram"));
    }

    public void sendMessage(View view) {
        EditText nim = (EditText) findViewById(R.id.nim);
        EditText nama = (EditText) findViewById(R.id.nama);
        EditText kelas = (EditText) findViewById(R.id.kelas);
        EditText telephone = (EditText) findViewById(R.id.telephone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText instagram = (EditText) findViewById(R.id.instagram);

        Intent intent = new Intent(detail_activity.this, data_teman.class);
        Bundle bundle = new Bundle();

        bundle.putString("nimEdit",nim.getText().toString());
        bundle.putString("namaEdit",nama.getText().toString());
        bundle.putString("telephoneEdit",telephone.getText().toString());
        bundle.putString("kelasEdit",kelas.getText().toString());
        bundle.putString("emailEdit",email.getText().toString());
        bundle.putString("instagramEdit",instagram.getText().toString());
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
