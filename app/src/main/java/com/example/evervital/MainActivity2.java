package com.example.evervital;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText textEmailAddress;
    private EditText textPassword;
    Button button;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main2);

        textEmailAddress = findViewById(R.id.editTextTextEmailAddress3);
        textPassword = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });

        TextView create_new_account = findViewById(R.id.textView);
        create_new_account.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });


        imageView = findViewById(R.id.imageView28);
        imageView.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmail.google.com%2Fmail&ec=GAlAFw&hl=en-GB&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-820353776%3A1739011542649368&ddm=1");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        imageView = findViewById(R.id.imageView29);
        imageView.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://web.facebook.com/?_rdc=1&_rdr");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
    private void LoginUser() {
        String email = textEmailAddress.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if (email.isEmpty()){
            textEmailAddress.setError("Email cannot be empty");
        }
        if (password.isEmpty()) {
            textPassword.setError("Password cannot be empty");
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity2.this, "Login Success",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity2.this, "Login failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /*@Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(intent);
        }
    }*/
}
