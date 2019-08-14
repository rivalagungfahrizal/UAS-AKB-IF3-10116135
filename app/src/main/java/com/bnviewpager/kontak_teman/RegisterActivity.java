package com.bnviewpager.kontak_teman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class RegisterActivity extends AppCompatActivity {
    Intent next_activity;
    public final static String Name = "NameKey";
    public final static String Password = "PassKey";
    public final static String Email = "EmailKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText reg_user = (EditText) findViewById(R.id.username_reg);
        final EditText reg_email= (EditText) findViewById(R.id.email_reg);
        final EditText reg_pass = (EditText) findViewById(R.id.password_reg);
        final EditText reg_conf_pass = (EditText) findViewById(R.id.conf_password_reg);
        Button daftar = (Button) findViewById(R.id.btn_daftar);
        Button back = (Button) findViewById(R.id.btn_kembali_reg);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUser = reg_user.getText().toString();
                String newPassword = reg_pass.getText().toString();
                String newConfPass = reg_conf_pass.getText().toString();
                String newEmail = reg_email.getText().toString();

                if(newPassword.equals(newConfPass))
                {
                    SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("NAME", newUser);
                    editor.putString("EMAIL", newEmail);
                    editor.putString("PASSWORD", newPassword);
                    editor.putBoolean("ISLOGGEDIN", true);
                    editor.commit();
                    Intent next_activity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(next_activity);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Password tidak sama", Toast.LENGTH_LONG).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(home);
            }
        });
    }
}
