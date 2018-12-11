package com.mizi.eagle.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.mizi.lib.dialog.EagleDialog;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTradition;
    Button btnCustom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTradition = findViewById(R.id.btnTradition);
        btnCustom = findViewById(R.id.btnCustom);
        btnTradition.setOnClickListener(this);
        btnCustom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCustom) {
            startActivity(new Intent(this, CustomActivity.class));
        }

        if (v.getId() == R.id.btnTradition) {
            Intent intent = new Intent(this, TraditionActivity.class);
            startActivity(intent);
        }
    }
}
