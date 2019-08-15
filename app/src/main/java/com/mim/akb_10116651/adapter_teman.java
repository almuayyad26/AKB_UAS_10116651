package com.mim.akb_10116651;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mim.akb_10116651.model.model_teman;
import com.mim.akb_10116651.view.fDaftarTeman;

import java.util.List;

public class adapter_teman extends RecyclerView.Adapter<adapter_teman.MyViewHolder> {
//    13/08/2019
//    NIM:10116651
//    Nama:Muhamad Iyad Muayyad
//    Kelas:IF-13
    private List<model_teman> model_tem;
    Context context;
    fDaftarTeman LTTeman;

    public adapter_teman(fDaftarTeman v, Context context, List<model_teman> model_Teman) {
        this.LTTeman = v;
        this.context = context;
        this.model_tem = model_Teman;
    }

    public adapter_teman(Context context, List<model_teman> model_temen) {
        this.context = context;
        this.model_tem = model_temen;
    }

    @Override
    public adapter_teman.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final model_teman model = model_tem.get(position);
        holder.nim.setText(model.getNim().toString());
        holder.nama.setText(model.getNama());
        holder.kelas.setText(model.getKelas());
        holder.email.setText(model.getEmail());
        holder.noHp.setText(model.getTelepon());
        holder.instagram.setText(model.getInstagram());
        holder.whatsapp.setText(model.getWhatsapp());
        holder.foto.setImageResource(R.drawable.ic_people_black_24dp);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LTTeman.update(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model_tem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nim, nama, kelas, email, noHp, instagram, whatsapp;
        ImageView foto;

        public MyViewHolder(View itemView) {
            super(itemView);
            nim = itemView.findViewById(R.id.nim);
            nama = itemView.findViewById(R.id.nama);
            kelas = itemView.findViewById(R.id.kelas);
            email = itemView.findViewById(R.id.email);
            noHp = itemView.findViewById(R.id.telepon);
            instagram = itemView.findViewById(R.id.ig);
            foto = itemView.findViewById(R.id.imageteman);
            whatsapp = itemView.findViewById(R.id.wa);
        }
    }
}
