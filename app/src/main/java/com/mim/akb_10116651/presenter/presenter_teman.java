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

//        realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        realm.deleteAll();
//        mt = realm.createObject(model_teman.class,"10112451");
//        mt.setNama("Dicoba");
//        mt.setKelas("IF13");
//        mt.setTelepon("01234536");
//        mt.setEmail("iyad@gmail.com");
//        mt.setInstagram("al_muayyad26");
//        mt.setWhatsapp("01234536");
//        mt.setGbr(R.drawable.iyad);
//        realm.commitTransaction();


        model_teman teman = new model_teman();
        teman.setGbr(R.drawable.almuayyad);
        teman.setNim("10116589");
        teman.setNama("Yusup Maulana");
        teman.setKelas("IF-13");
        teman.setTelepon("085351541901");
        teman.setEmail("yusupmaulanaibrohim@gmail.com");
        teman.setInstagram("@ibrohima05");
        teman.setWhatsapp("085123123431");
        listTeman.add(teman);
        model_teman teman2 = new model_teman();
        teman2.setGbr(R.drawable.iyad);
        teman2.setNim("10116631");
        teman2.setNama("Muhamad Iyad Muayyad");
        teman2.setKelas("IF-13");
        teman2.setTelepon("082216225327");
        teman2.setEmail("muhamadiyadm@gmail.com");
        teman2.setInstagram("@al_muayyad26");
        teman2.setWhatsapp("089663591954");
        listTeman.add(teman2);
//        model_teman teman3 = new model_teman();
//        teman3.setGbr(R.drawable.iyad);
//        teman3.setNim("10116651");
//        teman3.setNama("Muhamad Iyad Muayyad");
//        teman3.setKelas("IF-13");
//        teman3.setTelepon("082216225327");
//        teman3.setEmail("muhamadiyadm@gmail.com");
//        teman3.setInstagram("@al_muayyad26");
//        teman3.setWhatsapp("089663591954");
//        listTeman.add(teman3);
//        model_teman teman4 = new model_teman();
//        teman4.setGbr(R.drawable.iyad);
//        teman4.setNim("10116651");
//        teman4.setNama("Muhamad Iyad Muayyad");
//        teman4.setKelas("IF-13");
//        teman4.setTelepon("082216225327");
//        teman4.setEmail("muhamadiyadm@gmail.com");
//        teman4.setInstagram("@al_muayyad26");
//        teman4.setWhatsapp("089663591954");
//        listTeman.add(teman4);
//        model_teman teman5 = new model_teman();
//        teman5.setGbr(R.drawable.iyad);
//        teman5.setNim("10116651");
//        teman5.setNama("Muhamad Iyad Muayyad");
//        teman5.setKelas("IF-13");
//        teman5.setTelepon("082216225327");
//        teman5.setEmail("muhamadiyadm@gmail.com");
//        teman5.setInstagram("@al_muayyad26");
//        teman5.setWhatsapp("089663591954");
//        listTeman.add(teman5);
        return listTeman;
    }
}
