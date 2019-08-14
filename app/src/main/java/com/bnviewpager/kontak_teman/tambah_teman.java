package com.bnviewpager.kontak_teman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class tambah_teman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);
    }

    public void sendData(View view) {
        EditText nim = findViewById(R.id.nim);
        EditText nama = findViewById(R.id.nama);
        EditText kelas = findViewById(R.id.kelas);
        EditText telephone = findViewById(R.id.telephone);
        EditText email = findViewById(R.id.email);
        EditText instagram = findViewById(R.id.instagram);

        Intent intent = new Intent(tambah_teman.this, data_teman.class);
        Bundle bundle = new Bundle();

        bundle.putString("nimMasuk",nim.getText().toString());
        bundle.putString("namaMasuk",nama.getText().toString());
        bundle.putString("telephoneMasuk",telephone.getText().toString());
        bundle.putString("kelasMasuk",kelas.getText().toString());
        bundle.putString("emailMasuk",email.getText().toString());
        bundle.putString("instagramMasuk",instagram.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
