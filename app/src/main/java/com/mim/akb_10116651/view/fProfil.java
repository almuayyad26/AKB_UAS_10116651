package com.mim.akb_10116651.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mim.akb_10116651.R;

import io.realm.Realm;

public class fProfil extends Fragment {
//    08/08/2019
//    NIM:10116651
//    Nama:Muhamad Iyad Muayyad
//    Kelas:IF-13
    Realm realm;
    public TextView nama, kelas, nim, teman, deskripsi;
    MainView mainView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profil, container, false);
        nama = (TextView)view.findViewById(R.id.txt_nama);
        kelas = (TextView)view.findViewById(R.id.txt_kelas);
        nim = (TextView)view.findViewById(R.id.txt_nim);
        teman = (TextView)view.findViewById(R.id.txt_teman);
        deskripsi = (TextView)view.findViewById(R.id.txt_deskripsi);
        nama.setText("Muhamad Iyad Muayyad");
        kelas.setText("IF13");
        nim.setText("10116651");
        teman.setText("90");
        deskripsi.setText("Halo... Perkenalkan nama saya Muhamad Iyad Muayyad, saya berasal dari Kuningan, Jawa Barat. Saya terlahir sebagai anak ketiga dari tiga bersaudara, tepatnya pada tanggal 26 Februari 1998. Sekarang saya sedang menempuh pendidikan di Universitas Komputer Indonesia sejak tahun 2016 dengan mengambil program studi Teknik Informatika");
        return view;
    }
}
