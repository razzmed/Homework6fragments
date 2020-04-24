package com.example.homework6fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {


    static final String RESULT_OK = "result";

    private static int CALCULATOR_FRAGMENT_CODE = 1;

    Adapter adapter;
    ArrayList<String> showHistory;
    RecyclerView recyclerView;

    public ITwoButtonsFrag iTwoButtonsFrag;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new Adapter();
        recyclerView = view.findViewById(R.id.vh_text_view);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == CALCULATOR_FRAGMENT_CODE && data != null) {
            showHistory.add(0, data.getStringExtra("result"));
            Log.e("ololo", "onActivityResult: " + data.getStringExtra("result"));
            adapter.upDate(showHistory);
            adapter.notifyDataSetChanged();
        }
        }
    }
