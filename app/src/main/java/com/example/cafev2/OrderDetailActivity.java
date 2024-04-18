package com.example.cafev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_ADDITIVES = "additives";
    private static final String EXTRA_DRINK_TYPE = "drinkType";
    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewDrinkType;
    private TextView textViewAdditives;
    private String name;
    private String drink;
    private String drinkType;
    private String additives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initViews();
        setOrder();
    }
    private void setOrder(){
        name = getIntent().getStringExtra(EXTRA_USER_NAME);
        drink = getIntent().getStringExtra(EXTRA_DRINK);
        drinkType = getIntent().getStringExtra(EXTRA_DRINK_TYPE);
        additives = getIntent().getStringExtra(EXTRA_ADDITIVES);
        textViewName.setText(name);
        textViewDrink.setText(drink);
        textViewDrinkType.setText(drinkType);
        textViewAdditives.setText(additives);
    }
    public static Intent newIntent(Context context,
                                   String userName,
                                   String drink,
                                   String additives,
                                   String drinkType){
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);
        return intent;}
    private void initViews(){
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewAdditives = findViewById(R.id.textViewAdditives);
    }
}