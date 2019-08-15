package com.mim.akb_10116651.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mim.akb_10116651.R;
import com.mim.akb_10116651.RealmHelper;
import com.mim.akb_10116651.adapter_teman;
import com.mim.akb_10116651.model.model_teman;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class fDaftarTeman extends Fragment implements daftartemanView {
//    14/08/2019
//    NIM:10116651
//    Nama:Muhamad Iyad Muayyad
//    Kelas:IF-13
    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    adapter_teman adapterTeman;
    List<model_teman> modeltemen;
    View view;

    public fDaftarTeman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.daftarteman, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        modeltemen = new ArrayList<>();

        modeltemen = realmHelper.getAllTeman();
        show();
        FloatingActionButton fab = view.findViewById(R.id.btnTambahTeman);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fTambah tambahTemanFragment = new fTambah();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_container, tambahTemanFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
    public void show(){
        adapterTeman = new adapter_teman(this,getActivity(), modeltemen);
        recyclerView.setAdapter(adapterTeman);
    }

    public void  update(model_teman model_teman){
        Bundle bundle = new Bundle();
        bundle.putString("id",String.valueOf(model_teman.getId()));
        bundle.putString("nim",String.valueOf(model_teman.getNim()));
        bundle.putString("nama",String.valueOf(model_teman.getNama()));
        bundle.putString("kelas",String.valueOf(model_teman.getKelas()));
        bundle.putString("email",String.valueOf(model_teman.getEmail()));
        bundle.putString("nohp",String.valueOf(model_teman.getTelepon()));
        bundle.putString("ig",String.valueOf(model_teman.getInstagram()));
        bundle.putString("wa",String.valueOf(model_teman.getInstagram()));
        DetailTemanFragment detailTemanFragment = new DetailTemanFragment();
        detailTemanFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, detailTemanFragment);
        fragmentTransaction.commit();
    }}
