package com.mim.akb_10116651;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import com.mim.akb_10116651.model.model_teman;
import io.realm.RealmResults;
public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final model_teman mod_t){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(model_teman.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    mod_t.setId(nextId);
                    model_teman model = realm.copyToRealm(mod_t);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<model_teman> getAllTeman(){
        RealmResults<model_teman> results = realm.where(model_teman.class).findAll();
        return results;
    }

    // untuk meng-update data
    public void update(final Integer id, final model_teman friendsterModel){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model_teman model = realm.where(model_teman.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(friendsterModel.getNim());
                model.setNama(friendsterModel.getNama());
                model.setKelas(friendsterModel.getKelas());
                model.setEmail(friendsterModel.getEmail());
                model.setTelepon(friendsterModel.getTelepon());
                model.setWhatsapp(friendsterModel.getWhatsapp());
                model.setInstagram(friendsterModel.getInstagram());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    // untuk menghapus data
    public void delete(Integer id){
        final RealmResults<model_teman> model = realm.where(model_teman.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}
