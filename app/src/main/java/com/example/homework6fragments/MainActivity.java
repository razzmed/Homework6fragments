package com.example.homework6fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ITwoButtonsFrag{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTwoButtonsFragment();
        setupHistoryFragment();

    }

    private void setupTwoButtonsFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TwoButtonsFragment twoButtonsFragment = (TwoButtonsFragment) fragmentManager.findFragmentById(R.id.main_fragment_two_btn);
        twoButtonsFragment.iTwoButtonsFrag = this;
    }

    private void setupHistoryFragment() {
        HistoryFragment historyFragment = new HistoryFragment();
        showFragment(historyFragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onCalcButton() {
        CalculatorFragment calculatorFragment = new CalculatorFragment();
        calculatorFragment.iTwoButtonsFrag = this;
        showFragment(calculatorFragment);

    }

    @Override
    public void onHistoryButton() {
        HistoryFragment historyFragment = new HistoryFragment();
        historyFragment.iTwoButtonsFrag = this;
        showFragment(historyFragment);

    }


}
