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
 * Use the {@link FragmentTemanDalam2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTemanDalam2 extends Fragment {
    public static final String PAGE_TITLE = "Inner Tab1";
    TextView nim2,nama2,kelas2,telepon2,email2;
    ImageButton sosmed2;



    public FragmentTemanDalam2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment Fragment1.
     */
    public static FragmentTemanDalam2 newInstance() {
        FragmentTemanDalam2 fragment = new FragmentTemanDalam2();
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
        View view = inflater.inflate(R.layout.inner_fragment_teman2, container, false);
        ArrayList<String> teman2 = new ArrayList<>();

        teman2.add("Nim:\n10116095");
        teman2.add("Nama:\nMade Daniswara Grimaldi");
        teman2.add("Kelas:\nIF-3");
        teman2.add("Telepon:\n085721356367");
        teman2.add("Email:\nmadedaniswara@gmail.com");
        teman2.add("facebook.com/madedaniswaragrimaldi");

        nim2 = (TextView)view.findViewById(R.id.nim2);
        nama2 = (TextView)view.findViewById(R.id.nama2);
        kelas2 = (TextView)view.findViewById(R.id.kelas2);
        telepon2 = (TextView)view.findViewById(R.id.telepon2);
        email2 = (TextView)view.findViewById(R.id.email2);
        sosmed2 = (ImageButton)view.findViewById(R.id.sosmed2);

        nim2.setText(teman2.get(0));
        nama2.setText(teman2.get(1));
        kelas2.setText(teman2.get(2));
        telepon2.setText(teman2.get(3));
        email2.setText(teman2.get(4));
        sosmed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.facebook.com/daniswara.grimaldi.5?ref=br_rs"));
                startActivity(intent);
            }
        });


        return view;
    }
}
