package com.example.evervital;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ImageView imgrec = findViewById(R.id.imageView41);
        imgrec.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
            startActivity(intent);
        });

        ImageView imgrecc = findViewById(R.id.imageView43);
        imgrecc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity6.class);
            startActivity(intent);
        });

        ImageView hicn = findViewById(R.id.imageView10);
        hicn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity4.class);
            startActivity(intent);
        });

        ImageView add = findViewById(R.id.imageView17);
        add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
            startActivity(intent);
        });

        ImageView profile = findViewById(R.id.imageView26);
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity8.class);
            startActivity(intent);
        });
    }
}