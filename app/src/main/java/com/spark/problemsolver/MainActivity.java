package com.spark.problemsolver;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_start_calc)
    Button btnStartCalculate;

    @BindView(R.id.et_input_addition)
    EditText etInputAddition;

    @BindView(R.id.et_input_numbers)
    EditText etInputNumbers;

    @BindView(R.id.tv_first_no)
    TextView tvFirstNo;

    @BindView(R.id.tv_second_no)
    TextView tvSecondNo;

    @BindView(R.id.tv_third_no)
    TextView tvThirdNo;

    @BindView(R.id.tv_output)
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start_calc)
    public void onClickStart() {
        String[] strInputArray = etInputNumbers.getText().toString().split(" ");
        final int[] inputArray = new int[strInputArray.length];
        final String strInputAddition = etInputAddition.getText().toString();

        int i = 0;
        for (String s : strInputArray) {
            try {
                inputArray[i] = Integer.parseInt(s);
                i++;
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Please Enter Valid Inputs", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if (inputArray.length == strInputArray.length) {

            Thread handler = new Thread() {
                @Override
                public void run() {
                    try {
                        boolean flag = true;
                        for (int j = 0; j < inputArray.length && flag; j++) {
                            for (int k = 0; k < inputArray.length && flag; k++) {
                                for (int l = 0; l < inputArray.length; l++) {
                                    Thread.sleep(100);
                                    changeText(j, k, l, inputArray);
                                    try {
                                        if ((inputArray[j] + inputArray[k] + inputArray[l])
                                                == Integer.parseInt(strInputAddition)) {
                                            changeText(j, k, l, inputArray);
                                            flag = false;
                                            break;
                                        }
                                    } catch (NumberFormatException e) {
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                        }
                    } catch (InterruptedException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            handler.start();
        }
    }

    private void changeText(final int j, final int k, final int l, final int[] inputArray) {
        Thread t = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvFirstNo.setText(String.valueOf(inputArray[j]));
                        tvSecondNo.setText(String.valueOf(inputArray[k]));
                        tvThirdNo.setText(String.valueOf(inputArray[l]));
                        tvOutput.setText(String.valueOf(inputArray[j] + inputArray[k] + inputArray[l]));
                        Log.d("TEST", inputArray[j] + " + " + inputArray[k]
                                + " + " + inputArray[l] + " = " + (inputArray[j] + inputArray[k]
                                + inputArray[l]));
                    }
                });
            }

        };
        t.start();
    }
}
