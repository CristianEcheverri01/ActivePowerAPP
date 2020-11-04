package com.example.activepower.adtadores;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activepower.R;
import com.example.activepower.entidades.Entrenador;

import java.util.ArrayList;

public class AdapterEntrenador extends RecyclerView.Adapter<AdapterEntrenador.ViewHolder> implements View.OnClickListener{

    ArrayList<Entrenador> model;
    LayoutInflater inflater;

    //listener
    private View.OnClickListener listener;

    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public AdapterEntrenador(Context context, ArrayList<Entrenador> model){
        this.inflater=LayoutInflater.from(context);
        this.model=model;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String nombre = model.get(position).getNombre();
    int img = model.get(position).getImagen();

    holder.text.setText(nombre);
    holder.img.setImageResource(img);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.itemListText);
            img = itemView.findViewById(R.id.itemListImagen);

        }
    }
}
