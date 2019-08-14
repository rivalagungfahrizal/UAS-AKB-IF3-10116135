package com.bnviewpager.kontak_teman;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bnviewpager.kontak_teman.Model.ModelApp;
import com.bnviewpager.kontak_teman.Presenter.Adapter;

import java.util.ArrayList;
import java.util.List;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

public class data_teman extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<ModelApp> modelApps;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_teman);



        modelApps = new ArrayList<>();
        modelApps.add(new ModelApp(R.drawable.ic_person_black_24dp, "10116135", "Made Daniswara Grimaldi","IF-3","08123464743","daniswara@gmail.com","xidanis"));
        modelApps.add(new ModelApp(R.drawable.ic_contacts_black_24dp, "10116135", "Rival Agung Fahrizal","IF-3","081211298979","rivalagungfahrizal@gmail.com","rivalaf"));
        modelApps.add(new ModelApp(R.drawable.ic_person_black_24dp, "10116102", "Mochamad Rizki Ramadhan","IF-3","08222004240","rizkirama46@gmail.com","rizki.gg"));


        Button tambah = (Button) findViewById(R.id.btn_tambah);
        Button delete = (Button) findViewById(R.id.btn_delete);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(data_teman.this, tambah_teman.class);
                modelApps.add(new ModelApp(R.drawable.ic_contacts_black_24dp, "10116135", "Rival Agung Fahrizal","IF-3","081211298979","rivalagungfahrizal@gmail.com","rivalaf"));
                adapter.notifyDataSetChanged();
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelApps.remove(viewPager.getCurrentItem());
                adapter.notifyDataSetChanged();
                viewPager = (ViewPager) findViewById(R.id.viewPager);
                viewPager.setAdapter(adapter);
            }
        });

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
//            Toast.makeText(this,extras.getString("key"),Toast.LENGTH_SHORT).show();
            String getNim = extras.getString("nimMasuk");
            String getNama = extras.getString("namaMasuk");
            String getKelas = extras.getString("kelasMasuk");
            String getTelepon = extras.getString("telephoneMasuk");
            String getEmail = extras.getString("emailMasuk");
            String getInstagram = extras.getString("instagramMasuk");
            modelApps.add(new ModelApp(R.drawable.ic_person_black_24dp, getNim,getNama,getKelas,
                    getTelepon,getEmail,getInstagram));

        }

        adapter = new Adapter(modelApps, this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.design_default_color_primary)
        };

        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
