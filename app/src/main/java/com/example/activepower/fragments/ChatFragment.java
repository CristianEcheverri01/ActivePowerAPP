package com.example.activepower.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.activepower.R;
import com.example.activepower.adtadores.AdapterEntrenador;
import com.example.activepower.entidades.Entrenador;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    AdapterEntrenador adapterEntrenador;
    ArrayList<Entrenador> listaEntrenadores;
    RecyclerView recyclerViewEntrenador;
    View view;

    public ChatFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerViewEntrenador = view.findViewById(R.id.recyclerChat);
        listaEntrenadores = new ArrayList<>();
        //cargar la lista
        cargarLista();
        //mostrar datos
        mostrarDatos();

        return view;
    }

    public void cargarLista(){
        listaEntrenadores.add(new Entrenador("Cristian",R.drawable.persona1));
        listaEntrenadores.add(new Entrenador("Ceballos",R.drawable.persona2));
        listaEntrenadores.add(new Entrenador("Laura",R.drawable.persona3));
        listaEntrenadores.add(new Entrenador("Eve",R.drawable.persona4));
        listaEntrenadores.add(new Entrenador("Bladimir",R.drawable.persona5));
    }

    public void mostrarDatos(){
        recyclerViewEntrenador.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        adapterEntrenador = new AdapterEntrenador(getContext(),listaEntrenadores);
        recyclerViewEntrenador.setAdapter(adapterEntrenador);
    }
}