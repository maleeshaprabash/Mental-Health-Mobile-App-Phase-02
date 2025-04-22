package com.example.evervital;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);

        View backk = findViewById(R.id.imageView11);
        backk.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity6.this, MainActivity4.class);
            startActivity(intent);
        });

        View imgmusic = findViewById(R.id.imageView12);
        imgmusic.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://open.spotify.com/playlist/4kOdiP5gbzocwxQ8s2UTOF");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        View imgvideo = findViewById(R.id.imageView13);
        imgvideo.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.youtube.com/results?search_query=mind+relax+video");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        View imggame = findViewById(R.id.imageView14);
        imggame.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://poki.com/en/online");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        ImageView homeicn = findViewById(R.id.imageView9);
        homeicn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity6.this, MainActivity4.class);
            startActivity(intent);
        });

        ImageView addlist = findViewById(R.id.imageView16);
        addlist.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity6.this, MainActivity7.class);
            startActivity(intent);
        });

        ImageView pricn = findViewById(R.id.imageView21);
        pricn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity6.this, MainActivity8.class);
            startActivity(intent);
        });
    }
}