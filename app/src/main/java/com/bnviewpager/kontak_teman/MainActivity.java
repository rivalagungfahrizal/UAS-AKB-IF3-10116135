package com.bnviewpager.kontak_teman;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.bnviewpager.kontak_teman.View.FragmentDalam1;
import com.bnviewpager.kontak_teman.View.FragmentKontak;
import com.bnviewpager.kontak_teman.View.FragmentProfil;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class MainActivity extends AppCompatActivity {
    public static final String FRAGMENT_VIEWPAGER = "FRAGMENT_VIEWPAGER";
    public static final String FRAGMENT_FIRST = "FRAGMENT_FIRST";
    public static final String FRAGMENT_SECOND = "FRAGMENT_SECOND";
    public static final String FRAGMENT_THIRD = "FRAGMENT_THIRD";



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            /*switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(FragmentDalam1.newInstance(),FRAGMENT_FIRST);
                    return true;
                case R.id.navigation_profile:
                    replaceFragment(FragmentProfil.newInstance(),FRAGMENT_SECOND);
                    return true;
                case R.id.navigation_contact:
                    replaceFragment(FragmentKontak.newInstance(),FRAGMENT_THIRD);
                    return true;
                case R.id.navigation_friend_list:
                    Intent intent = new Intent(MainActivity.this, data_teman.class);
                    startActivity(intent);



            }*/

            int id = item.getItemId();
            Fragment fragment = null;
            if (id == R.id.navigation_home) {
                fragment = new FragmentDalam1();

            } else if (id == R.id.navigation_profile) {
                fragment= new FragmentProfil();

            } else if (id == R.id.navigation_contact) {
                fragment= new FragmentKontak();
            } else if (id == R.id.navigation_friend_list) {
                Intent intent = new Intent(MainActivity.this, data_teman.class);
                startActivity(intent);
            }
            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button logout = (Button) findViewById(R.id.btn_logout);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, FragmentDalam1.newInstance(), FRAGMENT_VIEWPAGER)
                .commit();
    }









}
