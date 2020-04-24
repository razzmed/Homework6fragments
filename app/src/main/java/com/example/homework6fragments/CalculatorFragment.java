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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    public ITwoButtonsFrag iTwoButtonsFrag;

    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;
    Double num1;
    Double num2;
    String oper;

    Button clear;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonZero;
    Button buttonPlus;

    Button buttonMinus;
    Button buttonMultiplication;
    Button buttonDivision;
    Button buttonDot;
    Button buttonEqually;
    Button buttonSave;


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        result = view.findViewById(R.id.result_field);
        clear = view.findViewById(R.id.clear);

        button1 = view.findViewById(R.id.one);
        button2 = view.findViewById(R.id.two);
        button3 = view.findViewById(R.id.three);
        button4 = view.findViewById(R.id.four);
        button5 = view.findViewById(R.id.five);
        button6 = view.findViewById(R.id.six);
        button7 = view.findViewById(R.id.seven);
        button8 = view.findViewById(R.id.eight);
        button9 = view.findViewById(R.id.nine);
        buttonZero = view.findViewById(R.id.zero);
        buttonPlus = view.findViewById(R.id.plus);
        buttonMinus = view.findViewById(R.id.minus);
        buttonDivision = view.findViewById(R.id.division);
        buttonMultiplication = view.findViewById(R.id.multiplication);
        buttonDot = view.findViewById(R.id.dot);
        buttonEqually = view.findViewById(R.id.equally);
//        buttonSave = view.findViewById(R.id.save);


        if (savedInstanceState != null) {
            num1 = savedInstanceState.getDouble("num1");
            num2 = savedInstanceState.getDouble("num2");
            oper = savedInstanceState.getString("oper");
            firstValues = num1;
            secondValues = num2;
            operation = oper;
        }
        Log.d("scalc", "onCreate");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("9");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("0");
            }
        });

//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra(HistoryFragment.GET_TEXT_KEY, result.getText().toString());
//            }
//        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    result.append(".");
                } catch (NumberFormatException NFE) {
                }
            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                operation = "+";
            }
        });


        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
            }
        });


        buttonEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation, "");
                    secondValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plusOperation();
                            break;
                        case "-":
                            minusOperation();
                            break;
                        case "*":
                            multiplicationOperation();
                            break;
                        case "/":
                            divisionOperation();
                            if (firstValues > 0) {
                                try {
                                    divisionOperation();
                                } catch (ArithmeticException AE) {
                                    result.setText("");
                                }
                            }
                            break;
                    }
                }
            }
        });
    }


    public void plusOperation() {
        result_op = firstValues + secondValues;
        result.setText(result_op.toString());
    }

    public void divisionOperation() {
        result_op = firstValues / secondValues;
        result.setText(result_op.toString());

    }

    public void minusOperation() {
        result_op = firstValues - secondValues;
        result.setText(result_op.toString());
    }

    public void multiplicationOperation() {
        result_op = firstValues * secondValues;
        result.setText(result_op.toString());
    }

    public void Save(View view) {

        Intent intent = new Intent();
        intent.putExtra("result", result.getText().toString());

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (firstValues != null) {
            outState.putDouble("num1", firstValues);
        }
        if (secondValues != null) {
            outState.putDouble("num2", secondValues);
        }
        if (operation != null) {
            outState.putString("oper", operation);
        }
    }
}

