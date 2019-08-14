package com.bnviewpager.kontak_teman.Presenter;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bnviewpager.kontak_teman.Model.ModelApp;
import com.bnviewpager.kontak_teman.R;
import com.bnviewpager.kontak_teman.detail_activity;

import java.util.List;

public class Adapter extends PagerAdapter {
    private List<ModelApp> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<ModelApp> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView;
        TextView nim,nama,kelas,telephone,email,instagram;
        imageView = (ImageView) view.findViewById(R.id.image);
        nim = (TextView) view.findViewById(R.id.nim);
        nama = (TextView) view.findViewById(R.id.nama);
        kelas = (TextView) view.findViewById(R.id.kelas);
        email = (TextView) view.findViewById(R.id.email);
        telephone = (TextView) view.findViewById(R.id.telephone);
        instagram = (TextView) view.findViewById(R.id.instagram);

        nim.setText(models.get(position).getNim());
        nama.setText(models.get(position).getNama());
        kelas.setText(models.get(position).getKelas());
        email.setText(models.get(position).getEmail());
        telephone.setText(models.get(position).getTelephone());
        instagram.setText(models.get(position).getInstagram());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle bundle = new Bundle();
                Intent intent = new Intent(context, detail_activity.class);
                Bundle extras = new Bundle();
                extras.putString("nim",models.get(position).getNim());
                extras.putString("nama",models.get(position).getNama());
                extras.putString("telephone",models.get(position).getTelephone());
                extras.putString("kelas",models.get(position).getKelas());
                extras.putString("email",models.get(position).getEmail());
                extras.putString("instagram",models.get(position).getInstagram());
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
