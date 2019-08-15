package com.mim.akb_10116651;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mim.akb_10116651.view.fDaftarTeman;
import com.mim.akb_10116651.view.fKontak;
import com.mim.akb_10116651.view.fProfil;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//    08/08/2019
//    NIM:10116651
//    Nama:Muhamad Iyad Muayyad
//    Kelas:IF-13
    private TextView myTextView;
    Realm realm;
    private String username;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        Intent login= new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(login);
        Realm.init(this);
        loadFragment(new fProfil());
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.navigation_profil:
                fragment = new fProfil();
                break;
            case R.id.navigation_kontak:
                fragment = new fKontak();
                break;
            case R.id.navigation_daftarteman:
                fragment = new fDaftarTeman();
                break;
            case R.id.navigation_signout:
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Keluar")
                .setMessage("Keluar dari Aplikasi?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        finish();
                        moveTaskToBack(true);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
