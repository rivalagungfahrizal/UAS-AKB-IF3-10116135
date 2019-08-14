package com.bnviewpager.kontak_teman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
        final Boolean isloggedin = sharedPreferences.getBoolean("ISLOGGEDIN", false);

        /*if(isloggedin)
        {
            Intent main = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(main);
        }*/

        final String required_email = sharedPreferences.getString("EMAIL", "DEFAULT_EMAIL");
        final String required_password = sharedPreferences.getString("PASSWORD", "DEFAULT_PASSWORD");
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.btn_login);
        Button register = (Button) findViewById(R.id.btn_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();
                String pass = password.getText().toString();
                if(user.equals(required_email) && pass.equals(required_password))
                {
                    sharedPreferences.edit().putBoolean("ISLOGGEDIN", false).apply();
                    Intent main = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,
                            "Email atau Password salah", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
