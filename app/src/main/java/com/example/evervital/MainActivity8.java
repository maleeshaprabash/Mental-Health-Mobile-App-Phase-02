package com.example.evervital;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main8);

        View back3 = findViewById(R.id.imageView30);
        back3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity4.class);
            startActivity(intent);
        });

        ImageView add_details = findViewById(R.id.imageView37);
        add_details.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity9.class);
            startActivity(intent);
        });

        View hme = findViewById(R.id.imageView31);
        hme.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity4.class);
            startActivity(intent);
        });

        View adlist = findViewById(R.id.imageView32);
        adlist.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity7.class);
            startActivity(intent);
        });

        View profilei = findViewById(R.id.imageView33);
        profilei.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity8.class);
            startActivity(intent);
        });

        View log_out = findViewById(R.id.textView41);
        log_out.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}