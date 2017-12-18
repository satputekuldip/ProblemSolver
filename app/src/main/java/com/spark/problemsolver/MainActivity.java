package com.spark.problemsolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}
