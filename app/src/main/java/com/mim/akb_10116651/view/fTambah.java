package com.mim.akb_10116651.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.mim.akb_10116651.R;
import com.mim.akb_10116651.RealmHelper;
import com.mim.akb_10116651.model.model_teman;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class fTambah extends Fragment implements View.OnClickListener {

    View view;
    Button btnSimpan, btnBatal;
    EditText nim, nama,kelas,email,noHp, instagram, whatsapp;
    ImageView foto;
    String sNama,sKelas,sEmail,sNHp, sInstagram, sWhatsapp, sNim;
    Integer sFoto;
    Realm realm;
    RealmHelper realmHelper;
    model_teman modelTeman;

    public fTambah() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.tambah, container, false);
        //Inisialisasi
        btnSimpan = view.findViewById(R.id.btn_simpan);
        btnBatal = view.findViewById(R.id.btn_batal);
        nim = view.findViewById(R.id.editTextNIM);
        nama = view.findViewById(R.id.editTextNama);
        kelas = view.findViewById(R.id.editTextKelas);
        email = view.findViewById(R.id.editTextEmail);
        noHp = view.findViewById(R.id.editTextTelpon);
        whatsapp = view.findViewById(R.id.editTextWa);
        instagram = view.findViewById(R.id.editTextIg);
        foto = view.findViewById(R.id.imageteman);

        //Set up Realm
        Realm.init(getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = nim.getText().toString().trim();
            sNama = nama.getText().toString().trim();
            sKelas = kelas.getText().toString().trim();
            sEmail = email.getText().toString().trim();
            sNHp    = noHp.getText().toString().trim();
            sFoto    = R.drawable.ic_people_black_24dp;
            sInstagram = instagram.getText().toString().trim();
            sWhatsapp = whatsapp.getText().toString().trim();
            if (!sNim.equals("") && !sNama.isEmpty()){
                modelTeman = new model_teman();
                modelTeman.setNim(sNim);
                modelTeman.setNama(sNama);
                modelTeman.setKelas(sKelas);
                modelTeman.setEmail(sEmail);
                modelTeman.setTelepon(sNHp);;
                modelTeman.setInstagram(sInstagram);
                modelTeman.setWhatsapp(sWhatsapp);
                modelTeman.setGbr(sFoto);
                realmHelper = new RealmHelper(realm);
                realmHelper.save(modelTeman);

                Toast.makeText(getActivity(), "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();
                nim.setText("");
                nama.setText("");
                kelas.setText("");
                email.setText("");
                noHp.setText("");
                instagram.setText("");
                whatsapp.setText("");

                fDaftarTeman listTemanFragment = new fDaftarTeman();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_container, listTemanFragment);
                fragmentTransaction.commit();

            }else {
                Toast.makeText(getActivity(), "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnBatal){
            fDaftarTeman listTemanFragment = new fDaftarTeman();
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_container, listTemanFragment);
            fragmentTransaction.commit();
        }
    }
}
