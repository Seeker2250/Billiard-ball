package com.example.billiardball;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Billiard 객체 만들어
        Billiard billiard = new Billiard(this);
        //billiard로 화면 구성할거야
        setContentView(billiard);

        //Action bar 없애
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}