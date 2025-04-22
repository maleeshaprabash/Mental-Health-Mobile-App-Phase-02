package com.example.evervital;


import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity3 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextText2;
    private EditText editTextText3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main3);

        editTextText2 = findViewById(R.id.editTextTextEmailAddress);
        editTextText3 = findViewById(R.id.editTextTextPassword3);
        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        TextView way_to_login = findViewById(R.id.textView5);
        way_to_login.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            startActivity(intent);
        });
    }

    private void registerUser() {

        String email = editTextText2.getText().toString().trim();
        String password = editTextText3.getText().toString().trim();

        if (email.isEmpty()){
            editTextText2.setError("Email cannot be empty");
        }
        if (password.isEmpty()) {
            editTextText3.setError("Password cannot be empty");
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity3.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity3.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /*@Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            startActivity(intent);
        }
    }*/
}
