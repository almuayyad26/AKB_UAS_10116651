package com.mim.akb_10116651.presenter;

import android.graphics.drawable.Drawable;

import com.mim.akb_10116651.R;
import com.mim.akb_10116651.model.model_teman;
import com.mim.akb_10116651.view.MainTeman;
import com.mim.akb_10116651.view.daftartemanView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class presenter_teman implements MainTeman {
//    11/08/2019
//    NIM:10116651
//    Nama:Muhamad Iyad Muayyad
//    Kelas:IF-13
    Realm realm;
    model_teman mt;
    private daftartemanView DaftarTemanView;
    // private Teman teman = new Teman();
    private List<model_teman> listTeman;

    public presenter_teman(daftartemanView DaftarTemanView) {
        this.DaftarTemanView = DaftarTemanView;
    }

    public presenter_teman() {
    }

    @Override
    public List<model_teman> dataDummy() {
        this.listTeman=new ArrayList<model_teman>();
        return listTeman;
    }
}
