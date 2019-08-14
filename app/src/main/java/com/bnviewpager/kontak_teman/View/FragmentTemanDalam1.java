package com.bnviewpager.kontak_teman.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bnviewpager.kontak_teman.R;

import java.util.ArrayList;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTemanDalam1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTemanDalam1 extends Fragment {
    public static final String PAGE_TITLE = "Inner Tab1";
    TextView nim,nama,kelas,telepon,email;
    ImageButton sosmed;
    public FragmentTemanDalam1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment Fragment1.
     */
    public static FragmentTemanDalam1 newInstance() {
        FragmentTemanDalam1 fragment = new FragmentTemanDalam1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.inner_fragment_teman, container, false);
        ArrayList<String> teman = new ArrayList<>();
        teman.add("Nim:\n10116111");
        teman.add("Nama:\nAmmar Rifqul Abrar");
        teman.add("Kelas:\nIF-3");
        teman.add("Telepon:\n082123125811");
        teman.add("Email:\nammarrifqul@gmail.com");

        nim = (TextView)view.findViewById(R.id.nim);
        nama = (TextView)view.findViewById(R.id.nama);
        kelas = (TextView)view.findViewById(R.id.kelas);
        telepon = (TextView)view.findViewById(R.id.telepon);
        email = (TextView)view.findViewById(R.id.email);
        sosmed = (ImageButton)view.findViewById(R.id.sosmed);

        nim.setText(teman.get(0));
        nama.setText(teman.get(1));
        kelas.setText(teman.get(2));
        telepon.setText(teman.get(3));
        email.setText(teman.get(4));
        sosmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.facebook.com/ammarriefqul"));
                startActivity(intent);
            }
        });


        return view;
    }
}
