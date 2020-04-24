package com.example.homework6fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoButtonsFragment extends Fragment {

    Button calc;
    Button history;

    ITwoButtonsFrag iTwoButtonsFrag;

    public TwoButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two_buttons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calc = view.findViewById(R.id.fragment_calc);
        history = view.findViewById(R.id.fragment_history);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("frag", "Button calc clicked");
                iTwoButtonsFrag.onCalcButton();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("frag", "Button history clicked");
                iTwoButtonsFrag.onHistoryButton();
            }
        });
    }

}
