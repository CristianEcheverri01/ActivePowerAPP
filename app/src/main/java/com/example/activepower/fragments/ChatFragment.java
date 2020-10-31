package com.example.activepower.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.activepower.R;
import com.example.activepower.fragments.recycler.AdapterDatos;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    ArrayList<String> listDatos;
    RecyclerView recyclerView;
    View view;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ChatFragment() {

    }

    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = view.findViewById(R.id.itemListText);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        listDatos = new ArrayList<String>();

        for(int i=0;i<=50;i++){
            listDatos.add("Dato #"+i+" ");
        }

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recyclerView.setAdapter(adapter);
        return view;
    }
}