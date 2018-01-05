package com.pethos.pethosdev;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{

    ArrayList<KategoriClass> kategoriList;


    RvAdapter(ArrayList<KategoriClass> kategoriList){
        this.kategoriList = kategoriList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaKategori;
        ImageView icon;
        CardView cv;
        Context context;


        public ViewHolder(View v) {
            super(v);
            namaKategori = (TextView) itemView.findViewById(R.id.nama_kategori);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
    }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_kategori, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;

        }

        public void onBindViewHolder(ViewHolder holder, final int i){
            holder.icon.setImageResource(kategoriList.get(i).icon);
            holder.namaKategori.setText(kategoriList.get(i).nama);

            //final int id_klik = kategoriList.get(i).idKategori;

           /** holder.cv.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v){

                    int inew = getIndex(id_klik);
                    //Snackbar.make(v, "Click " + id_klik, Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), blabla.class);
                    String iString = String.valueOf(inew);
                    intent.putExtra("dataKategori", iString);
                    v.getContext().startActivity(intent);
                }
            }); **/
        }

        public int getItemCount()
        {
            return kategoriList.size();
        }

    /**public int getIndex(int itemName)
    {
        for (int i = 0; i < kategoriList.size(); i++)
        {
            KategoriClass id = kategoriList.get(i);
            if (itemName==id.getIdKategori())
            {
                return i;
            }
        }

        return -1;
    }
     **/
    }
