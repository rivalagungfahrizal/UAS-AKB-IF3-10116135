package com.bnviewpager.kontak_teman.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bnviewpager.kontak_teman.R;

/*Tanggal Pengerjaan : 14/8/2019
  Nim                : 10116135
  Nama               : Rival Agung Fahrizal
  Kelas              : IF-3
* */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentKontak#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentKontak extends Fragment {

    ImageButton btn;
    public FragmentKontak() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment FragmentProfil.
     */
    public static FragmentKontak newInstance() {
        FragmentKontak fragment = new FragmentKontak();
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
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);
        btn = (ImageButton) view.findViewById(R.id.buttonfb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://www.facebook.com/rival.fafurizaru"));
                startActivity(intent);
            }
        });
        return view;
    }
}
