package com.example.cafev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeOrderActivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "userName";
    private TextView textViewGreetings;
    private RadioGroup radioGroupDrinks;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;
    private TextView textViewAdditives;

    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;

    private Spinner spinnerTea;
    private Spinner spinnerCoffee;
    private Button buttonMakeOrder;
    private String drink;
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();
        setupUserName();
        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == radioButtonTea.getId()){
                    onUserChooseTea();
                }
                else if (id == radioButtonCoffee.getId()){
                    onUserChooseCoffee();
                }
            }
        });
        radioButtonTea.setChecked(true);
        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserMadeOrder();
            }
        });
        }


    private void onUserMadeOrder(){
        ArrayList<String> additives = new ArrayList<>();
        if (checkBoxSugar.isChecked()){
            additives.add(checkBoxSugar.getText().toString());
        }
        if (checkBoxMilk.isChecked()){
            additives.add(checkBoxMilk.getText().toString());
        }
        if (radioButtonTea.isChecked() && checkBoxLemon.isChecked()){
            additives.add(checkBoxLemon.getText().toString());
        }

        String drinkType = "";
        if (radioButtonTea.isChecked()){
            drinkType = spinnerTea.getSelectedItem().toString();
        }
        else if (radioButtonCoffee.isChecked()){
            drinkType = spinnerCoffee.getSelectedItem().toString();
        }
        Intent intent = OrderDetailActivity.newIntent(
                this,
                userName,
                drink,
                additives.toString(),
                drinkType);
        startActivity(intent);
    }

    private void setupUserName(){
        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greetings, userName);
        textViewGreetings.setText(greetings);
    }

    private void onUserChooseTea(){
        drink = getString(R.string.tea);
        String additivesLabel = getString(R.string.additives, drink);
        textViewAdditives.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
    }
    private void onUserChooseCoffee(){
        drink = getString(R.string.coffee);
        String additivesLabel = getString(R.string.additives, drink);
        textViewAdditives.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
    }
    private void initViews(){
        textViewGreetings = findViewById(R.id.textViewGreetings);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);
    }
    public static Intent newIntent(Context context, String userName){
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return intent;}
}