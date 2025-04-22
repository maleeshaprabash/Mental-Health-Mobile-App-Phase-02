package com.example.evervital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity9 extends AppCompatActivity {

    private EditText name, email, telephone,country;
    Button saveButton;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main9);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        name = findViewById(R.id.editTextText2);
        email = findViewById(R.id.editTextText3);
        telephone = findViewById(R.id.editTextPhone);
        country = findViewById(R.id.editTextText4);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetailInFirebase();
            }
        });

        View backic = findViewById(R.id.imageView25);
        backic.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity9.this, MainActivity8.class);
            startActivity(intent);
        });

        View hm = findViewById(R.id.imageView34);
        hm.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity9.this, MainActivity4.class);
            startActivity(intent);
        });

        View al = findViewById(R.id.imageView35);
        al.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity9.this, MainActivity7.class);
            startActivity(intent);
        });

        View pr = findViewById(R.id.imageView36);
        pr.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity9.this, MainActivity8.class);
            startActivity(intent);
        });
    }

    private void saveDetailInFirebase(){
        String Name = name.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Telephone = telephone.getText().toString().trim();
        String Country = country.getText().toString().trim();

        if (Name.isEmpty() || Email.isEmpty() || Telephone.isEmpty() || Country.isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            details detail = new details(Name, Email, Telephone, Country);

            String feelingId = mDatabase.child("details").push().getKey();

            if (feelingId != null) {
                mDatabase.child("details").child(feelingId).setValue(detail)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity9.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity9.this, "Saved Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }
    }
}