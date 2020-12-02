package com.studio.parseviewpaises;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdpterListaPaises extends RecyclerView.Adapter<AdpterListaPaises.ViewHolder>{
    private List<Paises> list;
    private LayoutInflater layoutInflater;
    private static RecyclerViewOnClickListener recyclerViewOnClickListener;



    public void setRecyclerOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.listpaises,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView bandeira;
        public TextView nome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bandeira = (ImageView) itemView.findViewById(R.id.imgBandeira);
            nome = (TextView) itemView.findViewById(R.id.txtNome);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(recyclerViewOnClickListener != null){
                recyclerViewOnClickListener.onClickListener(v,getLayoutPosition());
            }
        }
    }
}
