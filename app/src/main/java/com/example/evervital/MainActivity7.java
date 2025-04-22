package com.example.evervital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class MainActivity7 extends AppCompatActivity {

    private EditText dateEditText, statusEditText, descriptionEditText;
    Button saveButton, clearButton;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        dateEditText = findViewById(R.id.editTextDate);
        statusEditText = findViewById(R.id.editTextText);
        descriptionEditText = findViewById(R.id.editTextTextMultiLine);
        saveButton = findViewById(R.id.button9);
        clearButton = findViewById(R.id.button4);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveIntoFirebase();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        ImageView backicn = findViewById(R.id.imageView22);
        backicn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this, MainActivity4.class);
            startActivity(intent);
        });

        ImageView homee = findViewById(R.id.imageView23);
        homee.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this, MainActivity4.class);
            startActivity(intent);
        });

        ImageView addto = findViewById(R.id.imageView24);
        addto.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this, MainActivity7.class);
            startActivity(intent);
        });

        ImageView profileimg = findViewById(R.id.imageView19);
        profileimg.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this, MainActivity8.class);
            startActivity(intent);
        });

        TextView my_feelings = findViewById(R.id.textView43);
        my_feelings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this, MainActivity10.class);
            startActivity(intent);
        });

    }

    private void saveIntoFirebase(){
        String date = dateEditText.getText().toString().trim();
        String status = statusEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        if (date.isEmpty()){
            dateEditText.setError("Date Is Required");
            dateEditText.requestFocus();
            return;
        }

        if (status.isEmpty()){
            statusEditText.setError("Feeling Status Is Required");
            statusEditText.requestFocus();
            return;
        }

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            feelings feeling = new feelings(date, status, description, userId);

            String feelingId = mDatabase.child("feelings").push().getKey();

            if (feelingId != null) {
                mDatabase.child("feelings").child(feelingId).setValue(feeling)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity7.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                clearFields();
                            } else {
                                Toast.makeText(MainActivity7.this, "Saved Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }
    }

    private void clearFields() {
        dateEditText.setText(" ");
        statusEditText.setText(" ");
        descriptionEditText.setText(" ");
    }
}