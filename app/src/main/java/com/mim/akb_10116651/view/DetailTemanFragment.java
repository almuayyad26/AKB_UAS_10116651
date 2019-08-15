package com.mim.akb_10116651.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mim.akb_10116651.R;
import com.mim.akb_10116651.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import com.mim.akb_10116651.model.model_teman;

/**
 * A simple {@link androidx.fragment.app.Fragment} subclass.
 */
//    NIM:10116574
//    Nama:Ira Yuti
//    Kelas:If-13
//    Tanggal Pengerjaan:14/08/2019
public class DetailTemanFragment extends Fragment implements  View.OnClickListener {
 View view;
    Button btnUbah, btnHapus,btnKembali;
    EditText nim, nama,kelas,email,noHp, instagram, whatsapp;
    String sNama,sKelas,sEmail,sNHp, sInstagram, sWhatsapp, sNim;
    Integer sId;
    Realm realm;
    RealmHelper realmHelper;
    model_teman modelTeman;
    public DetailTemanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.tambah, container, false);
        // Set up
        Realm.init(getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
     realmHelper = new RealmHelper(realm);
//
        btnUbah = view.findViewById(R.id.btn_simpan);
        btnHapus = view.findViewById(R.id.btn_hapus);
        btnKembali = view.findViewById(R.id.btn_batal);
        nim = view.findViewById(R.id.editTextNIM);
        nama = view.findViewById(R.id.editTextNama);
        kelas = view.findViewById(R.id.editTextKelas);
        email = view.findViewById(R.id.editTextEmail);
        noHp = view.findViewById(R.id.editTextTelpon);
        instagram = view.findViewById(R.id.editTextIg);
        whatsapp = view.findViewById(R.id.editTextWa);
//
        sId = Integer.parseInt(getArguments().getString("id"));
        sNim = getArguments().getString("nim");
        sNama = getArguments().getString("nama");
        sKelas = getArguments().getString("kelas");
        sEmail = getArguments().getString("email");
        sNHp = getArguments().getString("nohp");
        sInstagram = getArguments().getString("ig");
        sWhatsapp = getArguments().getString("wa");

        nim.setText(String.valueOf(sNim));
        nama.setText(sNama);
        kelas.setText(sKelas);
        email.setText(sEmail);
        noHp.setText(sNHp);
        instagram.setText(sInstagram);
        btnKembali.setOnClickListener(this);
        btnHapus.setOnClickListener(this);
        btnUbah.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_simpan:
                sNim = nim.getText().toString().trim();
                sNama = nama.getText().toString().trim();
                sKelas = kelas.getText().toString().trim();
                sEmail = email.getText().toString().trim();
                sNHp    = noHp.getText().toString().trim();
                sWhatsapp    = whatsapp.getText().toString().trim();
                sInstagram = instagram.getText().toString().trim();
                if (!sNim.equals("") && !sNama.isEmpty()) {
                    modelTeman = new model_teman();
                    modelTeman.setNim(sNim);
                    modelTeman.setNama(sNama);
                    modelTeman.setKelas(sKelas);
                    modelTeman.setEmail(sEmail);
                    modelTeman.setTelepon(sNHp);
                    modelTeman.setInstagram(sInstagram);
                    modelTeman.setWhatsapp(sWhatsapp);
                    realmHelper.update(sId, modelTeman);

                    Toast.makeText(getActivity(), "Berhasil Diubah!", Toast.LENGTH_SHORT).show();
                } else {
            Toast.makeText(getActivity(), "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
        }
                break;
            case R.id.btn_hapus:
                realmHelper.delete(sId);
              Toast.makeText(getActivity(), "Delete Success"+ String.valueOf(sId), Toast.LENGTH_SHORT).show();
                fDaftarTeman listTemanFragment = new fDaftarTeman();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_container, listTemanFragment);
                fragmentTransaction.commit();
                break;
            case R.id.btn_batal:
                fDaftarTeman listTemanFragment1 = new fDaftarTeman();
                FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fl_container, listTemanFragment1);
                fragmentTransaction1.commit();
                break;
        }
    }
}
