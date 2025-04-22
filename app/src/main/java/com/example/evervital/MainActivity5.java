package com.example.evervital;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    Button button;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        View back = findViewById(R.id.imageView3);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
            startActivity(intent);
        });

        button = findViewById(R.id.button6);
        button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://today.marquette.edu/2024/08/the-importance-of-self-care-for-maintaining-mental-health/?");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        button = findViewById(R.id.button7);
        button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.ourmental.health/self-care/15-simple-habits-to-boost-your-mental-health?utm");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        button = findViewById(R.id.button8);
        button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.helpguide.org/mental-health/wellbeing/building-better-mental-health?utm");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        ImageView hoicn = findViewById(R.id.imageView15);
        hoicn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
            startActivity(intent);
        });

        ImageView addlicn = findViewById(R.id.imageView18);
        addlicn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity7.class);
            startActivity(intent);
        });

        ImageView picn = findViewById(R.id.imageView20);
        picn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity8.class);
            startActivity(intent);
        });

    }
}