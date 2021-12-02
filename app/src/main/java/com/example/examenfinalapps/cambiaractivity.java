package com.example.examenfinalapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class cambiaractivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }
    public void cambiarAct(View view) {
        setContentView(R.layout.activity2);
        startActivity(new Intent(cambiaractivity.this, cambiaractivity.class));
    }
}
